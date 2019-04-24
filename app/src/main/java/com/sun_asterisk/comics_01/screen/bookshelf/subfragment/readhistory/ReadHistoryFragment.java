package com.sun_asterisk.comics_01.screen.bookshelf.subfragment.readhistory;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.sun_asterisk.comics_01.R;
import com.sun_asterisk.comics_01.data.repository.ComicRepository;
import com.sun_asterisk.comics_01.data.source.local.ComicLocalDataSource;
import com.sun_asterisk.comics_01.data.source.local.sqlite.ComicLocalHandler;
import com.sun_asterisk.comics_01.screen.bookshelf.subfragment.readhistory.adapter.ReadHistoryAdapter;

public class ReadHistoryFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;
    private ReadHistoryContract.Presenter mPresenter;
    private ReadHistoryAdapter mHistoryAdapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    public static ReadHistoryFragment getInstance() {
        ReadHistoryFragment fragment = new ReadHistoryFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sub_bookshelf, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        ComicLocalHandler comicLocalHandler = new ComicLocalHandler(getContext());
        ComicRepository comicRepository = ComicRepository.getInstance(null,
                ComicLocalDataSource.getsInstance(comicLocalHandler));
        mPresenter = new ReadHistoryPresenter(comicRepository);
        mHistoryAdapter = new ReadHistoryAdapter();
        mHistoryAdapter.setComics(mPresenter.getReadHistory());
        mRecyclerView.setAdapter(mHistoryAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void initView(View view) {
        mRecyclerView = view.findViewById(R.id.recyclerViewReadHistory);
        mSwipeRefreshLayout = view.findViewById(R.id.swipeRefresh);
        mSwipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void onRefresh() {
        mHistoryAdapter.clear();
        mHistoryAdapter.setComics(mPresenter.getReadHistory());
        mSwipeRefreshLayout.setRefreshing(false);
    }
}
