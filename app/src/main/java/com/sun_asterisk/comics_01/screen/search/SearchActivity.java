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
import com.sun_asterisk.comics_01.R;
import com.sun_asterisk.comics_01.data.model.Comic;
import com.sun_asterisk.comics_01.screen.home.HomeFragment;
import com.sun_asterisk.comics_01.screen.home.adapter.ComicAdapter;
import java.util.List;

public class SearchActivity extends AppCompatActivity implements SearchContract.View {
    private AutoCompleteTextView mAutoCompleteTvName;
    private Button mBtnSearch;
    private TextView mTvNotify;
    private RecyclerView mRvComic;
    private ProgressBar mProgressSearch;
    private ComicAdapter mAdapter;

    public static Intent getSearchIntent(Context context) {
        Intent intent = new Intent(context, SearchActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();
    }

    private void initView() {
        mAutoCompleteTvName = findViewById(R.id.autoCompleteTvNameComic);
        mBtnSearch = findViewById(R.id.btnSearch);
        mTvNotify = findViewById(R.id.tvNotify);
        mRvComic = findViewById(R.id.recyclerSearchComic);
        mAdapter = new ComicAdapter(this);
        mRvComic.setAdapter(mAdapter);
        mRvComic.setLayoutManager(new GridLayoutManager(this, HomeFragment.SPAN_COUNT));
        mProgressSearch = findViewById(R.id.progressSearch);
        mProgressSearch.setVisibility(View.GONE);
    }

    @Override
    public void onSearchComicSuccess(List<Comic> comics) {
        mProgressSearch.setVisibility(View.GONE);
    }

    @Override
    public void onError(Exception exception) {
    }
}
