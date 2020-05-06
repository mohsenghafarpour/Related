package com.karafs.related.ui.ruler

import com.karafs.related.R
import com.karafs.related.base.BaseFragment
import com.karafs.related.databinding.FragmentRulerBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RulerFragment : BaseFragment<RulerViewModel, FragmentRulerBinding>() {

    override val viewModel: RulerViewModel by viewModel()

    override val layoutRes: Int = R.layout.fragment_ruler

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