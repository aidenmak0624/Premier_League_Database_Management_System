
    // Source code is decompiled from a .class file using FernFlower decompiler.
import java.sql.Connection;
import java.util.Scanner;

public class FrontEnd {
   static Connection connection;

   public FrontEnd(){

   }

   public static void main(String[] backend) throws Exception {
      runConsole(new BackEnd());
      System.out.println("Exiting...");
   }

   public static void runConsole(BackEnd backend) {
      Scanner scanner = new Scanner(System.in);
      System.out.print("db > ");
      String string = scanner.nextLine();


for(String var3 = ""; string != null && !string.equalsIgnoreCase("q"); string = scanner.nextLine()) {
    String[] var4 = string.split("\\s+");
    if (string.indexOf(" ") > 0) {
       var3 = string.substring(string.indexOf(" ")).trim();
    }

    //print help
    if (var4[0].equalsIgnoreCase("h")) {
       printHelp();
    }
    //print show Table
    else if (var4[0].equalsIgnoreCase("employee")) {
        backend.showEmployee();
    }
    else if (var4[0].equalsIgnoreCase("team")) {
        backend.showTeam();
    }
    else if (var4[0].equalsIgnoreCase("city")) {
        backend.showCity();
    }
    else if (var4[0].equalsIgnoreCase("award")) {
        backend.showAward();
    }
    else if (var4[0].equalsIgnoreCase("stadium")) {
        backend.showStadium();
    }
    else if (var4[0].equalsIgnoreCase("mainsponsorship")) {
        backend.showMainSponsorship();
    }
    else if (var4[0].equalsIgnoreCase("HeadReferee")) {
        backend.showHeadReferee();
    }
    else if (var4[0].equalsIgnoreCase("Matches")) {
        backend.showMatches();
    }
    else if (var4[0].equalsIgnoreCase("Score")) {
        backend.showScore();;
    }
    else if (var4[0].equalsIgnoreCase("GetAward")) {
        backend.showGetAward();
    }
    else if (var4[0].equalsIgnoreCase("GetSponsor")) {
        backend.showGetSponsor();
    }
    else if (var4[0].equalsIgnoreCase("GoalDiff")) {
        backend.showGoalDiff();
    }
    else if (var4[0].equalsIgnoreCase("TeamPoint")) {
        backend.showTeamPoint();
    }
    else if (var4[0].equalsIgnoreCase("HomeStadium")) {
        backend.showHomeStadium();
    }
    else if (var4[0].equalsIgnoreCase("Play")) {
        backend.showPlay();
    }
    // show Queries
    else if (var4[0].equalsIgnoreCase("ec")) {
        try {
            if (var4.length >= 2) {
                backend.employeeByString(var3);                                      //just ignore
            } else {
               System.out.println("Require an argument for this command");
            }
         } catch (Exception notString) {
            System.out.println("name must be a string");
         }
    }
    else if (var4[0].equalsIgnoreCase("eid")) {
        try {
            if (var4.length >= 2) {
                backend.emplyeeByID(Integer.valueOf(var3));                                        //just ignore
            } else {
               System.out.println("Require an argument for this command");
            }
         } catch (Exception notInteger) {
            System.out.println("id must be an integer");
         }
       
    }
    else if (var4[0].equalsIgnoreCase("mrid")) {
        try {
            if (var4.length >= 2) {
                backend.matchByRid(Integer.valueOf(var3));                                      //just ignore
            } else {
               System.out.println("Require an argument for this command");
            }
         } catch (Exception notInteger) {
            System.out.println("id must be an integer");
         }
    }
    else if (var4[0].equalsIgnoreCase("gpo")) {
       backend.GPosition();
    }
    else if (var4[0].equalsIgnoreCase("aat")) {
        backend.Aattendance();
    }
    else if (var4[0].equalsIgnoreCase("apl")) {
        backend.AplayerAge();
    }
    else if (var4[0].equalsIgnoreCase("taw")) {
        backend.Tawards();
    }
    else if (var4[0].equalsIgnoreCase("mbsc")) {
        backend.matchBySameCity();
    }
    else if (var4[0].equalsIgnoreCase("phs")) {
        backend.PHSponsorship();
    }
    else if (var4[0].equalsIgnoreCase("tah")) {
        backend.TattendanceHome();
    }
    else if (var4[0].equalsIgnoreCase("ref5")) {
        backend.Referee50000();
    }
    else if (var4[0].equalsIgnoreCase("tops")) {
        backend.TopScorers();
    }
    else if (var4[0].equalsIgnoreCase("cct")) {
        backend.CityCnT();
    }
    else if (var4[0].equalsIgnoreCase("cll")) {
        backend.CityLargenLowest();
    }
    else {
      System.out.println("Read the help with h, or find help somewhere else.");
   }

   System.out.print("db > ");
}

scanner.close();
}

private static void printHelp() {    //change to the quiery we goti
    System.out.println("Winnipeg Council Member Expenses console");
    System.out.println("Commands:");
    System.out.println("h - Get help");
    System.out.println("EMPLOYEE - Print Employee Table");
    System.out.println("TEAM - Print Team Table");
    System.out.println("CITY - Print City Table");
    System.out.println("AWARD - Print Award Table");
    System.out.println("STADIUM - Print Stadium Table");
    System.out.println("MAINSPONSORSHIP - Print MainSponsorship Table");
    System.out.println("HEADREFEREE - Print Head Referee Table");
    System.out.println("MATCHES - Print Matches Table");
    System.out.println("SCORE - Print Score Table");
    System.out.println("GETAWARD - Print GetAward Table");
    System.out.println("GETSPONSOR - Print GetSponsor Table");
    System.out.println("GOALDIFF - Print GoalDiff Table");
    System.out.println("TEAMPOINT - Print TeamPoint Table");
    System.out.println("HOMESTADIUM - Print HomeStadium Table");
    System.out.println("PLAY - Print Play Table");

    System.out.println("ec - Print Employee name by 'character'");
    System.out.println("eid - Print Employee name by 'employee ID'");
    System.out.println("mrid - Print Match controlled by Referee 'ID'");
    System.out.println("gpo - Print employees by their position (like midfielder, defender, etc.) and calculates total goals, assists, and appearances");
    System.out.println("aat - the average attendance for each match day");
    System.out.println("apl - Print average player Age per Team");
    System.out.println("taw - Print the number of awards won by each team");
    System.out.println("mbsc - Print a list of matches played by 2 teams from the same city ");
    System.out.println("phs - Print Players with Most Awards in Teams with High Sponsorships(Over 100 millions");
    System.out.println("tah - Print Total Attendance in Home Matches of every team ");
    System.out.println("ref5 - print Referees Who Have Officiated the Most Matches with Over 50,000 Attendance");
    System.out.println("tops - Print Top Goal Scorers in Teams with Negative Goal Difference");
    System.out.println("cct - Print List of Cities with Their Total Stadium Capacities and Number of Teams");
    System.out.println("cll - cities with their Largest Stadiums capacity and Lowest Team Points");
    System.out.println("q - Exit the program");
    System.out.println("---- end help ----- ");
 }
}


/*      for(String var3 = ""; string != null && !string.equalsIgnoreCase("q"); string = scanner.nextLine()) {
         String[] var4 = string.split("\\s+");
         if (string.indexOf(" ") > 0) {
            var3 = string.substring(string.indexOf(" ")).trim();
         }

         if (var4[0].equalsIgnoreCase("h")) {
            printHelp();
/*        System.out.println("------------------------------------EMPLOYEE------------------------------------");
		backend.showEmployee();
		System.out.println("------------------------------------TEAM--------------------------------------");
		backend.showTeam();
		System.out.println("----------------------------------------CITY----------------------------------");
                backend.showCity();
System.out.println("------------------------------------AWARD--------------------------------------");
                backend.showAward();
System.out.println("-----------------------------------------STADIUM---------------------------------");
                backend.showStadium();
System.out.println("----------------------------------MAINSPONSORSHIP----------------------------------------");
                backend.showMainSponsorship();
System.out.println("-------------------------------------HEADREFEREE-------------------------------------");
                backend.showHeadReferee();
System.out.println("-----------------------------MATCHES---------------------------------------------");
                backend.showMatches();
System.out.println("------------------------------------SCORE--------------------------------------");
                backend.showScore();
System.out.println("-------------------------------------GETAWARD---------------------------------");
                backend.showGetAward();
System.out.println("---------------------------------------------GETSPONSOR-----------------------------");
                backend.showgetSponsor();
System.out.println("-----------------------------------GOALDIFF---------------------------------------");
                backend.showGoalDiff();
System.out.println("-----------------------------------TEAMPOINT---------------------------------------");
                backend.showTeamPoint();
System.out.println("--------------------------------HOMESTADIUM------------------------------------------");
                backend.showHomeStadium();
System.out.println("---------------------------------PLAY-----------------------------------------");
                backend.showPlay();
   */     
/*System.out.println("---------------------------------GPosition()-----------------------------------------");
	backend.GPosition();
System.out.println("---------------------------------Aattendance()-----------------------------------------");
backend.Aattendance();
System.out.println("---------------------------------AplayerAge()-----------------------------------------");
backend.AplayerAge();
System.out.println("---------------------------------Tawards()-----------------------------------------");
backend.Tawards();
System.out.println("---------------------------------matchBySameCity()-----------------------------------------");
backend.matchBySameCity();
System.out.println("---------------------------------PHSponsorship()-----------------------------------------");
backend.PHSponsorship();
System.out.println("---------------------------------TattendanceHome()-----------------------------------------");
backend.TattendanceHome();
System.out.println("---------------------------------Referee50000()-----------------------------------------");
backend.Referee50000();
System.out.println("---------------------------------TopScorers()------------------------------------------");
backend.TopScorers();
System.out.println("---------------------------------CityCnT()-----------------------------------------");
backend.CityCnT();
System.out.println("---------------------------------CityLargenLowest()-----------------------------------------");
backend.CityLargenLowest();*/
/*	 } 
         else if (var4[0].equalsIgnoreCase("ec")) {
            backend.employeeByString(var3);
         }
         else if (var4[0].equalsIgnoreCase("eid")) {
            backend.emplyeeByID(Integer.valueOf(var3));
         } 
         else if (var4[0].equalsIgnoreCase("mrid")) {
            backend.matchByRid(Integer.valueOf(var3));
         } 
         else if (var4[0].equalsIgnoreCase("tsc")) {
          //  backend.teamByCity(var3);
         } 
         else if (var4[0].equalsIgnoreCase("msc")) {
            //backend.matchBySameCity();
         } 
         else if (var4[0].equalsIgnoreCase("pg")) {
            try {
               if (var4.length >= 2) {
              //    backend. playersExceed10(var4[1]);                                         //just ignore
               } else {
                  System.out.println("Require an argument for this command");
               }
            } catch (Exception var7) {
               System.out.println("id must be an integer");
            }
         } 
         else if (var4[0].equalsIgnoreCase("ha")) {            //ignore
            if (var4.length >= 2) {
              // backend.topAttendance();
            } else {
               System.out.println("Require an argument for this command");
            }
         } 
         else if (var4[0].equalsIgnoreCase("mm")) {         //ignore
            try {
               if (var4.length >= 2) {
                //  backend. topSponsor();
               } else {
                  System.out.println("Require an argument for this command");
               }
            } catch (Exception var6) {
               System.out.println("id must be an integer");
            }
         } 
         else if (var4[0].equalsIgnoreCase("pn")) {
            if (var4.length >= 2) {
            //   backend.top5Population();        //ignore
            } else {
               System.out.println("Require an argument for this command");
            }
         } 
         else if (var4[0].equalsIgnoreCase("aa")) {
          //  backend.avgAge(var3);
         }  
         else if (var4[0].equalsIgnoreCase("ma")) {   //ignore
        //    backend.mostAwardTeam();
         } 
         else {
            System.out.println("Read the help with h, or find help somewhere else.");
         }

         System.out.print("db > ");
      }

      scanner.close();
   }*/
/*
   private static void printHelp() {    //change to the quiery we goti
      System.out.println("Winnipeg Council Member Expenses console");
      System.out.println("Commands:");
      System.out.println("h - Get help");
      System.out.println("ec - Print Employee name by 'character'");
      System.out.println("eid - Print Employee name by 'employee ID'");
      System.out.println("mrid name - Print Match controlled by Referee 'ID'");
      System.out.println("tsc name - Print all Teams that are in the same city, using the city’s name '");
      System.out.println("msc name - Print Match that played by the same city'");
      System.out.println("pg name - Print Players that have more than 10 goals");
      System.out.println("ha - Print Top 5 matches that have the highest attendance. ");
      System.out.println("mm - Print the Sponsor spend the most amount of money on teams");
      System.out.println("pn - Print Print the List the top 5 most popular nationality of the employees ");
      System.out.println("aa - Calculate the oldest/youngest average age of all the teams");
      System.out.println("ma - Print the Teams with the most player awards");
      System.out.println("q - Exit the program");
      System.out.println("---- end help ----- ");
   }
}*/


