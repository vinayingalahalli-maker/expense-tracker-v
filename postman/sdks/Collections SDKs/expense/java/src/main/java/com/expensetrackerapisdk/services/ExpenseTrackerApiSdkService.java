package com.expensetrackerapisdk.services;

import com.expensetrackerapisdk.config.ExpenseTrackerApiSdkConfig;
import com.expensetrackerapisdk.config.RequestConfig;
import com.expensetrackerapisdk.exceptions.ApiError;
import com.expensetrackerapisdk.http.Environment;
import com.expensetrackerapisdk.http.ExpenseTrackerApiSdkResponse;
import com.expensetrackerapisdk.http.HttpMethod;
import com.expensetrackerapisdk.http.ModelConverter;
import com.expensetrackerapisdk.http.util.RequestBuilder;
import com.expensetrackerapisdk.models.CreateCategoryRequest;
import com.expensetrackerapisdk.models.CreateClaimRequest;
import com.expensetrackerapisdk.models.CreateExpenseRequest;
import com.expensetrackerapisdk.models.ListClaimsParameters;
import com.expensetrackerapisdk.models.ListExpensesParameters;
import com.expensetrackerapisdk.models.LoginAsApproverRequest;
import com.expensetrackerapisdk.models.LoginAsEmployeeRequest;
import com.expensetrackerapisdk.models.LoginAsFinanceRequest;
import com.expensetrackerapisdk.models.UpdateCategoryRequest;
import com.expensetrackerapisdk.models.UpdateExpenseRequest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * ExpenseTrackerApiSdkService Service
 */
public class ExpenseTrackerApiSdkService extends BaseService {

  private RequestConfig loginAsEmployeeConfig = RequestConfig.builder()
    .environment(Environment.LOCALHOST8000)
    .build();
  private RequestConfig loginAsApproverConfig = RequestConfig.builder()
    .environment(Environment.LOCALHOST8000)
    .build();
  private RequestConfig loginAsFinanceConfig = RequestConfig.builder()
    .environment(Environment.LOCALHOST8000)
    .build();
  private RequestConfig listCategoriesConfig = RequestConfig.builder()
    .environment(Environment.LOCALHOST8000)
    .build();
  private RequestConfig getCategoryConfig = RequestConfig.builder()
    .environment(Environment.LOCALHOST8000)
    .build();
  private RequestConfig createCategoryConfig = RequestConfig.builder()
    .environment(Environment.LOCALHOST8000)
    .build();
  private RequestConfig updateCategoryConfig = RequestConfig.builder()
    .environment(Environment.LOCALHOST8000)
    .build();
  private RequestConfig deleteCategoryConfig = RequestConfig.builder()
    .environment(Environment.LOCALHOST8000)
    .build();
  private RequestConfig listExpensesConfig = RequestConfig.builder()
    .environment(Environment.LOCALHOST8000)
    .build();
  private RequestConfig getExpenseConfig = RequestConfig.builder()
    .environment(Environment.LOCALHOST8000)
    .build();
  private RequestConfig createExpenseConfig = RequestConfig.builder()
    .environment(Environment.LOCALHOST8000)
    .build();
  private RequestConfig updateExpenseConfig = RequestConfig.builder()
    .environment(Environment.LOCALHOST8000)
    .build();
  private RequestConfig deleteExpenseConfig = RequestConfig.builder()
    .environment(Environment.LOCALHOST8000)
    .build();
  private RequestConfig listClaimsConfig = RequestConfig.builder()
    .environment(Environment.LOCALHOST8000)
    .build();
  private RequestConfig getClaimConfig = RequestConfig.builder()
    .environment(Environment.LOCALHOST8000)
    .build();
  private RequestConfig createClaimConfig = RequestConfig.builder()
    .environment(Environment.LOCALHOST8000)
    .build();
  private RequestConfig submitClaimConfig = RequestConfig.builder()
    .environment(Environment.LOCALHOST8000)
    .build();
  private RequestConfig approveClaimConfig = RequestConfig.builder()
    .environment(Environment.LOCALHOST8000)
    .build();

  /**
   * Constructs a new instance of ExpenseTrackerApiSdkService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public ExpenseTrackerApiSdkService(
    @NonNull OkHttpClient httpClient,
    ExpenseTrackerApiSdkConfig config
  ) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code loginAsEmployee}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ExpenseTrackerApiSdkService setLoginAsEmployeeConfig(RequestConfig config) {
    this.loginAsEmployeeConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code loginAsApprover}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ExpenseTrackerApiSdkService setLoginAsApproverConfig(RequestConfig config) {
    this.loginAsApproverConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code loginAsFinance}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ExpenseTrackerApiSdkService setLoginAsFinanceConfig(RequestConfig config) {
    this.loginAsFinanceConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code listCategories}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ExpenseTrackerApiSdkService setListCategoriesConfig(RequestConfig config) {
    this.listCategoriesConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code getCategory}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ExpenseTrackerApiSdkService setGetCategoryConfig(RequestConfig config) {
    this.getCategoryConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code createCategory}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ExpenseTrackerApiSdkService setCreateCategoryConfig(RequestConfig config) {
    this.createCategoryConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code updateCategory}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ExpenseTrackerApiSdkService setUpdateCategoryConfig(RequestConfig config) {
    this.updateCategoryConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code deleteCategory}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ExpenseTrackerApiSdkService setDeleteCategoryConfig(RequestConfig config) {
    this.deleteCategoryConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code listExpenses}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ExpenseTrackerApiSdkService setListExpensesConfig(RequestConfig config) {
    this.listExpensesConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code getExpense}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ExpenseTrackerApiSdkService setGetExpenseConfig(RequestConfig config) {
    this.getExpenseConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code createExpense}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ExpenseTrackerApiSdkService setCreateExpenseConfig(RequestConfig config) {
    this.createExpenseConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code updateExpense}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ExpenseTrackerApiSdkService setUpdateExpenseConfig(RequestConfig config) {
    this.updateExpenseConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code deleteExpense}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ExpenseTrackerApiSdkService setDeleteExpenseConfig(RequestConfig config) {
    this.deleteExpenseConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code listClaims}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ExpenseTrackerApiSdkService setListClaimsConfig(RequestConfig config) {
    this.listClaimsConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code getClaim}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ExpenseTrackerApiSdkService setGetClaimConfig(RequestConfig config) {
    this.getClaimConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code createClaim}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ExpenseTrackerApiSdkService setCreateClaimConfig(RequestConfig config) {
    this.createClaimConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code submitClaim}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ExpenseTrackerApiSdkService setSubmitClaimConfig(RequestConfig config) {
    this.submitClaimConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code approveClaim}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public ExpenseTrackerApiSdkService setApproveClaimConfig(RequestConfig config) {
    this.approveClaimConfig = config;
    return this;
  }

  /**
   * Method loginAsEmployee
   * POST /auth/login
   *
   * @param loginAsEmployeeRequest {@link LoginAsEmployeeRequest} Request Body
   * @return response of {@code Object}
   */
  public Object loginAsEmployee(@NonNull LoginAsEmployeeRequest loginAsEmployeeRequest)
    throws ApiError {
    return this.loginAsEmployee(loginAsEmployeeRequest, null);
  }

  /**
   * Method loginAsEmployee
   * POST /auth/login
   *
   * @param loginAsEmployeeRequest {@link LoginAsEmployeeRequest} Request Body
   * @return response of {@code Object}
   */
  public Object loginAsEmployee(
    @NonNull LoginAsEmployeeRequest loginAsEmployeeRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse().loginAsEmployee(loginAsEmployeeRequest, requestConfig).getData();
  }

  /**
   * Method loginAsEmployee
   * POST /auth/login
   *
   * @param loginAsEmployeeRequest {@link LoginAsEmployeeRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> loginAsEmployeeAsync(
    @NonNull LoginAsEmployeeRequest loginAsEmployeeRequest
  ) throws ApiError {
    return this.loginAsEmployeeAsync(loginAsEmployeeRequest, null);
  }

  /**
   * Method loginAsEmployee
   * POST /auth/login
   *
   * @param loginAsEmployeeRequest {@link LoginAsEmployeeRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> loginAsEmployeeAsync(
    @NonNull LoginAsEmployeeRequest loginAsEmployeeRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .loginAsEmployeeAsync(loginAsEmployeeRequest, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildLoginAsEmployeeRequest(
    @NonNull LoginAsEmployeeRequest loginAsEmployeeRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.LOCALHOST8000),
      "auth/login"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setJsonContent(loginAsEmployeeRequest)
      .build();
  }

  /**
   * Method loginAsApprover
   * POST /auth/login
   *
   * @param loginAsApproverRequest {@link LoginAsApproverRequest} Request Body
   * @return response of {@code Object}
   */
  public Object loginAsApprover(@NonNull LoginAsApproverRequest loginAsApproverRequest)
    throws ApiError {
    return this.loginAsApprover(loginAsApproverRequest, null);
  }

  /**
   * Method loginAsApprover
   * POST /auth/login
   *
   * @param loginAsApproverRequest {@link LoginAsApproverRequest} Request Body
   * @return response of {@code Object}
   */
  public Object loginAsApprover(
    @NonNull LoginAsApproverRequest loginAsApproverRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse().loginAsApprover(loginAsApproverRequest, requestConfig).getData();
  }

  /**
   * Method loginAsApprover
   * POST /auth/login
   *
   * @param loginAsApproverRequest {@link LoginAsApproverRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> loginAsApproverAsync(
    @NonNull LoginAsApproverRequest loginAsApproverRequest
  ) throws ApiError {
    return this.loginAsApproverAsync(loginAsApproverRequest, null);
  }

  /**
   * Method loginAsApprover
   * POST /auth/login
   *
   * @param loginAsApproverRequest {@link LoginAsApproverRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> loginAsApproverAsync(
    @NonNull LoginAsApproverRequest loginAsApproverRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .loginAsApproverAsync(loginAsApproverRequest, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildLoginAsApproverRequest(
    @NonNull LoginAsApproverRequest loginAsApproverRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.LOCALHOST8000),
      "auth/login"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setJsonContent(loginAsApproverRequest)
      .build();
  }

  /**
   * Method loginAsFinance
   * POST /auth/login
   *
   * @param loginAsFinanceRequest {@link LoginAsFinanceRequest} Request Body
   * @return response of {@code Object}
   */
  public Object loginAsFinance(@NonNull LoginAsFinanceRequest loginAsFinanceRequest)
    throws ApiError {
    return this.loginAsFinance(loginAsFinanceRequest, null);
  }

  /**
   * Method loginAsFinance
   * POST /auth/login
   *
   * @param loginAsFinanceRequest {@link LoginAsFinanceRequest} Request Body
   * @return response of {@code Object}
   */
  public Object loginAsFinance(
    @NonNull LoginAsFinanceRequest loginAsFinanceRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse().loginAsFinance(loginAsFinanceRequest, requestConfig).getData();
  }

  /**
   * Method loginAsFinance
   * POST /auth/login
   *
   * @param loginAsFinanceRequest {@link LoginAsFinanceRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> loginAsFinanceAsync(
    @NonNull LoginAsFinanceRequest loginAsFinanceRequest
  ) throws ApiError {
    return this.loginAsFinanceAsync(loginAsFinanceRequest, null);
  }

  /**
   * Method loginAsFinance
   * POST /auth/login
   *
   * @param loginAsFinanceRequest {@link LoginAsFinanceRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> loginAsFinanceAsync(
    @NonNull LoginAsFinanceRequest loginAsFinanceRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .loginAsFinanceAsync(loginAsFinanceRequest, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildLoginAsFinanceRequest(
    @NonNull LoginAsFinanceRequest loginAsFinanceRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.LOCALHOST8000),
      "auth/login"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setJsonContent(loginAsFinanceRequest)
      .build();
  }

  /**
   * Method listCategories
   * GET /categories
   *
   * @return response of {@code Object}
   */
  public Object listCategories() throws ApiError {
    return this.listCategories(null);
  }

  /**
   * Method listCategories
   * GET /categories
   *
   * @return response of {@code Object}
   */
  public Object listCategories(RequestConfig requestConfig) throws ApiError {
    return withRawResponse().listCategories(requestConfig).getData();
  }

  /**
   * Method listCategories
   * GET /categories
   *
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> listCategoriesAsync() throws ApiError {
    return this.listCategoriesAsync(null);
  }

  /**
   * Method listCategories
   * GET /categories
   *
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> listCategoriesAsync(RequestConfig requestConfig)
    throws ApiError {
    return withRawResponse()
      .listCategoriesAsync(requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildListCategoriesRequest(RequestConfig resolvedConfig) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.LOCALHOST8000),
      "categories"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .build();
  }

  /**
   * Method getCategory
   * GET /categories/{categoryId}
   *
   * @param categoryId String
   * @return response of {@code Object}
   */
  public Object getCategory(@NonNull String categoryId) throws ApiError {
    return this.getCategory(categoryId, null);
  }

  /**
   * Method getCategory
   * GET /categories/{categoryId}
   *
   * @param categoryId String
   * @return response of {@code Object}
   */
  public Object getCategory(@NonNull String categoryId, RequestConfig requestConfig)
    throws ApiError {
    return withRawResponse().getCategory(categoryId, requestConfig).getData();
  }

  /**
   * Method getCategory
   * GET /categories/{categoryId}
   *
   * @param categoryId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getCategoryAsync(@NonNull String categoryId) throws ApiError {
    return this.getCategoryAsync(categoryId, null);
  }

  /**
   * Method getCategory
   * GET /categories/{categoryId}
   *
   * @param categoryId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getCategoryAsync(
    @NonNull String categoryId,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .getCategoryAsync(categoryId, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildGetCategoryRequest(
    @NonNull String categoryId,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.LOCALHOST8000),
      "categories/{categoryId}"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("categoryId", categoryId)
      .build();
  }

  /**
   * Method createCategory
   * POST /categories
   *
   * @param createCategoryRequest {@link CreateCategoryRequest} Request Body
   * @return response of {@code Object}
   */
  public Object createCategory(@NonNull CreateCategoryRequest createCategoryRequest)
    throws ApiError {
    return this.createCategory(createCategoryRequest, null);
  }

  /**
   * Method createCategory
   * POST /categories
   *
   * @param createCategoryRequest {@link CreateCategoryRequest} Request Body
   * @return response of {@code Object}
   */
  public Object createCategory(
    @NonNull CreateCategoryRequest createCategoryRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse().createCategory(createCategoryRequest, requestConfig).getData();
  }

  /**
   * Method createCategory
   * POST /categories
   *
   * @param createCategoryRequest {@link CreateCategoryRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> createCategoryAsync(
    @NonNull CreateCategoryRequest createCategoryRequest
  ) throws ApiError {
    return this.createCategoryAsync(createCategoryRequest, null);
  }

  /**
   * Method createCategory
   * POST /categories
   *
   * @param createCategoryRequest {@link CreateCategoryRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> createCategoryAsync(
    @NonNull CreateCategoryRequest createCategoryRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .createCategoryAsync(createCategoryRequest, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildCreateCategoryRequest(
    @NonNull CreateCategoryRequest createCategoryRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.LOCALHOST8000),
      "categories"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setJsonContent(createCategoryRequest)
      .build();
  }

  /**
   * Method updateCategory
   * PUT /categories/{categoryId}
   *
   * @param categoryId String
   * @param updateCategoryRequest {@link UpdateCategoryRequest} Request Body
   * @return response of {@code Object}
   */
  public Object updateCategory(
    @NonNull String categoryId,
    @NonNull UpdateCategoryRequest updateCategoryRequest
  ) throws ApiError {
    return this.updateCategory(categoryId, updateCategoryRequest, null);
  }

  /**
   * Method updateCategory
   * PUT /categories/{categoryId}
   *
   * @param categoryId String
   * @param updateCategoryRequest {@link UpdateCategoryRequest} Request Body
   * @return response of {@code Object}
   */
  public Object updateCategory(
    @NonNull String categoryId,
    @NonNull UpdateCategoryRequest updateCategoryRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .updateCategory(categoryId, updateCategoryRequest, requestConfig)
      .getData();
  }

  /**
   * Method updateCategory
   * PUT /categories/{categoryId}
   *
   * @param categoryId String
   * @param updateCategoryRequest {@link UpdateCategoryRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> updateCategoryAsync(
    @NonNull String categoryId,
    @NonNull UpdateCategoryRequest updateCategoryRequest
  ) throws ApiError {
    return this.updateCategoryAsync(categoryId, updateCategoryRequest, null);
  }

  /**
   * Method updateCategory
   * PUT /categories/{categoryId}
   *
   * @param categoryId String
   * @param updateCategoryRequest {@link UpdateCategoryRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> updateCategoryAsync(
    @NonNull String categoryId,
    @NonNull UpdateCategoryRequest updateCategoryRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .updateCategoryAsync(categoryId, updateCategoryRequest, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildUpdateCategoryRequest(
    @NonNull String categoryId,
    @NonNull UpdateCategoryRequest updateCategoryRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.PUT,
      resolveBaseUrl(resolvedConfig, Environment.LOCALHOST8000),
      "categories/{categoryId}"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("categoryId", categoryId)
      .setJsonContent(updateCategoryRequest)
      .build();
  }

  /**
   * Method deleteCategory
   * DELETE /categories/{categoryId}
   *
   * @param categoryId String
   * @return response of {@code Object}
   */
  public Object deleteCategory(@NonNull String categoryId) throws ApiError {
    return this.deleteCategory(categoryId, null);
  }

  /**
   * Method deleteCategory
   * DELETE /categories/{categoryId}
   *
   * @param categoryId String
   * @return response of {@code Object}
   */
  public Object deleteCategory(@NonNull String categoryId, RequestConfig requestConfig)
    throws ApiError {
    return withRawResponse().deleteCategory(categoryId, requestConfig).getData();
  }

  /**
   * Method deleteCategory
   * DELETE /categories/{categoryId}
   *
   * @param categoryId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> deleteCategoryAsync(@NonNull String categoryId) throws ApiError {
    return this.deleteCategoryAsync(categoryId, null);
  }

  /**
   * Method deleteCategory
   * DELETE /categories/{categoryId}
   *
   * @param categoryId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> deleteCategoryAsync(
    @NonNull String categoryId,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .deleteCategoryAsync(categoryId, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildDeleteCategoryRequest(
    @NonNull String categoryId,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.DELETE,
      resolveBaseUrl(resolvedConfig, Environment.LOCALHOST8000),
      "categories/{categoryId}"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("categoryId", categoryId)
      .build();
  }

  /**
   * Method listExpenses
   * GET /expenses
   *
   * @return response of {@code Object}
   */
  public Object listExpenses() throws ApiError {
    return this.listExpenses(ListExpensesParameters.builder().build());
  }

  /**
   * Method listExpenses
   * GET /expenses
   *
   * @param requestParameters {@link ListExpensesParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object listExpenses(@NonNull ListExpensesParameters requestParameters) throws ApiError {
    return this.listExpenses(requestParameters, null);
  }

  /**
   * Method listExpenses
   * GET /expenses
   *
   * @param requestParameters {@link ListExpensesParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object listExpenses(
    @NonNull ListExpensesParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse().listExpenses(requestParameters, requestConfig).getData();
  }

  /**
   * Method listExpenses
   * GET /expenses
   *
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> listExpensesAsync() throws ApiError {
    return this.listExpensesAsync(ListExpensesParameters.builder().build());
  }

  /**
   * Method listExpenses
   * GET /expenses
   *
   * @param requestParameters {@link ListExpensesParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> listExpensesAsync(
    @NonNull ListExpensesParameters requestParameters
  ) throws ApiError {
    return this.listExpensesAsync(requestParameters, null);
  }

  /**
   * Method listExpenses
   * GET /expenses
   *
   * @param requestParameters {@link ListExpensesParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> listExpensesAsync(
    @NonNull ListExpensesParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .listExpensesAsync(requestParameters, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildListExpensesRequest(
    @NonNull ListExpensesParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.LOCALHOST8000),
      "expenses"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setOptionalQueryParameter("status", requestParameters.getStatus())
      .setOptionalQueryParameter("category_id", requestParameters.getCategoryId())
      .setOptionalQueryParameter("from_date", requestParameters.getFromDate())
      .setOptionalQueryParameter("to_date", requestParameters.getToDate())
      .build();
  }

  /**
   * Method getExpense
   * GET /expenses/{expenseId}
   *
   * @param expenseId String
   * @return response of {@code Object}
   */
  public Object getExpense(@NonNull String expenseId) throws ApiError {
    return this.getExpense(expenseId, null);
  }

  /**
   * Method getExpense
   * GET /expenses/{expenseId}
   *
   * @param expenseId String
   * @return response of {@code Object}
   */
  public Object getExpense(@NonNull String expenseId, RequestConfig requestConfig) throws ApiError {
    return withRawResponse().getExpense(expenseId, requestConfig).getData();
  }

  /**
   * Method getExpense
   * GET /expenses/{expenseId}
   *
   * @param expenseId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getExpenseAsync(@NonNull String expenseId) throws ApiError {
    return this.getExpenseAsync(expenseId, null);
  }

  /**
   * Method getExpense
   * GET /expenses/{expenseId}
   *
   * @param expenseId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getExpenseAsync(
    @NonNull String expenseId,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .getExpenseAsync(expenseId, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildGetExpenseRequest(@NonNull String expenseId, RequestConfig resolvedConfig) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.LOCALHOST8000),
      "expenses/{expenseId}"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("expenseId", expenseId)
      .build();
  }

  /**
   * Method createExpense
   * POST /expenses
   *
   * @param createExpenseRequest {@link CreateExpenseRequest} Request Body
   * @return response of {@code Object}
   */
  public Object createExpense(@NonNull CreateExpenseRequest createExpenseRequest) throws ApiError {
    return this.createExpense(createExpenseRequest, null);
  }

  /**
   * Method createExpense
   * POST /expenses
   *
   * @param createExpenseRequest {@link CreateExpenseRequest} Request Body
   * @return response of {@code Object}
   */
  public Object createExpense(
    @NonNull CreateExpenseRequest createExpenseRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse().createExpense(createExpenseRequest, requestConfig).getData();
  }

  /**
   * Method createExpense
   * POST /expenses
   *
   * @param createExpenseRequest {@link CreateExpenseRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> createExpenseAsync(
    @NonNull CreateExpenseRequest createExpenseRequest
  ) throws ApiError {
    return this.createExpenseAsync(createExpenseRequest, null);
  }

  /**
   * Method createExpense
   * POST /expenses
   *
   * @param createExpenseRequest {@link CreateExpenseRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> createExpenseAsync(
    @NonNull CreateExpenseRequest createExpenseRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .createExpenseAsync(createExpenseRequest, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildCreateExpenseRequest(
    @NonNull CreateExpenseRequest createExpenseRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.LOCALHOST8000),
      "expenses"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setJsonContent(createExpenseRequest)
      .build();
  }

  /**
   * Method updateExpense
   * PUT /expenses/{expenseId}
   *
   * @param expenseId String
   * @param updateExpenseRequest {@link UpdateExpenseRequest} Request Body
   * @return response of {@code Object}
   */
  public Object updateExpense(
    @NonNull String expenseId,
    @NonNull UpdateExpenseRequest updateExpenseRequest
  ) throws ApiError {
    return this.updateExpense(expenseId, updateExpenseRequest, null);
  }

  /**
   * Method updateExpense
   * PUT /expenses/{expenseId}
   *
   * @param expenseId String
   * @param updateExpenseRequest {@link UpdateExpenseRequest} Request Body
   * @return response of {@code Object}
   */
  public Object updateExpense(
    @NonNull String expenseId,
    @NonNull UpdateExpenseRequest updateExpenseRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .updateExpense(expenseId, updateExpenseRequest, requestConfig)
      .getData();
  }

  /**
   * Method updateExpense
   * PUT /expenses/{expenseId}
   *
   * @param expenseId String
   * @param updateExpenseRequest {@link UpdateExpenseRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> updateExpenseAsync(
    @NonNull String expenseId,
    @NonNull UpdateExpenseRequest updateExpenseRequest
  ) throws ApiError {
    return this.updateExpenseAsync(expenseId, updateExpenseRequest, null);
  }

  /**
   * Method updateExpense
   * PUT /expenses/{expenseId}
   *
   * @param expenseId String
   * @param updateExpenseRequest {@link UpdateExpenseRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> updateExpenseAsync(
    @NonNull String expenseId,
    @NonNull UpdateExpenseRequest updateExpenseRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .updateExpenseAsync(expenseId, updateExpenseRequest, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildUpdateExpenseRequest(
    @NonNull String expenseId,
    @NonNull UpdateExpenseRequest updateExpenseRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.PUT,
      resolveBaseUrl(resolvedConfig, Environment.LOCALHOST8000),
      "expenses/{expenseId}"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("expenseId", expenseId)
      .setJsonContent(updateExpenseRequest)
      .build();
  }

  /**
   * Method deleteExpense
   * DELETE /expenses/{expenseId}
   *
   * @param expenseId String
   * @return response of {@code Object}
   */
  public Object deleteExpense(@NonNull String expenseId) throws ApiError {
    return this.deleteExpense(expenseId, null);
  }

  /**
   * Method deleteExpense
   * DELETE /expenses/{expenseId}
   *
   * @param expenseId String
   * @return response of {@code Object}
   */
  public Object deleteExpense(@NonNull String expenseId, RequestConfig requestConfig)
    throws ApiError {
    return withRawResponse().deleteExpense(expenseId, requestConfig).getData();
  }

  /**
   * Method deleteExpense
   * DELETE /expenses/{expenseId}
   *
   * @param expenseId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> deleteExpenseAsync(@NonNull String expenseId) throws ApiError {
    return this.deleteExpenseAsync(expenseId, null);
  }

  /**
   * Method deleteExpense
   * DELETE /expenses/{expenseId}
   *
   * @param expenseId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> deleteExpenseAsync(
    @NonNull String expenseId,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .deleteExpenseAsync(expenseId, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildDeleteExpenseRequest(
    @NonNull String expenseId,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.DELETE,
      resolveBaseUrl(resolvedConfig, Environment.LOCALHOST8000),
      "expenses/{expenseId}"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("expenseId", expenseId)
      .build();
  }

  /**
   * Method listClaims
   * GET /claims
   *
   * @return response of {@code Object}
   */
  public Object listClaims() throws ApiError {
    return this.listClaims(ListClaimsParameters.builder().build());
  }

  /**
   * Method listClaims
   * GET /claims
   *
   * @param requestParameters {@link ListClaimsParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object listClaims(@NonNull ListClaimsParameters requestParameters) throws ApiError {
    return this.listClaims(requestParameters, null);
  }

  /**
   * Method listClaims
   * GET /claims
   *
   * @param requestParameters {@link ListClaimsParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object listClaims(
    @NonNull ListClaimsParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse().listClaims(requestParameters, requestConfig).getData();
  }

  /**
   * Method listClaims
   * GET /claims
   *
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> listClaimsAsync() throws ApiError {
    return this.listClaimsAsync(ListClaimsParameters.builder().build());
  }

  /**
   * Method listClaims
   * GET /claims
   *
   * @param requestParameters {@link ListClaimsParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> listClaimsAsync(@NonNull ListClaimsParameters requestParameters)
    throws ApiError {
    return this.listClaimsAsync(requestParameters, null);
  }

  /**
   * Method listClaims
   * GET /claims
   *
   * @param requestParameters {@link ListClaimsParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> listClaimsAsync(
    @NonNull ListClaimsParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .listClaimsAsync(requestParameters, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildListClaimsRequest(
    @NonNull ListClaimsParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.LOCALHOST8000),
      "claims"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setOptionalQueryParameter("status", requestParameters.getStatus())
      .setOptionalQueryParameter("employee_id", requestParameters.getEmployeeId())
      .build();
  }

  /**
   * Method getClaim
   * GET /claims/{claimId}
   *
   * @param claimId String
   * @return response of {@code Object}
   */
  public Object getClaim(@NonNull String claimId) throws ApiError {
    return this.getClaim(claimId, null);
  }

  /**
   * Method getClaim
   * GET /claims/{claimId}
   *
   * @param claimId String
   * @return response of {@code Object}
   */
  public Object getClaim(@NonNull String claimId, RequestConfig requestConfig) throws ApiError {
    return withRawResponse().getClaim(claimId, requestConfig).getData();
  }

  /**
   * Method getClaim
   * GET /claims/{claimId}
   *
   * @param claimId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getClaimAsync(@NonNull String claimId) throws ApiError {
    return this.getClaimAsync(claimId, null);
  }

  /**
   * Method getClaim
   * GET /claims/{claimId}
   *
   * @param claimId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getClaimAsync(
    @NonNull String claimId,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .getClaimAsync(claimId, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildGetClaimRequest(@NonNull String claimId, RequestConfig resolvedConfig) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.LOCALHOST8000),
      "claims/{claimId}"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("claimId", claimId)
      .build();
  }

  /**
   * Method createClaim
   * POST /claims
   *
   * @param createClaimRequest {@link CreateClaimRequest} Request Body
   * @return response of {@code Object}
   */
  public Object createClaim(@NonNull CreateClaimRequest createClaimRequest) throws ApiError {
    return this.createClaim(createClaimRequest, null);
  }

  /**
   * Method createClaim
   * POST /claims
   *
   * @param createClaimRequest {@link CreateClaimRequest} Request Body
   * @return response of {@code Object}
   */
  public Object createClaim(
    @NonNull CreateClaimRequest createClaimRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse().createClaim(createClaimRequest, requestConfig).getData();
  }

  /**
   * Method createClaim
   * POST /claims
   *
   * @param createClaimRequest {@link CreateClaimRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> createClaimAsync(@NonNull CreateClaimRequest createClaimRequest)
    throws ApiError {
    return this.createClaimAsync(createClaimRequest, null);
  }

  /**
   * Method createClaim
   * POST /claims
   *
   * @param createClaimRequest {@link CreateClaimRequest} Request Body
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> createClaimAsync(
    @NonNull CreateClaimRequest createClaimRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .createClaimAsync(createClaimRequest, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildCreateClaimRequest(
    @NonNull CreateClaimRequest createClaimRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.LOCALHOST8000),
      "claims"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setJsonContent(createClaimRequest)
      .build();
  }

  /**
   * Method submitClaim
   * POST /claims/{claimId}/submit
   *
   * @param claimId String
   * @return response of {@code Object}
   */
  public Object submitClaim(@NonNull String claimId) throws ApiError {
    return this.submitClaim(claimId, null);
  }

  /**
   * Method submitClaim
   * POST /claims/{claimId}/submit
   *
   * @param claimId String
   * @return response of {@code Object}
   */
  public Object submitClaim(@NonNull String claimId, RequestConfig requestConfig) throws ApiError {
    return withRawResponse().submitClaim(claimId, requestConfig).getData();
  }

  /**
   * Method submitClaim
   * POST /claims/{claimId}/submit
   *
   * @param claimId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> submitClaimAsync(@NonNull String claimId) throws ApiError {
    return this.submitClaimAsync(claimId, null);
  }

  /**
   * Method submitClaim
   * POST /claims/{claimId}/submit
   *
   * @param claimId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> submitClaimAsync(
    @NonNull String claimId,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .submitClaimAsync(claimId, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildSubmitClaimRequest(@NonNull String claimId, RequestConfig resolvedConfig) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.LOCALHOST8000),
      "claims/{claimId}/submit"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("claimId", claimId)
      .build();
  }

  /**
   * Method approveClaim
   * POST /claims/{claimId}/approve
   *
   * @param claimId String
   * @return response of {@code Object}
   */
  public Object approveClaim(@NonNull String claimId) throws ApiError {
    return this.approveClaim(claimId, null);
  }

  /**
   * Method approveClaim
   * POST /claims/{claimId}/approve
   *
   * @param claimId String
   * @return response of {@code Object}
   */
  public Object approveClaim(@NonNull String claimId, RequestConfig requestConfig) throws ApiError {
    return withRawResponse().approveClaim(claimId, requestConfig).getData();
  }

  /**
   * Method approveClaim
   * POST /claims/{claimId}/approve
   *
   * @param claimId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> approveClaimAsync(@NonNull String claimId) throws ApiError {
    return this.approveClaimAsync(claimId, null);
  }

  /**
   * Method approveClaim
   * POST /claims/{claimId}/approve
   *
   * @param claimId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> approveClaimAsync(
    @NonNull String claimId,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .approveClaimAsync(claimId, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildApproveClaimRequest(@NonNull String claimId, RequestConfig resolvedConfig) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.LOCALHOST8000),
      "claims/{claimId}/approve"
    )
      .setAccessTokenAuth(resolveAccessToken(resolvedConfig), "Bearer")
      .setPathParameter("claimId", claimId)
      .build();
  }

  /**
   * Returns an accessor whose methods mirror this service but return the full HTTP response
   * (status code, headers, and raw body) wrapped alongside the parsed data.
   *
   * @return An accessor exposing raw-response variants of this service's methods
   */
  public WithRawResponse withRawResponse() {
    return new WithRawResponse();
  }

  /**
   * Per-call accessor exposing raw-response variants of {@link ExpenseTrackerApiSdkService}'s methods.
   * Reuses the enclosing service's request builders and configuration.
   */
  public class WithRawResponse {

    /**
     * Method loginAsEmployee
     * POST /auth/login
     *
     * @param loginAsEmployeeRequest {@link LoginAsEmployeeRequest} Request Body
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> loginAsEmployee(
      @NonNull LoginAsEmployeeRequest loginAsEmployeeRequest
    ) throws ApiError {
      return this.loginAsEmployee(loginAsEmployeeRequest, null);
    }

    /**
     * Method loginAsEmployee
     * POST /auth/login
     *
     * @param loginAsEmployeeRequest {@link LoginAsEmployeeRequest} Request Body
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> loginAsEmployee(
      @NonNull LoginAsEmployeeRequest loginAsEmployeeRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(loginAsEmployeeConfig, requestConfig);
      Request request = buildLoginAsEmployeeRequest(loginAsEmployeeRequest, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ExpenseTrackerApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method loginAsEmployee
     * POST /auth/login
     *
     * @param loginAsEmployeeRequest {@link LoginAsEmployeeRequest} Request Body
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> loginAsEmployeeAsync(
      @NonNull LoginAsEmployeeRequest loginAsEmployeeRequest
    ) throws ApiError {
      return this.loginAsEmployeeAsync(loginAsEmployeeRequest, null);
    }

    /**
     * Method loginAsEmployee
     * POST /auth/login
     *
     * @param loginAsEmployeeRequest {@link LoginAsEmployeeRequest} Request Body
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> loginAsEmployeeAsync(
      @NonNull LoginAsEmployeeRequest loginAsEmployeeRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(loginAsEmployeeConfig, requestConfig);
      Request request = buildLoginAsEmployeeRequest(loginAsEmployeeRequest, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ExpenseTrackerApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Method loginAsApprover
     * POST /auth/login
     *
     * @param loginAsApproverRequest {@link LoginAsApproverRequest} Request Body
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> loginAsApprover(
      @NonNull LoginAsApproverRequest loginAsApproverRequest
    ) throws ApiError {
      return this.loginAsApprover(loginAsApproverRequest, null);
    }

    /**
     * Method loginAsApprover
     * POST /auth/login
     *
     * @param loginAsApproverRequest {@link LoginAsApproverRequest} Request Body
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> loginAsApprover(
      @NonNull LoginAsApproverRequest loginAsApproverRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(loginAsApproverConfig, requestConfig);
      Request request = buildLoginAsApproverRequest(loginAsApproverRequest, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ExpenseTrackerApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method loginAsApprover
     * POST /auth/login
     *
     * @param loginAsApproverRequest {@link LoginAsApproverRequest} Request Body
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> loginAsApproverAsync(
      @NonNull LoginAsApproverRequest loginAsApproverRequest
    ) throws ApiError {
      return this.loginAsApproverAsync(loginAsApproverRequest, null);
    }

    /**
     * Method loginAsApprover
     * POST /auth/login
     *
     * @param loginAsApproverRequest {@link LoginAsApproverRequest} Request Body
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> loginAsApproverAsync(
      @NonNull LoginAsApproverRequest loginAsApproverRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(loginAsApproverConfig, requestConfig);
      Request request = buildLoginAsApproverRequest(loginAsApproverRequest, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ExpenseTrackerApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Method loginAsFinance
     * POST /auth/login
     *
     * @param loginAsFinanceRequest {@link LoginAsFinanceRequest} Request Body
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> loginAsFinance(
      @NonNull LoginAsFinanceRequest loginAsFinanceRequest
    ) throws ApiError {
      return this.loginAsFinance(loginAsFinanceRequest, null);
    }

    /**
     * Method loginAsFinance
     * POST /auth/login
     *
     * @param loginAsFinanceRequest {@link LoginAsFinanceRequest} Request Body
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> loginAsFinance(
      @NonNull LoginAsFinanceRequest loginAsFinanceRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(loginAsFinanceConfig, requestConfig);
      Request request = buildLoginAsFinanceRequest(loginAsFinanceRequest, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ExpenseTrackerApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method loginAsFinance
     * POST /auth/login
     *
     * @param loginAsFinanceRequest {@link LoginAsFinanceRequest} Request Body
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> loginAsFinanceAsync(
      @NonNull LoginAsFinanceRequest loginAsFinanceRequest
    ) throws ApiError {
      return this.loginAsFinanceAsync(loginAsFinanceRequest, null);
    }

    /**
     * Method loginAsFinance
     * POST /auth/login
     *
     * @param loginAsFinanceRequest {@link LoginAsFinanceRequest} Request Body
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> loginAsFinanceAsync(
      @NonNull LoginAsFinanceRequest loginAsFinanceRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(loginAsFinanceConfig, requestConfig);
      Request request = buildLoginAsFinanceRequest(loginAsFinanceRequest, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ExpenseTrackerApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Method listCategories
     * GET /categories
     *
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> listCategories() throws ApiError {
      return this.listCategories(null);
    }

    /**
     * Method listCategories
     * GET /categories
     *
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> listCategories(RequestConfig requestConfig)
      throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(listCategoriesConfig, requestConfig);
      Request request = buildListCategoriesRequest(resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ExpenseTrackerApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method listCategories
     * GET /categories
     *
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> listCategoriesAsync()
      throws ApiError {
      return this.listCategoriesAsync(null);
    }

    /**
     * Method listCategories
     * GET /categories
     *
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> listCategoriesAsync(
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(listCategoriesConfig, requestConfig);
      Request request = buildListCategoriesRequest(resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ExpenseTrackerApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Method getCategory
     * GET /categories/{categoryId}
     *
     * @param categoryId String
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> getCategory(@NonNull String categoryId)
      throws ApiError {
      return this.getCategory(categoryId, null);
    }

    /**
     * Method getCategory
     * GET /categories/{categoryId}
     *
     * @param categoryId String
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> getCategory(
      @NonNull String categoryId,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(getCategoryConfig, requestConfig);
      Request request = buildGetCategoryRequest(categoryId, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ExpenseTrackerApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method getCategory
     * GET /categories/{categoryId}
     *
     * @param categoryId String
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> getCategoryAsync(
      @NonNull String categoryId
    ) throws ApiError {
      return this.getCategoryAsync(categoryId, null);
    }

    /**
     * Method getCategory
     * GET /categories/{categoryId}
     *
     * @param categoryId String
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> getCategoryAsync(
      @NonNull String categoryId,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(getCategoryConfig, requestConfig);
      Request request = buildGetCategoryRequest(categoryId, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ExpenseTrackerApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Method createCategory
     * POST /categories
     *
     * @param createCategoryRequest {@link CreateCategoryRequest} Request Body
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> createCategory(
      @NonNull CreateCategoryRequest createCategoryRequest
    ) throws ApiError {
      return this.createCategory(createCategoryRequest, null);
    }

    /**
     * Method createCategory
     * POST /categories
     *
     * @param createCategoryRequest {@link CreateCategoryRequest} Request Body
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> createCategory(
      @NonNull CreateCategoryRequest createCategoryRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(createCategoryConfig, requestConfig);
      Request request = buildCreateCategoryRequest(createCategoryRequest, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ExpenseTrackerApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method createCategory
     * POST /categories
     *
     * @param createCategoryRequest {@link CreateCategoryRequest} Request Body
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> createCategoryAsync(
      @NonNull CreateCategoryRequest createCategoryRequest
    ) throws ApiError {
      return this.createCategoryAsync(createCategoryRequest, null);
    }

    /**
     * Method createCategory
     * POST /categories
     *
     * @param createCategoryRequest {@link CreateCategoryRequest} Request Body
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> createCategoryAsync(
      @NonNull CreateCategoryRequest createCategoryRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(createCategoryConfig, requestConfig);
      Request request = buildCreateCategoryRequest(createCategoryRequest, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ExpenseTrackerApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Method updateCategory
     * PUT /categories/{categoryId}
     *
     * @param categoryId String
     * @param updateCategoryRequest {@link UpdateCategoryRequest} Request Body
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> updateCategory(
      @NonNull String categoryId,
      @NonNull UpdateCategoryRequest updateCategoryRequest
    ) throws ApiError {
      return this.updateCategory(categoryId, updateCategoryRequest, null);
    }

    /**
     * Method updateCategory
     * PUT /categories/{categoryId}
     *
     * @param categoryId String
     * @param updateCategoryRequest {@link UpdateCategoryRequest} Request Body
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> updateCategory(
      @NonNull String categoryId,
      @NonNull UpdateCategoryRequest updateCategoryRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(updateCategoryConfig, requestConfig);
      Request request = buildUpdateCategoryRequest(
        categoryId,
        updateCategoryRequest,
        resolvedConfig
      );
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ExpenseTrackerApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method updateCategory
     * PUT /categories/{categoryId}
     *
     * @param categoryId String
     * @param updateCategoryRequest {@link UpdateCategoryRequest} Request Body
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> updateCategoryAsync(
      @NonNull String categoryId,
      @NonNull UpdateCategoryRequest updateCategoryRequest
    ) throws ApiError {
      return this.updateCategoryAsync(categoryId, updateCategoryRequest, null);
    }

    /**
     * Method updateCategory
     * PUT /categories/{categoryId}
     *
     * @param categoryId String
     * @param updateCategoryRequest {@link UpdateCategoryRequest} Request Body
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> updateCategoryAsync(
      @NonNull String categoryId,
      @NonNull UpdateCategoryRequest updateCategoryRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(updateCategoryConfig, requestConfig);
      Request request = buildUpdateCategoryRequest(
        categoryId,
        updateCategoryRequest,
        resolvedConfig
      );
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ExpenseTrackerApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Method deleteCategory
     * DELETE /categories/{categoryId}
     *
     * @param categoryId String
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> deleteCategory(@NonNull String categoryId)
      throws ApiError {
      return this.deleteCategory(categoryId, null);
    }

    /**
     * Method deleteCategory
     * DELETE /categories/{categoryId}
     *
     * @param categoryId String
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> deleteCategory(
      @NonNull String categoryId,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(deleteCategoryConfig, requestConfig);
      Request request = buildDeleteCategoryRequest(categoryId, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ExpenseTrackerApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method deleteCategory
     * DELETE /categories/{categoryId}
     *
     * @param categoryId String
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> deleteCategoryAsync(
      @NonNull String categoryId
    ) throws ApiError {
      return this.deleteCategoryAsync(categoryId, null);
    }

    /**
     * Method deleteCategory
     * DELETE /categories/{categoryId}
     *
     * @param categoryId String
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> deleteCategoryAsync(
      @NonNull String categoryId,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(deleteCategoryConfig, requestConfig);
      Request request = buildDeleteCategoryRequest(categoryId, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ExpenseTrackerApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Method listExpenses
     * GET /expenses
     *
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> listExpenses() throws ApiError {
      return this.listExpenses(ListExpensesParameters.builder().build());
    }

    /**
     * Method listExpenses
     * GET /expenses
     *
     * @param requestParameters {@link ListExpensesParameters} Request Parameters Object
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> listExpenses(
      @NonNull ListExpensesParameters requestParameters
    ) throws ApiError {
      return this.listExpenses(requestParameters, null);
    }

    /**
     * Method listExpenses
     * GET /expenses
     *
     * @param requestParameters {@link ListExpensesParameters} Request Parameters Object
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> listExpenses(
      @NonNull ListExpensesParameters requestParameters,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(listExpensesConfig, requestConfig);
      Request request = buildListExpensesRequest(requestParameters, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ExpenseTrackerApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method listExpenses
     * GET /expenses
     *
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> listExpensesAsync()
      throws ApiError {
      return this.listExpensesAsync(ListExpensesParameters.builder().build());
    }

    /**
     * Method listExpenses
     * GET /expenses
     *
     * @param requestParameters {@link ListExpensesParameters} Request Parameters Object
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> listExpensesAsync(
      @NonNull ListExpensesParameters requestParameters
    ) throws ApiError {
      return this.listExpensesAsync(requestParameters, null);
    }

    /**
     * Method listExpenses
     * GET /expenses
     *
     * @param requestParameters {@link ListExpensesParameters} Request Parameters Object
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> listExpensesAsync(
      @NonNull ListExpensesParameters requestParameters,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(listExpensesConfig, requestConfig);
      Request request = buildListExpensesRequest(requestParameters, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ExpenseTrackerApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Method getExpense
     * GET /expenses/{expenseId}
     *
     * @param expenseId String
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> getExpense(@NonNull String expenseId)
      throws ApiError {
      return this.getExpense(expenseId, null);
    }

    /**
     * Method getExpense
     * GET /expenses/{expenseId}
     *
     * @param expenseId String
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> getExpense(
      @NonNull String expenseId,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(getExpenseConfig, requestConfig);
      Request request = buildGetExpenseRequest(expenseId, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ExpenseTrackerApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method getExpense
     * GET /expenses/{expenseId}
     *
     * @param expenseId String
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> getExpenseAsync(
      @NonNull String expenseId
    ) throws ApiError {
      return this.getExpenseAsync(expenseId, null);
    }

    /**
     * Method getExpense
     * GET /expenses/{expenseId}
     *
     * @param expenseId String
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> getExpenseAsync(
      @NonNull String expenseId,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(getExpenseConfig, requestConfig);
      Request request = buildGetExpenseRequest(expenseId, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ExpenseTrackerApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Method createExpense
     * POST /expenses
     *
     * @param createExpenseRequest {@link CreateExpenseRequest} Request Body
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> createExpense(
      @NonNull CreateExpenseRequest createExpenseRequest
    ) throws ApiError {
      return this.createExpense(createExpenseRequest, null);
    }

    /**
     * Method createExpense
     * POST /expenses
     *
     * @param createExpenseRequest {@link CreateExpenseRequest} Request Body
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> createExpense(
      @NonNull CreateExpenseRequest createExpenseRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(createExpenseConfig, requestConfig);
      Request request = buildCreateExpenseRequest(createExpenseRequest, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ExpenseTrackerApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method createExpense
     * POST /expenses
     *
     * @param createExpenseRequest {@link CreateExpenseRequest} Request Body
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> createExpenseAsync(
      @NonNull CreateExpenseRequest createExpenseRequest
    ) throws ApiError {
      return this.createExpenseAsync(createExpenseRequest, null);
    }

    /**
     * Method createExpense
     * POST /expenses
     *
     * @param createExpenseRequest {@link CreateExpenseRequest} Request Body
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> createExpenseAsync(
      @NonNull CreateExpenseRequest createExpenseRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(createExpenseConfig, requestConfig);
      Request request = buildCreateExpenseRequest(createExpenseRequest, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ExpenseTrackerApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Method updateExpense
     * PUT /expenses/{expenseId}
     *
     * @param expenseId String
     * @param updateExpenseRequest {@link UpdateExpenseRequest} Request Body
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> updateExpense(
      @NonNull String expenseId,
      @NonNull UpdateExpenseRequest updateExpenseRequest
    ) throws ApiError {
      return this.updateExpense(expenseId, updateExpenseRequest, null);
    }

    /**
     * Method updateExpense
     * PUT /expenses/{expenseId}
     *
     * @param expenseId String
     * @param updateExpenseRequest {@link UpdateExpenseRequest} Request Body
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> updateExpense(
      @NonNull String expenseId,
      @NonNull UpdateExpenseRequest updateExpenseRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(updateExpenseConfig, requestConfig);
      Request request = buildUpdateExpenseRequest(expenseId, updateExpenseRequest, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ExpenseTrackerApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method updateExpense
     * PUT /expenses/{expenseId}
     *
     * @param expenseId String
     * @param updateExpenseRequest {@link UpdateExpenseRequest} Request Body
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> updateExpenseAsync(
      @NonNull String expenseId,
      @NonNull UpdateExpenseRequest updateExpenseRequest
    ) throws ApiError {
      return this.updateExpenseAsync(expenseId, updateExpenseRequest, null);
    }

    /**
     * Method updateExpense
     * PUT /expenses/{expenseId}
     *
     * @param expenseId String
     * @param updateExpenseRequest {@link UpdateExpenseRequest} Request Body
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> updateExpenseAsync(
      @NonNull String expenseId,
      @NonNull UpdateExpenseRequest updateExpenseRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(updateExpenseConfig, requestConfig);
      Request request = buildUpdateExpenseRequest(expenseId, updateExpenseRequest, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ExpenseTrackerApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Method deleteExpense
     * DELETE /expenses/{expenseId}
     *
     * @param expenseId String
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> deleteExpense(@NonNull String expenseId)
      throws ApiError {
      return this.deleteExpense(expenseId, null);
    }

    /**
     * Method deleteExpense
     * DELETE /expenses/{expenseId}
     *
     * @param expenseId String
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> deleteExpense(
      @NonNull String expenseId,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(deleteExpenseConfig, requestConfig);
      Request request = buildDeleteExpenseRequest(expenseId, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ExpenseTrackerApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method deleteExpense
     * DELETE /expenses/{expenseId}
     *
     * @param expenseId String
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> deleteExpenseAsync(
      @NonNull String expenseId
    ) throws ApiError {
      return this.deleteExpenseAsync(expenseId, null);
    }

    /**
     * Method deleteExpense
     * DELETE /expenses/{expenseId}
     *
     * @param expenseId String
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> deleteExpenseAsync(
      @NonNull String expenseId,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(deleteExpenseConfig, requestConfig);
      Request request = buildDeleteExpenseRequest(expenseId, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ExpenseTrackerApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Method listClaims
     * GET /claims
     *
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> listClaims() throws ApiError {
      return this.listClaims(ListClaimsParameters.builder().build());
    }

    /**
     * Method listClaims
     * GET /claims
     *
     * @param requestParameters {@link ListClaimsParameters} Request Parameters Object
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> listClaims(
      @NonNull ListClaimsParameters requestParameters
    ) throws ApiError {
      return this.listClaims(requestParameters, null);
    }

    /**
     * Method listClaims
     * GET /claims
     *
     * @param requestParameters {@link ListClaimsParameters} Request Parameters Object
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> listClaims(
      @NonNull ListClaimsParameters requestParameters,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(listClaimsConfig, requestConfig);
      Request request = buildListClaimsRequest(requestParameters, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ExpenseTrackerApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method listClaims
     * GET /claims
     *
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> listClaimsAsync()
      throws ApiError {
      return this.listClaimsAsync(ListClaimsParameters.builder().build());
    }

    /**
     * Method listClaims
     * GET /claims
     *
     * @param requestParameters {@link ListClaimsParameters} Request Parameters Object
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> listClaimsAsync(
      @NonNull ListClaimsParameters requestParameters
    ) throws ApiError {
      return this.listClaimsAsync(requestParameters, null);
    }

    /**
     * Method listClaims
     * GET /claims
     *
     * @param requestParameters {@link ListClaimsParameters} Request Parameters Object
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> listClaimsAsync(
      @NonNull ListClaimsParameters requestParameters,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(listClaimsConfig, requestConfig);
      Request request = buildListClaimsRequest(requestParameters, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ExpenseTrackerApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Method getClaim
     * GET /claims/{claimId}
     *
     * @param claimId String
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> getClaim(@NonNull String claimId) throws ApiError {
      return this.getClaim(claimId, null);
    }

    /**
     * Method getClaim
     * GET /claims/{claimId}
     *
     * @param claimId String
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> getClaim(
      @NonNull String claimId,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(getClaimConfig, requestConfig);
      Request request = buildGetClaimRequest(claimId, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ExpenseTrackerApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method getClaim
     * GET /claims/{claimId}
     *
     * @param claimId String
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> getClaimAsync(
      @NonNull String claimId
    ) throws ApiError {
      return this.getClaimAsync(claimId, null);
    }

    /**
     * Method getClaim
     * GET /claims/{claimId}
     *
     * @param claimId String
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> getClaimAsync(
      @NonNull String claimId,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(getClaimConfig, requestConfig);
      Request request = buildGetClaimRequest(claimId, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ExpenseTrackerApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Method createClaim
     * POST /claims
     *
     * @param createClaimRequest {@link CreateClaimRequest} Request Body
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> createClaim(
      @NonNull CreateClaimRequest createClaimRequest
    ) throws ApiError {
      return this.createClaim(createClaimRequest, null);
    }

    /**
     * Method createClaim
     * POST /claims
     *
     * @param createClaimRequest {@link CreateClaimRequest} Request Body
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> createClaim(
      @NonNull CreateClaimRequest createClaimRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(createClaimConfig, requestConfig);
      Request request = buildCreateClaimRequest(createClaimRequest, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ExpenseTrackerApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method createClaim
     * POST /claims
     *
     * @param createClaimRequest {@link CreateClaimRequest} Request Body
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> createClaimAsync(
      @NonNull CreateClaimRequest createClaimRequest
    ) throws ApiError {
      return this.createClaimAsync(createClaimRequest, null);
    }

    /**
     * Method createClaim
     * POST /claims
     *
     * @param createClaimRequest {@link CreateClaimRequest} Request Body
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> createClaimAsync(
      @NonNull CreateClaimRequest createClaimRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(createClaimConfig, requestConfig);
      Request request = buildCreateClaimRequest(createClaimRequest, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ExpenseTrackerApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Method submitClaim
     * POST /claims/{claimId}/submit
     *
     * @param claimId String
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> submitClaim(@NonNull String claimId)
      throws ApiError {
      return this.submitClaim(claimId, null);
    }

    /**
     * Method submitClaim
     * POST /claims/{claimId}/submit
     *
     * @param claimId String
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> submitClaim(
      @NonNull String claimId,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(submitClaimConfig, requestConfig);
      Request request = buildSubmitClaimRequest(claimId, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ExpenseTrackerApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method submitClaim
     * POST /claims/{claimId}/submit
     *
     * @param claimId String
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> submitClaimAsync(
      @NonNull String claimId
    ) throws ApiError {
      return this.submitClaimAsync(claimId, null);
    }

    /**
     * Method submitClaim
     * POST /claims/{claimId}/submit
     *
     * @param claimId String
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> submitClaimAsync(
      @NonNull String claimId,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(submitClaimConfig, requestConfig);
      Request request = buildSubmitClaimRequest(claimId, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ExpenseTrackerApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }

    /**
     * Method approveClaim
     * POST /claims/{claimId}/approve
     *
     * @param claimId String
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> approveClaim(@NonNull String claimId)
      throws ApiError {
      return this.approveClaim(claimId, null);
    }

    /**
     * Method approveClaim
     * POST /claims/{claimId}/approve
     *
     * @param claimId String
     * @return response of {@code ExpenseTrackerApiSdkResponse<Object>}
     */
    public ExpenseTrackerApiSdkResponse<Object> approveClaim(
      @NonNull String claimId,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(approveClaimConfig, requestConfig);
      Request request = buildApproveClaimRequest(claimId, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new ExpenseTrackerApiSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
      );
    }

    /**
     * Method approveClaim
     * POST /claims/{claimId}/approve
     *
     * @param claimId String
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> approveClaimAsync(
      @NonNull String claimId
    ) throws ApiError {
      return this.approveClaimAsync(claimId, null);
    }

    /**
     * Method approveClaim
     * POST /claims/{claimId}/approve
     *
     * @param claimId String
     * @return response of {@code CompletableFuture<ExpenseTrackerApiSdkResponse<Object>>}
     */
    public CompletableFuture<ExpenseTrackerApiSdkResponse<Object>> approveClaimAsync(
      @NonNull String claimId,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(approveClaimConfig, requestConfig);
      Request request = buildApproveClaimRequest(claimId, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new ExpenseTrackerApiSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<Object>() {})
        );
      });
    }
  }
}
