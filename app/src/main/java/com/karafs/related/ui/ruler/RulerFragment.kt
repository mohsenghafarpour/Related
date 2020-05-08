package com.karafs.related.ui.ruler

import com.karafs.related.R
import com.karafs.related.base.BaseFragment
import com.karafs.related.cv.MyRuler
import com.karafs.related.databinding.FragmentRulerBinding
import kotlinx.android.synthetic.main.fragment_ruler.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class RulerFragment : BaseFragment<RulerViewModel, FragmentRulerBinding>() {

    override val viewModel: RulerViewModel by viewModel()

    override val layoutRes: Int = R.layout.fragment_ruler

    override fun configEvents() {

        val ruler = MyRuler(context)
        ruler.isVertical = true
        root_view.addView(ruler)

        btn_type.setOnClickListener {
            ruler.isVertical = !ruler.isVertical
            when (ruler.isVertical) {
                true -> btn_type.text = resources.getString(R.string.horizontal)
                false -> btn_type.text = resources.getString(R.string.vertical)
            }
        }

        btn_unit.setOnClickListener {
            ruler.isInch = !ruler.isInch
            when (ruler.isInch) {
                true -> btn_unit.text = resources.getString(R.string.cm)
                false -> btn_unit.text = resources.getString(R.string.inch)
            }
        }


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