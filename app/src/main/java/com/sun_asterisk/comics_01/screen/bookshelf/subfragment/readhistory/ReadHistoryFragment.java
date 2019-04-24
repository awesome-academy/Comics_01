package com.sun_asterisk.comics_01.screen.bookshelf.subfragment.readhistory;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.sun_asterisk.comics_01.R;

public class ReadHistoryFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;

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
        return view;
    }

    private void initView(View view) {
        mRecyclerView = view.findViewById(R.id.recyclerViewReadHistory);
        mProgressBar = view.findViewById(R.id.progressBarReadHistory);
    }
}
