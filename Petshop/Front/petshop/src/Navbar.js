import './CSS/Navbar.css';
import logo from './Images/Logo.png';

export default function Navbar() {
    const loggedInUser = localStorage.getItem("loggedInUser");

    const handleLogout = () => {
        localStorage.removeItem("loggedInUser");
        // Perform any other logout-related actions if needed
    };

    return (
        <div id="header">
            <nav className="navbar navbar-mainbg">
                <div className="title">
                    <a className="navbar-brand navbar-logo" href="/">
                        <img src={logo} alt="Logo" className="navbar-logo" />
                        PetShop
                    </a>
                </div>
                <div className="navbar-nav">
                    <ul className="navbar-nav-horizontal">
                        <li className="nav-item">
                            <a className="submit-link" href="/Info">
                                Info
                            </a>
                        </li>
                        {loggedInUser ? (
                            <ul className="navbar-nav-horizontal">
                                <li className="nav-item">
                                    <a className="submit-link" href="/Shopping">
                                        Shopping
                                    </a>
                                </li>
                                <li className="nav-item">
                                    <a className="submit-link" href="/Carts">
                                        Cart
                                    </a>
                                </li>
                                <li className="nav-item">
                                    <a className="submit-link" href="/Account">
                                        Account
                                    </a>
                                </li>
                                <li className="nav-item">
                                    <a className="submit-link" href="/Admin">
                                        Add Product
                                    </a>
                                </li>
                                <li className="nav-item">
                                    <a className="submit-link" href="/Login " onClick={handleLogout}>
                                        Logout
                                    </a>
                                </li>
                            </ul>
                        ) : (
                            <li className="nav-item">
                                <a className="submit-link" href="/Login">
                                    Login
                                </a>
                            </li>
                        )}
                    </ul>
                </div>
            </nav>
        </div>
    );
}
