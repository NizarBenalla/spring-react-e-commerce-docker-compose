import { Outlet, Navigate } from 'react-router-dom'

const PrivateRoutes = ({aut}) => {
    // let auth = {'token':false}
    return(
        aut.token ? <Outlet/> : <Navigate to="/"/>
    )
}

export default PrivateRoutes