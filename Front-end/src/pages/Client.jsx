// import { Button } from '@mui/material';
// import { Button } from 'bootstrap';
import React, { useState, useEffect } from 'react'
import SidebarAdmin from '../components/Sidebar';
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogTitle from '@mui/material/DialogTitle';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import Select from '@mui/material/Select';
import { DataGrid } from '@mui/x-data-grid';
import { IconButton } from '@mui/material';
import DeleteIcon from '@mui/icons-material/Delete';
import EditIcon from '@mui/icons-material/Edit';
import axios from 'axios';


function Clients() {
    
    const [clients, setClients] = useState([])

    const columns = [
        { field: 'idPersonne', headerName: 'Id client', width: 130 },
        { field: 'nom', headerName: 'Nom', width: 200 },
        { field: 'prenom', headerName: 'Prénom', width: 200 },
        { field: 'email', headerName: 'Email', width: 350 },
        {
            field: 'delete', headerName: 'Suprimer', width: 100, sortable: false, renderCell: (params) => {
                return (
                    <DeleteIcon onClick={() => { deleteItem(params.id) }} />
                )
            }
        }
    ]

    const deleteItem = (id) => {
        axios
            .delete(`http://localhost:9090/client/delete/${id}`)
            // .then(console.log(id))
            .catch((err) => console.log(err));
    }

    useEffect(() => {
        const id = setInterval(() => {
            axios
                .get("http://localhost:9090/client/read")
                .then((res) => {
                    setClients(res.data);
                })
                .catch((err) => {
                    console.log(err);
                });
        }, 100);
        return () => clearInterval(id);
    }, [clients]);

    return (
        <div className="">
            <div className='row'>
                <div className="col-12 col-sm-4 col-md-2 shadow">
                    <SidebarAdmin />
                </div>
                <div className="col-12 col-sm-8 col-md-10">
                    <DataGrid className="d-flex shadow p-3 bg-body rounded m-0 "
                        columns={columns}
                        rows={clients}
                        pageSize={7}
                        rowsPerPageOptions={[5]}
                        // checkboxSelection
                        getRowId={(rows) => (rows.idPersonne)}
                        sx={{ m: 0 }}
                    />
                </div>
            </div>
        </div >
    )
}

export default Clients;

