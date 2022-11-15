import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import groovy.json.internal.Exceptions

import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

//****************Tasks****************
responseTask = WS.sendRequest(findTestObject('OR Octoperf/POST Tasks'))

WS.verifyResponseStatusCode(responseTask, 200)

task_id = responseTask.getResponseBodyContent()

println(responseTask.getResponseBodyContent())

//***************Result*****************
for (int i = 0; i < 100; i++) {

    responseResult = WS.sendRequest(findTestObject('OR Octoperf/GET Result', [('task_id') : task_id]))

    WS.verifyResponseStatusCode(responseResult, 200)

    println('value of ResponseBodyContent: ' + responseResult.getResponseBodyContent())

    println('value of ResponseText: ' + responseResult.getResponseText())

    filename = WS.getElementPropertyValue(responseResult, 'filename', FailureHandling.OPTIONAL)

    WebUI.comment(filename)

    if (filename != null) {
        break
    }
    
    WS.delay(2)

    println(filename)
	
}

//filename = 'Lobster.pdf'
//***************BenchResultIds*****************
responsebenchResult = WS.sendRequest(findTestObject('OR Octoperf/GET BenchResult'))

WS.verifyResponseStatusCode(responsebenchResult, 200)

println('value of ResponseBodyContent: ' + responsebenchResult.getResponseBodyContent())

println('value of ResponseText: ' + responsebenchResult.getResponseText())

benchResultIds = WS.getElementPropertyValue(responsebenchResult, 'benchResultIds')

println(benchResultIds instanceof String)

benchResultIds = benchResultIds.getAt(0)

println('benchResultIds: ' + benchResultIds)

//***************LogID*****************

responseLogId = WS.sendRequest(findTestObject('OR Octoperf/GET LogID', [('benchResultIds') : benchResultIds, ('filename') : filename]))

WS.verifyResponseStatusCode(responseLogId, 200)


println('value of ResponseBodyContent: ' + responseLogId.getResponseBodyContent())

println('value of ResponseText: ' + responseLogId.getResponseText())

