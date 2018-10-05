package me.roberto.github.api

import me.roberto.github.entities.GitHubResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {




    @GET("search/repositories")
    fun searchRepos(@Query("q") query: String): Call<GitHubResponse>


}