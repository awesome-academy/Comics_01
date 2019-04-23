package com.sun_asterisk.comics_01.data.source;

import com.sun_asterisk.comics_01.data.model.Comic;
import com.sun_asterisk.comics_01.data.source.remote.OnFetchDataJsonListener;

public interface ComicDataSource {

    interface LocalDataSource {}

    interface RemoteDataSource {
        void getComics(OnFetchDataJsonListener<Comic> listener);
        void getComicByName(OnFetchDataJsonListener<Comic> listener, String comicName);
        void getComicByCategory(int idCategory, OnFetchDataJsonListener<Comic> listener);
    }
}
