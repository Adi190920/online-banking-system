import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import {
  MDBBtn,
  MDBContainer,
  MDBRow,
  MDBCol,
  MDBCard,
  MDBCardBody,
  MDBInputGroup,
} from "mdb-react-ui-kit";
import axios from "axios";

function OpenNewFD() {
  const [accountnumber, setaccountnumber] = useState("");
  const [amount, setamount] = useState("");
  const [product, setproduct] = useState("");
  const [period, setperiod] = useState("");
  const [message, setMessage] = useState("");
  const [success, setSuccess] = useState("");
  const navigate = useNavigate();

  function handleSubmit(event) {
    event.preventDefault();
    if (accountnumber.length !== 11) {
      setMessage("Account number should be 11 digits");
      setTimeout(() => setMessage("   "), 4000);
    } else if (amount < 1000) {
      setMessage("Minimum FD amount is 1000");
      setTimeout(() => setMessage("   "), 4000);
    } else {
      setSuccess("Fixed Deposit Created");
      alert("Fixed Deposit Created");
      axios
        .post(`http://localhost:8081/fixeddeposit`, {
          accountnumber,
          amount,
          product,
          period,
        })
        .then((res) => {
          console.log(res);
          setMessage("Login successful");
          navigate("/dashboard");
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
                <input
                  type="text"
                  id="defaultContactFormName"
                  value={accountnumber}
                  onChange={(e) => setaccountnumber(e.target.value)}
                  class="form-control mb-4"
                  placeholder="Account Number"
                  required
                />
                <select
                  id="defaultContactFormName"
                  class="browser-default custom-select mb-4"
                  value={product}
                  onChange={(e) => setproduct(e.target.value)}
                >
                  <option value="" disabled selected>
                    Select FD Product
                  </option>
                  <option value="seniorcitizenFD">seniorcitizenFD </option>
                  <option value="normalFD">normalFD </option>
                </select>
                <select
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
                </select>

<<<<<<< Updated upstream
        <input type="number" id="defaultContactFormName" className="form-control mb-4" placeholder="Amount"value={Amount}
                onChange={(e) => setAmount(e.target.value)} required /> 
        <div className="custom-control custom-checkbox mb-4">
            <input type="checkbox" className="custom-control-input" id="defaultContactFormCopy" checked/ >
            <label className="custom-control-label" for="defaultContactFormCopy" >I have read and accepted the terms and conditions</label>
        </div>
        <button className="btn btn-info btn-block" type="submit" onClick={handleSubmit}>Transfer</button>
        </form>
        </MDBCardBody>
        </MDBCard>
=======
                <input
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
                <button
                  class="btn btn-info btn-block"
                  type="submit"
                  onClick={handleSubmit}
                >
                  Create New FD
                </button>
              </form>
            </MDBCardBody>
          </MDBCard>
>>>>>>> Stashed changes
        </MDBCol>
      </MDBRow>
    </MDBContainer>
    </div>
  );
}
export default OpenNewFD;
