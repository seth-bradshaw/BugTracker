import {
  GETUSERTICKETSSTART,
  GETUSERTICKETSSUCCESS,
  GETUSERTICKETSFAILURE,
  FILTERTICKETSNOTSTARTED, 
  FILTERTICKETSINPROGRESS,
  FILTERTICKETSCOMPLETED
} from '../../constants';
import axiosWithAuth from '../../utils/axiosWithAuth';
import { useSelector } from 'react-redux';

export const fetchDashBoardTickets = () => (dispatch) => {
  // dispatch({type: GETUSERTICKETSSTART});
  // const companyid = useSelector((state) => state.user.company.companyid)

  // axiosWithAuth()
  //   .get(`/company/${companyid}/tickets`)
  
};

//For filtering company tickets
export const filterTicketsByNotStarted  = () => (dispatch) => {
  dispatch({type: FILTERTICKETSNOTSTARTED, payload: true})
}

export const filterTicketsByInProgress  = () => (dispatch) => {
  dispatch({type: FILTERTICKETSINPROGRESS, payload: true})
}

export const filterTicketsByCompleted  = () => (dispatch) => {
  dispatch({type: FILTERTICKETSCOMPLETED, payload: true})
}
