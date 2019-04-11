package com.sun_asterisk.comics_01.screen.read;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import com.sun_asterisk.comics_01.R;
import com.sun_asterisk.comics_01.data.model.Chapter;
import com.sun_asterisk.comics_01.screen.read.adapter.ContentAdapter;
import com.sun_asterisk.comics_01.utils.StringUtils;
import java.util.List;

public class ReadComicActivity extends AppCompatActivity {
    private static final String ARGUMENT_IMAGE_LINK = "ARGUMENT_IMAGE_LINK";
    private static final String ARGUMENT_CHAPTER_NAME = "ARGUMENT_CHAPTER_NAME";
    private List<String> mImageLinks;
    private String mChapterName;
    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private ContentAdapter mAdapter;

    public static Intent getReadComicIntent(Context context, Chapter chapter) {
        Intent intent = new Intent(context, ReadComicActivity.class);
        intent.putExtra(ARGUMENT_IMAGE_LINK, chapter.getImagesLink());
        intent.putExtra(ARGUMENT_CHAPTER_NAME, chapter.getName());
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_comic);
        receiveData();
        initView();
    }

    private void initView() {
        mToolbar = findViewById(R.id.toolbarContentChapter);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(mChapterName);
        mRecyclerView = findViewById(R.id.recyclerContent);

        mAdapter = new ContentAdapter();
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        if (mImageLinks != null) mAdapter.setData(mImageLinks);
    }

    private void receiveData() {
        Intent intent = getIntent();
        if (intent != null) {
            String imageLinks = intent.getStringExtra(ARGUMENT_IMAGE_LINK);
            mImageLinks = StringUtils.formatStrToStrUrls(imageLinks);
            mChapterName = intent.getStringExtra(ARGUMENT_CHAPTER_NAME);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
