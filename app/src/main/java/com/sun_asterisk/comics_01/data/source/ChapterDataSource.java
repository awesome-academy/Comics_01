package com.sun_asterisk.comics_01.data.source;

import com.sun_asterisk.comics_01.data.model.Chapter;
import com.sun_asterisk.comics_01.data.source.remote.OnFetchDataJsonListener;

public interface ChapterDataSource {
    interface RemoteDataSource {
        void getChapters(int idComic, OnFetchDataJsonListener<Chapter> listener);
    }
}
