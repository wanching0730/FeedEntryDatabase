package com.example.android.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.android.database.data.FeedReaderContract;
import com.example.android.database.data.FeedReaderDbHelper;

public class DisplayDbAmount extends AppCompatActivity {

    private TextView dbAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_db_amount);

        displayDatabaseInfo();


    }

    private void displayDatabaseInfo(){

        //to access our database, initiate subclass of SQLiteOpenHelper
        FeedReaderDbHelper helper = new FeedReaderDbHelper(this);

        //Create or open a database to read from it
        SQLiteDatabase db = helper.getReadableDatabase();

        // Perform this raw SQL query "SELECT * FROM pets"
        // to get a Cursor that contains all rows from the pets table.
        Cursor cursor = db.rawQuery("SELECT * FROM" + FeedReaderContract.FeedEntry.TABLE_NAME, null);

        try {
            dbAmount = (TextView) findViewById(R.id.db_amount);
            dbAmount.setText("Number of rows in feedEntry database table: " + cursor.getCount());
        }finally {

            // Always close the cursor when you're done reading from it. This releases all its
            // resources and makes it invalid.
            cursor.close();
        }

    }
}
