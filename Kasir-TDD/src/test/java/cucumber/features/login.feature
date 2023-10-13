Feature: Login Page aplikasi kasir Aja

@TDD
Scenario Outline:
  Given Halaman login kasir aja
  When  I input <email> as email
  And   I input <password> as password
  And   Click login button
  Then  I verify <status> login result

  Examples:
  | email                  | password       | status         |
  | tdd-selenium@gmail.com | tdd-selenium   | success        |
  | testing@gmail.com      | tdd-selenium   | fail           |
  | tdd-selenium@gmail.com | 123456789      | fail           |
  | tdd-selenium@gmail.com |                | empty_password |
  |                        | tdd-selenium   | empty_username |
  | 1234                   | tdd-selenium   | invalid_email  |



