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
    
    const pinchange = async() =>{
      navigate('/changePin');
     
  }
    

    return(
      <Navbar bg="light" variant="light">
      <Container>
        <Navbar.Brand href="/">{auth.user.username}</Navbar.Brand>
        {/* to add onclick */}
        <Button variant="outline-dark">Check Balance</Button>
        <Button variant="outline-dark">Fund Transfer</Button>
        <Button variant="outline-dark">Open New FD</Button>
        <Button variant="outline-dark">Events</Button>
        <Button variant="outline-dark" onClick={pinchange}>Change Pin</Button>
        <Button variant="dark" onClick={logout}>Logout</Button>
      </Container>
    </Navbar>
      )
}

export default Appbar;

