
export function deleteOrder(id){

    const url = 'http://localhost:8080/deleteOrder'; // Replace with your backend URL

    // Configure the request
    const options = {
      method: 'DELETE',
      headers: {
        'Content-Type': 'application/json' // Set the appropriate content type
      },
      body: JSON.stringify(id) // Convert data to JSON string
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

export function deleteProductOrdered(id){
    const url = 'http://localhost:8080/deleteProductOrdered'; // Replace with your backend URL
    
    
    // Configure the request
    const options = {
      method: 'DELETE',
      headers: {
        'Content-Type': 'application/json' // Set the appropriate content type
      },
      body: JSON.stringify(id) // Convert data to JSON string
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
   