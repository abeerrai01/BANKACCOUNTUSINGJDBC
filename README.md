🏦 BANK ACCOUNT MANAGEMENT SYSTEM USING JDBC
A simple console-based Bank Account System developed using Java, JDBC, and SQL Server. Perform basic banking operations like deposit, withdraw, and balance check — directly from your terminal!

📌 Features
🏧 Deposit Money

💸 Withdraw Money

💼 Check Account Balance

🛡️ Secure DB operations using PreparedStatement

📦 JDBC integration with SQL Server

⚙️ Tech Stack
Layer	Tech
Language	Java
Database	SQL Server
Connectivity	JDBC (Java Database Connectivity)
IDE	IntelliJ / VS Code

🚀 How to Run
Clone the repo

bash
Copy
Edit
git clone https://github.com/abeerrai01/BANKACCOUNTUSINGJDBC
cd BANKACCOUNTUSINGJDBC
Setup your Database

Create a table using this SQL:

sql
Copy
Edit
CREATE TABLE accounts (
    ACCOUNTNUMBER INT PRIMARY KEY,
    BALANCE FLOAT
);
Configure DB connection

Open BankOperations.java

Update your DB URL, username, and password in:

java
Copy
Edit
Connection con = DriverManager.getConnection(
    "jdbc:sqlserver://localhost:1433;databaseName=YourDB", 
    "username", 
    "password"
);
Compile and Run

bash
Copy
Edit
javac BankOperations.java
java BankOperations
📸 Screenshots (Optional — Add if you can)
Terminal output of deposit/withdraw

Sample table data from DB

📁 Project Structure
bash
Copy
Edit
├── BankOperations.java    # Main class with all banking logic
└── README.md              # You're reading it :)
🧠 Future Enhancements
✅ Transaction history

✅ Custom exceptions

✅ Add login & signup functionality

✅ Migrate to Spring Boot with REST API

✅ Web or GUI frontend (JavaFX/Swing)

✨ Author
👤 Abeer Rai
📫 Learning Java | DSA | Spring Boot | Aspiring Developer

⭐ Give this repo a star if you find it useful!
