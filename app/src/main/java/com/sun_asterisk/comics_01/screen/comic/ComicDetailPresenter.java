package com.sun_asterisk.comics_01.screen.comic;

import com.sun_asterisk.comics_01.data.model.Chapter;
import com.sun_asterisk.comics_01.data.repository.ChapterRepository;
import com.sun_asterisk.comics_01.data.source.remote.OnFetchDataJsonListener;
import java.util.List;

public class ComicDetailPresenter implements ComicDetailContract.Presenter {
    private ComicDetailContract.View mView;
    private ChapterRepository mChapterRepository;
    private int mIdComic;

    public ComicDetailPresenter(ChapterRepository chapterRepository, int idComic) {
        mChapterRepository = chapterRepository;
        mIdComic = idComic;
    }

    @Override
    public void getChapters() {
        mChapterRepository.getChapters(mIdComic, new OnFetchDataJsonListener<Chapter>() {
            @Override
            public void onSuccess(List<Chapter> chapters) {
                if (chapters != null) mView.onGetChapterSuccess(chapters);
            }

            @Override
            public void onError(Exception exception) {
                mView.onError(exception);
            }
        });
    }

    @Override
    public void setView(ComicDetailContract.View view) {
        mView = view;
    }
}
