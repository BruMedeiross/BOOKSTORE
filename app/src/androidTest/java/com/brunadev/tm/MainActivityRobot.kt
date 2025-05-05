package com.brunadev.tm

import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.brunadev.tm.view.MainActivity


fun MainActivityTest.withMainActivity(func: MainActivityRobot.() -> Unit) = MainActivityRobot().apply(func)


class MainActivityRobot {

    fun launchActivity(){
        val intent = Intent(ApplicationProvider.getApplicationContext(), MainActivity::class.java)
        ActivityScenario.launch<MainActivity>(intent)
    }

    infix fun actions(func: MainActivityRobot.() -> Unit) = this.apply(func)

    fun clickList() =  onView(withId(R.id.rvlist)).perform(click())

    fun scrollList() = performAction(R.id.rvlist, ScrollRecyclerToBottom())

    infix fun verify(func: MainActivityResult.() -> Unit) = MainActivityResult().apply(func)
}

class MainActivityResult {

    fun checkTitleDetailIsDiplayed() = onView(withId(R.id.event_title)).check(matches(ViewMatchers.isDisplayed()))

    fun checkImageDetailIsDiplayed() = onView(withId(R.id.img_event)).check(matches(ViewMatchers.isDisplayed()))

    fun checkSearchViewIsDisplayed() = R.id.search_view.isDisplayed()

    fun checkAppNameIsTextDisplayed() = "TM EVENTS".isTextDisplayed()

    fun checkViewIsTextNotDisplayed() = "Event Not Found".isTextNotDisplayed()
}
