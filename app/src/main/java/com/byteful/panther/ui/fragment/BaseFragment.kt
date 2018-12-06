package com.byteful.panther.ui.fragment

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.byteful.panther.ui.bases.BaseActivity
import com.byteful.panther.utils.ProgressDialogeInterface

public abstract class BaseFragment<T:ViewDataBinding>:Fragment(), ProgressDialogeInterface {

    protected abstract fun getLayoutId(): Int
    protected lateinit var viewDataBinding: T




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)

        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showed()
    }

    override fun onResume() {
        super.onResume()
        resume()
    }

    override fun onPause() {
        super.onPause()
        pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        remove()
    }


    protected open fun showed() {}

    protected open fun resume() {}

    protected open fun pause() {}

    protected open fun hide() {}

    protected open fun remove() {}



    /**
     * Methods for Progress Dialoge
     */

    override fun showLoading() {

        if(activity!=null && activity is BaseActivity<*>){
            (activity as BaseActivity<*>).showLoading()
        }
    }

    override fun hideLoading() {
        if(activity!=null && activity is BaseActivity<*>){
            (activity as BaseActivity<*>).hideLoading()
        }
    }

    override fun loadError(e: Throwable) {
        if(activity!=null && activity is BaseActivity<*>){
            (activity as BaseActivity<*>).loadError(e.localizedMessage)
        }
    }

    override fun loadError(msg: String) {
        if(activity!=null && activity is BaseActivity<*>){
            (activity as BaseActivity<*>).loadError(msg)
        }
    }

}