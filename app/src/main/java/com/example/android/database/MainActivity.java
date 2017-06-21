package com.example.android.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;

import com.example.android.database.data.FeedReaderContract;
import com.example.android.database.data.FeedReaderDbHelper;

public class MainActivity extends AppCompatActivity {

    private Button viewAmount;
    private EditText entryId_field, title_field, subtitle_field;
    private int entryId;
    private String title, subtitle;
    private FeedReaderDbHelper helper;
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entryId_field = (EditText) findViewById(R.id.entry_id);
        title_field = (EditText) findViewById(R.id.title);
        subtitle_field = (EditText) findViewById(R.id.subtitle);

        Log.v("view", "view");

        viewAmount = (Button) findViewById(R.id.view_amount);
        viewAmount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addData(v);

                Intent intent = new Intent(MainActivity.this, DisplayDbAmount.class);
                startActivity(intent);
            }
        });


    }

    public void addData(View view){
        entryId = Integer.parseInt(entryId_field.getText().toString().trim());
        title = title_field.getText().toString().trim();
        subtitle = subtitle_field.getText().toString().trim();
        helper = new FeedReaderDbHelper(this);
        database = helper.getWritableDatabase();
        helper.insertData(entryId, title, subtitle, database);
        database.close();
    }
}
