import '../App';
import '../CSS/App.css';
import '../CSS/Shopping.css';
import React, { useEffect, useState } from 'react';
import { getProduct } from '../services/Product/Product';
import image from '../Images/whiskas.png';

export default function ShoppingComp() {
    const [products, setProducts] = useState([]);

    useEffect(() => {
        getProduct((data) => {
            if (data !== null) {
                setProducts(data);
            }
        });
    }, []);

    const addToCart = (productName) => {
        const productSelected = products.find((product) => product.name === productName);
        // Add logic to handle adding the product to the cart
        localStorage.setItem('productSelected', JSON.stringify({productSelected}));
        console.log(`Added product ${productName} to cart.`);
        window.location.href = "/Quantity";
    };

    return (
        <div className="App">
            <div className="shopping-page">
                <div className="product-grid">
                    {products.map((product) => (
                        <div key={product.id} className="product-card">
                            <img src={image} alt={product.name} className="product-image" />
                            <h3 className="product-name">{product.name}</h3>
                            <p className="product-price">€{product.price}</p>
                            <p className="product-price">In stock: {product.quantity}</p>
                            <div className="quantity">   
                            </div>
                            <button
                                className="add-to-cart-button"
                                onClick={() => addToCart(product.name)}
                            >
                                Add to Cart
                            </button>
                        </div>
                    ))}
                </div>
            </div>
        </div>
    );
}
