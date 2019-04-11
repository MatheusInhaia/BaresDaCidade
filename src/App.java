import java.io.IOException;

public class App {
    public static void main(String args[])throws IOException {
        Bar bar = new Bar();
        Sistema sistema = new Sistema(bar);

        sistema.showMenu();
    }
}
