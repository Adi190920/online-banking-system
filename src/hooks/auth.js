import React, { useState, useEffect } from "react";
import axios from "axios";
const useAuth = () => {

    const [auth,setAuth] = useState(null);
    const [user,setUser] = useState({});

    const isAuth = async() => {
        if(localStorage.getItem("username") === "hari" && localStorage.getItem("password") === "om" ){
            setUser({"username" : localStorage.getItem("username"), "password" : localStorage.getItem("password") });
            setAuth(true);
            console.log(user);
        }
        else{
            setAuth(false);
            setUser({"username" : "", "password" : "" });
        }
        // await axios.get('http://localhost:8080/api/logged-user/',{withCredentials:true})
        // .then(res => {
        //     setUser(res.data);
        //     setAuth(true);
        // })
        // .catch(error => {
        //     setAuth(false);
        // });
    }


    useEffect(() => {
        isAuth();
    },[auth])

    return{
        auth:auth,
        user:user
    }
}
export default useAuth;