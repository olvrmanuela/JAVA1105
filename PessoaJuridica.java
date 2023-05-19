import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class PessoaJuridica extends Cliente {
    private String razaoSocial;
    private String cnpj;

    public PessoaJuridica(String matricula, String razaoSocial, String nome, String cep, String cnpj) {
        super(matricula, nome, cep);
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
    }

    @Override
    public void escreverArquivo(String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write("Matricula: " + matricula);
            writer.newLine();
            writer.write("Razão Social: " + razaoSocial);
            writer.newLine();
            writer.write("Nome: " + nome);
            writer.newLine();
            writer.write("CEP: " + cep);
            writer.newLine();
            writer.write("CNPJ: " + cnpj);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao escrever arquivo: " + e.getMessage());
        }
    
    }