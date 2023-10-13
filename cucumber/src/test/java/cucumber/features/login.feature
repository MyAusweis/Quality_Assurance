Feature: Login Page aplikasi kasir Aja

  Scenario: Success Login
  Given Halaman login kasir aja
  When  Input username
  And   Input Password
  And   Click login button
  Then  user is on dashboard page

  Scenario: Failed Login
  Given Halaman login kasir aja
  When  Input username
  And   Input invalid Password
  And   Click login button
  Then  user get error message

  Scenario: Failed Login
  Given Halaman login kasir aja
  When  Input invalid username
  And   Input Password
  And   Click login button
  Then  user get error message


