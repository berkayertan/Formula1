package com.berkayertan.recycler.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.berkayertan.recycler.adapters.ConstructorAdapter
import com.berkayertan.recycler.databinding.ConstructorStandingFragmentBinding
import com.berkayertan.recycler.viewmodel.FirstViewModel
import io.reactivex.disposables.CompositeDisposable


class ConstructorStandingFragment : Fragment() {

    private lateinit var binding: ConstructorStandingFragmentBinding
    private lateinit var viewModel: FirstViewModel
    private val disposable = CompositeDisposable()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ConstructorStandingFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = ConstructorStandingFragmentBinding.bind(view)

        val adapter = ConstructorAdapter(emptyList())
        binding.constructorrc.adapter = adapter
        binding.constructorrc.layoutManager = LinearLayoutManager(requireContext())

        viewModel = ViewModelProvider(this).get(FirstViewModel::class.java)
        viewModel.constData()
        viewModel.constructors.observe(viewLifecycleOwner) { constructors ->
            adapter.setData(constructors)
        }

        viewModel.getConstDataFromAPI()


    }


    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }
}


