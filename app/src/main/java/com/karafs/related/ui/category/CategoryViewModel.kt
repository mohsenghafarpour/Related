package com.karafs.related.ui.category

import com.karafs.related.base.BaseViewModel

class CategoryViewModel : BaseViewModel() {

    fun goToRelated() {
        navigateTo(CategoryFragmentDirections.actionCategoryToUser())
    }

    fun goToRuler() {
        navigateTo(CategoryFragmentDirections.actionCategoryToRuler())
    }
}