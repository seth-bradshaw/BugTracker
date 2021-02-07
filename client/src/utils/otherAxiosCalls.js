import axios from 'axios';
import { BASEURL } from '../constants';

const baseAxiosCall = () => {
  return axios.create({
    baseURL: BASEURL,
  });
};

export const login = (loginCreds) => {
  const { username, password } = loginCreds;

  return baseAxiosCall()
    .post('/login', { username: username, password: password })
    .then((res) => {
      return res;
    })
    .catch((err) => {
      return err;
    });
};

export const register = (newUser) => {
  const { username, password, email } = newUser;

  return baseAxiosCall()
    .post('/createnewuser', {
      username: username,
      password: password,
      email: email,
    })
    .then((res) => {
      return res;
    })
    .catch((err) => {
      return err;
    });
};
