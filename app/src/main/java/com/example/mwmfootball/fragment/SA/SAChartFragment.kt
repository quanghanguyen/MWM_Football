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
import com.example.mwmfootball.adapter.SA.SAChartRecyclerAdapter
import com.example.mwmfootball.databinding.FragmentSATeamsBinding
import com.example.mwmfootball.model.Chart.PLChartModel
import com.example.mwmfootball.model.Chart.Table
import com.example.mwmfootball.viewmodel.SA.SAChartViewModel


class SAChartFragment : Fragment() {

    private lateinit var saChartRecyclerAdapter: SAChartRecyclerAdapter
    private lateinit var saChartBinding: FragmentSATeamsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val saChartViewModel : SAChartViewModel by viewModels()
        saChartViewModel.getListSAChartDataObserver().observe(this, Observer<PLChartModel?>{
            if (it != null) {
                val saChartInfo = it.standings
                saChartRecyclerAdapter.getListSAChart(saChartInfo[0].table as ArrayList<Table>)
                saChartRecyclerAdapter.notifyDataSetChanged()

                saChartBinding.pbSATeams.visibility = View.GONE
                saChartBinding.rcvSATeams.visibility = View.VISIBLE
            }
        })

        saChartViewModel.makeSAChartAPICall()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        saChartBinding.rcvSATeams.apply {
            layoutManager = LinearLayoutManager(context)
            saChartRecyclerAdapter = SAChartRecyclerAdapter()
            adapter = saChartRecyclerAdapter
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_s_a_chart, container, false)
        saChartBinding = FragmentSATeamsBinding.inflate(inflater, container, false)
        return saChartBinding.root
    }

}