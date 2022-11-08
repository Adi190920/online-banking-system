import React, {useState }from 'react';
import {
    MDBBtn,
    MDBContainer,
    MDBRow,
    MDBCol,
    MDBCard,
    MDBCardBody,
    MDBInput
  } from 'mdb-react-ui-kit';
  import {  useNavigate } from "react-router-dom";
    
function fundTransfer() {
    const [accnum, setAccnum] = useState("");
    const [beneficiary, setBeneficiary] = useState("");
    const [beneficiaryAcc, setBeneficiaryAcc] = useState("");
    const [beneficiaryIFSC, setBeneficiaryIFSC] = useState("");
    const [beneficiaryAccType, setBeneficiaryAccType] = useState("");
    const [Amount, setAmount] = useState("");
    const [Remarks, setRemarks] = useState("");
    const [Check, setCheck] = useState("");
    const [message, setMessage] = useState("");
    const [success, setSuccess] = useState("");
  
    const navigate = useNavigate();
  
    function handleSubmit(event){
      event.preventDefault();
      if(accnum.length!= 11){
        setMessage("Account number should be 11 digits");
        setTimeout(() => setMessage("   "), 4000);
      }
      else if(beneficiaryAcc.length!= 11){
        setMessage("Beneficiary Account number should be 11 digits");
        setTimeout(() => setMessage("   "), 4000);
      }
      else if(Amount<10 ||Amount>1000000 ){
        setMessage("Transfer Amount Should be between Rs. 10 and Rs. 10 Lakhs");
        setTimeout(() => setMessage("   "), 4000);
      }
      if(accnum.length === 0 ||beneficiary.length ===0 || beneficiaryAcc.length === 0 || beneficiaryIFSC.length ===0 || beneficiaryAccType.length ===0) {
        setMessage("Fill all fields");
        setTimeout(() => setMessage("   "), 4000);
      }
      //does not work
      else if(Check.checked === false) {
        setMessage("Accept the terms and condition");
        setTimeout(() => setMessage("   "), 4000);
      }
      else{
        setSuccess("Fund Transfer Completed Successfully")
        alert("Fund Transfer Completed Successfully")
      }
    }

return(
  <div style={{ backgroundColor: '#D41C2C' }}>
  <MDBContainer fluid>
      
  <MDBRow className='d-flex justify-content-center align-items-center h-80'>
  
  <MDBCol col='8'>
      <MDBCard className='bg-white my-5 mx-auto' style={{borderRadius: '1rem', maxWidth: '600px'}}>
        <MDBCardBody className='p-5 w-100 d-flex flex-column'>
        <h2 className="fw-bold mb-2 text-center">Fund Transfer</h2>
    <form className="text-center border border-light p-5" action="#!" >

        <div className="text-danger">{message ? <p>{message}</p> : null}</div>
        <div className="text-success">{success ? <p>{success}</p> : null}</div>
        <input type="text" id="defaultContactFormName" value={accnum}
                onChange={(e) => setAccnum(e.target.value)} className="form-control mb-4" placeholder="Account Number" required/>
        <select className="browser-default custom-select mb-4"value={beneficiary}
                onChange={(e) => setBeneficiary(e.target.value)}>
            <option value="" disabled selected>Select Beneficiary</option>
            <option value="1">Beneficiary 1</option>
            <option value="2">Beneficiary 2</option>
            <option value="3">Beneficiary 3</option>
        </select>

        <input type="number" id="defaultContactFormName" className="form-control mb-4" placeholder="Beneficiary Account Number" value={beneficiaryAcc}
                onChange={(e) => setBeneficiaryAcc(e.target.value)} required/>
        
        <input type="number" id="defaultContactFormName" className="form-control mb-4" placeholder="Beneficiary IFSC Code" value={beneficiaryIFSC}
                onChange={(e) => setBeneficiaryIFSC(e.target.value)} required/>

        <select className="browser-default custom-select mb-4" value={beneficiaryAccType}
                onChange={(e) => setBeneficiaryAccType(e.target.value)} required>
            <option value="" disabled selected>Select Beneficiary Account Type</option>
            <option value="1">Savings</option>
            <option value="2">Current</option>
            <option value="3">Retirement</option>
        </select>
        <input type="number" id="defaultContactFormName" className="form-control mb-4" placeholder="Amount"value={Amount}
                onChange={(e) => setAmount(e.target.value)} required />      
    
        <div className="form-group">
            <textarea className="form-control rounded-0" id="exampleFormControlTextarea2" rows="1" placeholder="Remarks" value={Remarks}
                onChange={(e) => setRemarks(e.target.value)} required></textarea>
        </div>
    

        <div className="custom-control custom-checkbox mb-4">
            <input type="checkbox" className="custom-control-input" id="defaultContactFormCopy" checked/ >
            <label className="custom-control-label" for="defaultContactFormCopy" >I have read and accepted the terms and conditions</label>
        </div>

        <button className="btn btn-info btn-block" type="submit" onClick={handleSubmit}>Transfer</button>
    </form>
    </MDBCardBody>
        </MDBCard>
        </MDBCol>
        </MDBRow>
    </MDBContainer>
    </div>
  ); 
}

export default fundTransfer;