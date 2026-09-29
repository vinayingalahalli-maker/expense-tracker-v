from __future__ import annotations
from pydantic import Field
from typing import Optional
from typing import Any
from typing import Union
from .utils.base_model import BaseModel


class LoginAsApproverRequest(BaseModel):
    """LoginAsApproverRequest

    :param email: email, defaults to None
    :type email: str, optional
    :param password: password, defaults to None
    :type password: str, optional
    """

    email: Optional[str] = Field(default=None)
    password: Optional[str] = Field(default=None)
