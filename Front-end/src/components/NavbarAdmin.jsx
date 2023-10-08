import { Link } from "react-router-dom";
import IconButton from "@mui/material/IconButton";
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';
import FavoriteIcon from '@mui/icons-material/Favorite';
import { Button } from "@mui/material";
import logo1 from '../../src/logo1.svg';


function NavbarAdmin({admin}) {
    return (
        <nav className='navbar navbar-expand-lg bg-light'  >
            <div className='container'>
                <b>ESPACE ADMIN</b>
                <div className='collapse navbar-collapse ' id='navbarNavAltMarkup'>
                    <div className="d-flex w-100 align-items-center justify-content-between">
                        <div className='navbar-nav'>
                        </div>
                        <div className='navbar-nav d-flex align-items-center'>
                            HI {admin}
                        </div>
                    </div>


                </div>
            </div>
        </nav>
    );
}

export default NavbarAdmin;