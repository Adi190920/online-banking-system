import Container from 'react-bootstrap/Container';
import Navbar from 'react-bootstrap/Navbar';
// import axios from "axios";
import useAuth from '../hooks/auth'
import React from 'react';
import { useNavigate,Route} from 'react-router-dom';
import Button from 'react-bootstrap/Button';



const Appbar = () => {

    const auth = useAuth();
    const navigate = useNavigate();

    const logout = async() =>{
        navigate('/login');
        localStorage.removeItem("username");
        localStorage.removeItem("accountnumber");
    }
  
    

    return(
      <Navbar bg="dark" variant="dark">
      <Container>
      {localStorage.getItem("username") ? 
        <Navbar.Brand href="/checkBalance">{localStorage.getItem("username")}</Navbar.Brand> :
        <Navbar.Brand href="/login">Online Banking Application</Navbar.Brand>  
    }
        
        {/* <Navbar.Brand href="/checkBalance">Online Banking Application</Navbar.Brand> */}
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

