package bloder.com.network.providers

import bloder.com.network.network

fun jsonPlaceHolderNetwork() = network {
    baseUrl("https://jsonplaceholder.typicode.com/")
}