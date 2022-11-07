import { MDBContainer, MDBNavbar, MDBNavbarBrand } from "mdb-react-ui-kit"
import React from "react"
export default function DashBoard(){
    return(
        <div id='dashboard'>
            <MDBNavbar>
                <MDBContainer>
                    <MDBNavbarBrand href="#">CheckBalance</MDBNavbarBrand>
                    <MDBNavbarBrand href="fundtransfer">Fund Transfer</MDBNavbarBrand>
                    <MDBNavbarBrand href="newfd">Open New FD</MDBNavbarBrand>
                    <MDBNavbarBrand href="#">Events</MDBNavbarBrand>
                    <MDBNavbarBrand href="changepin">Change ATM Pin</MDBNavbarBrand>
                </MDBContainer>
            </MDBNavbar>
        </div>
    )
}