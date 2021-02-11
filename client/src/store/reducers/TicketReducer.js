import {
  GETUSERTICKETSSTART,
  GETUSERTICKETSSUCCESS,
  GETUSERTICKETSFAILURE,
} from '../../constants';

const defaultState = {
  tickets: [],
};

const ticketReducer = (state = defaultState, action) => {
  switch (action.type) {
    case GETUSERTICKETSSUCCESS:
      return {
        ...state,
        tickets: action.payload,
        isFetching: false,
      };
    default:
      return state;
  }
};

export default ticketReducer;
