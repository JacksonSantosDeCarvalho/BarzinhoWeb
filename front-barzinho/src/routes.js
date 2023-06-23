import React from "react";
import { Route, BrowserRouter, Routes } from "react-router-dom";
import ListarComanda from "./ListarComanda";
import CadastrarComanda from "./CadastrarComanda";



const Routess = () => {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" exact element={<ListarComanda></ListarComanda>} />
                <Route element={<CadastrarComanda></CadastrarComanda>} path="/cadastrar" />
            </Routes>
        </BrowserRouter>
    )
}

export default Routess;