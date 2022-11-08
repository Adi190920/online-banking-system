import Container from 'react-bootstrap/Container';
import Navbar from 'react-bootstrap/Navbar';
import axios from "axios";
import useAuth from '../hooks/auth'
import React from 'react';
import { useNavigate} from 'react-router-dom';
import Button from 'react-bootstrap/Button';
const NotAuthAppbar = () => {


    return(
<<<<<<< Updated upstream
      <Navbar bg="dark" variant="dark">
        <Container>
          <Navbar.Brand href="/">Wells Fargo</Navbar.Brand>
=======
        <Navbar bg="dark" variant="dark">
        <Container>
          <Navbar.Brand href="/">Online Banking Application</Navbar.Brand>
          <Navbar.Brand href="/eventsAvailable">Events </Navbar.Brand>
>>>>>>> Stashed changes
        </Container>
      </Navbar>
        )
}

export default NotAuthAppbar;