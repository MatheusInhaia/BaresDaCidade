import java.util.ArrayList;

public class Bar {
    private ArrayList<Cliente> clientes;

    public Bar() {
        this.clientes = new ArrayList<>();
    }

    public void adicionar(Cliente c){
        clientes.add(c);
    }

    public void remover(Cliente c){
        clientes.remove(c);
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
            if(c.getGenero().equalsIgnoreCase("Feminino")){
                feminino++;
            }else{
                masculino++;
            }
        }

        s = "Total de pessoas : " + consultarQtdPessoas() + " "+ "Percentual de publico masculino: " + ((consultarQtdPessoas()/masculino)*100)+"%"+" Feminino: "+ ((consultarQtdPessoas()/masculino)*100)+"%.";

        return s;
    }

    
}
