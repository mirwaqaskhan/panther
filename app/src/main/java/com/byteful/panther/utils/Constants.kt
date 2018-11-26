package com.byteful.panther.utils

/**
 * @author Ehtisham haq
 * Object to contain all the constants
 */
object Constants{

    const val isNetwork="isNetwork"

    const val isDebug=true
    const val DemoEndURL="https://bal-playlist-manager-dev.herokuapp.com/api/"

    const val LiveEndURL="https://bal-playlist-manager-dev.herokuapp.com/api/"

    val EndURL=if(isDebug) DemoEndURL else LiveEndURL

}