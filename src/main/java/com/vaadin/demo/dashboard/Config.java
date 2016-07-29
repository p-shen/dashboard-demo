package com.vaadin.demo.dashboard;

/**
 * Created by Peter on 2016-07-28.
 */
public class Config {

    public static final boolean DEBUG = true;

    public static final int DB_VERSION = 1;

    private static final String HIBERNATE_CONFIG_PATH =
            "/Users/Peter/VaadinDemo/dashboard-demo/src/main/java/hibernate.cfg.xml";

    public static String getHibernateConfigPath() {
        if (DEBUG)
            return HIBERNATE_CONFIG_PATH;
        else return "";
    }
}
