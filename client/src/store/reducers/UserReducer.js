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
  company: {},
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
      const { userid, username, roles, email, company } = action.payload;
      return {
        ...state,
        userid: userid, 
        username: username,
        roles: roles,
        email: email,
        company: company,
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
