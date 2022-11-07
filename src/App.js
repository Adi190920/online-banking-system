import React from 'react'
import '../node_modules/bootstrap/dist/css/bootstrap.min.css'
import './App.css'
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom'

import Login from './pages/login'

import Register from './pages/register'
import DashBoard from './pages/dashboard'
import { MDBNav } from 'mdbreact'
import Container from 'react-bootstrap/Container';
import Navbar from 'react-bootstrap/Navbar';
import Changepin from './pages/Changepin'
function App() {
  return (
    <Router>
      <div className="App">
      <Navbar bg="light" variant="light">
        <Container>
          <Navbar.Brand href="/">WellsFargo</Navbar.Brand>
        </Container>
      </Navbar>
{/* 
        <MDBNav className="navbar navbar-expand-sm navbar- fixed-top">
          <div className="container">
            <Link className="navbar-brand" to={'/login'}>
            
              WellFargo
            </Link>
            <div className="collapse navbar-collapse" id="navbarTogglerDemo02">
              <ul className="navbar-nav ml-auto">
                <li className="nav-item">
                  <Link className="nav-link" to={'/login'}>
                    Login
                  </Link>
                </li>
                <li className="nav-item">
                  <Link className="nav-link" to={'/register'}>
                    Register
                  </Link>
                </li>
              </ul>
            </div>
          </div>
        </MDBNav> */}
        <br/>
        <div className="outer">
          <div className="inner">
            <Routes>
              <Route exact path="/" element={<Login />} />
              <Route path="/login" element={<Login />} />
              <Route path="/register" element={<Register />} />
              <Route path="/dashboard" element={<DashBoard />} />
              <Route path="/changepin" element={<Changepin/>}/>
            </Routes>
          </div>
        </div>
      </div>
    </Router>
  )
}

export default App