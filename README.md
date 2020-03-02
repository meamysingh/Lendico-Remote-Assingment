#lendico-ing-api-test

###This is api automation project designed to test rest api. i have used rest assured libraries for test apis through automation.

##Tools & Libraries
  #> Maven
  #> TestNg
  #> Java
  #> Rest Assured
  #> JsonObject Api
  
##Requirement
  In order to run tests you should have following softwares installed in your system.
  #> Java 1.8
  #> Maven
  
#Usage
 To run all the test, Navigate to lendico-ing-api-test directory and run below command
 
 ```bash
mvn test
```

##Reporting
After every run the report will be generated in directory - /lendico-ing-api-test/test-output/emailable-report.html

##Resources

I have automated 2 end points in [finance](https://github.com/public-apis/public-apis#finance), details are below:-

##[Alpha Vantage](https://www.alphavantage.co/)

End point:- https://www.alphavantage.co/query?function=SYMBOL_SEARCH&keywords=sony&apikey=demo

I wrote 5 Test cases for above end point and automated them.
Manual test cases can be found at google spread sheet- [Alpha Vantage_Test Cases](https://docs.google.com/spreadsheets/d/1LOgG96xxWsqMZKzteG60n_dSUez1zjSETo4Q4_-pXHQ/edit#gid=1267545814)

##[Razorpay_IFSC](https://ifsc.razorpay.com/)

End point:- https://ifsc.razorpay.com/IFSC_Code

I wrote 5 Test cases for above end point and automated them.
Manual test cases can be found at google spread sheet- [RazorPay_Test Cases](https://docs.google.com/spreadsheets/d/1LOgG96xxWsqMZKzteG60n_dSUez1zjSETo4Q4_-pXHQ/edit#gid=487262683)


##Defects

I explored the [Lendico](https://my.lendico.de/) application for finding defects.
i could find 5 defect in sort span, and details for these defects can be found by clicking on each defect link below:-
  
  #> [Defect_01](https://docs.google.com/document/d/1D_2pJTRGYaMkJ_XiVfQ-8dvQny2ZOLGngCFW_gGGIt8/edit?usp=sharing)
  #> [Defect_02](https://docs.google.com/document/d/1NqSdM7yAYULu8z_ICKkwjlM_N212eLC7UYL3n7tfXq0/edit?usp=sharing)
  #> [Defect_03](https://docs.google.com/document/d/1X8Ya0xUoep17CD3rI0MUAtBuprcZY1K_ZlvKd-DBTfs/edit?usp=sharing)
  #> [Defect_04](https://docs.google.com/document/d/1f-f9E3_rH_eI5qHnL4TU_1ao10jNPvSQP4GsFQdu18o/edit?usp=sharing)
  #> [Defect_05](https://docs.google.com/document/d/1hBYitDBCrqIzB9whjbyiQObN3uGV5VBOYgBQh25V6co/edit?usp=sharing)
  
  