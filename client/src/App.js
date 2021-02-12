import React, { useState, useEffect } from 'react';
import './App.css';
import { Switch, Route } from 'react-router-dom';
import NavBar from './components/NavBar';
import LoginForm from './components/LoginForm';
import RegisterForm from './components/RegisterForm';
import PrivateRoute from './utils/PrivateRoute';
import Dashboard from './components/Dashboard';
import PostTicket from './components/Tickets/PostTicket';
import PutTicket from './components/Tickets/PutTicket';
import CurrentEmployeeTickets from './components/Tickets/CurrentEmployeeTickets';
import { useDispatch, useSelector } from 'react-redux';
import { getCurrentUser } from './store/actions/UserActions';
import CompanyEmployees from './components/Employees/CompanyEmployees';
import { Collapse, Navbar, NavbarToggler, NavbarBrand, Nav, NavItem, NavLink } from 'reactstrap';

function App() {
  const [collapsed, setCollapsed] = useState(true);
  // const dispatch = useDispatch()
  // const tickets = useSelector((state) => state.tickets.tickets);

  // useEffect(() => {
  //   dispatch(getCurrentUser())
  // }, [])

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
        <PrivateRoute path="/currentemployeetickets" component={CurrentEmployeeTickets} />
        <PrivateRoute path="/companyemployees" component={CompanyEmployees} />
      </Switch>
    </div>
  );
}

export default App;
