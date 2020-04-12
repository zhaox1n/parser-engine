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

package org.github.zhaox1n.parser.core.visitor;

import org.github.zhaox1n.parser.statement.SQLStatementType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Visitor rule.
 */
@RequiredArgsConstructor
public enum VisitorRule {

    DML_STATEMENT("DmlStatement", SQLStatementType.DML),
    DDL_STATEMENT("DdlStatement", SQLStatementType.DDL),
    TCL_STATEMENT("TclStatement", SQLStatementType.TCL),
    DCL_STATEMENT("DclStatement", SQLStatementType.DCL),
    DAL_STATEMENT("DalStatement", SQLStatementType.DAL),
    RL_STATEMENT("RlStatement", SQLStatementType.RL);

    private final String name;
    
    @Getter
    private final SQLStatementType type;
    
    private String getContextName() {
        return name + "Context";
    }
    
    /**
     * Value of visitor rule.
     * 
     * @param parseTreeClass parse tree class
     * @return visitor rule
     */
    public static VisitorRule valueOf(final Class<? extends ParseTree> parseTreeClass) {
        String parseTreeClassName = parseTreeClass.getSimpleName();
        for (VisitorRule each : VisitorRule.values()) {
            if (each.getContextName().equals(parseTreeClassName)) {
                return each;
            }
        }
        throw new IllegalArgumentException(String.format("Can not find visitor rule: `%s`", parseTreeClassName));
    }
}
