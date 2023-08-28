import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Teste {
    public class Produto {
        public void getDescr() {}
    }

    public static void main(String[] args) {        
        try {
            int qtd = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de alunos"));
        } catch(NumberFormatException e) {
            System.out.println("Você não digiou um número inteiro.");
        }

        try {            
            Produto p = null;
            p.getDescr();            
        } catch (NullPointerException e) {
            System.out.println("Você não instanciou o objeto.");
        }
        
        try {
            List<String> palavras = new ArrayList<>();
            palavras.add("Oi");
            palavras.add("Tchau");
            palavras.remove(2);
        } catch(IndexOutOfBoundsException e) {
            System.out.println("Você tentou acessar um índice/posicao inválido.");
        }        
    }
}