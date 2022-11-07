import Container from 'react-bootstrap/Container';
import Navbar from 'react-bootstrap/Navbar';
import axios from "axios";
import useAuth from '../hooks/auth'
import React from 'react';
import { useNavigate } from 'react-router-dom';
import Button from 'react-bootstrap/Button';



const Appbar = () => {

    const auth = useAuth();
    const navigate = useNavigate();

    const logout = async() =>{
        navigate('/login');
        // await axios.get("http://localhost:8080/api/logout/",{withCredentials:true})
        // .then(res => {
        //     console.log(res.data);
        //     navigate('/login');
        //     return;
        // })
        
    }
  
    

    return(
      <Navbar bg="light" variant="light">
      <Container>
        <Navbar.Brand href="/">{auth.user.username}</Navbar.Brand>
        <Navbar.Brand href="/openNewFD">Open New FD</Navbar.Brand>
        <Navbar.Brand href="/fundTransfer">Fund Transfer</Navbar.Brand>
        <Navbar.Brand href="/checkBalance">Check Balance</Navbar.Brand>
        <Navbar.Brand href="/eventsAvailable">Events</Navbar.Brand>
        <Navbar.Brand href="/changePin">Change Pin</Navbar.Brand>

        <Button variant="dark" onClick={logout}>Logout</Button>
      </Container>
    </Navbar>
      )
}

export default Appbar;

