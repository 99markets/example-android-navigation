package oscar.c.pozas.android.navigation

import android.app.Activity

interface Navigator {

    fun navigate(activity: Activity)

    interface Provider {

        fun get(screen: Screen): Navigator
    }
}

sealed class Screen {

    object HomeScreen : Screen()
    object FeatOneScreen : Screen()
    class FeatTwoScreen(userId: String) : Screen()
}