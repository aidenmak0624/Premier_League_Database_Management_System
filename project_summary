# Project Summary

## Premier League Database Management System

A Java-based database management system featuring 29+ SQL queries for analyzing Premier League football data.

### What This Project Does

This application provides an interactive command-line interface for querying a relational database containing Premier League information. Users can execute simple searches, view data tables, and run complex analytical queries involving multiple database tables.

### Technologies Used

- **Java** - Core application logic and CLI
- **JDBC** - Database connectivity layer
- **SQL** - Query language (MySQL/PostgreSQL/SQL Server compatible)
- **Make** - Build automation

### Architecture

```
┌─────────────┐
│  FrontEnd   │  → CLI Interface & Command Parsing
│   (Java)    │
└──────┬──────┘
       │
┌──────▼──────┐
│  BackEnd    │  → Database Connection & Query Execution
│   (Java)    │
└──────┬──────┘
       │
┌──────▼──────┐
│  Database   │  → Premier League Data Storage
│   (SQL)     │
└─────────────┘
```

### Key Features

#### 1. Interactive CLI
- User-friendly command prompt
- Comprehensive help system
- Input validation and error handling

#### 2. Diverse Query Types
- **Basic**: View all records from 15 different tables
- **Search**: Find specific employees, matches, referees
- **Statistical**: Calculate averages, totals, and distributions
- **Analytical**: Complex multi-table joins and aggregations

#### 3. Database Flexibility
- Works with MySQL, PostgreSQL, or SQL Server
- Easy configuration via external config file
- No hardcoded credentials

### Query Capabilities

**Simple Queries** (18 total)
- Display all teams, players, cities, awards, stadiums
- Search by name or ID
- Find matches by referee

**Complex Analytical Queries** (11 total)
- Position-based player statistics (goals, assists, appearances)
- Average attendance analysis by match day
- Team demographics (average age)
- Award distribution by team
- Derby matches between same-city teams
- High-sponsorship team analysis (>100M)
- Home attendance totals
- Referee performance metrics
- Top scorers in struggling teams
- City-level stadium and team analysis

### Database Schema Highlights

**Main Entities:**
- Employee (players, coaches, referees)
- Team (20 Premier League clubs)
- City (team locations)
- Stadium (venues with capacity)
- Award (player achievements)
- MainSponsorship (financial deals)
- Matches (game records with attendance)

**Relationships:**
- Employee → Team (employment)
- Team → City (location)
- Team → Stadium (home venue)
- Employee ↔ Award (achievements)
- Matches ↔ Team (home/away)
- Matches → HeadReferee (officiating)

### Technical Implementation

**SQL Techniques Used:**
- INNER/OUTER JOINS (up to 5 tables)
- Aggregate functions (COUNT, AVG, SUM, MAX, MIN)
- GROUP BY with HAVING clauses
- Subqueries and correlated subqueries
- ORDER BY with LIMIT
- LIKE patterns for string matching
- Complex WHERE conditions

**Java Features:**
- PreparedStatement for SQL injection prevention
- External configuration file parsing
- Exception handling and logging
- Scanner for user input
- ResultSet processing and formatting

### Learning Outcomes

This project demonstrates:
-  Relational database design and normalization
-  Entity-Relationship modeling
-  SQL query writing from simple to advanced
-  JDBC connection management
-  Application-database integration
-  CLI design patterns
-  Software documentation practices
-  Build automation with Make

### Performance Considerations

- Parameterized queries prevent SQL injection
- Efficient query design using appropriate indexes
- Connection reuse within session
- Proper resource cleanup (closing connections)

### Use Cases

This system can answer questions like:
- Which players scored the most goals for teams with negative goal differences?
- What's the average attendance at matches in each stadium?
- Which referees have officiated the most high-attendance games?
- How do player demographics vary across teams?
- Which cities have the most teams and largest stadium capacities?
- What matches featured teams from the same city?

### Code Organization

**FrontEnd.java** (350+ lines)
- Command parsing and routing
- User input handling
- Help system
- Menu display

**BackEnd.java** (1000+ lines)
- Database connection setup
- 29+ query method implementations
- Result formatting
- Error handling

**SQL Files** (3 schemas)
- Table definitions with constraints
- Sample data inserts
- Foreign key relationships

### Getting Started

1. Set up database and import schemas
2. Configure credentials in auth.cfg
3. Compile: `make build`
4. Run: `make run`
5. Type `h` for help

### Example Session

```
db > h
[Shows complete command list]

db > team
[Displays all Premier League teams]

db > ec Salah
[Searches for employees named Salah]

db > tops
[Shows top scorers in teams with negative goal difference]

db > q
Exiting...
```

### Academic Context

Created as a database systems course project to demonstrate:
- Practical application of database theory
- SQL proficiency across query complexity levels
- Professional software development practices
- Technical documentation skills

### Why This Project Matters

1. **Demonstrates Real-World Skills**: Shows ability to design, implement, and document a complete database application
2. **Complexity Range**: Includes both simple CRUD operations and complex analytical queries
3. **Professional Practices**: Uses configuration files, parameterized queries, proper error handling
4. **Documentation**: Comprehensive guides for setup, usage, and understanding
5. **Extensibility**: Clean architecture allows for easy addition of new queries or features

