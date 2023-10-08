import React from 'react';
import { Route, Navigate } from "react-router-dom";

const GuardedRoute = ({ element: Component, auth, ...rest }) => {
    return (
        <Route {...rest} render={(props) => (
        auth === true
            ? <Component {...props} />
            : <Navigate to='/signin' />
    )} />)
}
    


export default GuardedRoute;