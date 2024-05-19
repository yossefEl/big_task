# Selenium Project
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
- Part 1: Basics
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

| Task                                                | Description                                                                                                                            |
|-----------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------|
| **Fill simple form and send (e.g., Login)**         | Login form                                                                                                                             |
| **Form sending with user**                          | Business adr<br>Password change<br>Rollback password change                                                                            |
| **Logout**                                          | logged two times <br>after the cookies setting<br>after the end of the                                                                 |
| **Fill input (text, radio, check...)**              | password, email                                                                                                                        |
| **Send a form**                                     | Login form                                                                                                                             |
| **Static Page test**                                | Convert,Compress, Edit pages                                                                                                           |
| **Multiple page test from array**                   | Convert,Compress, Edit pages                                                                                                           |
| **Complex xpath**                                   | Can be found in locators helper                                                                                                        |
| **Filling or reading textarea content**             | Business adr                                                                                                                           |
| **Filling or reading drop-down**                    | Account and Pdf tools dropdowns                                                                                                        |
| **Filling or reading Radio button**                 | remember me                                                                                                                            |
| **At least 4 class**                                | atLeast4Locator                                                                                                                        |
| **At least 6 class**                                | atLeast6Locator                                                                                                                        |
| **At least 8 class**                                | atLeast8Locator                                                                                                                        |
| **Explicit wait**                                   | wait.until(ExpectedConditions.urlMatches for uploadFile and in many other places mainly using the 2 helper methods from SeleniumHelper |
| **Reading the page title**                          | getPageTitle() from BasePage                                                                                                           |
| **Page object pattern**                             | Please check the project structure                                                                                                     |
| **BasePage object class**                           | all pages are extending BasePage                                                                                                       |
| **Test suite looks like readable test description** | Occured in many places in the code                                                                                                     |

For the "Advanced" tasks:

| Task                                    | Description                                                                                                                                                                               |
|-----------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **WebDriver configuration**             | in a method called getOptions inside SeleniumHelper                                                                                                                                       |
| **Manipulate cookie meaningfully**      | used existing token to login.  <br>read cookies to check if the user is authenticated                                                                                                     |
| **Hover test**                          | Hover over pdf tools dropdown and user account icon to logout                                                                                                                             |
| **Drag & Drop**                         | Drag the pen icon inside the Edit Page to the draggable area of the file upload<br>Drag and drop follows the mouse <br>Tried 5 ways to do it, most follow the cursor, some didn't  work . |
| **File Upload**                         | Upload the file "resources/file1.gif" to the website                                                                                                                                      |
| **History test**                        | navigateBack() from Viewer to Pdf Editor page                                                                                                                                             |
| **Test case dependencies**              | Occured in many places in the code                                                                                                                                                        |
| **E-mail checking**                     | Unable to do due to the Capcha challenge                                                                                                                                                  |
| **Test with random data**               | Random password and email generated using SeleniumHelper                                                                                                                                  |
| **Download multiple files to a folder** | File upload code is correct and expected to work but Unable to do due to the chrome not supporting the website                                                                            |
| **Using configuration file**            | can be found inside config/configs.json                                                                                                                                                   |
| **JavascriptExecutor**                  | used to<br>Scroll inside the compress page <br>bypass the GBC consent in the home page                                                                                                    |

For the "Goals" tasks:
| Task                                    | Description                                                                                                                                                                               |
|-----------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Readable code (Every function name describe what the function is doing)**             |Structure code, used relevant attributes and methods names, and respected the Java naming convention |
| **Structured (Organized in classes and functions)**      | Please check the project structure |
| **Unnecessary files ignored well**                          |all added to .gitignore |
| **Low redundancy (There are only a few of duplications of code)**                         |Redundant code refactored and moved to its respective helper  | 
