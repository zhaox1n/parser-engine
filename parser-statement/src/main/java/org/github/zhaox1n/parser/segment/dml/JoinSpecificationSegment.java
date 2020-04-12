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

package org.github.zhaox1n.parser.segment.dml;

import org.github.zhaox1n.parser.segment.SQLSegment;
import org.github.zhaox1n.parser.segment.dml.column.ColumnSegment;
import org.github.zhaox1n.parser.segment.dml.predicate.PredicateSegment;
import org.github.zhaox1n.parser.segment.generic.OwnerSegment;
import org.github.zhaox1n.parser.segment.generic.table.SimpleTableSegment;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.LinkedList;

@Setter
@Getter
public final class JoinSpecificationSegment implements SQLSegment {
    
    private int startIndex;
    
    private int stopIndex;
    
    private PredicateSegment predicateSegment;
    
    private Collection<ColumnSegment> usingColumns = new LinkedList<>();
    
    /**
     * get tables.
     * @return tables.
     */
    public Collection<SimpleTableSegment> getSimpleTableSegments() {
        Collection<SimpleTableSegment> tables = new LinkedList<>();
        if (null != predicateSegment) {
            if (null != predicateSegment.getColumn() && (predicateSegment.getColumn().getOwner().isPresent())) {
                OwnerSegment ownerSegment = predicateSegment.getColumn().getOwner().get();
                tables.add(new SimpleTableSegment(ownerSegment.getStartIndex(), ownerSegment.getStopIndex(), ownerSegment.getIdentifier()));
            }
            if (null != predicateSegment.getRightValue() && (predicateSegment.getRightValue() instanceof ColumnSegment) && ((ColumnSegment) predicateSegment.getRightValue()).getOwner().isPresent()) {
                OwnerSegment ownerSegment = ((ColumnSegment) predicateSegment.getRightValue()).getOwner().get();
                tables.add(new SimpleTableSegment(ownerSegment.getStartIndex(), ownerSegment.getStopIndex(), ownerSegment.getIdentifier()));
            }
        }
        return tables;
    }
}
