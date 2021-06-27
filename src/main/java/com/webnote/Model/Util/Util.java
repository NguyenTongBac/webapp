package com.webnote.Model.Util;

import java.sql.*;


public class Util {
    static String driverclass = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/webnote";
    static String name = "root";
    static String password = "";

    public static Connection getConn(){

        Connection conn = null;
        try {

            Class.forName(driverclass);

            conn = DriverManager.getConnection(url, name, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConn(Connection conn){
        try {
            if(conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn = null;
        }
    }

    public static void closePs(PreparedStatement ps){
        try {
            if(ps !=null){
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ps=null;
        }
    }
    public static void closeRs(ResultSet rs){
        try {
            if(rs !=null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            rs=null;
        }
    }

    public static void release(Connection conn, PreparedStatement ps){
        closeConn(conn);
        closePs(ps);
    }
    public static void release(Connection conn, PreparedStatement ps, ResultSet rs){
        closePs(ps);
        closeConn(conn);
        closeRs(rs);
    }
}

