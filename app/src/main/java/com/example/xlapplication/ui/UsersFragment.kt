package com.example.xlapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.xlapplication.R
import com.example.xlapplication.adapter.UserAdapter
import com.example.xlapplication.databinding.FragmentBankBinding
import com.example.xlapplication.databinding.FragmentEmployeeBinding
import com.example.xlapplication.databinding.FragmentPersonalBinding
import com.example.xlapplication.databinding.FragmentUsersBinding
import com.example.xlapplication.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_users.*


class UsersFragment : Fragment(R.layout.fragment_users) {

    private lateinit var _binding : FragmentUsersBinding
    private val binding get() = _binding
    private lateinit var userAdapter: UserAdapter

    private lateinit var viewModel: UserViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            _binding = FragmentUsersBinding.bind(view)
            viewModel = (activity as MainActivity).hostViewModel
            setUpRecyclerView()


//        userAdapter.setOnItemClickListener {
//            val bundle = Bundle().apply {
//                putSerializable("info",it)
//            }
////            findNavController().navigate(R.id.action_usersFragment_to_personalFragment,bundle)
//        }

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_usersFragment_to_personalFragment)
        }

        viewModel.getUserData().observe(viewLifecycleOwner, Observer {
                userAdapter.differ.submitList(it)
        })

    }

    private fun setUpRecyclerView() {
        userAdapter = UserAdapter()
        binding.rvUsers.apply {
            adapter = userAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

}