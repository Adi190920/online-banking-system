import React, {useEffect, useState }from 'react';
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
  import axios from "axios";
  import {  useNavigate } from "react-router-dom";
function checkBalance() {
  const auth = useAuth();
  const [resp,setResponse] = useState("");
  const [balance,setBalance] = useState("");
  const [name,setUsername] = useState("");
  useEffect(() => {
    setUsername(localStorage.getItem("username"));
    var data = {};

    var config = {
      method: 'get',
      url: 'http://localhost:8081/transactions',
      headers: { 
        'Content-Type': 'application/json', 
      },
      data : [{
        "accountNumber": localStorage.getItem("accountnumber")
      }]
    };

    console.log(config);
    axios(config)
    .then(function (res) {
      setResponse(res.data);
      console.log(res);
    })
    .catch(function (error) {
      console.log(error);
    });

    var configBalance = {
      method: 'get',
      url: 'http://localhost:8081/balance',
      headers: { 
        'Content-Type': 'application/json', 
      },
      data : {
        "accountnumber": localStorage.getItem("accountnumber")
      }
    };
    console.log(configBalance)
    axios(configBalance)
    .then(function (balanceres) {
      setBalance(balanceres.data);
      console.log(balanceres);
    })
    .catch(function (error) {
      console.log(error);
    });
    

  }, [])


return(

<div className="card">

  <div className="card-body">
  <h2 className="fw-bold mb-2 text-center">Account Details</h2>
    <div className="float-left">
      <label> Name </label>
    <MDBInput wrapperclassName='mb-4 w-100' value = {name}
                placeholder='Name' id='formControlLg' 
                type='text' size="lg" disabled/>
      </div>
      <div className="float-right">
      <label> Balance </label>
      {/* Add balance component to user */}
      <MDBInput wrapperclassName='mb-4 w-100' value = {balance.balance}
                placeholder='Current Balance' id='formControlLg' 
                type='text' size="lg" disabled/>
                </div>
  </div>
<<<<<<< Updated upstream
  <h5 className="card-title">Transaction Details</h5>
  <table className="table table-hover table-bordered">
=======
  <h5 class="card-title">Transaction Details</h5>
  <table class="table table-hover table-bordered">
>>>>>>> Stashed changes
  <thead>
    <tr>
      <th scope="col">Transaction ID</th>
      <th scope="col">Transaction Date</th>
      <th scope="col">Transaction Type</th>
      <th scope="col">Amount</th>
    </tr>
  </thead>
<<<<<<< Updated upstream
  <tbody >
  {/* {resp.map((item,index)=>(
      <tr key={index}>
        <td>{item.transactionid}</td>
        <td>{item.transactiondate}</td>
        <td>{item.transactiontype}</td>
        <td>{item.amount}</td>
      </tr>
    ))} */}
=======
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
>>>>>>> Stashed changes
  </tbody>
</table>

</div>


);
}

export default checkBalance;