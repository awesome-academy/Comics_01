package com.sun_asterisk.comics_01.screen.comic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.sun_asterisk.comics_01.R;
import com.sun_asterisk.comics_01.data.model.Chapter;
import com.sun_asterisk.comics_01.data.model.Comic;
import com.sun_asterisk.comics_01.data.repository.ChapterRepository;
import com.sun_asterisk.comics_01.data.source.remote.ChapterRemoteDataSource;
import com.sun_asterisk.comics_01.screen.comic.adapter.ChapterAdapter;
import com.sun_asterisk.comics_01.screen.read.ReadComicActivity;
import com.sun_asterisk.comics_01.utils.OnItemRecyclerViewClickListener;
import com.sun_asterisk.comics_01.utils.StringUtils;
import java.util.List;

public class ComicDetailActivity extends AppCompatActivity
        implements ComicDetailContract.View, OnItemRecyclerViewClickListener<Chapter> {
    private final static String BUNDLE_COMIC = "BUNDLE_COMIC";
    private final static String ARGUMENT_COMIC = "ARGUMENT_COMIC";
    private ComicDetailContract.Presenter mPresenter;
    private Comic mComic;
    private ImageView mImgThumbnail;
    private TextView mTvName;
    private TextView mTvOtherName;
    private TextView mTvDateCreated;
    private TextView mTvDescription;
    private ChapterAdapter mAdapter;
    private RecyclerView mRecyclerChapter;
    private Toolbar mToolbar;
    private ProgressBar mProgressBar;

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
        setContentView(R.layout.activity_comic_detail);
        receiveData();
        initView();
        initData();
        getRemoteData();
    }

    private void receiveData() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra(BUNDLE_COMIC);
        mComic = bundle.getParcelable(ARGUMENT_COMIC);
    }

    private void initView() {
        mToolbar = findViewById(R.id.toolbarChapter);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mImgThumbnail = findViewById(R.id.imgThumbComicDetail);
        mTvName = findViewById(R.id.tvNameComicDetail);
        mTvOtherName = findViewById(R.id.tvOtherNameComicDetail);
        mTvDateCreated = findViewById(R.id.tvDateCreatedComicDetail);
        mTvDescription = findViewById(R.id.tvDescriptionComicDetail);
        mTvDescription.setMovementMethod(new ScrollingMovementMethod());
        mRecyclerChapter = findViewById(R.id.recyclerChapter);
        mProgressBar = findViewById(R.id.progressBar);
        mAdapter = new ChapterAdapter();
        mAdapter.setOnItemRecyclerViewClickListener(this);
        mRecyclerChapter.setAdapter(mAdapter);
        mRecyclerChapter.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initData() {
        if (mComic != null) {
            Glide.with(this).load(mComic.getThumbnail()).centerCrop().into(mImgThumbnail);
            mTvName.setText(mComic.getName());
            mTvOtherName.setText(mComic.getOtherName());
            mTvDateCreated.setText(StringUtils.formatDate(mComic.getDateCreated()));
            mTvDescription.setText(mComic.getDescription());
        }
    }

    private void getRemoteData() {
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
        if (chapters != null) mAdapter.setData(chapters);
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void onError(Exception exception) {
        if (exception != null) mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void onItemClickListener(Chapter chapter) {
        startActivity(ReadComicActivity.getReadComicIntent(this, chapter.getImagesLink()));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
