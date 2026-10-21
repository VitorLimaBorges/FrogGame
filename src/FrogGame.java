import java.util.Scanner;

public class FrogGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        int frog = 3;
        
        String direction = "";

        IO.println("W - Pular para frente\nS - Pular para baixo\nQ - Sair\n");

        drawBoard(frog);

        
        while(!direction.equals("q")){
            
            
            IO.println("Digite seu movimento (W/S) ou Q para sair:");
            
            direction = scanner.next().toLowerCase();
            
            if (direction.equals("q")) {

                IO.println("Saindo do jogo...");

                break;

            } else if (direction.equals("w") || direction.equals("s")) {

                int posicaoAnterior = frog;

                frog = frogMove(frog, direction);

                displayResult(frog, direction, posicaoAnterior);

                if(hasMoved(posicaoAnterior, frog)){

                    drawBoard(frog);

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
        } 
        
        return frog;
    }

    static int frogMoveDown(int frog){
        if(frog < 3){
            frog = frog + 1;
        } 

        return frog;
    }

    static int frogMove(int frog, String direction){

        if(direction.equals("w")){

            return frogMoveUp(frog);
            
        } else if(direction.equals("s")){

            return frogMoveDown(frog);

        }
        
        return frog;
    }

    static boolean hasMoved(int posicaoAnterior, int frog){
        
        return posicaoAnterior != frog;
    }
    
    static void drawBoard(int frog){
        
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

    static void displayResult(int frog, String direction, int posicaoAnterior){
        if(hasMoved(posicaoAnterior, frog)){
            if(direction.equals("w")){

                IO.println("o sapo pulou para frente e está na linha " + frog);

            } else if(direction.equals("s")){

                IO.println("o sapo pulou para baixo e está na linha " + frog);

            }

        
        } else {

            if(direction.equals("w")){

                IO.println("o sapo não pode pular para frente");

            } else if(direction.equals("s")){

                IO.println("o sapo não pode pular para baixo");

            }

        }
    }
    

}
