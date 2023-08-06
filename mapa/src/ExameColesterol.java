import javax.swing.JOptionPane;

public class ExameColesterol {
  String nomePaciente;
  String tipoSanguineo;
  int anoNascimento;
  int idade;

  double colesterolHDL;
  double colesterolLDL;
  String risco;
  String resultadoHDL = "";
  String resultadoLDL = "";

  public void cadastrarExame() {
    this.nomePaciente = JOptionPane.showInputDialog("Digite o nome do paciente: ");
    this.tipoSanguineo = JOptionPane.showInputDialog("Digite o tipo sanguineo: ").toUpperCase();
    this.anoNascimento = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de nascimento: "));
    this.idade = 2023 - anoNascimento;

    this.colesterolHDL = Double.parseDouble(JOptionPane.showInputDialog("Digite o colesterol HDL por mg/dL:"));
    this.colesterolLDL = Double.parseDouble(JOptionPane.showInputDialog("Digite o colesterol LDL por mg/dL:"));

    this.risco = JOptionPane.showInputDialog("Risco (A - Alto, M - Médio, B - Baixo): ").toUpperCase();

    if (this.idade > 0 && this.idade <= 19 && this.colesterolHDL > 45) {
      this.resultadoHDL = "Bom";
    } else if (idade > 20 && colesterolHDL > 40) {
      this.resultadoHDL = "Bom";
    } else {
      this.resultadoHDL = "Ruim";
    }
    
    if(this.risco.equals("B") && this.colesterolLDL < 100) {
      this.resultadoLDL = "Bom";
    } else if (this.risco.equals("M") && this.colesterolLDL < 70) {
      this.resultadoLDL = "Bom";
    } else if (this.risco.equals("A") && this.colesterolLDL < 50) {
      this.resultadoLDL = "Bom";
    } else {
      this.resultadoLDL = "Ruim";
    }
  }

  public void mostrarResultado() {
    JOptionPane.showMessageDialog(null, "Nome: " + this.nomePaciente + "\nResultado HDL: " + this.colesterolHDL + "\nResultado LDL: " + this.colesterolLDL + "\nResultado risco: " + this.risco + "\nClassificação HDL: " + this.resultadoHDL + "\nClassificação LDL: " + this.resultadoLDL);
  }
}