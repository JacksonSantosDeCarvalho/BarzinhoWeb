import {useEffect,useState} from 'react';
import './App.css';
import CadastrarComanda from './CadastrarComanda';
import ListarComanda from './ListarComanda';


function App() {

  const [comandas, setComandas] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/comandas")
      .then(retorno => retorno.json())
      .then(retornoConvertidoEmJson =>
        setComandas(retornoConvertidoEmJson))

  }, [])//esse colchete é para realizar a requisição uma vez

  return (
    <div className="App">
      <p>{JSON.stringify(comandas)}</p>
      <CadastrarComanda></CadastrarComanda>
      <ListarComanda lista={comandas}></ListarComanda>
    </div>
  );
}

export default App;
