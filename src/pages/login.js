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
import { Button } from 'react-bootstrap';
import axios from "axios";
import {  useNavigate } from "react-router-dom";

function App() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [message, setMessage] = useState("");

  const navigate = useNavigate();

  function handleSubmit(event){
    event.preventDefault();
    var data = JSON.stringify({"username": username,"password": password});

    var config = {
      method: 'post',
      url: 'http://localhost:8081/login',
      headers: { 
        'Content-Type': 'application/json', 
      // 'Cookie': 'JSESSIONID=BD47BA85535C131A6AE0A5A78DA1B3D4'
      },
      data : data
    };

    axios(config)
    .then(function (res) {
      // console.log(res.data);
      localStorage.setItem("username", res.data.username);
      localStorage.setItem("accountnumber", res.data.accountnumber);
      console.log(localStorage.getItem("user"));
      setMessage("Login successful");
      navigate("/checkBalance");
    })
    .catch(function (error) {
      console.log(error);
      setMessage("Invalid Username and Password");
    });



  }
  return (
  
    <MDBContainer fluid>
      {/* <script src="https://apis.google.com/js/platform.js" async defer> */}
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
              

              <Button size="lg" onClick={handleSubmit} >Login</Button>
              
              <hr className="my-4" />
              <div className="text-center">
        <p>Not a member? <a href="/register">Register</a></p>
        </div>

              <div className="text-center">

                <p>or login with:</p>
                {/* <div class="g-signin2" data-onsuccess="onSignIn">hi</div> */}
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