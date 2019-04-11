package com.sun_asterisk.comics_01.screen.comic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.sun_asterisk.comics_01.R;
import com.sun_asterisk.comics_01.data.model.Chapter;
import com.sun_asterisk.comics_01.data.model.Comic;
import com.sun_asterisk.comics_01.data.repository.ChapterRepository;
import com.sun_asterisk.comics_01.data.source.remote.ChapterRemoteDataSource;
import java.util.List;

public class ComicDetailActivity extends AppCompatActivity implements ComicDetailContract.View {
    private final static String BUNDLE_COMIC = "BUNDLE_COMIC";
    private final static String ARGUMENT_COMIC = "ARGUMENT_COMIC";
    private ComicDetailContract.Presenter mPresenter;
    private Comic mComic;

    public static Intent getComicDetailIntent(Context context, Comic comic) {
        Intent intent = new Intent(context, ComicDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(ARGUMENT_COMIC, comic);
        intent.putExtra(BUNDLE_COMIC, bundle);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getData();
        initData();
    }

    private void getData() {
        setContentView(R.layout.activity_comic_detail);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra(BUNDLE_COMIC);
        mComic = bundle.getParcelable(ARGUMENT_COMIC);
    }

    private void initData() {
        if (mComic != null) {
            ChapterRepository chapterRepository =
                    ChapterRepository.getInstance(ChapterRemoteDataSource.getInstance());
            mPresenter = new ComicDetailPresenter(chapterRepository, mComic.getId());
            mPresenter.setView(this);
            mPresenter.getChapters();
        }
    }

    @Override
    public void onGetChapterSuccess(List<Chapter> chapters) {
    }

    @Override
    public void onError(Exception exception) {
    }
}
