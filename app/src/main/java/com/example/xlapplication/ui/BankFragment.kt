package com.example.xlapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.xlapplication.R
import com.example.xlapplication.databinding.FragmentBankBinding
import com.example.xlapplication.databinding.FragmentEmployeeBinding
import com.example.xlapplication.databinding.FragmentPersonalBinding
import com.example.xlapplication.viewmodel.UserViewModel


class BankFragment : Fragment(R.layout.fragment_bank) {

    private lateinit var _binding : FragmentBankBinding
    private val binding get() = _binding

    private lateinit var viewModel: UserViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            _binding = FragmentBankBinding.bind(view)
            viewModel = (activity as MainActivity).hostViewModel

        binding.btSubmitEmployee.setOnClickListener {
            if(binding.tvBankName.text.isNotEmpty() &&
                    binding.tvBranchName.text.isNotEmpty() &&
                    binding.tvAccountNumber.text.isNotEmpty() &&
                    binding.tvIfscCode.text.isNotEmpty()){

                viewModel.insertData(null,viewModel.personalInfo[1]!!,viewModel.personalInfo[2]!!,
                    viewModel.personalInfo[3]!!,
                    viewModel.personalInfo[4]!!,viewModel.personalInfo[5]!!,viewModel.personalInfo[6]!!,
                    binding.tvBankName.text.toString(),
                    binding.tvBranchName.text.toString(),
                binding.tvAccountNumber.text.toString(),
                binding.tvIfscCode.text.toString())
                Toast.makeText(context,"Data added Successfully",Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_bankFragment_to_usersFragment)
            }
            else{
                Toast.makeText(context,"Please enter all details",Toast.LENGTH_SHORT).show()

            }
        }

    }

}