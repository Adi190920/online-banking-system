import { MDBContainer, MDBNavbar, MDBNavbarBrand } from "mdb-react-ui-kit"
import React from "react"
export default function DashBoard(){
    return(
        <div id='dashboard'>
            <MDBNavbar>
                <MDBContainer>
                    <MDBNavbarBrand href="#">CheckBalance</MDBNavbarBrand>
                    <MDBNavbarBrand href="#">Fund Transfer</MDBNavbarBrand>
                    <MDBNavbarBrand href="#">Open New FD</MDBNavbarBrand>
                    <MDBNavbarBrand href="#">Events</MDBNavbarBrand>
                    <MDBNavbarBrand href="changepin">Change ATM Pin</MDBNavbarBrand>
                    <MDBNavbarBrand href="login">Logout</MDBNavbarBrand>
                </MDBContainer>
            </MDBNavbar>
        </div>
    )
}