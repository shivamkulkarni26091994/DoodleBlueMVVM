package com.doodleblue.application.ui.home

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.doodleblue.application.Adpater.Developer_CustomAdapter
import com.doodleblue.application.R
import com.doodleblue.application.model.DeveloperModel
import com.doodleblue.application.viewmodel.DeveloperViewModel
import com.google.android.material.appbar.MaterialToolbar
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    internal var activityMainBinding: HomeFragment? = null
    var mainViewModel: DeveloperViewModel? = null
    private var recyclerView:RecyclerView?=null
    private var mDeveloper_CustomAdapter: Developer_CustomAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val pricesToolbar = root.findViewById<MaterialToolbar>(R.id.pricesToolbar)
        val pricesToolbarTitle = root.findViewById<TextView>(R.id.toolbar_title)
        (activity as AppCompatActivity).setSupportActionBar(pricesToolbar)
        pricesToolbarTitle.text = "Prices"
        (activity as AppCompatActivity).supportActionBar?.setIcon(R.drawable.ic_baseline_dehaze_24)
        val swipeRefresh = root?.swipeRefresh
          recyclerView = root?.data_recycler_view!!
        recyclerView!!.setLayoutManager(LinearLayoutManager(context))
        recyclerView!!.setHasFixedSize(true)

        swipeRefresh?.setOnRefreshListener {
            mainViewModel!!.allDeveloper.observe(viewLifecycleOwner,
                Observer<List<Any>> { mDeveloperModel ->
                    ///if any thing chnage the update the UI
                    mDeveloper_CustomAdapter?.setDeveloperList(mDeveloperModel as ArrayList<DeveloperModel>)
                })
            swipeRefresh.isRefreshing = false
        }




        ///init the View Model
        mainViewModel = ViewModelProviders.of(this).get(DeveloperViewModel::class.java)

        //init the Custom adataper
        mDeveloper_CustomAdapter = Developer_CustomAdapter()
        //set the CustomAdapter
        recyclerView!!.setAdapter(mDeveloper_CustomAdapter)

        getAllDev()

        return root
    }
    private fun getAllDev() {
        ///get the list of dev from api response
        mainViewModel!!.allDeveloper.observe(viewLifecycleOwner,
            Observer<List<Any>> { mDeveloperModel ->
                ///if any thing chnage the update the UI
                mDeveloper_CustomAdapter?.setDeveloperList(mDeveloperModel as ArrayList<DeveloperModel>)
               })
       }
    
   }