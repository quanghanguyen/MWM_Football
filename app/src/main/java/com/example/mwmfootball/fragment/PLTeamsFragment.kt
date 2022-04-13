package com.example.mwmfootball.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mwmfootball.R
import com.example.mwmfootball.adapter.PLTeamsRecyclerAdapter
import com.example.mwmfootball.databinding.FragmentPLTeamsBinding
import com.example.mwmfootball.databinding.ListTeamsPlBinding
import com.example.mwmfootball.model.Teams.PLTeamsModel
import com.example.mwmfootball.model.Teams.Team
import com.example.mwmfootball.viewmodel.PLChartViewModel
import kotlinx.android.synthetic.main.fragment_p_l_teams.*


class PLTeamsFragment : Fragment() {

    private lateinit var plTeamsRecyclerAdapter: PLTeamsRecyclerAdapter
//    private lateinit var rcvBinding: FragmentPLTeamsBinding
//    private lateinit var teamsRecyclerView : RecyclerView
//    private lateinit var lstTeams : MutableList<Team>
//    private lateinit var adapter : PLTeamsRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        createData()

    }

    private fun createData() {
        val viewModel : PLChartViewModel by viewModels()
        viewModel.getListPLTeamsObserver().observe(this, Observer<PLTeamsModel?>{
            if (it != null) {
                plTeamsRecyclerAdapter.getlstTeams(it.teams as ArrayList<Team>)
                plTeamsRecyclerAdapter.notifyDataSetChanged()
            } else {
                //Toast.makeText(this@PLTeamsFragment, "Error", Toast.LENGTH_SHORT).show()
                Toast.makeText(activity, "Error", Toast.LENGTH_SHORT).show()
            }
        })

        viewModel.makeTeamsAPICall()
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_p_l_teams, container, false)

//        val rcvBinding = FragmentPLTeamsBinding.inflate(inflater, container, false)
//        val view =  rcvBinding.root
//
//        teamsRecyclerView = rcvBinding.rcvPLTeams
//        adapter = PLTeamsRecyclerAdapter()
//        teamsRecyclerView.layoutManager = LinearLayoutManager(activity)
//        teamsRecyclerView.adapter = adapter
//
//        return view
        val v = inflater.inflate(R.layout.fragment_p_l_teams, container, false)
        rcvPLTeams.apply {
            layoutManager = LinearLayoutManager(context)
            plTeamsRecyclerAdapter = PLTeamsRecyclerAdapter()
            adapter = plTeamsRecyclerAdapter
            return v
        }
    }
}