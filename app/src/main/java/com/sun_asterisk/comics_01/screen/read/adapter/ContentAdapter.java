package com.sun_asterisk.comics_01.screen.read.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.sun_asterisk.comics_01.R;
import java.util.ArrayList;
import java.util.List;

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ContentViewHolder> {
    private List<String> mLinks;

    public ContentAdapter() {
        mLinks = new ArrayList<>();
    }

    public void setData(List<String> links) {
    }

    @NonNull
    @Override
    public ContentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_content, viewGroup, false);
        return new ContentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContentViewHolder contentViewHolder, int position) {
        contentViewHolder.bind(mLinks.get(position));
    }

    @Override
    public int getItemCount() {
        return mLinks != null ? mLinks.size() : 0;
    }

    static class ContentViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgContent;

        ContentViewHolder(@NonNull View itemView) {
            super(itemView);
            imgContent = itemView.findViewById(R.id.imgContent);
        }

        void bind(String link) {
            if (imgContent != null) {
                Glide.with(itemView.getContext()).load(link).centerCrop().into(imgContent);
            }
        }
    }
}
