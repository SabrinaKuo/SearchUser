package com.example.sabrina.searchuser.model

import java.io.Serializable

data class SearchResponse(
    val incomplete_results: Boolean,
    val items: List<User>,
    val total_count: Int
):Serializable

