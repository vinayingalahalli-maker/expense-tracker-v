# ExpenseTrackerApiSdk Java SDK 1.0.0

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
- [Injecting a Custom HTTP Client](#injecting-a-custom-http-client)
- [Accessing the Raw HTTP Response](#accessing-the-raw-http-response)
- [Sample Usage](#sample-usage)
- [Services](#services)
- [Models](#models)

# Setup & Configuration

## Supported Language Versions

This SDK is compatible with the following versions: `Java >= 1.8`

## Installation

If you use Maven, place the following within the _dependency_ tag in your `pom.xml` file:

```XML
<dependency>
    <groupId>com</groupId>
    <artifactId>expensetrackerapisdk</artifactId>
    <version>1.0.0</version>
</dependency>
```

If you use Gradle, paste the next line inside the _dependencies_ block of your `build.gradle` file:

```Gradle
implementation("com:expensetrackerapisdk:1.0.0")
```

If you use JAR files, package the SDK by running the following command:

```shell
mvn compile assembly:single
```

Then, add the JAR file to your project's classpath.

## Authentication

### Access Token Authentication

The ExpenseTrackerApiSdk API uses an Access Token for authentication.

This token must be provided to authenticate your requests to the API.

#### Setting the Access Token

When you initialize the SDK, you can set the access token as follows:

```java
import com.expensetrackerapisdk.ExpenseTrackerApiSdk;
import com.expensetrackerapisdk.config.ExpenseTrackerApiSdkConfig;

public class Main {

  public static void main(String[] args) {
    ExpenseTrackerApiSdkConfig config = ExpenseTrackerApiSdkConfig.builder()
      .accessToken("YOUR_ACCESS_TOKEN")
      .build();

    ExpenseTrackerApiSdk expenseTrackerApiSdk = new ExpenseTrackerApiSdk(config);
  }
}

```

If you need to set or update the access token after initializing the SDK, you can use:

```java
expenseTrackerApiSdk.setAccessToken('YOUR_ACCESS_TOKEN');
```

## Setting a Custom Timeout

You can set a custom timeout for the SDK's HTTP requests as follows:

```java
import com.expensetrackerapisdk.ExpenseTrackerApiSdk;
import com.expensetrackerapisdk.config.ExpenseTrackerApiSdkConfig;

public class Main {

  public static void main(String[] args) {
    ExpenseTrackerApiSdkConfig config = ExpenseTrackerApiSdkConfig.builder().timeout(10000).build();
    ExpenseTrackerApiSdk expenseTrackerApiSdk = new ExpenseTrackerApiSdk(config);
  }
}

```

## Injecting a Custom HTTP Client

You can supply your own `OkHttpClient` — for example to configure a proxy, a shared connection pool, custom TLS, timeouts, or your own interceptors. The SDK derives its client from the one you provide (preserving your transport settings and interceptors) and layers its own interceptors (such as authentication and retry) on top, so the SDK keeps working as usual.

```java
OkHttpClient customClient = new OkHttpClient.Builder().addInterceptor(new MyInterceptor()).build();

ExpenseTrackerApiSdk expenseTrackerApiSdk = new ExpenseTrackerApiSdk(
  ExpenseTrackerApiSdkConfig.builder().httpClient(customClient).build()
);

```

`MyInterceptor` above is a placeholder for your own `okhttp3.Interceptor`.

> Your client's interceptors are added ahead of the SDK's, so on the outbound request they run before the SDK adds its own headers. A logging interceptor placed this way will **not** see SDK-injected headers such as authentication.

> **Timeout precedence:** when you inject a client, the config-level `timeout` is not applied — your client's own timeout settings are preserved. Per-request, method, and service-level timeout overrides still apply, layered on top of your client.

## Accessing the Raw HTTP Response

Every service method returns the parsed response body by default. When you also need the status code, response headers, or the raw HTTP response, call the same method through the per-call `withRawResponse()` accessor. The default methods are unchanged, so this is fully opt-in.

```java
ExpenseTrackerApiSdkResponse<Object> response =
    expenseTrackerApiSdk.expenseTrackerApiSdk.withRawResponse().listCategories();

response.getData();
response.getMetadata().getStatusCode();
response.getMetadata().getHeaders();
response.getRaw();
```

`getData()` returns the same value the default method would; `getMetadata()` exposes the status code and headers, and `getRaw()` exposes the underlying HTTP response.

# Sample Usage

Below is a comprehensive example demonstrating how to authenticate and call a simple endpoint:

```java
import com.expensetrackerapisdk.ExpenseTrackerApiSdk;
import com.expensetrackerapisdk.config.ExpenseTrackerApiSdkConfig;
import com.expensetrackerapisdk.exceptions.ApiError;

public class Main {

  public static void main(String[] args) {
    ExpenseTrackerApiSdkConfig config = ExpenseTrackerApiSdkConfig.builder()
      .accessToken("YOUR_ACCESS_TOKEN")
      .build();

    ExpenseTrackerApiSdk expenseTrackerApiSdk = new ExpenseTrackerApiSdk(config);

    try {
      Object response = expenseTrackerApiSdk.expenseTrackerApiSdk.listCategories();

      System.out.println(response);
    } catch (ApiError e) {
      e.printStackTrace();
    }

    System.exit(0);
  }
}

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
| [ListExpensesParameters](documentation/models/ListExpensesParameters.md) |             |
| [CreateExpenseRequest](documentation/models/CreateExpenseRequest.md)     |             |
| [UpdateExpenseRequest](documentation/models/UpdateExpenseRequest.md)     |             |
| [ListClaimsParameters](documentation/models/ListClaimsParameters.md)     |             |
| [CreateClaimRequest](documentation/models/CreateClaimRequest.md)         |             |

</details>
