package Biblioteca;

import Livro.Livro;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
	private List<Livro> livros;
	
	public Biblioteca() {
		this.livros = new ArrayList<>();
	}
	
	public void adicionarLivro(Livro livro) {
        this.livros.add(livro);
    }

    public void removerLivro(Livro livro) {
        this.livros.remove(livro);
    }
    
    public boolean alugarLivro(String titulo) {
    	for (Livro livro : this.livros) {
    		if (livro.isDisponivel() && livro.getTitulo().equalsIgnoreCase(titulo.trim())) {
    			livro.setDisponivel(false);
    			return true;
    		}
    	}
		return false;
    }
    
    public boolean devolverLivro(String titulo) {
    	for (Livro livro : this.livros) {
    		if (!livro.isDisponivel() && livro.getTitulo().equalsIgnoreCase(titulo.trim())) {
    			livro.setDisponivel(true);
    			return true;
    		}
    	}
		return false;
    }

    public List<Livro> mostarTodosOsLivros() {
        return this.livros;
    }
    
    public List<Livro> mostrarLivroPorTitulo(String titulo) {
        List<Livro> livrosEncontrados = new ArrayList<>();

        for (Livro livro : this.livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                livrosEncontrados.add(livro);
            }
        }

        return livrosEncontrados;
    }
    
    public List<Livro> mostrarLivroPorAutor(String autor) {
        List<Livro> livrosEncontrados = new ArrayList<>();

        for (Livro livro : this.livros) {
            if (livro.getAutor().equalsIgnoreCase(autor)) {
                livrosEncontrados.add(livro);
            }
        }

        return livrosEncontrados;
    }
}
