package com.karafs.related.ui.user

import com.karafs.related.R
import com.karafs.related.base.BaseFragment
import com.karafs.related.databinding.FragmentUserBinding
import kotlinx.android.synthetic.main.fragment_user.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserFragment : BaseFragment<UserViewModel, FragmentUserBinding>() {

    override val viewModel: UserViewModel by viewModel()
    private val adapter: UserAdapter by inject()

    override val layoutRes: Int = R.layout.fragment_user

    override fun configEvents() {
        list_user.adapter = adapter
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