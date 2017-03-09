Feature: Bet on English Premier League event
  As a WH Customer 
  I want the ability to place a bet on a English Premier League event
    
  Scenario: Bet on football
    Given Open WilliamHill website
    When Click on Football
    Then Validate url
    When Click Home on the first event
    And  Enter 0.05 on bet
    Then Validate Total stake value, odds and return value
    
    
