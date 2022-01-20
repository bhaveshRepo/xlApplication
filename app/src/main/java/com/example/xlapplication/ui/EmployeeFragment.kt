package com.example.xlapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.xlapplication.R
import com.example.xlapplication.databinding.FragmentEmployeeBinding
import com.example.xlapplication.databinding.FragmentPersonalBinding
import com.example.xlapplication.viewmodel.UserViewModel


class EmployeeFragment : Fragment(R.layout.fragment_employee) {

    private lateinit var _binding : FragmentEmployeeBinding
    private val binding get() = _binding

    private lateinit var viewModel: UserViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            _binding = FragmentEmployeeBinding.bind(view)
            viewModel = (activity as MainActivity).hostViewModel

            binding.btSubmitEmployee.setOnClickListener {
                if(binding.tvEmployeeNumber.text.isNotEmpty() && binding.tvEmployeeName.text.isNotEmpty()){

                    viewModel.employeeData(binding.tvEmployeeNumber.text.toString(),
                                            binding.tvEmployeeName.text.toString())
                    findNavController().navigate(R.id.action_employeeFragment_to_bankFragment)

                } else{
                    Toast.makeText(context,"Please enter all details",Toast.LENGTH_SHORT).show()
                }
            }



    }


}