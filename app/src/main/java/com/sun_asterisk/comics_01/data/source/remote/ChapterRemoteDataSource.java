package com.sun_asterisk.comics_01.data.source.remote;

import com.sun_asterisk.comics_01.data.model.Chapter;
import com.sun_asterisk.comics_01.data.source.ChapterDataSource;
import com.sun_asterisk.comics_01.data.source.remote.fetchjson.GetChapterJson;

public class ChapterRemoteDataSource implements ChapterDataSource.RemoteDataSource {

    private static ChapterRemoteDataSource sInstance;

    private ChapterRemoteDataSource() {
    }

    public static ChapterRemoteDataSource getInstance() {
        if (sInstance == null) return sInstance = new ChapterRemoteDataSource();
        return sInstance;
    }

    @Override
    public void getChapters(int idComic, OnFetchDataJsonListener<Chapter> listener) {
        GetChapterJson getChapterJson = new GetChapterJson(idComic, listener);
        getChapterJson.getChapter();
    }
}
