import React, { useState, useEffect } from 'react';
import { useSelector } from 'react-redux';
import axiosWithAuth from '../../utils/axiosWithAuth';

export default function CompanyEmployees() {
  const [emps, setEmps] = useState([]);
  const companyid = useSelector(state => state.user.company.companyid);
  console.log(companyid);

  useEffect(() => {
    axiosWithAuth()
      .get(`/company/${companyid}/employees`)
      .then(res => {
        setEmps(res.data);
      })
      .catch(err => {
        console.log(err);
      });
  }, []);

  return (
    <div>
      {emps.map(emp => {
        return (
          <div>
            <p>{emp.userid}</p>
            <p>{emp.username}</p>
            <p>{emp.email}</p>
            <p>{emp.role}</p>
          </div>
        );
      })}
    </div>
  );
}
