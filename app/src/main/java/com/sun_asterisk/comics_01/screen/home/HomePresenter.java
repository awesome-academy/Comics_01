package com.sun_asterisk.comics_01.screen.home;

import com.sun_asterisk.comics_01.data.source.ComicRepository;

final public class HomePresenter implements HomeContract.Presenter {
    private HomeContract.View mView;
    private ComicRepository mComicRepository;

    public HomePresenter(ComicRepository comicRepository) {
        mComicRepository = comicRepository;
    }

    @Override
    public void getComics() {

    }

    @Override
    public void setView(HomeContract.View view) {
        mView = view;
    }
}
