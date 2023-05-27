import '../App'
import '../CSS/App.css'
import '../CSS/Login.css';
import React, { useState } from 'react'
import Register from '../services/Register/Register';

export default function RegisterComp(){

    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [name, setName] = useState('');
    const [phone, setPhone] = useState('');
    const [address, setAddress] = useState('');

    const handleEmailChange = (e) => {
        setEmail(e.target.value);
    };

    const handleNameChange = (e) => {
        setName(e.target.value);
    };

    const handlePhoneChange = (e) => {
        setPhone(e.target.value);
    };

    const handleAddressChange = (e) => {
        setAddress(e.target.value);
    };

    const handlePasswordChange = (e) => {
        setPassword(e.target.value);
    };

    const handleFormSubmit = (e) => {
        const user = {
            name,
            email,
            password,
            phone,
            address
        };
        Register(user);
    };

    return(
        <div className="Login">
            <div className="login-form">
                <h1 className="login-title">Register</h1>
                <form onSubmit={handleFormSubmit}>
                    <div className="input-container">
                        <label htmlFor="name" className="label">Name</label>
                        <input
                            type="text"
                            id="name"
                            value={name}
                            onChange={handleNameChange}
                        />
                    </div>
                    <div className="input-container">
                        <label htmlFor="email" className="label">Email</label>
                        <input
                            type="text"
                            id="email"
                            value={email}
                            onChange={handleEmailChange}
                        />
                    </div>
                    <div className="input-container">
                        <label htmlFor="phone" className="label">Phone</label>
                        <input
                            type="text"
                            id="phone"
                            value={phone}
                            onChange={handlePhoneChange}
                        />
                    </div>
                    <div className="input-container">
                        <label htmlFor="address" className="label">Address</label>
                        <input
                            type="text"
                            id="address"
                            value={address}
                            onChange={handleAddressChange}
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
                        <a className="submit-link" onClick={handleFormSubmit}>Submit</a>
                    </div>
                    <div>
                        <label className="label">Already have an account? </label>
                        <a className="link" href ="/login">Login</a>
                    </div>
                </form>
            </div>
        </div>
    )
}


function validateEmail(email) {
    const emailPattern = /^[^\s@]+@[^\s@]+\.com+$/;
    return emailPattern.test(email);
}