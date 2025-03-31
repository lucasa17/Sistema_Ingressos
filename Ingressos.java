package ingressos;

import java.util.Scanner;

public class Ingressos {

static Scanner scanner = new Scanner(System.in);

    static int menuCliente(){
        System.out.println("\n\n1. Cadastrar Pessoa");
        System.out.println("2. Listar Pessoas");
        System.out.println("3. Remover Pessoa");        
        System.out.println("8. Comprar Ingressos");
        System.out.println("0. Salvar e Sair"); 
        System.out.print("Escolha uma opção: ");
        int opCliente = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
    return opCliente;
    }
    
    static int menuEvento(){
        System.out.println("4. Cadastrar Evento");
        System.out.println("5. Atualizar Evento");
        System.out.println("6. Lista Eventos");
        System.out.println("7. Remover Evento");
        System.out.println("0. Salvar e Sair"); 
        System.out.print("Escolha uma opção: "); 
        int opEvento = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
    return opEvento;
    }
    
    public static void main(String[] args) {
        SistemaIngressos sistema = new SistemaIngressos();
        String nomeArquivoPessoas = "pessoas.txt";
        String nomeArquivoEventos = "eventos.txt";
        // Carregar dados do arquivo
        sistema.carregarDadosPessoas(nomeArquivoPessoas);
        sistema.carregarDadosEventos(nomeArquivoEventos);

        while (true) {
            
            switch (opcao) {
                case 1:
                    System.out.print("CPF: ");
                    int cpf = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    System.out.print("Sexo (M/F): ");
                    char sexo = scanner.nextLine().charAt(0);
                    sistema.adicionarPessoa(new Pessoa(cpf, nome, idade, sexo, "."));
                    break;

                case 2:
                    System.out.println("Lista de Pessoas:");
                    sistema.listarPessoas();
                    break;

                case 3:
                    System.out.print("Cpf da Pessoa a remover: ");
                    int cpfRemover = scanner.nextInt();
                    sistema.removerPessoa(cpfRemover);
                    break;

                case 4:
                    System.out.print("Nome do Evento: ");
                    String nomeEvento = scanner.nextLine();
                    System.out.print("Data do Evento: ");
                    String dataEvento = scanner.nextLine();
                    System.out.print("Ingressos Disponíveis: ");
                    int ingressosDisponiveis = scanner.nextInt();
                    sistema.adicionarEvento(new Evento(nomeEvento, dataEvento, ingressosDisponiveis));
                break;
                
                case 5:
                    
                    sistema.listarEventos();

                    System.out.print("\nNome do evento a atualizar: ");
                    String nomeAtualizar = scanner.nextLine();
                    System.out.print("Novo Nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Nova data: ");
                    String novaData = scanner.nextLine();
                    scanner.nextLine(); // Limpar o buffer
                    System.out.print("Nova quantia de ingressos: ");
                    int novaQuantia = scanner.nextInt();
                    sistema.atualizarEvento(nomeAtualizar, new Evento(novoNome, novaData, novaQuantia));
                    break;

                case 6:
                    System.out.println("Lista de Eventos:");
                    sistema.listarEventos();
                    break;
                
                case 7:
                    System.out.print("Nome do evento a remover: ");
                    String nomeEventoRemove = scanner.nextLine();
                    sistema.removerEvento(nomeEventoRemove);
                break;
                    
                case 8:
                    System.out.print("Nome do Evento para comprar ingressos: ");
                    String eventoComprar = scanner.nextLine();
                    System.out.print("Quantidade de ingressos: ");
                    int quantidade = scanner.nextInt();
                    sistema.comprarIngresso(eventoComprar, quantidade);
                    break;

                case 0:
                    sistema.salvarDadosPessoas(nomeArquivoPessoas);
                    sistema.salvarDadosEventos(nomeArquivoEventos);
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    return; // Encerra o programa

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
