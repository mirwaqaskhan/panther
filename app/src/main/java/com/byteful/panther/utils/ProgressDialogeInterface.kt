package com.byteful.panther.utils

/**
 * @author Ehtisham haq
 */
internal interface ProgressDialogeInterface {

    fun showLoading()

    fun hideLoading()

    fun loadError(e: Throwable)

    fun loadError(msg: String)

}