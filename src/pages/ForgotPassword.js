import React, { useState } from "react";
import {
  MDBContainer,
  MDBRow,
  MDBCol,
  MDBCard,
  MDBCardBody,
  MDBInput,
} from "mdb-react-ui-kit";
import { Button } from "react-bootstrap";
import axios from "axios";
import { useNavigate } from "react-router-dom";

function ForgotPassword() {
  const [username, setUsername] = useState("");
  const [accountnumber, setAccountnumber] = useState("");
  const [answer, setAnswer] = useState("");
  const [password, setPassword] = useState("");
  const [message, setMessage] = useState("");

  const navigate = useNavigate();

  function handleSubmit(event) {
    event.preventDefault();

    var data = JSON.stringify({ 
        username: username, 
        accountnumber: accountnumber,
        securityquestions: "What is your pet name",
        securityanswers: answer, 
        newpassword: password 
    });

    var config = {
      method: "post",
      url: "http://localhost:8081/reset",
      headers: {
        "Content-Type": "application/json",
        // 'Cookie': 'JSESSIONID=BD47BA85535C131A6AE0A5A78DA1B3D4'
      },
      data: data,
    };

    axios(config)
      .then(function (res) {
        // console.log(res.data);
        alert("Password reset successfully");
        navigate("/login");
      })
      .catch(function (error) {
        console.log(error);
        // console.log(error.response.data[" errorMessage "]);
        setMessage("Something went wrong");
        // setMessage(error.response.data[" errorMessage "]);
        setTimeout(() => setMessage("   "), 2000);
        // setMessage("Invalid Username and Password");
      });
  }
  return (
    <div style={{ backgroundColor: " #021946 " }}>
      <MDBContainer fluid>
        <MDBRow className="d-flex justify-content-center align-items-center h-80">
          <MDBCol col="8">
            <MDBCard
              className="bg-white my-5 mx-auto"
              style={{ borderRadius: "1rem", maxWidth: "400px" }}
            >
              <MDBCardBody className="p-5 w-100 d-flex flex-column">
                <div className="text-danger">
                  {message ? <p>{message}</p> : null}
                </div>
                <h2 className="fw-bold mb-2 text-center">Reset Password</h2>
                <br />
                <MDBInput
                  wrapperClass="mb-4 w-100"
                  value={username}
                  onChange={(e) => setUsername(e.target.value)}
                  placeholder="Username"
                  id="formControlLg"
                  type="text"
                  size="lg"
                />
                <MDBInput
                  wrapperClass="mb-4 w-100"
                  value={accountnumber}
                  onChange={(e) => setAccountnumber(e.target.value)}
                  placeholder="Account Number"
                  id="formControlLg"
                  type="text"
                  size="lg"
                />
                <MDBInput
                  wrapperClass="mb-4 w-100"
                  value={answer}
                  onChange={(e) => setAnswer(e.target.value)}
                  placeholder="What is your pet name?"
                  id="formControlLg"
                  type="text"
                  size="lg"
                />
                <MDBInput
                  wrapperClass="mb-4 w-100"
                  value={password}
                  onChange={(e) => setPassword(e.target.value)}
                  placeholder="New Password"
                  id="formControlLg"
                  type="password"
                  size="lg"
                />

                <Button size="lg" onClick={handleSubmit}>
                  Reset Password
                </Button>
              </MDBCardBody>
            </MDBCard>
          </MDBCol>
        </MDBRow>
      </MDBContainer>
    </div>
  );
}

export default ForgotPassword;
