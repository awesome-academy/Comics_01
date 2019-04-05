package com.sun_asterisk.comics_01.screen.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.sun_asterisk.comics_01.R;
import com.sun_asterisk.comics_01.data.model.Comic;
import com.sun_asterisk.comics_01.screen.home.adapter.ComicAdapter;
import java.util.List;
import java.util.Objects;

public class HomeFragment extends Fragment implements HomeContract.View {
    private RecyclerView mRecyclerComic;
    private ComicAdapter mAdapter;
    private Toolbar mToolbar;
    private final int SPAN_COUNT = 2;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        addControls(view);
        initView();
        return view;
    }

    private void initView() {
        mAdapter = new ComicAdapter(Objects.requireNonNull(getContext()));
        mRecyclerComic.setAdapter(mAdapter);
        mRecyclerComic.setLayoutManager(new GridLayoutManager(getContext(), SPAN_COUNT));
    }

    private void addControls(View view) {
        mRecyclerComic = view.findViewById(R.id.recyclerComic);
        mToolbar = view.findViewById(R.id.toolbar);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.option_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemSearch:
                // go to search activity
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onGetComicsSuccess(List<Comic> comics) {
        if (comics != null) mAdapter.setData(comics);
    }

    @Override
    public void onError(Exception exception) {
        Toast.makeText(getContext(), exception.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
