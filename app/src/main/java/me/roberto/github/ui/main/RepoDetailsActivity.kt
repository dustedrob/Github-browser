package me.roberto.github.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_repo_details.*
import kotlinx.android.synthetic.main.content_repo_details.*
import kotlinx.android.synthetic.main.repo_row.*
import me.roberto.github.R
import me.roberto.github.entities.Repository

class RepoDetailsActivity : AppCompatActivity() {
    lateinit var repository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo_details)
        repository=intent.extras.getParcelable(getString(R.string.extra_repo))
        Picasso.get().load(repository.owner?.avatarUrl).into(avatar)
        watch_txt.text=repository.watchers.toString()
        star_txt.text=repository.stargazersCount.toString()
        fork_txt.text=repository.forksCount.toString()
        toolbar.title=repository.name
        description.text=repository.description
        full_name.text=repository.fullName

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
