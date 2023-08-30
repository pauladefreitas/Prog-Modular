import java.io.*;
import java.util.*;

public class dataApp {

    private DATA[] datasInseridas;
    private DATA dataMaisAntiga;
    private DATA dataMaisAvancada;

    /**
     * Realiza a leitura de datas a partir de um arquivo "datas.txt".
     * As datas lidas são armazenadas no vetor "datasInseridas".
     * O arquivo "datas.txt" deve estar no mesmo diretório do programa.
     * Caso o arquivo não seja encontrado, uma mensagem de erro será exibida.
     */
    public void leitura() {
        try {
            File arquivo = new File("datas.txt");
            Scanner scanner = new Scanner(arquivo);
            int numeroDeDatas = Integer.parseInt(scanner.nextLine());
            datasInseridas = new DATA[numeroDeDatas];

            for (int i = 0; i < numeroDeDatas; i++) {
                String linha = scanner.nextLine();
                DATA data = new DATA(linha);
                datasInseridas[i] = data;
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
        }
    }

    /**
     * Calcula a data mais antiga e a data mais avançada a partir das datas presentes em "datasInseridas".
     * Atualiza os valores de "dataMaisAntiga" e "dataMaisAvancada" com as datas correspondentes.
     * As datas devem estar previamente carregadas no vetor "datasInseridas".
     */
    public void calcularDatasTempo() {
        dataMaisAntiga = datasInseridas[0];
        dataMaisAvancada = datasInseridas[0];

        for (DATA data : datasInseridas) {
            if (data.estaAFrente(dataMaisAvancada)) {
                dataMaisAvancada = data;
            }
            if (dataMaisAntiga.estaAFrente(data)) {
                dataMaisAntiga = data;
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 

        dataApp app = new dataApp();

        app.leitura(); 

        System.out.print("Digite o número de datas a serem adicionadas: ");
        int numeroDeDatas = input.nextInt();
        input.nextLine();  

        DATA[] novasDatas = new DATA[numeroDeDatas];
        for (int i = 0; i < numeroDeDatas; i++) {
            System.out.print("Digite a data " + (i + 1) + " no formato dd/mm/aaaa: ");
            String linha = input.nextLine();
            DATA data = new DATA(linha);
            novasDatas[i] = data;
        }

        DATA[] todasAsDatas = new DATA[app.datasInseridas.length + novasDatas.length];
        System.arraycopy(app.datasInseridas, 0, todasAsDatas, 0, app.datasInseridas.length);
        System.arraycopy(novasDatas, 0, todasAsDatas, app.datasInseridas.length, novasDatas.length);
        app.datasInseridas = todasAsDatas;

        app.calcularDatasTempo();

        System.out.println("Data mais antiga: " + app.dataMaisAntiga.formatarData());
        System.out.println("Data mais avançada: " + app.dataMaisAvancada.formatarData());

        input.close();
    }
}
