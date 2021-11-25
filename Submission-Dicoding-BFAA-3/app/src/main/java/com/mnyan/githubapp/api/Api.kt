package com.mnyan.githubapp.api

import com.mnyan.githubapp.data.model.DetailUserResponse
import com.mnyan.githubapp.data.model.User
import com.mnyan.githubapp.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query


interface Api {
    @GET("search/users")
    @Headers("Authorization","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")
    fun getSearchUsers(
        @Query("q") query : String
    ) : Call<UserResponse>

    @GET("users/{username}")
    @Headers("Authorization: token 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")
    fun getUserDetail(
        @Path("username") username :String
    ) : Call<DetailUserResponse>

    @GET("users/{username}/followers")
    @Headers("Authorization: token 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")
    fun getFollowers(
        @Path("username") username :String
    ) : Call<ArrayList<User>>

    @GET("users/{username}/following")
    @Headers("Authorization: token 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")
    fun getFollowing(
        @Path("username") username :String
    ) : Call<ArrayList<User>>

}