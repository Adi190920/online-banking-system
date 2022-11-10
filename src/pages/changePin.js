import React, {useState }from 'react';
import {
    MDBContainer,
    MDBRow,
    MDBCol,
    MDBCard,
    MDBCardBody,
    MDBInputGroup
  } from 'mdb-react-ui-kit';
  
import { Button } from 'react-bootstrap';
import axios from 'axios';
function changePin() {
        const [oldpin, setOldPin] = useState("")
        const [newpin, setNewPin] = useState("")
        const [confirmnewpin, setConfirmPin] = useState("")
        const [message, setMessage] = useState("")  
        const [success, setSuccess] = useState("");
        
    function validate(){
        if(newpin.length !== 4 || confirmnewpin.length !== 4 || oldpin.length!== 4){
            setMessage("Size of pin should be 4");
            setTimeout(() => setMessage("   "), 2000);
        }
        else if(newpin === oldpin){
            setMessage("New pin is same as old pin. Try again");
            setTimeout(() => setMessage("   "), 2000);
        }
        else if(newpin !== confirmnewpin){
           setMessage("Pins do not match. Type again");
           setTimeout(() => setMessage("   "), 2000);
        }
        else{
            
            return true;
          }
          return false;
    }
    function handleSubmit(event){
        event.preventDefault();
        if(!validate()){
            return;
        }
        var data = JSON.stringify({
            "username": localStorage.getItem("username"),
            "oldpin" : oldpin,
            "newpin" : newpin,
            "conformpin" : confirmnewpin,
          });
      
          var config = {
            method: 'post',
            url: 'http://localhost:8081/changepin',
            headers: { 
              'Content-Type': 'application/json', 
            // 'Cookie': 'JSESSIONID=BD47BA85535C131A6AE0A5A78DA1B3D4'
            },
            data : data
          };
      
          axios(config)
          .then(function (res) {
            console.log(res.data);
            setSuccess("Pin is Changed");
            setTimeout(() => setSuccess("   "), 2000);
            setNewPin("");
            setOldPin("");
            setConfirmPin("");
            // alert("Pin is Changed");
           
          })
          .catch(function (error) {
            console.log(error);
            setMessage("Something went wrong");
            setTimeout(() => setMessage("   "), 2000);
          });
      
      
      }
    return(
        <div style={{ backgroundColor: '#021946' }}>
        <MDBContainer fluid>
        <MDBRow className='d-flex justify-content-center align-items-center h-80'>
        
        <MDBCol col='8'>
  
            <MDBCard className='bg-white my-5 mx-auto' style={{borderRadius: '1rem', maxWidth: '450px'}}>
            
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
                <Button onClick={handleSubmit}> Change Pin</Button>
        </MDBCardBody>
        </MDBCard>
        </MDBCol>
        </MDBRow>
    </MDBContainer>
    </div>   
    );
    
}
export default changePin;