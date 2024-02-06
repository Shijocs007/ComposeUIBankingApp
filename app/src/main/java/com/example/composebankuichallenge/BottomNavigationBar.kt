package com.example.composebankuichallenge

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun BottomNavigationBar() {
    NavigationBar {
        Row(modifier = Modifier.background(MaterialTheme.colorScheme.inverseOnSurface)) {
            bottomItems.forEachIndexed { index, bottomItem ->
                NavigationBarItem(
                    selected = index == 0,
                    onClick = { },
                    label = {
                            Text(
                                text = bottomItem.name,
                                color = MaterialTheme.colorScheme.onBackground
                                )
                    },
                    icon = {
                        Icon(
                            imageVector = bottomItem.icon,
                            contentDescription = bottomItem.name,
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    })
            }
        }
    }
}


val bottomItems = listOf(
    BottomItem(
        name = "Home",
        icon = Icons.Rounded.Home
    ),
    BottomItem(
        name = "Wallet",
        icon = Icons.Rounded.Wallet
    ),
    BottomItem(
        name = "Notification",
        icon = Icons.Rounded.Notifications
    ),
    BottomItem(
        name = "Account",
        icon = Icons.Rounded.AccountCircle
    )
)


data class BottomItem(
    val name : String,
    val icon : ImageVector
)