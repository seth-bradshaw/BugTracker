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
    .get(`/statuses/statuses/user`)
    .then(res => {
      return res;
    })
    .catch(err => {
      return err;
    });
};

export const getAllStatuses = () => {
  return axiosWithAuth()
    .get(`/statuses/statuses`)
    .then(res => {
      return res;
    })
    .catch(err => {
      return err;
    });
};

export const getStatusById = id => {
  return axiosWithAuth()
    .get(`/statuses/status/${id}`)
    .then(res => {
      return res;
    })
    .catch(err => {
      return err;
    });
};

export const addNewStatus = status => {
  return axiosWithAuth()
    .post('/statuses/statuses', status)
    .then(res => {
      return res;
    })
    .catch(err => {
      return err;
    });
};

export const editExistingStatus = (statusid, status) => {
  return axiosWithAuth()
    .put(`/statuses/status/${statusid}`, status)
    .then(res => {
      return res;
    })
    .catch(err => {
      return err;
    });
};

export const deleteStatusById = id => {
  return axiosWithAuth()
    .delete(`/statuses/status/${id}`)
    .then(res => {
      return res;
    })
    .catch(err => {
      return err;
    });
};

export const getSingleTicketById = id => {
  return axiosWithAuth()
    .get(`/tickets/ticket/${id}`)
    .then(res => {
      return res;
    })
    .catch(err => {
      return err;
    });
};

//returning all tickets in ticket table will change to tickets by company release 2
export const getAllTickets = () => {
  return axiosWithAuth()
    .get(`/tickets/tickets`)
    .then(res => {
      return res;
    })
    .catch(err => {
      return err;
    });
};

export const getTicketsForUser = userid => {
  return axiosWithAuth()
    .get(`/tickets/user/${userid}`)
    .then(res => {
      return res;
    })
    .catch(err => {
      return err;
    });
};

export const addNewTicket = newTicket => {
  return axiosWithAuth()
    .post('/tickets/tickets', newTicket)
    .then(res => {
      return res;
    })
    .catch(err => {
      return err;
    });
};

export const editExistingTicket = (ticketid, editedTicket) => {
  return axiosWithAuth()
    .put(`/tickets/ticket/${ticketid}`, editedTicket)
    .then(res => {
      return res;
    })
    .catch(err => {
      return err;
    });
};

export const deleteTicket = ticketid => {
  return axiosWithAuth()
    .delete(`/tickets/ticket/${ticketid}`)
    .then(res => {
      return res;
    })
    .catch(err => {
      return err;
    });
};
