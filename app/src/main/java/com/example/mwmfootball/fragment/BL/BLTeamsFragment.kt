package com.example.mwmfootball.fragment.BL

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mwmfootball.R
import com.example.mwmfootball.adapter.BL.BLTeamsRecyclerAdapter
import com.example.mwmfootball.databinding.FragmentBLTeamsBinding
import com.example.mwmfootball.model.PLHomeData
import com.example.mwmfootball.model.Teams.PLTeamsModel
import com.example.mwmfootball.model.Teams.Team
import com.example.mwmfootball.viewmodel.BLViewModel.BLTeamsViewModel


class BLTeamsFragment : Fragment() {

    private lateinit var blTeamsRecyclerAdapter: BLTeamsRecyclerAdapter
    private lateinit var rcvBLTeamsBinding: FragmentBLTeamsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val blTeamsViewModel : BLTeamsViewModel by viewModels()
        blTeamsViewModel.getListBLTeamsDataObserver().observe(this, Observer<PLTeamsModel?>{
            if (it != null) {
                blTeamsRecyclerAdapter.getListBLTeams(it.teams as ArrayList<Team>)
                blTeamsRecyclerAdapter.notifyDataSetChanged()

                rcvBLTeamsBinding.pbBLTeams.visibility = View.GONE
                rcvBLTeamsBinding.rcvBLTeams.visibility = View.VISIBLE
            } else {
                Toast.makeText(activity, "Error", Toast.LENGTH_SHORT).show()
            }
        })

        blTeamsViewModel.makeBLTeamsAPICall()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rcvBLTeamsBinding.rcvBLTeams.apply {
            layoutManager = LinearLayoutManager(context)
            blTeamsRecyclerAdapter = BLTeamsRecyclerAdapter()
            adapter = blTeamsRecyclerAdapter
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rcvBLTeamsBinding = FragmentBLTeamsBinding.inflate(inflater, container, false)
        return rcvBLTeamsBinding.root
    }
}