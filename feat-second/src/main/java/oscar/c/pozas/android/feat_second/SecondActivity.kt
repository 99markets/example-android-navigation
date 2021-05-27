package oscar.c.pozas.android.feat_second

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import oscar.c.pozas.android.navigation.Navigator
import oscar.c.pozas.android.navigation.extension.observe

class SecondActivity : AppCompatActivity() {

    private val viewModel: SecondViewModel by viewModels()

    // This dependency could be satisfied by the injector (Not implemented in that example)
    private lateinit var navigatorProvider: Navigator.Provider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        configureObservables()
    }

    private fun configureObservables() {
        observe(viewModel.navigateTo) { screenEvent ->
            screenEvent.getContentIfNotHandled()?.let { screen ->
                navigatorProvider.get(screen).navigate(this@SecondActivity)
            }
        }
    }

    companion object {

        fun launch(activity: Activity) {
            val intent = Intent(activity, SecondActivity::class.java)
            activity.startActivity(intent)
        }
    }
}

object GoToSecondActivity : Navigator {

    override fun navigate(activity: Activity) { SecondActivity.launch(activity) }
}