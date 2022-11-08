import React from 'react'
import Container from 'react-bootstrap/Container';
import Navbar from 'react-bootstrap/Navbar';
const NotAuthAppbar = () => {


    return(
      <Navbar bg="dark" variant="dark">
        <Container>
          <Navbar.Brand href="/">Wells Fargo</Navbar.Brand>
        </Container>
      </Navbar>
        )
}

export default NotAuthAppbar;