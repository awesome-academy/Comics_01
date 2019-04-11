package com.sun_asterisk.comics_01.screen.search;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.sun_asterisk.comics_01.R;
import com.sun_asterisk.comics_01.data.model.Comic;
import com.sun_asterisk.comics_01.data.repository.ComicRepository;
import com.sun_asterisk.comics_01.data.source.local.ComicLocalDataSource;
import com.sun_asterisk.comics_01.data.source.remote.ComicRemoteDataSource;
import com.sun_asterisk.comics_01.screen.comic.ComicDetailActivity;
import com.sun_asterisk.comics_01.screen.home.HomeFragment;
import com.sun_asterisk.comics_01.screen.home.adapter.ComicAdapter;
import com.sun_asterisk.comics_01.utils.OnItemRecyclerViewClickListener;
import java.util.List;

public class SearchActivity extends AppCompatActivity
        implements SearchContract.View, OnItemRecyclerViewClickListener<Comic>,
        View.OnClickListener {
    private AutoCompleteTextView mAutoCompleteTvName;
    private Button mBtnSearch;
    private TextView mTvNotify;
    private RecyclerView mRvComic;
    private ProgressBar mProgressSearch;
    private ComicAdapter mAdapter;
    private SearchPresenter mPresenter;

    public static Intent getSearchIntent(Context context) {
        return new Intent(context, SearchActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();
        setRemoteData();
    }

    private void setRemoteData() {
        ComicRepository comicRepository =
                ComicRepository.getInstance(ComicRemoteDataSource.getsInstance(),
                        ComicLocalDataSource.getsInstance());
        mPresenter = new SearchPresenter(comicRepository);
        mPresenter.setView(this);
    }

    private void initView() {
        mAutoCompleteTvName = findViewById(R.id.autoCompleteTvNameComic);
        mBtnSearch = findViewById(R.id.btnSearch);
        mBtnSearch.setOnClickListener(this);
        mTvNotify = findViewById(R.id.tvNotify);
        mRvComic = findViewById(R.id.recyclerSearchComic);
        mAdapter = new ComicAdapter(this);
        mAdapter.setOnItemRecyclerViewClickListener(this);
        mRvComic.setAdapter(mAdapter);
        mRvComic.setLayoutManager(new GridLayoutManager(this, HomeFragment.SPAN_COUNT));
        mProgressSearch = findViewById(R.id.progressSearch);
        mProgressSearch.setVisibility(View.GONE);
    }

    @Override
    public void onSearchComicSuccess(List<Comic> comics) {
        mProgressSearch.setVisibility(View.GONE);
        if (comics != null) mAdapter.setData(comics);
    }

    @Override
    public void onSearchComicError(Exception exception) {
        Toast.makeText(getApplicationContext(), exception.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNoDataAvailable() {
        mProgressSearch.setVisibility(View.GONE);
        mTvNotify.setText(getResources().getString(R.string.not_find));
        mAdapter.clear();
    }

    @Override
    public void onItemClickListener(Comic comic) {
        startActivity(ComicDetailActivity.getComicDetailIntent(this, comic));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSearch:
                mTvNotify.setText("");
                String name = mAutoCompleteTvName.getText().toString().trim();
                if (name.equals("")) {
                    mAutoCompleteTvName.requestFocus();
                } else {
                    mProgressSearch.setVisibility(View.VISIBLE);
                    mPresenter.searchComic(name);
                }
                break;
        }
    }
}
