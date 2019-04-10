package com.sun_asterisk.comics_01.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Comic implements Parcelable {
    private int mId;
    private String mName;
    private String mOtherName;
    private String mThumbnail;
    private String mDescription;
    private String mDateCreated;

    public Comic() {
    }

    public Comic(int id, String name, String otherName, String thumbnail, String description,
            String dateCreated) {
        mId = id;
        mName = name;
        mOtherName = otherName;
        mThumbnail = thumbnail;
        mDescription = description;
        mDateCreated = dateCreated;
    }

    public Comic(ComicBuilder comicBuilder) {
        mId = comicBuilder.mId;
        mName = comicBuilder.mName;
        mOtherName = comicBuilder.mOtherName;
        mThumbnail = comicBuilder.mThumbnail;
        mDescription = comicBuilder.mDescription;
        mDateCreated = comicBuilder.mDateCreated;
    }

    protected Comic(Parcel in) {
        mId = in.readInt();
        mName = in.readString();
        mOtherName = in.readString();
        mThumbnail = in.readString();
        mDescription = in.readString();
        mDateCreated = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mId);
        dest.writeString(mName);
        dest.writeString(mOtherName);
        dest.writeString(mThumbnail);
        dest.writeString(mDescription);
        dest.writeString(mDateCreated);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Comic> CREATOR = new Creator<Comic>() {
        @Override
        public Comic createFromParcel(Parcel in) {
            return new Comic(in);
        }

        @Override
        public Comic[] newArray(int size) {
            return new Comic[size];
        }
    };

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getOtherName() {
        return mOtherName;
    }

    public void setOtherName(String otherName) {
        mOtherName = otherName;
    }

    public String getThumbnail() {
        return mThumbnail;
    }

    public void setThumbnail(String thumbnail) {
        mThumbnail = thumbnail;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getDateCreated() {
        return mDateCreated;
    }

    public void setDateCreated(String dateCreated) {
        mDateCreated = dateCreated;
    }

    public static class ComicBuilder {
        private int mId;
        private String mName;
        private String mOtherName;
        private String mThumbnail;
        private String mDescription;
        private String mDateCreated;

        public ComicBuilder() {
        }

        public ComicBuilder(int id, String name, String otherName, String thumbnail,
                String description, String dateCreated) {
            mId = id;
            mName = name;
            mOtherName = otherName;
            mThumbnail = thumbnail;
            mDescription = description;
            mDateCreated = dateCreated;
        }

        public ComicBuilder id(int id) {
            mId = id;
            return this;
        }

        public ComicBuilder name(String name) {
            mName = name;
            return this;
        }

        public ComicBuilder otherName(String otherName) {
            mOtherName = otherName;
            return this;
        }

        public ComicBuilder thumbnail(String thumbnail) {
            mThumbnail = thumbnail;
            return this;
        }

        public ComicBuilder description(String description) {
            mDescription = description;
            return this;
        }

        public ComicBuilder dateCreated(String dateCreated) {
            mDateCreated = dateCreated;
            return this;
        }

        public Comic build() {
            return new Comic(this);
        }
    }

    public final class ComicEntry {
        public static final String ID = "Id";
        public static final String NAME = "TenTruyen";
        public static final String OTHER_NAME = "TenKhac";
        public static final String THUMBNAIL = "AnhDaiDien";
        public static final String DESCRIPTION = "MoTa";
        public static final String DATE_CREATED = "NgayTao";
        public static final String COMIC_LIST = "Data";
    }
}
