package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeListViewModel

/**
 * @author Kulbaka Nataly
 * @date 14.08.2021
 */
class ShoeDetailFragment : Fragment() {

    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_detail, container, false
        )
        binding.lifecycleOwner = this
        binding.shoe = Shoe("", 0.0, "", "")
        binding.viewModel = viewModel
        binding.cancelButton.setOnClickListener {
            findNavController().navigateUp()
        }
        viewModel.state.observe(this as LifecycleOwner, Observer {
            if (it) {
                findNavController().navigateUp()
            }
        })
        return binding.root
    }
}