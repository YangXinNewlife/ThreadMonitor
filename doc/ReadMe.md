#Project Name
ThreadMonitor

#Language
Javase1.8

#Function
Can Monitor catalog and files when files and catalogs altered

#Run Method
run the /ThreadMonitor/src/bin/Inital.java

#Catalog
|-doc
	|-ReadMe.md
|-output
	|-Output.txt
|-src
	|-bin
		|-Initial.java
	|-obj
		|-InputMessage.java
	|-task
		|-Detail.java
		|-Summary.java
		|-Task.java
	|-triger
		|-ModifiedTriger.java
		|-PathChangedTriger.java
		|-RenameTriger.java
		|-SizeChangedTriger.java


#Triger output
/ThreadMonitor/output/Output.txt


#InputDemo
IF /root modified THEN record-summary
IF [D:\test\demo.cpp] renamed THEN recover
END

#Scan frequency
5000ms