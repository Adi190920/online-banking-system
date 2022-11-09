import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import {
  MDBContainer,
  MDBRow,
  MDBInput,
  MDBCol,
  MDBCard,
  MDBCardBody,
} from "mdb-react-ui-kit";
import axios from "axios";
import Form from 'react-bootstrap/Form';
import { Button } from 'react-bootstrap';

function OpenNewFD() {
  const [accountnumber, setaccountnumber] = useState(localStorage.getItem("accountnumber"));
  const [amount, setamount] = useState("");
  const [product, setproduct] = useState("");
  const [period, setperiod] = useState("");
  const [message, setMessage] = useState("");
  const [success, setSuccess] = useState("");
  const navigate = useNavigate();

  function handleSubmit(event) {
    event.preventDefault();
    if (amount < 1000) {
      setMessage("Minimum FD amount is 1000");
      setTimeout(() => setMessage("   "), 2000);
    } else {
      
      axios
        .post(`http://localhost:8081/fixeddeposit`, {
          accountnumber,
          amount,
          product,
          period,
        })
        .then((res) => {
          console.log(res);
          setMessage("Fixed Deposit Created");
          // navigate("/dashboard");
          setSuccess("Fixed Deposit Created");
          setTimeout(() => setSuccess("   "), 2000);
          alert("Fixed Deposit Created");
        })
        .catch((err) => {
          console.log(err);
        });
    }
    console.log(accountnumber, amount, product, period);
  }
  return (
    <div style={{ backgroundColor: ' #021946 ' }}>
    <MDBContainer fluid>
      <MDBRow className="d-flex justify-content-center align-items-center h-80">
        <MDBCol col="8">
          <MDBCard
            className="bg-white my-5 mx-auto"
            style={{ borderRadius: "1rem", maxWidth: "450px" }}
          >
            <MDBCardBody className="p-5 w-100 d-flex flex-column">
              <h2 className="fw-bold mb-2 text-center">New Fixed Deposit</h2>
              <form class="text-center border border-light p-5" action="#!">
                <div className="text-danger">
                  {message ? <p>{message}</p> : null}
                </div>
                <div className="text-success">
                  {success ? <p>{success}</p> : null}
                </div>
                <MDBInput wrapperclassName='mb-4 w-100' value = {accountnumber}
                placeholder='Account Number' id='formControlLg' 
                type='text' size="lg" disabled/>
                <br/>
                <Form.Select
                  id="defaultContactFormName"
                  class="browser-default custom-select mb-4"
                  value={product}
                  onChange={(e) => setproduct(e.target.value)}
                >
                  <option value="" disabled selected>Select FD Product</option>
                  <option value="seniorcitizenFD">seniorcitizenFD </option>
                  <option value="normalFD">normalFD </option>
                </Form.Select>
                <br/>
                <Form.Select
                  id="defaultContactFormName"
                  class="browser-default custom-select mb-4"
                  value={period}
                  onChange={(e) => setperiod(e.target.value)}
                >
                  <option value="" disabled selected>
                    Select FD Period
                  </option>
                  <option value="1 year">1 year</option>
                  <option value="3 years">3 years</option>
                  <option value="5 years">5 years</option>
                </Form.Select>
                <br/>
                <MDBInput
                  type="number"
                  id="defaultContactFormName"
                  class="form-control mb-4"
                  placeholder="Amount"
                  value={amount}
                  onChange={(e) => setamount(e.target.value)}
                  required
                />
                <div class="custom-control custom-checkbox mb-4">
                  <input
                    type="checkbox"
                    class="custom-control-input"
                    id="defaultContactFormCopy"
                    checked
                  />
                  <label
                    class="custom-control-label"
                    for="defaultContactFormCopy"
                  >
                    I have read and accepted the terms and conditions
                  </label>
                </div>
                <Button
                  class="btn btn-info btn-block"
                  type="submit"
                  onClick={handleSubmit}
                >
                  Create New FD
                </Button>
              </form>
            </MDBCardBody>
          </MDBCard>
        </MDBCol>
      </MDBRow>
    </MDBContainer>
    </div>
  );
}
export default OpenNewFD;
