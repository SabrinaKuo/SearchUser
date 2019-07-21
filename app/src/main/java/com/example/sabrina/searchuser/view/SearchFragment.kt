package com.example.sabrina.searchuser.view

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import com.example.sabrina.searchuser.R
import com.example.sabrina.searchuser.model.User
import com.example.sabrina.searchuser.viewmodel.SearchViewModel
import org.koin.android.viewmodel.ext.android.viewModel


class SearchFragment : Fragment() {

    private val searchViewModel: SearchViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(view.context, LinearLayout.VERTICAL, false)

        var textedit = view.findViewById<TextInputEditText>(R.id.edtQuery)
        var button = view.findViewById<Button>(R.id.btnSearch)
        button.setOnClickListener({
            var queryName = textedit.text.toString()
            searchViewModel.searchUser(queryName)
        })

        searchViewModel.listOfUser.observe(this, Observer(function = fun(resultList: List<User>?){
            resultList?.let {
                if (resultList.isNotEmpty()){
//                    var list = listOf(User("https://avatars0.githubusercontent.com/u/13518019?v=4", "SabrinaKuo"), User("https://avatars0.githubusercontent.com/u/13518019?v=4", "SabrinaKuo"))
                    var searchResultAdapter = SearchResultAdapter(resultList)
                    recyclerView.adapter = searchResultAdapter
                }
            }
        }))

    }
}