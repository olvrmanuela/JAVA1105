import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class PessoaFisica extends Cliente {
    private String telefone;
    private String dataNascimento;
    private String cpf;

    public PessoaFisica(String matricula, String nome, String telefone, String dataNascimento, String cep, String cpf) {
        super(matricula, nome, cep);
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }

    @Override
    public void escreverArquivo(String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write("Matricula: " + matricula);
            writer.newLine();
            writer.write("Nome: " + nome);
            writer.newLine();
            writer.write("Telefone: " + telefone);
            writer.newLine();
            writer.write("Data de Nascimento: " + dataNascimento);
            writer.newLine();
            writer.write("CEP: " + cep);
            writer.newLine();
            writer.write("CPF: " + cpf);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao escrever arquivo: " + e.getMessage());
        }
    }
}