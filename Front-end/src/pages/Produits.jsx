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


function Produits() {
    const [open, setOpen] = React.useState(false);
    const [ouvrir, setOuvrir] = React.useState(false);

    const handleClickOuvrir = (id) => {
        setOuvrir(true);
        // admins.forEach((e) => e.id === id ? admin = e : e)
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


    // const handleChange = (event) => {
    //     setAge(event.target.value);
    // };

    const [produits, setProduits] = useState([])

    // const [id, setId] = useState(0)

    const columns = [
        { field: 'id', headerName: 'Id produit', width: 130 },
        { field: 'nom', headerName: 'Nom', width: 200 },
        { field: 'description', headerName: 'Description', width: 400 },
        { field: 'prix', headerName: 'prix', width: 200},
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
        {
            field: 'delete', headerName: 'Suprimer', width: 100, sortable: false, renderCell: (params) => {
                return (
                    // <IconButton key={params.id} color="error" aria-label="remove Item" >
                    <DeleteIcon onClick={() => { deleteItem(params.id) }} />
                    // </IconButton>
                )
            }
        }
    ]

    const deleteItem = (id) => {
        axios
            .delete(`http://localhost:9090/produit/delete/${id}`)
            .catch((err) => console.log(err));
    }

    const [admin, setAdmin] = useState({});

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
        axios
            .get("http://localhost:9090/categorie/read")
            .then((res) => { setCategories(res.data) })
            .catch((err) => { console.log(err) })
    }, [])

    useEffect(() => {
        const id = setInterval(() => {
            axios
                .get("http://localhost:9090/produit/read")
                .then((res) => {
                    setProduits(res.data);
                })
                .catch((err) => {
                    console.log(err);
                });
        }, 100);
        return () => clearInterval(id);
    }, [produits]);

    const [fournisseurs, setFournisseurs] = useState([])

    useEffect(() => {
        axios
            .get("http://localhost:9090/fournisseur/read")
            .then( res => {setFournisseurs(res.data)} )
            .catch((err) => { console.log(err) })
    }, [])

    

    const [nom, setNom] = useState("")
    const [description, setDescription] = useState("")
    const [prix, setPrix] = useState("")
    const [image, setImage] = useState("")
    const [categorie, setCategorie] = useState("")
    const [fournisseur, setFournisseur] = useState("")
    const data = {
        nom: nom,
        description: description,
        prix: prix,
        image: image,
        fournisseur: {
            idPersonne: fournisseur
        },
        categorie: {
            "idCategorie": categorie
        }
    }
    const create = () => {
        axios
            .post("http://localhost:9090/produit/create", data)
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
                        <button type="button" className="btn btn-primary m-3" onClick={handleClickOpen}>Ajouter produit</button>
                    </div>

                    <DataGrid className="d-flex shadow p-3 bg-body rounded m-0 "
                        columns={columns}
                        rows={produits}
                        pageSize={7}
                        rowsPerPageOptions={[5]}
                        // checkboxSelection
                        getRowId={(rows) => (rows.id)}
                        sx={{ m: 0 }}
                    />
                    <Dialog open={open} onClose={handleClose}>
                        <DialogTitle>Ajouter produit</DialogTitle>
                        <DialogContent>
                            <form >
                                <TextField
                                    key="nom"
                                    autoFocus
                                    margin="dense"
                                    id="nom"
                                    label="nom"
                                    type="text"
                                    fullWidth
                                    variant="outlined"
                                    onChange={(e) => {
                                        setNom(e.target.value)
                                    }}

                                />
                                <TextField
                                    key="prenom"
                                    autoFocus
                                    margin="dense"
                                    id="prenom"
                                    label="description"
                                    type="text"
                                    fullWidth
                                    variant="outlined"
                                    onChange={(e) => {
                                        setDescription(e.target.value)
                                    }}
                                />
                                <TextField
                                    key="adresse"
                                    autoFocus
                                    margin="dense"
                                    id="image"
                                    label="image"
                                    type="text"
                                    fullWidth
                                    variant="outlined"
                                    onChange={(e) => {
                                        setImage(e.target.value)
                                    }}
                                />
                                <TextField
                                    select
                                    key="idCategorie"
                                    autoFocus
                                    margin="dense"
                                    id="idCategorie"
                                    label="Categories"
                                    type="text"
                                    fullWidth
                                    variant="outlined"
                                    onChange={(e) => {
                                        setCategorie(e.target.value)
                                    }}
                                >
                                    {categories.map((option) => (
                                        <MenuItem key={option.idCategorie} value={option.idCategorie}>
                                            {option.description}
                                        </MenuItem>
                                    ))}
                                </TextField>
                                <TextField
                                    select
                                    key="idF"
                                    autoFocus
                                    margin="dense"
                                    id="idCategorie"
                                    label="fournisseurs"
                                    type="text"
                                    fullWidth
                                    variant="outlined"
                                    onChange={(e) => {
                                        setFournisseur(e.target.value)
                                    }}
                                >
                                    {fournisseurs.map((option) => (
                                        <MenuItem key={option.idPersonne} value={option.idPersonne}>
                                            {option.nom}
                                        </MenuItem>
                                    ))}
                                </TextField>
                                <TextField
                                    key="prix"
                                    autoFocus
                                    margin="dense"
                                    id="prix"
                                    label="prix"
                                    type="text"
                                    fullWidth
                                    variant="outlined"
                                    onChange={(e) => {
                                        setPrix(e.target.value)
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

export default Produits;

