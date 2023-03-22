package com.example.moodtracker

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.moodtracker.ui.MainActivity
import org.junit.Rule


@RunWith(AndroidJUnit4::class)
@LargeTest
class InstrumentalTest {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testButtonDisplayed() {
        // Start the scenario
        val scenario = ActivityScenario.launch(MainActivity::class.java)

        // Check if the Button is displayed
        Espresso.onView(ViewMatchers.withId(R.id.Continue))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        // Close the scenario
        scenario.close()
    }

   /* @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.moodtracker", appContext.packageName)
    }*/
}








