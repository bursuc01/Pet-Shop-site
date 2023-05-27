import './App'
import './CSS/App.css'
import './CSS/Carts.css'
import React from "react";
import imageitem from './Images/whiskas.png'

export default function Carts(){
    const cartItems = [
        { id: 1, name: 'Product 1', image: imageitem, quantity: 2, price: 10 },
        { id: 2, name: 'Product 2', image: imageitem, quantity: 1, price: 15 },
        { id: 3, name: 'Product 3', image: imageitem, quantity: 3, price: 20 },
    ];

    const handleOrderSubmit = (e) => {
        
        //make order
    };

    return (
        <div className="App">
            <div className="cart-page">
                <div className="cart-items">
                    <h2 className="title">Cart</h2>
                    {cartItems.map((item) => (
                        <div key={item.id} className="cart-item">
                            <div className="item-details">
                                <img src={item.image} alt={item.name} className="item-image" />
                                <h3 className="item-name">{item.name}</h3>
                                <p className="item-quantity">Quantity: {item.quantity}</p>
                                <p className="item-price">Price: ${item.price}</p>
                            </div>
                        </div>
                    ))}
                </div>
                <div className="total-price cart-items">
                    Total Price: ${cartItems.reduce((total, item) => total + item.quantity * item.price, 0)}
                </div>
                <div className="submit-button">
                    <a className="submit-link" href="/Success" onClick={handleOrderSubmit}>Order</a>
                </div>
            </div>
        </div>

    );

}