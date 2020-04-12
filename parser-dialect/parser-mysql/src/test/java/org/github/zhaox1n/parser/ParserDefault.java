package org.github.zhaox1n.parser;

import org.github.zhaox1n.parser.statement.SQLStatement;

public abstract class ParserDefault {

    private static final SQLParserEngine parser = SQLParserEngineFactory.getSQLParserEngine("MySQL");

    public SQLStatement run(String sql) {
        return parser.parse(sql, false);
    }
}
