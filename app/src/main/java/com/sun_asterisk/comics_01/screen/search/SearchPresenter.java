package com.sun_asterisk.comics_01.screen.search;

import com.sun_asterisk.comics_01.data.model.Comic;
import com.sun_asterisk.comics_01.data.repository.ComicRepository;
import com.sun_asterisk.comics_01.data.source.remote.OnFetchDataJsonListener;
import java.util.List;

public class SearchPresenter implements SearchContract.Presenter {
    private SearchContract.View mView;
    private ComicRepository mComicRepository;

    public SearchPresenter(ComicRepository comicRepository) {
        mComicRepository = comicRepository;
    }

    @Override
    public void searchComic(String comicName) {
        mComicRepository.getComicByName(comicName, new OnFetchDataJsonListener<Comic>() {
            @Override
            public void onSuccess(List<Comic> comics) {
                if (comics.isEmpty()) {
                    mView.onSearchComicSuccess(comics);
                } else {
                    mView.onNoDataAvailable();
                }
            }

            @Override
            public void onError(Exception exception) {
                mView.onSearchComicError(exception);
            }
        });
    }

    @Override
    public void setView(SearchContract.View view) {
        mView = view;
    }
}
