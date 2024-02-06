package com.example.composebankuichallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composebankuichallenge.ui.theme.BlueEnd
import com.example.composebankuichallenge.ui.theme.BlueStart
import com.example.composebankuichallenge.ui.theme.PurpleEnd
import com.example.composebankuichallenge.ui.theme.PurpleStart


@Preview
@Composable
fun CardSection() {
    LazyRow{
        items(cardItems.size) { index->
            CardItem(index = index)
        }
    }
}


@Composable
fun CardItem(
    index : Int
) {
    val card = cardItems[index]
    var paddingEnd = 0.dp
    if(index == cardItems.size -1) {
        paddingEnd = 16.dp
    }

    var image = painterResource(id = R.drawable.ic_visa)
    if(card.cardType == "MASTER")
        image = painterResource(id = R.drawable.ic_mastercard)

    Box(modifier = Modifier
        .padding(start = 16.dp, end = paddingEnd)
    ) {

        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable { }
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Image(
                modifier = Modifier.size(60.dp),
                painter = image,
                contentDescription = card.cardName)

            Text(
                text = card.cardName,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "$ ${card.balance}",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = card.cardNumber,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

        }

    }
}


data class Card(
    val cardType : String,
    val cardNumber : String,
    val cardName : String,
    val balance : Double,
    val color : Brush
)

val cardItems = listOf(
    Card(
        cardType = "VISA",
        cardNumber = "4111 1111 1111 1111",
        cardName = "Business",
        balance = 32.45,
        color = getLinearGradiant(startColor = PurpleStart, endColor = PurpleEnd)
    ),
    Card(
        cardType = "MASTER",
        cardNumber = "4242 4242 4242 4242",
        cardName = "Savings",
        balance = 132.5,
        color = getLinearGradiant(startColor = BlueStart, endColor = BlueEnd)
    ),
    Card(
        cardType = "VISA",
        cardNumber = "4111 1111 1111 1111",
        cardName = "School",
        balance = 2.45,
        color = getLinearGradiant(startColor = PurpleStart, endColor = PurpleEnd)
    ),
    Card(
        cardType = "MASTER",
        cardNumber = "4242 4242 4242 4242",
        cardName = "College",
        balance = 320.45,
        color = getLinearGradiant(startColor = BlueStart, endColor = BlueEnd)
    )
)


fun getLinearGradiant(
     startColor: Color,
     endColor: Color

) : Brush {
    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )
}


