# ExpenseTrackerApiSdk TypeScript SDK 1.0.0

Welcome to the ExpenseTrackerApiSdk SDK documentation. This guide will help you get started with integrating and using the ExpenseTrackerApiSdk SDK in your project.

## Versions

- SDK version: `1.0.0`

## About the API

# Expense Tracker API

REST API for Northbeam Consulting's internal expense management system.

Employees record expenses, group them into claims, and submit for approval.
Approvers review and approve or reject claims. Finance marks approved claims as reimbursed.

## Authentication

All endpoints require a **JWT Bearer token** (HS256). The token encodes the caller's role:

- `employee` — submit expenses and claims
- `approver` — approve or reject claims (cannot approve own claims)
- `finance` — manage categories and mark claims as reimbursed

## Claim State Machine

`draft → submitted → approved | rejected → reimbursed`

## Business Rules

- Amounts must be positive; dates cannot be in the future
- Expenses older than 90 days cannot be added to a claim
- A receipt is mandatory when the expense amount exceeds the category threshold
- Expenses inside a submitted claim are frozen (cannot be edited or deleted)
- An approver cannot approve their own claim
- A reimbursed claim is final

## Table of Contents

- [Setup & Configuration](#setup--configuration)
  - [Supported Language Versions](#supported-language-versions)
  - [Installation](#installation)
- [Authentication](#authentication)
  - [Access Token Authentication](#access-token-authentication)
- [Setting a Custom Timeout](#setting-a-custom-timeout)
- [Sample Usage](#sample-usage)
- [Services](#services)
- [Models](#models)

# Setup & Configuration

## Supported Language Versions

This SDK is compatible with the following versions: `TypeScript >= 4.8.4`

## Installation

To get started with the SDK, we recommend installing using `npm` or `yarn`:

```bash
npm install expense-tracker-api-sdk
```

or

```bash
yarn add expense-tracker-api-sdk
```

## Authentication

### Access Token Authentication

The ExpenseTrackerApiSdk API uses an Access Token for authentication.

This token must be provided to authenticate your requests to the API.

#### Setting the Access Token

When you initialize the SDK, you can set the access token as follows:

```ts
const sdk = new ExpenseTrackerApiSdk({ token: 'YOUR_TOKEN' });
```

If you need to set or update the access token after initializing the SDK, you can use:

```ts
const sdk = new ExpenseTrackerApiSdk();
sdk.token = 'YOUR_TOKEN';
```

## Setting a Custom Timeout

You can set a custom timeout for the SDK's HTTP requests as follows:

```ts
const expenseTrackerApiSdk = new ExpenseTrackerApiSdk({ timeout: 10000 });
```

# Sample Usage

Below is a comprehensive example demonstrating how to authenticate and call a simple endpoint:

```ts
import { ExpenseTrackerApiSdk } from 'expense-tracker-api-sdk';

(async () => {
  const expenseTrackerApiSdk = new ExpenseTrackerApiSdk({
    token: 'YOUR_TOKEN',
  });

  const data = await expenseTrackerApiSdk.expenseTrackerApiSdk.listCategories();

  console.log(data);
})();
```

## Services

The SDK provides various services to interact with the API.

<details>
<summary>Below is a list of all available services with links to their detailed documentation:</summary>

| Name                                                                                 |
| :----------------------------------------------------------------------------------- |
| [ExpenseTrackerApiSdkService](documentation/services/ExpenseTrackerApiSdkService.md) |

</details>

## Models

The SDK includes several models that represent the data structures used in API requests and responses. These models help in organizing and managing the data efficiently.

<details>
<summary>Below is a list of all available models with links to their detailed documentation:</summary>

| Name                                                                     | Description |
| :----------------------------------------------------------------------- | :---------- |
| [LoginAsEmployeeRequest](documentation/models/LoginAsEmployeeRequest.md) |             |
| [LoginAsApproverRequest](documentation/models/LoginAsApproverRequest.md) |             |
| [LoginAsFinanceRequest](documentation/models/LoginAsFinanceRequest.md)   |             |
| [CreateCategoryRequest](documentation/models/CreateCategoryRequest.md)   |             |
| [UpdateCategoryRequest](documentation/models/UpdateCategoryRequest.md)   |             |
| [CreateExpenseRequest](documentation/models/CreateExpenseRequest.md)     |             |
| [UpdateExpenseRequest](documentation/models/UpdateExpenseRequest.md)     |             |
| [CreateClaimRequest](documentation/models/CreateClaimRequest.md)         |             |

</details>
