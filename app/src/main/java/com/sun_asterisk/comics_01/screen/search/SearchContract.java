package com.sun_asterisk.comics_01.screen.search;

import com.sun_asterisk.comics_01.data.model.Comic;
import com.sun_asterisk.comics_01.screen.BasePresenter;
import java.util.List;

public interface SearchContract {
    interface View {
        void onSearchComicSuccess(List<Comic> comics);

        void onError(Exception exception);
    }

    interface Presenter extends BasePresenter<View> {
        void searchComic(String comicName);
    }
}
