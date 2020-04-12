/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.github.zhaox1n.parser.segment.dml.item;

import org.github.zhaox1n.parser.constant.AggregationType;
import org.github.zhaox1n.parser.util.SQLUtil;
import lombok.Getter;

/**
 * Aggregation distinct projection segment.
 */
@Getter
public final class AggregationDistinctProjectionSegment extends AggregationProjectionSegment {
    
    private final String distinctExpression;
    
    public AggregationDistinctProjectionSegment(final int startIndex, final int stopIndex, final AggregationType type, final int innerExpressionStartIndex, final String distinctExpression) {
        super(startIndex, stopIndex, type, innerExpressionStartIndex);
        this.distinctExpression = SQLUtil.getExpressionWithoutOutsideParentheses(distinctExpression);
    }
}
