import java.util.ArrayList;
import java.util.Scanner;

public class main {

    static ArrayList<Livro> catalogo = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int proximoId = 1;

    public static void main(String[] args) {

        int opcao;

        do {
            mostrarMenu();
            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    cadastrarLivro();
                    break;
                case 2:
                    listarLivros();
                    break;
                case 3:
                    buscarLivro();
                    break;
                case 4:
                    atualizarLivro();
                    break;
                case 5:
                    removerLivro();
                    break;
                case 0:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    // ===== MENU =====
    static void mostrarMenu() {
        System.out.println("\n=== CATÁLOGO DE LIVROS ===");
        System.out.println("1 - Cadastrar livro");
        System.out.println("2 - Listar livros");
        System.out.println("3 - Buscar livro");
        System.out.println("4 - Atualizar livro");
        System.out.println("5 - Remover livro");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
    }

    // ===== CADASTRAR =====
    static void cadastrarLivro() {
        System.out.print("Título: ");
        String titulo = sc.nextLine();

        System.out.print("Autor: ");
        String autor = sc.nextLine();

        System.out.print("Ano: ");
        int ano = sc.nextInt();
        sc.nextLine();

        System.out.print("Gênero: ");
        String genero = sc.nextLine();

        Livro livro = new Livro(proximoId, titulo, autor, ano, genero);
        catalogo.add(livro);
        proximoId++;

        System.out.println("Livro cadastrado com sucesso!");
    }

    // ===== LISTAR =====
    static void listarLivros() {
        if (catalogo.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }

        for (Livro livro : catalogo) {
            livro.mostrarLivro();
        }
    }

    // ===== BUSCAR =====
    static void buscarLivro() {
        System.out.print("Digite o ID do livro: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Livro livro : catalogo) {
            if (livro.getId() == id) {
                livro.mostrarLivro();
                return;
            }
        }

        System.out.println("Livro não encontrado.");
    }

    // ===== ATUALIZAR =====
    static void atualizarLivro() {
        System.out.print("Digite o ID do livro: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Livro livro : catalogo) {
            if (livro.getId() == id) {
                System.out.print("Novo título: ");
                livro.setTitulo(sc.nextLine());

                System.out.print("Novo autor: ");
                livro.setAutor(sc.nextLine());

                System.out.print("Novo ano: ");
                livro.setAno(sc.nextInt());
                sc.nextLine();

                System.out.print("Novo gênero: ");
                livro.setGenero(sc.nextLine());

                System.out.println("Livro atualizado!");
                return;
            }
        }

        System.out.println("Livro não encontrado.");
    }

    // ===== REMOVER =====
    static void removerLivro() {
        System.out.print("Digite o ID do livro: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < catalogo.size(); i++) {
            if (catalogo.get(i).getId() == id) {
                catalogo.remove(i);
                System.out.println("Livro removido!");
                return;
            }
        }

        System.out.println("Livro não encontrado.");
    }

    static class Livro {
        private int id;
        private String titulo;
        private String autor;
        private int ano;
        private String genero;

        public Livro(int id, String titulo, String autor, int ano, String genero) {
            this.id = id;
            this.titulo = titulo;
            this.autor = autor;
            this.ano = ano;
            this.genero = genero;
        }

        public int getId() {
            return id;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public String getAutor() {
            return autor;
        }

        public void setAutor(String autor) {
            this.autor = autor;
        }

        public int getAno() {
            return ano;
        }

        public void setAno(int ano) {
            this.ano = ano;
        }

        public String getGenero() {
            return genero;
        }

        public void setGenero(String genero) {
            this.genero = genero;
        }

        public void mostrarLivro() {
            System.out.println("ID: " + id);
            System.out.println("Título: " + titulo);
            System.out.println("Autor: " + autor);
            System.out.println("Ano: " + ano);
            System.out.println("Gênero: " + genero);
            System.out.println();
        }
    }
}