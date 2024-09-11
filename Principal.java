import dados.Biblioteca;
import dados.Livro;
import dados.Usuario;

public class Principal {
    public static void main(String[] args) {
        System.out.println("===================================");
        System.out.println(" ");
        System.out.println("@brunoccs100");
        System.out.println(" ");
        System.out.println("====================================");
        Livro livro = new Livro("Harry Potter Ordem da Fenix");
        Usuario usuario = new Usuario("Bruno de Castro");
        Biblioteca biblioteca = new Biblioteca(livro, usuario);
        biblioteca.solicitarEmprestimo();
        biblioteca.solicitarEmprestimo();
        biblioteca.devolverLivro();
        biblioteca.devolverLivro();
    }
}
