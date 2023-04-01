package namvt.dev.php_project.network

import namvt.dev.php_project.models.Post
import namvt.dev.php_project.models.Result
import namvt.dev.php_project.models.categories.Category
import namvt.dev.php_project.models.news.News
import namvt.dev.php_project.models.users.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface APIService {
    // TODO: http://127.0.0.1:8000/views/tinh-toan-get.php?a=4&b=-3&c=-1


    @GET("views/tinh-toan-get.php")
    suspend fun getResult(
        @Query("a") a: Int,
        @Query("b") b: Int,
        @Query("c") c: Int,
    ): Response<Result>


    // TODO: http://127.0.0.1:8000/views/tinh-dien-tich-post.php

    @Headers("Content-Type: application/json")
    @POST("views/tinh-dien-tich-post.php")
    suspend fun calculate(
        @Body methodPost: Post
    ): Response<Result>



    /* TODO User Auth  */
    // TODO http://localhost:8000/views/api/user/sign-in.php
    //  => API SignIn
    //  => Method POST
    //  => BODY TYPE : Email Password
    @Headers("Content-Type: application/json")
    @POST("views/api/user/sign-in.php")
    suspend fun signIn(
        @Body user: User
    ): Response<User>

    // TODO http://localhost:8000/views/api/user/sign-up.php
    //  => API SignUp
    //  => Method POST
    //  => BODY TYPE : Email Password
    @Headers("Content-Type: application/json")
    @POST("views/api/user/sign-up.php")
    suspend fun signUp(
        @Body user: User
    ): Response<User>
    /* TODO User Auth  */

    /* TODO LIST DATA  */

    // TODO http://localhost:8000/views/api/news/find-news-list.php
    //  => API Find News List
    //  => Method GET
    @GET("views/api/news/find-news-list.php")
    suspend fun findNewsList(
    ): Response<MutableList<News>>


    // TODO http://localhost:8000/views/api/news/find-categories.php
    //  => API Find News List
    //  => Method GET
    @GET("views/api/news/find-categories.php")
    suspend fun findNewsCategories(
    ): Response<MutableList<Category>>


    // TODO http://localhost:8000/views/api/user/find-users.php
    //  => API Find Users
    //  => Method GET
    @GET("views/api/user/find-users.php")
    suspend fun findUsers(
    ): Response<MutableList<User>>

    /* TODO LIST DATA  */



    /* TODO Get Object By ID  */
    // TODO http://localhost:8000/views/api/user/find-user-by-id.php?userId=1
    //  => API FindUserByID
    //  => Method GET
    //  => QUERY TYPE : userId
    @GET("views/api/user/find-user-by-id.php")
    suspend fun findUserById(
        @Query("userId") userId:Int
    ): Response<User>


    // TODO http://localhost:8000/views/api/news/find-category-by-id.php?cId=2
    //  => API FindCategoryByID
    //  => Method GET
    //  => QUERY TYPE : cID
    @GET("views/api/news/find-category-by-id.php")
    suspend fun findCategoryById(
        @Query("cId") cId:Int
    ): Response<Category>
    /* TODO Get Object By ID  */
}