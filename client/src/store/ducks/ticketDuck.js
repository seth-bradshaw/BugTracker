import {
  getSingleTicketById,
  getAllTickets,
  getTicketsForUser,
  addNewTicket,
  editExistingTicket,
  deleteTicket,
} from '../../utils/otherAxiosCalls';

export const types = {
  GET_TICKETS_START: 'GET_TICKETS_START',
  GET_TICKETS_SUCCESS: 'GET_TICKETS_SUCCESS',
  GET_TICKETS_ERROR: 'GET_TICKETS_ERROR',
  GET_TICKETS_RESOLVE: 'GET_TICKETS_RESOLVE',

  GET_USER_TICKETS_START: 'GET_USER_TICKETS_START',
  GET_USER_TICKETS_SUCCESS: 'GET_USER_TICKETS_SUCCESS',
  GET_USER_TICKETS_ERROR: 'GET_USER_TICKETS_ERROR',
  GET_USER_TICKETS_RESOLVE: 'GET_USER_TICKETS_RESOLVE',

  GET_TICKET_START: 'GET_TICKET_START',
  GET_TICKET_SUCCESS: 'GET_TICKET_SUCCESS',
  GET_TICKET_ERROR: 'GET_TICKET_ERROR',
  GET_TICKET_RESOLVE: 'GET_TICKET_RESOLVE',

  POST_TICKET_START: 'POST_TICKET_START',
  POST_TICKET_SUCCESS: 'POST_TICKET_SUCCESS',
  POST_TICKET_ERROR: 'POST_TICKET_ERROR',
  POST_TICKET_RESOLVE: 'POST_TICKET_RESOLVE',

  PUT_TICKET_START: 'PUT_TICKET_START',
  PUT_TICKET_SUCCESS: 'PUT_TICKET_SUCCESS',
  PUT_TICKET_ERROR: 'PUT_TICKET_ERROR',
  PUT_TICKET_RESOLVE: 'PUT_TICKET_RESOLVE',

  DELETE_TICKET_START: 'DELETE_TICKET_START',
  DELETE_TICKET_SUCCESS: 'DELETE_TICKET_SUCCESS',
  DELETE_TICKET_ERROR: 'DELETE_TICKET_ERROR',
  DELETE_TICKET_RESOLVE: 'DELETE_TICKET_RESOLVE',
};

export const actions = {
  fetchAllTicketsThunk: () => dispatch => {
    dispatch({ type: types.GET_TICKETS_START });
    getAllTickets()
      .then(res => {
        dispatch({ type: types.GET_TICKETS_SUCCESS, payload: res.data });
      })
      .catch(err => {
        dispatch({ type: types.GET_TICKETS_ERROR, payload: err.message });
      })
      .finally(() => {
        dispatch({ type: types.GET_TICKETS_RESOLVE });
      });
  },
  fetchTicketsByUserThunk: userid => dispatch => {
    dispatch({ type: types.GET_USER_TICKETS_START });
    getTicketsForUser(userid)
      .then(res => {
        dispatch({ type: types.GET_USER_TICKETS_SUCCESS, payload: res.data });
      })
      .catch(err => {
        dispatch({ type: types.GET_USER_TICKETS_ERROR, payload: err.message });
      })
      .finally(() => {
        dispatch({ type: types.GET_USER_TICKETS_RESOLVE });
      });
  },
  fetchSingleTicketbyId: ticketid => dispatch => {
    dispatch({ type: types.GET_TICKET_START });
    getSingleTicketById(ticketid)
      .then(res => {
        dispatch({ type: types.GET_TICKET_SUCCESS, payload: res.data });
      })
      .catch(err => {
        dispatch({ type: types.GET_TICKET_ERROR, payload: err.message });
      })
      .finally(() => {
        dispatch({ type: types.GET_TICKET_RESOLVE });
      });
  },
  postTicketThunk: newTicket => dispatch => {
    dispatch({ type: types.POST_TICKET_START });
    addNewTicket(newTicket)
      .then(res => {
        dispatch({ type: types.POST_TICKET_SUCCESS, payload: res.data });
      })
      .catch(err => {
        dispatch({ type: types.POST_TICKET_ERROR, payload: err.message });
      })
      .finally(() => {
        dispatch({ type: types.POST_TICKET_RESOLVE });
      });
  },
  editTicketThunk: (ticketid, editedTicket) => dispatch => {
    dispatch({ type: types.PUT_TICKET_START });
    editExistingTicket(ticketid, editedTicket)
      .then(res => {
        dispatch({ type: types.PUT_TICKET_SUCCESS, payload: res.data });
      })
      .catch(err => {
        dispatch({ type: types.PUT_TICKET_ERROR, payload: err.message });
      })
      .finally(() => {
        dispatch({ type: types.PUT_TICKET_RESOLVE });
      });
  },
  deleteTicketThunk: ticketid => dispatch => {
    dispatch({ type: types.DELETE_TICKET_START });
    deleteTicket(ticketid)
      .then(res => {
        dispatch({ type: types.DELETE_TICKET_SUCCESS, payload: res.data });
      })
      .catch(err => {
        dispatch({ type: types.DELETE_TICKET_ERROR, payload: err.message });
      })
      .finally(() => {
        dispatch({ type: types.DELETE_TICKET_RESOLVE });
      });
  },
};

const initialState = {
  tickets: [],
  ticket: {},
  status: 'idle',
  error: '',
};

const ticketReducer = (state = initialState, action) => {
  switch (action.type) {
    case types.GET_TICKETS_START:
      return {
        ...state,
        status: 'get/pending',
      };
    case types.GET_TICKETS_SUCCESS:
      return {
        ...state,
        tickets: action.payload,
        status: 'get/success',
      };
    case types.GET_TICKETS_ERROR:
      return {
        ...state,
        status: 'get/error',
        error: action.payload,
      };
    case types.GET_TICKETS_RESOLVE:
      return {
        ...state,
        status: 'get/pending',
      };
    case types.GET_USER_TICKETS_START:
      return {
        ...state,
        status: 'get/pending',
      };
    case types.GET_USER_TICKETS_SUCCESS:
      return {
        ...state,
        tickets: action.payload,
        status: 'get/success',
      };
    case types.GET_USER_TICKETS_ERROR:
      return {
        ...state,
        status: 'get/error',
        error: action.payload,
      };
    case types.GET_USER_TICKETS_RESOLVE:
      return {
        ...state,
        status: 'get/pending',
      };
    case types.GET_TICKET_START:
      return {
        ...state,
        status: 'get/pending',
      };
    case types.GET_TICKET_SUCCESS:
      return {
        ...state,
        ticket: action.payload,
        status: 'get/success',
      };
    case types.GET_TICKET_ERROR:
      return {
        ...state,
        status: 'get/error',
        error: action.payload,
      };
    case types.GET_TICKET_RESOLVE:
      return {
        ...state,
        status: 'get/pending',
      };
    case types.POST_TICKET_START:
      return {
        ...state,
        status: 'post/pending',
      };
    case types.POST_TICKET_SUCCESS:
      return {
        ...state,
        status: 'post/success',
      };
    case types.POST_TICKET_ERROR:
      return {
        ...state,
        status: 'post/error',
        error: action.payload,
      };
    case types.POST_TICKET_RESOLVE:
      return {
        ...state,
        status: 'idle',
      };
    case types.PUT_TICKET_START:
      return {
        ...state,
        status: 'put/pending',
      };
    case types.PUT_TICKET_SUCCESS:
      return {
        ...state,
        status: 'put/success',
      };
    case types.PUT_TICKET_ERROR:
      return {
        ...state,
        status: 'put/error',
        error: action.payload,
      };
    case types.PUT_TICKET_RESOLVE:
      return {
        ...state,
        status: 'idle',
      };
    case types.DELETE_TICKET_START:
      return {
        ...state,
        status: 'delete/pending',
      };
    case types.DELETE_TICKET_SUCCESS:
      return {
        ...state,
        status: 'delete/success',
      };
    case types.DELETE_TICKET_ERROR:
      return {
        ...state,
        status: 'delete/error',
        error: action.payload,
      };
    case types.DELETE_TICKET_RESOLVE:
      return {
        ...state,
        status: 'idle',
      };
    default:
      return state;
  }
};

export default ticketReducer;
