package me.roberto.github.repository

import io.reactivex.Single
import me.roberto.github.api.GithubService
import me.roberto.github.entities.GitHubResponse
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class GithubRepo {

    val githubService: GithubService
    init{


        val converter= MoshiConverterFactory.create()
        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(converter)
                .build()

        githubService = retrofit.create(GithubService::class.java)

    }


    fun getRepositories(): Single<GitHubResponse>
    {

        return Single.create<GitHubResponse> { e->

            val repos = githubService.searchRepos("android+language:java&sort=stars&order=desc")
            val response = repos.execute()

            if (response!=null && response.isSuccessful)
            {
                e.onSuccess(response.body()!!)
            }
            else
            {
                e.onError(Exception(response?.errorBody().toString()))
            }
        }

    }
}