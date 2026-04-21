import java.security.SecureRandom;

public class ProjetoGeradorDeSenhas {

    private static final String LETRAS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMEROS = "0123456789";
    private static final String ESPECIAIS = "!@#$%&*()_+-=[]|,./?><";

    public static String gerarSenha(int comprimento, boolean usarNumeros, boolean usarEspeciais) {

        String caracteres = LETRAS;

        //verificação se é para utilizar numeros
        if (usarNumeros) {
            caracteres += NUMEROS;
        }

        //verificação se é para utilizar caracteres especiais
        if (usarEspeciais) {
            caracteres += ESPECIAIS;
        }

        SecureRandom random = new SecureRandom();
        StringBuilder senha = new StringBuilder();

        //criação da senha com base no comprimento
        for (int i = 0; i < comprimento; i++) {
            int index = random.nextInt(caracteres.length());
            senha.append(caracteres.charAt(index));
        }

        return senha.toString();
    }
}