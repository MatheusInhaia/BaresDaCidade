package App;

import java.util.Date;

public class Cliente {
    private String CPF;
    private String nome;
    private String genero;
    private int idade; // sem tempo pra fazer com Date, para pegar a data de nascimento e converter para pegar a idade corrente no dia de hoje

    public Cliente(String CPF, String nome, String genero, int idade) {
        this.CPF = CPF;
        this.nome = nome;
        this.genero = genero;
        this.idade = idade;
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

    public int getIdade() {
        return idade;
    }

    @Override
    public String toString() {
        String src ="Cliente: "+ getNome() + " CPF: " + getCPF() + " Genero: " + getGenero() + " Idade: " + getIdade() ;
        return src;
    }
}
