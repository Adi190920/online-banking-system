import React, { useState } from 'react';
import {
  MDBBtn,
  MDBContainer,
  MDBRow,
  MDBCol,
  MDBCard,
  MDBCardBody,
  MDBInput,
  // MDBSelect,
  
}
from 'mdb-react-ui-kit';
import {  useNavigate } from "react-router-dom";
// import {MDBSelect} from 'mdbreact';
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
            
              <MDBRow>
                <MDBCol col='4'>
                  <MDBInput wrapperClass='mb-4' 
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                    label='First name' id='form1' type='text'/>
                </MDBCol>
                <MDBCol col='4'>
                  <MDBInput wrapperClass='mb-4' 
                    value={middleName}
                    onChange={(e) => setMiddlename(e.target.value)}
                    label='Middle name' id='form1' type='text'/>
                </MDBCol>
                <MDBCol col='4'>
                  <MDBInput wrapperClass='mb-4' 
                    value={lastName}
                    onChange={(e) => setLastname(e.target.value)}
                    label='Last name' id='form1' type='text'/>
                </MDBCol>
              </MDBRow>

              <MDBRow>
                <MDBCol col='4'>
                  <MDBInput wrapperClass='mb-4' 
                    value={username}
                    onChange={(e) => setUsername(e.target.value)}
                    label='Username' id='form1' type='text'/>
                </MDBCol>
                <MDBCol col='4'>
                  <MDBInput wrapperClass='mb-4' 
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                    label='Password' id='form1' type='password'/>
                </MDBCol>
              </MDBRow>
              <MDBRow>
                <MDBCol col='4'>
                  <p className="text-black-50 mb-">What is your pet name?</p>
                </MDBCol>
                <MDBCol col="4">
                    <MDBInput wrapperClass='mb-4' 
                      value={answer}
                      onChange={(e) => setAnswer(e.target.value)}
                      label='Answer' id='form1' type='text'/>
                </MDBCol>
              </MDBRow>
                  {/* <MDBSelect
                    data={[
                      { text: 'Gender', value: 1, disabled: true },
                      { text: 'Female', value: 2 },
                      { text: 'Male', value: 3 }
                    ]}
                    /> */}
                

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