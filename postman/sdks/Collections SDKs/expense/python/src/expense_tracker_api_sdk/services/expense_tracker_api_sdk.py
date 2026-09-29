from typing import Any, Optional, Union
from .utils.validator import Validator
from .utils.base_service import BaseService
from ..net.transport.serializer import Serializer
from ..net.sdk_config import SdkConfig
from ..net.environment.environment import Environment
from ..models.utils.sentinel import SENTINEL
from ..models.utils.cast_models import cast_models
from ..models import (
    CreateCategoryRequest,
    CreateClaimRequest,
    CreateExpenseRequest,
    LoginAsApproverRequest,
    LoginAsEmployeeRequest,
    LoginAsFinanceRequest,
    UpdateCategoryRequest,
    UpdateExpenseRequest,
)


class ExpenseTrackerApiSdkService(BaseService):
    """
    Service class for ExpenseTrackerApiSdkService operations.
    Provides methods to interact with ExpenseTrackerApiSdkService-related API endpoints.
    Inherits common functionality from BaseService including authentication and request handling.
    """

    def __init__(self, *args, **kwargs):
        """Initialize the service and method-level configurations."""
        super().__init__(*args, **kwargs)
        self._login_as_employee_config: SdkConfig = {
            "environment": Environment.LOCALHOST8000
        }
        self._login_as_approver_config: SdkConfig = {
            "environment": Environment.LOCALHOST8000
        }
        self._login_as_finance_config: SdkConfig = {
            "environment": Environment.LOCALHOST8000
        }
        self._list_categories_config: SdkConfig = {
            "environment": Environment.LOCALHOST8000
        }
        self._get_category_config: SdkConfig = {
            "environment": Environment.LOCALHOST8000
        }
        self._create_category_config: SdkConfig = {
            "environment": Environment.LOCALHOST8000
        }
        self._update_category_config: SdkConfig = {
            "environment": Environment.LOCALHOST8000
        }
        self._delete_category_config: SdkConfig = {
            "environment": Environment.LOCALHOST8000
        }
        self._list_expenses_config: SdkConfig = {
            "environment": Environment.LOCALHOST8000
        }
        self._get_expense_config: SdkConfig = {"environment": Environment.LOCALHOST8000}
        self._create_expense_config: SdkConfig = {
            "environment": Environment.LOCALHOST8000
        }
        self._update_expense_config: SdkConfig = {
            "environment": Environment.LOCALHOST8000
        }
        self._delete_expense_config: SdkConfig = {
            "environment": Environment.LOCALHOST8000
        }
        self._list_claims_config: SdkConfig = {"environment": Environment.LOCALHOST8000}
        self._get_claim_config: SdkConfig = {"environment": Environment.LOCALHOST8000}
        self._create_claim_config: SdkConfig = {
            "environment": Environment.LOCALHOST8000
        }
        self._submit_claim_config: SdkConfig = {
            "environment": Environment.LOCALHOST8000
        }
        self._approve_claim_config: SdkConfig = {
            "environment": Environment.LOCALHOST8000
        }

    def set_login_as_employee_config(self, config: SdkConfig):
        """
        Sets method-level configuration for login_as_employee.

        :param SdkConfig config: Configuration dictionary to override service-level defaults.
        :return: The service instance for method chaining.
        """
        self._login_as_employee_config = config
        return self

    def set_login_as_approver_config(self, config: SdkConfig):
        """
        Sets method-level configuration for login_as_approver.

        :param SdkConfig config: Configuration dictionary to override service-level defaults.
        :return: The service instance for method chaining.
        """
        self._login_as_approver_config = config
        return self

    def set_login_as_finance_config(self, config: SdkConfig):
        """
        Sets method-level configuration for login_as_finance.

        :param SdkConfig config: Configuration dictionary to override service-level defaults.
        :return: The service instance for method chaining.
        """
        self._login_as_finance_config = config
        return self

    def set_list_categories_config(self, config: SdkConfig):
        """
        Sets method-level configuration for list_categories.

        :param SdkConfig config: Configuration dictionary to override service-level defaults.
        :return: The service instance for method chaining.
        """
        self._list_categories_config = config
        return self

    def set_get_category_config(self, config: SdkConfig):
        """
        Sets method-level configuration for get_category.

        :param SdkConfig config: Configuration dictionary to override service-level defaults.
        :return: The service instance for method chaining.
        """
        self._get_category_config = config
        return self

    def set_create_category_config(self, config: SdkConfig):
        """
        Sets method-level configuration for create_category.

        :param SdkConfig config: Configuration dictionary to override service-level defaults.
        :return: The service instance for method chaining.
        """
        self._create_category_config = config
        return self

    def set_update_category_config(self, config: SdkConfig):
        """
        Sets method-level configuration for update_category.

        :param SdkConfig config: Configuration dictionary to override service-level defaults.
        :return: The service instance for method chaining.
        """
        self._update_category_config = config
        return self

    def set_delete_category_config(self, config: SdkConfig):
        """
        Sets method-level configuration for delete_category.

        :param SdkConfig config: Configuration dictionary to override service-level defaults.
        :return: The service instance for method chaining.
        """
        self._delete_category_config = config
        return self

    def set_list_expenses_config(self, config: SdkConfig):
        """
        Sets method-level configuration for list_expenses.

        :param SdkConfig config: Configuration dictionary to override service-level defaults.
        :return: The service instance for method chaining.
        """
        self._list_expenses_config = config
        return self

    def set_get_expense_config(self, config: SdkConfig):
        """
        Sets method-level configuration for get_expense.

        :param SdkConfig config: Configuration dictionary to override service-level defaults.
        :return: The service instance for method chaining.
        """
        self._get_expense_config = config
        return self

    def set_create_expense_config(self, config: SdkConfig):
        """
        Sets method-level configuration for create_expense.

        :param SdkConfig config: Configuration dictionary to override service-level defaults.
        :return: The service instance for method chaining.
        """
        self._create_expense_config = config
        return self

    def set_update_expense_config(self, config: SdkConfig):
        """
        Sets method-level configuration for update_expense.

        :param SdkConfig config: Configuration dictionary to override service-level defaults.
        :return: The service instance for method chaining.
        """
        self._update_expense_config = config
        return self

    def set_delete_expense_config(self, config: SdkConfig):
        """
        Sets method-level configuration for delete_expense.

        :param SdkConfig config: Configuration dictionary to override service-level defaults.
        :return: The service instance for method chaining.
        """
        self._delete_expense_config = config
        return self

    def set_list_claims_config(self, config: SdkConfig):
        """
        Sets method-level configuration for list_claims.

        :param SdkConfig config: Configuration dictionary to override service-level defaults.
        :return: The service instance for method chaining.
        """
        self._list_claims_config = config
        return self

    def set_get_claim_config(self, config: SdkConfig):
        """
        Sets method-level configuration for get_claim.

        :param SdkConfig config: Configuration dictionary to override service-level defaults.
        :return: The service instance for method chaining.
        """
        self._get_claim_config = config
        return self

    def set_create_claim_config(self, config: SdkConfig):
        """
        Sets method-level configuration for create_claim.

        :param SdkConfig config: Configuration dictionary to override service-level defaults.
        :return: The service instance for method chaining.
        """
        self._create_claim_config = config
        return self

    def set_submit_claim_config(self, config: SdkConfig):
        """
        Sets method-level configuration for submit_claim.

        :param SdkConfig config: Configuration dictionary to override service-level defaults.
        :return: The service instance for method chaining.
        """
        self._submit_claim_config = config
        return self

    def set_approve_claim_config(self, config: SdkConfig):
        """
        Sets method-level configuration for approve_claim.

        :param SdkConfig config: Configuration dictionary to override service-level defaults.
        :return: The service instance for method chaining.
        """
        self._approve_claim_config = config
        return self

    @cast_models
    def login_as_employee(
        self,
        request_body: LoginAsEmployeeRequest,
        *,
        request_config: Optional[SdkConfig] = None,
    ) -> Any:
        """login_as_employee

        :param request_body: The request body.
        :type request_body: LoginAsEmployeeRequest
        ...
        :raises RequestError: Raised when a request fails, with optional HTTP status code and details.
        ...
        :return: The parsed response data.
        :rtype: Any
        """

        Validator(LoginAsEmployeeRequest).is_nullable().validate(
            request_body, "request_body"
        )

        resolved_config = self._get_resolved_config(
            self._login_as_employee_config, request_config
        )

        serialized_request = (
            Serializer(
                f"{self._resolve_base_url(resolved_config) or Environment.LOCALHOST8000.url or Environment.DEFAULT.url}/auth/login",
                [self.get_access_token(resolved_config)],
                resolved_config,
            )
            .serialize()
            .set_method("POST")
            .set_body(request_body)
        )

        response, _, _ = self.send_request(serialized_request)
        return response

    @cast_models
    def login_as_approver(
        self,
        request_body: LoginAsApproverRequest,
        *,
        request_config: Optional[SdkConfig] = None,
    ) -> Any:
        """login_as_approver

        :param request_body: The request body.
        :type request_body: LoginAsApproverRequest
        ...
        :raises RequestError: Raised when a request fails, with optional HTTP status code and details.
        ...
        :return: The parsed response data.
        :rtype: Any
        """

        Validator(LoginAsApproverRequest).is_nullable().validate(
            request_body, "request_body"
        )

        resolved_config = self._get_resolved_config(
            self._login_as_approver_config, request_config
        )

        serialized_request = (
            Serializer(
                f"{self._resolve_base_url(resolved_config) or Environment.LOCALHOST8000.url or Environment.DEFAULT.url}/auth/login",
                [self.get_access_token(resolved_config)],
                resolved_config,
            )
            .serialize()
            .set_method("POST")
            .set_body(request_body)
        )

        response, _, _ = self.send_request(serialized_request)
        return response

    @cast_models
    def login_as_finance(
        self,
        request_body: LoginAsFinanceRequest,
        *,
        request_config: Optional[SdkConfig] = None,
    ) -> Any:
        """login_as_finance

        :param request_body: The request body.
        :type request_body: LoginAsFinanceRequest
        ...
        :raises RequestError: Raised when a request fails, with optional HTTP status code and details.
        ...
        :return: The parsed response data.
        :rtype: Any
        """

        Validator(LoginAsFinanceRequest).is_nullable().validate(
            request_body, "request_body"
        )

        resolved_config = self._get_resolved_config(
            self._login_as_finance_config, request_config
        )

        serialized_request = (
            Serializer(
                f"{self._resolve_base_url(resolved_config) or Environment.LOCALHOST8000.url or Environment.DEFAULT.url}/auth/login",
                [self.get_access_token(resolved_config)],
                resolved_config,
            )
            .serialize()
            .set_method("POST")
            .set_body(request_body)
        )

        response, _, _ = self.send_request(serialized_request)
        return response

    @cast_models
    def list_categories(self, *, request_config: Optional[SdkConfig] = None) -> Any:
        """list_categories

        ...
        :raises RequestError: Raised when a request fails, with optional HTTP status code and details.
        ...
        :return: The parsed response data.
        :rtype: Any
        """

        resolved_config = self._get_resolved_config(
            self._list_categories_config, request_config
        )

        serialized_request = (
            Serializer(
                f"{self._resolve_base_url(resolved_config) or Environment.LOCALHOST8000.url or Environment.DEFAULT.url}/categories",
                [self.get_access_token(resolved_config)],
                resolved_config,
            )
            .serialize()
            .set_method("GET")
        )

        response, _, _ = self.send_request(serialized_request)
        return response

    @cast_models
    def get_category(
        self, category_id: str, *, request_config: Optional[SdkConfig] = None
    ) -> Any:
        """get_category

        :param category_id: category_id
        :type category_id: str
        ...
        :raises RequestError: Raised when a request fails, with optional HTTP status code and details.
        ...
        :return: The parsed response data.
        :rtype: Any
        """

        Validator(str).validate(category_id, "category_id")

        resolved_config = self._get_resolved_config(
            self._get_category_config, request_config
        )

        serialized_request = (
            Serializer(
                f"{self._resolve_base_url(resolved_config) or Environment.LOCALHOST8000.url or Environment.DEFAULT.url}/categories/{{categoryId}}",
                [self.get_access_token(resolved_config)],
                resolved_config,
            )
            .add_path("categoryId", category_id)
            .serialize()
            .set_method("GET")
        )

        response, _, _ = self.send_request(serialized_request)
        return response

    @cast_models
    def create_category(
        self,
        request_body: CreateCategoryRequest,
        *,
        request_config: Optional[SdkConfig] = None,
    ) -> Any:
        """create_category

        :param request_body: The request body.
        :type request_body: CreateCategoryRequest
        ...
        :raises RequestError: Raised when a request fails, with optional HTTP status code and details.
        ...
        :return: The parsed response data.
        :rtype: Any
        """

        Validator(CreateCategoryRequest).is_nullable().validate(
            request_body, "request_body"
        )

        resolved_config = self._get_resolved_config(
            self._create_category_config, request_config
        )

        serialized_request = (
            Serializer(
                f"{self._resolve_base_url(resolved_config) or Environment.LOCALHOST8000.url or Environment.DEFAULT.url}/categories",
                [self.get_access_token(resolved_config)],
                resolved_config,
            )
            .serialize()
            .set_method("POST")
            .set_body(request_body)
        )

        response, _, _ = self.send_request(serialized_request)
        return response

    @cast_models
    def update_category(
        self,
        request_body: UpdateCategoryRequest,
        category_id: str,
        *,
        request_config: Optional[SdkConfig] = None,
    ) -> Any:
        """update_category

        :param request_body: The request body.
        :type request_body: UpdateCategoryRequest
        :param category_id: category_id
        :type category_id: str
        ...
        :raises RequestError: Raised when a request fails, with optional HTTP status code and details.
        ...
        :return: The parsed response data.
        :rtype: Any
        """

        Validator(UpdateCategoryRequest).is_nullable().validate(
            request_body, "request_body"
        )
        Validator(str).validate(category_id, "category_id")

        resolved_config = self._get_resolved_config(
            self._update_category_config, request_config
        )

        serialized_request = (
            Serializer(
                f"{self._resolve_base_url(resolved_config) or Environment.LOCALHOST8000.url or Environment.DEFAULT.url}/categories/{{categoryId}}",
                [self.get_access_token(resolved_config)],
                resolved_config,
            )
            .add_path("categoryId", category_id)
            .serialize()
            .set_method("PUT")
            .set_body(request_body)
        )

        response, _, _ = self.send_request(serialized_request)
        return response

    @cast_models
    def delete_category(
        self, category_id: str, *, request_config: Optional[SdkConfig] = None
    ) -> Any:
        """delete_category

        :param category_id: category_id
        :type category_id: str
        ...
        :raises RequestError: Raised when a request fails, with optional HTTP status code and details.
        ...
        :return: The parsed response data.
        :rtype: Any
        """

        Validator(str).validate(category_id, "category_id")

        resolved_config = self._get_resolved_config(
            self._delete_category_config, request_config
        )

        serialized_request = (
            Serializer(
                f"{self._resolve_base_url(resolved_config) or Environment.LOCALHOST8000.url or Environment.DEFAULT.url}/categories/{{categoryId}}",
                [self.get_access_token(resolved_config)],
                resolved_config,
            )
            .add_path("categoryId", category_id)
            .serialize()
            .set_method("DELETE")
        )

        response, _, _ = self.send_request(serialized_request)
        return response

    @cast_models
    def list_expenses(
        self,
        status: Union[str, None] = SENTINEL,
        category_id: Union[str, None] = SENTINEL,
        from_date: Union[str, None] = SENTINEL,
        to_date: Union[str, None] = SENTINEL,
        *,
        request_config: Optional[SdkConfig] = None,
    ) -> Any:
        """list_expenses

        :param status: Filter by status: unclaimed | claimed, defaults to None
        :type status: str, optional
        :param category_id: Filter by category ID, defaults to None
        :type category_id: str, optional
        :param from_date: Filter expenses on or after this date (ISO 8601: YYYY-MM-DD), defaults to None
        :type from_date: str, optional
        :param to_date: Filter expenses on or before this date (ISO 8601: YYYY-MM-DD), defaults to None
        :type to_date: str, optional
        ...
        :raises RequestError: Raised when a request fails, with optional HTTP status code and details.
        ...
        :return: The parsed response data.
        :rtype: Any
        """

        Validator(str).is_optional().is_nullable().validate(status, "status")
        Validator(str).is_optional().is_nullable().validate(category_id, "category_id")
        Validator(str).is_optional().is_nullable().validate(from_date, "from_date")
        Validator(str).is_optional().is_nullable().validate(to_date, "to_date")

        resolved_config = self._get_resolved_config(
            self._list_expenses_config, request_config
        )

        serialized_request = (
            Serializer(
                f"{self._resolve_base_url(resolved_config) or Environment.LOCALHOST8000.url or Environment.DEFAULT.url}/expenses",
                [self.get_access_token(resolved_config)],
                resolved_config,
            )
            .add_query("status", status, nullable=True)
            .add_query("category_id", category_id, nullable=True)
            .add_query("from_date", from_date, nullable=True)
            .add_query("to_date", to_date, nullable=True)
            .serialize()
            .set_method("GET")
        )

        response, _, _ = self.send_request(serialized_request)
        return response

    @cast_models
    def get_expense(
        self, expense_id: str, *, request_config: Optional[SdkConfig] = None
    ) -> Any:
        """get_expense

        :param expense_id: expense_id
        :type expense_id: str
        ...
        :raises RequestError: Raised when a request fails, with optional HTTP status code and details.
        ...
        :return: The parsed response data.
        :rtype: Any
        """

        Validator(str).validate(expense_id, "expense_id")

        resolved_config = self._get_resolved_config(
            self._get_expense_config, request_config
        )

        serialized_request = (
            Serializer(
                f"{self._resolve_base_url(resolved_config) or Environment.LOCALHOST8000.url or Environment.DEFAULT.url}/expenses/{{expenseId}}",
                [self.get_access_token(resolved_config)],
                resolved_config,
            )
            .add_path("expenseId", expense_id)
            .serialize()
            .set_method("GET")
        )

        response, _, _ = self.send_request(serialized_request)
        return response

    @cast_models
    def create_expense(
        self,
        request_body: CreateExpenseRequest,
        *,
        request_config: Optional[SdkConfig] = None,
    ) -> Any:
        """create_expense

        :param request_body: The request body.
        :type request_body: CreateExpenseRequest
        ...
        :raises RequestError: Raised when a request fails, with optional HTTP status code and details.
        ...
        :return: The parsed response data.
        :rtype: Any
        """

        Validator(CreateExpenseRequest).is_nullable().validate(
            request_body, "request_body"
        )

        resolved_config = self._get_resolved_config(
            self._create_expense_config, request_config
        )

        serialized_request = (
            Serializer(
                f"{self._resolve_base_url(resolved_config) or Environment.LOCALHOST8000.url or Environment.DEFAULT.url}/expenses",
                [self.get_access_token(resolved_config)],
                resolved_config,
            )
            .serialize()
            .set_method("POST")
            .set_body(request_body)
        )

        response, _, _ = self.send_request(serialized_request)
        return response

    @cast_models
    def update_expense(
        self,
        request_body: UpdateExpenseRequest,
        expense_id: str,
        *,
        request_config: Optional[SdkConfig] = None,
    ) -> Any:
        """update_expense

        :param request_body: The request body.
        :type request_body: UpdateExpenseRequest
        :param expense_id: expense_id
        :type expense_id: str
        ...
        :raises RequestError: Raised when a request fails, with optional HTTP status code and details.
        ...
        :return: The parsed response data.
        :rtype: Any
        """

        Validator(UpdateExpenseRequest).is_nullable().validate(
            request_body, "request_body"
        )
        Validator(str).validate(expense_id, "expense_id")

        resolved_config = self._get_resolved_config(
            self._update_expense_config, request_config
        )

        serialized_request = (
            Serializer(
                f"{self._resolve_base_url(resolved_config) or Environment.LOCALHOST8000.url or Environment.DEFAULT.url}/expenses/{{expenseId}}",
                [self.get_access_token(resolved_config)],
                resolved_config,
            )
            .add_path("expenseId", expense_id)
            .serialize()
            .set_method("PUT")
            .set_body(request_body)
        )

        response, _, _ = self.send_request(serialized_request)
        return response

    @cast_models
    def delete_expense(
        self, expense_id: str, *, request_config: Optional[SdkConfig] = None
    ) -> Any:
        """delete_expense

        :param expense_id: expense_id
        :type expense_id: str
        ...
        :raises RequestError: Raised when a request fails, with optional HTTP status code and details.
        ...
        :return: The parsed response data.
        :rtype: Any
        """

        Validator(str).validate(expense_id, "expense_id")

        resolved_config = self._get_resolved_config(
            self._delete_expense_config, request_config
        )

        serialized_request = (
            Serializer(
                f"{self._resolve_base_url(resolved_config) or Environment.LOCALHOST8000.url or Environment.DEFAULT.url}/expenses/{{expenseId}}",
                [self.get_access_token(resolved_config)],
                resolved_config,
            )
            .add_path("expenseId", expense_id)
            .serialize()
            .set_method("DELETE")
        )

        response, _, _ = self.send_request(serialized_request)
        return response

    @cast_models
    def list_claims(
        self,
        status: Union[str, None] = SENTINEL,
        employee_id: Union[str, None] = SENTINEL,
        *,
        request_config: Optional[SdkConfig] = None,
    ) -> Any:
        """list_claims

        :param status: Filter by status: draft | submitted | approved | rejected | reimbursed, defaults to None
        :type status: str, optional
        :param employee_id: Filter by employee (Finance and Approver only), defaults to None
        :type employee_id: str, optional
        ...
        :raises RequestError: Raised when a request fails, with optional HTTP status code and details.
        ...
        :return: The parsed response data.
        :rtype: Any
        """

        Validator(str).is_optional().is_nullable().validate(status, "status")
        Validator(str).is_optional().is_nullable().validate(employee_id, "employee_id")

        resolved_config = self._get_resolved_config(
            self._list_claims_config, request_config
        )

        serialized_request = (
            Serializer(
                f"{self._resolve_base_url(resolved_config) or Environment.LOCALHOST8000.url or Environment.DEFAULT.url}/claims",
                [self.get_access_token(resolved_config)],
                resolved_config,
            )
            .add_query("status", status, nullable=True)
            .add_query("employee_id", employee_id, nullable=True)
            .serialize()
            .set_method("GET")
        )

        response, _, _ = self.send_request(serialized_request)
        return response

    @cast_models
    def get_claim(
        self, claim_id: str, *, request_config: Optional[SdkConfig] = None
    ) -> Any:
        """get_claim

        :param claim_id: claim_id
        :type claim_id: str
        ...
        :raises RequestError: Raised when a request fails, with optional HTTP status code and details.
        ...
        :return: The parsed response data.
        :rtype: Any
        """

        Validator(str).validate(claim_id, "claim_id")

        resolved_config = self._get_resolved_config(
            self._get_claim_config, request_config
        )

        serialized_request = (
            Serializer(
                f"{self._resolve_base_url(resolved_config) or Environment.LOCALHOST8000.url or Environment.DEFAULT.url}/claims/{{claimId}}",
                [self.get_access_token(resolved_config)],
                resolved_config,
            )
            .add_path("claimId", claim_id)
            .serialize()
            .set_method("GET")
        )

        response, _, _ = self.send_request(serialized_request)
        return response

    @cast_models
    def create_claim(
        self,
        request_body: CreateClaimRequest,
        *,
        request_config: Optional[SdkConfig] = None,
    ) -> Any:
        """create_claim

        :param request_body: The request body.
        :type request_body: CreateClaimRequest
        ...
        :raises RequestError: Raised when a request fails, with optional HTTP status code and details.
        ...
        :return: The parsed response data.
        :rtype: Any
        """

        Validator(CreateClaimRequest).is_nullable().validate(
            request_body, "request_body"
        )

        resolved_config = self._get_resolved_config(
            self._create_claim_config, request_config
        )

        serialized_request = (
            Serializer(
                f"{self._resolve_base_url(resolved_config) or Environment.LOCALHOST8000.url or Environment.DEFAULT.url}/claims",
                [self.get_access_token(resolved_config)],
                resolved_config,
            )
            .serialize()
            .set_method("POST")
            .set_body(request_body)
        )

        response, _, _ = self.send_request(serialized_request)
        return response

    @cast_models
    def submit_claim(
        self, claim_id: str, *, request_config: Optional[SdkConfig] = None
    ) -> Any:
        """submit_claim

        :param claim_id: claim_id
        :type claim_id: str
        ...
        :raises RequestError: Raised when a request fails, with optional HTTP status code and details.
        ...
        :return: The parsed response data.
        :rtype: Any
        """

        Validator(str).validate(claim_id, "claim_id")

        resolved_config = self._get_resolved_config(
            self._submit_claim_config, request_config
        )

        serialized_request = (
            Serializer(
                f"{self._resolve_base_url(resolved_config) or Environment.LOCALHOST8000.url or Environment.DEFAULT.url}/claims/{{claimId}}/submit",
                [self.get_access_token(resolved_config)],
                resolved_config,
            )
            .add_path("claimId", claim_id)
            .serialize()
            .set_method("POST")
        )

        response, _, _ = self.send_request(serialized_request)
        return response

    @cast_models
    def approve_claim(
        self, claim_id: str, *, request_config: Optional[SdkConfig] = None
    ) -> Any:
        """approve_claim

        :param claim_id: claim_id
        :type claim_id: str
        ...
        :raises RequestError: Raised when a request fails, with optional HTTP status code and details.
        ...
        :return: The parsed response data.
        :rtype: Any
        """

        Validator(str).validate(claim_id, "claim_id")

        resolved_config = self._get_resolved_config(
            self._approve_claim_config, request_config
        )

        serialized_request = (
            Serializer(
                f"{self._resolve_base_url(resolved_config) or Environment.LOCALHOST8000.url or Environment.DEFAULT.url}/claims/{{claimId}}/approve",
                [self.get_access_token(resolved_config)],
                resolved_config,
            )
            .add_path("claimId", claim_id)
            .serialize()
            .set_method("POST")
        )

        response, _, _ = self.send_request(serialized_request)
        return response
