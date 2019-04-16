package com.sun_asterisk.comics_01.screen.read;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import com.sun_asterisk.comics_01.R;
import com.sun_asterisk.comics_01.utils.StringUtils;
import java.util.List;

public class ReadComicActivity extends AppCompatActivity {
    private static final String ARGUMENT_IMAGE_LINK = "ARGUMENT_IMAGE_LINK";
    private static final String BUNDLE_CHAPTER = "BUNDLE_CHAPTER";
    private List<String> mImageLinks;
    private Toolbar mToolbar;

    public static Intent getReadComicIntent(Context context, String imageLinks) {
        Intent intent = new Intent(context, ReadComicActivity.class);
        intent.putExtra(ARGUMENT_IMAGE_LINK, imageLinks);
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

    }

    private void receiveData() {
        Intent intent = getIntent();
        if (intent != null) {
            String imageLinks = intent.getStringExtra(ARGUMENT_IMAGE_LINK);
            mImageLinks = StringUtils.formatStrToStrUrls(imageLinks);
        }
    }

    @Override
    public boolean onNavigateUp() {
        onBackPressed();
        return true;
    }
}
