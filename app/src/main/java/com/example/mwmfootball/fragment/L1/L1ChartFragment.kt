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
import com.example.mwmfootball.adapter.L1.L1ChartRecyclerAdapter
import com.example.mwmfootball.adapter.L1.L1TeamsRecyclerAdapter
import com.example.mwmfootball.databinding.FragmentL1TeamsBinding
import com.example.mwmfootball.databinding.ListChartL1Binding
import com.example.mwmfootball.model.Chart.PLChartModel
import com.example.mwmfootball.model.Chart.Table
import com.example.mwmfootball.model.Teams.Team
import com.example.mwmfootball.viewmodel.L1ViewModel.L1ChartViewModel


class L1ChartFragment : Fragment() {

    private lateinit var l1ChartRecyclerAdapter: L1ChartRecyclerAdapter
    private lateinit var l1ChartBinding : FragmentL1TeamsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val l1ChartViewModel : L1ChartViewModel by viewModels()
        l1ChartViewModel.getListL1ChartDataObserver().observe(this, Observer<PLChartModel?>{
            if (it != null) {
                val chartL1Info = it.standings
                l1ChartRecyclerAdapter.getL1ListChart(chartL1Info[0].table as ArrayList<Table>)
                l1ChartRecyclerAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(activity, "Error", Toast.LENGTH_SHORT).show()
            }
        })

        l1ChartViewModel.makeL1ChartDataCall()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        l1ChartBinding.rcvL1Teams.apply {
            layoutManager = LinearLayoutManager(context)
            l1ChartRecyclerAdapter = L1ChartRecyclerAdapter()
            adapter = l1ChartRecyclerAdapter
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        l1ChartBinding = FragmentL1TeamsBinding.inflate(inflater, container, false)
        return l1ChartBinding.root

    }
}