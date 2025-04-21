# Task 1 - Exploratory Testing of Monefy iOS App

**Platform Tested:** iOS  
**Device:** iPhone 13 Pro Max
**App Version:** App Store Premium Version  
**Test Date:** April 17, 2025  
**Session Duration:** 2 hours

## 1. Exploratory Testing Charters

| Charter # | Objective                          | Expected Behavior                                     | Actual Behavior / Observation                            | Priority | Status     |
|-----------|------------------------------------|-------------------------------------------------------|----------------------------------------------------------|----------|------------|
| C1        | Onboarding                         | Smooth user entry with intro and premium promos       | Works as expected                                        | High     | Completed  |
| C2        | Add expenses and incomes           | Validate required fields, entries saved correctly     | Works as expected                                        | High     | Completed  |
| C3        | Search record                      | Records found via keywords and dates                  | Cannot search by date, only by keywords                  | Medium   | Completed  |
| C4        | Filters (date, interval, account)  | Filters adjust visible entries accordingly            | Works as expected                                        | Medium   | Completed  |
| C5        | Change and add accounts            | Allows new accounts with labels and switching         | Works, but allows duplicate account names                | High     | Completed  |
| C6        | Entry list                         | Displays all entries with correct detail              | Works as expected                                        | Medium   | Completed  |
| C7        | Balance mode                       | Correctly toggles between net balance and totals      | Works as expected                                        | Low      | Completed  |
| C8        | Dark theme                         | App fully supports dark mode                          | Works as expected                                        | Low      | Completed  |
| C9        | Currency                           | Changing currency updates app immediately             | Works as expected                                        | Medium   | Completed  |
| C10       | Add categories                     | Allows custom category creation                       | Works, but allows duplicate names                        | High     | Completed  |
| C11       | Schedule expense/income            | Supports scheduled entries                            | Works as expected                                        | Medium   | Completed  |
| C12       | Make account transfers             | Transfers reflect correctly between selected accounts | Works as expected                                        | Medium   | Completed  |
| C13       | Passcode protection                | Prompts for code when opening app                     | Works as expected                                        | Medium   | Completed  |

---

## 2. Findings from the Charters

Here are the only issues discovered during testing:

- **[C3] Search by Date Not Supported**  
  → Users cannot search for a specific date using the search bar (e.g., entering "Apr 15" doesn't show matching entries).  
  → Severity: Low

- **[C5] Duplicate Account Names Allowed**  
  → The app allows users to create multiple accounts with the same name.  
  → Severity: Medium

- **[C10] Duplicate Categories Allowed**  
  → It's possible to create categories with identical names, which may confuse users during entry.  
  → Severity: Medium

---

## 3. Prioritization

| Priority | Reasoning                                                                 |
|----------|---------------------------------------------------------------------------|
| High     | Critical for core functionality (expenses, accounts, categories)          |
| Medium   | Feature limitations that can affect UX or data clarity                    |
| Low      | Cosmetic or non-blocking usability concerns                               |

---

## 4. Risk Assessment & Mitigation

| Risk                                                | Mitigation Strategy                                         |
|-----------------------------------------------------|-------------------------------------------------------------|
| **Duplicate data (categories/accounts)**            | Add backend validation for uniqueness                       |
| **Limited search capabilities**                     | Enhance search logic to allow queries by date, amount, tags |
| **Swipe right and left might be confusing**         | Introduce tooltips/hints or more clean swiping shortcuts    |


## Summary

During the 2 hours exploratory session, I focused on core functionalities of the Monefy app such as adding expenses/incomes, filtering, managing accounts and categories, and testing various user interface features like dark mode, currency settings, and passcode protection.

Most of the tested features worked as expected. The main issues found were the inability to search records by date and the fact that both account names and category names can be duplicated without warning, which could confuse users.

Overall, the app feels stable and responsive, with a user-friendly design. These minor issues don’t block key functionality but should be considered in future usability or quality improvements.