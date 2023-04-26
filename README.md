
# Introduction

# Performance Testing

Performance Testing is a software testing process used for testing the speed, response time, stability, reliability, scalability, and resource usage of a software application under a particular workload. The main purpose of performance testing is to identify and eliminate the performance bottlenecks in the software application.

**Key parameter of Performance Testing

* Speed – Determines whether the application responds quickly
* Scalability – Determines the maximum user load the software application can handle.
* Stability – Determines if the application is stable under varying loads

**Types of Performance Testing
* Load testing – checks the application’s ability to perform under anticipated user loads. The objective is to identify performance bottlenecks before the software application goes live.
* Stress testing – involves testing an application under extreme workloads to see how it handles high traffic or data processing. The objective is to identify the breaking point of an application.
* Volume testing – Under Volume Testing large no. of. Data is populated in a database, and the overall software system’s behavior is monitored. The objective is to check software application’s performance under varying database volumes.


# What is Octoperf

OctoPerf is a commercial Saas and on Premise platform. Saas means Software As A Service. It's a full-stack cloud load testing platform. It allows simulating thousands of concurrent users on any HTTP-based website or mobile application. On premise means you can install your own OctoPerf platform anywhere you want. It has the following key features:
Record and design realistic Virtual User,
Monitor your servers,
Run scenarios from multiple locations (Europe, USA and more),
Analyze bench reports to find performance bottlenecks.

# Use case

Test a application (https://www.katalonhealthcare.com) with 10 users


# Prerequisite
* [Katalon Studio][KS]
* Octoperf Account.


# How to automate
* Generate a .har file on browser(Chrome/firefox) by recording all the action for your test website

<img width="1440" alt="Screenshot 2023-01-23 at 5 11 08 PM" src="https://user-images.githubusercontent.com/84115288/214031446-3ec9cad2-4881-45fb-af59-48cfb9d4c4a0.png">

* Setup your project on Octoperf(https://api.octoperf.com/)

![image](https://user-images.githubusercontent.com/84115288/214032009-071306ad-8afd-4ec1-853c-29b355eb9134.png)

* Increasing the virtual load.

![image](https://user-images.githubusercontent.com/84115288/214032175-0d116ae6-61a4-4171-ba47-94d7ddf4d8b0.png)

* Run and analysis the test.

![image](https://user-images.githubusercontent.com/84115288/214032821-102624f1-4eb1-41e9-8b60-2c4e64f34f01.png)

* Verify the report in pdf format.

![image](https://user-images.githubusercontent.com/84115288/214033013-94b92dbd-2a6a-4ae7-ad9d-87f41a4c9161.png)

* Use Octoperf APIs to download report from katalon.

  Request No 1 - https://api.octoperf.com/tasks
  
  Request No 2 - https://api.octoperf.com/analysis/bench-reports/${benchReportId}
  
  Request No 3 - https://api.octoperf.com/analysis/logs/${benchResultIds}?filename=${filename}
  
  ![image](https://user-images.githubusercontent.com/84115288/215849754-31324efd-0958-43f5-ae6c-90a40a11d58d.png)
  
* Now user can upload the performance report into TestOps.


[KS]: <https://docs.katalon.com/docs/get-started/katalon-studio-installation/install-katalon-studio-on-macoswindows#download-katalon-studio> "Katalon Studio"



