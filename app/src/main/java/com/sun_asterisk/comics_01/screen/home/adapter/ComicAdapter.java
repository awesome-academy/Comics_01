package com.sun_asterisk.comics_01.screen.home.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.sun_asterisk.comics_01.R;
import com.sun_asterisk.comics_01.data.model.Comic;
import java.util.ArrayList;
import java.util.List;

public class ComicAdapter extends RecyclerView.Adapter<ComicAdapter.ComicViewHolder> {
    private Context mContext;
    private List<Comic> mComics = new ArrayList<>();

    public ComicAdapter(@NonNull Context context) {
        mContext = context;
    }

    public void setData(List<Comic> comics) {
        mComics.clear();
        int positionStart = mComics.size();
        mComics.addAll(comics);
        notifyItemRangeInserted(positionStart, comics.size());
    }

    @NonNull
    @Override
    public ComicViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_comic, viewGroup, false);
        return new ComicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ComicViewHolder comicViewHolder, int position) {
        comicViewHolder.bindComic(mComics.get(position));
    }

    @Override
    public int getItemCount() {
        if (mComics != null) return mComics.size();
        return 0;
    }

    static class ComicViewHolder extends RecyclerView.ViewHolder {
        private TextView mTvName;
        private ImageView mImgThumbnail;

        ComicViewHolder(@NonNull View itemView) {
            super(itemView);
            mTvName = itemView.findViewById(R.id.tvName);
            mImgThumbnail = itemView.findViewById(R.id.imgThumbnail);
        }

        void bindComic(Comic comic) {
            mTvName.setText(comic.getName());
        }
    }
}
