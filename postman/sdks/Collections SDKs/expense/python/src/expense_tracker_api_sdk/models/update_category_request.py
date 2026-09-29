from __future__ import annotations
from pydantic import Field
from typing import Optional
from typing import Any
from typing import Union
from .utils.base_model import BaseModel


class UpdateCategoryRequest(BaseModel):
    """UpdateCategoryRequest

    :param name: name, defaults to None
    :type name: str, optional
    :param description: description, defaults to None
    :type description: str, optional
    :param receipt_threshold: receipt_threshold, defaults to None
    :type receipt_threshold: float, optional
    :param currency: currency, defaults to None
    :type currency: str, optional
    """

    name: Optional[str] = Field(default=None)
    description: Optional[str] = Field(default=None)
    receipt_threshold: Optional[float] = Field(default=None)
    currency: Optional[str] = Field(default=None)
