import React, {useEffect, useState }from 'react';
import {
    MDBInput
  } from 'mdb-react-ui-kit';
  import axios from "axios";
    
function checkBalance() {
  const [balance,setBalance] = useState("");
  const [name,setUsername] = useState("");
  const [transactions,setTransactions] = useState([]);
  useEffect(() => {
    setUsername(localStorage.getItem("username"));

    axios.post(`http://localhost:8081/transactions`,{"accountNumber":localStorage.getItem("accountnumber")},{responseType:"json"})
    
    .then(function(transaction){
      console.log(JSON.stringify(transaction.data))
      setTransactions(transaction.data)
      console.log(transactions)
      
    }
    )
    .catch(function (error) {
      console.log(error);
    });

    
    
    axios.post(`http://localhost:8081/balance`,
      {"accountNumber":localStorage.getItem("accountnumber")})
    .then(function (balanceres) {
      setBalance(balanceres.data.balance);
      console.log(balanceres.data);
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
      <MDBInput wrapperclassName='mb-4 w-100' value = {balance}
                 id='formControlLg' 
                type='text' size="lg" disabled/>
                </div>
  </div>
  <h5 className="card-title">Transaction Details</h5>
  <table className="table table-hover table-bordered">
  <thead>
    <tr>
      <th scope="col">Transaction ID</th>
      <th scope="col">Transaction Date</th>
      <th scope="col">Transaction Type</th>
      <th scope="col">Amount</th>
    </tr>
  </thead>
  <tbody >
  {transactions.map((item,index)=>(
      <tr key={index}>
        <td>{item.transactionid}</td>
        <td>{item.transactiondate}</td>
        <td>{item.transactiontype}</td>
        <td>{item.amount}</td>
      </tr>
    ))}
  </tbody>
</table>
</div>

);
}

export default checkBalance;