import '../App'
import '../CSS/App.css'
import '../CSS/Shopping.css';
import React, { useEffect, useState } from 'react'
import { getProduct } from '../services/Product/Product';
import image from '../Images/whiskas.png';

export default function ShoppingComp(){
    const [products, setProducts] = useState([]);
    
    useEffect(() => {
        getProduct((data) => {
            if(data !== null){
                setProducts(data);
            }
        });
    }, []);

    const addToCart = (productId) => {
        // Add logic to handle adding the product to the cart
        console.log(`Added product with ID ${productId} to cart.`);
    };

    const [quantity, setQuantity] = useState(1);

    const handleQuantityChange = (e) => {
        setQuantity(parseInt(e.target.value));
    };

    const handleDecrease = () => {
        if (quantity > 1) {
            setQuantity(quantity - 1);
        }
    };

    const handleIncrease = () => {
        setQuantity(quantity + 1);
    };


    return(
        <div className="App">
        <div className="shopping-page">
            <div className="product-grid">
                {products.map((product) => (
                    <div key={product.id} className="product-card">
                        <img src={image} alt={product.name} className="product-image" />
                        <h3 className="product-name">{product.name}</h3>
                        <p className="product-price">€{product.price}</p>
                        <div className="quantity">
                                <button onClick={handleDecrease}>-</button>
                                <input
                                    type="number"
                                    value={quantity}
                                    onChange={handleQuantityChange}
                                    min="1"
                                />
                                <button onClick={handleIncrease}>+</button>
                            </div>
                        <button
                            className="add-to-cart-button"
                            onClick={() => addToCart(product.id)}
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