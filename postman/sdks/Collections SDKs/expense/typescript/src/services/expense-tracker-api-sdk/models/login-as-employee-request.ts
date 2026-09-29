import { z } from 'zod';

/**
 * Zod schema for the LoginAsEmployeeRequest model.
 * Defines the structure and validation rules for this data type.
 * This is the shape used in application code - what developers interact with.
 */
export const loginAsEmployeeRequest = z.lazy(() => {
  return z.object({
    email: z.string().optional().nullable(),
    password: z.string().optional().nullable(),
  });
});

/**
 * @typedef {LoginAsEmployeeRequest} loginAsEmployeeRequest
 * @property {string} email
 * @property {string} password
 */
export type LoginAsEmployeeRequest = z.infer<typeof loginAsEmployeeRequest>;

/**
 * Zod schema for mapping API responses to the LoginAsEmployeeRequest application shape.
 * Handles any property name transformations from the API schema.
 * If property names match the API schema exactly, this is identical to the application shape.
 */
export const loginAsEmployeeRequestResponse = z.lazy(() => {
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
 * Zod schema for mapping the LoginAsEmployeeRequest application shape to API requests.
 * Handles any property name transformations required by the API schema.
 * If property names match the API schema exactly, this is identical to the application shape.
 */
export const loginAsEmployeeRequestRequest = z.lazy(() => {
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
