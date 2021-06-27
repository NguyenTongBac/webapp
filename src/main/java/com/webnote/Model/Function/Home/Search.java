package com.webnote.Model.Function.Home;

import com.webnote.Interface.Home.SearchNoteDao;
import com.webnote.Model.Service.DoNote;

public class Search implements SearchNoteDao {
    @Override
    public boolean search(String username, String search) {
        DoNote doNote = new DoNote();
        try {
            doNote.getListNotes(username, search);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
