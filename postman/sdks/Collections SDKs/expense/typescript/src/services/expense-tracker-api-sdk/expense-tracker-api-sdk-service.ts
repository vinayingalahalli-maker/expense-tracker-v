import { z } from 'zod';
import { BaseService } from '../base-service';
import { ContentType, HttpResponse, SdkConfig } from '../../http/types';
import { RequestBuilder } from '../../http/transport/request-builder';
import { SerializationStyle } from '../../http/serialization/base-serializer';
import { ThrowableError } from '../../http/errors/throwable-error';
import { Environment } from '../../http/environment';
import {
  LoginAsEmployeeRequest,
  loginAsEmployeeRequestRequest,
} from './models/login-as-employee-request';
import {
  LoginAsApproverRequest,
  loginAsApproverRequestRequest,
} from './models/login-as-approver-request';
import {
  LoginAsFinanceRequest,
  loginAsFinanceRequestRequest,
} from './models/login-as-finance-request';
import {
  CreateCategoryRequest,
  createCategoryRequestRequest,
} from './models/create-category-request';
import {
  UpdateCategoryRequest,
  updateCategoryRequestRequest,
} from './models/update-category-request';
import { ListClaimsParams, ListExpensesParams } from './request-params';
import { CreateExpenseRequest, createExpenseRequestRequest } from './models/create-expense-request';
import { UpdateExpenseRequest, updateExpenseRequestRequest } from './models/update-expense-request';
import { CreateClaimRequest, createClaimRequestRequest } from './models/create-claim-request';

/**
 * Service class for ExpenseTrackerApiSdkService operations.
 * Provides methods to interact with ExpenseTrackerApiSdkService-related API endpoints.
 * All methods return promises and handle request/response serialization automatically.
 */
export class ExpenseTrackerApiSdkService extends BaseService {
  protected loginAsEmployeeConfig: Partial<SdkConfig> = { environment: Environment.LOCALHOST8000 };

  protected loginAsApproverConfig: Partial<SdkConfig> = { environment: Environment.LOCALHOST8000 };

  protected loginAsFinanceConfig: Partial<SdkConfig> = { environment: Environment.LOCALHOST8000 };

  protected listCategoriesConfig: Partial<SdkConfig> = { environment: Environment.LOCALHOST8000 };

  protected getCategoryConfig: Partial<SdkConfig> = { environment: Environment.LOCALHOST8000 };

  protected createCategoryConfig: Partial<SdkConfig> = { environment: Environment.LOCALHOST8000 };

  protected updateCategoryConfig: Partial<SdkConfig> = { environment: Environment.LOCALHOST8000 };

  protected deleteCategoryConfig: Partial<SdkConfig> = { environment: Environment.LOCALHOST8000 };

  protected listExpensesConfig: Partial<SdkConfig> = { environment: Environment.LOCALHOST8000 };

  protected getExpenseConfig: Partial<SdkConfig> = { environment: Environment.LOCALHOST8000 };

  protected createExpenseConfig: Partial<SdkConfig> = { environment: Environment.LOCALHOST8000 };

  protected updateExpenseConfig: Partial<SdkConfig> = { environment: Environment.LOCALHOST8000 };

  protected deleteExpenseConfig: Partial<SdkConfig> = { environment: Environment.LOCALHOST8000 };

  protected listClaimsConfig: Partial<SdkConfig> = { environment: Environment.LOCALHOST8000 };

  protected getClaimConfig: Partial<SdkConfig> = { environment: Environment.LOCALHOST8000 };

  protected createClaimConfig: Partial<SdkConfig> = { environment: Environment.LOCALHOST8000 };

  protected submitClaimConfig: Partial<SdkConfig> = { environment: Environment.LOCALHOST8000 };

  protected approveClaimConfig: Partial<SdkConfig> = { environment: Environment.LOCALHOST8000 };

  /**
   * Sets method-level configuration for loginAsEmployee.
   * @param config - Partial configuration to override service-level defaults
   * @returns This service instance for method chaining
   */
  setLoginAsEmployeeConfig(config: Partial<SdkConfig>): this {
    this.loginAsEmployeeConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for loginAsApprover.
   * @param config - Partial configuration to override service-level defaults
   * @returns This service instance for method chaining
   */
  setLoginAsApproverConfig(config: Partial<SdkConfig>): this {
    this.loginAsApproverConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for loginAsFinance.
   * @param config - Partial configuration to override service-level defaults
   * @returns This service instance for method chaining
   */
  setLoginAsFinanceConfig(config: Partial<SdkConfig>): this {
    this.loginAsFinanceConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for listCategories.
   * @param config - Partial configuration to override service-level defaults
   * @returns This service instance for method chaining
   */
  setListCategoriesConfig(config: Partial<SdkConfig>): this {
    this.listCategoriesConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for getCategory.
   * @param config - Partial configuration to override service-level defaults
   * @returns This service instance for method chaining
   */
  setGetCategoryConfig(config: Partial<SdkConfig>): this {
    this.getCategoryConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for createCategory.
   * @param config - Partial configuration to override service-level defaults
   * @returns This service instance for method chaining
   */
  setCreateCategoryConfig(config: Partial<SdkConfig>): this {
    this.createCategoryConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for updateCategory.
   * @param config - Partial configuration to override service-level defaults
   * @returns This service instance for method chaining
   */
  setUpdateCategoryConfig(config: Partial<SdkConfig>): this {
    this.updateCategoryConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for deleteCategory.
   * @param config - Partial configuration to override service-level defaults
   * @returns This service instance for method chaining
   */
  setDeleteCategoryConfig(config: Partial<SdkConfig>): this {
    this.deleteCategoryConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for listExpenses.
   * @param config - Partial configuration to override service-level defaults
   * @returns This service instance for method chaining
   */
  setListExpensesConfig(config: Partial<SdkConfig>): this {
    this.listExpensesConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for getExpense.
   * @param config - Partial configuration to override service-level defaults
   * @returns This service instance for method chaining
   */
  setGetExpenseConfig(config: Partial<SdkConfig>): this {
    this.getExpenseConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for createExpense.
   * @param config - Partial configuration to override service-level defaults
   * @returns This service instance for method chaining
   */
  setCreateExpenseConfig(config: Partial<SdkConfig>): this {
    this.createExpenseConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for updateExpense.
   * @param config - Partial configuration to override service-level defaults
   * @returns This service instance for method chaining
   */
  setUpdateExpenseConfig(config: Partial<SdkConfig>): this {
    this.updateExpenseConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for deleteExpense.
   * @param config - Partial configuration to override service-level defaults
   * @returns This service instance for method chaining
   */
  setDeleteExpenseConfig(config: Partial<SdkConfig>): this {
    this.deleteExpenseConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for listClaims.
   * @param config - Partial configuration to override service-level defaults
   * @returns This service instance for method chaining
   */
  setListClaimsConfig(config: Partial<SdkConfig>): this {
    this.listClaimsConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for getClaim.
   * @param config - Partial configuration to override service-level defaults
   * @returns This service instance for method chaining
   */
  setGetClaimConfig(config: Partial<SdkConfig>): this {
    this.getClaimConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for createClaim.
   * @param config - Partial configuration to override service-level defaults
   * @returns This service instance for method chaining
   */
  setCreateClaimConfig(config: Partial<SdkConfig>): this {
    this.createClaimConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for submitClaim.
   * @param config - Partial configuration to override service-level defaults
   * @returns This service instance for method chaining
   */
  setSubmitClaimConfig(config: Partial<SdkConfig>): this {
    this.submitClaimConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for approveClaim.
   * @param config - Partial configuration to override service-level defaults
   * @returns This service instance for method chaining
   */
  setApproveClaimConfig(config: Partial<SdkConfig>): this {
    this.approveClaimConfig = config;
    return this;
  }

  /**
   *
   * @param {Partial<SdkConfig>} [requestConfig] - The request configuration for retry and validation.
   * @returns {Promise<HttpResponse<any>>} - OK
   */
  async loginAsEmployee(
    body: LoginAsEmployeeRequest,
    requestConfig?: Partial<SdkConfig>,
  ): Promise<any> {
    const resolvedConfig = this.getResolvedConfig(this.loginAsEmployeeConfig, requestConfig);
    const request = new RequestBuilder()
      .setConfig(resolvedConfig)
      .setBaseUrl(resolvedConfig)
      .setMethod('POST')
      .setPath('/auth/login')
      .setRequestSchema(loginAsEmployeeRequestRequest)
      .addAccessTokenAuth(resolvedConfig?.token)
      .setRequestContentType(ContentType.Json)
      .addResponse({
        schema: z.any(),
        contentType: ContentType.Json,
        status: 200,
      })
      .addHeaderParam({ key: 'Content-Type', value: 'application/json' })
      .addBody(body)
      .build();
    return this.client.callDirect<any>(request);
  }

  /**
   *
   * @param {Partial<SdkConfig>} [requestConfig] - The request configuration for retry and validation.
   * @returns {Promise<HttpResponse<any>>} - OK
   */
  async loginAsApprover(
    body: LoginAsApproverRequest,
    requestConfig?: Partial<SdkConfig>,
  ): Promise<any> {
    const resolvedConfig = this.getResolvedConfig(this.loginAsApproverConfig, requestConfig);
    const request = new RequestBuilder()
      .setConfig(resolvedConfig)
      .setBaseUrl(resolvedConfig)
      .setMethod('POST')
      .setPath('/auth/login')
      .setRequestSchema(loginAsApproverRequestRequest)
      .addAccessTokenAuth(resolvedConfig?.token)
      .setRequestContentType(ContentType.Json)
      .addResponse({
        schema: z.any(),
        contentType: ContentType.Json,
        status: 200,
      })
      .addHeaderParam({ key: 'Content-Type', value: 'application/json' })
      .addBody(body)
      .build();
    return this.client.callDirect<any>(request);
  }

  /**
   *
   * @param {Partial<SdkConfig>} [requestConfig] - The request configuration for retry and validation.
   * @returns {Promise<HttpResponse<any>>} - OK
   */
  async loginAsFinance(
    body: LoginAsFinanceRequest,
    requestConfig?: Partial<SdkConfig>,
  ): Promise<any> {
    const resolvedConfig = this.getResolvedConfig(this.loginAsFinanceConfig, requestConfig);
    const request = new RequestBuilder()
      .setConfig(resolvedConfig)
      .setBaseUrl(resolvedConfig)
      .setMethod('POST')
      .setPath('/auth/login')
      .setRequestSchema(loginAsFinanceRequestRequest)
      .addAccessTokenAuth(resolvedConfig?.token)
      .setRequestContentType(ContentType.Json)
      .addResponse({
        schema: z.any(),
        contentType: ContentType.Json,
        status: 200,
      })
      .addHeaderParam({ key: 'Content-Type', value: 'application/json' })
      .addBody(body)
      .build();
    return this.client.callDirect<any>(request);
  }

  /**
   *
   * @param {Partial<SdkConfig>} [requestConfig] - The request configuration for retry and validation.
   * @returns {Promise<HttpResponse<any>>} - OK
   */
  async listCategories(requestConfig?: Partial<SdkConfig>): Promise<any> {
    const resolvedConfig = this.getResolvedConfig(this.listCategoriesConfig, requestConfig);
    const request = new RequestBuilder()
      .setConfig(resolvedConfig)
      .setBaseUrl(resolvedConfig)
      .setMethod('GET')
      .setPath('/categories')
      .setRequestSchema(z.any())
      .addAccessTokenAuth(resolvedConfig?.token)
      .setRequestContentType(ContentType.Json)
      .addResponse({
        schema: z.any(),
        contentType: ContentType.Json,
        status: 200,
      })
      .build();
    return this.client.callDirect<any>(request);
  }

  /**
   *
   * @param {string} categoryId -
   * @param {Partial<SdkConfig>} [requestConfig] - The request configuration for retry and validation.
   * @returns {Promise<HttpResponse<any>>} - OK
   */
  async getCategory(categoryId: string, requestConfig?: Partial<SdkConfig>): Promise<any> {
    const resolvedConfig = this.getResolvedConfig(this.getCategoryConfig, requestConfig);
    const request = new RequestBuilder()
      .setConfig(resolvedConfig)
      .setBaseUrl(resolvedConfig)
      .setMethod('GET')
      .setPath('/categories/{categoryId}')
      .setRequestSchema(z.any())
      .addAccessTokenAuth(resolvedConfig?.token)
      .setRequestContentType(ContentType.Json)
      .addResponse({
        schema: z.any(),
        contentType: ContentType.Json,
        status: 200,
      })
      .addPathParam({
        key: 'categoryId',
        value: categoryId,
      })
      .build();
    return this.client.callDirect<any>(request);
  }

  /**
   *
   * @param {Partial<SdkConfig>} [requestConfig] - The request configuration for retry and validation.
   * @returns {Promise<HttpResponse<any>>} - OK
   */
  async createCategory(
    body: CreateCategoryRequest,
    requestConfig?: Partial<SdkConfig>,
  ): Promise<any> {
    const resolvedConfig = this.getResolvedConfig(this.createCategoryConfig, requestConfig);
    const request = new RequestBuilder()
      .setConfig(resolvedConfig)
      .setBaseUrl(resolvedConfig)
      .setMethod('POST')
      .setPath('/categories')
      .setRequestSchema(createCategoryRequestRequest)
      .addAccessTokenAuth(resolvedConfig?.token)
      .setRequestContentType(ContentType.Json)
      .addResponse({
        schema: z.any(),
        contentType: ContentType.Json,
        status: 200,
      })
      .addHeaderParam({ key: 'Content-Type', value: 'application/json' })
      .addBody(body)
      .build();
    return this.client.callDirect<any>(request);
  }

  /**
   *
   * @param {string} categoryId -
   * @param {Partial<SdkConfig>} [requestConfig] - The request configuration for retry and validation.
   * @returns {Promise<HttpResponse<any>>} - OK
   */
  async updateCategory(
    categoryId: string,
    body: UpdateCategoryRequest,
    requestConfig?: Partial<SdkConfig>,
  ): Promise<any> {
    const resolvedConfig = this.getResolvedConfig(this.updateCategoryConfig, requestConfig);
    const request = new RequestBuilder()
      .setConfig(resolvedConfig)
      .setBaseUrl(resolvedConfig)
      .setMethod('PUT')
      .setPath('/categories/{categoryId}')
      .setRequestSchema(updateCategoryRequestRequest)
      .addAccessTokenAuth(resolvedConfig?.token)
      .setRequestContentType(ContentType.Json)
      .addResponse({
        schema: z.any(),
        contentType: ContentType.Json,
        status: 200,
      })
      .addPathParam({
        key: 'categoryId',
        value: categoryId,
      })
      .addHeaderParam({ key: 'Content-Type', value: 'application/json' })
      .addBody(body)
      .build();
    return this.client.callDirect<any>(request);
  }

  /**
   *
   * @param {string} categoryId -
   * @param {Partial<SdkConfig>} [requestConfig] - The request configuration for retry and validation.
   * @returns {Promise<HttpResponse<any>>} - OK
   */
  async deleteCategory(categoryId: string, requestConfig?: Partial<SdkConfig>): Promise<any> {
    const resolvedConfig = this.getResolvedConfig(this.deleteCategoryConfig, requestConfig);
    const request = new RequestBuilder()
      .setConfig(resolvedConfig)
      .setBaseUrl(resolvedConfig)
      .setMethod('DELETE')
      .setPath('/categories/{categoryId}')
      .setRequestSchema(z.any())
      .addAccessTokenAuth(resolvedConfig?.token)
      .setRequestContentType(ContentType.Json)
      .addResponse({
        schema: z.any(),
        contentType: ContentType.Json,
        status: 200,
      })
      .addPathParam({
        key: 'categoryId',
        value: categoryId,
      })
      .build();
    return this.client.callDirect<any>(request);
  }

  /**
   *
   * @param {string} [params.status] - Filter by status: unclaimed | claimed
   * @param {string} [params.categoryId] - Filter by category ID
   * @param {string} [params.fromDate] - Filter expenses on or after this date (ISO 8601: YYYY-MM-DD)
   * @param {string} [params.toDate] - Filter expenses on or before this date (ISO 8601: YYYY-MM-DD)
   * @param {Partial<SdkConfig>} [requestConfig] - The request configuration for retry and validation.
   * @returns {Promise<HttpResponse<any>>} - OK
   */
  async listExpenses(
    params?: ListExpensesParams,
    requestConfig?: Partial<SdkConfig>,
  ): Promise<any> {
    const resolvedConfig = this.getResolvedConfig(this.listExpensesConfig, requestConfig);
    z.object({
      status: z.string().optional().nullable(),
      categoryId: z.string().optional().nullable(),
      fromDate: z.string().optional().nullable(),
      toDate: z.string().optional().nullable(),
    }).parse(params ?? {});
    const request = new RequestBuilder()
      .setConfig(resolvedConfig)
      .setBaseUrl(resolvedConfig)
      .setMethod('GET')
      .setPath('/expenses')
      .setRequestSchema(z.any())
      .addAccessTokenAuth(resolvedConfig?.token)
      .setRequestContentType(ContentType.Json)
      .addResponse({
        schema: z.any(),
        contentType: ContentType.Json,
        status: 200,
      })
      .addQueryParam({
        key: 'status',
        value: params?.status,
      })
      .addQueryParam({
        key: 'category_id',
        value: params?.categoryId,
      })
      .addQueryParam({
        key: 'from_date',
        value: params?.fromDate,
      })
      .addQueryParam({
        key: 'to_date',
        value: params?.toDate,
      })
      .build();
    return this.client.callDirect<any>(request);
  }

  /**
   *
   * @param {string} expenseId -
   * @param {Partial<SdkConfig>} [requestConfig] - The request configuration for retry and validation.
   * @returns {Promise<HttpResponse<any>>} - OK
   */
  async getExpense(expenseId: string, requestConfig?: Partial<SdkConfig>): Promise<any> {
    const resolvedConfig = this.getResolvedConfig(this.getExpenseConfig, requestConfig);
    const request = new RequestBuilder()
      .setConfig(resolvedConfig)
      .setBaseUrl(resolvedConfig)
      .setMethod('GET')
      .setPath('/expenses/{expenseId}')
      .setRequestSchema(z.any())
      .addAccessTokenAuth(resolvedConfig?.token)
      .setRequestContentType(ContentType.Json)
      .addResponse({
        schema: z.any(),
        contentType: ContentType.Json,
        status: 200,
      })
      .addPathParam({
        key: 'expenseId',
        value: expenseId,
      })
      .build();
    return this.client.callDirect<any>(request);
  }

  /**
   *
   * @param {Partial<SdkConfig>} [requestConfig] - The request configuration for retry and validation.
   * @returns {Promise<HttpResponse<any>>} - OK
   */
  async createExpense(
    body: CreateExpenseRequest,
    requestConfig?: Partial<SdkConfig>,
  ): Promise<any> {
    const resolvedConfig = this.getResolvedConfig(this.createExpenseConfig, requestConfig);
    const request = new RequestBuilder()
      .setConfig(resolvedConfig)
      .setBaseUrl(resolvedConfig)
      .setMethod('POST')
      .setPath('/expenses')
      .setRequestSchema(createExpenseRequestRequest)
      .addAccessTokenAuth(resolvedConfig?.token)
      .setRequestContentType(ContentType.Json)
      .addResponse({
        schema: z.any(),
        contentType: ContentType.Json,
        status: 200,
      })
      .addHeaderParam({ key: 'Content-Type', value: 'application/json' })
      .addBody(body)
      .build();
    return this.client.callDirect<any>(request);
  }

  /**
   *
   * @param {string} expenseId -
   * @param {Partial<SdkConfig>} [requestConfig] - The request configuration for retry and validation.
   * @returns {Promise<HttpResponse<any>>} - OK
   */
  async updateExpense(
    expenseId: string,
    body: UpdateExpenseRequest,
    requestConfig?: Partial<SdkConfig>,
  ): Promise<any> {
    const resolvedConfig = this.getResolvedConfig(this.updateExpenseConfig, requestConfig);
    const request = new RequestBuilder()
      .setConfig(resolvedConfig)
      .setBaseUrl(resolvedConfig)
      .setMethod('PUT')
      .setPath('/expenses/{expenseId}')
      .setRequestSchema(updateExpenseRequestRequest)
      .addAccessTokenAuth(resolvedConfig?.token)
      .setRequestContentType(ContentType.Json)
      .addResponse({
        schema: z.any(),
        contentType: ContentType.Json,
        status: 200,
      })
      .addPathParam({
        key: 'expenseId',
        value: expenseId,
      })
      .addHeaderParam({ key: 'Content-Type', value: 'application/json' })
      .addBody(body)
      .build();
    return this.client.callDirect<any>(request);
  }

  /**
   *
   * @param {string} expenseId -
   * @param {Partial<SdkConfig>} [requestConfig] - The request configuration for retry and validation.
   * @returns {Promise<HttpResponse<any>>} - OK
   */
  async deleteExpense(expenseId: string, requestConfig?: Partial<SdkConfig>): Promise<any> {
    const resolvedConfig = this.getResolvedConfig(this.deleteExpenseConfig, requestConfig);
    const request = new RequestBuilder()
      .setConfig(resolvedConfig)
      .setBaseUrl(resolvedConfig)
      .setMethod('DELETE')
      .setPath('/expenses/{expenseId}')
      .setRequestSchema(z.any())
      .addAccessTokenAuth(resolvedConfig?.token)
      .setRequestContentType(ContentType.Json)
      .addResponse({
        schema: z.any(),
        contentType: ContentType.Json,
        status: 200,
      })
      .addPathParam({
        key: 'expenseId',
        value: expenseId,
      })
      .build();
    return this.client.callDirect<any>(request);
  }

  /**
   *
   * @param {string} [params.status] - Filter by status: draft | submitted | approved | rejected | reimbursed
   * @param {string} [params.employeeId] - Filter by employee (Finance and Approver only)
   * @param {Partial<SdkConfig>} [requestConfig] - The request configuration for retry and validation.
   * @returns {Promise<HttpResponse<any>>} - OK
   */
  async listClaims(params?: ListClaimsParams, requestConfig?: Partial<SdkConfig>): Promise<any> {
    const resolvedConfig = this.getResolvedConfig(this.listClaimsConfig, requestConfig);
    z.object({
      status: z.string().optional().nullable(),
      employeeId: z.string().optional().nullable(),
    }).parse(params ?? {});
    const request = new RequestBuilder()
      .setConfig(resolvedConfig)
      .setBaseUrl(resolvedConfig)
      .setMethod('GET')
      .setPath('/claims')
      .setRequestSchema(z.any())
      .addAccessTokenAuth(resolvedConfig?.token)
      .setRequestContentType(ContentType.Json)
      .addResponse({
        schema: z.any(),
        contentType: ContentType.Json,
        status: 200,
      })
      .addQueryParam({
        key: 'status',
        value: params?.status,
      })
      .addQueryParam({
        key: 'employee_id',
        value: params?.employeeId,
      })
      .build();
    return this.client.callDirect<any>(request);
  }

  /**
   *
   * @param {string} claimId -
   * @param {Partial<SdkConfig>} [requestConfig] - The request configuration for retry and validation.
   * @returns {Promise<HttpResponse<any>>} - OK
   */
  async getClaim(claimId: string, requestConfig?: Partial<SdkConfig>): Promise<any> {
    const resolvedConfig = this.getResolvedConfig(this.getClaimConfig, requestConfig);
    const request = new RequestBuilder()
      .setConfig(resolvedConfig)
      .setBaseUrl(resolvedConfig)
      .setMethod('GET')
      .setPath('/claims/{claimId}')
      .setRequestSchema(z.any())
      .addAccessTokenAuth(resolvedConfig?.token)
      .setRequestContentType(ContentType.Json)
      .addResponse({
        schema: z.any(),
        contentType: ContentType.Json,
        status: 200,
      })
      .addPathParam({
        key: 'claimId',
        value: claimId,
      })
      .build();
    return this.client.callDirect<any>(request);
  }

  /**
   *
   * @param {Partial<SdkConfig>} [requestConfig] - The request configuration for retry and validation.
   * @returns {Promise<HttpResponse<any>>} - OK
   */
  async createClaim(body: CreateClaimRequest, requestConfig?: Partial<SdkConfig>): Promise<any> {
    const resolvedConfig = this.getResolvedConfig(this.createClaimConfig, requestConfig);
    const request = new RequestBuilder()
      .setConfig(resolvedConfig)
      .setBaseUrl(resolvedConfig)
      .setMethod('POST')
      .setPath('/claims')
      .setRequestSchema(createClaimRequestRequest)
      .addAccessTokenAuth(resolvedConfig?.token)
      .setRequestContentType(ContentType.Json)
      .addResponse({
        schema: z.any(),
        contentType: ContentType.Json,
        status: 200,
      })
      .addHeaderParam({ key: 'Content-Type', value: 'application/json' })
      .addBody(body)
      .build();
    return this.client.callDirect<any>(request);
  }

  /**
   *
   * @param {string} claimId -
   * @param {Partial<SdkConfig>} [requestConfig] - The request configuration for retry and validation.
   * @returns {Promise<HttpResponse<any>>} - OK
   */
  async submitClaim(claimId: string, requestConfig?: Partial<SdkConfig>): Promise<any> {
    const resolvedConfig = this.getResolvedConfig(this.submitClaimConfig, requestConfig);
    const request = new RequestBuilder()
      .setConfig(resolvedConfig)
      .setBaseUrl(resolvedConfig)
      .setMethod('POST')
      .setPath('/claims/{claimId}/submit')
      .setRequestSchema(z.any())
      .addAccessTokenAuth(resolvedConfig?.token)
      .setRequestContentType(ContentType.Json)
      .addResponse({
        schema: z.any(),
        contentType: ContentType.Json,
        status: 200,
      })
      .addPathParam({
        key: 'claimId',
        value: claimId,
      })
      .build();
    return this.client.callDirect<any>(request);
  }

  /**
   *
   * @param {string} claimId -
   * @param {Partial<SdkConfig>} [requestConfig] - The request configuration for retry and validation.
   * @returns {Promise<HttpResponse<any>>} - OK
   */
  async approveClaim(claimId: string, requestConfig?: Partial<SdkConfig>): Promise<any> {
    const resolvedConfig = this.getResolvedConfig(this.approveClaimConfig, requestConfig);
    const request = new RequestBuilder()
      .setConfig(resolvedConfig)
      .setBaseUrl(resolvedConfig)
      .setMethod('POST')
      .setPath('/claims/{claimId}/approve')
      .setRequestSchema(z.any())
      .addAccessTokenAuth(resolvedConfig?.token)
      .setRequestContentType(ContentType.Json)
      .addResponse({
        schema: z.any(),
        contentType: ContentType.Json,
        status: 200,
      })
      .addPathParam({
        key: 'claimId',
        value: claimId,
      })
      .build();
    return this.client.callDirect<any>(request);
  }
}
