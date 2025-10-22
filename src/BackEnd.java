
// Source code is decompiled from a .class file using FernFlower decompiler.
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class BackEnd {


   private Connection connection;

   public BackEnd() {
      try{
         // set up connection to the database
         Properties prop = new Properties();
         String fileName = "auth.cfg"; //
        try {
            FileInputStream configFile = new FileInputStream(fileName);
            prop.load(configFile);
            configFile.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Could not find config file.");
            System.exit(1);
        } catch (IOException ex) {
            System.out.println("Error reading config file.");
            System.exit(1);
        }
        String username = (prop.getProperty("username"));
        String password = (prop.getProperty("password"));

        if (username == null || password == null){
            System.out.println("Username or password not provided.");
            System.exit(1);
        }

        String connectionUrl =
                "jdbc:sqlserver://uranium.cs.umanitoba.ca:1433;"
                + "database=cs3380;"
                + "user=" + username + ";"
                + "password="+ password +";"
                + "encrypt=false;"
                + "trustServerCertificate=false;"
                + "loginTimeout=30;";
         System.out.println("Successfully connected to the database");

          connection = DriverManager.getConnection(connectionUrl);
     }
     catch(Exception e){
         e.printStackTrace();
     }
     
     /* 
     
      try {
         Class.forName("org.hsqldb.jdbcDriver");    //change to the jdbc we got
         this.connection = DriverManager.getConnection("jdbc:hsqldb:mem:mymemdb", "SA", "");
         this.createTables();
         this.readInData();
      } catch (ClassNotFoundException var2) {
         var2.printStackTrace(System.out);
      } catch (SQLException var3) {
         var3.printStackTrace(System.out);
      }
      */

   }  
 


public void showTeam( ) {                              //need change
      try {
         String sqlString ="SELECT Name, Win, Draw, Lost, Goal, Concede, City_Name, SponsorshipID FROM Team" ;

         PreparedStatement statement = connection.prepareStatement(sqlString);

         ResultSet resultSet = statement.executeQuery();

         while(resultSet.next()) {
            PrintStream var10000 = System.out;
            String var10001 = resultSet.getString("Name");
            var10000.println("" + var10001 + " - " + 
            " Win: " +  resultSet.getInt("Win") + 
            " Draw: " + resultSet.getInt("Draw") +
            " Lost: " + resultSet.getInt("Lost") +
            " Goal: " + resultSet.getInt("Goal") +
            " Concede: " + resultSet.getInt("Concede") +
            " City_Name: " + resultSet.getString("City_Name") +
            " SponsorshipID " + resultSet.getInt("SponsorshipID") 
            );
         }
         statement.close();
         resultSet.close();
      } catch (SQLException var3) {
         var3.printStackTrace(System.out);
      }

   }


   public void showEmployee( ) {
      try {
         String sqlString ="SELECT EmployeeID, nationality, name, age, Team_name, Employee_Type, position, appearances, goals, assists, minutes_play FROM Employee" ;

         PreparedStatement statement = connection.prepareStatement(sqlString);

         ResultSet resultSet = statement.executeQuery();

         while(resultSet.next()) {
            PrintStream var10000 = System.out;
            int var10001 = resultSet.getInt("EmployeeID");
            var10000.println("" + var10001 + " - " + 
            " nationality: " +  resultSet.getString("nationality") + 
            " name: " + resultSet.getString("name") +
            " age: " + resultSet.getInt("age") +
            " Team_name: " + resultSet.getString("Team_name") +
            " Employee_Type: " + resultSet.getString("Employee_Type") +
            " position: " + resultSet.getString("position") +
            " appearances: " + resultSet.getInt("appearances") +
            " goals: " + resultSet.getInt("goals") +
            " assists: " + resultSet.getInt("assists") +
            " minutes_play: " + resultSet.getInt("minutes_play")
            );
         }
         statement.close();
         resultSet.close();
      } catch (SQLException var3) {
         var3.printStackTrace(System.out);
      }

   }

      // show all city
      public void showCity( ) {    
         try {
            String sqlString ="SELECT city, Population, Number_of_Premier_league_team FROM City;" ;
   
            PreparedStatement statement = connection.prepareStatement(sqlString);
   
            ResultSet resultSet = statement.executeQuery();
   
            while(resultSet.next()) {
               PrintStream var10000 = System.out;
               String var10001 = resultSet.getString("city");
               var10000.println("" + var10001 + " - " + 
               " Population: " +  resultSet.getInt("Population") + 
               " Number_of_Premier_league_team: " + resultSet.getInt("Number_of_Premier_league_team") 
            );
         }
            statement.close();
            resultSet.close();
         } catch (SQLException var3) {
            var3.printStackTrace(System.out);
         }
   
      }

         // show all Award
   public void showAward( ) {    //need Award
      try {
         String sqlString ="SELECT AwardID, AwardName from Award;" ;

         PreparedStatement statement = connection.prepareStatement(sqlString);

         ResultSet resultSet = statement.executeQuery();

         while(resultSet.next()) {
            PrintStream var10000 = System.out;
            int var10001 = resultSet.getInt("AwardID");
            var10000.println("" + var10001 + " - " + 
               " AwardName: " +  resultSet.getString("AwardName") 
               );
            }



         statement.close();
         resultSet.close();
      } catch (SQLException var3) {
         var3.printStackTrace(System.out);
      }

   }

   /*SELECT Stadium_ID, Team_Name, Capacity, City, Confederation FROM Stadium;
SELECT SponsorshipID, Sponsor_Name from Main_SponsorShip;
SELECT RefereeID, Name, Date_of_birth, Nationality, Number_of_Matches, red, yellow FROM HeadReferee;
SELECT MatchID, Match_Day_Number, Home_Team, AwayTeam, RefID, Attendance FROM Matches;
SELECT Home_Team, AwayTeam, Score from Score;
SELECT AwardID, EmployeeID from GetAward;
SELECT SponsorshipID, Team_name, amount from GetSponsor;
SELECT Goal, Concede, Goal_Difference from GoalDifference;
SELECT Win, Draw, Lost, Point from TeamPoint;
SELECT Home_Team, StaID from HomeStadium;
SELECT MatchID, Team_name from Play;
       */

         // show all stadium
         public void showStadium( ) {    //need change
            try {
               String sqlString ="SELECT Stadium_ID, Team_Name, Capacity, City, Confederation FROM Stadium" ;
      
               PreparedStatement statement = connection.prepareStatement(sqlString);
      
               ResultSet resultSet = statement.executeQuery();
      
               while(resultSet.next()) {
                  PrintStream var10000 = System.out;
                  int var10001 = resultSet.getInt("Stadium_ID");
                  var10000.println("" + var10001 + " - " +
                  " Team_Name: " +  resultSet.getString("Team_Name") +
                  " Capacity: " +  resultSet.getInt("Capacity") +
                  " City: " +  resultSet.getString("City") +
                  " Confederation: " +  resultSet.getString("Confederation")
                  );
               }
               statement.close();
               resultSet.close();
            } catch (SQLException var3) {
               var3.printStackTrace(System.out);
            }
      
         }
         

          // show all main sponsorship
   public void showMainSponsorship( ) {    //need change
      try {
         String sqlString ="Select SponsorshipID, Sponsor_Name from Main_SponsorShip" ;

         PreparedStatement statement = connection.prepareStatement(sqlString);

         ResultSet resultSet = statement.executeQuery();

         while(resultSet.next()) {
            PrintStream var10000 = System.out;
            int var10001 = resultSet.getInt("SponsorshipID");
                  var10000.println("" + var10001 + " - " +
                  " Sponsor_Name: " +  resultSet.getString("Sponsor_Name") 
            );
         }



         statement.close();
         resultSet.close();
      } catch (SQLException var3) {
         var3.printStackTrace(System.out);
      }

   }

     // show all HeadReferee
     public void showHeadReferee( ) {    //need change
      try {
         String sqlString ="SELECT RefereeID, Name, Date_of_birth, Nationality, Number_of_Matches, red, yellow FROM HeadReferee;" ;

         PreparedStatement statement = connection.prepareStatement(sqlString);

         ResultSet resultSet = statement.executeQuery();

         while(resultSet.next()) {
            PrintStream var10000 = System.out;
            int var10001 = resultSet.getInt("RefereeID");
            var10000.println("" + var10001 + " - " +
            " Name: " +  resultSet.getString("Name") +
            " Date_of_birth: " +  resultSet.getString("Date_of_birth") +
            " Nationality: " +  resultSet.getString("Nationality") +
            " Number_of_Matches: " +  resultSet.getInt("Number_of_Matches") +
            " red: " +  resultSet.getInt("red") +
            " yellow: " +  resultSet.getInt("yellow") 
            );
         }
         statement.close();
         resultSet.close();
      } catch (SQLException var3) {
         var3.printStackTrace(System.out);
      }

   }

         // show all Matches
         public void showMatches( ) {    //need change
            try {
               String sqlString ="SELECT MatchID, Match_Day_Number, Home_Team, AwayTeam, RefID, Attendance FROM Matches;" ;
      
               PreparedStatement statement = connection.prepareStatement(sqlString);
      
               ResultSet resultSet = statement.executeQuery();
      
               while(resultSet.next()) {
                  PrintStream var10000 = System.out;
                  int var10001 = resultSet.getInt("MatchID");
                  var10000.println("" + var10001 + " - " +
                  " Match_Day_Number: " +  resultSet.getInt("Match_Day_Number") +
                  " Home_Team: " +  resultSet.getString("Home_Team") +
                  " AwayTeam: " +  resultSet.getString("AwayTeam") +
                  " RefID: " +  resultSet.getInt("RefID") +
                  " Attendance: " +  resultSet.getInt("Attendance") 
                  );
               }
      
      
      
               statement.close();
               resultSet.close();
            } catch (SQLException var3) {
               var3.printStackTrace(System.out);
            }
      
         }


               // show all Score
   public void showScore( ) {    //need change
      try {
         String sqlString ="SELECT Home_Team, AwayTeam, Score from Score" ;

         PreparedStatement statement = connection.prepareStatement(sqlString);

         ResultSet resultSet = statement.executeQuery();

         while(resultSet.next()) {
            PrintStream var10000 = System.out;
            String var10001 = resultSet.getString("Home_Team");
                  var10000.println("Home_Team " + var10001 +
                  " AwayTeam: " +  resultSet.getString("AwayTeam") +
                  " Score: " +  resultSet.getString("Score")
                  );
               }



         statement.close();
         resultSet.close();
      } catch (SQLException var3) {
         var3.printStackTrace(System.out);
      }

   }

         // show all GetAward
         public void showGetAward( ) {    //need change
            try {
               String sqlString ="SELECT AwardID, EmployeeID from GetAward" ;
      
               PreparedStatement statement = connection.prepareStatement(sqlString);
      
               ResultSet resultSet = statement.executeQuery();
      
               while(resultSet.next()) {
                  PrintStream var10000 = System.out;
                  int var10001 = resultSet.getInt("AwardID");
                  var10000.println("AwardID: " + var10001 + " - " +
                  " EmployeeID: " +  resultSet.getString("EmployeeID") 
                  );
               }
      
      
      
               statement.close();
               resultSet.close();
            } catch (SQLException var3) {
               var3.printStackTrace(System.out);
            }
      
         }

         

      // show all getSponsor
   public void showGetSponsor( ) {    //need change
      try {
         String sqlString ="SELECT SponsorshipID, Team_name, amount from GetSponsor" ;

         PreparedStatement statement = connection.prepareStatement(sqlString);

         ResultSet resultSet = statement.executeQuery();

         while(resultSet.next()) {
            PrintStream var10000 = System.out;
            int var10001 = resultSet.getInt("SponsorshipID");
            var10000.println("" + var10001 + " - " +
            " Team_name: " +  resultSet.getString("Team_name") +
            " amount: " +  resultSet.getInt("amount")
            );
         }



         statement.close();
         resultSet.close();
      } catch (SQLException var3) {
         var3.printStackTrace(System.out);
      }

   }

   

      // show all GoalDiff
      public void showGoalDiff( ) {    //need change
         try {
            String sqlString ="SELECT Goal, Concede, Goal_Difference from GoalDifference" ;
   
            PreparedStatement statement = connection.prepareStatement(sqlString);
   
            ResultSet resultSet = statement.executeQuery();
   
            while(resultSet.next()) {
               PrintStream var10000 = System.out;
               int var10001 = resultSet.getInt("Goal");
                  var10000.println(" Goal: " + var10001 + 
                  " Concede: " +  resultSet.getInt("Concede") +
                  " Goal_Difference: " +  resultSet.getInt("Goal_Difference") 
                  );
               }
   
   
   
            statement.close();
            resultSet.close();
         } catch (SQLException var3) {
            var3.printStackTrace(System.out);
         }
   
      }

      
      

      // show all TeamPoint
   public void showTeamPoint( ) {    //need change
      try {
         String sqlString ="SELECT Win, Draw, Lost, Point from TeamPoint" ;

         PreparedStatement statement = connection.prepareStatement(sqlString);

         ResultSet resultSet = statement.executeQuery();

         while(resultSet.next()) {
            PrintStream var10000 = System.out;
            int var10001 = resultSet.getInt("Win");
            var10000.println(" Win: " + var10001  +
            " Draw: " +  resultSet.getInt("Draw") +
            " Lost: " +  resultSet.getInt("Lost") +
            " Point: " +  resultSet.getInt("Point") 
            );
         }



         statement.close();
         resultSet.close();
      } catch (SQLException var3) {
         var3.printStackTrace(System.out);
      }

   }


   

      // show all HomeStadium
      public void showHomeStadium( ) {    //need change
         try {
            String sqlString ="SELECT Home_Team, StaID from HomeStadium" ;
   
            PreparedStatement statement = connection.prepareStatement(sqlString);
   
            ResultSet resultSet = statement.executeQuery();
   
            while(resultSet.next()) {
               PrintStream var10000 = System.out;
               String var10001 = resultSet.getString("Home_Team");
               var10000.println("" + var10001 + " - " +
               " StaID: " +  resultSet.getString("StaID") 
               );
            }
   
   
   
            statement.close();
            resultSet.close();
         } catch (SQLException var3) {
            var3.printStackTrace(System.out);
         }
   
      }
   

      // show all Play
      public void showPlay( ) {    //need change
         try {
            String sqlString ="SELECT MatchID, Team_name from Play" ;
   
            PreparedStatement statement = connection.prepareStatement(sqlString);
   
            ResultSet resultSet = statement.executeQuery();
   
            while(resultSet.next()) {
               PrintStream var10000 = System.out;
               int var10001 = resultSet.getInt("MatchID");
               var10000.println("" + var10001 + " - " +
               " Team_name: " +  resultSet.getString("Team_name") 
               );
            }
   
   
   
            statement.close();
            resultSet.close();
         } catch (SQLException var3) {
            var3.printStackTrace(System.out);
         }
   
      }
      




/*
 public void showTeam( ) {				//need change
      try {
         String sqlString ="SELECT EmployeeID, name, nationality FROM Employee" ;

         PreparedStatement statement = connection.prepareStatement(sqlString);

         ResultSet resultSet = statement.executeQuery();

         while(resultSet.next()) {
            PrintStream var10000 = System.out;
            int var10001 = resultSet.getInt("EmployeeID");
            var10000.println("" + var10001 + " - " + resultSet.getString("name") +  " Nationality: " + resultSet.getString("nationality"));
         }



         statement.close();
         resultSet.close();
      } catch (SQLException var3) {
         var3.printStackTrace(System.out);
      }

   }





  public void showEmployee( ) {
      try {
         String sqlString ="SELECT EmployeeID, name, nationality FROM Employee" ;

         PreparedStatement statement = connection.prepareStatement(sqlString);
         
         ResultSet resultSet = statement.executeQuery();

         while(resultSet.next()) {
            PrintStream var10000 = System.out;
            int var10001 = resultSet.getInt("EmployeeID");
            var10000.println("" + var10001 + " - " + resultSet.getString("name") +  " Nationality: " + resultSet.getString("nationality"));
         }



         statement.close();
         resultSet.close();
      } catch (SQLException var3) {
         var3.printStackTrace(System.out);
      }

   }
   // show all city
   public void showCity( ) {	//need change
      try {
         String sqlString ="SELECT EmployeeID, name, nationality FROM Employee" ;

         PreparedStatement statement = connection.prepareStatement(sqlString);

         ResultSet resultSet = statement.executeQuery();

         while(resultSet.next()) {
            PrintStream var10000 = System.out;
            int var10001 = resultSet.getInt("EmployeeID");
            var10000.println("" + var10001 + " - " + resultSet.getString("name") +  " Nationality: " + resultSet.getString("nationality"));
         }



         statement.close();
         resultSet.close();
      } catch (SQLException var3) {
         var3.printStackTrace(System.out);
      }

   }

   // show all Award
   public void showAward( ) {    //need Award
      try {
         String sqlString ="SELECT EmployeeID, name, nationality FROM Employee" ;

         PreparedStatement statement = connection.prepareStatement(sqlString);

         ResultSet resultSet = statement.executeQuery();

         while(resultSet.next()) {
            PrintStream var10000 = System.out;
            int var10001 = resultSet.getInt("EmployeeID");
            var10000.println("" + var10001 + " - " + resultSet.getString("name") +  " Nationality: " + resultSet.getString("nationality"));
         }



         statement.close();
         resultSet.close();
      } catch (SQLException var3) {
         var3.printStackTrace(System.out);
      }

   }
	
      // show all stadium
   public void showStadium( ) {    //need change
      try {
         String sqlString ="SELECT EmployeeID, name, nationality FROM Employee" ;

         PreparedStatement statement = connection.prepareStatement(sqlString);

         ResultSet resultSet = statement.executeQuery();

         while(resultSet.next()) {
            PrintStream var10000 = System.out;
            int var10001 = resultSet.getInt("EmployeeID");
            var10000.println("" + var10001 + " - " + resultSet.getString("name") +  " Nationality: " + resultSet.getString("nationality"));
         }



         statement.close();
         resultSet.close();
      } catch (SQLException var3) {
         var3.printStackTrace(System.out);
      }

   }
   
   // show all main sponsorship
   public void showMainSponsorship( ) {    //need change
      try {
         String sqlString ="SELECT EmployeeID, name, nationality FROM Employee" ;

         PreparedStatement statement = connection.prepareStatement(sqlString);

         ResultSet resultSet = statement.executeQuery();

         while(resultSet.next()) {
            PrintStream var10000 = System.out;
            int var10001 = resultSet.getInt("EmployeeID");
            var10000.println("" + var10001 + " - " + resultSet.getString("name") +  " Nationality: " + resultSet.getString("nationality"));
         }



         statement.close();
         resultSet.close();
      } catch (SQLException var3) {
         var3.printStackTrace(System.out);
      }

   }

     // show all HeadReferee
   public void showHeadReferee( ) {    //need change
      try {
         String sqlString ="SELECT EmployeeID, name, nationality FROM Employee" ;

         PreparedStatement statement = connection.prepareStatement(sqlString);

         ResultSet resultSet = statement.executeQuery();

         while(resultSet.next()) {
            PrintStream var10000 = System.out;
            int var10001 = resultSet.getInt("EmployeeID");
            var10000.println("" + var10001 + " - " + resultSet.getString("name") +  " Nationality: " + resultSet.getString("nationality"));
         }



         statement.close();
         resultSet.close();
      } catch (SQLException var3) {
         var3.printStackTrace(System.out);
      }

   }   
 
      // show all Matches
   public void showMatches( ) {    //need change
      try {
         String sqlString ="SELECT EmployeeID, name, nationality FROM Employee" ;

         PreparedStatement statement = connection.prepareStatement(sqlString);

         ResultSet resultSet = statement.executeQuery();

         while(resultSet.next()) {
            PrintStream var10000 = System.out;
            int var10001 = resultSet.getInt("EmployeeID");
            var10000.println("" + var10001 + " - " + resultSet.getString("name") +  " Nationality: " + resultSet.getString("nationality"));
         }



         statement.close();
         resultSet.close();
      } catch (SQLException var3) {
         var3.printStackTrace(System.out);
      }

   }

	
      // show all Score
   public void showScore( ) {    //need change
      try {
         String sqlString ="SELECT EmployeeID, name, nationality FROM Employee" ;
*/

   //1. Search the name of the employee given a string.
   //not so sure what means
   public void employeeByString(String name) {
      try {
         String sqlString ="SELECT EmployeeID, nationality, name, age, Team_name, Employee_Type, position, appearances, goals, assists, minutes_play FROM Employee WHERE LOWER(name) LIKE ?";

         PreparedStatement statement = connection.prepareStatement(sqlString);
         statement.setString(1, "%"+name.toLowerCase()+"%");
         ResultSet resultSet = statement.executeQuery();

         while(resultSet.next()) {
            PrintStream var10000 = System.out;
            String var10001 = resultSet.getString("name");
            var10000.println("" + var10001 + " - " + 
            " nationality: " +  resultSet.getString("nationality") + 
            " EmployeeID: " + resultSet.getInt("EmployeeID") +
            " age: " + resultSet.getInt("age") +
            " Team_name: " + resultSet.getString("Team_name") +
            " Employee_Type: " + resultSet.getString("Employee_Type") +
            " position: " + resultSet.getString("position") +
            " appearances: " + resultSet.getInt("appearances") +
            " goals: " + resultSet.getInt("goals") +
            " assists: " + resultSet.getInt("assists") +
            " minutes_play: " + resultSet.getInt("minutes_play"));
         }
         statement.close();
         resultSet.close();
      } catch (SQLException var3) {
         var3.printStackTrace(System.out);
      }

   }

   //2. Search the name of the employee given an ID.  //tick
   public void emplyeeByID(int id) {
      try {
         String sqlString ="SELECT EmployeeID, nationality, name, age, Team_name, Employee_Type, position, appearances, goals, assists, minutes_play "+
         "FROM Employee"+
         " WHERE EmployeeID = ?";

         PreparedStatement statement = connection.prepareStatement(sqlString);
         statement.setInt(1, id);
         ResultSet resultSet = statement.executeQuery();

         while(resultSet.next()) {
            PrintStream var10000 = System.out;
            int var10001 = resultSet.getInt("EmployeeID");
            var10000.println("" + var10001 + " - " + 
            " nationality: " +  resultSet.getString("nationality") + 
            " name: " + resultSet.getString("name") +
            " age: " + resultSet.getInt("age") +
            " Team_name: " + resultSet.getString("Team_name") +
            " Employee_Type: " + resultSet.getString("Employee_Type") +
            " position: " + resultSet.getString("position") +
            " appearances: " + resultSet.getInt("appearances") +
            " goals: " + resultSet.getInt("goals") +
            " assists: " + resultSet.getInt("assists") +
            " minutes_play: " + resultSet.getInt("minutes_play")
            );
         }
         
         
         statement.close();
         resultSet.close();
      } catch (SQLException var6) {
         var6.printStackTrace(System.out);
      }

   }




   public void GPosition () {
      try {
         String sqlString  = "SELECT position, SUM(goals) AS Total_Goals, SUM(assists) AS Total_Assists, SUM(appearances) AS Total_Appearances"+
         " FROM Employee "+
         "WHERE position IS NOT NULL "+
         "GROUP BY position";
         PreparedStatement statement = connection.prepareStatement(sqlString);
         ResultSet resultSet = statement.executeQuery();

         while(resultSet.next()) {
            PrintStream var10000 = System.out;
            String var10001 = resultSet.getString("position");
            var10000.println("" + var10001 + " - Toal Goals: " + resultSet.getInt("Total_Goals")+
            " Total Assists: "+ resultSet.getInt("Total_Assists")+
            " Total Appearances: "+ resultSet.getInt("Total_Appearances")
            );
         }
         statement.close();
         resultSet.close();
      } catch (SQLException var4) {
         var4.printStackTrace(System.out);
      }
   }


   public void Aattendance () {
      try {
         String sqlString  = "SELECT Match_Day_Number, AVG(Attendance) AS Average_Attendance"+
         " FROM Matches "+
         "GROUP BY Match_Day_Number";
	 PreparedStatement statement = connection.prepareStatement(sqlString);
         ResultSet resultSet = statement.executeQuery();

         while(resultSet.next()) {
            PrintStream var10000 = System.out;
            String var10001 = resultSet.getString("Match_Day_Number");
            var10000.println(" Match Day Number: " + var10001 + 
            " - Avg Attendance: " + resultSet.getInt("Average_Attendance")
            );
         }
         statement.close();
         resultSet.close();
      } catch (SQLException var4) {
         var4.printStackTrace(System.out);
      }
   }

   public void AplayerAge () {
      try {
         String sqlString  = "Select Team_name, AVG(age) AS Average_Player_Age"+
         " FROM Employee "+
         "WHERE Employee_Type = 'Player' "+
         "GROUP BY Team_name";
         PreparedStatement statement = connection.prepareStatement(sqlString);
	 ResultSet resultSet = statement.executeQuery();

         while(resultSet.next()) {
            PrintStream var10000 = System.out;
            String var10001 = resultSet.getString("Team_name");
            var10000.println(" Team name: " + var10001 + 
            " - Average_Player_Age: " + resultSet.getInt("Average_Player_Age")
            );
         }
         statement.close();
         resultSet.close();
      } catch (SQLException var4) {
         var4.printStackTrace(System.out);
      }
   }

   public void Tawards () {
      try {
         String sqlString  = "SELECT Employee.Team_name, COUNT(GetAward.AwardID) AS Awards_Count"+
         " FROM GetAward "+
         "JOIN Employee ON GetAward.EmployeeID = Employee.EmployeeID "+
         "GROUP BY Employee.Team_name ";
         PreparedStatement statement = connection.prepareStatement(sqlString);
	 ResultSet resultSet = statement.executeQuery();

         while(resultSet.next()) {
            PrintStream var10000 = System.out;
            String var10001 = resultSet.getString("Team_name");
            var10000.println(" Team name: " + var10001 + 
            " - Awards_Count: " + resultSet.getInt("Awards_Count")
            );
         }
         statement.close();
         resultSet.close();
      } catch (SQLException var4) {
         var4.printStackTrace(System.out);
      }
   }
   public void matchByRid(int rid) {
      try {
         String sqlString  =  "SELECT Matches.MatchID, Matches.Match_Day_Number, Matches.Home_Team, Matches.Attendance " + //
               "FROM Matches " + //
               "JOIN HeadReferee ON Matches.RefID = HeadReferee.RefereeID " + 
               "WHERE HeadReferee.RefereeID = ?";
         PreparedStatement statement = connection.prepareStatement(sqlString);
         statement.setInt(1, rid);
         ResultSet resultSet = statement.executeQuery();

         while(resultSet.next()) {
            PrintStream var10000 = System.out;
            int var10001 = resultSet.getInt("MatchID");
            var10000.println(" ID: " + var10001 +
            " Match Day Number: "+resultSet.getString("Match_Day_Number")+
            " Home_Team: "+resultSet.getString("Home_Team")+
            " Attendance: "+ resultSet.getInt("Attendance"));
         }
         

         statement.close();
         resultSet.close();
      } catch (SQLException var4) {
         var4.printStackTrace(System.out);
      }

   }
/*
   public void teamByCity (String var1) {
      try {
         String var2 = "";
         Statement var3 = this.connection.createStatement();
         ResultSet var4 = var3.executeQuery(var2);

         while(var4.next()) {
            PrintStream var10000 = System.out;
            String var10001 = var4.getString("name");
            var10000.println(var10001 + ":" + var4.getDouble("amount"));
         }

         var4.close();
         var3.close();
      } catch (SQLException var5) {
         var5.printStackTrace(System.out);
      }

   }
*/
   //tick
   public void matchBySameCity() {
      try {
         String sqlString = "SELECT Matches.MatchID, Matches.Home_Team, Matches.AwayTeam, Score.Score, City.city" +
	       " FROM Matches" +
	       " JOIN Team AS HomeTeam ON Matches.Home_Team = HomeTeam.Name" +
	       " JOIN Team AS AwayTeam ON Matches.AwayTeam = AwayTeam.Name" +
	       " JOIN City ON HomeTeam.City_Name = City.city AND AwayTeam.City_Name = City.city" +
	       " LEFT JOIN Score ON Matches.Home_Team = Score.Home_Team AND Matches.AwayTeam = Score.AwayTeam" +
	       " WHERE HomeTeam.City_Name = AwayTeam.City_Name";
         PreparedStatement statement = connection.prepareStatement(sqlString);
         ResultSet resultSet = statement.executeQuery();
         while(resultSet.next()) {
            PrintStream var10000 = System.out;
            int var10001 = resultSet.getInt("MatchID");
            var10000.println(" ID: " + var10001 + 
            " - Home Team: "+resultSet.getString("Home_Team")+
            " Away Team: "+ resultSet.getString("AwayTeam"));
         }
         statement.close();
         resultSet.close();
      } catch (SQLException var4) {
         var4.printStackTrace(System.out);
      }

   }

   public void PHSponsorship() {
      try {
         String sqlString = "SELECT Employee.name, COUNT(GetAward.AwardID) AS NumberOfAwards" + 
               " FROM Employee" + 
               " JOIN GetAward ON Employee.EmployeeID = GetAward.EmployeeID" +
               " JOIN GetSponsor ON Employee.Team_name = GetSponsor.Team_name" + 
               " GROUP BY Employee.name" + 
               " HAVING SUM(GetSponsor.amount) > 100000000" + 
               " ORDER BY NumberOfAwards DESC";
         PreparedStatement statement = connection.prepareStatement(sqlString);
         ResultSet resultSet = statement.executeQuery();
         while(resultSet.next()) {
            PrintStream var10000 = System.out;
            String var10001 = resultSet.getString("name");
            var10000.println(" Name: " + var10001 + 
            " - NumberOfAwards: "+resultSet.getInt("NumberOfAwards")
            );
         }
         statement.close();
         resultSet.close();
      } catch (SQLException var4) {
         var4.printStackTrace(System.out);
      }
   }

   public void TattendanceHome() {
      try {
         String sqlString = "SELECT Team.Name, SUM(Matches.Attendance) AS Total_Attendances" + 
               " FROM Team" + 
               " JOIN Play ON Team.Name = Play.Team_name" +
               " JOIN Matches ON Play.MatchID = Matches.MatchID" + 
               " WHERE Team.Name = Matches.Home_Team" + 
               " GROUP BY Team.Name" + 
               " ORDER BY Total_Attendances DESC";
         PreparedStatement statement = connection.prepareStatement(sqlString);
         ResultSet resultSet = statement.executeQuery();
         while(resultSet.next()) {
            PrintStream var10000 = System.out;
            String var10001 = resultSet.getString("Name");
            var10000.println(" Name: " + var10001 + 
            " - Total Attendances: "+resultSet.getInt("Total_Attendances")
            );
         }
         statement.close();
         resultSet.close();
      } catch (SQLException var4) {
         var4.printStackTrace(System.out);
      }
   }


   public void Referee50000() {
      try {
         String sqlString = "SELECT HeadReferee.Name, COUNT(Number_of_Matches) AS Matches_Officiated" + 
               " FROM HeadReferee" + 
               " JOIN Matches ON HeadReferee.RefereeID = Matches.RefID" +
               " WHERE Matches.Attendance > 50000" + 
               " GROUP BY HeadReferee.Name" + 
               " ORDER BY Matches_Officiated DESC" ;
         PreparedStatement statement = connection.prepareStatement(sqlString);
         ResultSet resultSet = statement.executeQuery();
         while(resultSet.next()) {
            PrintStream var10000 = System.out;
            String var10001 = resultSet.getString("Name");
            var10000.println(" Name: " + var10001 + 
            " - Matches Officiated: "+resultSet.getInt("Matches_Officiated")
            );
         }
         statement.close();
         resultSet.close();
      } catch (SQLException var4) {
         var4.printStackTrace(System.out);
      }
   }

   public void TopScorers() {
      try {
         String sqlString = "WITH TeamGoalDifference AS ("+
            "SELECT Name, Goal_Difference"+
            " FROM Team"+
            " Join GoalDifference ON Team.Goal = GoalDifference.Goal AND Team.Concede = GoalDifference.Concede"+
            ")"+
            "SELECT E.name, E.goals, E.Team_name"+
            " FROM Employee E"+
            " INNER JOIN ("+
            " SELECT Team_name, MAX(goals) AS MaxGoals"+
            " FROM Employee"+
            " WHERE Team_name IN ("+
            "    SELECT Name FROM TeamGoalDifference WHERE Goal_Difference < 0 "+
            ")"+
            " GROUP BY Team_name"+
            ") AS TopScorers ON E.Team_name = TopScorers.Team_name AND E.goals = TopScorers.MaxGoals"+
            " JOIN Team T ON E.Team_name = T.Name"+
            " ORDER By goals DESC;" ;
         PreparedStatement statement = connection.prepareStatement(sqlString);
         ResultSet resultSet = statement.executeQuery();
         while(resultSet.next()) {
            PrintStream var10000 = System.out;
            String var10001 = resultSet.getString("name");
            var10000.println(" Name: " + var10001 + 
            " - goals: "+resultSet.getInt("goals")+
            " Team: "+resultSet.getString("Team_name")
            );
         }
         statement.close();
         resultSet.close();
      } catch (SQLException var4) {
         var4.printStackTrace(System.out);
      }
   }

   public void CityCnT() {
      try {
         String sqlString = "SELECT City.city, SUM(Stadium.Capacity) AS Total_Stadium_Capacity, COUNT(DISTINCT Team.Name) AS Number_of_Teams" + 
               " FROM City" + 
               " JOIN Team ON City.city = Team.City_Name" +
               " LEFT JOIN Stadium ON Team.Name = Stadium.Team_Name" + 
               " GROUP BY City.city" + 
               " ORDER BY Total_Stadium_Capacity DESC, Number_of_Teams DESC" ;
         PreparedStatement statement = connection.prepareStatement(sqlString);
         ResultSet resultSet = statement.executeQuery();
         while(resultSet.next()) {
            PrintStream var10000 = System.out;
            String var10001 = resultSet.getString("city");
            var10000.println(" City: " + var10001 + 
            " -  Total Stadium Capacity: "+resultSet.getInt("Total_Stadium_Capacity")+
            " Number of Teams: "+resultSet.getInt("Number_of_Teams")
            );
         }
         statement.close();
         resultSet.close();
      } catch (SQLException var4) {
         var4.printStackTrace(System.out);
      }
   }


   public void CityLargenLowest() {
      try {
         String sqlString = "SELECT City.city, MAX(Stadium.Capacity) AS Largest_Stadium_Capacity, MIN(TP.Point) AS Lowest_Team_Points" + 
               " FROM City" + 
               " JOIN Stadium ON City.city = Stadium.City" +
               " JOIN Team ON Stadium.Team_Name = Team.Name" + 
               " JOIN TeamPoint AS TP ON Team.Win = TP.Win AND Team.Draw = TP.Draw AND Team.Lost = TP.Lost" + 
               " GROUP BY City.city"+
               " ORDER BY Largest_Stadium_Capacity DESC, Lowest_Team_Points ASC" ;
         PreparedStatement statement = connection.prepareStatement(sqlString);
         ResultSet resultSet = statement.executeQuery();
         while(resultSet.next()) {
            PrintStream var10000 = System.out;
            String var10001 = resultSet.getString("city");
            var10000.println(" City: " + var10001 + 
            " -  Largest Stadium Capacity: "+resultSet.getInt("Largest_Stadium_Capacity")+
            " Lowest_Team_Points: "+resultSet.getInt("Lowest_Team_Points")
            );
         }
         statement.close();
         resultSet.close();
      } catch (SQLException var4) {
         var4.printStackTrace(System.out);
      }
   }
/*
   //3. Matches that are control by a referee, using the referee’s ID. (Join referee table with matches table) 
   
   //tick
   //add RefID***
   public void matchByRid(int rid) {
      try {
         String sqlString  =  "SELECT Matches.RefID, Matches.MatchID, Matches.Match_Day_Number, Matches.Home_Team, Matches.Attendance " + //
               "FROM Matches " + //
               "JOIN HeadReferee ON Matches.RefID = HeadReferee.RefereeID " + 
               "WHERE HeadReferee.RefereeID = ?";
         PreparedStatement statement = connection.prepareStatement(sqlString);
         statement.setInt(1, rid);
         ResultSet resultSet = statement.executeQuery();

         while(resultSet.next()) {
            PrintStream var10000 = System.out;
            int var10001 = resultSet.getInt("Matches.RefID");
            var10000.println("" + var10001 + " - " + resultSet.getInt("Matches.MatchID")+" "+ resultSet.getInt("Matches.Match_Day_Number")+
            " "+resultSet.getString("Matches.Home_Team")+" "+ resultSet.getInt("Matches.Attendance"));
         }
         

         statement.close();
         resultSet.close();
      } catch (SQLException var4) {
         var4.printStackTrace(System.out);
      }

   }

   public void teamByCity (String var1) {
      try {
         String var2 = "";
         Statement var3 = this.connection.createStatement();
         ResultSet var4 = var3.executeQuery(var2);

         while(var4.next()) {
            PrintStream var10000 = System.out;
            String var10001 = var4.getString("name");
            var10000.println(var10001 + ":" + var4.getDouble("amount"));
         }

         var4.close();
         var3.close();
      } catch (SQLException var5) {
         var5.printStackTrace(System.out);
      }

   }

   //tick
   public void matchBySameCity() {
      try {
         String sqlString = "SELECT m.MatchID, m.Home_Team, m2.AwayTeam" + 
               "FROM Matches m" + 
               "JOIN Stadium s1 ON m.Home_Team = s1.Team_Name" +
               "JOIN City c1 ON s1.City = c1.city" + 
               "JOIN AwayTeam m2 ON m.Match_Day_Number = m2.Match_Day_Number AND m.Home_Team = m2.Home_Team" + 
               "JOIN Stadium s2 ON m2.AwayTeam = s2.Team_Name" + 
               "JOIN City c2 ON s2.City = c2.city" + 
               "WHERE c1.city = c2.city;";
         PreparedStatement statement = connection.prepareStatement(sqlString);
         ResultSet resultSet = statement.executeQuery();
         while(resultSet.next()) {
            PrintStream var10000 = System.out;
            int var10001 = resultSet.getInt("Matches.RefID");
            var10000.println("" + var10001 + " - " + resultSet.getInt("m.MatchID")+
            " "+resultSet.getString("m.Home_Team")+" "+ resultSet.getInt("m2.AwayTeam"));
         }
         statement.close();
         resultSet.close();
      } catch (SQLException var4) {
         var4.printStackTrace(System.out);
      }

   }

   //*******************Impliment**********************/
  /* public void playersExceed10(String var1) {
      try {
         String var2 = "delete from councilors where name = '" + var1 + "';";
         Statement var3 = this.connection.createStatement();
         var3.execute(var2);
         var3.close();
      } catch (SQLException var4) {
         var4.printStackTrace(System.out);
      }

   }

   //*******************Impliment**********************/
   /*public void topAttendance() {
      try {
         Statement var1 = this.connection.createStatement();
         ResultSet var2 = var1.executeQuery("Select name, max(amount) as amount from councilors join expenses on councilors.cID = expenses.cID  group by councilors.name;");

         while(var2.next()) {
            PrintStream var10000 = System.out;
            String var10001 = var2.getString("name");
            var10000.println(var10001 + ": " + var2.getDouble("amount"));
         }

         var2.close();
         var1.close();
      } catch (SQLException var3) {
         var3.printStackTrace(System.out);
      }

   }

   //*******************Impliment**********************/
   /*public void topSponsor() {
      try {
         Statement var1 = this.connection.createStatement();
         ResultSet var2 = var1.executeQuery("Select name, max(amount) as amount from councilors join expenses on councilors.cID = expenses.cID  group by councilors.name;");

         while(var2.next()) {
            PrintStream var10000 = System.out;
            String var10001 = var2.getString("name");
            var10000.println(var10001 + ": " + var2.getDouble("amount"));
         }

         var2.close();
         var1.close();
      } catch (SQLException var3) {
         var3.printStackTrace(System.out);
      }

   }

   //*******************Impliment**********************/
   /*public void top5Population() {
      try {
         Statement var1 = this.connection.createStatement();
         ResultSet var2 = var1.executeQuery("Select name, max(amount) as amount from councilors join expenses on councilors.cID = expenses.cID  group by councilors.name;");

         while(var2.next()) {
            PrintStream var10000 = System.out;
            String var10001 = var2.getString("name");
            var10000.println(var10001 + ": " + var2.getDouble("amount"));
         }

         var2.close();
         var1.close();
      } catch (SQLException var3) {
         var3.printStackTrace(System.out);
      }

   }

   //tick
   public void avgAge(String Player) {
      try {

         String sqlString = "SELECT Team_name, AVG(age) AS Average_Player_Age"+
         "FROM Employee"+
         "WHERE Employee_Type = "+ Player +
         "GROUP BY Team_name";
         PreparedStatement statement = connection.prepareStatement(sqlString);
         ResultSet resultSet = statement.executeQuery(); 

          while(resultSet.next()) {
            PrintStream var10000 = System.out;
            int var10001 = resultSet.getInt("Matches.RefID");
            var10000.println("" + var10001 + " - " + resultSet.getInt("Team_name")+
            " "+ resultSet.getInt("Average_Player_Age"));
         }
         statement.close();
         resultSet.close();
      } catch (SQLException var3) {
         var3.printStackTrace(System.out);
      }

   }

   //*******************Impliment**********************/
   /*public void mostAwardTeam() {
      try {
         Statement var1 = this.connection.createStatement();
         ResultSet var2 = var1.executeQuery("Select name, max(amount) as amount from councilors join expenses on councilors.cID = expenses.cID  group by councilors.name;");

         while(var2.next()) {
            PrintStream var10000 = System.out;
            String var10001 = var2.getString("name");
            var10000.println(var10001 + ": " + var2.getDouble("amount"));
         }

         var2.close();
         var1.close();
      } catch (SQLException var3) {
         var3.printStackTrace(System.out);
      }

   }

*/
   /* 
   //????????????????????????????????????????????????????????//
   private void createTables() {
      try {
         this.connection.createStatement().executeUpdate("create table wards (  wardID integer, name VARCHAR(60), primary key(wardID))");
         this.connection.createStatement().executeUpdate("create table councilors ( cID integer IDENTITY, wardID integer, name VARCHAR(60), primary key(cID), foreign key (wardID) references wards);");
         this.connection.createStatement().executeUpdate("create table expenses ( eID integer IDENTITY, cID integer, description VARCHAR(200),  account VARCHAR(60),  amount DECIMAL, primary key (eID, cID), foreign key (cID) references councilors on delete cascade);");
      } catch (SQLException var2) {
         var2.printStackTrace(System.out);
      }

   }

   public void allWards() {
      try {
         Statement var1 = this.connection.createStatement();
         ResultSet var2 = var1.executeQuery("Select * from wards;");

         while(var2.next()) {
            PrintStream var10000 = System.out;
            int var10001 = var2.getInt("wardID");
            var10000.println("" + var10001 + ": " + var2.getString("name"));
         }

         var2.close();
         var1.close();
      } catch (SQLException var3) {
         var3.printStackTrace(System.out);
      }

   }

   private int getOrMakeWard(String var1, String var2) {
      int var3 = -1;

      try {
         PreparedStatement var4 = this.connection.prepareStatement("Select * From  wards where wardID = ?;");
         var4.setInt(1, Integer.parseInt(var1));
         ResultSet var5 = var4.executeQuery();
         if (var5.next()) {
            var3 = var5.getInt("wardID");
         } else {
            PreparedStatement var6 = this.connection.prepareStatement("insert into wards (wardID, name) values (?, ?);");
            var3 = Integer.parseInt(var1);
            var6.setInt(1, var3);
            var6.setString(2, var2);
            var6.executeUpdate();
            var6.close();
         }

         var5.close();
         var4.close();
      } catch (SQLException var7) {
         var7.printStackTrace(System.out);
      }

      return var3;
   }

   private int getOrMakeCouncilor(String var1, int var2) {
      int var3 = -1;

      try {
         PreparedStatement var4 = this.connection.prepareStatement("Select cID From  councilors where name = ?;");
         var4.setString(1, var1);
         ResultSet var5 = var4.executeQuery();
         if (var5.next()) {
            var3 = var5.getInt("cID");
         } else {
            PreparedStatement var6 = this.connection.prepareStatement("insert into councilors (name, wardID) values (?, ?);", 1);
            var6.setString(1, var1);
            var6.setInt(2, var2);
            var6.executeUpdate();
            ResultSet var7 = var6.getGeneratedKeys();
            if (var7.next()) {
               var3 = var7.getInt(1);
            }

            var6.close();
         }

         var5.close();
         var4.close();
      } catch (SQLException var8) {
         var8.printStackTrace(System.out);
      }

      return var3;
   }

   private void readInData() {
      try {
         BufferedReader var1 = new BufferedReader(new FileReader("Council_Member_Expenses.csv"));
         var1.readLine();

         for(String var2 = var1.readLine(); var2 != null; var2 = var1.readLine()) {
            String[] var3 = var2.split(",");
            int var4 = this.getOrMakeCouncilor(var3[2], this.getOrMakeWard(var3[0], var3[1]));
            PreparedStatement var5 = this.connection.prepareStatement("insert into expenses  (cID, description, account, amount) values (?, ?, ?, ?);");
            var5.setInt(1, var4);
            int var6 = var3.length;
            var5.setString(2, var3[var6 - 3]);
            var5.setString(3, var3[var6 - 2]);
            var5.setDouble(4, Double.parseDouble(var3[var6 - 1]));
            var5.executeUpdate();
            var5.close();
         }

         var1.close();
      } catch (IOException var7) {
         var7.printStackTrace();
      } catch (SQLException var8) {
         var8.printStackTrace(System.out);
      }

   }*/
}


