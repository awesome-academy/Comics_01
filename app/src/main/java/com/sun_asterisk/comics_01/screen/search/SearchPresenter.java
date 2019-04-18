package com.sun_asterisk.comics_01.screen.search;

import com.sun_asterisk.comics_01.data.model.Comic;
import com.sun_asterisk.comics_01.data.repository.ComicRepository;
import com.sun_asterisk.comics_01.data.source.remote.OnFetchDataJsonListener;
import java.util.List;

public class SearchPresenter implements SearchContract.Presenter, OnFetchDataJsonListener<Comic> {
    private SearchContract.View mView;
    private ComicRepository mComicRepository;

    public SearchPresenter(ComicRepository comicRepository) {
        mComicRepository = comicRepository;
    }

    @Override
    public void searchComic(String comicName) {
        mComicRepository.getComicByName(this, comicName);
    }

    @Override
    public void setView(SearchContract.View view) {
        mView = view;
    }

    @Override
    public void onSuccess(List<Comic> comics) {
        if (comics != null) mView.onSearchComicSuccess(comics);
    }

    @Override
    public void onError(Exception exception) {
        mView.onError(exception);
    }
}
