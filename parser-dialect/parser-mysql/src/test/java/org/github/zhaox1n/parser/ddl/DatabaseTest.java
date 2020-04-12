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
                "create database 123test",
                "create database `123`",
                "create database `12``3`",
                "CREATE DATABASE test",
                "create database if not exists xxx",
                "/** 20180417 **/ create database if not exists xxx",
        };
        for (String sql : sqls) {
            run(sql);
        }
    }
}
