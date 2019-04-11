package com.sun_asterisk.comics_01.screen.bookshelf.subfragment.readhistory.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.sun_asterisk.comics_01.R;
import com.sun_asterisk.comics_01.data.model.Comic;
import com.sun_asterisk.comics_01.utils.ImageUtils;
import java.util.ArrayList;
import java.util.List;

public class ReadHistoryAdapter
        extends RecyclerView.Adapter<ReadHistoryAdapter.ReadHistoryViewHolder> {
    private List<Comic> mComics = new ArrayList<>();
    private int mSize;

    public void setComics(List<Comic> comics) {
        mComics.addAll(comics);
        mSize = mComics.size();
        notifyItemRangeInserted(0, mSize);
    }

    public void clear() {
        mComics.clear();
        notifyItemRangeRemoved(0, mSize);
    }

    @NonNull
    @Override
    public ReadHistoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_read_history, viewGroup, false);
        return new ReadHistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReadHistoryViewHolder readHistoryViewHolder,
            int position) {
        readHistoryViewHolder.bind(mComics.get(position));
    }

    @Override
    public int getItemCount() {
        return mComics != null ? mComics.size() : 0;
    }

    static class ReadHistoryViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImgThumbnail;
        private TextView mNameComic;
        private TextView mNameChapter;
        private ProgressBar mProgressBarReadHistory;

        public ReadHistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            mImgThumbnail = itemView.findViewById(R.id.imgThumbnailItemReadHistory);
            mNameComic = itemView.findViewById(R.id.tvComicName);
            mNameChapter = itemView.findViewById(R.id.tvNameChapter);
            mProgressBarReadHistory = itemView.findViewById(R.id.progressItemBarReadHistory);
        }

        public void bind(Comic comic) {
            ImageUtils.bindImage(itemView.getContext(), comic.getThumbnail(),
                    mProgressBarReadHistory, mImgThumbnail);
            mNameComic.setText(comic.getName());
            mNameChapter.setText(comic.getNameChapterCurrent());
        }
    }
}
