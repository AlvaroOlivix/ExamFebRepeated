package com.example.examfebrepeated.features.album.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examfebrepeated.databinding.FragmentCardsListBinding
import com.example.examfebrepeated.features.album.presentation.adapterCard.CardAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class CardsListFragment : Fragment() {

    private var _binding: FragmentCardsListBinding? = null
    private val binding get() = _binding!!

    private val args: CardsListFragmentArgs by navArgs()

    private val viewModel: CardsListViewModel by viewModel()
    private lateinit var adapter: CardAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCardsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = CardAdapter()
        setToolBar()
        setUpRecycler()
        setUpObserver()
        viewModel.loadCards(args.albumId.toString())
    }

    private fun setUpRecycler() {
        binding.cardsList.layoutManager =
            LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL,
                false
            )
        binding.cardsList.adapter = adapter
    }

    private fun setUpObserver() {
        val observer = Observer<CardsListViewModel.UiState> { state ->
            if (state.loading) {
                Log.d("@dev", "Mensaje cuando carga")
            }
            if (state.error) {
                Log.d("@dev", "Mensaje cuando salta un error")
            }
            adapter.submitList(state.album?.cards)
        }
        viewModel.uiState.observe(viewLifecycleOwner, observer)

    }

    private fun setToolBar() {
        binding.Ptoolbar.mainToolbar.apply {
            setNavigationOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}