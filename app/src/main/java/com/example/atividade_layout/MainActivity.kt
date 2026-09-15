package com.example.atividade_layout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.atividade_layout.ui.theme.AtividadelayoutTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AtividadelayoutTheme {
                GameApp()
            }

                }
            }
        }


@Composable
fun GameApp(){

    var gameOver by remember {
        mutableStateOf(false)
    }

    if(gameOver){
        GameOver()
    }else {

        TelaInicial(
            onStart = {
                gameOver = true
            }
        )
    }
}

@Composable
fun TelaInicial(
    onStart: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(25.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "SCORE:0050",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "LIVES: 👾👾👾",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }


        Spacer(
            modifier = Modifier.height(0.dp)
        )


        // INIMIGOS

        Row(
            horizontalArrangement = Arrangement.spacedBy(-30.dp)
        ) {

            AndroidEnemy(
                modifier = Modifier
                    .size(80.dp)
                    .padding(4.dp),
                color = Color.Green
            )

            AndroidEnemy(
                modifier = Modifier
                    .size(80.dp)
                    .padding(4.dp),
                color = Color.Red
            )

            AndroidEnemy(
                modifier = Modifier
                    .size(80.dp)
                    .padding(4.dp),
                color = Color.Blue
            )

            AndroidEnemy(
                modifier = Modifier
                    .size(80.dp)
                    .padding(4.dp),
                color = Color.Yellow
            )

            AndroidEnemy(
                modifier = Modifier
                    .size(80.dp)
                    .padding(4.dp),
                color = Color.Green
            )
        }

        Spacer(
            modifier = Modifier.height(400.dp)
        )

        Text(
            text = "🔵",
            fontSize = 45.sp
        )


        Spacer(
            modifier = Modifier.height(30.dp)
        )

        Button(
            onClick = onStart,

            modifier =  Modifier
                .fillMaxWidth()
                .height(55.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = Color.DarkGray
            )
        ) {
            Text(
                text = "PRESS START",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }

}

@Composable
fun AndroidEnemy(
    color: Color,
    modifier: Modifier = Modifier
){
    Image(
        modifier = modifier,

        painter = painterResource(
            id = R.drawable.ic_launcher_foreground
        ),

        colorFilter = ColorFilter.tint(color),

        contentDescription = "Android Enemy"
    )
}

@Composable
fun GameOver() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),

        contentAlignment = Alignment.Center
    ) {

        Text(
            text = "GAME OVER",
            color = Color.White,
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GamePreview() {

    AtividadelayoutTheme {
        GameApp()
    }
}