package com.sun_asterisk.comics_01.data.repository;

import com.sun_asterisk.comics_01.data.model.Comic;
import com.sun_asterisk.comics_01.data.source.ComicDataSource;
import com.sun_asterisk.comics_01.data.source.remote.OnFetchDataJsonListener;

public class ComicRepository {

    private static ComicRepository sInstance;
    private ComicDataSource.RemoteDataSource mRemoteDataSource;
    private ComicDataSource.LocalDataSource mLocalDataSource;

    private ComicRepository(ComicDataSource.RemoteDataSource remoteDataSource,
            ComicDataSource.LocalDataSource localDataSource) {
        mRemoteDataSource = remoteDataSource;
        mLocalDataSource = localDataSource;
    }

    public static ComicRepository getInstance(ComicDataSource.RemoteDataSource remoteDataSource,
            ComicDataSource.LocalDataSource localDataSource) {
        if (sInstance == null) {
            sInstance = new ComicRepository(remoteDataSource, localDataSource);
        }
        return sInstance;
    }

    public void getComics(OnFetchDataJsonListener<Comic> listener) {
        mRemoteDataSource.getComics(listener);
    }

    public void getComicByName(OnFetchDataJsonListener<Comic> listener, String comicName) {
        mRemoteDataSource.getComicByName(listener, comicName);
    }
}
