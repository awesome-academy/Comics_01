package com.sun_asterisk.comics_01.screen.category.subfragment;

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

public class SubCategoryFragment extends Fragment {
    private static final String ARGUMENT_ID_CATEGORY = "ARGUMENT_ID_CATEGORY";
    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;

    public static SubCategoryFragment newInstance(int id) {
        SubCategoryFragment fragment = new SubCategoryFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(ARGUMENT_ID_CATEGORY, id);
        fragment.setArguments(arguments);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        int idCategory = getArguments().getInt(ARGUMENT_ID_CATEGORY);
        View view = inflater.inflate(R.layout.fragment_sub_category, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mRecyclerView = view.findViewById(R.id.recyclerPerCategory);
        mProgressBar = view.findViewById(R.id.progressBarPerCategory);
    }
}
