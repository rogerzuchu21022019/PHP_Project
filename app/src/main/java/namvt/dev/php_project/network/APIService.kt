package namvt.dev.php_project.network

import namvt.dev.php_project.models.Post
import namvt.dev.php_project.models.Result
import namvt.dev.php_project.models.categories.ResponseCate
import namvt.dev.php_project.models.users.ResponseUser
import namvt.dev.php_project.models.users.User
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface APIService {
    // TODO: http://127.0.0.1:8000/views/tinh-toan-get.php?a=4&b=-3&c=-1


    @GET("views/tinh-toan-get.php")
    suspend fun getResult(
        @Query("a") a:Int,
        @Query("b") b:Int,
        @Query("c") c:Int,
    ): Response<Result>


    // TODO: http://127.0.0.1:8000/views/tinh-dien-tich-post.php

    @Headers("Content-Type: application/json")
    @POST("views/tinh-dien-tich-post.php")
    suspend fun calculate(
        @Body methodPost: Post
    ):Response<Result>


    // TODO http://localhost:8000/views/api/user/sign-in.php
    //  => API SignIn
    //  => Method POST
    //  => BODY TYPE : Email Password

    @Headers("Content-Type: application/json")
    @POST("views/api/user/sign-in.php")
    suspend fun signIn(
        @Body user: User
    ):Response<ResponseUser>

    // TODO http://localhost:8000/views/api/user/sign-up.php
    //  => API SignUp
    //  => Method POST
    //  => BODY TYPE : Email Password
    @Headers("Content-Type: application/json")
    @POST("views/api/user/sign-up.php")
    suspend fun signUp(
        @Body user: User
    ):Response<ResponseUser>
}