# MiniBank – Console Banking System

A Java console application that simulates a small bank, built as a course project
during my Higher Vocational Education (YH) studies in Sweden.

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
6. Search accounts by owner
7. Show transaction history
8. Run month-end          (admin only)
9. Bank statistics
0. Exit
```

---

## Class structure

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

---

## Key concepts used

| Concept | Where |
|---|---|
| **Inheritance** | The three account classes `extend` `Account` and reuse its fields and methods |
| **Abstraction** | `Account` is abstract – a plain "account" with no type cannot be created |
| **Polymorphism** | Month-end loops over a `List<Account>` and calls `applyMonthEnd()`; each object runs its own version |
| **Interface** | `interest` defines a capability that only some account types have |
| **Method overriding** | `@Override` on `withdrawl()`, `applyMonthEnd()` and `describe()` |
| **Encapsulation** | Balance changes only through `deposit()` and `withdrawl()` |
| **Exception handling** | Input validation so invalid menu input does not crash the program |

---

## Design decisions

### Superclass vs interface
`Account` models **what something is**: every account type *is an* account.
The `interest` interface models **a capability** that only some accounts have.
A checking account does not earn interest, so `calculate_interest()` is not
placed in `Account`.

### Month-end processing
The program does not track real time. Menu option 8 simulates the end of a month,
similar to the scheduled batch job a real bank runs. It is protected by an admin
check so a regular user cannot trigger it.

### Interest calculation
Interest is calculated monthly as `balance × annualRate / 12` and added to the
balance at month-end, so it compounds. Real banks usually calculate interest daily
and pay it out yearly – this project uses a simplified monthly model.

---

## How to run

Requires Java 17 or newer.

```bash
javac *.java
java Main
```

---

## Development

The project is developed incrementally with Git, committing after each working
step with descriptive English commit messages.
