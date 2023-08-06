// Faça a leitura da quantidade de rotas do dia.
// Faça a leitura da km de cada ônibus.
// Calcule a quantidade necessária de combustível para atender toda a demanda.
// Faça leitura do valor do litro do óleo diesel.

// Sabendo que cada ônibus tem uma média de consumo de 2,5km/litro de óleo diesel, faça um programa que:
// No final mostre o resultado de total de km, quantos litros de combustível é necessário para atender às rotas e o valor que a empresa desembolsará.

import java.util.Scanner; // Importa a classe Scanner do pacote util.

// Criado a classe Rota.
public class Rota1 {
  // Método principal da classe.
  public void planejarDia() {
    try (Scanner stdin = new Scanner(System.in)) {
      // Imprime a mensagem para o usuário digitar a quantidade de rotas.
      System.out.println("Digite a quantidade de rotas: ");
      // Armazena a quantidade de rotas digitadas pelo usuário na variável quantidadeRotas.
      int quantidadeRotas = stdin.nextInt();

      // Crie um array vazia para armazenar a quantidade de km de cada rota.
      int[] quantidadeKm = new int[quantidadeRotas];

      // Cria um laço de repetição para pedir ao usuário a quantidade de km de cada rota e armazenar no array.
      for (int i = 0; i < quantidadeRotas; i++) {
        // Imprime a mensagem para o usuário digitar a quantidade de km da rota.
        System.out.println("Digite a quantidade de km da rota " + (i + 1) + ": ");
        // Armazena a quantidade de km da rota digitada pelo usuário no array.
        quantidadeKm[i] = stdin.nextInt();
      }

      // Imprime a mensagem para o usuário digitar o valor do litro do óleo diesel.
      System.out.println("Digite o valor do litro do óleo diesel: ");
      // Armazena o valor do litro do óleo diesel digitado pelo usuário na variável valorLitro.
      int valorLitro = stdin.nextInt();

      // Cria uma variável para armazenar o total de km.
      double totalKm = 0;

      // Cria um laço de repetição para somar o total de km.
      for (int i = 0; i < quantidadeRotas; i++) {
        // Soma o total de km com a quantidade de km de cada rota.
        totalKm += quantidadeKm[i];
      }

      // Cria uma variável do tipo double chamada totalLitros para armazenar o total de km dividido por 2.5.
      double totalLitros = totalKm / 2.5;

      // Cria uma variável do tipo double chamada totalValor para armazenar o total de litros multiplicado pelo valor do litro.
      double totalValor = totalLitros * valorLitro;

      // Imprime o total de KM.
      System.out.println("Total de KM: " + totalKm);

      // Imprime o total de litros necessários para cada rota.
      System.out.println("Litros necessários para cada rota: " + totalLitros);

      // Imprime o total de valor que vai ser reembolsado.
      System.out.println("Total do valor que vai ser reembolsado: " + totalValor);
    }
  }
}
