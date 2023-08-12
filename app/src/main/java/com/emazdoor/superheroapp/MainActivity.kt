package com.emazdoor.superheroapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.emazdoor.superheroapp.ui.components.SuperHeroItemView
import com.emazdoor.superheroapp.ui.theme.SuperHeroAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            data class Test( val title: String, val subTitle: String)
            val aList = remember{ mutableStateListOf<Test>() }
            aList.add(Test("harry", "potter"))
            aList.add(Test("ABC", "SDSF"))
            SuperHeroAppTheme {
                LazyColumn(){
                    items(aList){
                        SuperHeroItemView(title = it.title, subTitle = it.subTitle)
                    }

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    data class Test( val title: String, val subTitle: String)
    val aList = remember{ mutableStateListOf<Test>() }
    aList.add(Test("harry", "potter"))
    aList.add(Test("ABC", "SDSF"))
    SuperHeroAppTheme {
        LazyColumn(){
           items(aList){
               SuperHeroItemView(title = it.title, subTitle = it.subTitle)
           }

        }
    }
}