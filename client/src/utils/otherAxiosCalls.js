import axios from 'axios';
import { BASEURL } from '../constants';
import axiosWithAuth from '../utils/axiosWithAuth';

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

export const postTicket = (newTicket, companyid) => {
  const { title, description, status, errorCode, errorCategory } = newTicket;
  return axiosWithAuth()
    .post(`/company/${companyid}/ticket/add`, {
        title: title,
        description: description,
        status: status,
        errorCode: errorCode,
        errorCategory: errorCategory
    })
    .then(res => {
      console.log("SUCCESS POSTING TICKET==>", res)
      return res
    })
    .catch(err => {
      console.log("ERROR POSTING TICKET==>", err)
      return err
    })
}
