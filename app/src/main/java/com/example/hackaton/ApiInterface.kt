package com.example.hackaton
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


    interface ApiInterface{

        @FormUrlEncoded
        @POST("digitalflake/api/create_account")
        fun createUser(
            @Field("email") email: String,
            @Field("name") name: String
        ): Call<Void>

        @FormUrlEncoded
        @POST("digitalflake/api/login")
        fun loginUser(
            @Field("email") email: String,
            @Field("password") password: String
        ): Call<Void>
    }


