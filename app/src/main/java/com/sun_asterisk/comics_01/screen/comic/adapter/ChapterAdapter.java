package com.sun_asterisk.comics_01.screen.comic.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.sun_asterisk.comics_01.R;
import com.sun_asterisk.comics_01.data.model.Chapter;
import java.util.ArrayList;
import java.util.List;

public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.ChapterHolder> {
    private static final String SEPARATE = ". ";
    private List<Chapter> mChapters;

    public ChapterAdapter() {
        mChapters = new ArrayList<>();
    }

    public void setData(List<Chapter> chapters) {
        mChapters.clear();
        mChapters = chapters;
        notifyItemRangeInserted(0, mChapters.size());
    }

    @NonNull
    @Override
    public ChapterHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_chapter, viewGroup, false);
        return new ChapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChapterHolder chapterHolder, int position) {
        chapterHolder.bind(mChapters.get(position));
    }

    @Override
    public int getItemCount() {
        return mChapters != null ? mChapters.size() : 0;
    }

    static class ChapterHolder extends RecyclerView.ViewHolder {
        private TextView mTvNameChapter;
        private TextView mTvDateCreated;
        private TextView mTvView;

        ChapterHolder(@NonNull View itemView) {
            super(itemView);
            mTvNameChapter = itemView.findViewById(R.id.tvChapterName);
            mTvDateCreated = itemView.findViewById(R.id.tvDateCreated);
            mTvView = itemView.findViewById(R.id.tvView);
        }

        void bind(Chapter chapter) {
            mTvNameChapter.setText(chapter.getSerial() + SEPARATE + chapter.getName());
            mTvDateCreated.setText(chapter.getDateCreated());
            mTvView.setText(Long.toString(chapter.getView()));
        }
    }
}
