package rhcloud.com.testapp.activity;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import rhcloud.com.testapp.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testIfInnerCloseButtonWorks() {
        ViewInteraction appCompatTextView = onView(
                allOf(withText("Add Tab"), isDisplayed()));
        appCompatTextView.perform(click());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.btnAddNewTab), withText("Add Tab"), isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction button = onView(
                allOf(withId(R.id.btnCloseTab), withText("Close Tab"), isDisplayed()));
        button.check(matches(isDisplayed()));

        ViewInteraction textView = onView(
                allOf(withId(R.id.text1), withText("Closeable"), isDisplayed()));
        textView.check(matches(withText("Closeable")));

        ViewInteraction imageButton = onView(
                allOf(withId(R.id.ibClose), isDisplayed()));
        imageButton.check(matches(isDisplayed()));

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.btnCloseTab), withText("Close Tab"), isDisplayed()));
        appCompatButton2.perform(click());

    }

    @Test
    public void testIfExternalButtonWorks() {
        ViewInteraction appCompatTextView = onView(
                allOf(withText("Add Tab"), isDisplayed()));
        appCompatTextView.perform(click());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.btnAddNewTab), withText("Add Tab"), isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.text1), withText("Closeable"), isDisplayed()));
        textView.check(matches(withText("Closeable")));

        ViewInteraction imageButton = onView(
                allOf(withId(R.id.ibClose), isDisplayed()));
        imageButton.perform(click());

        ViewInteraction button = onView(
                allOf(withId(R.id.btnAddNewTab), withText("Add Tab"), isDisplayed()));
        button.check(matches(isDisplayed()));

    }

}
