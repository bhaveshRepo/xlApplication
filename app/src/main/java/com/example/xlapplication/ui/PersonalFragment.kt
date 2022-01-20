package com.example.xlapplication.ui

import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.xlapplication.R
import com.example.xlapplication.databinding.FragmentPersonalBinding
import com.example.xlapplication.viewmodel.UserViewModel


class PersonalFragment : Fragment(R.layout.fragment_personal) {

    private lateinit var _binding : FragmentPersonalBinding
    private val binding get() = _binding

    private lateinit var viewModel: UserViewModel
    private lateinit var gender: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentPersonalBinding.bind(view)
        viewModel = (activity as MainActivity).hostViewModel


        binding.rbMale.setOnClickListener {
            gender = "Male"
        }

        binding.rbFemale.setOnClickListener {
            gender = "Female"
        }

        binding.btSubmit.setOnClickListener {

           try {
               if (emptyCheck(
                       binding.tvFirstName.text.toString(),
                       binding.tvLastName.text.toString(),
                       binding.tvPhoneNumber.text.toString(), gender
                   )
               ) {
                   viewModel.personInfoData(
                       binding.tvFirstName.text.toString(),
                       binding.tvLastName.text.toString(),
                       binding.tvPhoneNumber.text.toString(),
                       gender
                   )
                   findNavController().navigate(R.id.action_personalFragment_to_employeeFragment)
               } else {
                   Toast.makeText(context, "Please enter all details", Toast.LENGTH_SHORT).show()
               }
           } catch (e: Exception){
               Toast.makeText(context,"enter details",Toast.LENGTH_SHORT).show()
           }
        }
    }
    private fun emptyCheck(firstName: String, lastName: String, phone: String,gender : String): Boolean{
        var fName = firstName
        var lName = lastName
        var phone = phone
        var gender = gender

            return fName.isNotEmpty() && lName.isNotEmpty() && phone.isNotEmpty() && gender.isNotEmpty()
}
}