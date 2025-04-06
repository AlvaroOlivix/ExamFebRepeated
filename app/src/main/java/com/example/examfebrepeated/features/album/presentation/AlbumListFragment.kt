package com.example.examfebrepeated.features.album.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examfebrepeated.R
import com.example.examfebrepeated.databinding.FragmentAlbumListBinding
import com.example.examfebrepeated.features.album.presentation.adapter.AlbumAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class AlbumListFragment : Fragment() {

    private var _binding: FragmentAlbumListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AlbumListViewModel by viewModel()
    private lateinit var adapter: AlbumAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAlbumListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = AlbumAdapter(
            onClick = { navigateToAlbumDetail(it.id) },
            bookMark = {
                viewModel.toggleFavorite(it)
            })
        setUpRecyclerView()
        setUpObserver()
        viewModel.getAlbums()
        setToolBar()
    }

    private fun setUpRecyclerView() {

        //Pautas de como se organiza la pantalla
        binding.albumList.layoutManager = LinearLayoutManager(
            requireContext(), LinearLayoutManager.VERTICAL, false
        )
        //De donde recibirá la información, que elmentos mostrar y como se debe ver.
        binding.albumList.adapter = adapter
    }

    private fun setUpObserver() {
        val observer = Observer<AlbumListViewModel.UiState> { state ->
            //Verifica si carga
            if (state.loading) {
                Log.d("@dev", "Cargando datos")
            }
            //Comprueba si hay algún error
            if (state.error) {
                Log.d("@dev", "Ha habido un error en la recogida de datos")
            }
            //Actualiza la lista
            adapter.submitList(state.albums)
        }
        viewModel.uiState.observe(viewLifecycleOwner, observer)
    }

    private fun navigateToAlbumDetail(albumId: String) {
        findNavController().navigate(AlbumListFragmentDirections.actionListAlbumsToListCards(albumId))
    }

    private fun setToolBar() {
        binding.Atoolbar.mainToolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.action_bookmark -> {
                    viewModel.showFavorites()
                    item.setIcon(R.drawable.baseline_bookmark_24)
                    true
                } else -> false
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}