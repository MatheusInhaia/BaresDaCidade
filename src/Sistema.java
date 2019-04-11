import java.io.IOException;
import java.util.Scanner;

public class Sistema {

    Bar bar;
    int opc;

    public Sistema(Bar bar) {
        this.bar = bar;
    }

    public void showMenu() throws IOException {
        bar.carregarSocios();
        Scanner ler = new Scanner(System.in);
        do {
        System.out.println("--------------------------");
        System.out.println("MENU PRINCIPAL");
        System.out.println("1 - Registrar entrada");
        System.out.println("2 - Registrar saída");
        System.out.println("3 - Consultas");
        System.out.println("4 - Cadastrar cliente");
        System.out.println("0 - Sair");

        System.out.print("\nDigite a opção: ");


        opc = ler.nextInt();


            switch (opc) {

                case 1:
                    registrarEntrada();

                    break;
                case 2:
                    registrarSaida();

                    break;
                case 3:
                    consultas();

                    break;

                case 4:
                    cadastrarSocio();

                    break;
                case 0:
                    System.out.println("você saiu!");
                    bar.salvarPublicoDia();
                    bar.salvarSocios();
                    ler.close();
                    break;
                default:
                    showMenu();
                    break;

            }
        }while(opc!=0); // botar como default o show menu;

        ler.close();
    }

    public void cadastrarSocio(){
        Scanner ler = new Scanner(System.in);
        System.out.print("Informe CPF: ");
        String CPF = ler.nextLine();
        System.out.print("Informe Nome: ");
        String nome = ler.nextLine();
        System.out.print("Informe gênero: ");
        String genero = ler.nextLine();
        System.out.print("Informe a idade: ");
        int idade = ler.nextInt();
        System.out.print("Informe o numero: ");
        int numero = ler.nextInt();
        Socio s = new Socio(CPF,nome,genero,idade,numero);


        bar.registrarSocio(s);
        System.out.println("Socio registrado!");
        ler.close();
    }

    public void consultas() throws IOException{
        System.out.println("1 - Consultar publico");
        System.out.println("2 - Consultar por CPF");
        System.out.println("3 - Consultar quantidade de pessoas");
        System.out.println("4 - Consultar por gênero");
        System.out.println("5 - Consultar total de socios");
        System.out.println("0 - Voltar");
        System.out.print("\nDigite a opção: ");
        Scanner ler = new Scanner(System.in);
        int opc = ler.nextInt();
       // do {
            switch (opc) {

                case 1:
                    bar.consultarPublico();
                    consultas();
                    break;
                case 2:
                    System.out.print("Informe CPF: ");
                    String cpf = ler.next();
                    bar.consultarCPF(cpf);
                    consultas();
                    break;
                case 3:
                    System.out.println("Quatidade de pessoas: "+bar.consultarQtdPessoas());
                    consultas();
                    break;
                case 4:
                    System.out.println(bar.ConsultarPercentualGenero());
                    consultas();
                    break;
                case 5:

                    System.out.println(bar.consultarSociosENaoSocios());
                    consultas();
                    break;
                case 0:
                    showMenu();
                    break;
                default:
                    showMenu();
                    break;

            }
      // }while(opc==0); // botar como default o show menu;

        ler.close();
    }

    public void registrarEntrada(){
        Scanner ler = new Scanner(System.in);
        System.out.print("Informe CPF: ");
        String CPF = ler.nextLine();
        System.out.print("Informe Nome: ");
        String nome = ler.nextLine();
        System.out.print("Informe gênero: ");
        String genero = ler.nextLine();
        System.out.print("Informe a idade: ");
        int idade = ler.nextInt();
        Cliente c = new Cliente(CPF,nome,genero,idade);
        bar.adicionar(c);
        System.out.println("Cliente registrado!");
        //ler.close();
    }

    public void registrarSaida(){
        Scanner ler = new Scanner(System.in);
        System.out.print("Informe CPF: ");
        String CPF = ler.nextLine();
        bar.remover(CPF);
        //ler.close();
    }
}
