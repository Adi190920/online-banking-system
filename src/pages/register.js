import React, { useState, useEffect } from "react";
import {
  MDBBtn,
  MDBContainer,
  MDBRow,
  MDBCol,
  MDBCard,
  MDBCardBody,
  MDBInput,
  MDBCheckbox,
} from "mdb-react-ui-kit";
import { Button } from "react-bootstrap";
import Col from "react-bootstrap/Col";
import Form from "react-bootstrap/Form";
import axios from "axios";
import { useNavigate } from "react-router-dom";

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

  const navigate = useNavigate();

  function validateForm() {
    if (mobno.length != 10) {
      setMessage("Invalid Mobile Number");
      return false;
    }
    // else if(accnumber.length != 11){
    //   setMessage("Invalid Account Number");
    //   return false;
    // }
    return true;
  }

  function handleSubmit(event) {
    event.preventDefault();
    if (!validateForm()) {
      return;
    }

    var data = JSON.stringify({
      name: name,
      middlename: middleName,
      lastname: lastName,
      username: username,
      password: password,
      securityquestions: "What is your pet name",
      securityanswers: answer,
      mobilenumber: mobno,
      accountnumber: accnumber,
      acctypeid: 1,
    });

    var config = {
      method: "post",
      url: "http://localhost:8081/register",
      headers: {
        "Content-Type": "application/json",
        // 'Cookie': 'JSESSIONID=BD47BA85535C131A6AE0A5A78DA1B3D4'
      },
      data: data,
    };

    axios(config)
      .then(function (res) {
        console.log(JSON.stringify(res.data));
        localStorage.setItem("user", res.data);
        // console.log(localStorage.getItem("user"));
        setMessage("Registration successful");
        navigate("/login");
      })
      .catch(function (error) {
        console.log(error);
      });
  }

  return (
    <div style={{ backgroundColor: " #021946 " }}>
      <MDBContainer fluid>
        <MDBRow className="d-flex justify-content-center align-items-center h-80">
          <MDBCol md="6">
            <MDBCard className="my-5">
              <MDBCardBody className="p-5">
                <h2 className="fw-bold mb-2 text-center">Register</h2>
                <br />
                <MDBRow>
                  <MDBCol col="4">
                    <MDBInput
                      wrapperClass="mb-4"
                      value={name}
                      onChange={(e) => setName(e.target.value)}
                      Placeholder="First name"
                      id="form1"
                      type="text"
                    />
                  </MDBCol>
                  <MDBCol col="4">
                    <MDBInput
                      wrapperClass="mb-4"
                      value={middleName}
                      onChange={(e) => setMiddlename(e.target.value)}
                      Placeholder="Middle name"
                      id="form1"
                      type="text"
                    />
                  </MDBCol>
                  <MDBCol col="4">
                    <MDBInput
                      wrapperClass="mb-4"
                      value={lastName}
                      onChange={(e) => setLastname(e.target.value)}
                      Placeholder="Last name"
                      id="form1"
                      type="text"
                    />
                  </MDBCol>
                </MDBRow>

                <MDBRow>
                  <MDBCol col="4">
                    <MDBInput
                      wrapperClass="mb-4"
                      value={username}
                      onChange={(e) => setUsername(e.target.value)}
                      Placeholder="Username"
                      id="form1"
                      type="text"
                    />
                  </MDBCol>
                  <MDBCol col="4">
                    <MDBInput
                      wrapperClass="mb-4"
                      value={password}
                      onChange={(e) => setPassword(e.target.value)}
                      Placeholder="Password"
                      id="form1"
                      type="password"
                    />
                  </MDBCol>
                </MDBRow>
                <MDBRow>
                  <MDBCol col="4">
                    <MDBInput
                      wrapperClass="mb-4"
                      value={answer}
                      onChange={(e) => setAnswer(e.target.value)}
                      Placeholder="What is your pet name?"
                      id="form1"
                      type="text"
                    />
                  </MDBCol>
                  <Form.Group as={Col} controlId="formGridState">
                    <Form.Select defaultValue="Select Account Type...">
                      <option>Select Account Type...</option>
                      <option value="1">Savings</option>
                      <option value="2">Current</option>
                      <option value="3">Retirement</option>
                    </Form.Select>
                  </Form.Group>
                </MDBRow>
                <MDBRow>
                  <MDBCol col="4">
                    <MDBInput
                      wrapperClass="mb-4"
                      value={accnumber}
                      onChange={(e) => setAccnumber(e.target.value)}
                      Placeholder="Account Number"
                      id="form1"
                      type="text"
                    />
                  </MDBCol>
                  <MDBCol col="4">
                    <MDBInput
                      wrapperClass="mb-4"
                      value={mobno}
                      onChange={(e) => setMmobno(e.target.value)}
                      Placeholder="Mobile Number"
                      id="form1"
                      type="text"
                    />
                  </MDBCol>
                </MDBRow>

                <MDBCheckbox
                  name="flexCheck"
                  value=""
                  id="flexCheckDefault"
                  label="Agree Terms & Conditions"
                />

                <MDBBtn size="lg" onClick={handleSubmit}>
                  Register
                </MDBBtn>
              </MDBCardBody>
            </MDBCard>
          </MDBCol>
        </MDBRow>
      </MDBContainer>
    </div>
  );
}

export default App;
