package com.geekstudio.composetest.utils

import android.os.Build
import android.text.Html

object Util {

    /**
     *
     */
    fun decodingHtml(htmlString: String): String {
        return if (Build.VERSION.SDK_INT >= 24) {
            Html.fromHtml(htmlString, Html.FROM_HTML_MODE_LEGACY).toString()
        } else {
            Html.fromHtml(htmlString).toString()
        }
    }
}