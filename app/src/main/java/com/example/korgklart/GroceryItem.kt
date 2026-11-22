package com.example.korgklart

// Beskriver informationen som varje vara i inköpslistan har.
data class GroceryItem(
    val id: Int,
    val name: String,
    val category: String,
    val purchased: Boolean = false
)
