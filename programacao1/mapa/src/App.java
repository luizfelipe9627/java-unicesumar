public class App {
    public static void main(String[] args) {
        ExameGlicemia eg = new ExameGlicemia();
        eg.cadastrarExame();
        eg.mostrarResultado();

        ExameColesterol ec = new ExameColesterol();
        ec.cadastrarExame();
        ec.mostrarResultado();

        ExameTriglicerideos et = new ExameTriglicerideos();
        et.cadastrarExame();
        et.mostrarResultado();
    }
}