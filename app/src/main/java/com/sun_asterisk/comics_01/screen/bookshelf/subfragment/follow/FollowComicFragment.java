package com.sun_asterisk.comics_01.screen.bookshelf.subfragment.follow;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sun_asterisk.comics_01.R;

public class FollowComicFragment extends Fragment {

    public static FollowComicFragment getInstance() {
        FollowComicFragment fragment = new FollowComicFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sub_bookshelf, container, false);
    }
}
