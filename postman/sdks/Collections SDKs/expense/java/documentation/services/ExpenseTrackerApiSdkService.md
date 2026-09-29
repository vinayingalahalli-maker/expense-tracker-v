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

| Name                   | Type                                                          | Required | Description  |
| :--------------------- | :------------------------------------------------------------ | :------- | :----------- |
| loginAsEmployeeRequest | [LoginAsEmployeeRequest](../models/LoginAsEmployeeRequest.md) | ✅       | Request Body |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.expensetrackerapisdk.ExpenseTrackerApiSdk;
import com.expensetrackerapisdk.config.ExpenseTrackerApiSdkConfig;
import com.expensetrackerapisdk.models.LoginAsEmployeeRequest;

public class Main {

  public static void main(String[] args) {
    ExpenseTrackerApiSdkConfig config = ExpenseTrackerApiSdkConfig.builder()
      .accessToken("YOUR_ACCESS_TOKEN")
      .build();

    ExpenseTrackerApiSdk expenseTrackerApiSdk = new ExpenseTrackerApiSdk(config);

    LoginAsEmployeeRequest loginAsEmployeeRequest = LoginAsEmployeeRequest.builder()
      .email("alice@northbeam.com")
      .password("password123")
      .build();

    Object response = expenseTrackerApiSdk.expenseTrackerApiSdk.loginAsEmployee(
      loginAsEmployeeRequest
    );

    System.out.println(response);
  }
}

```

## loginAsApprover

- HTTP Method: `POST`
- Endpoint: `/auth/login`

**Parameters**

| Name                   | Type                                                          | Required | Description  |
| :--------------------- | :------------------------------------------------------------ | :------- | :----------- |
| loginAsApproverRequest | [LoginAsApproverRequest](../models/LoginAsApproverRequest.md) | ✅       | Request Body |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.expensetrackerapisdk.ExpenseTrackerApiSdk;
import com.expensetrackerapisdk.config.ExpenseTrackerApiSdkConfig;
import com.expensetrackerapisdk.models.LoginAsApproverRequest;

public class Main {

  public static void main(String[] args) {
    ExpenseTrackerApiSdkConfig config = ExpenseTrackerApiSdkConfig.builder()
      .accessToken("YOUR_ACCESS_TOKEN")
      .build();

    ExpenseTrackerApiSdk expenseTrackerApiSdk = new ExpenseTrackerApiSdk(config);

    LoginAsApproverRequest loginAsApproverRequest = LoginAsApproverRequest.builder()
      .email("bob@northbeam.com")
      .password("password123")
      .build();

    Object response = expenseTrackerApiSdk.expenseTrackerApiSdk.loginAsApprover(
      loginAsApproverRequest
    );

    System.out.println(response);
  }
}

```

## loginAsFinance

- HTTP Method: `POST`
- Endpoint: `/auth/login`

**Parameters**

| Name                  | Type                                                        | Required | Description  |
| :-------------------- | :---------------------------------------------------------- | :------- | :----------- |
| loginAsFinanceRequest | [LoginAsFinanceRequest](../models/LoginAsFinanceRequest.md) | ✅       | Request Body |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.expensetrackerapisdk.ExpenseTrackerApiSdk;
import com.expensetrackerapisdk.config.ExpenseTrackerApiSdkConfig;
import com.expensetrackerapisdk.models.LoginAsFinanceRequest;

public class Main {

  public static void main(String[] args) {
    ExpenseTrackerApiSdkConfig config = ExpenseTrackerApiSdkConfig.builder()
      .accessToken("YOUR_ACCESS_TOKEN")
      .build();

    ExpenseTrackerApiSdk expenseTrackerApiSdk = new ExpenseTrackerApiSdk(config);

    LoginAsFinanceRequest loginAsFinanceRequest = LoginAsFinanceRequest.builder()
      .email("carol@northbeam.com")
      .password("password123")
      .build();

    Object response = expenseTrackerApiSdk.expenseTrackerApiSdk.loginAsFinance(
      loginAsFinanceRequest
    );

    System.out.println(response);
  }
}

```

## listCategories

- HTTP Method: `GET`
- Endpoint: `/categories`

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.expensetrackerapisdk.ExpenseTrackerApiSdk;
import com.expensetrackerapisdk.config.ExpenseTrackerApiSdkConfig;

public class Main {

  public static void main(String[] args) {
    ExpenseTrackerApiSdkConfig config = ExpenseTrackerApiSdkConfig.builder()
      .accessToken("YOUR_ACCESS_TOKEN")
      .build();

    ExpenseTrackerApiSdk expenseTrackerApiSdk = new ExpenseTrackerApiSdk(config);

    Object response = expenseTrackerApiSdk.expenseTrackerApiSdk.listCategories();

    System.out.println(response);
  }
}

```

## getCategory

- HTTP Method: `GET`
- Endpoint: `/categories/{categoryId}`

**Parameters**

| Name       | Type   | Required | Description |
| :--------- | :----- | :------- | :---------- |
| categoryId | String | ✅       |             |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.expensetrackerapisdk.ExpenseTrackerApiSdk;
import com.expensetrackerapisdk.config.ExpenseTrackerApiSdkConfig;

public class Main {

  public static void main(String[] args) {
    ExpenseTrackerApiSdkConfig config = ExpenseTrackerApiSdkConfig.builder()
      .accessToken("YOUR_ACCESS_TOKEN")
      .build();

    ExpenseTrackerApiSdk expenseTrackerApiSdk = new ExpenseTrackerApiSdk(config);

    Object response = expenseTrackerApiSdk.expenseTrackerApiSdk.getCategory("categoryId");

    System.out.println(response);
  }
}

```

## createCategory

- HTTP Method: `POST`
- Endpoint: `/categories`

**Parameters**

| Name                  | Type                                                        | Required | Description  |
| :-------------------- | :---------------------------------------------------------- | :------- | :----------- |
| createCategoryRequest | [CreateCategoryRequest](../models/CreateCategoryRequest.md) | ✅       | Request Body |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.expensetrackerapisdk.ExpenseTrackerApiSdk;
import com.expensetrackerapisdk.config.ExpenseTrackerApiSdkConfig;
import com.expensetrackerapisdk.models.CreateCategoryRequest;

public class Main {

  public static void main(String[] args) {
    ExpenseTrackerApiSdkConfig config = ExpenseTrackerApiSdkConfig.builder()
      .accessToken("YOUR_ACCESS_TOKEN")
      .build();

    ExpenseTrackerApiSdk expenseTrackerApiSdk = new ExpenseTrackerApiSdk(config);

    CreateCategoryRequest createCategoryRequest = CreateCategoryRequest.builder()
      .name("Software & Subscriptions")
      .description("SaaS tools, licenses and software subscriptions")
      .receiptThreshold(20D)
      .currency("USD")
      .build();

    Object response = expenseTrackerApiSdk.expenseTrackerApiSdk.createCategory(
      createCategoryRequest
    );

    System.out.println(response);
  }
}

```

## updateCategory

- HTTP Method: `PUT`
- Endpoint: `/categories/{categoryId}`

**Parameters**

| Name                  | Type                                                        | Required | Description  |
| :-------------------- | :---------------------------------------------------------- | :------- | :----------- |
| categoryId            | String                                                      | ✅       |              |
| updateCategoryRequest | [UpdateCategoryRequest](../models/UpdateCategoryRequest.md) | ✅       | Request Body |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.expensetrackerapisdk.ExpenseTrackerApiSdk;
import com.expensetrackerapisdk.config.ExpenseTrackerApiSdkConfig;
import com.expensetrackerapisdk.models.UpdateCategoryRequest;

public class Main {

  public static void main(String[] args) {
    ExpenseTrackerApiSdkConfig config = ExpenseTrackerApiSdkConfig.builder()
      .accessToken("YOUR_ACCESS_TOKEN")
      .build();

    ExpenseTrackerApiSdk expenseTrackerApiSdk = new ExpenseTrackerApiSdk(config);

    UpdateCategoryRequest updateCategoryRequest = UpdateCategoryRequest.builder()
      .name("Travel & Transport")
      .description("Flights, trains, taxis, car hire and other transport")
      .receiptThreshold(75D)
      .currency("USD")
      .build();

    Object response = expenseTrackerApiSdk.expenseTrackerApiSdk.updateCategory(
      "categoryId",
      updateCategoryRequest
    );

    System.out.println(response);
  }
}

```

## deleteCategory

- HTTP Method: `DELETE`
- Endpoint: `/categories/{categoryId}`

**Parameters**

| Name       | Type   | Required | Description |
| :--------- | :----- | :------- | :---------- |
| categoryId | String | ✅       |             |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.expensetrackerapisdk.ExpenseTrackerApiSdk;
import com.expensetrackerapisdk.config.ExpenseTrackerApiSdkConfig;

public class Main {

  public static void main(String[] args) {
    ExpenseTrackerApiSdkConfig config = ExpenseTrackerApiSdkConfig.builder()
      .accessToken("YOUR_ACCESS_TOKEN")
      .build();

    ExpenseTrackerApiSdk expenseTrackerApiSdk = new ExpenseTrackerApiSdk(config);

    Object response = expenseTrackerApiSdk.expenseTrackerApiSdk.deleteCategory("categoryId");

    System.out.println(response);
  }
}

```

## listExpenses

- HTTP Method: `GET`
- Endpoint: `/expenses`

**Parameters**

| Name              | Type                                                          | Required | Description               |
| :---------------- | :------------------------------------------------------------ | :------- | :------------------------ |
| requestParameters | [ListExpensesParameters](../models/ListExpensesParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.expensetrackerapisdk.ExpenseTrackerApiSdk;
import com.expensetrackerapisdk.config.ExpenseTrackerApiSdkConfig;
import com.expensetrackerapisdk.models.ListExpensesParameters;

public class Main {

  public static void main(String[] args) {
    ExpenseTrackerApiSdkConfig config = ExpenseTrackerApiSdkConfig.builder()
      .accessToken("YOUR_ACCESS_TOKEN")
      .build();

    ExpenseTrackerApiSdk expenseTrackerApiSdk = new ExpenseTrackerApiSdk(config);

    ListExpensesParameters requestParameters = ListExpensesParameters.builder()
      .status("unclaimed")
      .categoryId("cat-001")
      .fromDate("2024-01-01")
      .toDate("2024-12-31")
      .build();

    Object response = expenseTrackerApiSdk.expenseTrackerApiSdk.listExpenses(requestParameters);

    System.out.println(response);
  }
}

```

## getExpense

- HTTP Method: `GET`
- Endpoint: `/expenses/{expenseId}`

**Parameters**

| Name      | Type   | Required | Description |
| :-------- | :----- | :------- | :---------- |
| expenseId | String | ✅       |             |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.expensetrackerapisdk.ExpenseTrackerApiSdk;
import com.expensetrackerapisdk.config.ExpenseTrackerApiSdkConfig;

public class Main {

  public static void main(String[] args) {
    ExpenseTrackerApiSdkConfig config = ExpenseTrackerApiSdkConfig.builder()
      .accessToken("YOUR_ACCESS_TOKEN")
      .build();

    ExpenseTrackerApiSdk expenseTrackerApiSdk = new ExpenseTrackerApiSdk(config);

    Object response = expenseTrackerApiSdk.expenseTrackerApiSdk.getExpense("expenseId");

    System.out.println(response);
  }
}

```

## createExpense

- HTTP Method: `POST`
- Endpoint: `/expenses`

**Parameters**

| Name                 | Type                                                      | Required | Description  |
| :------------------- | :-------------------------------------------------------- | :------- | :----------- |
| createExpenseRequest | [CreateExpenseRequest](../models/CreateExpenseRequest.md) | ✅       | Request Body |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.expensetrackerapisdk.ExpenseTrackerApiSdk;
import com.expensetrackerapisdk.config.ExpenseTrackerApiSdkConfig;
import com.expensetrackerapisdk.models.CreateExpenseRequest;

public class Main {

  public static void main(String[] args) {
    ExpenseTrackerApiSdkConfig config = ExpenseTrackerApiSdkConfig.builder()
      .accessToken("YOUR_ACCESS_TOKEN")
      .build();

    ExpenseTrackerApiSdk expenseTrackerApiSdk = new ExpenseTrackerApiSdk(config);

    CreateExpenseRequest createExpenseRequest = CreateExpenseRequest.builder()
      .categoryId("{{category_id}}")
      .amount(120.5D)
      .currency("USD")
      .date("2024-06-10")
      .merchant("Delta Airlines")
      .description("Flight to NYC for client meeting")
      .receiptUrl("https://storage.northbeam.com/receipts/exp-001.pdf")
      .build();

    Object response = expenseTrackerApiSdk.expenseTrackerApiSdk.createExpense(createExpenseRequest);

    System.out.println(response);
  }
}

```

## updateExpense

- HTTP Method: `PUT`
- Endpoint: `/expenses/{expenseId}`

**Parameters**

| Name                 | Type                                                      | Required | Description  |
| :------------------- | :-------------------------------------------------------- | :------- | :----------- |
| expenseId            | String                                                    | ✅       |              |
| updateExpenseRequest | [UpdateExpenseRequest](../models/UpdateExpenseRequest.md) | ✅       | Request Body |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.expensetrackerapisdk.ExpenseTrackerApiSdk;
import com.expensetrackerapisdk.config.ExpenseTrackerApiSdkConfig;
import com.expensetrackerapisdk.models.UpdateExpenseRequest;

public class Main {

  public static void main(String[] args) {
    ExpenseTrackerApiSdkConfig config = ExpenseTrackerApiSdkConfig.builder()
      .accessToken("YOUR_ACCESS_TOKEN")
      .build();

    ExpenseTrackerApiSdk expenseTrackerApiSdk = new ExpenseTrackerApiSdk(config);

    UpdateExpenseRequest updateExpenseRequest = UpdateExpenseRequest.builder()
      .categoryId("cat-001")
      .amount(135D)
      .currency("USD")
      .date("2024-06-10")
      .merchant("Delta Airlines")
      .description("Flight to NYC for client meeting (updated fare)")
      .receiptUrl("https://storage.northbeam.com/receipts/exp-001-v2.pdf")
      .build();

    Object response = expenseTrackerApiSdk.expenseTrackerApiSdk.updateExpense(
      "expenseId",
      updateExpenseRequest
    );

    System.out.println(response);
  }
}

```

## deleteExpense

- HTTP Method: `DELETE`
- Endpoint: `/expenses/{expenseId}`

**Parameters**

| Name      | Type   | Required | Description |
| :-------- | :----- | :------- | :---------- |
| expenseId | String | ✅       |             |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.expensetrackerapisdk.ExpenseTrackerApiSdk;
import com.expensetrackerapisdk.config.ExpenseTrackerApiSdkConfig;

public class Main {

  public static void main(String[] args) {
    ExpenseTrackerApiSdkConfig config = ExpenseTrackerApiSdkConfig.builder()
      .accessToken("YOUR_ACCESS_TOKEN")
      .build();

    ExpenseTrackerApiSdk expenseTrackerApiSdk = new ExpenseTrackerApiSdk(config);

    Object response = expenseTrackerApiSdk.expenseTrackerApiSdk.deleteExpense("expenseId");

    System.out.println(response);
  }
}

```

## listClaims

- HTTP Method: `GET`
- Endpoint: `/claims`

**Parameters**

| Name              | Type                                                      | Required | Description               |
| :---------------- | :-------------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [ListClaimsParameters](../models/ListClaimsParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.expensetrackerapisdk.ExpenseTrackerApiSdk;
import com.expensetrackerapisdk.config.ExpenseTrackerApiSdkConfig;
import com.expensetrackerapisdk.models.ListClaimsParameters;

public class Main {

  public static void main(String[] args) {
    ExpenseTrackerApiSdkConfig config = ExpenseTrackerApiSdkConfig.builder()
      .accessToken("YOUR_ACCESS_TOKEN")
      .build();

    ExpenseTrackerApiSdk expenseTrackerApiSdk = new ExpenseTrackerApiSdk(config);

    ListClaimsParameters requestParameters = ListClaimsParameters.builder()
      .status("submitted")
      .employeeId("usr-001")
      .build();

    Object response = expenseTrackerApiSdk.expenseTrackerApiSdk.listClaims(requestParameters);

    System.out.println(response);
  }
}

```

## getClaim

- HTTP Method: `GET`
- Endpoint: `/claims/{claimId}`

**Parameters**

| Name    | Type   | Required | Description |
| :------ | :----- | :------- | :---------- |
| claimId | String | ✅       |             |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.expensetrackerapisdk.ExpenseTrackerApiSdk;
import com.expensetrackerapisdk.config.ExpenseTrackerApiSdkConfig;

public class Main {

  public static void main(String[] args) {
    ExpenseTrackerApiSdkConfig config = ExpenseTrackerApiSdkConfig.builder()
      .accessToken("YOUR_ACCESS_TOKEN")
      .build();

    ExpenseTrackerApiSdk expenseTrackerApiSdk = new ExpenseTrackerApiSdk(config);

    Object response = expenseTrackerApiSdk.expenseTrackerApiSdk.getClaim("claimId");

    System.out.println(response);
  }
}

```

## createClaim

- HTTP Method: `POST`
- Endpoint: `/claims`

**Parameters**

| Name               | Type                                                  | Required | Description  |
| :----------------- | :---------------------------------------------------- | :------- | :----------- |
| createClaimRequest | [CreateClaimRequest](../models/CreateClaimRequest.md) | ✅       | Request Body |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.expensetrackerapisdk.ExpenseTrackerApiSdk;
import com.expensetrackerapisdk.config.ExpenseTrackerApiSdkConfig;
import com.expensetrackerapisdk.models.CreateClaimRequest;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    ExpenseTrackerApiSdkConfig config = ExpenseTrackerApiSdkConfig.builder()
      .accessToken("YOUR_ACCESS_TOKEN")
      .build();

    ExpenseTrackerApiSdk expenseTrackerApiSdk = new ExpenseTrackerApiSdk(config);

    List<String> expenseIdsList = Arrays.asList("{{expense_id}}");

    CreateClaimRequest createClaimRequest = CreateClaimRequest.builder()
      .title("June 2024 NYC Trip")
      .expenseIds(expenseIdsList)
      .build();

    Object response = expenseTrackerApiSdk.expenseTrackerApiSdk.createClaim(createClaimRequest);

    System.out.println(response);
  }
}

```

## submitClaim

- HTTP Method: `POST`
- Endpoint: `/claims/{claimId}/submit`

**Parameters**

| Name    | Type   | Required | Description |
| :------ | :----- | :------- | :---------- |
| claimId | String | ✅       |             |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.expensetrackerapisdk.ExpenseTrackerApiSdk;
import com.expensetrackerapisdk.config.ExpenseTrackerApiSdkConfig;

public class Main {

  public static void main(String[] args) {
    ExpenseTrackerApiSdkConfig config = ExpenseTrackerApiSdkConfig.builder()
      .accessToken("YOUR_ACCESS_TOKEN")
      .build();

    ExpenseTrackerApiSdk expenseTrackerApiSdk = new ExpenseTrackerApiSdk(config);

    Object response = expenseTrackerApiSdk.expenseTrackerApiSdk.submitClaim("claimId");

    System.out.println(response);
  }
}

```

## approveClaim

- HTTP Method: `POST`
- Endpoint: `/claims/{claimId}/approve`

**Parameters**

| Name    | Type   | Required | Description |
| :------ | :----- | :------- | :---------- |
| claimId | String | ✅       |             |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import com.expensetrackerapisdk.ExpenseTrackerApiSdk;
import com.expensetrackerapisdk.config.ExpenseTrackerApiSdkConfig;

public class Main {

  public static void main(String[] args) {
    ExpenseTrackerApiSdkConfig config = ExpenseTrackerApiSdkConfig.builder()
      .accessToken("YOUR_ACCESS_TOKEN")
      .build();

    ExpenseTrackerApiSdk expenseTrackerApiSdk = new ExpenseTrackerApiSdk(config);

    Object response = expenseTrackerApiSdk.expenseTrackerApiSdk.approveClaim("claimId");

    System.out.println(response);
  }
}

```
