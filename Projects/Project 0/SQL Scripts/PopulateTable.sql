###########################################################
##################### CREATE DATABASE #####################
###########################################################

USE Project 0;

# DB Tables Needed
# CUSTOMER (FIRST_NAME, LAST_NAME, ACCOUNT_ID, CUSTOMER_ID) : A customer can have multiple ACCOUNT_IDs tied to them, but only one CUSTOMER_ID
# ACCOUNTS (CUSTOMER_ID, ACCOUNT_ID, BALANCE) : A customer can have multiple accounts, but the ACCOUNT_IDs must be different

CREATE TABLE ACCOUNTS 
(
	ACCOUNT_ID INT AUTO_INCREMENT = 100,
	CUSTOMER_ID INT AUTO_INCREMENT,
	BALANCE INT NOT NULL,
	INDEX (ACCOUNT_ID),
	INDEX (CUSTOMER_ID),
	CONSTRAINT ACCOUNTS_FK PRIMARY KEY (ACCOUNT_ID)
);


