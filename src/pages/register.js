import React, { useState, useEffect } from 'react';
import {
  MDBContainer,
  MDBRow,
  MDBCol,
  MDBCard,
  MDBCardBody,
  MDBInput,
  MDBCheckbox,
  
} from 'mdb-react-ui-kit';
import { Button } from 'react-bootstrap';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import axios from "axios";
import Select from 'react-select';
import {  useNavigate } from "react-router-dom";

function App() {
  const [name, setName] = useState("");
  const [middleName, setMiddlename] = useState("");
  const [lastName, setLastname] = useState("");
  const [answer, setAnswer] = useState("");
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [accnumber, setAccnumber] = useState("");
  const [mobno, setMmobno] = useState("");
  const [acctype, setAcctype] = useState("");
  const [message, setMessage] = useState("");
  const [acctypelist, setAcctypelist] = useState([]);
  const navigate = useNavigate();

  

  function validateForm(){
    if(mobno.length != 10 ){
      setMessage("Invalid Mobile Number");
      return false;
    }
    return true;
  }
  useEffect(() => {
    var config = {
      method: 'get',
      url: 'http://localhost:8081/acctype',
      headers: { 
        'Content-Type': 'application/json', 
      }
    };
  
    axios(config)
    .then(function (res) {
      console.log(JSON.stringify(res.data[0].acctypeid));
      // setAcctypelist(res.data);
      const data = res.data;
      for(let i = 0; i < data.length; i++){
        data[i].value  = data[i].acctypeid ;
        data[i].label  = data[i].acctype ;
        delete data[i].acctypeid;
        delete data[i].acctype;
      }
      setAcctypelist(data);
    })
    .catch(function (error) {
      console.log(error);
    });

  }, [])

  function handleSubmit(event){
    event.preventDefault();
    if(!validateForm()){
      return;
    }
    
    var data = JSON.stringify({
      "name" : name, 
      "middlename" : middleName, 
      "lastname" : lastName, 
      "username" : username, 
      "password" : password, 
      "securityanswers" : answer, 
      "mobilenumber" : mobno, 
      "accountnumber" : accnumber,
      "acctypeid" : acctype,
      "securityquestion":"what is your pet name?"
    });
    
    var config = {
      method: 'post',
      url: 'http://localhost:8081/register',
      headers: { 
        'Content-Type': 'application/json', 
      // 'Cookie': 'JSESSIONID=BD47BA85535C131A6AE0A5A78DA1B3D4'
      },
      data : data
    };
  
    axios(config)
    .then(function (res) {
      console.log(JSON.stringify(res.data));
      localStorage.setItem("user", res.data);
      setMessage("Registration successful");
      navigate("/login");
    })
    .catch(function (error) {
      console.log(error);
    });
  
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
                    <Select options={acctypelist} 
                      // value={acctype} 
                      onChange={(e) => {
                        setAcctype(e.value);
                        console.log(acctype);
                      }}
                    />
                   
                  </Form.Group>
              </MDBRow>
              <MDBRow>
                <MDBCol col='4'>
                    <MDBInput wrapperClass='mb-4' 
                      value={accnumber}
                      onChange={(e) => setAccnumber(e.target.value)}
                      Placeholder='Account Number' id='form1' type='text'/>
                </MDBCol>
                <MDBCol col="4">
                    <MDBInput wrapperClass='mb-4' 
                      value={mobno}
                      onChange={(e) => setMmobno(e.target.value)}
                      Placeholder='Mobile Number' id='form1' type='text'/>
                </MDBCol>
              </MDBRow>
              
              <MDBCheckbox name='flexCheck' value='' id='flexCheckDefault' label='Agree Terms & Conditions' />
               
              <Button size="lg" onClick={handleSubmit} >Register</Button>

            </MDBCardBody>
          </MDBCard>

        </MDBCol>

    </MDBRow>

    </MDBContainer>
    
  );
}

export default App;