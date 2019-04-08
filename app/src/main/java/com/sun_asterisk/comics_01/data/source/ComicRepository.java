package com.sun_asterisk.comics_01.data.source;

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
}
