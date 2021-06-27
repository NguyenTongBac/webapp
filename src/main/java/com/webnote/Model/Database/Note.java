package com.webnote.Model.Database;

public class Note {
    private int id;
    private String username;
    private String tileNote;
    private String note;

    public Note() {

    }

    public Note(int id, String username, String tileNote, String note) {
        this.id = id;
        this.username = username;
        this.tileNote = tileNote;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTileNote() {
        return tileNote;
    }

    public void setTileNote(String tileNote) {
        this.tileNote = tileNote;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", tileNote='" + tileNote + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
