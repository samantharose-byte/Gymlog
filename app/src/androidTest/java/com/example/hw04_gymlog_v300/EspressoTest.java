package com.example.hw04_gymlog_v300;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;



@LargeTest
@RunWith(AndroidJUnit4.class)
public class EspressoTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void espressoTest() {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.userNameLoginEditText),
                        childAtPosition(
                                allOf(withId(R.id.main),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("admin1"), closeSoftKeyboard());
        SystemClock.sleep(1000);

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.passwordLoginEditText),
                        childAtPosition(
                                allOf(withId(R.id.main),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                2),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("admin1"), closeSoftKeyboard());
        SystemClock.sleep(1000);

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.loginButton), withText("Login!"),
                        childAtPosition(
                                allOf(withId(R.id.main),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                3),
                        isDisplayed()));
        appCompatButton.perform(click());
        SystemClock.sleep(1000);

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.exerciseInputEditText),
                        childAtPosition(
                                allOf(withId(R.id.main),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                2),
                        isDisplayed()));
        appCompatEditText3.perform(replaceText("testing"), closeSoftKeyboard());
        SystemClock.sleep(1000);

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.weightInputEditText),
                        childAtPosition(
                                allOf(withId(R.id.main),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                4),
                        isDisplayed()));
        appCompatEditText4.perform(replaceText("420"), closeSoftKeyboard());
        SystemClock.sleep(1000);

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.repInputEditText),
                        childAtPosition(
                                allOf(withId(R.id.main),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                6),
                        isDisplayed()));
        appCompatEditText5.perform(replaceText("5000"), closeSoftKeyboard());
        SystemClock.sleep(1000);

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.logButton), withText("Log!"),
                        childAtPosition(
                                allOf(withId(R.id.main),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                7),
                        isDisplayed()));
        appCompatButton2.perform(click());
        SystemClock.sleep(1000);

        ViewInteraction actionMenuItemView = onView(
                allOf(withId(R.id.logoutMenuItem), withText("admin1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(com.google.android.material.R.id.action_bar),
                                        1),
                                0),
                        isDisplayed()));
        actionMenuItemView.perform(click());
        SystemClock.sleep(1000);

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(android.R.id.button1), withText("Logout"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        appCompatButton3.perform(scrollTo(), click());
        SystemClock.sleep(1000);

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.userNameLoginEditText),
                        childAtPosition(
                                allOf(withId(R.id.main),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatEditText6.perform(replaceText("admin1"), closeSoftKeyboard());
        SystemClock.sleep(1000);

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.passwordLoginEditText),
                        childAtPosition(
                                allOf(withId(R.id.main),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                2),
                        isDisplayed()));
        appCompatEditText7.perform(replaceText("admin1"), closeSoftKeyboard());
        SystemClock.sleep(1000);

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.loginButton), withText("Login!"),
                        childAtPosition(
                                allOf(withId(R.id.main),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                3),
                        isDisplayed()));
        appCompatButton4.perform(click());
        SystemClock.sleep(1000000);
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
