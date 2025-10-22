# Premier League Database Management System

A comprehensive Java-based database management system for querying and analyzing Premier League football data. Features a command-line interface with 29+ SQL queries ranging from simple searches to complex analytical operations.

![Java](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=openjdk&logoColor=white)
![SQL](https://img.shields.io/badge/SQL-4479A1?style=flat&logo=mysql&logoColor=white)
![JDBC](https://img.shields.io/badge/JDBC-007396?style=flat&logo=java&logoColor=white)
![License](https://img.shields.io/badge/License-Academic-blue)

## Overview

This project implements a relational database for managing Premier League data with an interactive command-line interface. It demonstrates database design, SQL query optimization, and Java-SQL integration using JDBC.

### Key Features

- 🔍 **29+ SQL Queries** - From simple searches to complex analytical operations
- 💻 **Interactive CLI** - User-friendly command-line interface
- 🔄 **Multi-Database Support** - Compatible with MySQL, PostgreSQL, SQL Server
- 📊 **Advanced Analytics** - Complex joins, aggregations, and statistical analysis
- 🔒 **Secure Configuration** - External config file for database credentials
- 📖 **Comprehensive Documentation** - Detailed setup and usage guides

## Project Structure

```
premier-league-db/
├── src/
│   ├── FrontEnd.java          # CLI interface and command handling
│   └── BackEnd.java           # Database connectivity and SQL queries
├── data/
│   ├── Award.csv              # Award reference data
│   ├── AwayTeam.csv           # Away team statistics
│   └── Matches.csv            # Match records and results
├── sql/
│   ├── Award.sql              # Award table schema
│   ├── AwayTeam.sql           # Away team table schema
│   └── Matches.sql            # Matches table schema
├── docs/
│   └── Query_idea.pdf         # Original requirements and EER diagram
└── README.md                  # This file
```

## Database Schema

The database manages the following entities:

- **Employee** - Players, coaches, and referees
- **Team** - Premier League clubs
- **City** - Geographic locations of teams
- **Stadium** - Venue information
- **Award** - Player achievements and honors
- **MainSponsorship** - Team sponsorship deals
- **Matches** - Match records with scores and attendance
- **HeadReferee** - Match officials

## Quick Start

### Prerequisites

- Java JDK 8 or higher
- JDBC driver for your database (MySQL, PostgreSQL, or SQL Server)
- Database server (MySQL, PostgreSQL, SQL Server, or SQLite)

### Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/premier-league-db.git
   cd premier-league-db
   ```

2. **Set up the database**
   ```sql
   CREATE DATABASE premier_league;
   USE premier_league;
   SOURCE sql/Award.sql;
   SOURCE sql/AwayTeam.sql;
   SOURCE sql/Matches.sql;
   -- Import remaining SQL files
   ```

3. **Create configuration file**
   ```bash
   cp auth.cfg.example auth.cfg
   ```
   
   Edit `auth.cfg`:
   ```properties
   username=your_database_username
   password=your_database_password
   ```

4. **Update database connection**
   
   Edit `src/BackEnd.java` and update the connection URL:
   ```java
   String connectionUrl = "jdbc:mysql://localhost:3306/premier_league"
       + "?user=" + username
       + "&password=" + password;
   ```

5. **Compile and run**
   ```bash
   make build
   make run
   ```

## Usage

Once started, you'll see the interactive prompt:

```
db >
```

### Basic Commands

```bash
db > h              # Show help menu
db > team           # Display all teams
db > employee       # Display all employees
db > q              # Exit program
```

### Search Queries

```bash
db > ec Ronaldo     # Search employees by name
db > eid 101        # Find employee by ID
db > mrid 5         # Show matches by referee ID
```

### Analytical Queries

```bash
db > gpo            # Group employees by position with statistics
db > aat            # Average attendance per match day
db > apl            # Average player age per team
db > taw            # Team awards count
db > mbsc           # Derby matches (same-city teams)
db > phs            # Players in high-sponsorship teams (>100M)
db > tah            # Total home match attendance by team
db > ref5           # Referees with most 50K+ attendance matches
db > tops           # Top scorers in negative goal difference teams
db > cct            # Cities with stadium capacity and team counts
db > cll            # Cities with largest stadiums and lowest points
```

## Query Categories

### Table Display Queries (15)
View complete tables: `employee`, `team`, `city`, `award`, `stadium`, `mainsponsorship`, `HeadReferee`, `Matches`, `Score`, `GetAward`, `GetSponsor`, `GoalDiff`, `TeamPoint`, `HomeStadium`, `Play`

### Search Queries (3)
- **ec [name]** - Search employees by name
- **eid [id]** - Find employee by ID
- **mrid [id]** - Find matches by referee ID

### Statistical Queries (4)
- **gpo** - Position-based statistics
- **aat** - Average match attendance
- **apl** - Average player age per team
- **taw** - Team award counts

### Advanced Analytical Queries (7)
- **mbsc** - Same-city derby matches
- **phs** - Players in high-sponsorship teams
- **tah** - Total home attendance
- **ref5** - Top referees by high-attendance matches
- **tops** - Top scorers in struggling teams
- **cct** - City stadium capacity analysis
- **cll** - City infrastructure vs performance

## Technical Details

### Technologies
- **Java** - Application logic and CLI
- **JDBC** - Database connectivity
- **SQL** - Query language for data operations
- **Make** - Build automation

### Database Support
- MySQL (default)
- PostgreSQL
- SQL Server
- SQLite

### Key Implementation Features
- Parameterized queries for SQL injection prevention
- External configuration file for credentials
- Error handling and validation
- Modular architecture (Frontend/Backend separation)

## Sample Queries

The project includes 29+ queries demonstrating:
- Multi-table joins (up to 5 tables)
- Aggregate functions (COUNT, AVG, SUM)
- GROUP BY operations
- Subqueries and nested queries
- HAVING clauses
- ORDER BY and LIMIT
- Complex WHERE conditions

## Project Highlights

This project demonstrates proficiency in:
-  Database design and normalization
-  Entity-Relationship modeling
-  SQL query optimization
-  JDBC programming and connection management
-  Complex analytical queries
-  Command-line interface design
-  Software documentation

## Academic Context

**Note:** This is an educational project completed as part of a database systems course. It demonstrates understanding of relational databases, SQL, and database application development.

**For students:** This is provided as a reference implementation. Please do not copy this code for your own coursework, as it may violate your institution's academic integrity policy. Use it to understand concepts, then implement your own solution.




---

⭐ If you found this project helpful or interesting, please consider giving it a star!
