import javax.swing.JOptionPane; 

public class Rota {
  public void planejarDia() {
    int quantidadeRotas = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de rotas: "));

    int[] quantidadeKm = new int[quantidadeRotas]; 
   
    for (int i = 0; i < quantidadeRotas; i++) {
      quantidadeKm[i] = Integer
          .parseInt(JOptionPane.showInputDialog("Digite a quantidade de km da rota " + (i + 1) + ": "));
    }

    int valorLitro = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor do litro do óleo diesel: "));

    double totalKm = 0;

    for (int i = 0; i < quantidadeRotas; i++) {
      totalKm += quantidadeKm[i]; 
    }

    double totalLitros = totalKm / 2.5;
    double totalValor = totalLitros * valorLitro;

    String mensagem = "Total de KM: " + totalKm + "\n" +
        "Litros necessários para cada rota: " + totalLitros + "\n" +
        "Total do valor que vai ser reembolsado: R$ " + totalValor;

    JOptionPane.showMessageDialog(null, mensagem);
  }
}
