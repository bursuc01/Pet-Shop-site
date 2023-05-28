import axios from 'axios';

export function getOrders(callback){
    axios.get("http://localhost:8080/getOrder").then((response) =>{
        if ((response.status === 200) && response.data){
            callback(response.data.fetched);
        }
        else{
            callback(null);
        }   
    });
}

export function createOrder(orderQuantity, details, date, client_id) {
    const url = 'http://localhost:8080/createOrder'; // Replace with your backend URL
  
    // Data to send in the request body
    const data = {
      orderQuantity: orderQuantity,
      details: details,
      date: date,
      client_id: client_id
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
  

