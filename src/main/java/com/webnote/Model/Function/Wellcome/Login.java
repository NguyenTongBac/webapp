package com.webnote.Model.Function.Wellcome;

import com.webnote.Model.Database.Customer;
import com.webnote.Model.Database.Note;
import com.webnote.Interface.Wellcome.LoginUserDao;
import com.webnote.Model.Service.DoUser;
import com.webnote.Model.Util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Login implements LoginUserDao {
    private String message = "";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private Customer customer = new Customer();

    public Customer getCustomer() {
        return customer;
    }

    public Note note = new Note();


    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public boolean login(String username, String password) {

        if (!username.endsWith("@gmail.com")) {
            setMessage("username's not right, please re-enter");
            return false;
        }
        if (password == null) {
            setMessage("please enter password");
            return false;
        }
        else {
            DoUser doUser = new DoUser();
            Customer customerCheck = doUser.checkLoginCustomer(username, password);

            if(customerCheck != null){
                customer = customerCheck;
                return true;
            }
        }
        setMessage("login failed");
        return false;
    }

    public List<Note> getSearchAllNotes(String search, String username) {
        String sql = "select * from note where titleNote like ? and account =?";
        if(search == null){
            sql = "select * from note where account =?";
        }
        List<Note> listSearch = new ArrayList<>();
        try {
            conn = Util.getConn();

            ps = conn.prepareStatement(sql);
            ps.setString(1, '%'+search+'%');
            ps.setString(2, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                listSearch.add(new Note(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listSearch;
    }


}
