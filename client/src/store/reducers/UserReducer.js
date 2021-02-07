import {
  GETCURRENTUSERSTART,
  GETCURRENTUSERSUCCESS,
  GETCURRENTUSERFAILURE,
} from '../../constants';

const defaultState = {
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
      const { username, roles, email } = action.payload;
      return {
        ...state,
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
