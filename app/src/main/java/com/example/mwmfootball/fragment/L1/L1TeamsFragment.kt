package com.example.mwmfootball.fragment.L1

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
import com.example.mwmfootball.adapter.L1.L1TeamsRecyclerAdapter
import com.example.mwmfootball.databinding.FragmentL1TeamsBinding
import com.example.mwmfootball.model.Teams.PLTeamsModel
import com.example.mwmfootball.model.Teams.Team
import com.example.mwmfootball.viewmodel.L1ViewModel.L1TeamsViewModel

class L1TeamsFragment : Fragment() {

    private lateinit var l1TeamsRecyclerAdapter: L1TeamsRecyclerAdapter
    private lateinit var rcvL1Binding : FragmentL1TeamsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val l1TeamsViewModel : L1TeamsViewModel by viewModels()
        l1TeamsViewModel.getListL1TeamsDataObserver().observe(this, Observer<PLTeamsModel?>{
            if (it != null) {
                l1TeamsRecyclerAdapter.getlstL1Teams(it.teams as ArrayList<Team>)
                l1TeamsRecyclerAdapter.notifyDataSetChanged()

                rcvL1Binding.pbL1Teams.visibility = View.GONE
                rcvL1Binding.rcvL1Teams.visibility = View.VISIBLE
            } else {
                Toast.makeText(activity, "Error", Toast.LENGTH_SHORT).show()
            }
        })

        l1TeamsViewModel.makeL1TeamsCallAPI()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rcvL1Binding.rcvL1Teams.apply {
            layoutManager = LinearLayoutManager(context)
            l1TeamsRecyclerAdapter = L1TeamsRecyclerAdapter()
            adapter = l1TeamsRecyclerAdapter
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rcvL1Binding = FragmentL1TeamsBinding.inflate(inflater, container, false)
        return rcvL1Binding.root
    }

}