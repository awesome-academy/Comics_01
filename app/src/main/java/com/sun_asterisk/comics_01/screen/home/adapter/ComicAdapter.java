package com.sun_asterisk.comics_01.screen.home.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.sun_asterisk.comics_01.R;
import com.sun_asterisk.comics_01.data.Comic;
import java.util.ArrayList;

public class ComicAdapter extends RecyclerView.Adapter<ComicAdapter.ComicViewHolder> {
    private ArrayList<Comic> mComics;

    public ComicAdapter(ArrayList<Comic> comics) {
        mComics = comics;
    }

    @NonNull
    @Override
    public ComicViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_comic, viewGroup, false);
        return new ComicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ComicViewHolder comicViewHolder, int i) {
        comicViewHolder.bindComic(mComics.get(i));
    }

    @Override
    public int getItemCount() {
        if (mComics != null) return mComics.size();
        return 0;
    }

    static class ComicViewHolder extends RecyclerView.ViewHolder {
        private TextView mTvName;

        ComicViewHolder(@NonNull View itemView) {
            super(itemView);
            mTvName = itemView.findViewById(R.id.tvName);
        }

        void bindComic(Comic comic) {
            mTvName.setText(comic.getName());
        }
    }
}
