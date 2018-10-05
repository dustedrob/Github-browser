package me.roberto.github.ui.main

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_repo_details.*
import kotlinx.android.synthetic.main.main_fragment.*
import me.roberto.github.R
import me.roberto.github.entities.Repository
import me.roberto.github.entities.RepositoryState
import me.roberto.github.viewmodel.RepositoryViewModel

class MainFragment : androidx.fragment.app.Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: RepositoryViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }


    val adapter: ReposAdapter = ReposAdapter(ArrayList())
    val observer = Observer<RepositoryState> { it ->

        when (it.status) {
            //Status will tell us if it was a success
            //if so, we update the list
            //if there was an error, we display in in the UI
            RepositoryState.STATUS_SUCCESS -> {

                progress_bar.visibility = View.GONE
                recycler.visibility = View.VISIBLE
                adapter.add(it.repositories!!)
            }
            else -> {
                progress_bar.visibility = View.GONE
                Snackbar.make(recycler, "Connectivity Error", Snackbar.LENGTH_INDEFINITE).show()
            }
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context)
        recycler.adapter = adapter


    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {

        //Using Android Jetpack libraries to structure the MVVM pattern.
        //UI is handled with LiveData/ViewModel
        //Network calls with RXJava/Retrofit2
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RepositoryViewModel::class.java)
        viewModel.repositories.observe(this, observer)
        viewModel.getRepositories()

    }


}
