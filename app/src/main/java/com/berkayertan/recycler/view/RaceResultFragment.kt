package com.berkayertan.recycler.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.berkayertan.recycler.adapters.RaceResultAdapter
import com.berkayertan.recycler.databinding.RaceResultFragmentBinding
import com.berkayertan.recycler.viewmodel.FirstViewModel
import io.reactivex.disposables.CompositeDisposable

class RaceResultFragment : Fragment() {

    private lateinit var binding: RaceResultFragmentBinding
    private lateinit var viewModel: FirstViewModel
    private val disposable = CompositeDisposable()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = RaceResultFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = RaceResultFragmentBinding.bind(view)

        val adapter = RaceResultAdapter(emptyList())
        binding.resultrcview.adapter = adapter
        binding.resultrcview.layoutManager = LinearLayoutManager(requireContext())

        viewModel = ViewModelProvider(this).get(FirstViewModel::class.java)
        viewModel.resultData()
        viewModel.results.observe(viewLifecycleOwner) { results ->
            adapter.setData(results)
        }

        viewModel.getRaceResultsDataFromAPI()
    }
    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }
}