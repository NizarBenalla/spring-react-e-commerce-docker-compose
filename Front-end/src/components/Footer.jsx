import React from 'react';
import {
  MDBFooter,
  MDBContainer,
  MDBCol,
  MDBRow,
} from 'mdb-react-ui-kit';
import logo1 from '../../src/logo1.svg';

export default function Footer() {
  return (
    <MDBFooter className='bg-secondary text-white text-center mt-5' style={{ bottom: '0', width: '100%', height :'25%'}}>
      <MDBContainer className='p-4'>
        <MDBRow>
          <MDBCol lg="6" md="12" className='mb-4 mb-md-0'>
          <img src = {logo1} width={190} height={100} />

            <h5 className='text-uppercase'>myStore</h5>

            <p>
              une boutique en ligne qui vous offres une panoplie de categorie des produits informatiques
            </p>
          </MDBCol>

          <MDBCol lg="3" md="6" className='mb-4 mb-md-0'>
            <h5 className='text-uppercase'>myShop</h5>

            <ul className='list-unstyled mb-0'>
              <li>
                <a href='produit' className='text-white'>
                   Produits
                </a>
              </li>
              <li>
                <a href='faq' className='text-white'>
                   A propos                
                  </a>
              </li>
            </ul>
          </MDBCol>

          <MDBCol lg="3" md="6" className='mb-4 mb-md-0'>
            <h5 className='text-uppercase mb-0'>Liens</h5>

            <ul className='list-unstyled'>
              <li>
                <a href='#!' className='text-white'>
              Support                
                </a>
              </li>
              <li>
                <a href='signin' className='text-white'>
                  Sign In
                </a>
              </li>
              <li>
                <a href='signup' className='text-white'>
                  Sign Up
                </a>
              </li>
            
            </ul>
          </MDBCol>
        </MDBRow>
      </MDBContainer>

      <div className='text-center p-3' style={{ backgroundColor: 'rgba(0, 0, 0, 0.2)' }}>
        © 2023 Copyright:
        <a className='text-white' href='https://mdbootstrap.com/'>
          Myshop.com
        </a>
      </div>
    </MDBFooter>
  );
}