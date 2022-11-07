import React, {useState }from 'react';
import {
  MDBBtn,
  MDBContainer,
  MDBRow,
  MDBCol,
  MDBCard,
  MDBCardBody,
  MDBInput,
  MDBIcon,
  
}
from 'mdb-react-ui-kit';

import axios from "axios";
import {  useNavigate } from "react-router-dom";

function App() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [message, setMessage] = useState("");

  const navigate = useNavigate();

  function handleSubmit(event){
    event.preventDefault();
    if(username === "hari" && password === "om"){
      localStorage.setItem("username", username);
      localStorage.setItem("password", password);
      setMessage("Login successful");
      navigate("/dashboard");
    }
    else{
      setMessage("Please try again");
      navigate("/");
    }
    // axios
    // .post(`http://localhost:8080/user/login`, { username, password })
    // .then((res) => {
    //   localStorage.setItem("username", res.data.user.username);
    //   setMessage("Login successful");
    //   his.replace("/dashboard");
    // })
    // .catch((err) => {
    //   console.log(err);
    // });
  }
  return (
    <MDBContainer fluid>
      
      <MDBRow className='d-flex justify-content-center align-items-center h-80'>
      
        <MDBCol col='8'>

          <MDBCard className='bg-white my-5 mx-auto' style={{borderRadius: '1rem', maxWidth: '400px'}}>
            <MDBCardBody className='p-5 w-100 d-flex flex-column'>
            <div className="text-danger">{message ? <p>{message}</p> : null}</div>
              <h2 className="fw-bold mb-2 text-center">Login</h2>
              <br/>
              <MDBInput wrapperClass='mb-4 w-100'
                value={username}
                onChange={(e) => setUsername(e.target.value)}
                placeholder='Username' id='formControlLg' 
                type='text' size="lg"/>
              <MDBInput wrapperClass='mb-4 w-100'
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                placeholder='Password' id='formControlLg'
                type='password' size="lg"/>

              

              <MDBBtn size='lg'
                onClick={handleSubmit}
                >Login </MDBBtn>
              
              <hr className="my-4" />
              <div className="text-center">
        <p>Not a member? <a href="/register">Register</a></p>
        </div>

              <div className="text-center">

                <p>or login with:</p>

                <MDBBtn tag='a' color='none' className='mx-3' style={{ color: '#1266f1' }}>
                  <MDBIcon fab icon='facebook-f' size="sm"/>
                </MDBBtn>

                <MDBBtn tag='a' color='none' className='mx-3' style={{ color: '#1266f1' }}>
                  <MDBIcon fab icon='twitter' size="sm"/>
                </MDBBtn>

                <MDBBtn tag='a' color='none' className='mx-3' style={{ color: '#1266f1' }}>
                  <MDBIcon fab icon='google' size="sm"/>
                </MDBBtn>

                <MDBBtn tag='a' color='none' className='mx-3' style={{ color: '#1266f1' }}>
                  <MDBIcon fab icon='github' size="sm"/>
                </MDBBtn>

              </div>

            </MDBCardBody>
          </MDBCard>

        </MDBCol>
      </MDBRow>

    </MDBContainer>
  );
}

export default App;