import {
  GETCURRENTUSERSTART,
  GETCURRENTUSERSUCCESS,
  GETCURRENTUSERFAILURE,
} from '../../constants';

const defaultState = {
  userid: 0,
  username: null,
  roles: [],
  email: '',
  isFetching: false,
  error: '',
};

const userReducer = (state = defaultState, action) => {
  switch (action.type) {
    case GETCURRENTUSERSTART:
      return {
        ...state,
        isFetching: true,
      };
    case GETCURRENTUSERSUCCESS:
      const { userid, username, roles, email } = action.payload;
      return {
        ...state,
        userid: userid, 
        username: username,
        roles: roles,
        email: email,
        isFetching: false,
      };
    case GETCURRENTUSERFAILURE:
      return {
        ...state,
        error: action.payload,
        isFetching: false,
      };
    default:
      return state;
  }
};

export default userReducer;
