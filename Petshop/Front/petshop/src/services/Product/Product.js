import axios from 'axios';

export function getProduct(callback){
    axios.get("http://localhost:8080/getProduct").then((response) =>{
        if ((response.status === 200) && response.data){
            callback(response.data.fetched);
        }
        else{
            callback(null);
        }
    });
}
