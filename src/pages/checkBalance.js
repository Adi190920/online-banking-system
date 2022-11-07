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
  import useAuth from '../hooks/auth';
  import {  useNavigate } from "react-router-dom";
    
function checkBalance() {
  const auth = useAuth();
  


return(

<div class="card">

  <div class="card-body">
  <h2 className="fw-bold mb-2 text-center">Account Details</h2>
    <div class="float-left">
      <label> Name </label>
    <MDBInput wrapperClass='mb-4 w-100' value = {auth.user.username}
                placeholder='Name' id='formControlLg' 
                type='text' size="lg" disabled/>
      </div>
      <div class="float-right">
      <label> Balance </label>
      {/* Add balance component to user */}
      <MDBInput wrapperClass='mb-4 w-100' value = '10000'
                placeholder='Current Balance' id='formControlLg' 
                type='text' size="lg" disabled/>
                </div>
  </div>
  <h5 class="card-title">Transaction Details</h5>
  <table class="table table-hover table-bordered">
  <thead>
    <tr>
      <th scope="col">Transaction ID</th>
      <th scope="col">Transaction Date</th>
      <th scope="col">Transaction Type</th>
      <th scope="col">Amount</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>23/05/2022</td>
      <td>Savings</td>
      <td>1000</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>23/12/2022</td>
      <td>Savings</td>
      <td>2000</td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td>24/08/2022</td>
      <td>Savings</td>
      <td>2698</td>
    </tr>
    <tr>
      <th scope="row">4</th>
      <td>24/08/2022</td>
      <td>Savings</td>
      <td>218</td>
    </tr>
    <tr>
      <th scope="row">5</th>
      <td>24/08/2022</td>
      <td>Savings</td>
      <td>378</td>
    </tr>
  </tbody>
</table>
</div>


);
}

export default checkBalance;