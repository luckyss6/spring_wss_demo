package com.example.demo.listener;

import oracle.jdbc.dcn.DatabaseChangeEvent;
import oracle.jdbc.dcn.DatabaseChangeListener;

public class OracleDatabaseChangeListener implements DatabaseChangeListener {


    @Override
    public void onDatabaseChangeNotification(DatabaseChangeEvent arg0) {
        System.out.println("halo");
        System.out.println(arg0.getDatabaseName());
        System.out.println(arg0.getEventType().name());
        System.out.println(arg0.getConnectionInformation());
    }

}
