package com.jesustrejo10.simplerssreader.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.jesustrejo10.simplerssreader.R

class LoadingDialogFragment : DialogFragment(),
    LoadingDialogControl {

    companion object {
        const val DIALOG_TAG = "loading_dialog"
    }

    var isShowing: Boolean = false

    override fun showDialogFragment(fragmentManager: FragmentManager) {
        val fragment = fragmentManager.findFragmentByTag(DIALOG_TAG)
        if (fragment != null) {
            if (!this.isAdded)
                this.show(fragmentManager,
                    DIALOG_TAG
                )
        } else {
            if (!this.isAdded)
                this.show(fragmentManager,
                    DIALOG_TAG
                )
        }
    }

    override fun dismissDialogFragment() {
        try {
            this.dismiss()
        } catch (e: Exception) {
            println("Dialog already dimissed")
        }

        isShowing = false
    }

    override fun show(manager: FragmentManager, tag: String?) {
        super.show(manager,
            DIALOG_TAG
        )
        isShowing = true
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.dialog_loading, container)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
        isCancelable = false
    }
}