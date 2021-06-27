package com.webnote.Model.Service;

import com.webnote.Model.Database.Customer;
import com.webnote.Model.Util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoUser {
    Customer customer = new Customer();

    public Customer getCustomer() {
        return customer;
    }

    public DoUser() {
    }

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Customer checkLoginCustomer(String username, String password) {
        String sql = "SELECT * FROM `customer` WHERE account=? and password=?";
        try {
            conn = Util.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                customer = new Customer(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
            }
            if (customer.getUsername() == null) {
                return null;
            }
            return customer;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insertCustomer(String username, String password, String name, String password2) {
        try {
            conn = Util.getConn();
            String sql = "INSERT INTO `customer`(`account`, `password`, `name`, `password2`) VALUES (?, ?, ?, ?);";

            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, name);
            ps.setString(4, password2);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.release(conn, ps, rs);
        }
    }

    public Customer checkInsertCustomer(String username, String password, String name, String password2) {
        String sql = "SELECT * FROM `customer` WHERE account=? and password=? and name=? and password2=?";
        try {
            conn = Util.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, name);
            ps.setString(4, password2);
            rs = ps.executeQuery();
            while (rs.next()) {
                customer = new Customer(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
            }
            if (customer.getUsername() == null) {
                return null;
            }
            return customer;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Customer checkUpdateCustomer(String username, String password2){
        String sql = "SELECT * FROM `customer` WHERE account=? and password2=?";
        try {
            conn = Util.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password2);
            rs = ps.executeQuery();
            while (rs.next()) {
                customer = new Customer(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
            }
            if (customer.getUsername() == null) {
                return null;
            }
            return customer;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateCustomer(String username, String password, String password2) {
        String sql = "update customer set `password` = ? where `account` = ? and`password2` = ?";
        try {
            conn = Util.getConn();
            ps = conn.prepareStatement(sql);

            ps.setString(1, password);
            ps.setString(2, username);
            ps.setString(3, password2);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
