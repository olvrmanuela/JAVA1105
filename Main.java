import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número de clientes a serem cadastrados: ");
        int numClientes = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        for (int i = 1; i <= numClientes; i++) {
            System.out.println("Cliente " + i);
            System.out.print("Digite a matrícula: ");
            String matricula = scanner.nextLine();
            System.out.print("Digite o nome: ");
            String nome = scanner.nextLine();
            System.out.print("Digite o CEP: ");
            String cep = scanner.nextLine();

            System.out.print("Digite o tipo de cliente (1 - Pessoa Física, 2 - Pessoa Jurídica): ");
            int tipoCliente = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            if (tipoCliente == 1) {
                System.out.print("Digite o telefone: ");
                String telefone = scanner.nextLine();
                System.out.print("Digite a data de nascimento: ");
                String dataNascimento = scanner.nextLine();
                System.out.print("Digite o CPF: ");
                String cpf = scanner.nextLine();

                PessoaFisica pessoaFisica = new PessoaFisica(matricula, nome, telefone, dataNascimento, cep, cpf);
                pessoaFisica.escreverArquivo(gerarNomeArquivo(matricula));
            } else if (tipoCliente == 2) {
                System.out.print("Digite a razão social: ");
                String razaoSocial = scanner.nextLine();
                System.out.print("Digite o CNPJ: ");
                String cnpj = scanner.nextLine();

                PessoaJuridica pessoaJuridica = new PessoaJuridica(matricula, razaoSocial, nome, cep, cnpj);
                pessoaJuridica.escreverArquivo(gerarNomeArquivo(matricula));
            } else {
                System.out.println("Tipo de cliente inválido.");
            }
        }

        scanner.close();
    }

    // Método auxiliar para gerar o nome do arquivo com base na matrícula e na data/hora atual
    private static String gerarNomeArquivo(String matricula) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String dataHoraAtual = dateFormat.format(new Date());
        return matricula + "_" + dataHoraAtual + ".txt";
    }
}