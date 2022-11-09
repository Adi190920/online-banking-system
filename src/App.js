import React from 'react'
import '../node_modules/bootstrap/dist/css/bootstrap.min.css'
import './App.css'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'

import Login from './pages/login'

import Register from './pages/register'
import Appbar from './pages/AppBar'
import Changepin from './pages/changePin'
import EventsAvailable from './pages/event'
import FundTransfer from './pages/fundTransfer'
import ForgotPassword from './pages/ForgotPassword'
import OpenNewFD from './pages/openNewFD'
import CheckBalance from './pages/checkBalance'
import RequireAuth from './pages/RequireAuth'
function App() {
  return (
    <Router>
      <div className="App">
      {/* {auth.auth ? <Appbar/> : <NotAuthAppbar/>} */}
      <Appbar/>
        <div className="outer">
          <div className="inner">
            <Routes>
              <Route exact path="/" element={<Login />} />
              <Route path="/login" element={<Login />} />
              <Route path="/register" element={<Register />} />
              <Route path="/forgotpassword" element={<ForgotPassword />} />
              <Route element={<RequireAuth/>}>
                <Route path="/changePin" element={<Changepin />} />
                <Route path="/checkBalance" element={<CheckBalance />} />
                <Route path="/fundTransfer" element={<FundTransfer />} />
                <Route path="/openNewFD" element={<OpenNewFD />} />
              </Route>
              <Route path="/EventsAvailable" element={<EventsAvailable />} />
              </Routes>
          </div>
        </div>
      </div>
    </Router>
  )
}

export default App