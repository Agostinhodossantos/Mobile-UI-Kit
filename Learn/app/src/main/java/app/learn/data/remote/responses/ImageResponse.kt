package app.learn.data.remote.responses

import app.learn.data.remote.responses.ImageResult


data class ImageResponse(
    val hits: List<ImageResult>,
    val total: Int,
    val totalHits: Int
)