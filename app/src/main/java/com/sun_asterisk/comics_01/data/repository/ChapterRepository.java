package com.sun_asterisk.comics_01.data.repository;

import com.sun_asterisk.comics_01.data.model.Chapter;
import com.sun_asterisk.comics_01.data.source.ChapterDataSource;
import com.sun_asterisk.comics_01.data.source.remote.OnFetchDataJsonListener;

public class ChapterRepository {
    private static ChapterRepository sInstance;
    private ChapterDataSource.RemoteDataSource mChapterRemoteDataSource;

    private ChapterRepository(ChapterDataSource.RemoteDataSource chapterRemoteDataSource) {
        mChapterRemoteDataSource = chapterRemoteDataSource;
    }

    public static ChapterRepository getInstance(
            ChapterDataSource.RemoteDataSource chapterRemoteDataSource) {
        if (sInstance == null) return sInstance = new ChapterRepository(chapterRemoteDataSource);
        return sInstance;
    }

    public void getChapters(int idComic, OnFetchDataJsonListener<Chapter> listener) {
        mChapterRemoteDataSource.getChapters(idComic, listener);
    }
}
