import React, { useState, useEffect } from 'react'
import SidebarAdmin from '../components/Sidebar';
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogTitle from '@mui/material/DialogTitle';
import { DataGrid } from '@mui/x-data-grid';
// import DeleteIcon from '@mui/icons-material/Delete';
import EditIcon from '@mui/icons-material/Edit';
import axios from 'axios';
import { IconButton, MenuItem } from '@mui/material';

function Fournisseurs() {
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

    // const [produits, setProduits] = useState([])

    // const [id, setId] = useState(0)

    const columns = [
        { field: 'idPersonne', headerName: 'Id fournisseur', width: 130 },
        { field: 'nom', headerName: 'Nom', width: 200 },
        { field: 'prenom', headerName: 'Prénom', width: 200 },
        { field: 'email', headerName: 'Email', width: 350 },
        {
            field: 'update', headerName: 'Modifier', width: 100, sortable: false, renderCell: (params) => {
                return (
                    <IconButton key={params.id} color="success" aria-label="edit Item"
                        // onClick={() => {
                        // update(params.id)
                        // handleClickOuvrir()
                        // setId(params.id)
                        // console.log(id)
                    // } }
                    >
                        <EditIcon />
                    </IconButton>)
            }
        }
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

    const [fournisseurs, setFournisseurs] = useState([])
    useEffect(() => {
        const id = setInterval(() => {
            axios
                .get("http://localhost:9090/fournisseur/read")
                .then((res) => {
                    setFournisseurs(res.data);
                })
                .catch((err) => {
                    console.log(err);
                });
        }, 100);
        return () => clearInterval(id);
    }, [fournisseurs]);

    const [nom, setNom] = useState("")
    const [prenom, setPrenom] = useState("")
    const [adresse, setAdresse] = useState("")
    const [sexe, setSexe] = useState("")
    const [email, setEmail] = useState("")
    const [motDePasse, setMotDePasse] = useState("")
    // const [type, setType] = useState("")
    const data = {
        nom: nom,
        prenom: prenom,
        adresse: adresse,
        sexe: sexe,
        email: email,
        motDePasse: motDePasse,
        // type: type
    }
    const create = () => {
        axios
            .post("http://localhost:9090/fournisseur/create", data)
            .then(handleClose)
            .catch((err) => { console.log(err) });
    };

    const select = [
        {
            value: 'M',
            label: 'Masculin',
        },
        {
            value: 'F',
            label: 'féminin',
        }
    ];

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
                        <button type="button" className="btn btn-primary m-3" onClick={handleClickOpen}>Ajouter fournisseur</button>
                    </div>
                    <DataGrid className="d-flex shadow p-3 bg-body rounded m-0 "
                        columns={columns}
                        rows={fournisseurs}
                        pageSize={7}
                        rowsPerPageOptions={[5]}
                        getRowId={(rows) => (rows.idPersonne)}
                        sx={{ m: 0 }}
                    />
                    <Dialog open={open} onClose={handleClose}>
                        <DialogTitle>Ajouter fournisseur</DialogTitle>
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
                                    label="prenom"
                                    type="text"
                                    fullWidth
                                    variant="outlined"
                                    onChange={(e) => {
                                        setPrenom(e.target.value)
                                    }}
                                />
                                <TextField
                                    key="adresse"
                                    autoFocus
                                    margin="dense"
                                    id="adresse"
                                    label="adresse"
                                    type="text"
                                    fullWidth
                                    variant="outlined"
                                    onChange={(e) => {
                                        setAdresse(e.target.value)
                                    }}
                                />
                                <TextField
                                    id="outlined-select-currency"
                                    select
                                    label="Sexe"
                                    fullWidth
                                    helperText="Veuillez choisir le sexe"
                                    onChange={(e) => { setSexe(e.target.value) }}
                                >
                                    {select.map((option) => (
                                        <MenuItem key={option.value} value={option.value}>
                                            {option.label}
                                        </MenuItem>
                                    ))}
                                </TextField>
                                <TextField
                                    key="email"
                                    autoFocus
                                    margin="dense"
                                    label="email"
                                    type="email"
                                    fullWidth
                                    variant="outlined"
                                    onChange={(e) => {
                                        setEmail(e.target.value)
                                    }}
                                />
                                <TextField
                                    key="password"
                                    autoFocus
                                    margin="dense"
                                    // id="adresse"
                                    label="Mot de passe"
                                    type="password"
                                    fullWidth
                                    variant="outlined"
                                    onChange={(e) => {
                                        setMotDePasse(e.target.value)
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

export default Fournisseurs;