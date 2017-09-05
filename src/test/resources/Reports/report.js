$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("login2.feature");
formatter.feature({
  "line": 2,
  "name": "Flight Reservation Login 2",
  "description": "",
  "id": "flight-reservation-login-2",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@RunMe"
    }
  ]
});
formatter.scenario({
  "line": 4,
  "name": "Login to flight reservation 2",
  "description": "",
  "id": "flight-reservation-login-2;login-to-flight-reservation-2",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "the user opened \"chrome\" browser",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "the user navigated to \"http://newtours.demoaut.com/\" page",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "the user enters username \"tcoedemo\" in  input field",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "the user enters password \"password\" in  input field",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "chrome",
      "offset": 17
    }
  ],
  "location": "Stepdefs.the_user_opened_browser(String)"
});
formatter.result({
  "duration": 4537526562,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "http://newtours.demoaut.com/",
      "offset": 23
    }
  ],
  "location": "Stepdefs.the_user_navigated_to_page(String)"
});
formatter.result({
  "duration": 2098449853,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "tcoedemo",
      "offset": 26
    }
  ],
  "location": "Stepdefs.the_user_enters_username_in_input_field(String)"
});
formatter.result({
  "duration": 161095391,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "password",
      "offset": 26
    }
  ],
  "location": "Stepdefs.the_user_enters_password_in_input_field(String)"
});
formatter.result({
  "duration": 124065593,
  "status": "passed"
});
