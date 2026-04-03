package com.solvd.developmentcompany.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyConnection {

    private final int id;
    private static final Logger LOGGER = LoggerFactory.getLogger(MyConnection.class);
    public MyConnection(int id) {
        this.id = id; }

    public void query(String sql) {
        LOGGER.info("  MyConnection #" + id + " executing: " + sql);}

    @Override
    public String toString() {
        return "MyConnection #" + id;}
}
