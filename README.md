# Banking App project
Criteria for this app:

- Read a .csv file of names, social security numbers, account type and initial deposit (eventually migrate this all to a server, so as to not require the .csv file)
- Use a proper data structure to hold all the accounts
- Both Savings and Chequeing accounts share the follow methods:
  - *deposit()*
  - *withdraw()*
  - *transfer()*
  - *showInfo()*
  - In addition, an 11-digit account number will be generated as follows: 1 or 2 depending on Savings or Chequeing (respectively), last two digits of the SSN, unique 5-digit number, and a random 3 digit number)
- Savings account holders are given a Safety Deposit Box, identified by a 3-digit number and accessed with a 4-digit code
- Chequeing accont holders are given a Debit Card, with a 12-digit number and a 4-digit PIN
- Both accounts will use an interface that determine the base interest rate
  - *Savings account will use 0.25% less than the base rate*
  - *Chequeing account will use 15% of the base rate*
- The showInfo method should reveal relevant account information as well as information specific to the Chequeing account or Savings account
