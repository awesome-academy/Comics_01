package com.sun_asterisk.comics_01.data.source.remote.fetchjson;

import com.sun_asterisk.comics_01.data.model.Comic;
import com.sun_asterisk.comics_01.data.source.remote.OnFetchDataJsonListener;
import com.sun_asterisk.comics_01.utils.Constant;

public class GetComicJson {
    private OnFetchDataJsonListener<Comic> mListener;

    public GetComicJson(OnFetchDataJsonListener<Comic> listener) {
        mListener = listener;
    }

    public void getComics() {
        String url = Constant.BASE_URL + Constant.STORE_ALL;
        new GetComicAsyncTask(mListener).execute(url);
    }
}
