package com.vytrack.step_definitions;

import com.vytrack.pages.BrowserUtils;
import com.vytrack.pages.CalendarEventsPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class CalendarEventsStepDefinitions {

    /*
    And user verifies that column names are displayed
      |TITLE            |
      |CALENDAR         |
      |START            |
      |END              |
      |RECURRENT        |
      |RECURRENCE       |
      |INVITATION STATUS|
     */
    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

    @Then("user verifies that column names are displayed")
    public void user_verifies_that_column_names_are_displayed( List<String> dataTable) {
        System.out.println(dataTable);
        calendarEventsPage.waitUntilLoaderMaskDisappear();
        BrowserUtils.wait(3);
        Assert.assertEquals(dataTable, calendarEventsPage.getColumnNames());
    }

}
