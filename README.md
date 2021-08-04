# Movie Review Website
To run fully functional Movie Review Web page, there are some requirements need to be setup.

## Features
- Add / edit / remove Reviews
- Add / edit / remove Movie by using Admin Account
- Register / login page
- List all Movies / List all Reviews
- Search Movies by Movie Title
- Responsive layout

## Tools Needed to Run Movie Review Website
- Java 8+
- JSP and Servlet
- JDBC 
- Oracle Database 11g - SQLDeveloper
- Eclipse IDE
- Apache Tomcat Server 8+

## Step to Set Up Project
### Step to set up Oracle 11g Database On Windows OS
1. Download and install Oracle Database( version 11g release 2)
- Download the Oracle 11g Database
- Unzip the file
- Run the setup.exe 
2. Download Eclipse EE IDE
- Start a New Dynamic Web Project
- Set up Target Runtime -> Apache Tomcat v.9.0+
- Next -> Generate web.xml deployment descriptor
3. Import the JDBC driver to Project
- Open the folder where Oracle is installed. looking for the folder named oraclexe
- Go to app -> oracle -> product -> 11.2.0 (the version of the database) -> server -> JDBC -> lib
- Copy ojdbc6.jar into WEB-INF/lib.
4. Import the JSP JAR files to Project
- _For Windows OS_:
    - JSP : jstl-1.2.jar
- _For Mac OS/ Linux OS_:
    - JSP: jakarta.servlet.jsp.jstl-2.0.0.jar
    - JSP: jakarta.servlet.jsp.jstl-api-2.0.0.jar

--> All JAR files have to be place in : folder lib in WEB-INF ( WEB-INF/lib ) 


## Now, start to import MOVIE REVIEW APPLICATION
- Install and import code from Github
- Oracle JDBC Driver communicates with the server to connect and process data in Oracle Database. The connection using jdbcURL:jdbc:oracle:thin:@localhost:1521:xe, User: "hr", Password: 'hr' and needed to be modified when import to match your DBMS.
- The application using Apache Tomcat which is a Java application server for building and deploying Java Web applications. Accessible with URL: http://localhost:8081/MovieReviewProject/ when run.


Clone the repository, open the project in your Eclipse IDE. 
Modify jdbcURL, User, Password to match your database connection
Click on the project and run it as "Run on Server", choose Tomcat and finish.
Use browser http://localhost:8081/MovieReviewProject/ on your local browser to access the application. 


![home.png](https://drive.google.com/u/2/uc?id=1z_9nsu2ZVClhk-CCRXpsplD5mlEEQpJW&export=download)

![review.png](https://drive.google.com/u/2/uc?id=1r6yHih0EbBlYt99-aK1veZYwcpC5nJNu&export=download)
