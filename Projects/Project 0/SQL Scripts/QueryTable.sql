-- This script does random queries

# DB Tables Needed
# CUSTOMERS (USER_ID, CUSTOMER_ID, EMAIL, LAST_NAME, FIRST_NAME) : A customer can have multiple ACCOUNT_IDs tied to them, but only one CUSTOMER_ID
# ACCOUNTS (ACCOUNT_ID, ACCOUNT_TYPE, BALANCE) : A customer can have multiple accounts, but the ACCOUNT_IDs must be different
# AC_JUNCTION (JUNCTION_ID, ACCOUNT_ID, CUSTOMER_ID) : A junction table that ties CUSTOMERS and ACCOUNTS together
# USERINFO (USER_ID, PASSWORD, USER_ID) : A table containing the user login info based on CUSTOMER_ID

USE Project0;

# Return all Customer names from CUSTOMERS
SELECT CONCAT(c.FIRST_NAME, ' ', c.LAST_NAME) AS "All Customer Names in Database"
FROM CUSTOMERS c;

# Return Customers with an account that has a balance > $1000
SELECT *
FROM CUSTOMERS c
JOIN AC_JUNCTION aj ON aj.CUSTOMER_ID = c.CUSTOMER_ID
JOIN ACCOUNTS a ON a.ACCOUNT_ID = aj.ACCOUNT_ID 
WHERE a.BALANCE > 1000;

# Return User Login Info Based on CUSTOMER_ID
SELECT c.FIRST_NAME, c.LAST_NAME, u.USERNAME, u.PASSWORD 
FROM CUSTOMERS c 
JOIN USERINFO u ON c.USER_ID = u.USER_ID;

# Max Account ID currently
SELECT MAX(ACCOUNT_ID)
FROM ACCOUNTS;

# Get Username of Customer with User_ID
SELECT *
FROM USERINFO u 
JOIN CUSTOMERS c ON c.USER_ID = u.USER_ID 
WHERE c.CUSTOMER_ID = 10;

# Get all Customer info based on Username
SELECT *
FROM CUSTOMERS c
JOIN USERINFO u ON c.USER_ID = u.USER_ID 
WHERE u.USERNAME = 'manm3';

# Get all Accounts based on Username
SELECT *
FROM ACCOUNTS a
JOIN AC_JUNCTION aj on a.ACCOUNT_ID = aj.ACCOUNT_ID 
JOIN CUSTOMERS c on c.CUSTOMER_ID = aj.CUSTOMER_ID 
JOIN USERINFO u on u.USER_ID = c.USER_ID 
WHERE u.USERNAME = 'KB123';

# Get all based on First Name
SELECT *
FROM ACCOUNTS a
JOIN AC_JUNCTION aj on a.ACCOUNT_ID = aj.ACCOUNT_ID 
JOIN CUSTOMERS c on c.CUSTOMER_ID = aj.CUSTOMER_ID 
JOIN USERINFO u on u.USER_ID = c.USER_ID 
WHERE c.FIRST_NAME = 'Kollier';

# Transfer funds based on account number
UPDATE accounts
SET balance = (balance - 199.99)
WHERE account_id = 900001; #Jason

UPDATE accounts
SET balance = (balance + 199.99)
WHERE account_id = 900003; #Amanda

# Deposit
UPDATE ACCOUNTS
SET BALANCE = (BALANCE + 10)
WHERE ACCOUNT_ID = 100;