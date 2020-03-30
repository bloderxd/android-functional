package bloder.com.albums.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import bloder.com.albums.R
import bloder.com.albums.databinding.AlbumsFragmentBinding
import bloder.com.albums.presentation.AlbumsViewModel

class AlbumsFragment : Fragment() {

    private lateinit var binding: AlbumsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.albums_fragment, null, false)
        val v = ViewModelProviders.of(this)[AlbumsViewModel::class.java]
        return binding.apply {
            lifecycleOwner = this@AlbumsFragment
            viewModel = v
            v.loadAlbums()
        }.root
    }
}