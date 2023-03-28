package com.example.composegramapp

import android.icu.number.Scale
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showSystemUi = true)
@Composable
fun TwitScreen() {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color(0xFF161D26))
    ) {
        Column {
            Content()
            Divider(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp), color = Color.Gray
            )
        }
    }
}

@Composable
fun Content() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        ProfilePicture()
        TwitBody(Modifier.weight(3f))
    }
}

@Composable
fun DotsOptions() {
    Icon(
        painter = painterResource(id = R.drawable.ic_dots),
        contentDescription = "dotsOptions",
        tint = Color.White
    )
}

@Composable
fun TwitBody(modifier: Modifier) {
    Column(modifier = modifier.padding(horizontal = 12.dp)) {
        Header()
        TwitDescription()
        TwitImage()
        TwitReactions()
    }
}

@Composable
fun TwitReactions() {
    var commentMarked by rememberSaveable { mutableStateOf(false) }
    var rtMarked by rememberSaveable { mutableStateOf(false) }
    var likeMarked by rememberSaveable { mutableStateOf(false) }
    Row(
        Modifier
            .fillMaxWidth()
            .padding(top = 8.dp), horizontalArrangement = Arrangement.SpaceAround) {
        Row {
            Icon(
                painter = painterResource(id =
                if (commentMarked)
                    R.drawable.ic_chat_filled
                else
                    R.drawable.ic_chat),
                contentDescription = "comment icon",
                tint = Color.LightGray,
                modifier = Modifier.size(16.dp).clickable {
                    commentMarked = !commentMarked
                }
            )
            Text(
                text = if (commentMarked) "2" else "1",
                color = Color.LightGray,
                fontSize = 10.sp,
                modifier = Modifier.padding(horizontal = 2.dp)
            )
        }
        Row {
            Icon(
                painter = painterResource(id = R.drawable.ic_rt),
                contentDescription = "rt icon",
                tint = if (rtMarked) Color.Green else Color.LightGray,
                modifier = Modifier.size(17.dp).clickable { rtMarked = !rtMarked }
            )
            Text(
                text = if (rtMarked) "2" else "1",
                color = Color.LightGray,
                fontSize = 11.sp,
                modifier = Modifier.padding(horizontal = 2.dp)
            )
        }
        Row {
            Icon(
                painter = painterResource(id = if (likeMarked) R.drawable.ic_like_filled else R.drawable.ic_like),
                contentDescription = "like icon",
                tint = if (likeMarked) Color.Red else Color.LightGray,
                modifier = Modifier.size(16.dp).clickable { likeMarked = !likeMarked }
            )
            Text(
                text = if (likeMarked) "2" else "1",
                color = Color.LightGray,
                fontSize = 10.sp,
                modifier = Modifier.padding(horizontal = 2.dp)
            )
        }
    }
}

@Composable
fun TwitImage() {
    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "twit image",
        modifier = Modifier
            .clip(
                RoundedCornerShape(18.dp)
            )
            .fillMaxWidth()
    )
}

@Composable
fun TwitDescription() {
    Text(
        text = stringResource(id = R.string.generic_text),
        color = Color.White,
        modifier = Modifier.padding(bottom = 10.dp, top = 4.dp)
    )
}

@Composable
fun Header() {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        ProfileName()
        DotsOptions()
    }
}

@Composable
fun ProfileName() {
    Row {
        Text(
            text = "Ivan",
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Text(
            text = "@IvanDev 4h",
            color = Color(0xFFB5B5B5),
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }
}

@Composable
fun ProfilePicture() {
    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "image profile",
        modifier = Modifier
            .size(64.dp)
            .clip(CircleShape)
    )
}