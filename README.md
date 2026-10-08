# MiniBank – Console Banking System

A Java console application that simulates a small bank
Users can open accounts, deposit and withdraw money, and run a month-end process
that applies interest and fees. Each account type follows its own rules, which is
what makes inheritance and polymorphism meaningful in this project.

---

## Features

```
1. Open account
2. Close account
3. Deposit
4. Withdraw
5. Transfer
6. Show transaction history
7. Run month-end          (admin only)
8. Bank statistics
0. Exit
```

---

## structure

```
Main                     → entry point, menu loop, reads user input
Account (abstract)       → superclass: owner name, balance, deposit(), describe()
 ├── Savingaccount       → earns interest, max 3 withdrawals per month
 ├── Cheakingaccount     → allows overdraft down to -1100, monthly fee
 └── Studentaccount      → student account with its own withdrawal rules
interest (interface)     → calculate_interest(), implemented by the interest-earning accounts
```

### Account rules

| Account type | Withdrawal rule | Month-end |
|---|---|---|
| `Savingaccount` | Balance cannot go below 0. Max 3 withdrawals per month. | Adds interest, resets the withdrawal counter |
| `Cheakingaccount` | Balance cannot go below the overdraft limit (-1100) | Charges a monthly fee |
| `Studentaccount` | Own withdrawal limit | Adds interest |

### Month-end processing
The program does not track real time. Menu option 8 simulates the end of a month,
similar to the scheduled batch job a real bank runs. It is protected by an admin
check so a regular user cannot trigger it.

### Interest calculation
Interest is calculated monthly as `balance × annualRate / 12`  

