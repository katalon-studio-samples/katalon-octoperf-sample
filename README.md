
# Introduction

In this article we are focusing on how katalon studio helps users to do the performance testing by using a tool called Octoperf.


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

**Repository for the [Sample Project][SP]**

[KS]: <https://docs.katalon.com/docs/get-started/katalon-studio-installation/install-katalon-studio-on-macoswindows#download-katalon-studio> "Katalon Studio"
[SP]: <https://github.com/katalon-studio-samples/katalon-octoperf-sample.git> "Sample Project"



