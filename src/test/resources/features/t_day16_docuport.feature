@docuport
Feature: Validate Left Navigate Items
  User Story: As a user, when I am on the Google search page,
  I want to be able to open the Docuport web page and validate left navigation items for 3 user

  Scenario: User validate left navigation items
    Then user validates all accessible fields on the left panel for his usertype
      | client     | Home , Received docs , My uploads , Invitations                                                                                                  |
      | employee   | Home , Received docs , My uploads , Clients     , Users       , Bookkeeping , 1099    Form , Reconciliations                                     |
      | supervisor | Home , Received docs , My uploads , Clients     , Users       , Leads       , Bookkeeping  , 1099   Form     , Reconciliations                   |
      | advisor    | Home , Received docs , My uploads , Clients     , Invitations , Users       , Leads        , Bookkeeping     , 1099 Form       , Reconciliations |
