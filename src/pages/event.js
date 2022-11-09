import React from 'react';
import {
  MDBCol,
  MDBContainer,
  MDBRow,
  MDBCard,
  MDBCardText,
  MDBCardBody,
  MDBTypography,
  MDBIcon
} from 'mdb-react-ui-kit';

export default function event() {
  return (
    <section className="vh-110" style={{ backgroundColor: '#021946' }}>
              <br/><br/>
        <h2 style={{ color: 'white' }} className="fw-bold mb-2 text-center-">Event Details</h2>
      <MDBContainer className="py-5 h-100">
        <MDBRow className="justify-content-center align-items-center h-100">
          <MDBCol xl="10">
            <MDBCard className="mb-5" style={{ borderRadius: '15px' }}>
              <MDBCardBody className="p-4 ">
                <MDBTypography tag='h3'>How to achieve financial independence?</MDBTypography>
                <MDBCardText className="small text-black">
                  <MDBIcon far icon="star" size="lg" />
                  <span className="mx-2 text-black">|</span> Watch discussion between industry experts and advisors on planning and achieving financial independence
                </MDBCardText>
                <hr className="my-4" />
                <div className="d-flex justify-content-start align-items-center">
                  <MDBCardText className="text-uppercase mb-0">
                    <MDBIcon fas icon="far fa-calendar-check" /> <span className="text-black small"><a href="https://calendar.google.com/calendar/render?action=TEMPLATE&dates=20221123T123000Z%2F20221123T133000Z&details=%20Watch%20discussion%20between%20industry%20experts%20and%20advisors%20on%20planning%20and%20achieving%20financial%20independence&location=Online&text=How%20to%20achieve%20financial%20independence%3F" title="Save Event in my Calendar">Add to Calendar</a> </span>
                  </MDBCardText>
                  <MDBCardText className="text-uppercase mb-0">
                    <MDBIcon fas icon="link ms-4 me-2" /> <span className="text-black small"><a href='https://support.microsoft.com/en-us/office/join-a-meeting-in-teams-1613bb53-f3fa-431e-85a9-d6a91e3468c9'>Event Link</a></span>
                  </MDBCardText>
                  <span className="ms-3 me-4">|</span>
                  <div className="p-4 text-black" >
                <div className="d-flex justify-content-end text-center py-1">
                  <div>
                    <MDBCardText className="mb-1 h5 text-black">Date</MDBCardText>
                    <MDBCardText className="small text-black mb-0">23rd November 2022</MDBCardText>
                  </div>
                  <div className="px-3">
                    <MDBCardText className="mb-1 h5 text-black">Time</MDBCardText>
                    <MDBCardText className="small mb-0 text-black">06:00 pm</MDBCardText>
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
                      <MDBCardText className='text-black'>52 comments</MDBCardText>
                </div>
              </MDBCardBody>
            </MDBCard>
            <MDBCard className="mb-5" style={{ borderRadius: '15px'}}>
              <MDBCardBody className="p-4 ">
                <MDBTypography tag='h3'>Diversification of Portfolio</MDBTypography>
                <MDBCardText className="small text-black">
                  <MDBIcon far icon="star" size="lg" />
                  <span className="mx-2 text-black">|</span> Be a part of an engaging discussion between experienced professionals on portfolio management
                </MDBCardText>
                <hr className="my-4" />
                <div className="d-flex justify-content-start align-items-center">
                  <MDBCardText className="text-uppercase mb-0">
                    <MDBIcon fas icon="far fa-calendar-check" /> <span className="text-black small"><a href="https://calendar.google.com/calendar/render?action=TEMPLATE&dates=20221123T123000Z%2F20221123T133000Z&details=%20Watch%20discussion%20between%20industry%20experts%20and%20advisors%20on%20planning%20and%20achieving%20financial%20independence&location=Online&text=How%20to%20achieve%20financial%20independence%3F" title="Save Event in my Calendar">Add to Calendar</a></span>
                  </MDBCardText>
                  <MDBCardText className="text-uppercase mb-0">
                  <MDBIcon fas icon="link ms-4 me-2" /> <span className="text-black small"><a href='https://support.microsoft.com/en-us/office/join-a-meeting-in-teams-1613bb53-f3fa-431e-85a9-d6a91e3468c9'>Event Link</a></span>
                  </MDBCardText>
                  <span className="ms-3 me-4">|</span>
                  <div className="p-4 text-black" >
                <div className="d-flex justify-content-end text-center py-1">
                  <div>
                    <MDBCardText className="mb-1 h5 text-black">Date</MDBCardText>
                    <MDBCardText className="small text-black mb-0">9th December 2022</MDBCardText>
                  </div>
                  <div className="px-3">
                    <MDBCardText className="mb-1 h5 text-black">Time</MDBCardText>
                    <MDBCardText className="small text-black mb-0">05:00 pm</MDBCardText>
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
                      <MDBCardText className='text-black'>12 comments</MDBCardText>
                </div>
              </MDBCardBody>
            </MDBCard>        

          </MDBCol>
        </MDBRow>
      </MDBContainer>
    </section>
  );
}