import axios from 'axios';

const axiosWithAuth = () => {
  const token = localStorage.getItem('token');

  return axios.create({
    headers: {
      Authorization: token,
    },
    // for testing
    baseURL: 'http://localhost:2019/',
    // for deployment
    // baseURL: "",
  });
};

export default axiosWithAuth;
