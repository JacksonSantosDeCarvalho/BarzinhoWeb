import { useEffect, useState } from 'react';
import { Link } from "react-router-dom";

function CadastrarComanda() {

    const [comandas, setComandas] = useState([]);
    useEffect(() => {
        fetch("http://localhost:8080/comandas")
            .then(retorno => retorno.json())
            .then(retornoConvertidoEmJson =>
                setComandas(retornoConvertidoEmJson))

    }, [])

    const comanda = {
        id: 0,
        nome: ''
    }

    const [objComanda, setObjComanda] = useState(comanda)

    //esse colchete é para realizar a requisição uma vez

    const eventoDigitar = (e) => {
        setObjComanda({ ...objComanda, [e.target.name]: e.target.value })
    }

    const limparFormulario = () => {
        setObjComanda(comanda);
    }

    const cadastrar = () => {
        fetch('http://localhost:8080/comanda', {
            method: 'post',
            body: JSON.stringify(objComanda),
            headers: {
                'Content-type': 'application/json',
                'Accept': 'application/json'
            }
        }).
            then(retorno => retorno.json()).
            then(retornoConvertido => {
                if (retornoConvertido.mensagem !== undefined) {
                    alert(retornoConvertido.mensagem);
                } else {
                    setComandas([...comandas, retornoConvertido]);
                    alert("Salvo com sucesso!")
                    limparFormulario();
                }
            })
    }
    return (
        <div>
            <nav className='navbar fixed-top navbar-expand-lg bg-body-primary' >
                <div className='container-fluid'>
                    <div className='collapse navbar-collapse' id="navbarNav">
                        <ul className='navbar-nav'>
                            <li className='nav-item'><Link className='nav-link active' to="/">Listar</Link></li>
                        </ul>
                    </div>
                </div>
            </nav>
            <div className='App'>

                <form>
                    <input type='text' value={objComanda.nome} onChange={eventoDigitar} name="nome" placeholder="Nome" className="form-control" />

                    <input type='button' onClick={cadastrar} value='Salvar' className="btn btn-success" />|

                </form>
            </div>
        </div>

    )
}

export default CadastrarComanda;