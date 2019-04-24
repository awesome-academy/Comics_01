package com.sun_asterisk.comics_01.screen.comic;

import com.sun_asterisk.comics_01.data.model.Chapter;
import com.sun_asterisk.comics_01.data.model.Comic;
import com.sun_asterisk.comics_01.screen.BasePresenter;
import java.util.List;

public interface ComicDetailContract {
    interface View {
        void onGetChapterSuccess(List<Chapter> chapters);

        void onError(Exception exception);
    }

    interface Presenter extends BasePresenter<View> {
        void getChapters();
        void saveComicCurrent(Comic comic);
    }
}
