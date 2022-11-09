import Container from 'react-bootstrap/Container';
import Navbar from 'react-bootstrap/Navbar';
import React from 'react';
const NotAuthAppbar = () => {


    return(
        <Navbar bg="dark" variant="dark">
        <Container>
          <Navbar.Brand href="/">Online Banking Application</Navbar.Brand>
          <Navbar.Brand href="/eventsAvailable">Events </Navbar.Brand>
        </Container>
      </Navbar>
        )
}

export default NotAuthAppbar;