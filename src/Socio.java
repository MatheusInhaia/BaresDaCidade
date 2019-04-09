public class Socio extends Cliente {
    private int numeroSocio;

    public Socio(String CPF, String nome, String genero, int numeroSocio) {
        super(CPF, nome, genero);
        this.numeroSocio = numeroSocio;
    }
}
