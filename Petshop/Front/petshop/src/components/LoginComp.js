import '../App'
import '../CSS/App.css'
import '../CSS/Shopping.css';
import React, { useEffect, useState } from 'react'
import {getUsers} from '../services/Login/Login'

export default function LoginComp(){
    const [users, setUsers] = useState([]);

    useEffect((users) => {
        getUsers((data) => {
            if(data !== null){
                setUsers(data);
            }
        });
        console.log(users);

    }, []);

        const [email, setEmail] = useState('');
        const [password, setPassword] = useState('');
    
        const handleEmailChange = (e) => {
            setEmail(e.target.value);
        };
    
        const handlePasswordChange = (e) => {
            setPassword(e.target.value);
        };
    
        const handleFormSubmit = (e) => {
            e.preventDefault();
            
            const isUserValid = users.some((user) => user.email === email && user.password === password);
            const loggedUser = users.find((user) => user.email === email && user.password === password);

            if (isUserValid) {
                // Store user information in local storage
                localStorage.setItem('loggedInUser', JSON.stringify({loggedUser}));

                window.location.href = '/';
            } 
            else {
                window.location.href = '/Register';
            }
          };
          

    return(
            <div className="Login">
            <div className="login-form">
                <h1 className="title-login">Login</h1>
                <form onSubmit={handleFormSubmit}>
                <div className="input-container">
                    <label htmlFor="email" className="label">Email</label>
                    <input
                        type="email"
                        id="email"
                        value={email}
                        onChange={handleEmailChange}
                    />
                </div>
                <div className="input-container">
                    <label htmlFor="password" className="label">Password</label>
                    <input
                        type="password"
                        id="password"
                        value={password}
                        onChange={handlePasswordChange}
                    />
                </div>
                <div className="submit-button">
                    <span className="submit-link" onClick={handleFormSubmit}>Submit</span>
                </div>
                <div>
                    <label className="label">Don't have an account yet? </label>
                    <a className="link" href ="/Register">Register</a>
                </div>
                </form>
            </div>
            </div>
    );


}