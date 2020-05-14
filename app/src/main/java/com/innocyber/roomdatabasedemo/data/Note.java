package com.innocyber.roomdatabasedemo.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName =  "notes")
public class Note {

    @PrimaryKey
    @NonNull
    private  String id;

    @NonNull
    @ColumnInfo(name = "note")
    private  String note;

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    @NonNull
    public String getNote() {
        return note;
    }

    public void setNote(@NonNull String note) {
        this.note = note;
    }

    public Note(@NonNull String id, @NonNull String note) {
        this.id = id;
        this.note = note;
    }
}
