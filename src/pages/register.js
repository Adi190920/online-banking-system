import React, { useState } from 'react';
import {
  MDBBtn,
  MDBContainer,
  MDBRow,
  MDBCol,
  MDBCard,
  MDBCardBody,
  MDBInput,
  MDBCheckbox,
  
} from 'mdb-react-ui-kit';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import {  useNavigate } from "react-router-dom";

function App() {
  const [name, setName] = useState("");
  const [middleName, setMiddlename] = useState("");
  const [lastName, setLastname] = useState("");
  const [answer, setAnswer] = useState("");
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [message, setMessage] = useState("");

  const navigate = useNavigate();
  function handleSubmit(event){
    event.preventDefault();
    if(username === "hari" && password === "om"){
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
        <MDBContainer fluid >
        <MDBRow className='d-flex justify-content-center align-items-center h-80'>
        <MDBCol md='6'>

          <MDBCard className='my-5'>
            <MDBCardBody className='p-5'>
            <h2 className="fw-bold mb-2 text-center">Register</h2>
            <br/>
              <MDBRow>
                <MDBCol col='4'>
                  <MDBInput wrapperClass='mb-4' 
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                    Placeholder='First name' id='form1' type='text'/>
                </MDBCol>
                <MDBCol col='4'>
                  <MDBInput wrapperClass='mb-4' 
                    value={middleName}
                    onChange={(e) => setMiddlename(e.target.value)}
                    Placeholder='Middle name' id='form1' type='text'/>
                </MDBCol>
                <MDBCol col='4'>
                  <MDBInput wrapperClass='mb-4' 
                    value={lastName}
                    onChange={(e) => setLastname(e.target.value)}
                    Placeholder='Last name' id='form1' type='text'/>
                </MDBCol>
              </MDBRow>

              <MDBRow>
                <MDBCol col='4'>
                  <MDBInput wrapperClass='mb-4' 
                    value={username}
                    onChange={(e) => setUsername(e.target.value)}
                    Placeholder='Username' id='form1' type='text'/>
                </MDBCol>
                <MDBCol col='4'>
                  <MDBInput wrapperClass='mb-4' 
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                    Placeholder='Password' id='form1' type='password'/>
                </MDBCol>
              </MDBRow>
              <MDBRow>
                <MDBCol col='4'>
                    <MDBInput wrapperClass='mb-4' 
                      value={answer}
                      onChange={(e) => setAnswer(e.target.value)}
                      Placeholder='What is your pet name?' id='form1' type='text'/>
                </MDBCol>
                  <Form.Group as={Col} controlId="formGridState">
                    <Form.Select defaultValue="Select Account Type...">
                      <option>Select Account Type...</option>
                      <option>...</option>
                    </Form.Select>
                  </Form.Group>
              </MDBRow>
              <MDBRow>
                <MDBCol col='4'>
                    <MDBInput wrapperClass='mb-4' 
                      value={answer}
                      onChange={(e) => setAnswer(e.target.value)}
                      Placeholder='Account Number' id='form1' type='text'/>
                </MDBCol>
                <MDBCol col="4">
                    <MDBInput wrapperClass='mb-4' 
                      value={answer}
                      onChange={(e) => setAnswer(e.target.value)}
                      Placeholder='Mobile Number' id='form1' type='text'/>
                </MDBCol>
              </MDBRow>
              
              <MDBCheckbox name='flexCheck' value='' id='flexCheckDefault' label='Agree Terms & Conditions' />
               
                <MDBBtn size='lg'
                onClick={handleSubmit}
                >Register</MDBBtn>

            </MDBCardBody>
          </MDBCard>

        </MDBCol>

    </MDBRow>

    </MDBContainer>
  );
}

export default App;