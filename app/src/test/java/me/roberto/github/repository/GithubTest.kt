package me.roberto.github.repository

import org.junit.Test

import org.junit.Assert.*

class GithubTest {

    @Test
    fun getRepositories() {

        val repo=GithubRepo()
        repo.getRepositories().test().assertComplete().assertNoErrors().awaitTerminalEvent()
    }
}