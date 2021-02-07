import React, { useEffect } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { getCurrentUser } from '../store/actions/UserActions';

export default function Dashboard() {
  const dispatch = useDispatch();
  const currentUser = useSelector((state) => state.user);

  useEffect(() => {
    dispatch(getCurrentUser());
  }, []);

  return (
    <>
      <div>Dashboard</div>
      {currentUser && console.log(currentUser)}
    </>
  );
}
