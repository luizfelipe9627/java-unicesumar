import javax.swing.JOptionPane;

public class ExameGlicemia {
  String nomePaciente;
  String tipoSanguineo;
  int anoNascimento;
  int idade;

  double glicemia;
  String resultadoGlicemia;

  public void cadastrarExame() {
    this.nomePaciente = JOptionPane.showInputDialog("Digite o nome do paciente: ");
    this.tipoSanguineo = JOptionPane.showInputDialog("Digite o tipo sanguineo: ").toUpperCase();
    this.anoNascimento = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de nascimento: "));
    this.idade = 2023 - anoNascimento;

    this.glicemia = Double.parseDouble(JOptionPane.showInputDialog("Digite a glicemia por mg/dL: "));

    if (this.glicemia < 100) {
      this.resultadoGlicemia = "Normoglicemia";
    } else if (this.glicemia >= 100 && this.glicemia < 126) {
      this.resultadoGlicemia = "Pré-diabete";
    } else if (this.glicemia >= 126) {
      this.resultadoGlicemia = "Diabete";
    }
  }

  public void mostrarResultado() {
    JOptionPane.showMessageDialog(null, "Nome do paciente: " + this.nomePaciente + "\nResultado: " + this.glicemia + "mg/l\nClassificação: " + this.resultadoGlicemia);
  }
}