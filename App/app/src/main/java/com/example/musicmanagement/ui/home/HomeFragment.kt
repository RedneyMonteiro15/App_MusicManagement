package com.example.musicmanagement.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musicmanagement.Adapter.AdapterCardHome
import com.example.musicmanagement.Adapter.AdapterHomeMusic
import com.example.musicmanagement.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private lateinit var recyclerView : RecyclerView
    private lateinit var adapter : AdapterHomeMusic

    private lateinit var recyclerViewCard1 : RecyclerView
    private lateinit var adapterCard : AdapterCardHome



    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        recyclerView = binding.recyclerViewMusicHome
        adapter = AdapterHomeMusic()

        recyclerView.isClickable = true
        recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        recyclerView.adapter = adapter


        recyclerViewCard1 = binding.recyclerViewCardHome1
        adapterCard = AdapterCardHome()

        recyclerViewCard1.isClickable = true
        recyclerViewCard1.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        recyclerViewCard1.adapter = adapterCard







        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}