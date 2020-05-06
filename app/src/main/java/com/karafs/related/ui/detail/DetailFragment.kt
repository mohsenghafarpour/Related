package com.karafs.related.ui.detail

import com.karafs.related.R
import com.karafs.related.base.BaseFragment
import com.karafs.related.databinding.FragmentDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : BaseFragment<DetailViewModel, FragmentDetailBinding>() {

    override val viewModel: DetailViewModel by viewModel()

    override val layoutRes: Int = R.layout.fragment_detail

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