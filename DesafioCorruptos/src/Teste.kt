fun main(args: Array<String>) {
    var ativa: Int = 0
    var passiva: Int = 0
    var sistemica: Int = 0
    var iniciante: Int = 0
    var media: Int = 0
    var avancada: Int = 0
    var usuarios: MutableList<Usuario> = mutableListOf()

    var u1 = Usuario("corrupto1",50000.00)
    var u2 = Usuario("corrupto2",40000.00)
    var u3 = Usuario("corrupto3",60000.00)
    var u4 = Usuario("corrupto4",55000.00)

    var c1 = Corrupcao(Tipo.ATIVA,"pagamento de suborno durante blitz",400.00,1)
    var c2 = Corrupcao(Tipo.PASSIVA,"superfaturamento de obra pública",400000.00,1)
    var c3 = Corrupcao(Tipo.SISTEMICA,"mensalao",600000.00,12)
    var c4 = Corrupcao(Tipo.ATIVA,"pagamento de suborno para expedição de alvará",40000.00,2)
    var c5 = Corrupcao(Tipo.PASSIVA,"licença médica fraudulenta",0.0,1)
    var c6 = Corrupcao(Tipo.SISTEMICA,"liberação de verbas para favorecimento parlamentar",7000000.00,5)

    u1.delitos.add(c1)
    u1.delitos.add(c2)
    u2.delitos.add(c1)
    u3.delitos.add(c3)
    u4.delitos.add(c5)
    u2.delitos.add(c4)
    u2.delitos.add(c6)

    usuarios.add(u1)
    usuarios.add(u2)
    usuarios.add(u3)
    usuarios.add(u4)

    for (u in usuarios){
        for (d in u.delitos){
            when(d.tipo){
                Tipo.ATIVA -> ativa++
                Tipo.SISTEMICA -> sistemica++
                Tipo.PASSIVA -> passiva++
            }
        }
    }

    println("TIPOS DE CORRUPÇÃO:\nAtiva - ${ativa}\nPassiva - ${passiva}\nSistemica - ${sistemica}\n")

    for (u in usuarios){
        for (d in u.delitos){
            if (d.valor == 0.0)
                iniciante++
            else if (d.valor < 5000 && d.frequencia <=1)
                media++
            else
                avancada++
        }
    }

    println("NÍVEIS DE CORRUPÇÃO:\nIniciante - ${iniciante}\nMédia - ${media}\nAvançada - ${avancada}\n")

    for (u in usuarios){
        println("${u.toString()}\nRoubado: ${u.totalRoubado()}")
    }
}