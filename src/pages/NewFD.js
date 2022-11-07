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

export function NewFD() {
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
            <h2 className="fw-bold mb-2 text-center">Fixed Deposit</h2>
            <MDBInput wrapperClass='mb-4 w-100'
                placeholder='From account' id='formControlLg'
                type='text' size="sm"/>
            <select class='browser-default custom-select'>
              <option selected>select FD Product</option>
              <option value="regular">Regular</option>
              <option value="corporate">Corporate</option>
              <option value="cumulative">Cumulative</option>
            </select><br/>
            <select class='browser-default custom-select'>
              <option selected>select FD Period</option>
              <option value="ten">10 years</option>
              <option value="fifteen">15 years</option>
              <option value="twenty">20 years</option>
            </select><br/>
            <MDBInput wrapperClass='mb-4 w-100'
                placeholder='Amount' id='formControlLg'
                type='text' size="sm"/>
                <MDBBtn size='sm' onClick={handleSubmit}
                >Register </MDBBtn>
            </MDBCardBody>
          </MDBCard>

        </MDBCol>
      </MDBRow>

    </MDBContainer>
  )
}

export default NewFD