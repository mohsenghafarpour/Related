package com.karafs.related.ui.user

import com.karafs.related.R
import com.karafs.related.base.BaseFragment
import com.karafs.related.databinding.FragmentUserBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserFragment : BaseFragment<UserViewModel, FragmentUserBinding>() {

    override val viewModel: UserViewModel by viewModel()

    override val layoutRes: Int = R.layout.fragment_user

    override fun configEvents() {
    }

    override fun bindObservables() {
    }

    override fun initBinding() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            vm = viewModel
            executePendingBindings()
        }
    }
}