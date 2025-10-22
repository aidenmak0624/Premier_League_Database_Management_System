.PHONY := build


FrontEnd.class: FrontEnd.java
	javac FrontEnd.java

BackEnd.class: BackEnd.java
	javac BackEnd.java

build: FrontEnd.class BackEnd.class

run: build
	java -cp .:mssql-jdbc-11.2.0.jre18 FrontEnd
