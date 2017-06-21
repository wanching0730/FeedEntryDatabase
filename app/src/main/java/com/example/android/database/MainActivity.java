package com.example.android.database;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import com.example.android.database.data.FeedReaderDbHelper;

public class MainActivity extends AppCompatActivity {

    private Button viewAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewAmount = (Button) findViewById(R.id.view_amount);
        viewAmount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DisplayDbAmount.class);
                startActivity(intent);

                SQLiteDatabase mydatabase = openOrCreateDatabase("FeedReader.db",MODE_PRIVATE,null);
               // mydatabase.execSQL("INSERT INTO Entry VALUES(1, 'wc', 'wc')");
                mydatabase.execSQL("INSERT INTO Entry VALUES(2, 'teoh', 'teoh')");




            }
        });


    }
}
