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

package org.github.zhaox1n.parser.mysql.visitor.impl;

import org.github.zhaox1n.parser.api.ASTNode;
import org.github.zhaox1n.parser.api.visitor.statement.TCLVisitor;
import org.github.zhaox1n.parser.autogen.MySQLStatementParser.*;
import org.github.zhaox1n.parser.mysql.visitor.MySQLVisitor;
import org.github.zhaox1n.parser.segment.tcl.AutoCommitSegment;
import org.github.zhaox1n.parser.statement.tcl.*;

/**
 * TCL visitor for MySQL.
 */
public final class MySQLTCLVisitor extends MySQLVisitor implements TCLVisitor {
    
    @Override
    public ASTNode visitSetTransaction(final SetTransactionContext ctx) {
        return new SetTransactionStatement();
    }
    
    @Override
    public ASTNode visitSetAutoCommit(final SetAutoCommitContext ctx) {
        SetAutoCommitStatement result = new SetAutoCommitStatement();
        result.setAutoCommit(((AutoCommitSegment) visit(ctx.autoCommitValue())).isAutoCommit());
        return result;
    }
    
    @Override
    public ASTNode visitAutoCommitValue(final AutoCommitValueContext ctx) {
        boolean autoCommit = "1".equals(ctx.getText()) || "ON".equals(ctx.getText());
        return new AutoCommitSegment(ctx.getStart().getStartIndex(), ctx.getStop().getStopIndex(), autoCommit);
    }
    
    @Override
    public ASTNode visitBeginTransaction(final BeginTransactionContext ctx) {
        return new BeginTransactionStatement();
    }
    
    @Override
    public ASTNode visitCommit(final CommitContext ctx) {
        return new CommitStatement();
    }
    
    @Override
    public ASTNode visitRollback(final RollbackContext ctx) {
        return new RollbackStatement();
    }
    
    @Override
    public ASTNode visitSavepoint(final SavepointContext ctx) {
        return new SavepointStatement();
    }
}
