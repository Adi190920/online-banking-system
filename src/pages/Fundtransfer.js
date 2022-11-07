import React from 'react'
import {
    MDBBtn,
    MDBContainer,
    MDBRow,
    MDBCol,
    MDBCard,
    MDBCardBody,
    MDBInput,
    MDBIcon,
    MDBDropdown,
    MDBDropdownToggle,
    MDBDropdownMenu,
    MDBDropdownItem,
    
  }
  from 'mdb-react-ui-kit';
import {  useNavigate } from "react-router-dom";

export function Fundtransfer() {
    const navigate = useNavigate();
    function handleSubmit(event){
        event.preventDefault();
        navigate("/dashboard");
    }
  return (
    <MDBContainer fluid>
      
      <MDBRow className='d-flex justify-content-center align-items-center h-80'>
      
        <MDBCol col='8'>

          <MDBCard className='bg-white my-5 mx-auto' style={{borderRadius: '1rem', maxWidth: '400px'}}>
            <MDBCardBody className='p-5 w-100 d-flex flex-column'>
            <h2 className="fw-bold mb-2 text-center">Fund Transfer</h2>
            <MDBInput wrapperClass='mb-4 w-100'
                placeholder='From account' id='formControlLg'
                type='text' size="sm"/>
            <select class='browser-default custom-select'>
              <option selected>select Beneficiary</option>
              <option value="father">Father</option>
              <option value="mother">Mother</option>
              <option value="guardian">Guardian</option>
            </select><br/>
            <MDBInput wrapperClass='mb-4 w-100'
                placeholder='Beneficiary Account' id='formControlLg'
                type='text' size="sm"/>
                <MDBInput wrapperClass='mb-4 w-100'
                placeholder='Beneficiary IFSC code' id='formControlLg'
                type='text' size="sm"/>
            <select class='browser-default custom-select'>
              <option selected>Beneficiary Account type</option>
              <option value="current">current</option>
              <option value="savings">savings</option>
            </select><br/>
            <MDBInput wrapperClass='mb-4 w-100'
                placeholder='Amount' id='formControlLg'
                type='text' size="sm"/>
            <MDBInput wrapperClass='mb-4 w-100'
                placeholder='Remarks' id='formControlLg'
                type='text' size="sm"/>
                <MDBBtn size='sm' onClick={handleSubmit}
                >Transfer </MDBBtn>
            </MDBCardBody>
          </MDBCard>
        </MDBCol>
      </MDBRow>

    </MDBContainer>
  )
}

export default Fundtransfer