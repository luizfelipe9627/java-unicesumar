import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class LoginInterface extends javax.swing.JFrame {
    public LoginInterface() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginInterface().setVisible(true);
            }
        });
    }

    private void initComponents() {
        LoginText = new javax.swing.JTextField();
        LoginLabel = new javax.swing.JLabel();
        SenhaLabel = new javax.swing.JLabel();
        SenhaText = new javax.swing.JPasswordField();
        EntrarButton = new javax.swing.JButton();
        CadastrarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Login");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("Sistema de Login");
        setResizable(false);

        LoginLabel.setFont(new java.awt.Font("Arial", 1, 14));
        LoginLabel.setText("Login:");

        SenhaLabel.setFont(new java.awt.Font("Arial", 1, 14));
        SenhaLabel.setText("Senha:");

        EntrarButton.setFont(new java.awt.Font("Arial", 1, 12));
        EntrarButton.setText("Entrar");
        EntrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntrarButtonActionPerformed(evt);
            }
        });

        CadastrarButton.setFont(new java.awt.Font("Arial", 1, 12));
        CadastrarButton.setText("Cadastrar Novo Usuário");
        CadastrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SenhaLabel)
                    .addComponent(LoginLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(EntrarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LoginText, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addComponent(CadastrarButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SenhaText))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LoginLabel)
                    .addComponent(LoginText))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(SenhaLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SenhaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(EntrarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CadastrarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }

    public boolean LogarUsuario(LogarUsuario logarUsuario) {
        String sql = "SELECT id, nome, login, senha , email from usuario where login = ? and senha = ?";
        
        PreparedStatement ps;

        try {
            ps = ConexaoBD.getConexao().prepareStatement(sql);
            
            ps.setString(1, logarUsuario.getLogin());
            ps.setString(2, logarUsuario.getPassword());
            
            try (ResultSet resultSet = ps.executeQuery()) {
                return resultSet.next();
            }
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }     
    }
     
    private void EntrarButtonActionPerformed(java.awt.event.ActionEvent evt) {
        LogarUsuario ld = new LogarUsuario();
        
        String login = LoginText.getText();
        String senha = new String(SenhaText.getPassword());
        
        if (login.isEmpty() || senha.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
         }
        
        ld.setLogin(login);
        ld.setPassword(senha);
        
        if (LogarUsuario(ld)) {
            JOptionPane.showMessageDialog(null, "Acesso autorizado!", "Login", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Acesso negado!", "Login", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void CadastrarButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        CadastroInterface c = new CadastroInterface();
        c.setVisible(true);
    }

    private javax.swing.JButton CadastrarButton;
    private javax.swing.JButton EntrarButton;
    private javax.swing.JLabel LoginLabel;
    private javax.swing.JTextField LoginText;
    private javax.swing.JLabel SenhaLabel;
    private javax.swing.JPasswordField SenhaText;
}
