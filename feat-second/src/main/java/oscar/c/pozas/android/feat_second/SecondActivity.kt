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
        resolveArgs()
    }

    private fun configureObservables() {
        observe(viewModel.navigateTo) { screenEvent ->
            screenEvent.getContentIfNotHandled()?.let { screen ->
                navigatorProvider.get(screen).navigate(this@SecondActivity)
            }
        }
    }

    private fun resolveArgs() {
        val userId = intent.extras!!.getString(USER_ID_ARG) // Not used in the example
    }

    companion object {

        private const val USER_ID_ARG = "USER_ID_ARG"

        fun launch(activity: Activity, userId: String) {
            val intent = Intent(activity, SecondActivity::class.java).apply {
                putExtra(USER_ID_ARG, userId)
            }
            activity.startActivity(intent)
        }
    }
}

class GoToSecondActivity(private val userId: String) : Navigator {

    override fun navigate(activity: Activity) { SecondActivity.launch(activity, userId) }
}