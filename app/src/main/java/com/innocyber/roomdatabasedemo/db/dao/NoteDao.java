package com.innocyber.roomdatabasedemo.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.innocyber.roomdatabasedemo.data.Note;

@Dao
public interface NoteDao {

    @Insert
    void insert(Note note);
}
