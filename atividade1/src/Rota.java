import javax.swing.JOptionPane; // Importa a classe JOptionPane do pacote javax.swing, responsável por exibir caixas de diálogo.

// Criado a classe Rota.
public class Rota {
  // Método publica chamado planejarDia.
  public void planejarDia() {
    // Imprime a mensagem para o usuário digitar a quantidade de rotas e armazena na variável quantidadeRotas.
    int quantidadeRotas = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de rotas: "));

    int[] quantidadeKm = new int[quantidadeRotas]; // Criado um array vazia para armazenar a quantidade de km de cada rota e armazena na variável quantidadeKm.

    // Cria um laço de repetição que se repete a conforme a quantidade de rotas digitadas pelo usuário.
    for (int i = 0; i < quantidadeRotas; i++) {
      // Imprime a mensagem para o usuário digitar a quantidade de km de cada rota e armazena no array.
      quantidadeKm[i] = Integer
          .parseInt(JOptionPane.showInputDialog("Digite a quantidade de km da rota " + (i + 1) + ": "));
    }

    // Imprime a mensagem para o usuário digitar o valor do litro do óleo diesel e armazena na variável valorLitro.
    int valorLitro = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor do litro do óleo diesel: "));

    double totalKm = 0; // Cria uma variável zerada para armazenar o total de km.
    // Cria um laço de repetição para somar o total de km digitado pelo usuário.
    for (int i = 0; i < quantidadeRotas; i++) {
      totalKm += quantidadeKm[i]; // Soma o total de km com a quantidade de km de cada rota.
    }

    double totalLitros = totalKm / 2.5; // Cria uma variável do tipo double chamada totalLitros para armazenar o total de km dividido por 2.5.

    double totalValor = totalLitros * valorLitro; // Cria uma variável do tipo double chamada totalValor para armazenar o total de litros multiplicado pelo valor do litro.

    // Imprime o total de KM, o total de litros necessários para cada rota e o total de valor que vai ser reembolsado.
    String mensagem = "Total de KM: " + totalKm + "\n" +
        "Litros necessários para cada rota: " + totalLitros + "\n" +
        "Total do valor que vai ser reembolsado: R$ " + totalValor;

    // Imprime a mensagem na tela.
    JOptionPane.showMessageDialog(null, mensagem);
  }
}
