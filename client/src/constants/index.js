// for testing (locally)
export const BASEURL = 'http://localhost:2019';
// for deployment
// export const BASEURL = '';

// User Action Types
export const GETCURRENTUSERSTART = 'GETCURRENTUSERSTART';
export const GETCURRENTUSERSUCCESS = 'GETCURRENTUSERSUCCESS';
export const GETCURRENTUSERFAILURE = 'GETCURRENTUSERFAILURE';

// Ticket Action Types
export const GETUSERTICKETSSUCCESS = 'GETUSERTICKETSSUCCESS';

// For Company Employees or Admins Users depending on app.
export const GETCOMPANYEMPLOYEESSUCCESS = 'GETCOMPANYEMPLOYEESSUCCESS';

//For filtering through tickets by status
export const FILTERTICKETSNOTSTARTED = 'FILTERTICKETSNOTSTARTED';
export const FILTERTICKETSINPROGRESS = 'FILTERTICKETSINPROGRESS';
export const FILTERTICKETSCOMPLETED = 'FILTERTICKETSCOMPLETED';