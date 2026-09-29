from __future__ import annotations
from pydantic import Field
from typing import Optional
from typing import Any
from typing import Union
from .utils.base_model import BaseModel


class CreateExpenseRequest(BaseModel):
    """CreateExpenseRequest

    :param category_id: category_id, defaults to None
    :type category_id: str, optional
    :param amount: amount, defaults to None
    :type amount: float, optional
    :param currency: currency, defaults to None
    :type currency: str, optional
    :param date_: date_, defaults to None
    :type date_: str, optional
    :param merchant: merchant, defaults to None
    :type merchant: str, optional
    :param description: description, defaults to None
    :type description: str, optional
    :param receipt_url: receipt_url, defaults to None
    :type receipt_url: str, optional
    """

    category_id: Optional[str] = Field(default=None)
    amount: Optional[float] = Field(default=None)
    currency: Optional[str] = Field(default=None)
    date_: Optional[str] = Field(alias="date", serialization_alias="date", default=None)
    merchant: Optional[str] = Field(default=None)
    description: Optional[str] = Field(default=None)
    receipt_url: Optional[str] = Field(default=None)
