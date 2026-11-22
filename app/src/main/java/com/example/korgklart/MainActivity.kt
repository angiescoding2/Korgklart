/*
 * TODO – KORGKLART | EXAMINATION 1
 *
 [x] 1. Skapa Androidprojekt och koppla till GitHub.
 [x] 2. Skapa data class GroceryItem med minst tre egenskaper.
 [x] 3. Skapa ShoppingViewModel som hanterar inköpslistan.
 [] 4. Skapa appens gränssnitt med Material 3 och tema.
 [x] 5. Lägg till TextField, kategorival och Button.
 [ ] 6. Visa inköpslistan med LazyColumn.
 [ ] 7. Lägg till funktion för att markera varor som inköpta.
 [ ] 8. Lägg till funktioner för att redigera och ta bort varor.
 [ ] 9. Visa statistik och hjälptext när listan är tom.
 [ ] 10. Testa, felsök med Logcat och färdigställ README.
 * GIT: Gör minst 5 tydliga commits under utvecklingen.
 */


package com.example.korgklart

// Importerar klasser som behövs för att starta Android-appen.
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

// Importerar komponenter för appens gränssnitt.
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Importerar appens tema.
import com.example.korgklart.ui.theme.KorgklartTheme
// Komponenter för formulär och kategorival.
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
// Används för komponenter som fyller bredden och Material 3-menyn.
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api

// MainActivity är den första Activity som startas när appen öppnas.
class MainActivity : ComponentActivity() {

    // onCreate körs när Activity skapas.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Gör att appens innehåll kan ritas bakom systemfält.
        enableEdgeToEdge()

        // Bestämmer vilket gränssnitt appen ska visa.
        setContent {

            // Använder Korgklarts färger och Material 3-tema.
            KorgklartTheme {

                // Scaffold skapar en grundstruktur för appens skärm.
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    // Visar vår egen huvudsida med rätt marginaler.
                    ShoppingScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// Skapar Korgklarts huvudsida med Jetpack Compose.

// Skapar Korgklarts huvudsida.
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingScreen(modifier: Modifier = Modifier) {

    // Sparar texten som användaren skriver.
    var itemName by remember { mutableStateOf("") }

    // Skapar kategorierna som användaren kan välja mellan.
    val categories = listOf(
        "Frukt & grönt",
        "Mejeri",
        "Kött & fisk",
        "Skafferi",
        "Övrigt"
    )

    // Sparar den valda kategorin.
    var selectedCategory by remember {
        mutableStateOf(categories.first())
    }

    // Håller reda på om kategorimenyn är öppen.
    var expanded by remember { mutableStateOf(false) }

    // Placerar komponenterna under varandra.
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        // Visar appens namn.
        Text(
            text = "Korgklart",
            style = MaterialTheme.typography.headlineMedium
        )

        // Visar en kort beskrivning.
        Text(
            text = "Din inköpslista",
            style = MaterialTheme.typography.bodyMedium
        )

        // Skapar avstånd mellan rubrik och formulär.
        Spacer(modifier = Modifier.height(24.dp))

        // Textfält där användaren skriver varans namn.
        OutlinedTextField(
            value = itemName,
            onValueChange = { itemName = it },
            label = { Text("Varans namn") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        // Skapar avstånd mellan textfält och kategorival.
        Spacer(modifier = Modifier.height(12.dp))

        // Skapar en meny för kategorival.
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = it }
        ) {

            // Visar den valda kategorin.
            OutlinedTextField(
                value = selectedCategory,
                onValueChange = {},
                readOnly = true,
                label = { Text("Kategori") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(
                        expanded = expanded
                    )
                },
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
            )

            // Visar alla kategorier när menyn öppnas.
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {

                // Skapar ett menyval för varje kategori.
                categories.forEach { category ->
                    DropdownMenuItem(
                        text = { Text(category) },
                        onClick = {
                            selectedCategory = category
                            expanded = false
                        }
                    )
                }
            }
        }

        // Skapar avstånd mellan kategorival och knapp.
        Spacer(modifier = Modifier.height(16.dp))

        // Skapar knappen för att lägga till en vara.
        Button(
            onClick = {
                // Kopplingen till ShoppingViewModel
                // lägger vi till i nästa steg.
            },
            enabled = itemName.isNotBlank(),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Lägg till")
        }
    }
}

