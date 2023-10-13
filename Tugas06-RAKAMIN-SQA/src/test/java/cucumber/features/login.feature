Feature: Login Page aplikasi sourcedemo

@TDD
Scenario Outline:
  Given Halaman login sourcedemo
  When  I input <username> as username
  And   I input <password> as password
  And   Click login button
  Then  I verify <status> login result

  Examples:
  | username               | password       | status            |
  | standard_user          | secret_sauce   | success           |
  | standard_user          | iseng          | fail              |
  | @standard_user3        | secret_sauce   | fail              |
  | jajal                  | secret_sauce   | fail              |
  | standard_user          |                | empty_password    |
  |                        | secret_sauce   | empty_username    |
  | locked_out_user        | secret_sauce   | username_locked   |
  | error_user             | secret_sauce   | unable_error_user |







