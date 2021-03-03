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

export const postTicket = (newTicket) => {
  const { title, description, status, errorcode, category, notes, severity } = newTicket;
  // TEMP COMMENT OUT SINCE WE DONT HAVE ANT MATCHERS return axiosWithAuth()
  axios
    .post(`http://localhost:2019/tickets/tickets`, {
      title: title,
      description: description,
      status: status,
      errorcode: errorcode,
      category: category,
      notes: notes,
      severity: severity
    })
    .then((res) => {
      console.log('SUCCESS POSTING TICKET==>', res);
      return res;
    })
    .catch((err) => {
      console.log('ERROR POSTING TICKET==>', err);
      return err;
    });
};

export const getStatusesByUser = () => {
  axiosWithAuth()
    .get(`http://localhost:2019/statuses/statuses/user`)
    .then((res) => {
      return res;
    })
    .catch((err) => {
      return err;
    })
}