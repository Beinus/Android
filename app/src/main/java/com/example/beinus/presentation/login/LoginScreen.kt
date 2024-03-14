package com.example.beinus.presentation.login

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.beinus.data.remote.model.Employee

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginScreen(
    navController: NavHostController = rememberNavController(),
    viewModel: LoginViewModel = hiltViewModel()
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val context = LocalContext.current

            Column {
                OutlinedTextField(
                    value = viewModel.name.value,
                    onValueChange = { viewModel.setName(it) },
                    label = {
                        Text(
                            text = "Name",
                            color = if (viewModel.name.value.isEmpty()) {
                                Color.Red
                            } else {
                                Color.Black
                            }
                        )
                    },
                    singleLine = true
                )

                OutlinedTextField(
                    value = viewModel.location.value,
                    onValueChange = { viewModel.setLocation(it) },
                    label = {
                        Text(
                            text = "Location",
                            color = if (viewModel.location.value.isEmpty()) {
                                Color.Red
                            } else {
                                Color.Black
                            }
                        )
                    },
                )

                OutlinedTextField(
                    value = viewModel.branch.value,
                    onValueChange = { viewModel.setBranch(it) },
                    label = {
                        Text(
                            text = "Branch",
                            color = if (viewModel.branch.value.isEmpty()) {
                                Color.Red
                            } else {
                                Color.Black
                            }
                        )
                    },
                )
            }

            Button(
                onClick = {
                    if (viewModel.haveEmptyField()) {
                        Toast.makeText(context, "Please fill all the blanks", Toast.LENGTH_SHORT).show()
                    } else {
                        viewModel.saveEmployee()
                        Toast.makeText(context, "Welcome, ${viewModel.name.value}!", Toast.LENGTH_SHORT).show()
                    }
                }
            ) {
                Text(text = "Save Employee")
            }
        }
    }

}