# language: en

@mobile @apidemos
Feature: Android ApiDemos application

  As a QA Automation Engineer
  I want to validate Android application navigation
  So that I can ensure the main mobile flows work as expected

  @smoke @home
  Scenario: Validate main menu options on home screen
    Then I should see the Views menu
    And  I should see the App menu
    And  I should see the Animation menu

  @regression @views
  Scenario: Validate navigation to Views menu
    When I access the Views menu
    Then I should see the Controls option
    And  I should see the Date Widgets option
    And  I should see the Expandable Lists option

  @regression @scroll
  Scenario: Validate scroll inside Views menu
    When I access the Views menu
    And  I scroll to the "WebView" option
    Then the "WebView" option should be visible