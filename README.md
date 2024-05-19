# Big Selenium Project
This is a big project that uses Selenium to automate the process according to the checklist provided by the Professor. The project is divided into 2 parts:
- Part 1: Basics
- Part 2: Advanced
# Commands I always forget 😅
`docker exec -it selenium-docker-sandbox-ubuntu-1 bash`<br/>
`export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-arm64`<br/>
`export PATH=$JAVA_HOME/bin:$PATH`<br/>

# Links
VNC: http://localhost:8081/vnc.html <br/>
Chosen Websites : https://docs.google.com/spreadsheets/d <br/>



# Checklist
- [ ] Part 1: Basics
  - [x] Fill simple form and send (eg. Login)
  - [x] Form sending with user
  - [x] Logout
  - [x] Fill input (text,radio,check...)
  - [x] Send a form
  - [x] Static Page test
  - [x] Multiple page test from array (easily extendable static page tests)
  - [x] complex xpath (eg. //div//a[@href='asd'])
  - [x] Filling or reading textarea content
  - [x] Filling or reading drop-down
  - [x] Filling or reading Radio button
  - [x] At least 4 class
  - [x] At least 6 class
  - [x] At least 8 class
  - [x] Explicit wait
  - [x] Reading the page title
  - [x] Page object pattern
  - [x] BasePage object class
  - [x] Test suite looks like readable test description

- Part 2: Advanced
  - [x] WebDriver configuration (modify something in the browser options)
  - [x] Manipulate cookie meaningfully (without ui), e.g. avoid showing up consent popup without clicking onto it
  - [x] Hover test
  - [x] Drag&Drop
  - [x] File Upload
  - [x] History test (browser back button)
  - [x] Test case dependencies
  - [ ] E-mail checking (eg. Registration with activation e-mail): Unable to do this because of the Captcha
  - [x] Test with random data
  - [ ] Download multiple files to a folder from an user protected page: Unable to do this because the chrome version is too old
  - [x] Using configuration file
  - [x] JavascriptExecutor



# MyOwnChecklistDescription

| Task                                                 | Description on Hugging Face Website                                                   |
|------------------------------------------------------|----------------------------------------------------------------------------------------|
| **Fill simple form and send (e.g., Login)**          | Automate filling the login form and submitting it to access your account.              |
| **Form sending with user**                           | Automate a form submission that requires user interaction, like setting a profile.    |
| **Logout**                                           | Automate the process of logging out from the website.                                  |
| **Fill input (text, radio, check...)**               | Automate entering data into different types of input fields on a form.                 |
| **Send a form**                                      | Automate the process of submitting a general form (like feedback or settings).         |
| **Static Page test**                                 | Check the load and display of static pages like the homepage or documentation.         |
| **Multiple page test from array**                    | Automate visiting multiple static pages using an array of URLs to check each page.    |
| **Complex xpath**                                    | Use a complex XPath to locate elements like links within nested divs.                  |
| **Filling or reading textarea content**              | Automate entering or verifying text in a textarea field, like a model description.    |
| **Filling or reading drop-down**                     | Automate selecting options from a drop-down menu, such as sorting options in search.  |
| **Filling or reading Radio button**                  | Automate checking a radio button, such as selecting a subscription plan.               |
| **At least 4 class, 6 class, 8 class**               | Check the presence and correctness of CSS classes on the page elements.               |
| **Explicit wait**                                    | Implement waits to ensure elements are loaded before actions are taken.               |
| **Reading the page title**                           | Automate fetching and verifying the title of the webpage.                             |
| **Page object pattern**                              | Organize test scripts using the Page Object design pattern for better maintenance.    |
| **BasePage object class**                            | Create a base class for common page properties and methods used across tests.         |
| **Test suite looks like readable test description**  | Structure your test suite so that the tests read like a clear description of actions. |

For the "Advanced" tasks:

| Task                                                   | Description on Hugging Face Website                                                   |
|--------------------------------------------------------|----------------------------------------------------------------------------------------|
| **WebDriver configuration**                            | Modify browser settings, like disabling pop-ups or setting window sizes.              |
| **Manipulate cookie meaningfully**                     | Automate cookie manipulation to bypass pop-ups without manual clicks.                 |
| **Hover test**                                         | Test UI changes that occur when hovering over elements like menu options.             |
| **Drag & Drop**                                        | Automate drag and drop actions, particularly in interactive UI elements.              |
| **File Upload**                                        | Automate uploading files, possibly to a model repository.                             |
| **History test**                                       | Test the browser back button to ensure it navigates correctly through user history.   |
| **Test case dependencies**                             | Ensure tests that depend on the outcome of others are executed in the correct order.  |
| **E-mail checking**                                    | Test the email sending and receiving process, like account activation emails.         |
| **Test with random data**                              | Use randomly generated data in tests to ensure robustness.                            |
| **Download multiple files to a folder**                | Automate downloading files from a protected user area to a specified folder.          |
| **Using configuration file**                           | Use a config file to manage test settings and parameters for different environments.  |
| **JavascriptExecutor**                                 | Execute JavaScript code during tests for scenarios that require it, like scrolling.   |
.