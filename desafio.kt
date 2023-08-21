class Usuario(val nome: String, var email: String){
    override fun toString(): String {
        return "Usuario: '$nome', email: '$email')"
    }
}

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class ConteudoEducacional(val nome: String, var duracao: Int  ){
    override fun toString(): String {
        return "Materia: '$nome', duracao: $duracao minutos)"
    }
}

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivel: Nivel){


    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario){

        inscritos.add(usuario)
    }

    override fun toString(): String {
        return "Formacao: '$nome', conteudos: $conteudos, nivel: $nivel, inscritos: $inscritos)"
    }

}



fun main() {

    val us1 = Usuario("Arthur Souza", "arthurlucio@gmail.com")
    val us2 = Usuario("Joao Souza", "jaosouza@gmail.com")
    val us3 = Usuario("Maria Souza", "maria.souza@gmail.com")

    val conteudosAndroid = mutableListOf(ConteudoEducacional("Conhecendo o Kotlin", 120),
                                              ConteudoEducacional("POO em Kotlin", 120)      )

    val conteudosJava = mutableListOf(ConteudoEducacional("Logica de Programação em Java", 240),
        ConteudoEducacional("POO em Java", 120), ConteudoEducacional("Generics", 120))


    val conteudosGit = mutableListOf(ConteudoEducacional("Conhecendo Git e GitHub", 60),
        ConteudoEducacional("Baixando Git e Criando conta GitHub", 60), ConteudoEducacional("Versionamento", 120))

    val formacaoAd = Formacao("Formação Android", conteudosAndroid, Nivel.INTERMEDIARIO)
    val formacaoJava = Formacao("Formação Java", conteudosJava, Nivel.BASICO)
    val formacaoGit = Formacao("Formação Git", conteudosGit, Nivel.DIFICIL)



    formacaoAd.matricular(us1)
    formacaoJava.matricular(us2)
    formacaoGit.matricular(us3)

    println(formacaoGit)

}
