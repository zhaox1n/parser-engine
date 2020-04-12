package org.github.zhaox1n.parser;

public abstract class ParserDefault {

    private static final SQLParserEngine parser = SQLParserEngineFactory.getSQLParserEngine("MySQL");

    public void run(String sql) {
        parser.parse(sql, false);
    }
}
