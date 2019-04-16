package App;

public class Socio extends Cliente {
    private int numeroSocio;

    public Socio(String CPF, String nome, String genero,int idade, int numeroSocio) {
        super(CPF, nome, genero,idade);
        this.numeroSocio = numeroSocio;
    }

    public int getNumeroSocio() {
        return numeroSocio;
    }

    @Override
    public String toString() {
        return super.toString()+" numero do socio: " +getNumeroSocio();
    }
}
