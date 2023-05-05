import java.util.ArrayList;
import java.util.Scanner;

public class Main {
        
    public static void main(String[] args) throws Exception {
        int opcao;
        Scanner scanner = new Scanner(System.in);
        String nome, data, local, opcaoIngresso;
        char letraAssento;
        int ingressosInt, ingressosMeia, numeroAssento;
        Partida partida = null;
        Assento assento;
        TipoIngresso tipo;
        final double VALOR_INGRESSO = 100.0;
        Ingresso ingresso = null;

        ArrayList<Partida> partidas = new ArrayList<Partida>();

        System.out.println("Sistema de compra de ingressos!");
        while (true) {
            System.out.println(opcoes());
            opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1:
                    System.out.println("Insira as informações da partida:");
                    System.out.print("Nome da partida: ");
                    nome = scanner.nextLine();
                    System.out.print("Data da partida: ");
                    data = scanner.nextLine();
                    System.out.print("Local da partida: ");
                    local = scanner.nextLine();
                    System.out.print("Número de ingressos tipo inteira: ");
                    ingressosInt = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Número de ingressos tipo meia: ");
                    ingressosMeia = scanner.nextInt();
                    scanner.nextLine();
                    partida = new Partida(nome, data, local, ingressosInt, ingressosMeia);
                    System.out.println("Partida criada!\n");
                    partidas.add(partida);
                    break;
                case 2:
                    if (partida != null) {
                        System.out.println("Qual partida deseja comprar?");
                        String partidaComprada = scanner.nextLine();
                        boolean controle = false;
                        for (Partida partidaComparar : partidas){
                            if (partidaComparar.nome.equals(partidaComprada)){
                                controle = true;
                                continue;  
                            }
                        }
                        if (controle == false){
                            System.out.println("Erro!");
                            break;
                        }
                        System.out.println("Vendendo um ingresso!");
                        System.out.print("Letra do assento: ");
                        letraAssento = scanner.next().charAt(0);
                        System.out.print("Número do assento: ");
                        numeroAssento = scanner.nextInt();
                        scanner.nextLine();
                        assento = new Assento(numeroAssento, letraAssento);
    
                        System.out.print("O seu ingresso é meia (s/n)? ");
                        opcaoIngresso = scanner.nextLine();
    
                        if (opcaoIngresso.equals("s")) {
                            tipo = TipoIngresso.MEIA;
    
                            ingresso = new IngressoMeia(partida, assento, VALOR_INGRESSO / 2);
                        } else {
                            tipo = TipoIngresso.INTEIRA;
    
                            ingresso = new IngressoInteira(partida, assento, VALOR_INGRESSO);
                        }
                        partida.venderIngresso(tipo);
                    } else {
                        System.out.println("Você precisa primeiro cadastrar uma partida!");
                    }
                    break;
                case 3:
                    if (partida != null) {
                        System.out.println("Informações da partida:");
                        for (int i = 0; i < partidas.size(); i++){
                            System.out.println(partidas.get(i) + "\n");
                        }
                    } else {
                        System.out.println("Você precisa primeiro cadastrar uma partida!");
                    }
                    break;
                case 4:
                    if (partida != null) {
                        for(Partida partida2 : partidas){
                            System.out.println("O número de ingressos disponíveis é " + partida2.getIngressos() +" " + partida2.nome);
                        }
                    } else {
                        System.out.println("Você precisa primeiro cadastrar uma partida!");
                    }
                    break;
                case 5:
                    if (ingresso != null) {
                        System.out.println("Informações sobre o último ingresso vendido:");
                        System.out.println(ingresso);
                    } else {
                        System.out.println("Você precisa primeiro vender um ingresso!");
                    }
                    break;
                default:
                    opcao = 0;
            }

            if (opcao == 0) {
                System.out.println("Saindo do programa...");
                break;
            }
        }

        scanner.close();

        System.out.println(partidas);
    }

    public static String opcoes() {
        String msg;

        msg = "\n------\n";
        msg += "Insira a opção desejada conforme o menu abaixo, ou digite outra mensagem para sair do programa:\n";
        msg += "1 - Cadastrar uma nova partida;\n";
        msg += "2 - Realizar a venda de um ingresso;\n";
        msg += "3 - Exibir informações da partida;\n";
        msg += "4 - Exibir o número de ingressos restantes;\n";
        msg += "5 - Exibir informações sobre o último ingresso vendido;\n";

        return msg;
    }

    
}


