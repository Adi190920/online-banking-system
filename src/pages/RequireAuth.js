import { useLocation, Navigate, Outlet } from "react-router-dom";
import React from "react";
const RequireAuth = () =>{
    const location = useLocation();
    
    return(
            localStorage.getItem("username") ? 
            <Outlet/> 
            : <Navigate to="/login" state={{ from : location }}   repalce/>
    )
}

export default RequireAuth;