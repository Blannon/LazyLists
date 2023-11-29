package com.example.lazylists

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lazylists.ui.theme.LazyListsTheme

class MainActivity : ComponentActivity() {

    companion object{
        val items = listOf(
            Item(
                title ="@1",
                image = R.drawable.bmwi5
            ),
            Item(
                title ="@2",
                image = R.drawable.bmwix
            ),
            Item(
                title ="@3",
                image = R.drawable.bmwm3
            ),
            Item(
                title ="@4",
                image = R.drawable.bmwix
            ), Item(
                title ="@5",
                image = R.drawable.bmwi5
            ), Item(
                title ="@6",
                image = R.drawable.bmwm3
            ), Item(
                title ="@7",
                image = R.drawable.bmwix
            ), Item(
                title ="@8",
                image = R.drawable.bmwi5
            ),
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyListsTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background)
                {
                    val navHostController = rememberNavController()
                    NavHost(
                        navController = navHostController,
                        startDestination = "HomeScreen")
                    {
                        composable("HomeScreen"){
                            HomeScreen(navHostController = navHostController)
                        }
                        composable("Row_Screen"){
                            Row_Screen()
                        }
                        composable("Column_Screen"){
                            Column_Screen()
                        }
                        composable("Grid_Screen"){
                            Grid_Screen()
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun HomeScreen(
    navHostController: NavHostController
){
    Column(
        modifier =Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){

        Button(onClick = {navHostController.navigate("Row_Screen") }) {
            Text(
                text = "Row"
            )

        }

        Spacer(
            modifier = Modifier
                .height(38.dp)
        )

        Button(onClick = {navHostController.navigate("Column_Screen") }) {
            Text(
                text = "Column"
            )

        }

        Spacer(
            modifier = Modifier
                .height(38.dp)
        )

        Button(onClick = {navHostController.navigate("Grid_Screen") }) {
            Text(
                text = "Grid"
            )

        }

        Spacer(
            modifier = Modifier
                .height(38.dp)
        )
    }
}
