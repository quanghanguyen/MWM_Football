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
import com.example.mwmfootball.adapter.PL.PLChartRecyclerAdapter
import com.example.mwmfootball.databinding.FragmentPLChartBinding
import com.example.mwmfootball.model.Chart.PLChartModel
import com.example.mwmfootball.model.Chart.Table
import com.example.mwmfootball.viewmodel.PLViewModel.PLChartViewModel


class PLChartFragment : Fragment() {

    private lateinit var plChartRecyclerAdapter : PLChartRecyclerAdapter
    private lateinit var plchartBinding : FragmentPLChartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        createdPLChartData()

    }

    private fun createdPLChartData() {
        val plChartViewModel : PLChartViewModel by viewModels()
        plChartViewModel.getListChartObserver().observe(this, Observer<PLChartModel?>{
            if (it != null) {
                val chartInfo = it.standings
                plChartRecyclerAdapter.getlstChart(chartInfo[0].table as ArrayList<Table>)
                plChartRecyclerAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(activity, "Error", Toast.LENGTH_SHORT).show()
            }
        })

        plChartViewModel.makeChartAPICall()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        plchartBinding.rcvPLChart.apply {
            layoutManager = LinearLayoutManager(context)
            plChartRecyclerAdapter = PLChartRecyclerAdapter()
            adapter = plChartRecyclerAdapter
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        plchartBinding = FragmentPLChartBinding.inflate(inflater, container, false)
        return plchartBinding.root
    }

}