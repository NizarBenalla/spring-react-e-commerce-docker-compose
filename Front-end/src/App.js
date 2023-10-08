import { BrowserRouter, Routes, Route } from "react-router-dom";
import React from 'react'
import Navbar from "./components/Navbar";
import Products from "./pages/Products";
import Wishlist from "./pages/Wishlist";
import Cart from "./pages/Cart";
import Product from "./pages/Product";
import Faq from "./pages/Faq";
import Admins from "./pages/Admins";
import SidebarAdmin from "./components/Sidebar";
import SignInSide from "./pages/SignInSide";
import SignUp from "./pages/SignUp";
import Clients from "./pages/Client";
import Produits from "./pages/Produits";
import Categorie from "./pages/Categorie";
import Fournisseurs from "./pages/fournisseurs";
import { useState } from "react";
import GuardedRoute from "./GuardedRoute";
import Footer from "./components/Footer";
import PrivateRoutes from "./utils/PrivateRoutes";
import { useEffect } from "react";
import NavbarAdmin from "./components/NavbarAdmin";
import SignInAdmin from "./pages/SignInAdmin";
import Profile from "./pages/Profile";


function App() {
  const [auth, setAuth] = useState({})
  const [adminLog, setAdminLog] = useState({})
  const [user, setUser] = useState('')
  const [client, setClient] = useState({})
  return (
    <BrowserRouter className="App">
      <Navbar aut={auth} adminLog={adminLog} admin={user} setAuth={setAuth} setAdminLog={setAdminLog} />
      <Routes>
        <Route path="/signin" element={<SignInSide setAuth={setAuth} setAdmin={setUser} setC={ setClient} />} />
        <Route path="/SignAdmin" element={<SignInAdmin setAdminLog={setAdminLog} setAdmin={setUser} />} />
        <Route path="/" element={<Products />} />
        <Route path="/wishlist" element={<Wishlist />} />
        <Route path="/product/:id" element={<Product />} />
        <Route path="/faq" element={<Faq />} />
        <Route path="/signup" element={<SignUp />} auth={setAuth} />
        <Route element={<PrivateRoutes aut={adminLog} />} >
          <Route path="/admin/admins" element={<Admins />} />
          <Route path="/admin/clients" element={<Clients />} />
          <Route path="/admin/produits" element={<Produits />} />
          <Route path="/admin/categories" element={<Categorie />} />
          <Route path="/admin/fournisseurs" element={<Fournisseurs />} />
        </Route>
        <Route element={<PrivateRoutes aut={auth} />} >
          <Route path="/profile" element={<Profile />} client={ client } />
          <Route path="/cart" element={<Cart />} />
        </Route>


      </Routes>
      <Footer />
    </BrowserRouter>
  );
}

export default App;
