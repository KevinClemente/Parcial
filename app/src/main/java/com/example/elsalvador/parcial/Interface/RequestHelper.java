package com.example.elsalvador.parcial.Interface;

import com.example.elsalvador.parcial.Object.News;
import com.example.elsalvador.parcial.Object.TopPlayers;
import com.example.elsalvador.parcial.Object.usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface RequestHelper {
    @FormUrlEncoded
    @POST("login")

    Call<usuario> loginRequest(@Field("user") String username, @Field("password") String password);

    @GET("news")
    Call<List<News>> getNewsRequest(@Header("Authorization") String token);

    @GET("players")
    Call<List<TopPlayers>> getTopPlayersRequest(@Header("Authorization") String token);
}
