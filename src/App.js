import React from 'react'
import '../node_modules/bootstrap/dist/css/bootstrap.min.css'
import './App.css'
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom'

import Login from './pages/login'

import Register from './pages/register'
import DashBoard from './pages/dashboard'
import useAuth from './hooks/auth'
import NotAuthAppbar from './pages/NotAuthAppbar'
import Appbar from './pages/AppBar'
import Changepin from './pages/Changepin'
import Fundtransfer from './pages/Fundtransfer'
import NewFD from './pages/NewFD'


function App() {
  const auth = useAuth();
  return (
    <Router>
      <div className="App">
      {auth.auth ? <Appbar/> : <NotAuthAppbar/>}
        <div className="outer">
          <div className="inner">
            <Routes>
              <Route exact path="/" element={<Login />} />
              <Route path="/login" element={<Login />} />
              <Route path="/register" element={<Register />} />
              <Route path="/dashboard" element={<DashBoard />} />
              <Route path="/changepin" element={<Changepin/>}/>
              <Route path="/newfd" element={<NewFD/>}/>
              <Route path="/fundtransfer" element={<Fundtransfer/>}/>
            </Routes>
          </div>
        </div>
      </div>
    </Router>
  )
}

export default App