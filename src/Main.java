import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        String[] candidatos = {"Felipe", "Márcia", "Júlia", "Paulo", "Augusto", "Mônica", "Fabrício", "Mirela", "Daniela", "Jorge"};
        String[] selecionados;
        analisarCandidato(1900.0);
        analisarCandidato(2200.0);
        analisarCandidato(2000.0);
        selecionados = selecionar(candidatos);
        listarSelecionados(selecionados);
        ligarParaCandidatos(selecionados);
    }

    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido){
            System.out.println("Ligar para o candidato.");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar para o candidato com contraproposta.");
        }else {
            System.out.println("Aguardando o resultado dos demais candidatos.");
        }
    }
    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }
    static String[] selecionar(String[] candidatos) {
        String[] selecionados = new String[5];
         int i = 0;

        for (String candidato : candidatos) {
            double valorPretendido = valorPretendido();
            if (valorPretendido >= 2000.0 && i < 5){
                selecionados[i] =  candidato;
                i++;
            }
        }
        return selecionados;
    }

    static void listarSelecionados (String[] selecionados) {
        for( String selecionado: selecionados){
            if ( selecionado != null){
                System.out.println(selecionado);
            }
        }
    }

    static void ligarParaCandidatos(String[] selecionados) {
        for (String selecionado : selecionados) {
            if(selecionado == null) continue;
            int tentativas = 1;
            for (int i = 1; i < 3; i++) {
                boolean atendeu = Math.random() > 0.5;
                if (atendeu) {
                    System.out.println("Conseguimos contato com "
                        + selecionado
                        + " após "
                        + tentativas
                        + " tentativa(s)");
                    break;
                }
                tentativas++;
                if(tentativas == 3){
                    System.out.println("Não conseguimos contato com " + selecionado + ".");
                }
            }
        }

    }
}