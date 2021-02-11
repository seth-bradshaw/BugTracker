import {
  GETCURRENTUSERSTART,
  GETCURRENTUSERSUCCESS,
  GETCURRENTUSERFAILURE,
  GETUSERTICKETSSUCCESS,
} from '../../constants';
import axiosWithAuth from '../../utils/axiosWithAuth';

export const getCurrentUser = () => (dispatch) => {
  dispatch({ type: GETCURRENTUSERSTART });

  axiosWithAuth()
    .get('/getuserinfo')
    .then((res) => {
      let { userid, username, roles, email, companies } = res.data;
      roles = roles.map((role) => {
        return role.role.name;
      });
      dispatch({
        type: GETCURRENTUSERSUCCESS,
        payload: {
          userid: userid,
          username: username,
          roles: roles,
          email: email,
        },
      });
      dispatch({
        type: GETUSERTICKETSSUCCESS,
        payload: companies[0].company.tickets,
      });
    })
    .catch((err) => {
      dispatch({ type: GETCURRENTUSERFAILURE, payload: err.message });
    });
};
