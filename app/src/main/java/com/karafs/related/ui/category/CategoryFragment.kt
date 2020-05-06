package com.karafs.related.ui.category

import com.karafs.related.R
import com.karafs.related.base.BaseFragment
import com.karafs.related.databinding.FragmentCategoryBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CategoryFragment : BaseFragment<CategoryViewModel, FragmentCategoryBinding>() {

    override val viewModel: CategoryViewModel by viewModel()

    override val layoutRes: Int = R.layout.fragment_category

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