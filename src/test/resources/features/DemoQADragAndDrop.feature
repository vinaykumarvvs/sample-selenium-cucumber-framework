Feature: DemoQA scenario - Drag & Drop Test Case

  @Test
  Scenario: Drag and drop operation scenario
    Given user navigates to "https://demoqa.com/"
    Then user should be landed on DemoQA home screen
    And user clicks on Droppable link present under interactions section
    Then user should be navigated to Droppable screen
    And user drag's the child box and drop it on top of parent box
    And user drag's back the child box from top of parent box
    Then user should see that text has changed from dropped to drop here