package oscar.c.pozas.android.navigation.provider

import oscar.c.pozas.android.feat.one.GoToFirstActivity
import oscar.c.pozas.android.feat_second.GoToSecondActivity
import oscar.c.pozas.android.navigation.GoToHomeScreen
import oscar.c.pozas.android.navigation.Navigator
import oscar.c.pozas.android.navigation.Screen

class DefaultNavigatorProvider : Navigator.Provider {

    override fun get(screen: Screen): Navigator = when (screen) {
        is Screen.HomeScreen -> GoToHomeScreen
        is Screen.FeatOneScreen -> GoToFirstActivity
        is Screen.FeatTwoScreen -> GoToSecondActivity(screen.userId)
    }
}