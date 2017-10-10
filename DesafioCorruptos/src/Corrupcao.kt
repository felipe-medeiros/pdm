enum class Tipo {
    ATIVA, PASSIVA, SISTEMICA
}

class Corrupcao (
        var tipo: Tipo,
        var valor: Double,
        var frequencia: Int
){

}