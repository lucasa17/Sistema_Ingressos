package ingressos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SistemaIngressos {
    private List<Pessoa> listaPessoas = new ArrayList<>();
    private List<Evento> listaEventos = new ArrayList<>();

    public void adicionarPessoa(Pessoa pessoa) {
        
        listaPessoas.add(pessoa);
        
        
    }

    public void removerPessoa(String nome) {
        listaPessoas.removeIf(p -> p.nome.equals(nome));
    }

    public void atualizarEvento(String nome, Evento novoEvento) {
        for (int i = 0; i < listaPessoas.size(); i++) {
            if (listaEventos.get(i).nome.equals(nome)) {
                listaEventos.set(i, novoEvento);
                break;
            }
        }
    }

    public void listarPessoas() {
        for (Pessoa p : listaPessoas) {
            System.out.println("Nome: " + p.nome);
            System.out.println("Idade: " + p.idade);
            System.out.println("Sexo: " + p.sexo);
            System.out.println("Evento: " + p.evento);
        }
    }

    public void removerEvento(String nome) {
        listaEventos.removeIf(p -> p.nome.equals(nome));
    }
    public void adicionarEvento(Evento evento) {
                listaEventos.add(evento);
    }

    public void listarEventos() {
        for (Evento e : listaEventos) {
            System.out.println("Nome: " + e.nome);
            System.out.println("Data: " + e.data);
            System.out.println("Ingressos disponíveis: " + e.ingressosDisponiveis);
        }
    }

    public void comprarIngresso(String nomeEvento, int quantidade) {
        for (Evento e : listaEventos) {
            if (e.nome.equals(nomeEvento)) {
                e.comprarIngresso(quantidade);
            break;
            }
            else{
                System.out.println("Evento não encontrado");
            break;
            }
            }
        }
    

    public void salvarDadosPessoas(String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Pessoa p : listaPessoas) {
                writer.write(p.toString());
                writer.newLine();
            }
            System.out.println("Dados de pessoas salvos com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }
    
    
    public void salvarDadosEventos(String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Evento e : listaEventos) {
                writer.write(e.toString());
                writer.newLine();
            }
            System.out.println("Dados de Eventos salvos com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    public void carregarDadosPessoas(String nomeArquivo) {
        File arquivo = new File(nomeArquivo);
        if (arquivo.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
                String linha;
                while ((linha = reader.readLine()) != null) {
                    String[] campos = linha.split(",");
                    if (campos.length == 4) {
                        Pessoa novaPessoa = new Pessoa(campos[0], Integer.parseInt(campos[1]), campos[2].charAt(0), campos[3]);
                        listaPessoas.add(novaPessoa);
                    }
                }
                System.out.println("Dados de pessoas carregados com sucesso!");
            } catch (IOException e) {
                System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Erro: formato inválido nos dados do arquivo.");
            }
        } else {
            System.out.println("Arquivo não encontrado :(");
        }
    }
    
    
        public void carregarDadosEventos(String nomeArquivo) {
        File arquivo = new File(nomeArquivo);
        if (arquivo.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
                String linha;
                while ((linha = reader.readLine()) != null) {
                    String[] campos = linha.split(",");
                    if (campos.length == 3) {
                        Evento novoEvento = new Evento(campos[0], campos[1], Integer.parseInt(campos[2]));
                        listaEventos.add(novoEvento);
                    }
                }
                System.out.println("Dados de pessoas carregados com sucesso!");
            } catch (IOException e) {
                System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Erro: formato inválido nos dados do arquivo.");
            }
        } else {
            System.out.println("Arquivo não encontrado :(");
        }
    }
}
