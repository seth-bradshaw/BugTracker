import { getStatusesByUser } from '../../utils/otherAxiosCalls';

export const types = {
  GET_STATUSES_START: 'GET_STATUSES_START',
  GET_STATUSES_SUCCESS: 'GET_STATUSES_SUCCESS',
  GET_STATUSES_ERROR: 'GET_STATUSES_ERROR',
  GET_STATUSES_RESOLVE: 'GET_STATUSES_RESOLVE',
  GET_STATUS_START: 'GET_STATUS_START',
  GET_STATUS_SUCCESS: 'GET_STATUS_SUCCESS',
  GET_STATUS_ERROR: 'GET_STATUS_ERROR',
  GET_STATUS_RESOLVE: 'GET_STATUS_RESOLVE',
  POST_STATUS_START: 'POST_STATUS_START',
  POST_STATUS_SUCCESS: 'POST_STATUS_SUCCESS',
  POST_STATUS_ERROR: 'POST_STATUS_ERROR',
  POST_STATUS_RESOLVE: 'POST_STATUS_RESOLVE',
  PUT_STATUS_START: 'PUT_STATUS_START',
  PUT_STATUS_SUCCESS: 'PUT_STATUS_SUCCESS',
  PUT_STATUS_ERROR: 'PUT_STATUS_ERROR',
  PUT_STATUS_RESOLVE: 'PUT_STATUS_RESOLVE',
  DELETE_STATUS_START: 'DELETE_STATUS_START',
  DELETE_STATUS_SUCCESS: 'DELETE_STATUS_SUCCESS',
  DELETE_STATUS_ERROR: 'DELETE_STATUS_ERROR',
  DELETE_STATUS_RESOLVE: 'DELETE_STATUS_RESOLVE',
};

export const actions = {
  fetchStatusesThunk: () => dispatch => {
    dispatch({ type: types.GET_STATUSES_START });
    getStatusesByUser()
      .then(res => {
        dispatch({ type: types.GET_STATUSES_SUCCESS, payload: res.data });
      })
      .catch(err => {
        dispatch({ type: types.GET_STATUSES_ERROR, payload: err.message });
      })
      .finally(() => {
        dispatch({ type: types.GET_STATUSES_RESOLVE });
      });
  },
  fetchSingleStatusThunk: id => dispatch => {
    dispatch({ type: types.GET_STATUS_START });
    register(newUser)
      .then(res => {
        dispatch({ type: types.GET_STATUS_SUCCESS, payload: res.data });
      })
      .catch(err => {
        dispatch({ type: types.GET_STATUS_ERROR, payload: err.message });
      })
      .finally(() => {
        dispatch({ type: types.GET_STATUS_RESOLVE });
      });
  },
  postStatusThunk: newUser => dispatch => {
    dispatch({ type: types.GET_STATUS_START });
    register(newUser)
      .then(res => {
        dispatch({ type: types.GET_STATUS_SUCCESS, payload: res.data });
      })
      .catch(err => {
        dispatch({ type: types.GET_STATUS_ERROR, payload: err.message });
      })
      .finally(() => {
        dispatch({ type: types.GET_STATUS_RESOLVE });
      });
  },
  putStatusThunk: newUser => dispatch => {
    dispatch({ type: types.REGISTER_START });
    register(newUser)
      .then(res => {
        dispatch({ type: types.REGISTER_SUCCESS, payload: res.data });
      })
      .catch(err => {
        dispatch({ type: types.FETCH_STATUS_ERROR, payload: err.message });
      })
      .finally(() => {
        dispatch({ type: types.FETCH_STATUS_RESOLVE });
      });
  },
  deleteStatusThunk: newUser => dispatch => {
    dispatch({ type: types.REGISTER_START });
    register(newUser)
      .then(res => {
        dispatch({ type: types.REGISTER_SUCCESS, payload: res.data });
      })
      .catch(err => {
        dispatch({ type: types.FETCH_STATUS_ERROR, payload: err.message });
      })
      .finally(() => {
        dispatch({ type: types.FETCH_STATUS_RESOLVE });
      });
  },
};

const initialState = {
  statuses: [],
  ticketStatus: {},
  status: 'idle',
  error: '',
};

const statusReducer = (state = initialState, action) => {
  switch (action.type) {
    case types.GET_STATUSES_START:
      return {
        ...state,
        status: 'get/pending',
      };
    case types.GET_STATUSES_SUCCESS:
      return {
        ...state,
        statuses: action.payload,
        status: 'get/success',
      };
    case types.GET_STATUSES_ERROR:
      return {
        ...state,
        status: 'get/error',
        error: action.payload,
      };
    case types.GET_STATUSES_RESOLVE:
      return {
        ...state,
        status: 'idle',
      };

    case types.GET_STATUS_START:
      return {
        ...state,
        status: 'get/pending',
      };
    case types.GET_STATUS_SUCCESS:
      return {
        ...state,
        ticketStatus: action.payload,
        status: 'get/success',
      };
    case types.GET_STATUS_ERROR:
      return {
        ...state,
        status: 'get/error',
        error: action.payload,
      };
    case types.GET_STATUS_RESOLVE:
      return {
        ...state,
        status: 'idle',
      };
    //release 2
    // case types.POST_STATUS_START:
    //     return {
    //         ...state,
    //         status: 'post/pending',
    //     };
    // case types.POST_STATUS_SUCCESS:
    //     return {
    //         ...state,
    //         ticketStatus: action.payload,
    //         status: 'post/success'
    //     }
    // case types.POST_STATUS_ERROR:
    //     return {
    //         ...state,
    //         status: 'post/error',
    //         error: action.payload
    //     }
    // case types.POST_STATUS_RESOLVE:
    //     return {
    //         ...state,
    //         status: 'idle'
    //     }

    // case types.PUT_STATUS_START:
    //     return {
    //         ...state,
    //         status: 'put/pending',
    //     };
    // case types.PUT_STATUS_SUCCESS:
    //     return {
    //         ...state,
    //         ticketStatus: action.payload,
    //         status: 'put/success'
    //     }
    // case types.PUT_STATUS_ERROR:
    //     return {
    //         ...state,
    //         status: 'put/error',
    //         error: action.payload
    //     }
    // case types.PUT_STATUS_RESOLVE:
    //     return {
    //         ...state,
    //         status: 'idle'
    //     }

    // case types.DELETE_STATUS_START:
    //     return {
    //         ...state,
    //         status: 'delete/pending',
    //     };
    // case types.DELETE_STATUS_SUCCESS:
    //     return {
    //         ...state,
    //         ticketStatus: action.payload,
    //         status: 'delete/success'
    //     }
    // case types.DELETE_STATUS_ERROR:
    //     return {
    //         ...state,
    //         status: 'delete/error',
    //         error: action.payload
    //     }
    // case types.DELETE_STATUS_RESOLVE:
    //     return {
    //         ...state,
    //         status: 'idle'
    //     }
  }
};

export default statusReducer;