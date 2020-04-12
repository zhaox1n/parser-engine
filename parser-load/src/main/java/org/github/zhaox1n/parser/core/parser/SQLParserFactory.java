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

package org.github.zhaox1n.parser.core.parser;

import org.github.zhaox1n.parser.api.parser.SQLParser;
import org.github.zhaox1n.parser.spi.SQLParserConfiguration;
import org.github.zhaox1n.parser.spi.ShardingSphereServiceLoader;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.antlr.v4.runtime.*;

/**
 * SQL parser factory.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SQLParserFactory {
    
    static {
        ShardingSphereServiceLoader.register(SQLParserConfiguration.class);
    }
    
    /** 
     * New instance of SQL parser.
     * 
     * @param databaseTypeName name of database type
     * @param sql SQL
     * @return SQL parser
     */
    public static SQLParser newInstance(final String databaseTypeName, final String sql) {
        for (SQLParserConfiguration each : ShardingSphereServiceLoader.newServiceInstances(SQLParserConfiguration.class)) {
            if (each.getDatabaseTypeName().equals(databaseTypeName)) {
                return createSQLParser(sql, each);
            }
        }
        throw new UnsupportedOperationException(String.format("Cannot support database type '%s'", databaseTypeName));
    }
    
    @SneakyThrows
    private static SQLParser createSQLParser(final String sql, final SQLParserConfiguration configuration) {
        Lexer lexer = (Lexer) configuration.getLexerClass().getConstructor(CharStream.class).newInstance(CharStreams.fromString(sql));
        return configuration.getParserClass().getConstructor(TokenStream.class).newInstance(new CommonTokenStream(lexer));
    }
}
