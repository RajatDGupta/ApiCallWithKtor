package com.demo.apicallwithktor.core.route

sealed class Route(val route: String) {
    object ListScreen : Route("list_screen")
    object DetailScreen : Route("detail_screen")
}