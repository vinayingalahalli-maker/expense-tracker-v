import { z } from 'zod';

/**
 * Zod schema for the UpdateExpenseRequest model.
 * Defines the structure and validation rules for this data type.
 * This is the shape used in application code - what developers interact with.
 */
export const updateExpenseRequest = z.lazy(() => {
  return z.object({
    categoryId: z.string().optional().nullable(),
    amount: z.number().optional().nullable(),
    currency: z.string().optional().nullable(),
    date: z.string().optional().nullable(),
    merchant: z.string().optional().nullable(),
    description: z.string().optional().nullable(),
    receiptUrl: z.string().optional().nullable(),
  });
});

/**
 * @typedef {UpdateExpenseRequest} updateExpenseRequest
 * @property {string} categoryId
 * @property {number} amount
 * @property {string} currency
 * @property {string} date
 * @property {string} merchant
 * @property {string} description
 * @property {string} receiptUrl
 */
export type UpdateExpenseRequest = z.infer<typeof updateExpenseRequest>;

/**
 * Zod schema for mapping API responses to the UpdateExpenseRequest application shape.
 * Handles any property name transformations from the API schema.
 * If property names match the API schema exactly, this is identical to the application shape.
 */
export const updateExpenseRequestResponse = z.lazy(() => {
  return z
    .object({
      category_id: z.string().optional().nullable(),
      amount: z.number().optional().nullable(),
      currency: z.string().optional().nullable(),
      date: z.string().optional().nullable(),
      merchant: z.string().optional().nullable(),
      description: z.string().optional().nullable(),
      receipt_url: z.string().optional().nullable(),
    })
    .transform((data) => ({
      categoryId: data['category_id'],
      amount: data['amount'],
      currency: data['currency'],
      date: data['date'],
      merchant: data['merchant'],
      description: data['description'],
      receiptUrl: data['receipt_url'],
    }));
});

/**
 * Zod schema for mapping the UpdateExpenseRequest application shape to API requests.
 * Handles any property name transformations required by the API schema.
 * If property names match the API schema exactly, this is identical to the application shape.
 */
export const updateExpenseRequestRequest = z.lazy(() => {
  return z
    .object({
      categoryId: z.string().optional().nullable(),
      amount: z.number().optional().nullable(),
      currency: z.string().optional().nullable(),
      date: z.string().optional().nullable(),
      merchant: z.string().optional().nullable(),
      description: z.string().optional().nullable(),
      receiptUrl: z.string().optional().nullable(),
    })
    .transform((data) => ({
      category_id: data['categoryId'],
      amount: data['amount'],
      currency: data['currency'],
      date: data['date'],
      merchant: data['merchant'],
      description: data['description'],
      receipt_url: data['receiptUrl'],
    }));
});
