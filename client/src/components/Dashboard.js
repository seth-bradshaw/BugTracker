import React, { useEffect, useState } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { getCurrentUser } from '../store/actions/UserActions';
import EditingToggle from './EditingToggle';

export default function Dashboard() {
  const dispatch = useDispatch();
  const currentUser = useSelector((state) => state.user);
  const tickets = useSelector((state) => state.tickets.tickets);
  const [getIsEditing, setIsEditing] = useState(false);

  const updateSection = () => {};

  useEffect(() => {
    dispatch(getCurrentUser());
  }, []);

  return (
    <>
      <div>Dashboard</div>
      {console.log(tickets)}
      {tickets.length > 0 &&
        tickets.map((ticket) => {
          return (
            <div key={ticket.ticketid}>
              <ul>
                <li>ID: {ticket.ticketid}</li>
                <li>Created By: {ticket.user}</li>
                <li>Title: {ticket.title}</li>
                <li>Desc: {ticket.description}</li>
                <li>Status: {ticket.status}</li>
                <li>Error Code: {ticket.errorcode}</li>
                <li>Error Category: {ticket.errorcategory}</li>
                <li>Notes: {ticket.notes}</li>
              </ul>
            </div>
          );
        })}
    </>
  );
}
