package ingressos;

//import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Evento {
    public String nome;
    //Date data;
    public String data;
    public Integer ingressosDisponiveis;

    public Evento(String nome, String data, int ingressosDisponiveis) {
        this.nome = nome;
        this.data = data;
        this.ingressosDisponiveis = ingressosDisponiveis;
    }

    public void comprarIngresso(int quantidade) {
        if (quantidade <= ingressosDisponiveis) {
            ingressosDisponiveis -= quantidade;
            System.out.println("Ingressos comprados com sucesso!");
        }  
        else if(quantidade > ingressosDisponiveis){
            System.out.println("Ingressos insuficientes!");
        }
        else if(quantidade < 0){
            System.out.println("Ingressos negativos, compraq não aceita.");
        }
    }

    @Override
    public String toString() {
        return nome + "," + data + "," + ingressosDisponiveis;
    }
}
