import App.Cliente;

import org.junit.jupiter.api.BeforeEach;

public class BarTeste {

    @BeforeEach
    public void iniciar(){
        Cliente c = new Cliente("0314", "Matheus","Masculino",25);
    }
}
