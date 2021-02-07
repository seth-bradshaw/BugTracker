import React from 'react';
import { useHistory } from 'react-router-dom';
import { Nav } from 'react-bootstrap';

export default function NavBar() {
  const { push } = useHistory();

  const handleLogout = (e) => {
    localStorage.removeItem('token');
    push('/');
  };

  return (
    <Nav
      justify
      variant="tabs"
      defaultActiveKey="/home"
      style={{ display: 'flex', justifyContent: 'space-evenly' }}
    >
      {/* {localStorage.getItem('token') && (
        <Nav.Item>
          <Nav.Link href="/dashboard">Home</Nav.Link>
        </Nav.Item>
      )} */}
      <Nav.Item>
        <Nav.Link href="/dashboard">Home</Nav.Link>
      </Nav.Item>
      <Nav.Item>
        <Nav.Link href="/">Login</Nav.Link>
      </Nav.Item>
      <Nav.Item>
        <Nav.Link href="/register">Register</Nav.Link>
      </Nav.Item>
      <Nav.Item>
        <Nav.Link onClick={handleLogout}>Logout</Nav.Link>
      </Nav.Item>
      {/* {localStorage.getItem('token') && (
        <Nav.Item>
          <Nav.Link onClick={handleLogout}>Logout</Nav.Link>
        </Nav.Item>
      )} */}
    </Nav>
  );
}
