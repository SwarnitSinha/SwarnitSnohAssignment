package com.example.swarnitsnohassignment.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.swarnitsnohassignment.R
import com.example.swarnitsnohassignment.database.TheProject
import com.example.swarnitsnohassignment.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    lateinit var viewModel : HomeViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val saveBtn : Button= binding.addBtn
        saveBtn.setOnClickListener { addData() }

        val deleteBtn : Button = binding.deleteBtn
        deleteBtn.setOnClickListener { deleteAll() }
/*IMPORTANT
        Instantiate viewModel and recyclerview adapter then fetch
       data from viewModel and send it to the adapter
*/
        //RVAdapter
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)

        val adapter = RVAdapter(context)
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        viewModel.allProjects.observe(viewLifecycleOwner,{list->
            list?.let{
                adapter.updateList(it)
            }

        })

        return root
    }

    private fun deleteAll() {
        viewModel.delete()
    }

    private fun addData() {
        val data = "Something is added"
        viewModel.insert(TheProject(data))

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}