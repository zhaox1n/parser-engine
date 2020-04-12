package org.github.zhaox1n.parser.ddl;

import org.github.zhaox1n.parser.ParserDefault;
import org.junit.Test;

public class CreateTableTest extends ParserDefault {


    @Test
    public void createDatabaseTest() {
        String[] sqls = {
                "CREATE TABLE foo (a TINYINT UNSIGNED);",
                "CREATE TABLE t( c1 TIME(2), c2 DATETIME(2), c3 TIMESTAMP(2) );",
                "create table t (`row` int)",
                "create table `123` (123a1 int)",
//                "create table t (c int, index ci (c) USING BTREE COMMENT \"123\")"

        };

        for (String sql : sqls) {
            run(sql);
        }
    }
}
