package oscar.c.pozas.android.feat.one

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import oscar.c.pozas.android.navigation.Navigator
import oscar.c.pozas.android.navigation.extension.observe

class FirstActivity : AppCompatActivity() {

    private val viewModel: FirstViewModel by viewModels()

    // This dependency could be satisfied by the injector (Not implemented in that example)
    private lateinit var navigatorProvider: Navigator.Provider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        configureObservables()
    }

    private fun configureObservables() {
        observe(viewModel.navigateTo) { screenEvent ->
            screenEvent.getContentIfNotHandled()?.let { screen ->
                navigatorProvider.get(screen).navigate(this@FirstActivity)
            }
        }
    }

    companion object {

        fun launch(activity: Activity) {
            val intent = Intent(activity, FirstActivity::class.java)
            activity.startActivity(intent)
        }
    }
}

object GoToFirstActivity : Navigator {

    override fun navigate(activity: Activity) { FirstActivity.launch(activity) }
}