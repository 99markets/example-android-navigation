package oscar.c.pozas.android.feat_second

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import oscar.c.pozas.android.navigation.Screen
import oscar.c.pozas.android.navigation.livedata.Event

class SecondViewModel : ViewModel() {

    val navigateTo = MutableLiveData<Event<Screen>>()

    fun onButtonClicks() {
        navigateTo.value = Event(Screen.HomeScreen)
    }
}