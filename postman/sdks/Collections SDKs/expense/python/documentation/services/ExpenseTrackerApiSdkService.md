# ExpenseTrackerApiSdkService

A list of all methods in the `ExpenseTrackerApiSdkService` service. Click on the method name to view detailed information about that method.

| Methods                                 | Description |
| :-------------------------------------- | :---------- |
| [login_as_employee](#login_as_employee) |             |
| [login_as_approver](#login_as_approver) |             |
| [login_as_finance](#login_as_finance)   |             |
| [list_categories](#list_categories)     |             |
| [get_category](#get_category)           |             |
| [create_category](#create_category)     |             |
| [update_category](#update_category)     |             |
| [delete_category](#delete_category)     |             |
| [list_expenses](#list_expenses)         |             |
| [get_expense](#get_expense)             |             |
| [create_expense](#create_expense)       |             |
| [update_expense](#update_expense)       |             |
| [delete_expense](#delete_expense)       |             |
| [list_claims](#list_claims)             |             |
| [get_claim](#get_claim)                 |             |
| [create_claim](#create_claim)           |             |
| [submit_claim](#submit_claim)           |             |
| [approve_claim](#approve_claim)         |             |

## login_as_employee

- HTTP Method: `POST`
- Endpoint: `/auth/login`

**Parameters**

| Name         | Type                                                          | Required | Description       |
| :----------- | :------------------------------------------------------------ | :------- | :---------------- |
| request_body | [LoginAsEmployeeRequest](../models/LoginAsEmployeeRequest.md) | ✅       | The request body. |

**Return Type**

`Any`

**Example Usage Code Snippet**

```python
from expense_tracker_api_sdk import ExpenseTrackerApiSdk, Environment
from expense_tracker_api_sdk.models import LoginAsEmployeeRequest

sdk = ExpenseTrackerApiSdk(
    access_token="YOUR_ACCESS_TOKEN",
    base_url=Environment.DEFAULT.value,
    timeout=10
)

request_body = LoginAsEmployeeRequest(
    email="alice@northbeam.com",
    password="password123"
)

result = sdk.expense_tracker_api_sdk.login_as_employee(request_body=request_body)

print(result)
```

## login_as_approver

- HTTP Method: `POST`
- Endpoint: `/auth/login`

**Parameters**

| Name         | Type                                                          | Required | Description       |
| :----------- | :------------------------------------------------------------ | :------- | :---------------- |
| request_body | [LoginAsApproverRequest](../models/LoginAsApproverRequest.md) | ✅       | The request body. |

**Return Type**

`Any`

**Example Usage Code Snippet**

```python
from expense_tracker_api_sdk import ExpenseTrackerApiSdk, Environment
from expense_tracker_api_sdk.models import LoginAsApproverRequest

sdk = ExpenseTrackerApiSdk(
    access_token="YOUR_ACCESS_TOKEN",
    base_url=Environment.DEFAULT.value,
    timeout=10
)

request_body = LoginAsApproverRequest(
    email="bob@northbeam.com",
    password="password123"
)

result = sdk.expense_tracker_api_sdk.login_as_approver(request_body=request_body)

print(result)
```

## login_as_finance

- HTTP Method: `POST`
- Endpoint: `/auth/login`

**Parameters**

| Name         | Type                                                        | Required | Description       |
| :----------- | :---------------------------------------------------------- | :------- | :---------------- |
| request_body | [LoginAsFinanceRequest](../models/LoginAsFinanceRequest.md) | ✅       | The request body. |

**Return Type**

`Any`

**Example Usage Code Snippet**

```python
from expense_tracker_api_sdk import ExpenseTrackerApiSdk, Environment
from expense_tracker_api_sdk.models import LoginAsFinanceRequest

sdk = ExpenseTrackerApiSdk(
    access_token="YOUR_ACCESS_TOKEN",
    base_url=Environment.DEFAULT.value,
    timeout=10
)

request_body = LoginAsFinanceRequest(
    email="carol@northbeam.com",
    password="password123"
)

result = sdk.expense_tracker_api_sdk.login_as_finance(request_body=request_body)

print(result)
```

## list_categories

- HTTP Method: `GET`
- Endpoint: `/categories`

**Return Type**

`Any`

**Example Usage Code Snippet**

```python
from expense_tracker_api_sdk import ExpenseTrackerApiSdk, Environment

sdk = ExpenseTrackerApiSdk(
    access_token="YOUR_ACCESS_TOKEN",
    base_url=Environment.DEFAULT.value,
    timeout=10
)

result = sdk.expense_tracker_api_sdk.list_categories()

print(result)
```

## get_category

- HTTP Method: `GET`
- Endpoint: `/categories/{categoryId}`

**Parameters**

| Name        | Type | Required | Description |
| :---------- | :--- | :------- | :---------- |
| category_id | str  | ✅       |             |

**Return Type**

`Any`

**Example Usage Code Snippet**

```python
from expense_tracker_api_sdk import ExpenseTrackerApiSdk, Environment

sdk = ExpenseTrackerApiSdk(
    access_token="YOUR_ACCESS_TOKEN",
    base_url=Environment.DEFAULT.value,
    timeout=10
)

result = sdk.expense_tracker_api_sdk.get_category(category_id="categoryId")

print(result)
```

## create_category

- HTTP Method: `POST`
- Endpoint: `/categories`

**Parameters**

| Name         | Type                                                        | Required | Description       |
| :----------- | :---------------------------------------------------------- | :------- | :---------------- |
| request_body | [CreateCategoryRequest](../models/CreateCategoryRequest.md) | ✅       | The request body. |

**Return Type**

`Any`

**Example Usage Code Snippet**

```python
from expense_tracker_api_sdk import ExpenseTrackerApiSdk, Environment
from expense_tracker_api_sdk.models import CreateCategoryRequest

sdk = ExpenseTrackerApiSdk(
    access_token="YOUR_ACCESS_TOKEN",
    base_url=Environment.DEFAULT.value,
    timeout=10
)

request_body = CreateCategoryRequest(
    name="Software & Subscriptions",
    description="SaaS tools, licenses and software subscriptions",
    receipt_threshold=20,
    currency="USD"
)

result = sdk.expense_tracker_api_sdk.create_category(request_body=request_body)

print(result)
```

## update_category

- HTTP Method: `PUT`
- Endpoint: `/categories/{categoryId}`

**Parameters**

| Name         | Type                                                        | Required | Description       |
| :----------- | :---------------------------------------------------------- | :------- | :---------------- |
| request_body | [UpdateCategoryRequest](../models/UpdateCategoryRequest.md) | ✅       | The request body. |
| category_id  | str                                                         | ✅       |                   |

**Return Type**

`Any`

**Example Usage Code Snippet**

```python
from expense_tracker_api_sdk import ExpenseTrackerApiSdk, Environment
from expense_tracker_api_sdk.models import UpdateCategoryRequest

sdk = ExpenseTrackerApiSdk(
    access_token="YOUR_ACCESS_TOKEN",
    base_url=Environment.DEFAULT.value,
    timeout=10
)

request_body = UpdateCategoryRequest(
    name="Travel & Transport",
    description="Flights, trains, taxis, car hire and other transport",
    receipt_threshold=75,
    currency="USD"
)

result = sdk.expense_tracker_api_sdk.update_category(
    request_body=request_body,
    category_id="categoryId"
)

print(result)
```

## delete_category

- HTTP Method: `DELETE`
- Endpoint: `/categories/{categoryId}`

**Parameters**

| Name        | Type | Required | Description |
| :---------- | :--- | :------- | :---------- |
| category_id | str  | ✅       |             |

**Return Type**

`Any`

**Example Usage Code Snippet**

```python
from expense_tracker_api_sdk import ExpenseTrackerApiSdk, Environment

sdk = ExpenseTrackerApiSdk(
    access_token="YOUR_ACCESS_TOKEN",
    base_url=Environment.DEFAULT.value,
    timeout=10
)

result = sdk.expense_tracker_api_sdk.delete_category(category_id="categoryId")

print(result)
```

## list_expenses

- HTTP Method: `GET`
- Endpoint: `/expenses`

**Parameters**

| Name        | Type | Required | Description                                                   |
| :---------- | :--- | :------- | :------------------------------------------------------------ |
| status      | str  | ❌       | Filter by status: unclaimed \| claimed                        |
| category_id | str  | ❌       | Filter by category ID                                         |
| from_date   | str  | ❌       | Filter expenses on or after this date (ISO 8601: YYYY-MM-DD)  |
| to_date     | str  | ❌       | Filter expenses on or before this date (ISO 8601: YYYY-MM-DD) |

**Return Type**

`Any`

**Example Usage Code Snippet**

```python
from expense_tracker_api_sdk import ExpenseTrackerApiSdk, Environment

sdk = ExpenseTrackerApiSdk(
    access_token="YOUR_ACCESS_TOKEN",
    base_url=Environment.DEFAULT.value,
    timeout=10
)

result = sdk.expense_tracker_api_sdk.list_expenses(
    status="unclaimed",
    category_id="cat-001",
    from_date="2024-01-01",
    to_date="2024-12-31"
)

print(result)
```

## get_expense

- HTTP Method: `GET`
- Endpoint: `/expenses/{expenseId}`

**Parameters**

| Name       | Type | Required | Description |
| :--------- | :--- | :------- | :---------- |
| expense_id | str  | ✅       |             |

**Return Type**

`Any`

**Example Usage Code Snippet**

```python
from expense_tracker_api_sdk import ExpenseTrackerApiSdk, Environment

sdk = ExpenseTrackerApiSdk(
    access_token="YOUR_ACCESS_TOKEN",
    base_url=Environment.DEFAULT.value,
    timeout=10
)

result = sdk.expense_tracker_api_sdk.get_expense(expense_id="expenseId")

print(result)
```

## create_expense

- HTTP Method: `POST`
- Endpoint: `/expenses`

**Parameters**

| Name         | Type                                                      | Required | Description       |
| :----------- | :-------------------------------------------------------- | :------- | :---------------- |
| request_body | [CreateExpenseRequest](../models/CreateExpenseRequest.md) | ✅       | The request body. |

**Return Type**

`Any`

**Example Usage Code Snippet**

```python
from expense_tracker_api_sdk import ExpenseTrackerApiSdk, Environment
from expense_tracker_api_sdk.models import CreateExpenseRequest

sdk = ExpenseTrackerApiSdk(
    access_token="YOUR_ACCESS_TOKEN",
    base_url=Environment.DEFAULT.value,
    timeout=10
)

request_body = CreateExpenseRequest(
    category_id="{{category_id}}",
    amount=120.5,
    currency="USD",
    date_="2024-06-10",
    merchant="Delta Airlines",
    description="Flight to NYC for client meeting",
    receipt_url="https://storage.northbeam.com/receipts/exp-001.pdf"
)

result = sdk.expense_tracker_api_sdk.create_expense(request_body=request_body)

print(result)
```

## update_expense

- HTTP Method: `PUT`
- Endpoint: `/expenses/{expenseId}`

**Parameters**

| Name         | Type                                                      | Required | Description       |
| :----------- | :-------------------------------------------------------- | :------- | :---------------- |
| request_body | [UpdateExpenseRequest](../models/UpdateExpenseRequest.md) | ✅       | The request body. |
| expense_id   | str                                                       | ✅       |                   |

**Return Type**

`Any`

**Example Usage Code Snippet**

```python
from expense_tracker_api_sdk import ExpenseTrackerApiSdk, Environment
from expense_tracker_api_sdk.models import UpdateExpenseRequest

sdk = ExpenseTrackerApiSdk(
    access_token="YOUR_ACCESS_TOKEN",
    base_url=Environment.DEFAULT.value,
    timeout=10
)

request_body = UpdateExpenseRequest(
    category_id="cat-001",
    amount=135,
    currency="USD",
    date_="2024-06-10",
    merchant="Delta Airlines",
    description="Flight to NYC for client meeting (updated fare)",
    receipt_url="https://storage.northbeam.com/receipts/exp-001-v2.pdf"
)

result = sdk.expense_tracker_api_sdk.update_expense(
    request_body=request_body,
    expense_id="expenseId"
)

print(result)
```

## delete_expense

- HTTP Method: `DELETE`
- Endpoint: `/expenses/{expenseId}`

**Parameters**

| Name       | Type | Required | Description |
| :--------- | :--- | :------- | :---------- |
| expense_id | str  | ✅       |             |

**Return Type**

`Any`

**Example Usage Code Snippet**

```python
from expense_tracker_api_sdk import ExpenseTrackerApiSdk, Environment

sdk = ExpenseTrackerApiSdk(
    access_token="YOUR_ACCESS_TOKEN",
    base_url=Environment.DEFAULT.value,
    timeout=10
)

result = sdk.expense_tracker_api_sdk.delete_expense(expense_id="expenseId")

print(result)
```

## list_claims

- HTTP Method: `GET`
- Endpoint: `/claims`

**Parameters**

| Name        | Type | Required | Description                                                                |
| :---------- | :--- | :------- | :------------------------------------------------------------------------- |
| status      | str  | ❌       | Filter by status: draft \| submitted \| approved \| rejected \| reimbursed |
| employee_id | str  | ❌       | Filter by employee (Finance and Approver only)                             |

**Return Type**

`Any`

**Example Usage Code Snippet**

```python
from expense_tracker_api_sdk import ExpenseTrackerApiSdk, Environment

sdk = ExpenseTrackerApiSdk(
    access_token="YOUR_ACCESS_TOKEN",
    base_url=Environment.DEFAULT.value,
    timeout=10
)

result = sdk.expense_tracker_api_sdk.list_claims(
    status="submitted",
    employee_id="usr-001"
)

print(result)
```

## get_claim

- HTTP Method: `GET`
- Endpoint: `/claims/{claimId}`

**Parameters**

| Name     | Type | Required | Description |
| :------- | :--- | :------- | :---------- |
| claim_id | str  | ✅       |             |

**Return Type**

`Any`

**Example Usage Code Snippet**

```python
from expense_tracker_api_sdk import ExpenseTrackerApiSdk, Environment

sdk = ExpenseTrackerApiSdk(
    access_token="YOUR_ACCESS_TOKEN",
    base_url=Environment.DEFAULT.value,
    timeout=10
)

result = sdk.expense_tracker_api_sdk.get_claim(claim_id="claimId")

print(result)
```

## create_claim

- HTTP Method: `POST`
- Endpoint: `/claims`

**Parameters**

| Name         | Type                                                  | Required | Description       |
| :----------- | :---------------------------------------------------- | :------- | :---------------- |
| request_body | [CreateClaimRequest](../models/CreateClaimRequest.md) | ✅       | The request body. |

**Return Type**

`Any`

**Example Usage Code Snippet**

```python
from expense_tracker_api_sdk import ExpenseTrackerApiSdk, Environment
from expense_tracker_api_sdk.models import CreateClaimRequest

sdk = ExpenseTrackerApiSdk(
    access_token="YOUR_ACCESS_TOKEN",
    base_url=Environment.DEFAULT.value,
    timeout=10
)

request_body = CreateClaimRequest(
    title="June 2024 NYC Trip",
    expense_ids=[
        "{{expense_id}}"
    ]
)

result = sdk.expense_tracker_api_sdk.create_claim(request_body=request_body)

print(result)
```

## submit_claim

- HTTP Method: `POST`
- Endpoint: `/claims/{claimId}/submit`

**Parameters**

| Name     | Type | Required | Description |
| :------- | :--- | :------- | :---------- |
| claim_id | str  | ✅       |             |

**Return Type**

`Any`

**Example Usage Code Snippet**

```python
from expense_tracker_api_sdk import ExpenseTrackerApiSdk, Environment

sdk = ExpenseTrackerApiSdk(
    access_token="YOUR_ACCESS_TOKEN",
    base_url=Environment.DEFAULT.value,
    timeout=10
)

result = sdk.expense_tracker_api_sdk.submit_claim(claim_id="claimId")

print(result)
```

## approve_claim

- HTTP Method: `POST`
- Endpoint: `/claims/{claimId}/approve`

**Parameters**

| Name     | Type | Required | Description |
| :------- | :--- | :------- | :---------- |
| claim_id | str  | ✅       |             |

**Return Type**

`Any`

**Example Usage Code Snippet**

```python
from expense_tracker_api_sdk import ExpenseTrackerApiSdk, Environment

sdk = ExpenseTrackerApiSdk(
    access_token="YOUR_ACCESS_TOKEN",
    base_url=Environment.DEFAULT.value,
    timeout=10
)

result = sdk.expense_tracker_api_sdk.approve_claim(claim_id="claimId")

print(result)
```
