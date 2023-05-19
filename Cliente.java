import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class Cliente implements Arquivo {
    protected String matricula;
    protected String nome;
    protected String cep;

    public Cliente(String matricula, String nome, String cep) {
        this.matricula = matricula;
        this.nome = nome;
        this.cep = cep;
    }

    public void escreverArquivo(String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write("Matricula: " + matricula);
            writer.newLine();
            writer.write("Nome: " + nome);
            writer.newLine();
            writer.write("CEP: " + cep);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao escrever arquivo: " + e.getMessage());
        }
    }
}