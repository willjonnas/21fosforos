import java.util.Random;
import java.util.Scanner;
public class Main {

    static Scanner in = new Scanner(System.in);
    static Random rnd = new Random();
    static int fosforos = 21, retira;




    public static void main(String[] args) {

        int op;

        do {
            System.out.print("\n");
            System.out.print("\n");
            System.out.println("*********************************** ");
            System.out.println("*******Jogo dos 21 Fósforos******** ");
            System.out.println("*********************************** ");
            System.out.print("\n");
            System.out.println("Bem Vindo ");
            System.out.print("\n");
            System.out.println("Escolha uma das seguintes opções");
            System.out.println("1- Regras");
            System.out.println("2- Humano contra computador (sem inteligência)");
            System.out.println("3- Humano contra computador (Com inteligência)");
            System.out.println("4- Dois jogadores humanos");
            System.out.println("0- Sair");

            op = in.nextInt();

            switch (op) {
                case 1 -> Regras();
                case 2 -> Humano_compS();//sem inteligencia
                case 3 -> Humano_compC();//com inteligencia
                case 4 -> Dois_jogados();
                default -> System.out.println("Opção inválida");
            }
        } while (op != 0);

    }


    private static void Regras() {

        System.out.println("");
        System.out.println("");
        System.out.println("1- Regras");
        System.out.println("Jogo dos 21 Fosforos");
        System.out.println("Retire 1, 2, 3 ou 4 fosforos.");
        System.out.println("O jogador que ficar com 1 fosforo perde.");

    }

    private static void Dois_jogados() {

        //1. Dois jogadores humanos;

        in = new Scanner(System.in);
        System.out.println("Nome do primeiro jogador: ");
        String jogador_1 = in.nextLine();
        System.out.println("Nome do segundo jogador: ");
        String jogador_2 = in.nextLine();

        int vez = rnd.nextInt(1, 3); //Escolhe aleatóriamente qual é o 1º a jogar

        while (fosforos >= 1) {
            if (vez == 1) {//JOGADOR 1 COMEÇA A JOGAR
                System.out.println(jogador_1 + ", é a sua vez de jogar");
                Jogo();
                if (fosforos == 1) { //VERIFICA SE O JOGO TERMINOU
                    System.out.println("Parabéns, " + jogador_1 + ", você ganhou o jogo");
                    System.out.println("Não foi dessa vez, " + jogador_2);
                    fosforos = 21; //RENICIALIZA O JOGO
                    return;
                } else { //PASSA A VEZ AO JOGADOR
                    System.out.println(jogador_2 + ", é a sua vez de jogar");
                    Jogo();
                    if (fosforos == 1) {
                        System.out.println("Parabéns, " + jogador_2 + ",você ganhou o jogo");
                        System.out.println("Não foi dessa vez, " + jogador_1);
                        fosforos = 21; //RENICIALIZA O JOGO
                        return;
                    }
                }
            } else { //JOGADOR 2 COMEÇA A JOGAR
                System.out.println(jogador_2 + ", é a sua vez de jogar");
                Jogo();
                if (fosforos == 1) {
                    System.out.println("Parabéns, " + jogador_2 + ", você ganhou o jogo");
                    System.out.println("Não foi dessa vez, " + jogador_1);
                    fosforos = 21; //RENICIALIZA O JOGO
                    return;
                } else {
                    System.out.println(jogador_1 + " É a sua vez de jogar");
                    Jogo();
                    if (fosforos == 1) {
                        System.out.println("Parabéns, " + jogador_1 + ", você ganhou o jogo");
                        System.out.println("Não foi dessa vez, " + jogador_2);
                        fosforos = 21; //RENICIALIZA O JOGO
                        return;
                    }
                }
            }
        }

    }

    private static void Jogo() {
        //O jogo dos 21 fósforos coloca dois oponentes a retirar fósforos, à vez, até sobrar o último. Quem ficar com o último fósforo
        //perde. Em cada jogada é possível retirar 1, 2, 3 ou 4 fósforos. Implemente uma aplicação que permita jogar:
        int op = 1;
        while (op != 0) {
            System.out.println("Temos " + fosforos + " fosforos no jogo,  é possível retirar 1, 2, 3 ou 4 fósforos.");

            try {
                retira = in.nextInt();
                if (retira == 1 || retira == 2 || retira == 3 || retira == 4) {
                    if (fosforos - retira >= 1) {
                        fosforos = fosforos - retira;
                        return;
                    } else
                        System.out.println("Valor invalido, voce esta a retirar mais fosforos dos que os que estao em jogo. Tente novamente");

                } else System.out.println("Valor invalido, tente novamente");
            } catch (Exception e) {
                System.out.println("Valor invalido, tente novamente");
                in.nextLine();
            }

        }
    }

    private static void Humano_compS() {
        // sem inteligencia
        //O computador é o 1º a jogar

        in = new Scanner(System.in);
        int op = 1;

        while (op != 0) {
            System.out.println("Jogo contra computador");
            System.out.println("Escolha o 1º a jogar:");
            System.out.println("1 - Computador");
            System.out.println("2 - Jogador");
            System.out.println("0 - Voltar menu anterior");
            try {
                op = in.nextInt();

                switch (op) {
                    case 0:
                        break;
                    case 1:
                        Computador1();
                        break;
                    case 2:
                        Jogador_1();
                        break;
                    default:
                        System.out.println("Opcao invalida, tente novamente");
                        break;
                }

            } catch (Exception e) {
                System.out.println("Valor invalido, tente novamente");
                in.nextLine();
            }
        }
    }

    private static void Computador1(){

        in = new Scanner(System.in);
        System.out.println("Nome do jogador: ");
        String jogador_1 = in.nextLine();

        while (fosforos >= 1) {
            int valor = rnd.nextInt(1, 5);
            while (fosforos - valor <= 0) { //ENQUANTO O VALOR ALEATORIO FOR MAIOR QUE OS FOSFOROS EM JOGO
                valor = rnd.nextInt(1, 5);
            }
            System.out.println("O computador retira " + valor);
            fosforos -= valor;
            if (fosforos == 1) {
                System.out.println("O computador ganhou o jogo");
                System.out.println("");
                System.out.println("");
                fosforos = 21;
                return;
            }
            System.out.println(jogador_1 + ", é a sua vez de jogar");
            Jogo();
            if (fosforos == 1) {
                System.out.println("Parabens, você ganhou o jogo");
                fosforos = 21;
                return;
            }
        }
    }

    private static void Jogador_1() {
        //JOGADOR_1 1º A JOGAR
        in = new Scanner(System.in);
        System.out.println("Nome do jogador: ");
        String jogador_1 = in.nextLine();

        while (fosforos >= 1) {

            System.out.println(jogador_1 + ", é a sua vez de jogar");
                        Jogo();
            if (fosforos == 1) {
                System.out.println("Parabéns, você ganhou o jogo, "+ jogador_1);
                System.out.println("");
                System.out.println("");
                fosforos = 21;
                return;
            }

            //*VEZ DA MAQ JOGAR  int valor = rnd.nextInt(1, 5); //GERA NUM ALEATORIO DE FOSFOROS A RETIRAR
            //            while (fosforos-valor<=0){ //ENQUANTO O VALOR ALEATORIO FOR MAIOR QUE OS FOSFOROS EM JOGO
            //                valor = rnd.nextInt(1, 5);
            //            }
            //            System.out.println("A maquina retira " + valor);
            //            fosforos -= valor;
            //            if (fosforos == 1) {
            //                System.out.println("A maquina ganhou o jogo");
            //                fosforos = 21;
            //                return;
            //            }
            //
            //        }*\\

        }
    }

    private static void Humano_compC() {
        // com inteligencia
        //o Computador  é o 1º a jogar

        in = new Scanner(System.in);
        int op = 1;

        while (op != 0) {
            System.out.println("Jogo contra computador");
            System.out.println("Escolha o 1º a jogar:");
            System.out.println("1 - Computador");
            System.out.println("2 - Jogador");
            System.out.println("0 - Voltar menu anterior");
            try {
                op = in.nextInt();

                switch (op) {
                    case 0:
                        break;
                    case 1:
                        Computador_1();
                        break;
                    case 2:
                        jogador1();
                        break;
                    default:
                        System.out.println("Opcao invalida, tente novamente");
                        break;
                }

            } catch (Exception e) {
                System.out.println("Valor invalido, tente novamente");
                in.nextLine();
            }
        }
    }
    private static void Computador_1() {


        in = new Scanner(System.in);
        System.out.println("Nome do jogador: ");
        String jogador_1 = in.nextLine();

        while (fosforos >= 1) {

            int valor = rnd.nextInt(1, 5);
            System.out.println("O computador retira " + valor);
            fosforos -= valor;
            System.out.println(jogador_1 + ", sua vez de jogar");
            Jogo();
            if (fosforos == 1) {
                System.out.println("Parabéns, você ganhou o jogo");
                System.out.println("");
                System.out.println("");
                fosforos = 21;
                return;
            }

            if (valor + retira < 5) { //o Computador passa a ter vantagem

                System.out.println("O computador retira " + valor);
                jogador1(); //passa para o metodo onde o computador vai ganhar
                return;//sai deste metodo para o menu
            } else if (valor + retira > 5) { //O computador passa a ter vantagem
                valor = 10 - (valor + retira);
                fosforos -= valor;
                System.out.println("O computador retira " + valor);
                jogador1(); //passa para o metodo e o computador vai ganhar
                return;//sai deste metodo para o menu
            }
        }
    }

    private static void jogador1(){
        //Jogador joga 1º
        in = new Scanner(System.in);
        System.out.println("Nome do jogador: ");
        String jogador_1 = in.nextLine();

        while (fosforos >= 1) {

            System.out.println(jogador_1 + ", sua vez de jogar");

            Jogo();
            //COMPUTADOR TEM INTELIGENCIA, JOGADOR NUNCA GANHA

            int valor;
            valor = 5 - retira;
            System.out.println("O computador retira " + valor);
            fosforos -= valor;
            if (fosforos == 1) {
                System.out.println("O computador ganhou.");
                System.out.println("");
                System.out.println("");
                fosforos = 21;
                return;
            }
        }
    }
}

