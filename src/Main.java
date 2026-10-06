import java.util.Scanner;

public class Main {

    // Array que representa as vagas
    static String[] vagas = new String[10];

    // Pilha do estacionamento
    static Pilha pilha = new Pilha(10);

    // Scanner para entrada de dados
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int opcao;

        do {

            System.out.println("\n=================================");
            System.out.println("   SISTEMA DE ESTACIONAMENTO");
            System.out.println("=================================");

            System.out.println("1 - Estacionar veículo");
            System.out.println("2 - Listar vagas");
            System.out.println("3 - Consultar topo da pilha");
            System.out.println("4 - Retirar veículo da pilha");
            System.out.println("0 - Sair");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    cadastrarVeiculo();
                    break;

                case 2:
                    listarVagas();
                    break;

                case 3:
                    consultarTopo();
                    break;

                case 4:
                    retirarDaPilha();
                    break;

                case 0:
                    System.out.println("\nSistema encerrado.");
                    break;

                default:
                    System.out.println("\nOpção inválida!");
            }

        } while (opcao != 0);
    }

    // Cadastra um veículo
    public static void cadastrarVeiculo() {

        System.out.println("\n===== CADASTRO DE VEÍCULO =====");

        System.out.print("Digite a placa do veículo: ");
        String placa = scanner.nextLine();

        System.out.println("\nEscolha o tipo do veículo:");
        System.out.println("1 - Carro");
        System.out.println("2 - Moto");
        System.out.println("3 - Caminhão");

        System.out.print("Digite a opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        TipoVeiculo tipo;

        if (opcao == 1) {
            tipo = TipoVeiculo.CARRO;
        } else if (opcao == 2) {
            tipo = TipoVeiculo.MOTO;
        } else if (opcao == 3) {
            tipo = TipoVeiculo.CAMINHAO;
        } else {
            System.out.println("Tipo inválido!");
            return;
        }

        // Procura uma vaga livre
        for (int i = 0; i < vagas.length; i++) {

            if (vagas[i] == null) {

                vagas[i] = placa + " - " + tipo;

                // Coloca o veículo na pilha
                pilha.empilhar(placa);

                System.out.println("\nVeículo estacionado com sucesso!");
                System.out.println("Vaga: " + (i + 1));
                System.out.println("Placa: " + placa);
                System.out.println("Tipo: " + tipo);

                return;
            }
        }

        System.out.println("\nEstacionamento cheio!");
    }

    // Lista todas as vagas
    public static void listarVagas() {

        System.out.println("\n===== VAGAS DO ESTACIONAMENTO =====");

        for (int i = 0; i < vagas.length; i++) {

            if (vagas[i] == null) {
                System.out.println("Vaga " + (i + 1) + ": LIVRE");
            } else {
                System.out.println("Vaga " + (i + 1) + ": " + vagas[i]);
            }
        }
    }

    // Consulta o topo da pilha
    public static void consultarTopo() {

        String placa = pilha.consultarTopo();

        if (placa == null) {
            System.out.println("\nA pilha está vazia.");
        } else {
            System.out.println("\nVeículo no topo da pilha: " + placa);
        }
    }

    // Retira o veículo do topo da pilha
    public static void retirarDaPilha() {

        String placa = pilha.desempilhar();

        if (placa == null) {
            System.out.println("\nNão há veículos na pilha.");
        } else {
            System.out.println("\nVeículo retirado da pilha: " + placa);
        }
    }
}