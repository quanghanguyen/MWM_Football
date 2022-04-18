package com.example.mwmfootball.fragment.SA

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mwmfootball.R
import com.example.mwmfootball.adapter.SA.SATeamsRecyclerAdapter
import com.example.mwmfootball.databinding.FragmentSATeamsBinding
import com.example.mwmfootball.model.Teams.PLTeamsModel
import com.example.mwmfootball.model.Teams.Team
import com.example.mwmfootball.viewmodel.SA.SATeamsViewModel

class SATeamsFragment : Fragment() {

    private lateinit var saTeamsRecyclerAdapter: SATeamsRecyclerAdapter
    private lateinit var rcvSATeamsBinding: FragmentSATeamsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val saTeamsViewModel : SATeamsViewModel by viewModels()
        saTeamsViewModel.getListSATeamsDataObserver().observe(this, Observer<PLTeamsModel?>{
            if (it != null) {
                saTeamsRecyclerAdapter.getlstSATeams(it.teams as ArrayList<Team>)
                saTeamsRecyclerAdapter.notifyDataSetChanged()

                rcvSATeamsBinding.pbSATeams.visibility = View.GONE
                rcvSATeamsBinding.rcvSATeams.visibility = View.VISIBLE
            }
        })

        saTeamsViewModel.makeSAListAPICall()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rcvSATeamsBinding.rcvSATeams.apply {
            layoutManager = LinearLayoutManager(context)
            saTeamsRecyclerAdapter = SATeamsRecyclerAdapter()
            adapter = saTeamsRecyclerAdapter
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rcvSATeamsBinding = FragmentSATeamsBinding.inflate(inflater, container, false)
        return rcvSATeamsBinding.root
    }
}