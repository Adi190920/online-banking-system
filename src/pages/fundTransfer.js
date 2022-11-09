import Select from 'react-select';
import React, { useState, useEffect } from "react";
import {
  
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
  const [sourceaccnumber, setsourceaccnumber] = useState(localStorage.getItem("accountnumber"));
  const [beneficiary, setBeneficiary] = useState("");
  const [destaccnumber, setdestaccnumber] = useState("");
  const [beneficiaryIFSC, setBeneficiaryIFSC] = useState("");
  const [destacctypeid, setdestacctypeid] = useState("");
  const [transferamount, settransferamount] = useState("");
  // const [Remarks, setRemarks] = useState("");
  // const [Check, setCheck] = useState("");
  const [message, setMessage] = useState("");
  const [success, setSuccess] = useState("");
  const [acctypelist, setAcctypelist] = useState([]);
  const navigate = useNavigate();

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



  function handleSubmit(event) {
    console.log(sourceaccnumber, destaccnumber, destacctypeid, transferamount);

    event.preventDefault();
    if (
      sourceaccnumber.length === 0 ||
      destaccnumber.length === 0 ||
      destacctypeid.length === 0
    ) {
      setMessage("Fill all fields");
      setTimeout(() => setMessage("   "), 4000);
    }
    else if (transferamount < 10 || transferamount > 1000000) {
      setMessage(
        "Transfer transferamount Should be between Rs. 10 and Rs. 10 Lakhs"
      );
      setTimeout(() => setMessage("   "), 4000);
    }
    
     else {
      axios
        .post(`http://localhost:8081/fundtransfer`, {
          sourceaccnumber,
          destaccnumber,
          destacctypeid,
          transferamount,
        })
        .then((res) => {
          console.log(res);
          // navigate("/dashboard");
          
      setSuccess("Fund Transfer Completed Successfully");
      setTimeout(() => setSuccess("   "), 4000);
      alert("Fund Transfer Completed Successfully");
      setdestaccnumber("");
      settransferamount('');
        })
        .catch((err) => {
          console.log(err);
          setMessage(err);
          setTimeout(() => setMessage("   "), 4000);
        });
    }

    
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
                <p classNmae="text-left fw-bold">Account Number : {sourceaccnumber}</p>
                

                <input
                  type="number"
                  id="defaultContactFormName"
                  class="form-control mb-4"
                  placeholder="Beneficiary Account Number"
                  value={destaccnumber}
                  onChange={(e) => setdestaccnumber(e.target.value)}
                  required
                />

                
                  <Select options={acctypelist} 
                      // value={acctype} 
                      onChange={(e) => {
                        setdestacctypeid(e.value);
                        // console.log(acctype);
                      }}
                    />
                    <br/>
                <input
                  type="number"
                  id="defaultContactFormName"
                  class="form-control mb-4"
                  placeholder="Transfer Amount"
                  value={transferamount}
                  onChange={(e) => settransferamount(e.target.value)}
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