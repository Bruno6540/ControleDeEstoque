import com.sun.source.tree.WhileLoopTree;

import java.lang.runtime.SwitchBootstraps;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        System.out.println("\nBem vindo ao estoque");
        System.out.println("--------------------");

        int escolha;
        System.out.println("*** Menu ***");
        System.out.println("1- Adicionar produto ao estoque");
        System.out.println("2- Remover produtos do estoque");
        System.out.println("3- Verificar estoque");
        System.out.println("4- Sair");
        System.out.println("Escolha uma opção: ");
        escolha = leitura.nextInt();

        switch (escolha) {
            case 1:
                System.out.println("Nome do produto: ");
                String nome = leitura.nextLine();
                System.out.println("Preço do produto: ");
                double preco = leitura.nextDouble();
                System.out.println("Quantidade: ");
                int quantidade = leitura.nextInt();
        }

    }
}