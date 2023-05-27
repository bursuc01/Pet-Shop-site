import './App'
import './CSS/App.css'
import sale from './Images/sale.jpg'
import facebook from './Images/Facebook-Icon.png'
import twitter from './Images/Twitter-Icon.png'
import instagram from './Images/Instagram-Icon.png'
import youtube from './Images/Youtube-Icon.png'

export default function MainPage(){
    const loggedInUser = JSON.parse(localStorage.getItem("loggedInUser"));
    console.log(loggedInUser)
    
    return(
        <div className="App">
            <div className="mainpage">
                <a className={"sale"}>
                    <img className="sale" src = {sale} alt={"sale"}/>
                </a>
                <div className="transparent-container">
                    <h1>
                        {loggedInUser ? (
                            `Welcome to THE PETSHOP, ${loggedInUser.name}`
                        ) : (
                            "Welcome to THE PETSHOP"
                        )}
                    </h1>
                </div>
                <div className="wrapper">
                    <ul className="list">
                        <li> Get Social with Us</li>
                        <li><a href="/"> <img className="social" src={facebook} alt="Facebook"/></a></li>
                        <li><a href="/"> <img className="social" src={twitter} alt="Twitter"/></a></li>
                        <li><a href="/"> <img className="social" src={instagram} alt="Instagram"/></a></li>
                        <li><a href="/"> <img className="social" src={youtube} alt="YouTube"/></a></li>
                    </ul>
                </div>
            </div>
        </div>
    );
}
