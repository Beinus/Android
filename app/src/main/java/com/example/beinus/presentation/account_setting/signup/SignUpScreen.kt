package com.example.beinus.presentation.account_setting.signup

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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

        Button(
            onClick = {
                if (viewModel.haveEmptyField()) {
                    Toast.makeText(context, "Please fill all the blanks", Toast.LENGTH_SHORT).show()
                } else {
                    viewModel.saveEmployee()
                    Toast.makeText(context, "Sign up complete! Please log in again.", Toast.LENGTH_SHORT).show()
                    navController.popBackStack()
                }
            }
        ) {
            Text(text = "Sign up")
        }
    }
}