public class Cliente {
    private String CPF;
    private String nome;
    private String genero;

    public Cliente(String CPF, String nome, String genero) {
        this.CPF = CPF;
        this.nome = nome;
        this.genero = genero;
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
        return "Cliente{" +
                "CPF='" + CPF + '\'' +
                ", nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
