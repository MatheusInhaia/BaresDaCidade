public class Cliente {
    private String CPF;
    private String nome;
    private String genero;
    private boolean socio;
    private int numeroSocio;

    public Cliente(String CPF, String nome, String genero) {
        this.CPF = CPF;
        this.nome = nome;
        this.genero = genero;
        this.socio = false;
        this.numeroSocio = 0;
    }

    public String getCPF() {
        return CPF;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    @Override
    public String toString() {
        String src ="Cliente: "+ getNome() + " CPF: " + getCPF() + " Genero: " + getGenero() + " Idade: " ;
        return src;
    }
}
