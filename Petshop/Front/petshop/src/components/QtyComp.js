import React, { useEffect, useState } from 'react';
import { createOrder, getOrders } from '../services/Order/Order';
import '../CSS/App.css';
import { addProductToOrder } from '../services/PlacedOrders/ProductOrdered';

export default function InputPage() {
  const [inputValue, setInputValue] = useState('');
  const [cart, setCart] = useState([]);

  useEffect(() => {
    getOrders((data) => {
      if (data !== null) {
        setCart(data);
      }
    });
  }, []);

  const handleInputChange = (e) => {
    setInputValue(e.target.value);
  };

  const handleFormSubmit = (e) => {
    e.preventDefault();
    const productSelected = JSON.parse(localStorage.getItem("productSelected"));
    const productSelectedId = productSelected ? productSelected.product_id : null;
    const loggedInUser = JSON.parse(localStorage.getItem("loggedInUser"));
    const loggedInUserId = loggedInUser ? loggedInUser.user_id : null;

    console.log(productSelected.product_id);
    console.log(loggedInUser.user_id);
    const order = cart.find((item) => item.client_id === loggedInUserId);

    if (order) {
      addProductToOrder(order.order_id, productSelectedId, inputValue);
    } else {
      createOrder(inputValue, "test", new Date(), loggedInUserId);
      addProductToOrder(loggedInUserId, productSelectedId, inputValue);
    }
  };

  return (
    <div className="App">
      <div className="main-container">
        <h1>Enter quantity:</h1>
        <form onSubmit={handleFormSubmit}>
          <input
            type="text"
            value={inputValue}
            onChange={handleInputChange}
            className="input-field"
          />
          <div className="submit-button">
            <button type="submit" className="submit-button">
              Submit
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}
