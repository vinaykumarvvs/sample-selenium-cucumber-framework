Feature: DemoQA scenario - Resize Test Case

  @Test
  Scenario: Resize the editor and log dimensions every time
    Given user navigates to "https://demoqa.com/"
    Then user should be landed on DemoQA home screen
    And user clicks on Resizable link present under interactions section
    Then user should be navigated to Resizable screen
    And user resize's the editor with x-offset as 250 and y-offset as 250