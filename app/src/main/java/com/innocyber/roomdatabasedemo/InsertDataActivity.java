package com.innocyber.roomdatabasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InsertDataActivity extends AppCompatActivity {

    public static final String NEW_NOTE = "inserted_note";
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);

        editText = findViewById(R.id.edit_text);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent resultIntent = new Intent();
                if (TextUtils.isEmpty(editText.getText())){
                    setResult(RESULT_CANCELED,resultIntent);
                }else {
                    String note = editText.getText().toString();
                    resultIntent.putExtra(NEW_NOTE,note);
                    setResult(RESULT_OK,resultIntent);
                }

                finish();
            }
        });
    }
}
