package com.webnote.Model.Function.Home;

import com.webnote.Interface.Home.CreateNoteDao;
import com.webnote.Model.Database.Note;
import com.webnote.Model.Service.DoNote;

public class Create implements CreateNoteDao {
    @Override
    public boolean create(String username, String titleNote, String note) {
        DoNote doNote = new DoNote();
        try {
            doNote.insertNote(username, titleNote, note);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
