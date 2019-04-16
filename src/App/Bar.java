package App;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

public class Bar {
    private ArrayList<Cliente> clientes;
    private List<Socio> socios;



    public Bar() {
        this.clientes = new ArrayList<>();
        this.socios = new ArrayList<>();
    }

    public String consultarSociosENaoSocios() {
        String s;
        int socios = 0;
        int naoSocios = 0;

        for (Cliente c : clientes) {
            if (c instanceof Socio) {
                socios++;
            } else {
                naoSocios++;
            }
        }

        s = "Quantidade de clientes: " + consultarQtdPessoas() + ", Socios: " + socios + ", não socios: " + naoSocios;

        return s;
    }

    public void registrarSocio(Socio s) {
        socios.add(s);
    }

    public void adicionar(Cliente c) {
        boolean aux = true;
        for (Socio s : socios) {
            if (s.getCPF().equals(c.getCPF())) {
                clientes.add(s);
                aux = false;
            }
        }
        if (aux == true) {
            clientes.add(c);
        }
    }

    public void remover(String CPF){
        for(Cliente c : clientes){
            if(c.getCPF().equals(CPF)){
                clientes.remove(c);
                System.out.println("Cliente removido!");
            }
        }

    }

    public void consultarPublico(){
        for(Cliente c : clientes){
            System.out.println(c.toString());
        }
    }

    public void consultarCPF(String cpf){
        for(Cliente c: clientes){
            if(c.getCPF().equals(cpf)){
                System.out.println(c);
            }
        }
    }

    public int consultarQtdPessoas(){
        int aux = 0;
        aux = clientes.size();
        return aux;
    }

    public String ConsultarPercentualGenero(){
        String s;
        int masculino = 0;
        int feminino = 0 ;

        for(Cliente c : clientes){
            if(c.getGenero().contains("f")){
                feminino++;
            }else{
                masculino++;
            }
        }

        s = "Total de pessoas : " + consultarQtdPessoas() + " "+ "Percentual de publico masculino: " + ((masculino/consultarQtdPessoas())*100)+"%"+" Feminino: "+ ((feminino/consultarQtdPessoas())*100)+"%.";

        return s;
    }

    public void salvarPublicoDia() throws IOException {
        File f = new File("src/"+ LocalDate.now()+".txt");
        FileWriter fw = new FileWriter(f);
        PrintWriter pw = new PrintWriter(fw);

        BufferedWriter writer = new BufferedWriter(pw);

        for (Cliente c: clientes ) {
            writer.write(c.getCPF() + ";");
            writer.write(c.getNome() + ";");
            writer.write(c.getGenero() + ";");
            writer.write(c.getIdade() + ";");
            if(c instanceof Socio){
                for(Socio s : socios){
                    if(s.getCPF().equals(c.getCPF())){
                        writer.write(s.getNumeroSocio() + ";");
                    }
                }

            }

            writer.newLine();
        }
        writer.flush();
        writer.close();

    }
    public void salvarSocios() throws IOException {
        File f = new File("src/Socios.txt");
        FileWriter fw = new FileWriter(f);
        PrintWriter pw = new PrintWriter(fw);

        BufferedWriter writer = new BufferedWriter(pw);

        for (Socio s : socios ) {
            writer.write(s.getCPF() + ";");
            writer.write(s.getNome() + ";");
            writer.write(s.getGenero() + ";");
            writer.write(s.getIdade() + ";");
            writer.write(s.getNumeroSocio() + ";");
            writer.newLine();
        }
        writer.flush();
        writer.close();

    }

    public void carregarSocios()throws IOException{
        Path path = Paths.get("src/Socios.txt");

        String cpf, nome, genero,idade,numero;


        try (Scanner sc = new Scanner(Files.newBufferedReader(path, Charset.defaultCharset()))) {
            sc.useDelimiter(";\n");

            while (sc.hasNext()) {
                cpf= sc.next();
                nome = sc.next();
                genero = sc.next();
                idade = sc.next();
                numero = sc.next();
                Socio s = new Socio(cpf,nome,genero,Integer.parseInt(idade),Integer.parseInt(numero));
                registrarSocio(s);
            }


        }

    }
}
