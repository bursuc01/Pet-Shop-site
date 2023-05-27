import axios from 'axios';

export function getQuestion(callback){
    axios.get("http://localhost:8080/getQuestion").then((response) =>{
        if ((response.status === 200) && response.data){
            callback(response.data.fetched);
        }
        else{
            callback(null);
        }
    });
}
