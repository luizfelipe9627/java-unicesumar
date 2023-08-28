import javax.swing.JOptionPane;

public class ExameTriglicerideos {
  String nomePaciente;
  String tipoSanguineo;
  int anoNascimento;
  int idade;

  double triglicerideos;
  String resultadoTriglicerideos = "";

  public void cadastrarExame() {
    this.nomePaciente = JOptionPane.showInputDialog("Digite o nome do paciente: ");
    this.tipoSanguineo = JOptionPane.showInputDialog("Digite o tipo sanguineo: ").toUpperCase();
    this.anoNascimento = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de nascimento: "));
    this.idade = 2023 - anoNascimento;

    this.triglicerideos = Double.parseDouble(JOptionPane.showInputDialog("Digite o triglicerideos por mg/dL:"));

    if (this.idade > 0 && this.idade <= 9 && this.triglicerideos < 75) {
      this.resultadoTriglicerideos = "Bom";
    } else if (this.idade > 10 && idade <= 19 && this.triglicerideos < 90) {
      this.resultadoTriglicerideos = "Bom";
    } else if (this.idade > 20 && this.triglicerideos < 150) {
      this.resultadoTriglicerideos = "Bom";
    } else {
      this.resultadoTriglicerideos = "Ruim";
    }
  }

  public void mostrarResultado() {
    JOptionPane.showMessageDialog(null, "Nome: " + this.nomePaciente + "\nTriglicerideos: " + this.triglicerideos + "mg/l" + "\nClassificação: " + this.resultadoTriglicerideos);
  }
}