package com.example.beinus.presentation.account_setting.signup

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.example.beinus.presentation.account_setting.AccountSettingViewModel

@Composable
fun SignUpScreen(
    navController: NavHostController = rememberNavController(),
    viewModel: AccountSettingViewModel = hiltViewModel()
) {
    viewModel.getAllUsers()

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
                value = viewModel.userID.value,
                onValueChange = { viewModel.setUserID(it) },
                label = {
                    Text(
                        text = "ID"
                    )
                },
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = viewModel.userPW.value,
                onValueChange = { viewModel.setUserPW(it) },
                label = {
                    Text(
                        text = "password"
                    )
                },
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = viewModel.userPW2.value,
                onValueChange = { viewModel.setUserPW2(it) },
                label = {
                    Text(
                        text = "check password"
                    )
                },
            )
        }

        Button(
            modifier = Modifier.fillMaxWidth(0.5f),
            onClick = {
                if (viewModel.hasEmptyField()) {
                    Toast.makeText(context, "Please fill all the blanks", Toast.LENGTH_SHORT).show()
                } else {
                    if (viewModel.userID.value in viewModel.userList.value.map { it.userID }) {
                        Toast.makeText(
                            context,
                            "This ID already exists. Try another ID.",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else if (viewModel.userPW.value != viewModel.userPW2.value) {
                        Toast.makeText(
                            context,
                            "Passwords do not match. Please check the password again.",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        viewModel.saveUser()
                        Toast.makeText(
                            context,
                            "Sign up complete! Please log in again.",
                            Toast.LENGTH_SHORT
                        ).show()
                        navController.popBackStack()
                    }
                }
            }
        ) {
            Text(text = "Sign up")
        }
    }
}