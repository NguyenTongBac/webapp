package com.webnote.Model.Function.Home;

import com.webnote.Interface.Home.EditNoteDao;
import com.webnote.Model.Service.DoNote;

public class Edit implements EditNoteDao {

    @Override
    public boolean Edit(String id, String titleNote, String note) {
        DoNote doNote = new DoNote();
        try {
            doNote.updateNote(id, titleNote, note);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
