import axios from 'axios';
import { BASEURL } from '../constants';

const axiosWithAuth = () => {
  const token = localStorage.getItem('token');

  return axios.create({
    headers: {
      Authorization: `Bearer ${token}`,
    },
    // baseURL: BASEURL,
    baseURL: 'http://localhost:2019',
  });
};

export default axiosWithAuth;
