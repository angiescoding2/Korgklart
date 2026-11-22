package com.example.korgklart

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

// Hanterar inköpslistans data och funktioner.
class ShoppingViewModel : ViewModel() {

    // Skapar en tom inköpslista som Compose kan observera.
    var items by mutableStateOf(listOf<GroceryItem>())
        private set

    // Lägger till en ny vara i inköpslistan.
    fun addItem(item: GroceryItem) {
        items = items + item
    }
    // Ändrar en varas status mellan inköpt och inte inköpt.
    fun togglePurchased(id: Int) {
        items = items.map { item ->
            if (item.id == id) {
                item.copy(purchased = !item.purchased)
            } else {
                item
            }
        }
    }
    // Tar bort en vara från inköpslistan med hjälp av dess ID.
    fun removeItem(id: Int) {
        items = items.filter { item ->
            item.id != id
        }
    }
    // Uppdaterar en befintlig vara med ny information.
    fun updateItem(updatedItem: GroceryItem) {
        items = items.map { item ->
            if (item.id == updatedItem.id) {
                updatedItem
            } else {
                item
            }
        }
    }
}