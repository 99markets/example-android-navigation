package oscar.c.pozas.android.navigation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import oscar.c.pozas.android.navigation.livedata.Event

class HomeViewModel : ViewModel() {

    val navigateTo = MutableLiveData<Event<Screen>>()

    fun onNavigateButtonClick() {
        navigateTo.value = Event(Screen.FeatOneScreen)
    }
}