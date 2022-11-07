import React from 'react'
import Container from 'react-bootstrap/Container';
import Navbar from 'react-bootstrap/Navbar';
const NotAuthAppbar = () => {


    return(
        <Navbar bg="light" variant="light">
        <Container>
          <Navbar.Brand href="/">Login First</Navbar.Brand>
        </Container>
      </Navbar>
        )
}

export default NotAuthAppbar;