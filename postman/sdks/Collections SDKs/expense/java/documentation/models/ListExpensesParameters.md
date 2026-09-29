# ListExpensesParameters

**Properties**

| Name       | Type   | Required | Description                                                   |
| :--------- | :----- | :------- | :------------------------------------------------------------ |
| status     | String | ❌       | Filter by status: unclaimed \| claimed                        |
| categoryId | String | ❌       | Filter by category ID                                         |
| fromDate   | String | ❌       | Filter expenses on or after this date (ISO 8601: YYYY-MM-DD)  |
| toDate     | String | ❌       | Filter expenses on or before this date (ISO 8601: YYYY-MM-DD) |
