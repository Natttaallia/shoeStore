package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
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

        binding.cancelButton.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.saveButton.setOnClickListener {
            viewModel.onSave(
                binding.nameEt.text.toString(),
                binding.sizeEt.text.toString(),
                binding.companyEt.text.toString(),
                binding.descriptionEt.text.toString()
            )
            findNavController().navigateUp()
        }
        return binding.root
    }
}