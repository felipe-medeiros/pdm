class Usuario (
    var nome: String,
    var salario: Double
){
    var delitos: List<Corrupcao> = mutableListOf()

    public fun adicionarDelito(var delito: Corrupcao){
        delitos.
    }
    override fun toString(): String {
        return "Nome: ${this.nome} - Salário: ${this.salario}"
    }
}