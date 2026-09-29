# ExpenseTrackerApiSdkService

A list of all methods in the `ExpenseTrackerApiSdkService` service. Click on the method name to view detailed information about that method.

| Methods                             | Description |
| :---------------------------------- | :---------- |
| [loginAsEmployee](#loginasemployee) |             |
| [loginAsApprover](#loginasapprover) |             |
| [loginAsFinance](#loginasfinance)   |             |
| [listCategories](#listcategories)   |             |
| [getCategory](#getcategory)         |             |
| [createCategory](#createcategory)   |             |
| [updateCategory](#updatecategory)   |             |
| [deleteCategory](#deletecategory)   |             |
| [listExpenses](#listexpenses)       |             |
| [getExpense](#getexpense)           |             |
| [createExpense](#createexpense)     |             |
| [updateExpense](#updateexpense)     |             |
| [deleteExpense](#deleteexpense)     |             |
| [listClaims](#listclaims)           |             |
| [getClaim](#getclaim)               |             |
| [createClaim](#createclaim)         |             |
| [submitClaim](#submitclaim)         |             |
| [approveClaim](#approveclaim)       |             |

## loginAsEmployee

- HTTP Method: `POST`
- Endpoint: `/auth/login`

**Parameters**

| Name | Type                                                          | Required | Description       |
| :--- | :------------------------------------------------------------ | :------- | :---------------- |
| body | [LoginAsEmployeeRequest](../models/LoginAsEmployeeRequest.md) | ✅       | The request body. |

**Return Type**

`any`

**Example Usage Code Snippet**

```typescript
import { ExpenseTrackerApiSdk, LoginAsEmployeeRequest } from 'expense-tracker-api-sdk';

(async () => {
  const expenseTrackerApiSdk = new ExpenseTrackerApiSdk({
    token: 'YOUR_TOKEN',
  });

  const loginAsEmployeeRequest: LoginAsEmployeeRequest = {
    email: 'alice@northbeam.com',
    password: 'password123',
  };

  const data =
    await expenseTrackerApiSdk.expenseTrackerApiSdk.loginAsEmployee(loginAsEmployeeRequest);

  console.log(data);
})();
```

## loginAsApprover

- HTTP Method: `POST`
- Endpoint: `/auth/login`

**Parameters**

| Name | Type                                                          | Required | Description       |
| :--- | :------------------------------------------------------------ | :------- | :---------------- |
| body | [LoginAsApproverRequest](../models/LoginAsApproverRequest.md) | ✅       | The request body. |

**Return Type**

`any`

**Example Usage Code Snippet**

```typescript
import { ExpenseTrackerApiSdk, LoginAsApproverRequest } from 'expense-tracker-api-sdk';

(async () => {
  const expenseTrackerApiSdk = new ExpenseTrackerApiSdk({
    token: 'YOUR_TOKEN',
  });

  const loginAsApproverRequest: LoginAsApproverRequest = {
    email: 'bob@northbeam.com',
    password: 'password123',
  };

  const data =
    await expenseTrackerApiSdk.expenseTrackerApiSdk.loginAsApprover(loginAsApproverRequest);

  console.log(data);
})();
```

## loginAsFinance

- HTTP Method: `POST`
- Endpoint: `/auth/login`

**Parameters**

| Name | Type                                                        | Required | Description       |
| :--- | :---------------------------------------------------------- | :------- | :---------------- |
| body | [LoginAsFinanceRequest](../models/LoginAsFinanceRequest.md) | ✅       | The request body. |

**Return Type**

`any`

**Example Usage Code Snippet**

```typescript
import { ExpenseTrackerApiSdk, LoginAsFinanceRequest } from 'expense-tracker-api-sdk';

(async () => {
  const expenseTrackerApiSdk = new ExpenseTrackerApiSdk({
    token: 'YOUR_TOKEN',
  });

  const loginAsFinanceRequest: LoginAsFinanceRequest = {
    email: 'carol@northbeam.com',
    password: 'password123',
  };

  const data =
    await expenseTrackerApiSdk.expenseTrackerApiSdk.loginAsFinance(loginAsFinanceRequest);

  console.log(data);
})();
```

## listCategories

- HTTP Method: `GET`
- Endpoint: `/categories`

**Return Type**

`any`

**Example Usage Code Snippet**

```typescript
import { ExpenseTrackerApiSdk } from 'expense-tracker-api-sdk';

(async () => {
  const expenseTrackerApiSdk = new ExpenseTrackerApiSdk({
    token: 'YOUR_TOKEN',
  });

  const data = await expenseTrackerApiSdk.expenseTrackerApiSdk.listCategories();

  console.log(data);
})();
```

## getCategory

- HTTP Method: `GET`
- Endpoint: `/categories/{categoryId}`

**Parameters**

| Name       | Type   | Required | Description |
| :--------- | :----- | :------- | :---------- |
| categoryId | string | ✅       |             |

**Return Type**

`any`

**Example Usage Code Snippet**

```typescript
import { ExpenseTrackerApiSdk } from 'expense-tracker-api-sdk';

(async () => {
  const expenseTrackerApiSdk = new ExpenseTrackerApiSdk({
    token: 'YOUR_TOKEN',
  });

  const data = await expenseTrackerApiSdk.expenseTrackerApiSdk.getCategory('categoryId');

  console.log(data);
})();
```

## createCategory

- HTTP Method: `POST`
- Endpoint: `/categories`

**Parameters**

| Name | Type                                                        | Required | Description       |
| :--- | :---------------------------------------------------------- | :------- | :---------------- |
| body | [CreateCategoryRequest](../models/CreateCategoryRequest.md) | ✅       | The request body. |

**Return Type**

`any`

**Example Usage Code Snippet**

```typescript
import { CreateCategoryRequest, ExpenseTrackerApiSdk } from 'expense-tracker-api-sdk';

(async () => {
  const expenseTrackerApiSdk = new ExpenseTrackerApiSdk({
    token: 'YOUR_TOKEN',
  });

  const createCategoryRequest: CreateCategoryRequest = {
    name: 'Software & Subscriptions',
    description: 'SaaS tools, licenses and software subscriptions',
    receiptThreshold: 20,
    currency: 'USD',
  };

  const data =
    await expenseTrackerApiSdk.expenseTrackerApiSdk.createCategory(createCategoryRequest);

  console.log(data);
})();
```

## updateCategory

- HTTP Method: `PUT`
- Endpoint: `/categories/{categoryId}`

**Parameters**

| Name       | Type                                                        | Required | Description       |
| :--------- | :---------------------------------------------------------- | :------- | :---------------- |
| body       | [UpdateCategoryRequest](../models/UpdateCategoryRequest.md) | ✅       | The request body. |
| categoryId | string                                                      | ✅       |                   |

**Return Type**

`any`

**Example Usage Code Snippet**

```typescript
import { ExpenseTrackerApiSdk, UpdateCategoryRequest } from 'expense-tracker-api-sdk';

(async () => {
  const expenseTrackerApiSdk = new ExpenseTrackerApiSdk({
    token: 'YOUR_TOKEN',
  });

  const updateCategoryRequest: UpdateCategoryRequest = {
    name: 'Travel & Transport',
    description: 'Flights, trains, taxis, car hire and other transport',
    receiptThreshold: 75,
    currency: 'USD',
  };

  const data = await expenseTrackerApiSdk.expenseTrackerApiSdk.updateCategory(
    'categoryId',
    updateCategoryRequest,
  );

  console.log(data);
})();
```

## deleteCategory

- HTTP Method: `DELETE`
- Endpoint: `/categories/{categoryId}`

**Parameters**

| Name       | Type   | Required | Description |
| :--------- | :----- | :------- | :---------- |
| categoryId | string | ✅       |             |

**Return Type**

`any`

**Example Usage Code Snippet**

```typescript
import { ExpenseTrackerApiSdk } from 'expense-tracker-api-sdk';

(async () => {
  const expenseTrackerApiSdk = new ExpenseTrackerApiSdk({
    token: 'YOUR_TOKEN',
  });

  const data = await expenseTrackerApiSdk.expenseTrackerApiSdk.deleteCategory('categoryId');

  console.log(data);
})();
```

## listExpenses

- HTTP Method: `GET`
- Endpoint: `/expenses`

**Parameters**

| Name       | Type   | Required | Description                                                   |
| :--------- | :----- | :------- | :------------------------------------------------------------ |
| status     | string | ❌       | Filter by status: unclaimed \| claimed                        |
| categoryId | string | ❌       | Filter by category ID                                         |
| fromDate   | string | ❌       | Filter expenses on or after this date (ISO 8601: YYYY-MM-DD)  |
| toDate     | string | ❌       | Filter expenses on or before this date (ISO 8601: YYYY-MM-DD) |

**Return Type**

`any`

**Example Usage Code Snippet**

```typescript
import { ExpenseTrackerApiSdk } from 'expense-tracker-api-sdk';

(async () => {
  const expenseTrackerApiSdk = new ExpenseTrackerApiSdk({
    token: 'YOUR_TOKEN',
  });

  const data = await expenseTrackerApiSdk.expenseTrackerApiSdk.listExpenses({
    status: 'unclaimed',
    categoryId: 'cat-001',
    fromDate: '2024-01-01',
    toDate: '2024-12-31',
  });

  console.log(data);
})();
```

## getExpense

- HTTP Method: `GET`
- Endpoint: `/expenses/{expenseId}`

**Parameters**

| Name      | Type   | Required | Description |
| :-------- | :----- | :------- | :---------- |
| expenseId | string | ✅       |             |

**Return Type**

`any`

**Example Usage Code Snippet**

```typescript
import { ExpenseTrackerApiSdk } from 'expense-tracker-api-sdk';

(async () => {
  const expenseTrackerApiSdk = new ExpenseTrackerApiSdk({
    token: 'YOUR_TOKEN',
  });

  const data = await expenseTrackerApiSdk.expenseTrackerApiSdk.getExpense('expenseId');

  console.log(data);
})();
```

## createExpense

- HTTP Method: `POST`
- Endpoint: `/expenses`

**Parameters**

| Name | Type                                                      | Required | Description       |
| :--- | :-------------------------------------------------------- | :------- | :---------------- |
| body | [CreateExpenseRequest](../models/CreateExpenseRequest.md) | ✅       | The request body. |

**Return Type**

`any`

**Example Usage Code Snippet**

```typescript
import { CreateExpenseRequest, ExpenseTrackerApiSdk } from 'expense-tracker-api-sdk';

(async () => {
  const expenseTrackerApiSdk = new ExpenseTrackerApiSdk({
    token: 'YOUR_TOKEN',
  });

  const createExpenseRequest: CreateExpenseRequest = {
    categoryId: '{{category_id}}',
    amount: 120.5,
    currency: 'USD',
    date: '2024-06-10',
    merchant: 'Delta Airlines',
    description: 'Flight to NYC for client meeting',
    receiptUrl: 'https://storage.northbeam.com/receipts/exp-001.pdf',
  };

  const data = await expenseTrackerApiSdk.expenseTrackerApiSdk.createExpense(createExpenseRequest);

  console.log(data);
})();
```

## updateExpense

- HTTP Method: `PUT`
- Endpoint: `/expenses/{expenseId}`

**Parameters**

| Name      | Type                                                      | Required | Description       |
| :-------- | :-------------------------------------------------------- | :------- | :---------------- |
| body      | [UpdateExpenseRequest](../models/UpdateExpenseRequest.md) | ✅       | The request body. |
| expenseId | string                                                    | ✅       |                   |

**Return Type**

`any`

**Example Usage Code Snippet**

```typescript
import { ExpenseTrackerApiSdk, UpdateExpenseRequest } from 'expense-tracker-api-sdk';

(async () => {
  const expenseTrackerApiSdk = new ExpenseTrackerApiSdk({
    token: 'YOUR_TOKEN',
  });

  const updateExpenseRequest: UpdateExpenseRequest = {
    categoryId: 'cat-001',
    amount: 135,
    currency: 'USD',
    date: '2024-06-10',
    merchant: 'Delta Airlines',
    description: 'Flight to NYC for client meeting (updated fare)',
    receiptUrl: 'https://storage.northbeam.com/receipts/exp-001-v2.pdf',
  };

  const data = await expenseTrackerApiSdk.expenseTrackerApiSdk.updateExpense(
    'expenseId',
    updateExpenseRequest,
  );

  console.log(data);
})();
```

## deleteExpense

- HTTP Method: `DELETE`
- Endpoint: `/expenses/{expenseId}`

**Parameters**

| Name      | Type   | Required | Description |
| :-------- | :----- | :------- | :---------- |
| expenseId | string | ✅       |             |

**Return Type**

`any`

**Example Usage Code Snippet**

```typescript
import { ExpenseTrackerApiSdk } from 'expense-tracker-api-sdk';

(async () => {
  const expenseTrackerApiSdk = new ExpenseTrackerApiSdk({
    token: 'YOUR_TOKEN',
  });

  const data = await expenseTrackerApiSdk.expenseTrackerApiSdk.deleteExpense('expenseId');

  console.log(data);
})();
```

## listClaims

- HTTP Method: `GET`
- Endpoint: `/claims`

**Parameters**

| Name       | Type   | Required | Description                                                                |
| :--------- | :----- | :------- | :------------------------------------------------------------------------- |
| status     | string | ❌       | Filter by status: draft \| submitted \| approved \| rejected \| reimbursed |
| employeeId | string | ❌       | Filter by employee (Finance and Approver only)                             |

**Return Type**

`any`

**Example Usage Code Snippet**

```typescript
import { ExpenseTrackerApiSdk } from 'expense-tracker-api-sdk';

(async () => {
  const expenseTrackerApiSdk = new ExpenseTrackerApiSdk({
    token: 'YOUR_TOKEN',
  });

  const data = await expenseTrackerApiSdk.expenseTrackerApiSdk.listClaims({
    status: 'submitted',
    employeeId: 'usr-001',
  });

  console.log(data);
})();
```

## getClaim

- HTTP Method: `GET`
- Endpoint: `/claims/{claimId}`

**Parameters**

| Name    | Type   | Required | Description |
| :------ | :----- | :------- | :---------- |
| claimId | string | ✅       |             |

**Return Type**

`any`

**Example Usage Code Snippet**

```typescript
import { ExpenseTrackerApiSdk } from 'expense-tracker-api-sdk';

(async () => {
  const expenseTrackerApiSdk = new ExpenseTrackerApiSdk({
    token: 'YOUR_TOKEN',
  });

  const data = await expenseTrackerApiSdk.expenseTrackerApiSdk.getClaim('claimId');

  console.log(data);
})();
```

## createClaim

- HTTP Method: `POST`
- Endpoint: `/claims`

**Parameters**

| Name | Type                                                  | Required | Description       |
| :--- | :---------------------------------------------------- | :------- | :---------------- |
| body | [CreateClaimRequest](../models/CreateClaimRequest.md) | ✅       | The request body. |

**Return Type**

`any`

**Example Usage Code Snippet**

```typescript
import { CreateClaimRequest, ExpenseTrackerApiSdk } from 'expense-tracker-api-sdk';

(async () => {
  const expenseTrackerApiSdk = new ExpenseTrackerApiSdk({
    token: 'YOUR_TOKEN',
  });

  const createClaimRequest: CreateClaimRequest = {
    title: 'June 2024 NYC Trip',
    expenseIds: ['{{expense_id}}'],
  };

  const data = await expenseTrackerApiSdk.expenseTrackerApiSdk.createClaim(createClaimRequest);

  console.log(data);
})();
```

## submitClaim

- HTTP Method: `POST`
- Endpoint: `/claims/{claimId}/submit`

**Parameters**

| Name    | Type   | Required | Description |
| :------ | :----- | :------- | :---------- |
| claimId | string | ✅       |             |

**Return Type**

`any`

**Example Usage Code Snippet**

```typescript
import { ExpenseTrackerApiSdk } from 'expense-tracker-api-sdk';

(async () => {
  const expenseTrackerApiSdk = new ExpenseTrackerApiSdk({
    token: 'YOUR_TOKEN',
  });

  const data = await expenseTrackerApiSdk.expenseTrackerApiSdk.submitClaim('claimId');

  console.log(data);
})();
```

## approveClaim

- HTTP Method: `POST`
- Endpoint: `/claims/{claimId}/approve`

**Parameters**

| Name    | Type   | Required | Description |
| :------ | :----- | :------- | :---------- |
| claimId | string | ✅       |             |

**Return Type**

`any`

**Example Usage Code Snippet**

```typescript
import { ExpenseTrackerApiSdk } from 'expense-tracker-api-sdk';

(async () => {
  const expenseTrackerApiSdk = new ExpenseTrackerApiSdk({
    token: 'YOUR_TOKEN',
  });

  const data = await expenseTrackerApiSdk.expenseTrackerApiSdk.approveClaim('claimId');

  console.log(data);
})();
```
