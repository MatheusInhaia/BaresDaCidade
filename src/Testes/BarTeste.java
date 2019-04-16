import App.Bar;
import App.Cliente;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class BarTeste {

    Cliente c;
    Cliente c1;
    Cliente c2;
    Bar bar;
    @BeforeEach
    public void iniciar(){
         bar = new Bar();
         c = new Cliente("0314", "Matheus","Masculino",25);
         c1 = new Cliente("0348", "Bianca","Feminino",25);
         c2 = new Cliente("0485", "Maria","Feminino",50);
        bar.adicionar(c);
        bar.adicionar(c1);
        bar.adicionar(c2);
    }

    @Test
    public void AdicionarClienteTeste(){
        Assertions.assertEquals(3,bar.consultarQtdPessoas());
    }

    @Test
    public void removerClienteTeste()throws InterruptedException {
        bar.remover("0314");

        //Thread.sleep(500000);

        Assertions.assertEquals(2,bar.consultarQtdPessoas());

    }
}
