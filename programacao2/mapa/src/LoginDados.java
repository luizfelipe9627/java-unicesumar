public class LoginDados {
  public String login;
  public String password;

  public LoginDados(String login, char[] password) {
    this.login = login;
    this.password = new String(password);
  }

  public String getLogin() {
    return login;
  }

  public String getPassword() {
    return password;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String toString() {
    return "Dados{" + "login=" + login + ", password=" + password + '}';
  }
}
