import React, { useState } from "react";
import {
  MDBBtn,
  MDBContainer,
  MDBRow,
  MDBCol,
  MDBCard,
  MDBCardBody,
  MDBInput,
} from "mdb-react-ui-kit";
import { useNavigate } from "react-router-dom";
import axios from "axios";

function FundTransfer() {
  const [sourceaccnumber, setsourceaccnumber] = useState("");
  const [beneficiary, setBeneficiary] = useState("");
  const [destaccnumber, setdestaccnumber] = useState("");
  const [beneficiaryIFSC, setBeneficiaryIFSC] = useState("");
  const [destacctypeid, setdestacctypeid] = useState("");
  const [transferamount, settransferamount] = useState("");
  const [Remarks, setRemarks] = useState("");
  const [Check, setCheck] = useState("");
  const [message, setMessage] = useState("");
  const [success, setSuccess] = useState("");

  const navigate = useNavigate();

  function handleSubmit(event) {
    console.log(sourceaccnumber, destaccnumber, destacctypeid, transferamount);

    event.preventDefault();
    if (sourceaccnumber.length != 11) {
      setMessage("Account number should be 11 digits");
      setTimeout(() => setMessage("   "), 4000);
    } else if (destaccnumber.length != 11) {
      setMessage("Beneficiary Account number should be 11 digits");
      setTimeout(() => setMessage("   "), 4000);
    } else if (transferamount < 10 || transferamount > 1000000) {
      setMessage(
        "Transfer transferamount Should be between Rs. 10 and Rs. 10 Lakhs"
      );
      setTimeout(() => setMessage("   "), 4000);
    }
    if (
      sourceaccnumber.length === 0 ||
      beneficiary.length === 0 ||
      destaccnumber.length === 0 ||
      beneficiaryIFSC.length === 0 ||
      destacctypeid.length === 0
    ) {
      setMessage("Fill all fields");
      setTimeout(() => setMessage("   "), 4000);
    }
    //does not work
    else if (Check.checked === false) {
      setMessage("Accept the terms and condition");
      setTimeout(() => setMessage("   "), 4000);
    } else {
      axios
        .post(`http://localhost:8081/fundtransfer`, {
          sourceaccnumber,
          destaccnumber,
          destacctypeid,
          transferamount,
        })
        .then((res) => {
          console.log(res);
          navigate("/dashboard");
        })
        .catch((err) => {
          console.log(err);
        });
      setSuccess("Fund Transfer Completed Successfully");
      alert("Fund Transfer Completed Successfully");
    }

    // axios
    //   .post(`http://localhost:8081/login`, { username, password })
    //   .then((res) => {
    //     setMessage("Login successful");
    //     navigate("/dashboard");
    //     localStorage.setItem("username", res.data.user.username);
    //   })
    //   .catch((err) => {
    //     console.log(err);
    //   });
  }

  return (
    <div style={{ backgroundColor: ' #021946 '}}>
    <MDBContainer fluid>
      <MDBRow className="d-flex justify-content-center align-items-center h-80">
        <MDBCol col="8">
          <MDBCard
            className="bg-white my-5 mx-auto"
            style={{ borderRadius: "1rem", maxWidth: "600px" }}
          >
            <MDBCardBody className="p-5 w-100 d-flex flex-column">
              <h2 className="fw-bold mb-2 text-center">Fund Transfer</h2>
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
                  value={sourceaccnumber}
                  onChange={(e) => setsourceaccnumber(e.target.value)}
                  class="form-control mb-4"
                  placeholder="Account Number"
                  required
                />
                <select
                  class="browser-default custom-select mb-4"
                  value={beneficiary}
                  onChange={(e) => setBeneficiary(e.target.value)}
                >
                  <option value="" disabled selected>
                    Select Beneficiary
                  </option>
                  <option value="1">Beneficiary 1</option>
                  <option value="2">Beneficiary 2</option>
                  <option value="3">Beneficiary 3</option>
                </select>

                <input
                  type="number"
                  id="defaultContactFormName"
                  class="form-control mb-4"
                  placeholder="Beneficiary Account Number"
                  value={destaccnumber}
                  onChange={(e) => setdestaccnumber(e.target.value)}
                  required
                />

                <input
                  type="number"
                  id="defaultContactFormName"
                  class="form-control mb-4"
                  placeholder="Beneficiary IFSC Code"
                  value={beneficiaryIFSC}
                  onChange={(e) => setBeneficiaryIFSC(e.target.value)}
                  required
                />

                <select
                  class="browser-default custom-select mb-4"
                  value={destacctypeid}
                  onChange={(e) => setdestacctypeid(e.target.value)}
                  required
                >
                  <option value="" disabled selected>
                    Select Beneficiary Account Type
                  </option>
                  <option value="1">Savings</option>
                  <option value="2">Current</option>
                  <option value="3">Retirement</option>
                </select>
                <input
                  type="number"
                  id="defaultContactFormName"
                  class="form-control mb-4"
                  placeholder="Transfer Amount"
                  value={transferamount}
                  onChange={(e) => settransferamount(e.target.value)}
                  required
                />

                <div class="form-group">
                  <textarea
                    class="form-control rounded-0"
                    id="exampleFormControlTextarea2"
                    rows="1"
                    placeholder="Remarks"
                    value={Remarks}
                    onChange={(e) => setRemarks(e.target.value)}
                    required
                  ></textarea>
                </div>

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
                  Transfer
                </button>
              </form>
            </MDBCardBody>
          </MDBCard>
        </MDBCol>
      </MDBRow>
    </MDBContainer>
    </div>
  );
}

export default FundTransfer;
