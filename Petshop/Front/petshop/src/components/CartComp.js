import '../App'
import '../CSS/App.css'
import '../CSS/Carts.css'
import React from "react";
import { getOrders } from '../services/Order/Order';
import { useEffect, useState } from 'react';
import { getProduct } from '../services/Product/Product';
import { getProductOrdered } from '../services/PlacedOrders/ProductOrdered';
import { deleteOrder, deleteProductOrdered } from '../services/OrderRegistered/OrderedRegistered';
export default function Carts(){
    const [cart, setCart] = useState([]);
    const [products, setProducts] = useState([]);
    const [productsOrdered, setProductsOrdered] = useState([]);

    useEffect(() => {
        getOrders((data) => {
            if(data !== null){
                setCart(data);
            }
        });
        getProduct((data) => {
            if(data !== null){
                setProducts(data);
            }
        });
        getProductOrdered((data) => {
            if(data !== null){
                setProductsOrdered(data);
            }
        });
    }, []);


    const handleOrderSubmit = async (e) => {
        try {
          for (const item of cart) {
            const matchedProducts = productsOrdered.filter(
              (productOrdered) => productOrdered.order_id === item.order_id
            );
      
            for (const matchedProduct of matchedProducts) {
              await deleteProductOrdered(matchedProduct.productOrdered_id);
            }
      
            await deleteOrder(item.order_id);
          }
      
          // Delay for a certain period of time (e.g., 1 second)
          await new Promise((resolve) => setTimeout(resolve, 1000));
      
          window.location.href = '/Success';
        } catch (error) {
          console.error(error);
          // Handle the error gracefully
        }
      };
      
      
      
    return (
        <div className="App">
            <div className="cart-page">
                <div className="cart-items">
                    <h2 className="title">Cart</h2>
                    {cart.map((item) => {
                    const matchedProducts = productsOrdered.filter(
                        (productOrdered) => productOrdered.order_id === item.order_id
                    );

                    return (
                        <div>
                        <div key={item.order_id} className="cart-items">
                        {matchedProducts.map((matchedProduct) => {
                            const product = products.find(
                            (product) => product.product_id === matchedProduct.product_id
                            );

                            // Check if product is defined before accessing its properties
                            if (product) {
                            return (
                                <div key={matchedProduct.id} className="product-item">
                                <h3>{product.name}</h3>
                                <p>Quantity: {matchedProduct.ordered_quantity}</p>
                                <p>Price: ${product.price}</p>
                                </div>
                            );
                            } else {
                            // Render a placeholder or error message if product is not found
                            return <p key={matchedProduct.id}>No products selected!</p>;
                            }
                        })}
                        </div>
                        <h1 className="total-price">Total Price: {item.totalPrice.toFixed(2)}</h1>
                        </div>
                    );
                    })}
                </div>
                
                <div className="submit-button">
                    <span className="submit-link" onClick={handleOrderSubmit}>Order</span>
                </div>
            </div>
        </div>

    );

}