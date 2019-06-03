/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifcp.qms.dao.Intr;

import java.sql.*;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class DAOManagerByJNDI { //singletone for ds
    
    private static DataSource datasource;  //ds is in charge of the mgmnt of physical conn to DB
    //each ds is as a connection pool. the parameters of pool is configured in config file of Appserver.

    static
    {
        try {
            InitialContext ctx = new InitialContext();
            datasource = (DataSource) ctx.lookup("jdbc/qms");

        } catch (Exception e) {
        }
    }

    public Connection getConnection() {
        try {

                   return  datasource.getConnection(); //returns a conn from the pool that is congigured in Tomcat
               

        } catch (Exception e) {
        }

        return null;
    }

    public void close(Connection connection) {

        try
        {
            if (connection != null && !connection.isClosed()) {
                connection.close();  //the conn will be back to pool in sleep state
                connection = null; //make object unreachable and ready to be GC
               
            }
        } catch (Exception e) {
        }

    }

}
