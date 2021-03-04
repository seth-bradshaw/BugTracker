import axios from 'axios';
import { BASEURL } from '../constants';
import axiosWithAuth from '../utils/axiosWithAuth';

const baseAxiosCall = () => {
  return axios.create({
    // baseURL: BASEURL,
    baseURL: 'http://localhost:2019',
  });
};

export const login = loginCreds => {
  const { username, password } = loginCreds;

  return baseAxiosCall()
    .post('/login', { username: username, password: password })
    .then(res => {
      return res;
    })
    .catch(err => {
      return err;
    });
};

export const register = newUser => {
  const { username, password, email } = newUser;

  return baseAxiosCall()
    .post('/createnewuser', {
      username: username,
      password: password,
      email: email,
    })
    .then(res => {
      return res;
    })
    .catch(err => {
      return err;
    });
};

export const postTicket = newTicket => {
  const {
    title,
    description,
    status,
    errorcode,
    category,
    notes,
    severity,
  } = newTicket;
  // TEMP COMMENT OUT SINCE WE DONT HAVE ANT MATCHERS return axiosWithAuth()
  axios
    .post(`http://localhost:2019/tickets/tickets`, {
      title: title,
      description: description,
      status: status,
      errorcode: errorcode,
      category: category,
      notes: notes,
      severity: severity,
    })
    .then(res => {
      console.log('SUCCESS POSTING TICKET==>', res);
      return res;
    })
    .catch(err => {
      console.log('ERROR POSTING TICKET==>', err);
      return err;
    });
};

export const getStatusesByUser = () => {
  return axiosWithAuth()
    .get(`http://localhost:2019/statuses/statuses/user`)
    .then(res => {
      return res;
    })
    .catch(err => {
      return err;
    });
};

export const getAllStatuses = () => {
  return axiosWithAuth()
    .get(`http://localhost:2019/statuses/statuses`)
    .then(res => {
      return res;
    })
    .catch(err => {
      return err;
    });
};

export const getStatusById = id => {
  return axiosWithAuth()
    .get(`http://localhost:2019/statuses/status/${id}`)
    .then(res => {
      return res;
    })
    .catch(err => {
      return err;
    });
};

export const addNewStatus = () => {
  return axiosWithAuth()
    .post('http://localhost:2019/statuses/statuses')
    .then(res => {
      return res;
    })
    .catch(err => {
      return err;
    });
};

export const editExistingStatus = id => {
  axiosWithAuth()
    .put(`http://localhost:2019/statuses/status/${id}`)
    .then(res => {
      return res;
    })
    .catch(err => {
      return err;
    });
};

export const deleteStatusById = id => {
  return axiosWithAuth()
    .delete(`http://localhost:2019/statuses/status/${id}`)
    .then(res => {
      return res;
    })
    .catch(err => {
      return err;
    });
};
