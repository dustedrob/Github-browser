package me.roberto.github.ui.main

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.repo_row.view.*
import me.roberto.github.R
import me.roberto.github.entities.Repository


class ReposAdapter(private val values: ArrayList<Repository>)
    : androidx.recyclerview.widget.RecyclerView.Adapter<ReposAdapter.ReposViewHolder>() {

    private val listener: View.OnClickListener

    init {
        listener = View.OnClickListener { v ->
            val item = v.tag as Repository
            v.context.startActivity(Intent(v.context, RepoDetailsActivity::class.java)
                    .putExtra(v.context.getString(R.string.extra_repo), item))

        }
    }



    fun add (list:List<Repository>)
    {
        values.clear()
        values.addAll(list)
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return values.size
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReposViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.repo_row, parent, false)
        return ReposViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReposAdapter.ReposViewHolder, position: Int) {
        val item = values.get(position)


        holder.name.text = item.fullName
        holder.description.text = item.description
        holder.starred.text = item.stargazersCount.toString()
        holder.language.text = item.language
        holder.updated.text = item.updatedAt

        with(holder.view)
        {
            tag = item
            setOnClickListener(listener)
        }


    }

    class ReposViewHolder(val view: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {

        val name = view.name
        val description = view.desc
        val language = view.language
        val starred = view.stars
        val updated = view.updated_txt

    }

}
