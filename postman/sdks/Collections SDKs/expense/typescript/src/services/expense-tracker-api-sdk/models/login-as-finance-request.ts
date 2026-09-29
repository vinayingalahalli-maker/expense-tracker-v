import { z } from 'zod';

/**
 * Zod schema for the LoginAsFinanceRequest model.
 * Defines the structure and validation rules for this data type.
 * This is the shape used in application code - what developers interact with.
 */
export const loginAsFinanceRequest = z.lazy(() => {
  return z.object({
    email: z.string().optional().nullable(),
    password: z.string().optional().nullable(),
  });
});

/**
 * @typedef {LoginAsFinanceRequest} loginAsFinanceRequest
 * @property {string} email
 * @property {string} password
 */
export type LoginAsFinanceRequest = z.infer<typeof loginAsFinanceRequest>;

/**
 * Zod schema for mapping API responses to the LoginAsFinanceRequest application shape.
 * Handles any property name transformations from the API schema.
 * If property names match the API schema exactly, this is identical to the application shape.
 */
export const loginAsFinanceRequestResponse = z.lazy(() => {
  return z
    .object({
      email: z.string().optional().nullable(),
      password: z.string().optional().nullable(),
    })
    .transform((data) => ({
      email: data['email'],
      password: data['password'],
    }));
});

/**
 * Zod schema for mapping the LoginAsFinanceRequest application shape to API requests.
 * Handles any property name transformations required by the API schema.
 * If property names match the API schema exactly, this is identical to the application shape.
 */
export const loginAsFinanceRequestRequest = z.lazy(() => {
  return z
    .object({
      email: z.string().optional().nullable(),
      password: z.string().optional().nullable(),
    })
    .transform((data) => ({
      email: data['email'],
      password: data['password'],
    }));
});
