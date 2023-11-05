package bancosangue;
import java.io.IOException;
import java.util.Scanner;
/**
 * @author Andressa Flavia Atelli
 * Arquivo C:\\Users\\andre\\OneDrive\\Documentos\\doacoes.csv
 * 11,Tiao luis,259886477-58,2023-18-11,O+,350
 */
public class BancoSangue {
    public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o caminho e nome do arquivo CSV: ");
        String filePath = scanner.nextLine();

        while (true) {
            System.out.println("---------------------------------------");
            System.out.println("Menu:");
            System.out.println("1. Exibir conteúdo do arquivo");
            System.out.println("2. Inserir nova doação");
            System.out.println("3. Excluir doação por código");
            System.out.println("4. Sair");
            System.out.println("---------------------------------------");
            System.out.print("Escolha uma opção: ");

            int escolha = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer de entrada
            System.out.println("----------------------------------");
            try {
                switch (escolha) {
                    case 1:
                        EditorDoacaoCsv.exibirConteudoCSV(filePath);
                        break;
                    case 2:
                        System.out.print("Informe a nova doação no formato 'código,nome,cpf,data_nascimento,tipo_sanguíneo,mls_doados': ");
                        String novaDoacao = scanner.nextLine();
                        EditorDoacaoCsv.inserirDoacaoCSV(filePath, novaDoacao);
                        break;
                    case 3:
                        System.out.print("Informe o código da doação a ser excluída: ");
                        String codigo = scanner.nextLine();
                        EditorDoacaoCsv.excluirDoacaoPorCodigo(filePath, codigo);
                        break;
                    case 4:
                        System.out.println("Saindo do programa.");
                        System.exit(0);
                    default:
                        System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                }
            } catch (IOException e) {
                System.err.println("Erro na manipulação do arquivo: " + e.getMessage());
            }
        }        
    }    
}
