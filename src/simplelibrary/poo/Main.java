package simplelibrary.poo;

import simplelibrary.poo.dao.EmprestimoDAO;

public class Main {

    public static void main(String[] args) {

        try {
            EmprestimoDAO dao = new EmprestimoDAO();

            // ✅ TESTE 1: devolver o livro 1 (estava emprestado)
            dao.devolverPorLivro(1);
            System.out.println("Devolução do livro 1 feita com sucesso!");

            // ✅ TESTE 2: emprestar o livro 2 para o usuário 1
            dao.emprestar(1, 2);
            System.out.println("Empréstimo do livro 2 feito com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro:");
            e.printStackTrace();
        }
    }
}
