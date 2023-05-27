
function Register(user){

const url = 'http://localhost:8080/createUser'; // Replace with your backend URL

// Data to send in the request body
const data = {
  name: user.name,
  email: user.email,
  password: user.password,
  phone: user.phone,
  address: user.address
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
    //Redirect
    window.location.href = '/login';
  })
  .catch(error => {
    // Handle any errors that occur during the request
    console.error('Error:', error);
  });
}

export default Register;