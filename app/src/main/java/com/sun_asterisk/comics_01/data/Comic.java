package com.sun_asterisk.comics_01.data;

public class Comic {
    private int mId;
    private String mName;
    private String mOtherName;
    private String mThumb;
    private String mDescription;
    private String mDateCreated;

    public Comic() {
    }

    public Comic(int id, String name, String otherName, String thumb, String description,
            String dateCreated) {
        mId = id;
        mName = name;
        mOtherName = otherName;
        mThumb = thumb;
        mDescription = description;
        mDateCreated = dateCreated;
    }

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

    public String getThumb() {
        return mThumb;
    }

    public void setThumb(String thumb) {
        mThumb = thumb;
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
}
