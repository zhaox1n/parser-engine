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

package org.github.zhaox1n.parser.segment.generic.database;

import org.github.zhaox1n.parser.value.identifier.IdentifierValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Simple table segment.
 */
@RequiredArgsConstructor
@Getter
@ToString
public final class SimpleDatabaseSegment implements DatabaseSegment{
    
    private final DatabaseNameSegment databaseName;
    

    public SimpleDatabaseSegment(final int startIndex, final int stopIndex, final IdentifierValue identifierValue) {
        databaseName = new DatabaseNameSegment(startIndex, stopIndex, identifierValue);
    }
    
    @Override
    public int getStartIndex() {
        return databaseName.getStartIndex();
    }
    
    @Override
    public int getStopIndex() {
        return databaseName.getStopIndex();
    }
    
}
