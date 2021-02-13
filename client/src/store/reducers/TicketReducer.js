import {
  GETUSERTICKETSSTART,
  GETUSERTICKETSSUCCESS,
  GETUSERTICKETSFAILURE,
  FILTERTICKETSNOTSTARTED, 
  FILTERTICKETSINPROGRESS,
  FILTERTICKETSCOMPLETED
} from '../../constants';

const defaultState = {
  tickets: [],
  notStarted: false,
  inProgress: false,
  completed: false,
  displayAllTickets: true
};

const ticketReducer = (state = defaultState, action) => {
  switch (action.type) {
    case GETUSERTICKETSSUCCESS:
      return {
        ...state,
        tickets: action.payload,
        isFetching: false,
      };
    case FILTERTICKETSNOTSTARTED:
      return {
        ...state,
        notStarted: action.payload, 
        displayAllTickets: false
      };
    case FILTERTICKETSINPROGRESS:
      return {
        ...state,
        inProgress: action.payload,
        displayAllTickets: false
      };
    case FILTERTICKETSCOMPLETED:
      return {
        ...state,
        completed: action.payload,
        displayAllTickets: false
      }
    default:
      return state;
  }
};

export default ticketReducer;
