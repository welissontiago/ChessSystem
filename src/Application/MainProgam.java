package Application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Chess.ChessException;
import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.ChessPosition;

public class MainProgam {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	
		ChessMatch chessMatch = new ChessMatch();
		List<ChessPiece> captureds = new ArrayList<>();
		
		while(!chessMatch.getCheckMate()) {
			try {
				
			
			UI.clearScreen();
			UI.printMatch(chessMatch, captureds);
			System.out.println();
			System.out.print("Origem: ");
			ChessPosition source = UI.readChessPosition(sc);
			
			boolean[][] possibleMoves = chessMatch.possibleMoves(source);
			UI.clearScreen();
			UI.printBoard(chessMatch.getPieces(), possibleMoves);
			
			System.out.println("");
			System.out.println("Alvo: ");
			ChessPosition target = UI.readChessPosition(sc);
			
			ChessPiece captuedPiece = chessMatch.performanceChessMove(source, target);
			if(captuedPiece != null) {
				captureds.add(captuedPiece);
			}
			
			}catch(ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
		UI.clearScreen();
		UI.printMatch(chessMatch, captureds);
	}

}
