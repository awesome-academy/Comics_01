package com.sun_asterisk.comics_01.data.source.remote;

import com.sun_asterisk.comics_01.data.model.Comic;
import com.sun_asterisk.comics_01.data.source.ComicDataSource;
import com.sun_asterisk.comics_01.data.source.remote.fetchjson.GetDataJson;

public class ComicRemoteDatasource implements ComicDataSource.RemoteDataSource {

    private static ComicRemoteDatasource sInstance;

    public static ComicRemoteDatasource getsInstance() {
        if (sInstance == null) {
            sInstance = new ComicRemoteDatasource();
        }
        return sInstance;
    }

    @Override
    public void getComics(OnFetchDataJsonListener<Comic> listener) {
        GetDataJson getDataJson = new GetDataJson(listener);
        getDataJson.getComics();
    }
}
