enum class Tipo {
    ATIVA, PASSIVA, SISTEMICA
}

class Corrupcao (
        var tipo: Tipo,
        var descricao: String,
        var valor: Double = 0.0,
        var frequencia: Int = 1
){

}