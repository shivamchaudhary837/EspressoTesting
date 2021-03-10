package com.example.espressotesting

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import org.hamcrest.Matchers.not
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class ShoppingCartTest{

    @get:Rule
    val activityRule=ActivityTestRule(MainActivity::class.java)

    @Test
    fun calculateAmount_showErrorMessage(){
        onView(withId(R.id.product_quantitiy)).perform(typeText(""))
        onView(withId(R.id.calculate_amount)).perform(click())
        onView(withId(R.id.product_error_msg)).check(matches(isDisplayed()))

    }

    @Test
    fun calculateAmount_NotShowErrorMessage(){
        onView(withId(R.id.product_quantitiy)).perform(typeText("4"))
        onView(withId(R.id.calculate_amount)).perform(click())
        onView(withId(R.id.product_error_msg)).check(matches(not(isDisplayed())))
    }

}