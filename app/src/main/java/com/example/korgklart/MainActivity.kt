/*
 * TODO – KORGKLART | EXAMINATION 1
 *
 [x] 1. Skapa Androidprojekt och koppla till GitHub.
 [x] 2. Skapa data class GroceryItem med minst tre egenskaper.
 [x] 3. Skapa ShoppingViewModel som hanterar inköpslistan.
 [ ] 4. Skapa appens gränssnitt med Material 3 och tema.
 [ ] 5. Lägg till TextField, kategorival och Button.
 [ ] 6. Visa inköpslistan med LazyColumn.
 [ ] 7. Lägg till funktion för att markera varor som inköpta.
 [ ] 8. Lägg till funktioner för att redigera och ta bort varor.
 [ ] 9. Visa statistik och hjälptext när listan är tom.
 [ ] 10. Testa, felsök med Logcat och färdigställ README.
 * GIT: Gör minst 5 tydliga commits under utvecklingen.
 */
package com.example.korgklart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.korgklart.ui.theme.KorgklartTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KorgklartTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KorgklartTheme {
        Greeting("Android")
    }
}