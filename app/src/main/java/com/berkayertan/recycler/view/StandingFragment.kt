package com.berkayertan.recycler.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.berkayertan.recycler.adapters.StandingAdapter
import com.berkayertan.recycler.databinding.StandingFragmentBinding
import com.berkayertan.recycler.viewmodel.FirstViewModel
import io.reactivex.disposables.CompositeDisposable



class StandingFragment : Fragment() {

    private lateinit var binding: StandingFragmentBinding
    private lateinit var viewModel:FirstViewModel
    private val disposable = CompositeDisposable()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = StandingFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = StandingFragmentBinding.bind(view)


        val adapter = StandingAdapter(emptyList())
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())




        viewModel = ViewModelProvider(this).get(FirstViewModel::class.java)
        viewModel.refreshData()
        viewModel.drivers.observe(viewLifecycleOwner) { drivers ->
            adapter.setData(drivers)
        }

        viewModel.getDataFromAPI()

    }


    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }
    }




