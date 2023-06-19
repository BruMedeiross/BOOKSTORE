package com.brunadev.bookstore

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.app.Activity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.espresso.action.GeneralLocation
import androidx.test.espresso.action.GeneralSwipeAction
import androidx.test.espresso.action.Press
import androidx.test.espresso.action.Swipe
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers

fun Int.click(): ViewInteraction = performAction(this, ViewActions.click())

fun Int.clickWithValidatableButtonText(text: String): ViewInteraction =
    onView(withText(text))
        .perform((ViewActions.click()))

fun Int.scrollToBottom(): ViewInteraction = performAction(this, ScrollRecyclerToBottom())

fun Int.clickViewWithText(text: String): ViewInteraction =
    onView(withText(text)).perform((ViewActions.click()))

fun Int.setValidatableEditText(text: String?): ViewInteraction =
    onView(withId(this)).check(matches(ViewMatchers.withText(text)))

fun Int.hasText(text: String): ViewInteraction =
    onView(withId(this)).check(matches(ViewMatchers.withText(text)))

fun Int.replaceText(text: String): ViewInteraction =
    onView(withId(this)).perform(ViewActions.replaceText(text))

fun Int.isEnabled(): ViewInteraction = onView(withId(this)).check(matches(ViewMatchers.isEnabled()))

fun Int.isGone(): ViewInteraction = onView(withId(this))
    .check(matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.GONE)))

fun Int.isVisible(): ViewInteraction =
    onView(withId(this)).check(matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))

fun Int.fastSwipeUp(): ViewInteraction = performAction(
    this,
    GeneralSwipeAction(
        Swipe.FAST,
        GeneralLocation.BOTTOM_CENTER,
        GeneralLocation.BOTTOM_CENTER,
        Press.PINPOINT
    )
)


fun Activity.animationEnd(callback: () -> Unit) : AnimatorListenerAdapter {
    return object : AnimatorListenerAdapter() {
        override fun onAnimationEnd(animation: Animator?) {
            callback.invoke()
        }
    }
}

fun Int.slowSwipeUp(): ViewInteraction = performAction(
    this,
    GeneralSwipeAction(
        Swipe.SLOW,
        GeneralLocation.CENTER,
        GeneralLocation.TOP_CENTER,
        Press.FINGER
    )
)

fun Int.slowSwipeDown(): ViewInteraction = performAction(
    this,
    GeneralSwipeAction(
        Swipe.SLOW,
        GeneralLocation.CENTER,
        GeneralLocation.BOTTOM_CENTER,
        Press.FINGER
    )
)

fun Int.isDisplayed(): ViewInteraction =
    onView(withId(this)).check(matches(ViewMatchers.isDisplayed()))

fun Int.isChecked(): ViewInteraction = onView(withId(this)).check(matches(ViewMatchers.isChecked()))

fun Int.isNotChecked(): ViewInteraction =
    onView(withId(this)).check(matches(ViewMatchers.isNotChecked()))

fun Int.isSelected(): ViewInteraction =
    onView(withId(this)).check(matches(ViewMatchers.isSelected()))

fun Int.isNotSelected(): ViewInteraction =
    onView(withId(this)).check(matches(ViewMatchers.isNotSelected()))

fun Int.scrollTo(): ViewInteraction = performAction(this, ViewActions.scrollTo())

fun Int.scrollAndClick() {
    scrollTo()
    click()
}
