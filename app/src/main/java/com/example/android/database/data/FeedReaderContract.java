package com.example.android.database.data;

import android.provider.BaseColumns;

/**
 * Created by WanChing on 20/6/2017.
 */

public final class FeedReaderContract {

    public FeedReaderContract(){}

    public static abstract class FeedEntry implements BaseColumns{
        public static final String TABLE_NAME = "Entry";
        public static final String COLUMN_NAME_ENTRY_ID = "Entry ID";
        public static final String COLUMN_NAME_TITLE = "Title";
        public static final String COLUMN_NAME_SUBTITLE = "Subtitle";
    }
}
