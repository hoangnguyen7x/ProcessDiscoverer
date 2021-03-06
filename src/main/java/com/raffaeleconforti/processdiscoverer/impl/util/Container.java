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

package com.raffaeleconforti.processdiscoverer.impl.util;

import java.nio.charset.StandardCharsets;

/**
 * Created by Raffaele Conforti (conforti.raffaele@gmail.com) on 05/08/2018.
 */
public class Container {
    
    public static String[] var1 = {
                   				"BPMN Visualizer - raffaeleconforti.com",
                   				"Process Discoverer - raffaeleconforti.com",
                   				"Process Instances - raffaeleconforti.com",
                   				"Create Filter Criterion - raffaeleconforti.com",
                   				"Details - raffaeleconforti.com",
                   				"Filter Criteria - raffaeleconforti.com",
                   				"Fitness - raffaeleconforti.com",
                   				"License expired. Please renew your Process Discoverer license.",
                   				"License expired.",
                   				"Please, select exactly one log.",
                   				"Wrong Log Selection",
                   				"<startEvent",
                   				"<endEvent",
                   				"/>",
                   				"isInterrupting=\"false\"",
                   				"zul/bpmnVisualizer.zul",
                   				"zul/processDiscoverer.zul",
                   				"zul/details.zul",
                   				"zul/cases.zul",
                   				"zul/fitness.zul",
                   				"use_fixed",
                   				"use_dynamic",
                   				"preserve_connectivity",
                   				"gateways",
                   				"prioritize",
                   				"secondary",
                   				"inverted_nodes",
                   				"inverted_arcs",
                   				"slider1",
                   				"slider2",
                   				"slider3",
                   				"activityText",
                   				"arcText",
                   				"parallelismText",
                   				"caseNumber",
                   				"uniquecaseNumber",
                   				"activityNumber",
                   				"eventNumber",
                   				"meanDuration",
                   				"medianDuration",
                   				"maxDuration",
                   				"minDuration",
                   				"selectormenu",
                   				"frequency",
                   				"absolute_frequency",
                   				"case_frequency",
                   				"median_frequency",
                   				"mean_frequency",
                   				"mode_frequency",
                   				"max_frequency",
                   				"min_frequency",
                   				"duration",
                   				"total_duration",
                   				"median_duration",
                   				"mean_duration",
                   				"max_duration",
                   				"min_duration",
                   				"impact",
                   				"total_impact",
                   				"median_impact",
                   				"mean_impact",
                   				"max_impact",
                   				"min_impact",
                   				"details",
                   				"cases",
                   				"fitness",
                   				"filter",
                   				"animate",
                   				"exportFitted",
                   				"exportUnfitted",
                   				"export",
                   				"downloadPDF",
                   				"downloadPNG",
                   				"exportBPMN",
                   				"onClick",
                   				"onCheck",
                   				"onScroll",
                   				"onChange",
                   				"onChanging",
                   				"onExport",
                   				"onAnimate",
                   				"detailsList",
                   				"pos",
                   				"detail_frequency",
                   				"detail_ratio",
                   				"casesList",
                   				"variant_value",
                   				"case_length",
                   				"Fitness",
                   				"onNodeRemovedTrace",
                   				"onNodeRetainedTrace",
                   				"onNodeRemovedEvent",
                   				"onNodeRetainedEvent",
                   				"onEdgeRemoved",
                   				"direct:follow",
                   				"onEdgeRetained",
                   				"onLoaded",
                   				"onOpen",
                   				" - Cumulative Frequency",
                   				" - Case Frequency",
                   				" - Mean Frequency",
                   				" - Median Frequency",
                   				" - Mode Frequency",
                   				" - Max Frequency",
                   				" - Min Frequency",
                   				" - Cumulative Duration",
                   				" - Mean Duration",
                   				" - Median Duration",
                   				" - Max Duration",
                   				" - Min Duration",
                   				" - Cumulative Impact",
                   				" - Mean Impact",
                   				" - Median Impact",
                   				" - Max Impact",
                   				" - Min Impact",
                   				"downloadPDF('%s');",
                   				"downloadPNG('%s');",
                   				"lifecycle:transition",
                   				"complete",
                   				"start",
                   				"+complete",
                   				"+start",
                   				"time:timestamp",
                   				"##############0.##",
                   				"concept:name",
                   				"direct:follow",
                   				"eventually:follow",
                   				"lifecycle:transition",
                   				"org:group",
                   				"org:resource",
                   				"org:role",
                   				"time:duration",
                   				"time:timestamp",
                   				"Activity",
                   				"Direct Follow Relation",
                   				"Duration",
                   				"Eventually Follow Relation",
                   				"Lifecycle",
                   				"Group",
                   				"Resource",
                   				"Role",
                   				"Time-frame",
                   				"0",
                   				"9",
                   				"8",
                   				"7",
                   				"6",
                   				"5",
                   				"4",
                   				"3",
                   				"2",
                   				"1",
                   				" yrs",
                   				" mths",
                   				" wks",
                   				" d",
                   				" hrs",
                   				" mins",
                   				" secs",
                   				" millis",
                   				"instant",
                   				"concept:name"};

}
