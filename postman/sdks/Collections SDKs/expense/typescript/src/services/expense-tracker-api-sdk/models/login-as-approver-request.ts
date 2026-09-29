import { z } from 'zod';

/**
 * Zod schema for the LoginAsApproverRequest model.
 * Defines the structure and validation rules for this data type.
 * This is the shape used in application code - what developers interact with.
 */
export const loginAsApproverRequest = z.lazy(() => {
  return z.object({
    email: z.string().optional().nullable(),
    password: z.string().optional().nullable(),
  });
});

/**
 * @typedef {LoginAsApproverRequest} loginAsApproverRequest
 * @property {string} email
 * @property {string} password
 */
export type LoginAsApproverRequest = z.infer<typeof loginAsApproverRequest>;

/**
 * Zod schema for mapping API responses to the LoginAsApproverRequest application shape.
 * Handles any property name transformations from the API schema.
 * If property names match the API schema exactly, this is identical to the application shape.
 */
export const loginAsApproverRequestResponse = z.lazy(() => {
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
 * Zod schema for mapping the LoginAsApproverRequest application shape to API requests.
 * Handles any property name transformations required by the API schema.
 * If property names match the API schema exactly, this is identical to the application shape.
 */
export const loginAsApproverRequestRequest = z.lazy(() => {
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
