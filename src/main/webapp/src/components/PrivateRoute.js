import React from 'react';
import { Route, Redirect } from 'react-router-dom';

const PrivateRoute = ({ component: Component, requiredRole, roles, ...rest }) => (
    <Route {...rest} render={props => {

        //authentication check
        if(!localStorage.getItem("authenticated")){
            return <Redirect to="/login" />
        }

        //authorization check
        if(roles && requiredRole){
            var authorization=false;
            roles.map((role)=>{
                if(role.name===requiredRole){
                    authorization=true;
                }
                return "";
            })
            if(!authorization){
                return <Redirect to="/" />
            }
        }


        return <Component {...props} />
    }} />
);

export default PrivateRoute;