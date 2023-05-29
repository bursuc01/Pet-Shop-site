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
    const loggedInUser = JSON.parse(localStorage.getItem("loggedInUser"));

    console.log(productSelected);
    console.log(loggedInUser);
    const order = cart.find((item) => item.client_id === loggedInUser.loggedUser.user_id);

    if (order) {
      addProductToOrder(order.order_id, productSelected.productSelected.product_id, inputValue);
    } else {
      createOrder(inputValue, "test", new Date(), loggedInUser.loggedUser.user_id);
      addProductToOrder(loggedInUser.loggedUser.user_id, productSelected.productSelected.product_id, inputValue);
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
