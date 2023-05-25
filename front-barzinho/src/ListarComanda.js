function ListarComanda({ lista }) {
    return (
        <table className="table">
            <thead>
                <tr>
                    <td>Id</td>
                    <td>Nome</td>
                    <td>Status</td>
                </tr>
            </thead>
            <tbody>
                {
                    lista.map((obj, indice) =>
                    (
                        <tr key={indice}>
                            <td>{obj.id}</td>
                            <td>{obj.nome}</td>
                            <td>{obj.status?"Ocupado":"Livre"}</td>
                        </tr>
                    ))
                }

            </tbody>
        </table>
    )
}
export default ListarComanda;