package oscar.c.pozas.android.navigation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import oscar.c.pozas.android.navigation.extension.observe

class HomeActivity : AppCompatActivity() {

    private val viewModel: HomeViewModel by viewModels()

    // This dependency could be satisfied by the injector (Not implemented in that example)
    private lateinit var navigatorProvider: Navigator.Provider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configureObservables()
    }

    private fun configureObservables() {
        observe(viewModel.navigateTo) { screenEvent ->
            screenEvent.getContentIfNotHandled()?.let { screen ->
                navigatorProvider.get(screen).navigate(this@HomeActivity)
            }
        }
    }

    companion object {

        fun launch(activity: Activity) {
            val intent = Intent(activity, HomeActivity::class.java)
            activity.startActivity(intent)
        }
    }
}

object GoToHomeScreen : Navigator {

    override fun navigate(activity: Activity) { HomeActivity.launch(activity) }
}
