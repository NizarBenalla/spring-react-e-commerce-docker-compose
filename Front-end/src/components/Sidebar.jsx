import React from 'react'
import { Sidebar, Menu, MenuItem, useProSidebar } from 'react-pro-sidebar';
import { Link } from 'react-router-dom';

function SidebarAdmin({setAuth}) {
    const { collapseSidebar } = useProSidebar();

    return (
        <div style={{ display: 'flex', height: '100%' }}>
            <Sidebar>
                <Menu>
                    <MenuItem routerLink={<Link to="/admin/admins" />}> Gestion administrateurs</MenuItem>
                    <MenuItem routerLink={<Link to="/admin/clients"/>}> Gestion clients</MenuItem>
                    <MenuItem routerLink={<Link to="/admin/produits"/>}> Gestion produits</MenuItem>
                    <MenuItem routerLink={<Link to="/admin/categories"/>}> Gestion catégories</MenuItem>
                    {/* <MenuItem> Gestion commandes</MenuItem>
                    <MenuItem> Gestion actualités</MenuItem> */}
                    <MenuItem> Gestion offres</MenuItem>
                    <MenuItem routerLink={<Link to="/admin/fournisseurs"/>}> Gestion fournisseurs</MenuItem>
                    {/* <MenuItem onClick={setAuth({'token':true})}> Déconnecter</MenuItem> */}
                </Menu>
            </Sidebar>
            {/* <main>
                <button onClick={() => collapseSidebar()}>Collapse</button>
            </main> */}
        </div>
    );
}

export default SidebarAdmin;