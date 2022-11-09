import React, { useState, useEffect } from "react";
import axios from "axios";
const useAuth = () => {

    const [auth,setAuth] = useState(null);
    const [user,setUser] = useState({});

    const isAuth = async() => {
        if(localStorage.getItem("username") != null){
            setUser(localStorage.getItem("username"));
            setAuth(true);
        }else{
            setAuth(false);
        }
    }


    useEffect(() => {
        isAuth();
    },[localStorage.getItem("username")])

    return{
        auth:auth,
        user:user
    }
}
export default useAuth;