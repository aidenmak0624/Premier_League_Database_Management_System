----------------------------showAll--------------
SELECT * from Team;
SELECT * from Employee;
SELECT * from City;
SELECT * from Award;
SELECT * from Stadium;
SELECT * from Main_SponsorShip;
SELECT * from HeadReferee;
SELECT * from Matches;
SELECT * from Score;
SELECT * from GetAward;
SELECT * from GetSponsor;
SELECT * from GoalDifference;
SELECT * from TeamPoint;
SELECT * from HomeStadium;
SELECT * from Play;


----------------------------Queries---------------

--Search the Name of the Employee Given a String
SELECT * FROM Employee WHERE name LIKE "?" ;

--Search the Name of the Employee Given an ID
SELECT *
FROM Employee
WHERE EmployeeID = "?";


--This query groups employees by their position (like midfielder, defender, etc.) and calculates total goals, assists, and appearances:
SELECT position, SUM(goals) AS Total_Goals, SUM(assists) AS Total_Assists, SUM(appearances) AS Total_Appearances
FROM Employee
WHERE position IS NOT NULL
GROUP BY position;

--Calculates the average attendance for each match day:
SELECT Match_Day_Number, AVG(Attendance) AS Average_Attendance
FROM Matches
GROUP BY Match_Day_Number;

--Average Player Age per Team
SELECT Team_name, AVG(age) AS Average_Player_Age
FROM Employee
WHERE Employee_Type = 'Player'
GROUP BY Team_name;

--Counts the number of awards won by each team:
SELECT Employee.Team_name, COUNT(GetAward.AwardID) AS Awards_Count
FROM GetAward
JOIN Employee ON GetAward.EmployeeID = Employee.EmployeeID
GROUP BY Employee.Team_name;

--Matches Controlled by a Referee, Using the Referee’s ID
SELECT Matches.MatchID, Matches.Match_Day_Number, Matches.Home_Team, Matches.Attendance
FROM Matches
JOIN HeadReferee ON Matches.RefID = HeadReferee.RefereeID
WHERE HeadReferee.RefereeID = '?';

--List of Matches Played by 2 Teams from the Same City
SELECT m.MatchID, m.Home_Team, m.AwayTeam
FROM Matches m
JOIN Stadium s1 ON m.Home_Team = s1.Team_Name
JOIN City c1 ON s1.City = c1.city
JOIN Stadium s2 ON m.AwayTeam = s2.Team_Name
JOIN City c2 ON s2.City = c2.city
WHERE c1.city = c2.city;


--Players with Most Awards in Teams with High Sponsorships(Over 100 millions)
SELECT Employee.name, COUNT(GetAward.AwardID) AS NumberOfAwards
FROM Employee
JOIN GetAward ON Employee.EmployeeID = GetAward.EmployeeID
JOIN GetSponsor ON Employee.Team_name = GetSponsor.Team_name
GROUP BY Employee.name
HAVING SUM(GetSponsor.amount) > 100000000
ORDER BY NumberOfAwards DESC;

--Total Attendance in Home Matches of every team
SELECT Team.Name, SUM(Matches.Attendance) AS Total_Attendance
FROM Team
JOIN Play ON Team.Name = Play.Team_name
JOIN Matches ON Play.MatchID = Matches.MatchID
WHERE Team.Name = Matches.Home_Team
GROUP BY Team.Name
ORDER BY Total_Attendance DESC;

--Referees Who Have Officiated the Most Matches with Over 50,000 Attendance
SELECT HeadReferee.Name, COUNT(*) AS Matches_Officiated
FROM HeadReferee
JOIN Matches ON HeadReferee.RefereeID = Matches.RefID
WHERE Matches.Attendance > 50000
GROUP BY HeadReferee.Name
ORDER BY Matches_Officiated DESC;

-- Top Goal Scorers in Teams with Negative Goal Difference
WITH TeamGoalDifference AS (
    SELECT Name, Goal_Difference
    FROM Team
    Join GoalDifference ON Team.Goal = GoalDifference.Goal AND Team.Concede = GoalDifference.Concede
)
SELECT E.name, E.goals, E.Team_name
FROM Employee E
INNER JOIN (
    SELECT Team_name, MAX(goals) AS MaxGoals
    FROM Employee
    WHERE Team_name IN (
        SELECT Name FROM TeamGoalDifference WHERE Goal_Difference < 0
    )
    GROUP BY Team_name
) AS TopScorers ON E.Team_name = TopScorers.Team_name AND E.goals = TopScorers.MaxGoals
JOIN Team T ON E.Team_name = T.Name
ORDER By goals DESC;


--List of Cities with Their Total Stadium Capacities and Number of Teams
SELECT 
    City.city, 
    SUM(Stadium.Capacity) AS Total_Stadium_Capacity, 
    COUNT(DISTINCT Team.Name) AS Number_of_Teams
FROM City
JOIN Team ON City.city = Team.City_Name
LEFT JOIN Stadium ON Team.Name = Stadium.Team_Name
GROUP BY City.city
ORDER BY Total_Stadium_Capacity DESC, Number_of_Teams DESC;

-- Show cities with their Largest Stadiums capacity and Lowest Team Points
SELECT 
    City.city, 
    MAX(Stadium.Capacity) AS Largest_Stadium_Capacity,
    MIN(TP.Point) AS Lowest_Team_Points
FROM City
JOIN Stadium ON City.city = Stadium.City
JOIN Team ON Stadium.Team_Name = Team.Name
JOIN TeamPoint AS TP ON Team.Win = TP.Win AND Team.Draw = TP.Draw AND Team.Lost = TP.Lost
GROUP BY City.city
ORDER BY Largest_Stadium_Capacity DESC, Lowest_Team_Points ASC;

















