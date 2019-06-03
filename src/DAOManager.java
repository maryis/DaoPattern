/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifcp.qms.dao.Intr;

import com.ifcp.qms.common.Constants;
import snaq.db.ConnectionPool;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOManager {
    //singletone for pool

    private static ConnectionPool pool;
    static String ConnURL;
    static String ConnUSER;
    static String ConnPASS;

    static {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            pool = new ConnectionPool("QMSPOOL",
                    Constants.connPoolSize, Constants.connMaxSize, Constants.connExpireTime,
                    Constants.connURL, Constants.connUSER, Constants.connPASS);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Connection getConnection() {

        Connection connection = null;
        try {
            connection = pool.getConnection();
        } catch (Exception ex) {
        }

        return connection;
    }

    public static void close(Connection connection) {
        try {
            connection.close();
            //no need to close conn of connection pool. it is recycled by the pool and ready to use again
        } catch (SQLException ex) {
            Logger.getLogger(DAOManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void finalize() throws Throwable {

        if (pool != null) {
            pool.release();
        }
        super.finalize();
    }
}
