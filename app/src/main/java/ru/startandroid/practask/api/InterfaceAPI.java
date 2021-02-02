package ru.startandroid.practask.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import ru.startandroid.practask.Article;

public interface InterfaceAPI {

    @GET("articles")
    Call<List<Article>> getArticles();
}
