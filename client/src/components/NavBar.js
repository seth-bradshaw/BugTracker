import React, {useState} from 'react';
import { useHistory } from 'react-router-dom';
import {Button} from 'semantic-ui-react';
// import { Nav } from 'react-bootstrap';
import { Collapse, Navbar, NavbarToggler, NavbarBrand, Nav, NavItem, NavLink } from 'reactstrap';

export default function NavBar() {
  const { push } = useHistory();

  const handleLogout = (e) => {
    localStorage.removeItem('token');
    push('/');
  };

  const [collapsed, setCollapsed] = useState(true);

  const toggleNavbar = () => setCollapsed(!collapsed);

  return (
    <div>
      <Navbar color="faded" light>
        <NavbarBrand href="/" className="mr-auto" style={{color: "white", fontSize:"25px"}}>Bug Tracker</NavbarBrand>
        <Button circular icon='bars' onClick={toggleNavbar} inverted/>
        {/* <NavbarToggler onClick={toggleNavbar} className="mr-2" /> */}
        <Collapse isOpen={!collapsed} navbar >
          <Nav navbar >
            <NavItem>
              <NavLink href="/dashboard" style={{color: "#00B5AD"}}>Something</NavLink>
            </NavItem>
            <NavItem>
              <NavLink href="/postticket" style={{color: "#00B5AD"}}>New Ticket</NavLink>
            </NavItem>
            <NavItem>
              <NavLink href="/account" style={{color: "#00B5AD"}}>Account</NavLink>
            </NavItem>
            <NavItem>
              <NavLink href="/" style={{color: "#00B5AD"}} onClick={handleLogout}>Sign Out</NavLink>
            </NavItem>
          </Nav>
        </Collapse>
      </Navbar>
    </div>
  );
  // return (
  //   <Nav
  //     justify
  //     variant="tabs"
  //     defaultActiveKey="/home"
  //     style={{ display: 'flex', justifyContent: 'space-evenly' }}
  //   >
  //     {/* {localStorage.getItem('token') && (
  //       <Nav.Item>
  //         <Nav.Link href="/dashboard">Home</Nav.Link>
  //       </Nav.Item>
  //     )} */}
  //     <Nav.Item>
  //       <Nav.Link href="/dashboard">Home</Nav.Link>
  //     </Nav.Item>
  //     <Nav.Item>
  //       <Nav.Link href="/">Login</Nav.Link>
  //     </Nav.Item>
  //     <Nav.Item>
  //       <Nav.Link href="/register">Register</Nav.Link>
  //     </Nav.Item>
  //     <Nav.Item>
  //       <Nav.Link onClick={handleLogout}>Logout</Nav.Link>
  //     </Nav.Item>
  //     {/* {localStorage.getItem('token') && (
  //       <Nav.Item>
  //         <Nav.Link onClick={handleLogout}>Logout</Nav.Link>
  //       </Nav.Item>
  //     )} */}
  //   </Nav>
  // );
}
