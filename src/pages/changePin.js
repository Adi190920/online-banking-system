import React, {useState }from 'react';
import {
    MDBBtn,
    MDBContainer,
    MDBRow,
    MDBCol,
    MDBCard,
    MDBCardBody,
    MDBInputGroup,
  } from 'mdb-react-ui-kit';
  import {  useNavigate } from "react-router-dom";
    
export default function changePin() {
        const [oldpin, setOldPin] = useState("")
        const [newpin, setNewPin] = useState("")
        const [confirmnewpin, setConfirmPin] = useState("")
        const [message, setMessage] = useState("")      
        const navigate = useNavigate()

    function handleSubmit(event){
        event.preventDefault();
        if(newpin.length !== 4 || confirmnewpin.length !== 4 || oldpin.length!== 4){
            setMessage("Size of pin should be 4");
        }
        else if(newpin !== confirmnewpin){
           setMessage("Pins do not match. Type again");
        //   navigate("/");
        }
        else{
            setMessage("Pin is changed")
            //  navigate("/dashboard");
        }

      }
    return(
        <MDBContainer fluid>
      
        <MDBRow className='d-flex justify-content-center align-items-center h-80'>
        
        <MDBCol col='8'>
  
            <MDBCard className='bg-white my-5 mx-auto' style={{borderRadius: '1rem', maxWidth: '400px'}}>
              <MDBCardBody className='p-5 w-100 d-flex flex-column'>
              <div className="text-danger">{message ? <p>{message}</p> : null}</div>
                <h2 className="fw-bold mb-2 text-center">Change Pin</h2>
                <br/>         
                    <MDBInputGroup className='mb-4 w-100' value={oldpin} onChange={(e) => setOldPin(e.target.value)}>
                    <input className='form-control' type='number' placeholder="Old Pin"required />
                    </MDBInputGroup>
                    <MDBInputGroup className='mb-4 w-100' value={newpin} onChange={(e) => setNewPin(e.target.value)}>
                    <input className='form-control' type='number' placeholder="New Pin" required/>
                    </MDBInputGroup>
                    <MDBInputGroup className='mb-4 w-100' value={confirmnewpin} onChange={(e) => setConfirmPin(e.target.value)}>
                    <input className='form-control' type='number' placeholder="Confirm Pin" required/>
                    </MDBInputGroup>         
                <MDBBtn size ='lg' > Change </MDBBtn>  
        </MDBCardBody>
        </MDBCard>
        </MDBCol>
        </MDBRow>
    </MDBContainer>
    );
    
}