package com.example.beinus.presentation.account_setting.login

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.beinus.graphs.RootGraph
import com.example.beinus.presentation.account_setting.AccountSettingViewModel

@Composable
fun LoginScreen(
    navController: NavHostController,
    viewModel: AccountSettingViewModel = hiltViewModel()
) {
    viewModel.getAllEmployees()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 64.dp),
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
                        text = "Name"
                    )
                },
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = viewModel.location.value,
                onValueChange = { viewModel.setLocation(it) },
                label = {
                    Text(
                        text = "Location"
                    )
                },
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = viewModel.branch.value,
                onValueChange = { viewModel.setBranch(it) },
                label = {
                    Text(
                        text = "Branch"
                    )
                },
            )
        }

        Column(
            modifier = Modifier.fillMaxWidth(0.5f)
        ) {
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    if (viewModel.haveEmptyField()) {
                        Toast.makeText(context, "Please fill all the blanks", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        val matchingEmployee =
                            viewModel.employeeList.value.firstOrNull { it.name == viewModel.name.value }
                        if (matchingEmployee != null && matchingEmployee.branch == viewModel.branch.value) {
                            // Employee with matching name and branch found! Perform your desired action.
                            Toast.makeText(
                                context,
                                "Welcome, ${viewModel.name.value}!",
                                Toast.LENGTH_SHORT
                            ).show()
                            navController.popBackStack(
                                RootGraph.LoginScreen.route,
                                inclusive = true
                            ) // Clear backstack to LoginScreen
                            navController.navigate(RootGraph.MainScreen.route)
                        } else {
                            Toast.makeText(context, "Wrong id or password.", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }
            ) {
                Text(text = "Log in")
            }

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    navController.navigate(route = RootGraph.SignUpScreen.route)
                }
            ) {
                Text(text = "Sign up")
            }
        }
    }
}