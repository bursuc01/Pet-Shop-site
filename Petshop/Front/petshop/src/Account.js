import './App';
import './CSS/App.css';
import { useState } from 'react';

export default function Account() {
  const [editMode] = useState(false);
  const loggedInUser = JSON.parse(localStorage.getItem("loggedInUser"));


  const handleInputChange = (e) => {
    // Handle input change logic here
  };

  const handleLogout = () => {
    // Clear user session or token
    localStorage.removeItem('loggedInUser');
    window.location.href = '/MainPage';
  };

  return (
    <div className="App">
      <div className="main-container">
        <h2 className="title">My Account</h2>
        <p>
          <span className="label">Name:</span>{' '}
          {editMode ? (
            <input
              type="text"
              name="name"
              value={loggedInUser.loggedUser.name}
              onChange={handleInputChange}
            />
          ) : (
            loggedInUser.loggedUser.name
          )}
        </p>
        <p>
          <span className="label">Email:</span>{' '}
          {editMode ? (
            <input
              type="text"
              name="email"
              value={loggedInUser.loggedUser.email}
              onChange={handleInputChange}
            />
          ) : (
            loggedInUser.loggedUser.email
          )}
        </p>
        <p>
          <span className="label">Phone:</span>{' '}
          {editMode ? (
            <input
              type="text"
              name="phone"
              value={loggedInUser.loggedUser.phone}
              onChange={handleInputChange}
            />
          ) : (
            loggedInUser.loggedUser.phone
          )}
        </p>
        <p>
          <span className="label">Address:</span>{' '}
          {editMode ? (
            <input
              type="text"
              name="address"
              value={loggedInUser.loggedUser.address}
              onChange={handleInputChange}
            />
          ) : (
            loggedInUser.loggedUser.address
          )}
        </p>
        <p>
          <span className="label">Password:</span>{' '}
          {editMode ? (
            <input
              type="password"
              name="password"
              value={loggedInUser.loggedUser.password}
              onChange={handleInputChange}
            />
          ) : (
            loggedInUser.loggedUser.password
          )}
        </p>
      </div>

      <button className="submit-button" onClick={handleLogout}>
        Log Out
      </button>
    </div>
  );
}
