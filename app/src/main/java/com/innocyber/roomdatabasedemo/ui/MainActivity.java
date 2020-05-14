package com.innocyber.roomdatabasedemo.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.innocyber.roomdatabasedemo.data.Note;
import com.innocyber.roomdatabasedemo.viewmodel.NoteViewModel;
import com.innocyber.roomdatabasedemo.R;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private NoteViewModel noteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InsertDataActivity.class);
                startActivityForResult(intent,1);
            }
        });

        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        final String note_id = UUID.randomUUID().toString();
        Note note = new Note(note_id,data.getStringExtra(InsertDataActivity.NEW_NOTE));
        noteViewModel.insert(note);

        if (requestCode == 1 && resultCode == RESULT_OK){
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Not Saved", Toast.LENGTH_SHORT).show();
        }
    }
}
