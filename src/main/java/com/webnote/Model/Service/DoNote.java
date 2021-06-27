package com.webnote.Model.Service;

import com.webnote.Model.Database.Customer;
import com.webnote.Model.Database.Note;
import com.webnote.Model.Util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoNote {

    DoUser doUser = new DoUser();
    Customer customer = new Customer();
    Note note = new Note();

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Note> getAllNotes(String username) {
        List<Note> list = new ArrayList<>();
        try {
            conn = Util.getConn();
            String sql = "select * from note where account = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Note(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public  void updateNote(String id, String tileNote, String note){
        String sql = "UPDATE note SET titleNote =?, note =? WHERE Note_id =?";
        try {
            conn = new Util().getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, tileNote);
            ps.setString(2, note);
            ps.setString(3, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteNote(String id) {
        String sql = "DELETE FROM `note` WHERE Note_id = ?";
        try {
            conn = new Util().getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertNote(String username, String titleNote, String note){
        String sql = "INSERT INTO `note`(`account`, `titleNote`, `note`) VALUES (?,?,?)";
        try {
            conn = new Util().getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, titleNote);
            ps.setString(3, note);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Note> getListNotes(String username, String search){
        String sql = "SELECT * FROM `note` WHERE account = ? and titleNote like ?";

        List<Note> list = new ArrayList<>();
        try {
            String searchTitle = '%' + search + '%';
            conn = Util.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, searchTitle);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Note(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Note getNote(String id){
        String sql = "SELECT * FROM note WHERE Note_id =?";
        try {
            conn = Util.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                note = new Note(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
            }
            if(note.getUsername() == null){
                return null;
            }
            return note;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
