import React, {useState }from 'react';
import {
    MDBBtn,
    MDBContainer,
    MDBRow,
    MDBCol,
    MDBCard,
    MDBCardBody,
    MDBInputGroup
  } from 'mdb-react-ui-kit';
  import {  useNavigate } from "react-router-dom";
    
function changePin() {
        const [oldpin, setOldPin] = useState("")
        const [newpin, setNewPin] = useState("")
        const [confirmnewpin, setConfirmPin] = useState("")
        const [message, setMessage] = useState("")  
        const [success, setSuccess] = useState("");    
        const navigate = useNavigate()
        

    function handleSubmit(event){
        event.preventDefault();
        if(newpin.length !== 4 || confirmnewpin.length !== 4 || oldpin.length!== 4){
            setMessage("Size of pin should be 4");
            setTimeout(() => setMessage("   "), 4000);
        }
        else if(newpin === oldpin){
            setMessage("New pin is same as old pin. Try again");
            setTimeout(() => setMessage("   "), 4000);
        }
        else if(newpin !== confirmnewpin){
           setMessage("Pins do not match. Type again");
           setTimeout(() => setMessage("   "), 4000);
        //   navigate("/");
        }
        else{
            setSuccess("Pin is Changed")
            alert("Pin is Changed")
          }

      }
    return(
        <MDBContainer fluid>
      
        <MDBRow className='d-flex justify-content-center align-items-center h-80'>
        
        <MDBCol col='8'>
  
            <MDBCard className='bg-white my-5 mx-auto' style={{borderRadius: '1rem', maxWidth: '400px'}}>
              <MDBCardBody className='p-5 w-100 d-flex flex-column'>
              <div className="text-danger">{message ? <p>{message}</p> : null}</div>
              <div className="text-success">{success ? <p>{success}</p> : null}</div>
                <h2 className="fw-bold mb-2 text-center">Change Pin</h2>
                <br/>         
                    <MDBInputGroup className='mb-4 w-100' value={oldpin} onChange={(e) => setOldPin(e.target.value)}>
                    <input className='form-control' type='number' placeholder="Old Pin"required />
                    </MDBInputGroup>
                    <MDBInputGroup className='mb-4 w-100' value={newpin} onChange={(e) => setNewPin(e.target.value)}>
                    <input className='form-control' type='number' placeholder="New Pin" required/>
                    </MDBInputGroup>
                    <MDBInputGroup className='mb-4 w-100' value={confirmnewpin} onChange={(e) => setConfirmPin(e.target.value)}>
                    <input className='form-control' type='number' placeholder="Confirm New Pin" required/>
                    </MDBInputGroup>         
                <button onClick={handleSubmit}> Change Pin</button>
                {/*  Misbehaving due to MDB Template bugs
               <MDBBtn size='lg'
                onClick={handleSubmit}
    >Change Pin </MDBBtn>   */}
        </MDBCardBody>
        </MDBCard>
        </MDBCol>
        </MDBRow>
    </MDBContainer>
    );
    
}
export default changePin;