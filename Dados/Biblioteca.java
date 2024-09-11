package dados;

public class Biblioteca {
    private dados.Livro livro;
    private dados.Usuario usuario;
    private dados.Emprestimo emprestimo;

    public Biblioteca(dados.Livro livro, dados.Usuario usuario) {
        this.livro = livro;
        this.usuario = usuario;
    }

    public void solicitarEmprestimo() {
        if (livro.isDisponivel()) {
            emprestimo = new dados.Emprestimo(livro, usuario);
            emprestimo.emitir();
        } else {
            System.out.println("O livro " + livro.getTitulo() + " não está disponível no momento.");
        }
    }

    public void devolverLivro() {
        if (emprestimo != null) {
            emprestimo.devolver();
            emprestimo.verificarMulta();
        } else {
            System.out.println("Nenhum empréstimo encontrado para devolução.");
        }
    }
}
