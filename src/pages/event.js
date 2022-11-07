import React from 'react';
import {
  MDBCol,
  MDBContainer,
  MDBRow,
  MDBCard,
  MDBCardText,
  MDBCardBody,
  MDBCardImage,
  MDBBtn,
  MDBTypography,
  MDBIcon
} from 'mdb-react-ui-kit';

export default function event() {
  return (
    <section className="vh-110" style={{ backgroundColor: '#5f59f7' }}>
      <MDBContainer className="py-5 h-100">
        <MDBRow className="justify-content-center align-items-center h-100">
          <MDBCol xl="10">
            <MDBCard className="mb-5" style={{ borderRadius: '15px' }}>
              <MDBCardBody className="p-4">
                <MDBTypography tag='h3'>How to achieve financial independence?</MDBTypography>
                <MDBCardText className="small">
                  <MDBIcon far icon="star" size="lg" />
                  <span className="mx-2">|</span> Watch discussion between industry experts and advisors on planning and achieving financial independence
                </MDBCardText>
                <hr className="my-4" />
                <div className="d-flex justify-content-start align-items-center">
                  <MDBCardText className="text-uppercase mb-0">
                    <MDBIcon fas icon="far fa-calendar-check" /> <span className="text-muted small">Add to Calendar </span>
                  </MDBCardText>
                  <MDBCardText className="text-uppercase mb-0">
                    <MDBIcon fas icon="link ms-4 me-2" /> <span className="text-muted small">Event Link</span>
                  </MDBCardText>
                  <span className="ms-3 me-4">|</span>
                  <div className="p-4 text-black" style={{ backgroundColor: '#f8f9fa' }}>
                <div className="d-flex justify-content-end text-center py-1">
                  <div>
                    <MDBCardText className="mb-1 h5">Date</MDBCardText>
                    <MDBCardText className="small text-muted mb-0">23rd November 2022</MDBCardText>
                  </div>
                  <div className="px-3">
                    <MDBCardText className="mb-1 h5">Time</MDBCardText>
                    <MDBCardText className="small text-muted mb-0">06:00 pm</MDBCardText>
                  </div>
                </div>
              </div>
              <span className="ms-3 me-4">|</span>
            <ul className="mb-0 list-unstyled d-flex flex-row" style={{ color: '#1B7B2C' }}>
                        <li>
                          <MDBIcon fas icon="star fa-xs" />
                        </li>
                        <li>
                          <MDBIcon fas icon="star fa-xs" />
                        </li>
                        <li>
                          <MDBIcon fas icon="star fa-xs" />
                        </li>
                        <li>
                          <MDBIcon fas icon="star fa-xs" />
                        </li>
                        <li>
                          <MDBIcon fas icon="star fa-xs" />
                        </li>
                      </ul>
                      <span className="ms-3 me-4">|</span>
                      <MDBCardText>52 comments</MDBCardText>
                </div>
              </MDBCardBody>
            </MDBCard>
            <MDBCard className="mb-5" style={{ borderRadius: '15px' }}>
              <MDBCardBody className="p-4">
                <MDBTypography tag='h3'>Diversification of Portfolio</MDBTypography>
                <MDBCardText className="small">
                  <MDBIcon far icon="star" size="lg" />
                  <span className="mx-2">|</span> Be a part of an engaging discussion between experienced professionals on portfolio management
                </MDBCardText>
                <hr className="my-4" />
                <div className="d-flex justify-content-start align-items-center">
                  <MDBCardText className="text-uppercase mb-0">
                    <MDBIcon fas icon="far fa-calendar-check" /> <span className="text-muted small">Add to Calendar </span>
                  </MDBCardText>
                  <MDBCardText className="text-uppercase mb-0">
                    <MDBIcon fas icon="link ms-4 me-2" /> <span className="text-muted small">Event Link</span>
                  </MDBCardText>
                  <span className="ms-3 me-4">|</span>
                  <div className="p-4 text-black" style={{ backgroundColor: '#f8f9fa' }}>
                <div className="d-flex justify-content-end text-center py-1">
                  <div>
                    <MDBCardText className="mb-1 h5">Date</MDBCardText>
                    <MDBCardText className="small text-muted mb-0">9th December 2022</MDBCardText>
                  </div>
                  <div className="px-3">
                    <MDBCardText className="mb-1 h5">Time</MDBCardText>
                    <MDBCardText className="small text-muted mb-0">05:00 pm</MDBCardText>
                  </div>
                </div>
              </div>
              <span className="ms-3 me-4">|</span>
            <ul className="mb-0 list-unstyled d-flex flex-row" style={{ color: '#1B7B2C' }}>
                        <li>
                          <MDBIcon fas icon="star fa-xs" />
                        </li>
                        <li>
                          <MDBIcon fas icon="star fa-xs" />
                        </li>
                        <li>
                          <MDBIcon fas icon="star fa-xs" />
                        </li>
                        <li>
                          <MDBIcon fas icon="star fa-xs" />
                        </li>
                        <li>
                          <MDBIcon fas icon="star fa-xs" />
                        </li>
                      </ul>
                      <span className="ms-3 me-4">|</span>
                      <MDBCardText>12 comments</MDBCardText>
                </div>
              </MDBCardBody>
            </MDBCard>        

          </MDBCol>
        </MDBRow>
      </MDBContainer>
    </section>
  );
}