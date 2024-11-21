package Main;

import Biblioteca.Biblioteca;
import Livro.Livro;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Biblioteca ===");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Remover Livro");
            System.out.println("3. Mostrar Todos os Livros");
            System.out.println("4. Buscar Livro por Título");
            System.out.println("5. Buscar Livro por Autor");
            System.out.println("6. Alugar Livro");
            System.out.println("7. Devolver Livro");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\n=== Adicionar Livro ===");
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ano de Publicação: ");
                    int anoPublicacao = scanner.nextInt();
                    System.out.print("Está disponível (true/false)? ");
                    boolean disponivel = scanner.nextBoolean();
                    scanner.nextLine();

                    Livro novoLivro = new Livro(titulo, autor, anoPublicacao, disponivel);
                    biblioteca.adicionarLivro(novoLivro);
                    System.out.println("Livro adicionado com sucesso!");
                    break;

                case 2:
                    System.out.println("\n=== Remover Livro ===");
                    System.out.print("Título do livro a ser removido: ");
                    String tituloRemover = scanner.nextLine();
                    List<Livro> livrosARemover = biblioteca.mostrarLivroPorTitulo(tituloRemover);

                    if (livrosARemover.isEmpty()) {
                        System.out.println("Nenhum livro encontrado com o título: " + tituloRemover);
                    } else {
                        Livro livroRemover = livrosARemover.get(0);
                        biblioteca.removerLivro(livroRemover);
                        System.out.println("Livro removido com sucesso!");
                    }
                    break;

                case 3:
                    System.out.println("\n=== Todos os Livros ===");
                    List<Livro> todosLivros = biblioteca.mostarTodosOsLivros();

                    if (todosLivros.isEmpty()) {
                        System.out.println("A biblioteca está vazia.");
                    } else {
                        for (Livro livro : todosLivros) {
                            System.out.println(livro.getTitulo() + " - " + livro.getAutor() + " (" + livro.getAnoPublicacao() + ")"
                                    + (livro.isDisponivel() ? " [Disponível]" : " [Indisponível]"));
                        }
                    }
                    break;

                case 4:
                    System.out.println("\n=== Buscar Livro por Título ===");
                    System.out.print("Título: ");
                    String tituloBusca = scanner.nextLine();
                    List<Livro> livrosPorTitulo = biblioteca.mostrarLivroPorTitulo(tituloBusca);

                    if (livrosPorTitulo.isEmpty()) {
                        System.out.println("Nenhum livro encontrado com o título: " + tituloBusca);
                    } else {
                        for (Livro livro : livrosPorTitulo) {
                            System.out.println(livro.getTitulo() + " - " + livro.getAutor() + " (" + livro.getAnoPublicacao() + ")");
                        }
                    }
                    break;

                case 5:
                    System.out.println("\n=== Buscar Livro por Autor ===");
                    System.out.print("Autor: ");
                    String autorBusca = scanner.nextLine();
                    List<Livro> livrosPorAutor = biblioteca.mostrarLivroPorAutor(autorBusca);

                    if (livrosPorAutor.isEmpty()) {
                        System.out.println("Nenhum livro encontrado do autor: " + autorBusca);
                    } else {
                        for (Livro livro : livrosPorAutor) {
                            System.out.println(livro.getTitulo() + " - " + livro.getAutor() + " (" + livro.getAnoPublicacao() + ")");
                        }
                    }
                    break;
                    
                case 6: 
                	System.out.println("Titulo: ");
                	String tituloAlugar = scanner.nextLine();
                	
                	boolean resultadoAlugar = biblioteca.alugarLivro(tituloAlugar);
                	if(resultadoAlugar) {
                		System.out.println("Livro alugado com sucesso!");
                	} else {
                		System.out.println("Livro Indisponível");
                	}
                	
                	break;
                	
                case 7:
                	System.out.println("Titulo: ");
                	String tituloDevolver = scanner.nextLine();
                	
                	boolean resultadoDevolver = biblioteca.devolverLivro(tituloDevolver);
                	if(resultadoDevolver) {
                		System.out.println("Livro devolvido com sucesso!");
                	} else {
                		System.out.println("Livro não encontrado para devolução");
                	}
                	
                	break;
                	
                case 8:
                    System.out.println("Programa encerrado. Até logo!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}

