package com.geekstudio.composetest.presentation.snackbar

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.geekstudio.composetest.ui.view.snackBar
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
            snackBar()
        }

        composeTestRule
            .onNodeWithTag("SnackTextField")
            .performTextInput("테스트")

        composeTestRule
            .onNodeWithText("Show SnackBar")
            .performClick()

        composeTestRule
            .onNodeWithText("textState : 테스트")
            .assertIsDisplayed()
    }
}