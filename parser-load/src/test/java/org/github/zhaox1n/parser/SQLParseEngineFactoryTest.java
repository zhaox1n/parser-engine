package org.github.zhaox1n.parser;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author : zhaoxin183
 * @date : 2020-04-10 15:24
 */
public class SQLParseEngineFactoryTest {

    @Test
    public void assertGetSQLParseEngine() {
        assertThat(SQLParserEngineFactory.getSQLParserEngine("MySQL"), is(SQLParserEngineFactory.getSQLParserEngine("MySQL")));
    }
}
