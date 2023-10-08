import { Link } from "react-router-dom";
import IconButton from "@mui/material/IconButton";
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';
import FavoriteIcon from '@mui/icons-material/Favorite';
import { Button } from "@mui/material";
import logo1 from '../../src/logo1.svg';


function Navbar({ aut, admin, setAuth, adminLog, setAdminLog }) {
    // const navbar = () => {
    //     if()
    // }
    const wish = () => {
        document.getElementById("wishlist").disabled = false
    }


    return (
        <nav className='navbar navbar-expand-lg bg-light'  >
            <div className='container'>
                <Link className='navbar-brand' to='/'  >
                    <img src={logo1} width={182} height={90} />
                    MySHop
                </Link>
                <button
                    className='navbar-toggler'
                    type='button'
                    data-bs-toggle='collapse'
                    data-bs-target='#navbarNavAltMarkup'
                    aria-controls='navbarNavAltMarkup'
                    aria-expanded='false'
                    aria-label='Toggle navigation'
                >
                    <span className='navbar-toggler-icon' />
                </button>
                <div className='collapse navbar-collapse ' id='navbarNavAltMarkup'>
                    <div className="d-flex w-100 align-items-center justify-content-between">
                        <div className='navbar-nav'>
                            <Link className='nav-link' to='/'>
                                Produits
                            </Link>
                            <Link className='nav-link' to='/faq'>
                                A propos
                            </Link>
                        </div>
                        <div className='navbar-nav d-flex align-items-center'>


                            {aut.token ?
                                <div className="d-flex align-items-center">
                                    <Link className='nav-link' to='/wishlist'>
                                        <IconButton aria-label="wishlist">
                                            <FavoriteIcon />
                                        </IconButton>
                                    </Link>

                                    <Link className='nav-link' to='/cart'>
                                        <IconButton aria-label="Cart">
                                            <ShoppingCartIcon />
                                        </IconButton>
                                    </Link>
                                    <div style={{ marginRight: "10px" }}> <b>Hi {admin}</b></div>
                                    <Link className='nav-link' to='/profile' >

                                        <Button variant="outlined"  >
                                            Profile
                                        </Button>
                                    </Link>
                                    

                                    <div>
                                        <Button variant="outlined" onClick={() => { setAuth({ 'token': false }) }} className="ml-5">
                                            logout
                                        </Button>
                                    </div>

                                </div>
                                : adminLog.token ?

                                    <div className="d-flex align-items-center">
                                        <div> <b>Hi {admin}</b></div>
                                        {/* {document.getElementById("wishlist").disabled = false} */}
                                        <Button variant="outlined" onClick={() => { setAdminLog({ 'token': false }) }} className="ml-5">
                                            logout
                                        </Button>
                                    </div> :

                                    <div className="d-flex align-items-center">
                                        <Link className='nav-link' to='/wishlist'>
                                            <IconButton aria-label="wishlist">
                                                <FavoriteIcon />
                                            </IconButton>
                                        </Link>
                                        <Link className='nav-link' disableElevation to='/signin' >
                                            <Button variant="contained"  >
                                                Sign In
                                            </Button>
                                        </Link>
                                        <Link className='nav-link' to='/signup' >

                                            <Button variant="outlined"  >
                                                Sign Up
                                            </Button>
                                        </Link>
                                    </div>
                            }
                        </div>
                    </div>


                </div>
            </div>
        </nav>
    );
}

export default Navbar;