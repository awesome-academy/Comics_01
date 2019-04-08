package com.sun_asterisk.comics_01.data.source.remote;

import com.sun_asterisk.comics_01.data.model.Comic;
import com.sun_asterisk.comics_01.data.source.ComicDataSource;
import com.sun_asterisk.comics_01.data.source.remote.fetchjson.GetDataJson;

public class ComicRemoteDataSource implements ComicDataSource.RemoteDataSource {

    private static ComicRemoteDataSource sInstance;

    public static ComicRemoteDataSource getsInstance() {
        if (sInstance == null) {
            sInstance = new ComicRemoteDataSource();
        }
        return sInstance;
    }

    @Override
    public void getComics(OnFetchDataJsonListener<Comic> listener) {
        GetDataJson getDataJson = new GetDataJson(listener);
        getDataJson.getComics();
    }
}
