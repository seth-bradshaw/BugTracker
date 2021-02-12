import {
  GETUSERTICKETSSTART,
  GETUSERTICKETSSUCCESS,
  GETUSERTICKETSFAILURE,
} from '../../constants';
import axiosWithAuth from '../../utils/axiosWithAuth';
import { useSelector } from 'react-redux';

export const fetchDashBoardTickets = () => (dispatch) => {
  dispatch({type: GETUSERTICKETSSTART});
  const companyid = useSelector((state) => state.user.company.companyid)

  axiosWithAuth()
    .get(`/company/${companyid}/tickets`)
  
};
