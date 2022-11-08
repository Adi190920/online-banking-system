import React, { useState } from 'react';
import {  useNavigate } from "react-router-dom";
import {
    MDBBtn,
    MDBContainer,
    MDBRow,
    MDBCol,
    MDBCard,
    MDBCardBody,
    MDBInputGroup
  } from 'mdb-react-ui-kit';

function openNewFD() {
    const [accnum, setAccnum] = useState("");
    const [Amount, setAmount] = useState("");
    const [message, setMessage] = useState("");
    const [success, setSuccess] = useState("");
    const navigate = useNavigate();
    function handleSubmit(event){
        event.preventDefault();
        if(accnum.length!= 11){
            setMessage("Account number should be 11 digits");
            setTimeout(() => setMessage("   "), 4000);
          }
          else if(Amount<1000){
            setMessage("Minimum FD Amount is 1000");
            setTimeout(() => setMessage("   "), 4000);
          }
          else{
            setSuccess("Fixed Deposit Created")
            alert("Fixed Deposit Created")
          }
    }
    return (
      <div style={{ backgroundColor: '#D41C2C' }}>
        <MDBContainer fluid>
      
        <MDBRow className='d-flex justify-content-center align-items-center h-80'>
        
        <MDBCol col='8'>
            <MDBCard className='bg-white my-5 mx-auto' style={{borderRadius: '1rem', maxWidth: '450px'}}>
              <MDBCardBody className='p-5 w-100 d-flex flex-column'>
              <h2 className="fw-bold mb-2 text-center">New Fixed Deposit</h2>
        <form className="text-center border border-light p-5" action="#!">

        <div className="text-danger">{message ? <p>{message}</p> : null}</div>
        <div className="text-success">{success ? <p>{success}</p> : null}</div>
        <input type="text" id="defaultContactFormName" value={accnum}
                onChange={(e) => setAccnum(e.target.value)} className="form-control mb-4" placeholder="Account Number" required/>
        <select className="browser-default custom-select mb-4">
            <option value="" disabled selected>Select FD Product</option>
            <option value="1">FD Product 1 </option>
            <option value="2">FD Product 2 </option>
            <option value="3">FD Product 3</option>
        </select>
        <select className="browser-default custom-select mb-4">
            <option value="" disabled selected>Select FD Period</option>
            <option value="1">1 year</option>
            <option value="2">3 years</option>
            <option value="3">5+ years</option>
        </select>

        <input type="number" id="defaultContactFormName" className="form-control mb-4" placeholder="Amount"value={Amount}
                onChange={(e) => setAmount(e.target.value)} required /> 
        <div className="custom-control custom-checkbox mb-4">
            <input type="checkbox" className="custom-control-input" id="defaultContactFormCopy" checked/ >
            <label className="custom-control-label" for="defaultContactFormCopy" >I have read and accepted the terms and conditions</label>
        </div>
<<<<<<< Updated upstream
        <button className="btn btn-info btn-block" type="submit" onClick={handleSubmit}>Transfer</button>
=======
        <MDBBtn size='lg'color='warning'onClick={handleSubmit}>Change Pin </MDBBtn>  
        {/* <button class="btn btn-warning btn-lg" type="submit" onClick={handleSubmit}>Transfer</button> */}
>>>>>>> Stashed changes
        </form>
        </MDBCardBody>
        </MDBCard>
        </MDBCol>
        </MDBRow>
    </MDBContainer>
    </div>
    );
}
export default openNewFD;