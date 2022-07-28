package com.jieun.weather.base

import android.app.Dialog
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.lifecycleScope
import com.jieun.weather.R
import com.jieun.weather.databinding.DialogLoadingBinding
import java.util.Stack

abstract class BaseActivity<VDB : ViewDataBinding>(
    @LayoutRes private val layoutResourceId: Int
) : AppCompatActivity() {

    protected lateinit var binding: VDB

    private var loadingDialog: Dialog? = null
    private var ladingCnt = 0
    private var loadingStack = Stack<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        binding = DataBindingUtil.setContentView<VDB>(this, layoutResourceId).apply {
            lifecycleOwner = this@BaseActivity
        }
    }

    fun setupLoadingObserver(vararg viewModels: BaseViewModel) {
        lifecycleScope.launchWhenStarted {
            viewModels.forEach { viewModel ->
                viewModel.loadingState.loading.observe(this@BaseActivity) {
                    if (it) showLoading() else hideLoading()
                }
            }
        }
    }

    fun showLoading() {
        if (loadingDialog == null) {
            loadingDialog = BaseDialog<DialogLoadingBinding>(
                context = this,
                layoutResourceId = R.layout.dialog_loading,
                enableDim = false
            )
        }

        if (loadingDialog?.isShowing == false && !isFinishing
        ) {
            loadingDialog?.show()
        }

        loadingStack.push(ladingCnt++)
    }

    fun hideLoading() {
        if (!loadingStack.isEmpty()) loadingStack.pop()

        if (loadingStack.isEmpty()) loadingDialog?.dismiss()
    }

    fun closeAllLoading() {
        while (loadingStack.isNotEmpty()) {
            hideLoading()
        }
    }
}
