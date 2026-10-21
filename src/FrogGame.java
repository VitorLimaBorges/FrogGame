import java.util.Scanner;

public class FrogGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        int frog = 3;
        
        String direction = "";

        IO.println("W - Pular para frente\nS - Pular para baixo\nQ - Sair\n");

        desenharTabuleiro(frog);

        
        while(!direction.equals("q")){
            
            
            IO.println("Digite seu movimento (W/S) ou Q para sair:");
            
            direction = scanner.next().toLowerCase();
            
            if (direction.equals("q")) {
                IO.println("Saindo do jogo...");
                break;
            }
            else if (direction.equals("w")) {

                int posicaoAnterior = frog;

                frog = frogMoveUp(frog);

                if(posicaoAnterior != frog){

                    IO.println("o sapo pulou para frente e está na linha " + frog);

                    desenharTabuleiro(frog);
                
                }

            } else if (direction.equals("s")) {

                int posicaoAnterior = frog;

                frog = frogMoveDown(frog);

                if(posicaoAnterior != frog){

                    IO.println("o sapo pulou para baixo e está na linha " + frog);
            
                    desenharTabuleiro(frog);

                }

            } else {
                System.out.println("Comando inválido");
            }

        }
        
        scanner.close();
    }

    static int frogMoveUp(int frog){
        if(frog > 0){
            frog = frog - 1;
        } else {
            IO.println("o sapo não pode pular para frente");
        }
        
        return frog;
    }

    static int frogMoveDown(int frog){
        if(frog < 3){
            frog = frog + 1;
        } else {
            IO.println("o sapo não pode pular para baixo");
        }

        return frog;
    }
    
    static void desenharTabuleiro(int frog){
        
        for(int linha = 0; linha < 4; linha++){
            if(linha == frog){
                IO.print("[" + linha + "]");
                IO.println("[S]");
            } else {
                IO.print("[" + linha + "]");
                IO.println("[ ]");
            }
        }

    }

}
