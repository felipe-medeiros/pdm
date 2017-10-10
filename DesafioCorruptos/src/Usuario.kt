class Usuario (
    var nome: String,
    var salario: Double
){
    var delitos: MutableList<Corrupcao> = mutableListOf()

    public fun adicionarDelito(delito: Corrupcao){
        this.delitos.add(delito)
    }

    public fun totalRoubado(): Double{
        var montante: Double = 0.0
        for (d in delitos){
            montante += d.valor
        }
        return montante
    }
    override fun toString(): String {
        return "Nome: ${this.nome} - Salário: ${this.salario}"
    }
}