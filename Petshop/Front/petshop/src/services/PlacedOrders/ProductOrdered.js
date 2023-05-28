import axios from 'axios';

export function getProductOrdered(callback){
    axios.get("http://localhost:8080/getProductOrdered").then((response) =>{
        if ((response.status === 200) && response.data){
            callback(response.data.fetched);
        }
        else{
            callback(null);
        }
    });
}

export function addProductToOrder(order_id, product_id, qty){
    const url = 'http://localhost:8080/addToOrder'; // Replace with your backend URL
    
    // Data to send in the request body
    const data = {
      order_id: order_id,
      product_id: product_id,
      qty: qty
    };
    
    
    // Configure the request
    const options = {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json' // Set the appropriate content type
      },
      body: JSON.stringify(data) // Convert data to JSON string
    };
    
    // Make the request
    fetch(url, options)
      .then(response => response.json())
      .then(data => {
        // Handle the response from the backend
        console.log(data);
      })
      .catch(error => {
        // Handle any errors that occur during the request
        console.error('Error:', error);
      });
}





