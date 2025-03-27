package Application;

import java.util.InputMismatchException;
import java.util.Scanner;

import Chess.ChessException;
import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.ChessPosition;

public class MainProgam {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	
		ChessMatch chessMatch = new ChessMatch();
		
		while(true) {
			try {
				
			
			UI.clearScreen();
			UI.printBoard(chessMatch.getPieces());
			System.out.println();
			System.out.print("Origem: ");
			ChessPosition source = UI.readChessPosition(sc);
			
			System.out.println("");
			System.out.println("Alvo: ");
			ChessPosition target = UI.readChessPosition(sc);
			
			ChessPiece captuedPiece = chessMatch.performanceChessMove(source, target);
			}catch(ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
		
		

	}

}
