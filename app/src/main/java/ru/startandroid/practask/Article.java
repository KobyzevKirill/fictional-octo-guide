package ru.startandroid.practask;

import com.google.gson.annotations.SerializedName;

public class Article {
    private String title;

    @SerializedName("summary")
    private String description;

    private String imageUrl;

    public Article(String title, String description, String imageUrl) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() { return imageUrl; }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

}
