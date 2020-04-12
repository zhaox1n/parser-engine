package org.github.zhaox1n.parser.ddl;

import org.github.zhaox1n.parser.ParserDefault;
import org.junit.Test;

/**
 * Database test
 */
public class DatabaseTest extends ParserDefault {

    @Test
    public void createDatabaseTest() {
        String[] sqls = {
                //"create database 123test",
                //"create database `123`",
                //"create database `12``3`",
                /*"CREATE DATABASE test",
                "create database if exists xxx",
                "create database if not exists xxx",
                "create database xxx encryption = 'N'",
                "create database xxx encryption 'N'",
                "create database xxx default encryption = 'N'",
                "create database xxx encryption 'Y'",
                "create database xxx default encryption = 'Y'"*/
        };
        for (String sql : sqls) {
            run(sql);
        }
    }
}
