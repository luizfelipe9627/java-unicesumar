import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CadastroInterface extends javax.swing.JFrame {
    public CadastroInterface() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroInterface().setVisible(true);
            }
        });
    }

    private void initComponents() {
        NameLabel = new javax.swing.JLabel();
        NameText = new javax.swing.JTextField();
        LoginLabel = new javax.swing.JLabel();
        LoginText = new javax.swing.JTextField();
        SenhaLabel = new javax.swing.JLabel();
        SenhaText = new javax.swing.JPasswordField();
        EmailLabel = new javax.swing.JLabel();
        EmailText = new javax.swing.JTextField();
        SalvarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Cadastro");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("Sistema de Cadastro");
        setResizable(false);

        NameLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        NameLabel.setText("Nome:");

        LoginLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        LoginLabel.setText("Login:");

        SenhaLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        SenhaLabel.setText("Senha:");
        
        EmailLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        EmailLabel.setText("Email:");

        SalvarButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        SalvarButton.setText("Salvar");
        SalvarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalvarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(LoginLabel)
                        .addComponent(NameLabel))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(EmailLabel)
                        .addComponent(SenhaLabel)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SalvarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SenhaText, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LoginText, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addComponent(NameText)
                    .addComponent(EmailText))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NameText)
                    .addComponent(NameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LoginText, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LoginLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SenhaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SenhaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EmailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EmailText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(SalvarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
    }    

    public void CadastrarUsuario(CadastrarUsuario cadastrarUsuario) {
        String sql = "INSERT INTO usuario (nome, login, senha, email) VALUES (?, ?, ?, ?)";

        PreparedStatement ps;

        try {
            ps = ConexaoBD.getConexao().prepareStatement(sql);
            
            ps.setString(1, cadastrarUsuario.getNome());
            ps.setString(2, cadastrarUsuario.getLogin());
            ps.setString(3, cadastrarUsuario.getSenha());
            ps.setString(4, cadastrarUsuario.getEmail());

            ps.execute();
            ps.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    private void SalvarButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            CadastrarUsuario cd = new CadastrarUsuario();
            
            String nome = NameText.getText();
            String login = LoginText.getText();
            String senha = new String(SenhaText.getPassword());
            String email = EmailText.getText();
            
            if (nome.isEmpty() || login.isEmpty() || senha.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            cd.setNome(nome);
            cd.setLogin(login);
            cd.setSenha(senha);
            cd.setEmail(email);
            CadastrarUsuario(cd);
            
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            LoginInterface l = new LoginInterface();
            l.setVisible(true);
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        
    }

    private javax.swing.JLabel EmailLabel;
    private javax.swing.JTextField EmailText;
    private javax.swing.JLabel LoginLabel;
    private javax.swing.JTextField LoginText;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JTextField NameText;
    private javax.swing.JButton SalvarButton;
    private javax.swing.JLabel SenhaLabel;
    private javax.swing.JPasswordField SenhaText;
}
