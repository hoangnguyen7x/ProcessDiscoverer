/*
 *  Copyright (C) 2018 Raffaele Conforti (www.raffaeleconforti.com)
 *
 *  This project is dual licensed under GNU Affero General Public License and Raffaele Conforti License.
 *  You can choose between one of them if you use this work
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Affero General Public License for more details.
 *
 *  You should have received a copy of the GNU Affero General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a
 *  copy of this software and associated documentation files (the "Software"),
 *  to deal in the Software without restriction, including without limitation
 *  the rights to use, copy, modify, merge, publish, distribute, sublicense,
 *  and/or sell copies of the Software, and to permit persons to whom the
 *  Software is furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included
 *  in all copies or substantial portions of the Software.
 *
 *  When this software (or parts of it) is being used in a website or
 *  application, the message "Process Discover - raffaeleconforti.com"
 *  must stay fully visible to the user and not visually overlapped by other elements.
 *  The message must be showed using a 12 point font size minimum and must
 *  appear on the screen for the entire duration of the usage and a minimum of 30
 *  seconds.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 *  OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 *
 */

package com.raffaeleconforti.processdiscoverer.impl.miners;

import com.raffaeleconforti.splitminer.log.SimpleLog;
import com.raffaeleconforti.splitminer.log.graph.LogNode;
import com.raffaeleconforti.splitminer.splitminer.dfgp.DFGEdge;
import com.raffaeleconforti.splitminer.splitminer.dfgp.DirectlyFollowGraphPlus;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;

import java.util.*;

/**
 * Created by Raffaele Conforti (conforti.raffaele@gmail.com) on 05/08/2018.
 */
public class DFGPWithLogThreshold extends DirectlyFollowGraphPlus {

    private double filterThreshold;
    private boolean preserve_connectivity = true;
    private boolean parallelism = true;
    private boolean inverted = false;
    private double min;
    private double max;

    public DFGPWithLogThreshold(SimpleLog log, double percentileFrequencyThreshold, double parallelismsThreshold, boolean parallelismsFirst) {
        super(log, percentileFrequencyThreshold, parallelismsThreshold, parallelismsFirst);
    }

    public DFGPWithLogThreshold(SimpleLog log, double percentileFrequencyThreshold, double parallelismsThreshold, boolean parallelismsFirst, boolean preserve_connectivity, boolean inverted) {
        super(log, percentileFrequencyThreshold, parallelismsThreshold, parallelismsFirst);
        this.preserve_connectivity = preserve_connectivity;
        this.parallelism = parallelismsFirst;
        this.inverted = inverted;
    }

    public void buildDFGP() {
        loopsL1 = new HashSet<>();
        loopsL2 = new HashSet<>();
        buildDirectlyFollowsGraph();
        if(parallelism) {
            filterWithThreshold();
            detectLoops();
            detectParallelisms();
        }else {
            filterWithThreshold();
            detectLoops();
            detectParallelisms();
        }
    }

    private void filterWithThreshold() {
        ArrayList<DFGEdge> retained_arcs = new ArrayList<>(edges);
        retained_arcs.sort(new Comparator<DFGEdge>() {
            @Override
            public int compare(DFGEdge o1, DFGEdge o2) {
                if(inverted) return Integer.compare(o1.getFrequency(), o2.getFrequency());
                return Integer.compare(o2.getFrequency(), o1.getFrequency());
            }
        });
        computeFilterThreshold(retained_arcs);

        for(int i = retained_arcs.size() - 1; i >= 0; i--) {
            DFGEdge e = retained_arcs.get(i);
            double current = scale(e.getFrequency() + 1);
            if(current < filterThreshold) {
                if(retained_arcs.contains(e)) {
                    retained_arcs.remove(e);
                    if (preserve_connectivity && (!reachable(e.getTarget(), retained_arcs) || !reaching(e.getSource(), retained_arcs))) {
                        retained_arcs.add(e);
                    }
                }
            }else {
                break;
            }
        }

        for( DFGEdge e : new HashSet<>(edges) ) {
            if(!retained_arcs.contains(e)) {
                removeEdge(e, false);
            }
        }
    }

    private void computeFilterThreshold(ArrayList<DFGEdge> retained_arcs) {
        min = (retained_arcs.get(retained_arcs.size() - 1).getFrequency() + 1);
        max = (retained_arcs.get(0).getFrequency() + 1);
        double tmp = min;
        min = Math.min(min, max);
        max = Math.max(tmp, max);
        filterThreshold = getLog((1 + max) - min) * percentileFrequencyThreshold;
    }

    private boolean reachable(LogNode node, ArrayList<DFGEdge> retained_arcs) {
        LogNode source = nodes.get(startcode);
        if(node.getCode() == source.getCode()) return true;

        IntHashSet visited = new IntHashSet();
        IntArrayList reached = new IntArrayList();
        reached.add(source.getCode());

        while (reached.size() > 0) {
            int current = reached.removeAtIndex(0);
            for (DFGEdge arc : retained_arcs) {
                if(arc.getSource().getCode() == current) {
                    if(arc.getTarget().getCode() == node.getCode()) {
                        return true;
                    }else if(!visited.contains(arc.getTarget().getCode())) {
                        visited.add(arc.getTarget().getCode());
                        reached.add(arc.getTarget().getCode());
                    }
                }
            }
        }

        return false;
    }

    private boolean reaching(LogNode node, ArrayList<DFGEdge> retained_arcs) {
        LogNode target = nodes.get(endcode);
        if(node.getCode() == target.getCode()) return true;

        IntHashSet visited = new IntHashSet();
        IntArrayList reached = new IntArrayList();
        reached.add(target.getCode());

        while (reached.size() > 0) {
            int current = reached.removeAtIndex(0);
            for (DFGEdge arc : retained_arcs) {
                if(arc.getTarget().getCode() == current) {
                    if(arc.getSource().getCode() == node.getCode()) {
                        return true;
                    }else if(!visited.contains(arc.getSource().getCode())) {
                        visited.add(arc.getSource().getCode());
                        reached.add(arc.getSource().getCode());
                    }
                }
            }
        }

        return false;
    }

    private double scale(long value) {
        double v = (value - min) + 1;
        return (inverted) ? getLog((((1 + max) - min) - v) + 1) : getLog(v);
    }

    private double getLog(double value) {
        return (Math.log10(value) / Math.log10(2));
    }

}
