package com.example.mwmfootball.fragment.BL

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mwmfootball.R
import com.example.mwmfootball.adapter.BL.BLChartRecyclerAdapter
import com.example.mwmfootball.adapter.L1.L1ChartRecyclerAdapter
import com.example.mwmfootball.databinding.FragmentBLChartBinding
import com.example.mwmfootball.model.Chart.PLChartModel
import com.example.mwmfootball.model.Chart.Table
import com.example.mwmfootball.viewmodel.BLViewModel.BLChartViewModel


class BLChartFragment : Fragment() {

    private lateinit var blRecyclerAdapter: BLChartRecyclerAdapter
    private lateinit var rcvBLBinding : FragmentBLChartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val blChartViewModel : BLChartViewModel by viewModels()
        blChartViewModel.getListBLChartDataObserver().observe(this, Observer<PLChartModel?>{
            if (it != null) {
                val blChartInfo = it.standings
                blRecyclerAdapter.getBLListChart(blChartInfo[0].table as ArrayList<Table>)
                blRecyclerAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(activity, "Error", Toast.LENGTH_SHORT).show()
            }
        })

        blChartViewModel.makeBLChartCall()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rcvBLBinding.rcvBLChart.apply {
            layoutManager = LinearLayoutManager(context)
            blRecyclerAdapter = BLChartRecyclerAdapter()
            adapter = blRecyclerAdapter
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rcvBLBinding = FragmentBLChartBinding.inflate(inflater, container, false)
        return rcvBLBinding.root
    }
}