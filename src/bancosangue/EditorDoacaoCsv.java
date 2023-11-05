package bancosangue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Andressa Flavia Atelli
 */
public class EditorDoacaoCsv {
    // Delimitador CSV
    private static final String DELIMITER = ","; 

    /*Método para exibir o conteudo do arquivo.*/
    public static void exibirConteudoCSV(String filePath) throws IOException {        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    /* Método para inserir uma nova doação no final do arquivo CSV.*/
    public static void inserirDoacaoCSV(String filePath, String novaDoacao) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(novaDoacao);
        }
    }

    /* Método para excluir uma doação com base no código especificado.*/
    public static void excluirDoacaoPorCodigo(String filePath, String codigo) throws IOException {
        File inputFile = new File(filePath);
        File tempFile = new File("temp.csv");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(DELIMITER);
                if (!parts[0].equals(codigo)) {
                    writer.write(line + System.lineSeparator());
                }
            }
        }

        // Deleta o arquivo original
        inputFile.delete();

        // Renomeia o arquivo temporário para o nome original
        tempFile.renameTo(inputFile);
    }
}
