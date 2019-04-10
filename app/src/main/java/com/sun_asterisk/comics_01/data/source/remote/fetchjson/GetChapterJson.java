package com.sun_asterisk.comics_01.data.source.remote.fetchjson;

import com.sun_asterisk.comics_01.data.model.Chapter;
import com.sun_asterisk.comics_01.data.source.remote.OnFetchDataJsonListener;
import com.sun_asterisk.comics_01.utils.Constant;

public class GetChapterJson {
    private OnFetchDataJsonListener<Chapter> mListener;
    private int mIdComic;

    public GetChapterJson(int idComic, OnFetchDataJsonListener<Chapter> listener) {
        mListener = listener;
        mIdComic = idComic;
    }

    public void getChapter() {
        String url = Constant.BASE_URL + Constant.CHAPTERS + mIdComic;
        new GetChapterAsyncTask(mListener).execute(url);
    }
}
