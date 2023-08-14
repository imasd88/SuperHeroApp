package com.emazdoor.superheroapp

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}

/*Since Compose is a declarative UI framework, the above code can be simplified as well
* instead of using Fragments and Navigation we could have used Compose directly instead.
* Handling navigation of SuperHeroListScreen and SuperHeroDetailsScreen could have been done
* directly using Compose with Activity.
* Eliminating the need of Fragments and Navigation completely.
* Something like this
* @Composable
fun MainActivity() {
  val navController = rememberNavController()
  MaterialApp(
    startDestination = "home",
    navController = navController
  ) {
    NavHost(navController = navController, startDestination = "superheroList") {
      composable("superheroList") { SuperHeroListScreen(navController = navController) }
      composable("superheroDetails") { SuperHeroDetailsScreen() }
    }
  }
}
* @Composable
fun SuperHeroListScreen(navController: NavController) {
  Text("This is the Super Hero List Screen")
  Button(onClick = { navController.navigate("superheroDetails") }) {
    Text("Super Hero List Screen")
  }
}
* */