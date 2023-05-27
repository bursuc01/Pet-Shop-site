import './App'
import './CSS/App.css'

export default function Success(){
    const handleFormSubmit = (e) => {
        e.preventDefault();
        //cod
        window.location.href = '/';
    };
    return(
        <div className="App">
            <div className="main-container"><h1> Order placed! </h1>
                <div className="submit-button">
                    <a className="submit-link" href="/" onClick={handleFormSubmit}>Back to main page</a>
                </div>
            </div>
        </div>
    );
}