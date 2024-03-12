/** SISTEMA DE REGISTROS DE FUNCIONÁRIOS
 *
 * Desenvolva um sistema de registro de funcionários para uma empresa.
 * O sistema deverá permitir registrar diferentes tipos de funcionários e apresentar suas informações.
 *
 * Alguns passos abaixo:
 *
 * 1.Crie uma classe base chamada Funcionario com as seguintes propriedades:
 * - Nome (string): o nome do funcionário.
 * - Idade (int): a idade do funcionário.
 *
 * 2.Crie uma classe Gerente que herda da classe Funcionario e adicione uma propriedade adicional:
 * - Setor (string): o setor em que o gerente trabalha.
 *
 * 3.Crie uma classe Desenvolvedor que herda da classe Funcionario e adicione uma propriedade adicional:
 * - Linguagem (string): a linguagem de programação que o desenvolvedor utiliza.
 *
 * 4.Crie uma classe Analista que herda da classe Funcionario e adicione uma propriedade adicional:
 * - Area (string): a área de especialização do analista.
 *
 * 5.Imprima uma mensagem informando que um novo funcionário foi registrado, juntamente com o nome e a idade do
 * funcionário. (Lembre-se do init)
 *
 * 6. Crie um método na classe Funcionario chamado Apresentar que imprima uma mensagem de apresentação do funcionário,
 * incluindo o nome e a idade.
 *
 * 7. Crie uma lista de funcionários e adicione diferentes tipos de funcionários (gerentes, desenvolvedores e analistas)
 * à lista.
 *
 * 8. Utilize o typecast (is e as) para verificar o tipo de cada funcionário na lista e chamar o método Apresentar
 * correspondente.
 */
open class Funcionario(val nome: String, val idade: Int){
    init {
        println("Funcionário de Nome: $nome e Idade: $idade criado com Sucesso!!")
    }
    open fun apresentar(){
        println("Funcionario de Nome: $nome e Idade: $idade")
    }
}

class Gerente(val setor: String, nome: String, idade: Int): Funcionario(nome, idade){
    override fun apresentar() {
        println("Gerente: $nome, Idade: $idade, Setor: $setor")
    }
}

class Desenvolvedor(val linguagem: String, nome: String, idade: Int): Funcionario(nome,idade){
    override fun apresentar() {
        println("Desenvolvedor: $nome, Idade: $idade, Linguagem: $linguagem")
    }
}

class Analista(val area: String, nome: String, idade: Int): Funcionario(nome,idade){
    override fun apresentar() {
        println("Analista: $nome, Idade: $idade, Área: $area")
    }
}

fun main(){
    val gerente:Gerente = Gerente("RH","Juan",20)
    val desenvolvedor:Desenvolvedor = Desenvolvedor("Python","Marcela", 19)
    val analista:Analista = Analista("Requisitos","Matheus",19)
    val funcionarios: MutableList<Funcionario> = mutableListOf(gerente,desenvolvedor,analista)
    for(funcionario in funcionarios){
        if (funcionario is Gerente) {
            (funcionario as Gerente).apresentar()
        }else if(funcionario is Desenvolvedor){
            (funcionario as Desenvolvedor).apresentar()
        }else if(funcionario is Analista){
            (funcionario as Analista).apresentar()
        }
    }
}