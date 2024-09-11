package dados;

import java.util.Date;

public class Emprestimo {
    private dados.Livro livro;
    private dados.Usuario usuario;
    private Date dataEmprestimo;
    private Date dataDevolucao;
    private boolean multaAplicada;

    public Emprestimo(dados.Livro livro, dados.Usuario usuario) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = new Date(); // Data atual
        this.dataDevolucao = null;
        this.multaAplicada = false;
    }

    public void emitir() {
        livro.emprestar();
        System.out.println("Empréstimo emitido para " + usuario.getNome() + " com o livro " + livro.getTitulo() + ".");
    }

    public void devolver() {
        livro.devolver();
        dataDevolucao = new Date(); // Atualiza a data de devolução
        System.out.println("O livro " + livro.getTitulo() + " foi devolvido por " + usuario.getNome() + ".");
    }

    public void verificarMulta() {
        if (dataDevolucao == null) {
            System.out.println("O livro ainda não foi devolvido.");
            return;
        }

        long diffInMillies = Math.abs(dataDevolucao.getTime() - dataEmprestimo.getTime());
        long diff = diffInMillies / (24 * 60 * 60 * 1000); // Diferença em dias

        if (diff > 7 && !multaAplicada) { // Suponha que 7 dias é o prazo para devolução
            multaAplicada = true;
            System.out.println("Multa aplicada ao usuário " + usuario.getNome() + " por atraso na devolução.");
        }
    }
}
