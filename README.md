
# Introduction

# Performance Testing

Performance Testing is a software testing process used for testing the speed, response time, stability, reliability, scalability, and resource usage of a software application under a particular workload. The main purpose of performance testing is to identify and eliminate the performance bottlenecks in the software application.

Key parameter of Performance Testing

* Speed – Determines whether the application responds quickly
* Scalability – Determines the maximum user load the software application can handle.
* Stability – Determines if the application is stable under varying loads

Types of Performance Testing

* Load testing – checks the application’s ability to perform under anticipated user loads. The objective is to identify performance bottlenecks before the software application goes live.
* Stress testing – involves testing an application under extreme workloads to see how it handles high traffic or data processing. The objective is to identify the breaking point of an application.
* Volume testing – Under Volume Testing large no. of. Data is populated in a database, and the overall software system’s behavior is monitored. The objective is to check software application’s performance under varying database volumes.


# What is Octoperf

OctoPerf is a commercial Saas and on Premise platform. It's a full-stack cloud load testing platform. It allows simulating thousands of concurrent users on any HTTP-based website or mobile application. On premise means you can install your own OctoPerf platform anywhere you want. It has the following key features:
Record and design realistic Virtual User,
Monitor your servers,
Run scenarios from multiple locations (Europe, USA and more),
Analyze bench reports to find performance bottlenecks.

# Katalon Platform

Katalon is a modern, comprehensive quality management platform that helps teams of any size deliver the highest quality digital experiences. Katalon Studio is a comprehensive toolset for web, API, mobile, and desktop app automation testing.

# Katalon Platfrom with Octoperf
This project demonstrates how Katalon Studio helps users to perform the performance testing by using octoperf. I have build a test suite which is triggring Load test from octoperf.


# Prerequisite
* [Katalon Studio][KS]
* Octoperf Account.

# Account Setup in Octoperf

* Login into the octoperf account

* Create a Wokspace and copy the Workspace Id from URL. 

![image](https://user-images.githubusercontent.com/84115288/234657872-c7ee3acb-aa57-4706-bcda-33aefdf65d83.png)

* Create a project and copy Project Id from the URL. 
 
![image](https://user-images.githubusercontent.com/84115288/234658135-3ea29580-f470-43c3-b438-61f0c33ce1aa.png)

* Create Virtual Users: A [Virtual User][VU] (shortened VU) represents a user journey through your application. It lets you simulate a real user behavior.
  You are then prompted with several options:
  * Website or REST API
  * Browser Record(HAR)
  * Jmeter Project
  * Postman collection
  * Fragments
  We am using [Browser Record(HAR)][CR] for the Vitrual user so we generating a .har file on browser(Chrome/firefox) by recording all the action for test application.
  
  <img width="1440" alt="Screenshot 2023-01-23 at 5 11 08 PM" src="https://user-images.githubusercontent.com/84115288/214031446-3ec9cad2-4881-45fb-af59-48cfb9d4c4a0.png">

* Go with the Virtual User Validation check.
* Click on [Execute Load Test][ELT] 

![image](https://user-images.githubusercontent.com/84115288/234665108-bed98ad2-f98b-426a-9f74-d0c6d621a99e.png)
* Click on Scenaio and copy Scenario Id from the URL.

![image](https://user-images.githubusercontent.com/84115288/234665439-3b944583-db9b-4e4a-8eaa-d4615280cc26.png)
* Enter the [Time of occurrence and number of concurrent users][ONCU] 

![image](https://user-images.githubusercontent.com/84115288/234666403-bee739d9-1adf-4fa4-8b10-3bc12dd62f1a.png)
* Click on Templates >> Extract Template and copy Template Id from the URL.

![image](https://user-images.githubusercontent.com/84115288/234667381-c21efa24-c946-46b3-961a-b02a7a9bca22.png)

# Project Setup in Katalon
* Create a project.
* Add all the store values for octoperf into katalon Profile.
   * Template Id.
   * Scenario Id
   * Worksapce Id
   * Project Id
   * OCtoperf API Key
   * Add download-report.sh at project root directory.
![image](https://user-images.githubusercontent.com/84115288/234672155-16caadd3-abda-4c71-8d0c-8cd842eb7837.png)


* Create APIs within Object repository.
  * POST https://api.octoperf.com/runtime/scenarios/run/<scenarioId>?templateId=<templateId>

![image](https://user-images.githubusercontent.com/84115288/234672691-8b47b3a0-eae8-4516-95ad-461f949d19b6.png)
 
  * https://api.octoperf.com/runtime/bench-results/progress/${benchResultId}
 
 ![image](https://user-images.githubusercontent.com/84115288/234673222-0a54f1eb-2637-4cef-a1a5-efd8baad3260.png)
 
 * Create Test Cases and Extract the values from APIs
 
  * Test Case No 1: TC001_Executes the scenario with the given ID
   ![image](https://user-images.githubusercontent.com/84115288/234673845-815063c6-9648-4634-8aa0-c6a2ba3797d8.png)
  * Test Case No 2: TC002_Track Run Progress
   ![image](https://user-images.githubusercontent.com/84115288/234674203-b04a13c2-b28f-4ab2-873a-00fbf18da1f2.png)
  * Test Case No 3: TC003_Download PDF Report
   ![image](https://user-images.githubusercontent.com/84115288/234674705-4a0d3cf1-0ffd-4148-86c5-6d679c0c69bf.png)

* Create a Test Suite and Add all the above test cases.

 ![image](https://user-images.githubusercontent.com/84115288/234675263-6e5b5dac-32a5-4b49-825d-288480e450f8.png)

* Run Katalon Test suite and verify the report downloaded on the project root directory.

 ![image](https://user-images.githubusercontent.com/84115288/234676193-724de98b-359e-4c93-8cb8-d0b70ee00adf.png)
 ![image](https://user-images.githubusercontent.com/84115288/234676442-86a6f25b-a04c-4809-9774-31323c8bb3dd.png)
 ![image](https://user-images.githubusercontent.com/84115288/234678697-550f764e-5b45-4688-9da3-70d5f3f42726.png)



[KS]: <https://docs.katalon.com/docs/get-started/katalon-studio-installation/install-katalon-studio-on-macoswindows#download-katalon-studio> "Katalon Studio"

[VU]: <https://api.octoperf.com/doc/design/#create-a-vu> "Virtual User"

[CR]: <https://api.octoperf.com/doc/design/create-virtual-user/record-chrome-har/> "Browser Record(HAR)"

[ELT]: <https://api.octoperf.com/doc/runtime/#runtime-scenarios-list> "Execute Load Test"

[ONCU]: https://api.octoperf.com/doc/runtime/edit-scenario/edit-user-profile/strategy/load/> "Time of occurrence and number of concurrent users"



