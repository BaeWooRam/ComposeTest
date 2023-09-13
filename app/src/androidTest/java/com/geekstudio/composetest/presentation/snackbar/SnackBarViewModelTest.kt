package com.geekstudio.composetest.presentation.snackbar

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SnackBarViewModelTest {

    // LiveData 이용을 위한 처리 - core-testing 함께 사용
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `기본_동작_테스트_getAll`() {
        composeTestRule.setContent {
            Button(onClick = { }) {
                Text("테스트")
            }
        }

        composeTestRule
            .onNodeWithText("테스트")
            .assertIsDisplayed()
    }
}