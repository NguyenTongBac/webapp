package com.webnote.Model.Function.Home;

import com.webnote.Interface.Home.DeleteNoteDao;
import com.webnote.Model.Database.Note;
import com.webnote.Model.Service.DoNote;

public class Delete implements DeleteNoteDao {

    @Override
    public boolean deleteNote(String id) {
        DoNote doNote = new DoNote();
        try {
            doNote.deleteNote(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
