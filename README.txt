Overview of Framework
--------------------------------

The framework choosen is Hybrid framework as it using Page Object Model also Data Driven framework concepts for better modularity, maintance & development. 

Structure of Framework is:
----------------------------------

SRC
   --Driver - This package/folder contains java files/classes to set-up, this has code to open a browser & nevigate to the webiste under test
   
   --PageObject - This package/folder contains java files/classes for different pages of website, It has different methods for user action on the 		           pertciluar pages with like HomePage
   
   --Testcases -  This package/folder contains java files/classes which contains the test methods & building blocks of methods, methods from page                 object are used here to form test cases 

   --Commonlib  - This package/folder contains java files/classes which are used as helper function like reading excel file, reading properrty values 		etc.

   --Resources - This folder contains, different drivers used for initializing the driver & property files. 

   --Reports   - This folder is used for keeping extra reporting files 

      --- Screenshot - This folder contains screenshot of the test execution

  --Testdata   - This folder contains the datasheet which contains different data that will be used for execution of test cases

  --Test-outputs - This folder got generated on running the project & it contains the TestNG reports for the execution

  --Doc  - This folder contains the java doc creating out of the project 





Main Libararies Used:
---------------------------------
1. apache-log4j-1.2.17 --- For Logging 
2. jxl-2.6.12.jar --- For Reading Excel file.
3. selenium-java-3.11.1 -- Main Selenium WebDriver 
4. Junit-4.12


How to Run
-----------------------------------------
It is very simple to run as mentioned below.
1. Clone the project from the git repository using any IDE
2. As maven goals please put - clean:clean dependency:tree test surefire-report:report
3. Go to Testcases in /src/java/testcases folder/package
4. Run Individual Test Case starting with name AcceptanceTest
5. If AcceptanceTestSignup test will be executed first it will do signup creating new user id and new email and save it to test data
sheet in testdata package in first sheet with name "signup"
6. If AcceptanceTestLogin test will be executed first it will pick the test data (user id, password) from test data sheet created previously
and stored in data sheet by test AcceptanceTestSignup
