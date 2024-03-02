fun main() {
    val repositorioAnimal = RepositorioAnimal()
    var opcao = 0
    while (opcao != 10) {
        menu()
        print("Digite a opção: ")
        opcao = readlnOrNull()?.toInt() ?: 0
        when (opcao) {
            0 -> {
                print("Digite o nome do novo Cachorro: ")
                var nome = readlnOrNull() ?: ""
                print("Digite a idade do novo Cachorro: ")
                val idade = readlnOrNull()?.toInt() ?: 0
                val cachorro = Cachorro(idade,Cor.RED)
                cachorro.nome = nome
                repositorioAnimal.adicionar(cachorro)
            }
            1 -> {
                print("Digite o nome do novo Gato: ")
                var nome = readlnOrNull() ?: ""
                print("Digite a idade do novo Gato: ")
                val idade = readlnOrNull()?.toInt() ?: 0
                val gato = Gato(idade, Cor.BLUE)
                gato.nome = nome
                repositorioAnimal.adicionar(gato)
            }
            2 -> {
                print("Digite o nome do novo Passaro: ")
                var nome = readlnOrNull() ?: ""
                print("Digite a idade do novo Passaro: ")
                val idade = readlnOrNull()?.toInt() ?: 0
                val passaro = Passaro(idade, Cor.GREEN)
                passaro.nome = nome
                repositorioAnimal.adicionar(passaro)
            }
            3 -> {
                print("Digite o nome do novo Humano: ")
                var nome = readlnOrNull() ?: ""
                print("Digite a idade do novo Humano: ")
                val idade = readlnOrNull()?.toInt() ?: 0
                val humano = Humano(idade, Cor.PELE)
                humano.nome = nome
                repositorioAnimal.adicionar(humano)
            }
            4 -> {
                repositorioAnimal.listar()
            }
            5 -> {
                repositorioAnimal.animais.forEach(Animal::emitirSom)
                repositorioAnimal.animais.forEach { it.emitirSom()}
            }
            6 -> {
                print("Digite o animal que deseja remover: ")
                var animalARemover = readlnOrNull() ?: ""
                repositorioAnimal.remover(animalARemover)
            }
            7 -> {
                print("Buscar Animal por qual Cor? ")
                val corAnimal = readlnOrNull()?.uppercase() ?: ""
                val cor = Cor.valueOf(corAnimal)
                repositorioAnimal.buscaAnimalPorCor(cor).forEach { println(it.nome) }
            }
            8 -> {
                print("Buscar Animal por qual Idade? ")
                val idade = readlnOrNull()?.toInt() ?: 0
                repositorioAnimal.buscaAnimalPorIdade(idade).forEach { println(it.nome) }
            }
            9 -> {
                print("Buscar Animal por qual Nome? ")
                val nome = readlnOrNull() ?: ""
                val animal = repositorioAnimal.buscaAnimalPorNome(nome)
                println(animal)
                if (animal == null){
                    println("Animal com Nome: ${nome} não encontrado")
                }
                else{
                    println("Animal encontrado com Nome: ${nome} Idade:${animal.idadeEmAnosHumanos()} e com Cor: ${animal.cor}")
                }
            }
        }

    }
}

abstract class Animal(var idade: Int, var cor: Cor) {
    open var nome: String = ""
        get() = "Animal: $field"
        set(valor) {
            field = valor
        }

    abstract fun emitirSom()

    open fun idadeEmAnosHumanos(): Int{
        return idade * 7
    }
}

class Cachorro(idade: Int, cor: Cor) : Animal(idade, cor) {
    override fun emitirSom() {
        println("Au au")
    }
}
class Gato(idade: Int, cor: Cor) : Animal(idade, cor) {
    override fun emitirSom() {
        println("Miau")
    }
}

class Passaro(idade: Int, cor: Cor) : Animal(idade, cor) {
    override fun emitirSom() {
        println("Piu piu")
    }
}

class Humano(idade: Int, cor: Cor) : Animal(idade, cor){
    override fun emitirSom() {
        println("Eita Deu bom!!!!")
    }

    override fun idadeEmAnosHumanos(): Int {
        return idade
    }
}

fun menu() {
    println("0 - Cachorro")
    println("1 - Gato")
    println("2 - Pássaro")
    println("3 - Humano")
    println("4 - Listar Animais")
    println("5 - Emitir som")
    println("6 - Remover Animal")
    println("7 - Buscar animal por Cor")
    println("8 - Buscar animal por Idade")
    println("9 - Buscar animal por Nome")
    println("10 - Sair")
}

class RepositorioAnimal {
    val animais: MutableList<Animal> = mutableListOf()

    fun adicionar(animal: Animal) {
        animais.add(animal)
    }

    fun listar() {
        animais.forEach { println(it.nome + " Cor: " + it.cor + " Idade em anos humanos: " + it.idadeEmAnosHumanos()) }
    }
    fun remover(nome: String){
        var animalARemover: List<Animal> = animais.filter {it.nome == nome}
        if (animalARemover.size > 0){
            animais.remove(animalARemover[0])
        }
        else{
            println("Animal não encontrado")
        }
    }
    fun buscaAnimalPorCor(cor: Cor): List<Animal>{
        return animais.filter {it.cor == cor}
    }
    fun buscaAnimalPorIdade(idade: Int): List<Animal>{
        return animais.filter {it.idade == idade}
    }
    fun buscaAnimalPorNome(nome: String): Animal?{
        val animal = animais.find { it.nome == "Animal: "+ nome }
        println(animal)
        if (animal != null){
            return animal
        }
        else{
            return null
        }
    }

}

enum class Cor(){
    RED,
    GREEN,
    BLUE,
    PELE,
}