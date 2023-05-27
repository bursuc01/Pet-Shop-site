import axios from 'axios';

export function getUsers(callback){
    axios.get("http://localhost:8080/getUser").then((response) =>{
        if ((response.status === 200) && response.data){
            callback(response.data.fetched);
        }
        else{
            callback(null);
        }
    });
}

export function getAdmins(callback){
    axios.get("http://localhost:8080/getAdmin").then((response) =>{
        if ((response.status === 200) && response.data){
            callback(response.data.fetched);
        }
        else{
            callback(null);
        }
    });
}

