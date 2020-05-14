package com.innocyber.roomdatabasedemo.viewmodel;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.innocyber.roomdatabasedemo.data.Note;
import com.innocyber.roomdatabasedemo.db.dao.NoteDao;
import com.innocyber.roomdatabasedemo.db.NoteRoomDatabase;

public class NoteViewModel extends AndroidViewModel {

    NoteDao noteDao;
    NoteRoomDatabase noteRoomDatabase;

    public NoteViewModel(@NonNull Application application) {
        super(application);

        noteRoomDatabase = NoteRoomDatabase.getDatabase(application);
        noteDao = noteRoomDatabase.noteDao();
    }

    public  void insert(Note note){
        new InsertNoteAsyncTask(noteDao).execute(note);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i("view model state", "onCleared: " + "View Model destroyed");
    }

    private class InsertNoteAsyncTask extends AsyncTask<Note,Void,Void>{

        NoteDao noteDao;

        public InsertNoteAsyncTask(NoteDao noteDao){
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {

            noteDao.insert(notes[0]);
            return null;
        }
    }
}
