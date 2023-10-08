import React, { useState, useEffect } from 'react'
import SidebarAdmin from '../components/Sidebar';
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogTitle from '@mui/material/DialogTitle';
import { DataGrid } from '@mui/x-data-grid';
import DeleteIcon from '@mui/icons-material/Delete';
import EditIcon from '@mui/icons-material/Edit';
import axios from 'axios';

function Categorie() {
    const [open, setOpen] = React.useState(false);
    const [ouvrir, setOuvrir] = React.useState(false);

    const handleClickOuvrir = (id) => {
        setOuvrir(true);
    };

    const handleFermer = () => {
        setOuvrir(false);
    };

    const handleClickOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
    };

    const [produits, setProduits] = useState([])

    // const [id, setId] = useState(0)

    const columns = [
        { field: 'idCategorie', headerName: 'Id produit', width: 130 },
        { field: 'description', headerName: 'Description', width: 400 },
        // {
        //     field: 'update', headerName: 'Modifier', width: 100, sortable: false, renderCell: (params) => {
        //         return (
        //             <IconButton key={params.id} color="success" aria-label="edit Item" onClick={() => {
        //                 update(params.id)
        //                 handleClickOuvrir()
        //                 setId(params.id)
        //                 console.log(id)
        //             }
        //             }>
        //                 <EditIcon />
        //             </IconButton>)
        //     }
        // },
        // {
        //     field: 'delete', headerName: 'Suprimer', width: 100, sortable: false, renderCell: (params) => {
        //         return (
        //             <DeleteIcon onClick={() => { deleteItem(params.id) }} />
        //         )
        //     }
        // }
    ]

    // const deleteItem = (id) => {
    //     axios
    //         .delete(`http://localhost:9090/categorie/delete/${id}`)
    //         .catch((err) => console.log(err));
    // }

    // const [admin, setAdmin] = useState({});
    // const update = (id) => {
    //     axios
    //         .get(`http://localhost:9090/administrateur/read/${id}`)
    //         .then((res) => {
    //             setAdmin(res.data)
    //         })
    //         .catch((err) => console.log(err))
    // }

    const [categories, setCategories] = useState([])
    useEffect(() => {
        const id = setInterval(() => {
            axios
                .get("http://localhost:9090/categorie/read")
                .then((res) => {
                    setCategories(res.data);
                })
                .catch((err) => {
                    console.log(err);
                });
        }, 100);
        return () => clearInterval(id);
    }, [produits]);

    const [description, setDescription] = useState("")
    const data = {
        description: description
    }
    const create = () => {
        axios
            .post("http://localhost:9090/categorie/create", data)
            .then(handleClose)
            .catch((err) => { console.log(err) });

    };

    // const updateItem = (id) => {
    //     axios
    //         .put(`http://localhost:9090/administrateur/update/${id}`, data)
    //         .then(handleClose)
    //         .catch((err) => { console.log(err) });

    // }
    return (
        <div className="">
            <div className='row'>
                <div className="col-12 col-sm-4 col-md-2 shadow">
                    <SidebarAdmin />
                </div>
                <div className="col-12 col-sm-8 col-md-10">
                    <div className="d-flex justify-content-end">
                        <button type="button" className="btn btn-primary m-3" onClick={handleClickOpen}>Ajouter catégorie</button>
                    </div>
                    <DataGrid className="d-flex shadow p-3 bg-body rounded m-0 "
                        columns={columns}
                        rows={categories}
                        pageSize={7}
                        rowsPerPageOptions={[5]}
                        getRowId={(rows) => (rows.idCategorie)}
                        sx={{ m: 0 }}
                    />
                    <Dialog open={open} onClose={handleClose}>
                        <DialogTitle>Ajouter catégorie</DialogTitle>
                        <DialogContent>
                            <form >
                                <TextField
                                    key="nom"
                                    autoFocus
                                    margin="dense"
                                    id="description"
                                    label="description"
                                    type="text"
                                    fullWidth
                                    variant="outlined"
                                    onChange={(e) => {
                                        setDescription(e.target.value)
                                    }}
                                />
                            </form>
                        </DialogContent>
                        <DialogActions>
                            <Button onClick={handleClose}>Retour</Button>
                            <Button onClick={create}>Ajouter</Button>
                        </DialogActions>
                    </Dialog>
                </div>
            </div>
        </div >
    )
}

export default Categorie;