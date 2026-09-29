# ExpenseTrackerApiSdk Python SDK 1.0.0

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
- [Async Usage](#async-usage)
- [Services](#services)
- [Models](#models)

# Setup & Configuration

## Supported Language Versions

This SDK is compatible with the following versions: `Python >= 3.9`

## Installation

To get started with the SDK, we recommend installing using `pip`:

```bash
pip install expense_tracker_api_sdk
```

If you are using Python 3, you can use `pip3` instead:

```bash
pip3 install expense_tracker_api_sdk
```

## Authentication

### Access Token Authentication

The ExpenseTrackerApiSdk API uses an Access Token for authentication.

This token must be provided to authenticate your requests to the API.

#### Setting the Access Token

When you initialize the SDK, you can set the access token as follows:

```py
ExpenseTrackerApiSdk(
    access_token="YOUR_ACCESS_TOKEN",
    timeout=10
)
```

If you need to set or update the access token after initializing the SDK, you can use:

```py
sdk.set_access_token("YOUR_ACCESS_TOKEN")
```

## Setting a Custom Timeout

You can set a custom timeout for the SDK's HTTP requests as follows:

```py
from expense_tracker_api_sdk import ExpenseTrackerApiSdk

sdk = ExpenseTrackerApiSdk(timeout=10)
```

# Sample Usage

Below is a comprehensive example demonstrating how to authenticate and call a simple endpoint:

```py
from expense_tracker_api_sdk import ExpenseTrackerApiSdk, Environment

sdk = ExpenseTrackerApiSdk(
    access_token="YOUR_ACCESS_TOKEN",
    base_url=Environment.DEFAULT.value,
    timeout=10
)

result = sdk.expense_tracker_api_sdk.list_categories()

print(result)

```

# Async Usage

The SDK includes an Async Client for making asynchronous API requests. This is useful for applications that need non-blocking operations, like web servers or apps with a graphical user interface.

```py
import asyncio
from expense_tracker_api_sdk import ExpenseTrackerApiSdkAsync, Environment

sdk = ExpenseTrackerApiSdkAsync(
    access_token="YOUR_ACCESS_TOKEN",
    base_url=Environment.DEFAULT.value,
    timeout=10
)


async def main():
  result = await sdk.expense_tracker_api_sdk.list_categories()
  print(result)

asyncio.run(main())
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
