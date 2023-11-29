package com.techfortyone.jetpackcompose1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.techfortyone.jetpackcompose1.ui.theme.JetpackCompose1Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackCompose1Theme {
                var name by remember {
                    mutableStateOf("")
                }

                var names by remember {
                    mutableStateOf(listOf(""))
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        OutlinedTextField(value = name, onValueChange = { text ->
                            name = text
                        }, modifier = Modifier.width(250.dp),
                            colors =  TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = Green,
                                unfocusedBorderColor = Yellow
                            ))
                        Spacer(modifier = Modifier.width(20.dp))
                        Button(onClick = {
                            if (name.isNotBlank()) {
                                names = names + name
                                name = ""
                            }
                        }, modifier = Modifier.width(100.dp)) {
                            Text(text = "Add")
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    LazyColumn(modifier = Modifier.fillMaxWidth()) {
                        items(names) { currentName ->
                            Text(text = currentName,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp))
                            Divider()
                        }

                    }
                }
            }
        }
    }
}
