import * as Yup from 'yup';

export const loginSchema = Yup.object().shape({
  username: Yup.string().required('*Username is required'),
  password: Yup.string()
    .min(6, '*Min length is 6 characters')
    .max(30, '*Max length 30 characters')
    .required('*Password is required'),
});

export const registerSchema = Yup.object().shape({
  username: Yup.string().required('*Username is required'),
  password: Yup.string()
    .min(6, '*Min length is 6 characters')
    .max(30, '*Max length 30 characters')
    .required('*Password is required'),
  email: Yup.string().email().required('*Email is required'),
});
