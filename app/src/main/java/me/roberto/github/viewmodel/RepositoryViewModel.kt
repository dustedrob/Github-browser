package me.roberto.github.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.roberto.github.entities.Repository
import me.roberto.github.entities.RepositoryState
import me.roberto.github.repository.GithubRepo

class RepositoryViewModel : ViewModel() {


    val repositories = MutableLiveData<RepositoryState>()
    private val githubRepo = GithubRepo()


    fun getRepositories() {

        //githubRepo returns a List of Repository
        //We wrap it around RepositoryState to communicate status: Success or Error depending
        //on API call result

        githubRepo.getRepositories()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ it ->
                    val repositoryState = RepositoryState(it.items, RepositoryState.STATUS_SUCCESS)
                    repositories.value = repositoryState
                }
                        , { error ->
                    Log.e("model", error.message)
                    val repositoryState = RepositoryState(ArrayList(), RepositoryState.STATUS_ERROR)
                    repositories.value = repositoryState
                })

    }

}
