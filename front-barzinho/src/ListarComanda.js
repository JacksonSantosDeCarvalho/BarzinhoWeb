import { useEffect, useState } from 'react';
import { Link } from "react-router-dom";

function ListarComanda() {
    const [comandas, setComandas] = useState([]);
    useEffect(() => {
        fetch("http://localhost:8080/comandas")
            .then(retorno => retorno.json())
            .then(retornoConvertidoEmJson =>
                setComandas(retornoConvertidoEmJson))

    }, [])
    return (
        <div>
            <nav className='navbar fixed-top navbar-expand-lg bg-body-primary' >
                <div className='container-fluid'>
                    <div className='collapse navbar-collapse' id="navbarNav">
                        <ul className='navbar-nav'>
                            <li className='nav-item'><Link className='nav-link active' to="/cadastrar">Cadastrar</Link></li>
                        </ul>
                    </div>
                </div>
            </nav>
            <div className='App'>

                <table className="table">
                    <thead>
                        <tr>
                            <td>Id</td>
                            <td>Nome</td>
                            <td>Status</td>
                            <td>Ações</td>
                        </tr>
                    </thead>
                    <tbody>

                        {
                            comandas.map((obj, indice) =>
                            (
                                <tr key={indice}>
                                    <td>{obj.id}</td>
                                    <td>{obj.nome}</td>
                                    <td>{obj.status ? "Ocupado" : "Livre"}</td>
                                    <td>
                                        <input type="button" value='Editar' className="btn btn-secondary"></input>
                                        <input type="button" value='Remover' className="btn btn-danger"></input>
                                    </td>
                                </tr>
                            ))
                        }

                    </tbody>
                </table>
            </div>
        </div>
    )
}
export default ListarComanda;