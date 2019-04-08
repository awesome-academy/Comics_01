package com.sun_asterisk.comics_01.data.source.local;

import com.sun_asterisk.comics_01.data.source.ComicDataSource;

public class ComicLocalDataSource implements ComicDataSource.LocalDataSource {
    private static ComicLocalDataSource sInstance;

    public static ComicLocalDataSource getsInstance() {
        if (sInstance == null) {
            sInstance = new ComicLocalDataSource();
        }
        return sInstance;
    }
}
