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
    
  }
  from 'mdb-react-ui-kit';
import {  useNavigate } from "react-router-dom";

export function Changepin() {
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
            <h2 className="fw-bold mb-2 text-center">Change ATM Pin</h2>
            <MDBInput wrapperClass='mb-4 w-100'
                label='oldpin' id='formControlLg' 
                type='password' size="sm"/>
              <MDBInput wrapperClass='mb-4 w-100'
                label='newpin' id='formControlLg'
                type='password' size="sm"/>
                <MDBInput wrapperClass='mb-4 w-100'
                label='confirmpin' id='formControlLg'
                type='password' size="sm"/>
                <MDBBtn size='sm' onClick={handleSubmit}
                >Changepin </MDBBtn>
            </MDBCardBody>
          </MDBCard>

        </MDBCol>
      </MDBRow>

    </MDBContainer>
  )
}

export default Changepin