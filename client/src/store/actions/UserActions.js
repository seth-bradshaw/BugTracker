import {
  GETCURRENTUSERSTART,
  GETCURRENTUSERSUCCESS,
  GETCURRENTUSERFAILURE,
} from '../../constants';
import axiosWithAuth from '../../utils/axiosWithAuth';

export const getCurrentUser = () => (dispatch) => {
  dispatch({ type: GETCURRENTUSERSTART });
  axiosWithAuth()
    .get('/getuserinfo')
    .then((res) => {
      let { userid, username, roles, email } = res.data;
      roles = roles.map((role) => {
        return role.role.name;
      });
      dispatch({
        type: GETCURRENTUSERSUCCESS,
        payload: { userid: userid, username: username, roles: roles, email: email },
      });
    })
    .catch((err) => {
      dispatch({ type: GETCURRENTUSERFAILURE, payload: err.message });
    });
};
