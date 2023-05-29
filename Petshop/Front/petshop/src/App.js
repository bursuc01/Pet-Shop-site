import Navbar from "./Navbar";
import Info from "./components/QuestionComp";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import MainPage from "./MainPage";
import Account from "./Account";
import ShoppingComp from "./components/ShoppingComp";
import Carts from "./components/CartComp";
import Success from "./Success";
import Login from "./components/LoginComp";
import RegisterComp from "./components/RegisterComp"
import QtyComp from "./components/QtyComp"

function App() {
    return (
        <section>
            <Navbar />
            <BrowserRouter>
                <Routes>
                    <Route path="/Info" element={<Info />}></Route>
                </Routes>
                <Routes>
                    <Route path="/" element={<MainPage />}></Route>
                </Routes>
                <Routes>
                    <Route path="/Account" element={<Account />}></Route>
                </Routes>
                <Routes>
                    <Route path="/Shopping" element={<ShoppingComp />}></Route>
                </Routes>
                <Routes>
                    <Route path="/Carts" element={<Carts />}></Route>
                </Routes>
                <Routes>
                    <Route path="/Success" element={<Success />}></Route>
                </Routes>
                <Routes>
                    <Route path="/Login" element={<Login />}></Route>
                </Routes>
                <Routes>
                    <Route path="/Register" element={<RegisterComp />}></Route>
                </Routes>
                <Routes>
                    <Route path="/Quantity" element={<QtyComp />}></Route>
                </Routes>
            </BrowserRouter>
        </section>
  );
}

export default App;
