export interface ListExpensesParams {
  status?: string | null;
  categoryId?: string | null;
  fromDate?: string | null;
  toDate?: string | null;
}

export interface ListClaimsParams {
  status?: string | null;
  employeeId?: string | null;
}
