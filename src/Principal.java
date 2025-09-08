import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        ArrayList<Produto> estoque = new ArrayList<>();
        System.out.println("\nBem vindo ao estoque");
        System.out.println("--------------------");
        int escolha;
        do {
            System.out.println("\n*** Menu ***");
            System.out.println("1- Adicionar produto ao estoque");
            System.out.println("2- Remover produtos do estoque");
            System.out.println("3- Verificar estoque");
            System.out.println("4- Sair");
            System.out.println("Escolha uma opção: \n");
            escolha = leitura.nextInt();
            leitura.nextLine();
            switch (escolha) {
                case 1:
                    System.out.print("\nNome do produto: ");
                    String nome = leitura.nextLine();
                    System.out.print("Preço do produto: ");
                    double preco = leitura.nextDouble();
                    leitura.nextLine();
                    System.out.print("Quantidade: ");
                    int quantidade = leitura.nextInt();
                    leitura.nextLine();
                    boolean existe = false;
                    for (Produto p : estoque) {
                        if (p.getNome().equalsIgnoreCase(nome)) {
                            p.adicionarQuantidade(quantidade);
                            existe = true;
                            break;
                        }
                    }
                    if (!existe) {
                        estoque.add(new Produto(nome, preco, quantidade));
                    }
                    System.out.println("\nproduto adicionado com sucesso!");
                    break;
                case 2:
                    System.out.print("\nNome do produto para remover: ");
                    String removerNome = leitura.nextLine();
                    boolean encontrado = false;
                    for (int i = 0; i < estoque.size(); i++) {
                        Produto p = estoque.get(i);
                        if (p.getNome().equalsIgnoreCase(removerNome)) {
                            System.out.print("Quantidade para remover: ");
                            int removerQtd = leitura.nextInt();
                            leitura.nextLine();
                            p.removerQuantidade(removerQtd);
                            if (p.getQuantidade() == 0) {
                                estoque.remove(i);
                                System.out.println("Produto removido do estoque!\n");
                            } else {
                                System.out.println("Produto atualizado com sucesso!\n");
                            }
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.print("Produto não encontrado no estoque!\n");
                    }
                    break;
                case 3:
                    System.out.println("\n*** Estoque ***");
                    if (estoque.isEmpty()) {
                        System.out.println("nenhum produto cadastrado!\n");
                    } else {
                        double valorTotal = 0;
                        for (Produto p : estoque) {
                            System.out.println(p);
                            valorTotal += p.getPreco() * p.getQuantidade();
                        }
                        String valorFormatado = String.format("%.2f", valorTotal);
                        System.out.println("Valor total do estoque: R$ " + valorFormatado + ".");
                    }
                    break;
                case 4:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("opção inválida! Tente novamente.\n");
            }
        } while (escolha != 4);
        leitura.close();
    }
}