package ingressos;

public class Pessoa {
    public Integer cpf;
    public String nome;
    public int idade;
    public char sexo;
    public String evento;

    // Construtor, getters e setters
    public Pessoa(int cpf, String nome, int idade, char sexo, String evento) {
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.evento = evento;
    }

    @Override
    public String toString() {
        return cpf + "," +nome + "," + idade + "," + sexo + "," + evento;
    }
}
