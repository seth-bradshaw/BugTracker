import React, { useState } from 'react';
import './App.css';
import { Switch, Route } from 'react-router-dom';
import NavBar from './components/NavBar';
import LoginForm from './components/LoginForm';
import RegisterForm from './components/RegisterForm';
import PrivateRoute from './utils/PrivateRoute';
import Dashboard from './components/Dashboard';
import PostTicket from './components/Tickets/PostTicket';
import PutTicket from './components/Tickets/PutTicket';
import { Collapse, Navbar, NavbarToggler, NavbarBrand, Nav, NavItem, NavLink } from 'reactstrap';

function App() {
  const [collapsed, setCollapsed] = useState(true);

  const toggleNavbar = () => setCollapsed(!collapsed);
  return (
    <div className="App">
      <NavBar />
      <Switch>
        <Route exact path="/" component={LoginForm} />
        <Route path="/register" component={RegisterForm} />
        <PrivateRoute path="/dashboard" component={Dashboard} />
        <PrivateRoute path="/postticket" component={PostTicket} />
        <PrivateRoute path="/putticket" component={PutTicket} />
      </Switch>
    </div>
  );
}

export default App;
