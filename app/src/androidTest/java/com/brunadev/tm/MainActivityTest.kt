package com.brunadev.tm

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.brunadev.tm.view.MainActivity
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun showHomeActivityClickListThenShowEventDetails() {
        withMainActivity {
            launchActivity()
        } actions {
            clickList()
        } verify {
            checkImageDetailIsDiplayed()
            checkTitleDetailIsDiplayed()
        }
    }


    @Test
    fun showHomeActivityScrollListThenCheckSearchViewIsDisplayed() {
        withMainActivity {
            launchActivity()
        } actions {
            scrollList()
            Thread.sleep(2000)
        } verify {
            checkSearchViewIsDisplayed()
        }
    }

    @Test
    fun showHomeActivityThenCheckTextDisplayed() {
        withMainActivity {
            launchActivity()
        } verify {
            checkAppNameIsTextDisplayed()
            checkViewIsTextNotDisplayed()
        }
    }
}