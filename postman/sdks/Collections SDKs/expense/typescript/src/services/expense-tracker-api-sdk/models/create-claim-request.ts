import { z } from 'zod';

/**
 * Zod schema for the CreateClaimRequest model.
 * Defines the structure and validation rules for this data type.
 * This is the shape used in application code - what developers interact with.
 */
export const createClaimRequest = z.lazy(() => {
  return z.object({
    title: z.string().optional().nullable(),
    expenseIds: z.array(z.string()).optional().nullable(),
  });
});

/**
 * @typedef {CreateClaimRequest} createClaimRequest
 * @property {string} title
 * @property {string[]} expenseIds
 */
export type CreateClaimRequest = z.infer<typeof createClaimRequest>;

/**
 * Zod schema for mapping API responses to the CreateClaimRequest application shape.
 * Handles any property name transformations from the API schema.
 * If property names match the API schema exactly, this is identical to the application shape.
 */
export const createClaimRequestResponse = z.lazy(() => {
  return z
    .object({
      title: z.string().optional().nullable(),
      expense_ids: z.array(z.string()).optional().nullable(),
    })
    .transform((data) => ({
      title: data['title'],
      expenseIds: data['expense_ids'],
    }));
});

/**
 * Zod schema for mapping the CreateClaimRequest application shape to API requests.
 * Handles any property name transformations required by the API schema.
 * If property names match the API schema exactly, this is identical to the application shape.
 */
export const createClaimRequestRequest = z.lazy(() => {
  return z
    .object({
      title: z.string().optional().nullable(),
      expenseIds: z.array(z.string()).optional().nullable(),
    })
    .transform((data) => ({
      title: data['title'],
      expense_ids: data['expenseIds'],
    }));
});
