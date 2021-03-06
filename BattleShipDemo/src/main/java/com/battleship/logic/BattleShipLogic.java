package com.battleship.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.battleship.model.Player;

public class BattleShipLogic {

	// Logic to check while placing ship to battle field
	public static int checkChar(String a) {

		char firstCharacter = a.charAt(0);
		int numbers = 0;

		switch (firstCharacter) {

		case 'A':
			numbers = 0;
			break;
		case 'B':
			numbers = 1;
			break;
		case 'C':
			numbers = 2;
			break;
		case 'D':
			numbers = 3;
			break;
		case 'E':
			numbers = 4;
			break;
		case 'F':
			numbers = 5;
			break;

		case 'G':
			numbers = 6;
			break;
		}

		return numbers;

	}

	// Logic to check while placing ship to battle field
	public static int checkNumber(String dimension) {
		String a = dimension;
		char a1 = a.charAt(1);

		int result = 0;
		switch (a1) {

		case '1':
			result = 0;
			break;
		case '2':
			result = 1;
			break;
		case '3':
			result = 2;
			break;
		case '4':
			result = 3;
			break;
		case '5':
			result = 4;
			break;
		case '6':
			result = 5;
			break;
		case '7':
			result = 6;
			break;
		case '8':
			result = 7;
			break;
		case '9':
			result = 8;
			break;

		}

		return result;
	}

	// Display Player Battle field
	public static void printArray(int[][] a) {

		for (int row = 0; row < a.length; row++) {
			for (int col = 0; col < a[row].length; col++) {
				System.out.print(a[row][col] + " ");
			}
			System.out.println("");
		}

	}

	// Compare the dimension of ships vs dimension of Battleground
	public static boolean checkDimensionLogic(Player p) {

		int dimension = p.getDimensionOfBattleGroundHeight() * p.getDimensionOfBattleGroundWidth();

		int dimensionOfShip = p.getDimensionOfShip1Column() * p.getDimensionOfShip1Row();

		int dimesionOfShip2 = p.getDimensionOfShip2Column() * p.getDimensionOfShip1Row();

		int a = dimensionOfShip + dimesionOfShip2;

		if (a >= dimension) {
			return true;
		} else {
			return false;
		}

	}

	// Spilt the number of missiles given into List
	public static List<String> seperateMissiles(String missiles) {

		String l[] = missiles.trim().split(",");

		List<String> list = new ArrayList<String>(Arrays.asList(l));

		return list;

	}

	// Add Battle ship in dimenion given
	public static void addElemenetInArrayByDimension(int[][] a, int battleShipWidth, int bsHeight, int shipType,
			int dimensionOfShipFromWidth, int dimensionOfShipFromHeight) throws Exception {

		int[][] b = a;

		for (int row = dimensionOfShipFromWidth; row < dimensionOfShipFromWidth + battleShipWidth; row++) {

			for (int col = dimensionOfShipFromHeight; col < dimensionOfShipFromHeight + bsHeight; col++) {

				if (b[row][col] == 0) {

					b[row][col] = shipType;
				} else {
					throw new Exception("Unable to add ship as other ship already exists");
				}
			}
		}

	}

	// Attacking player logic
	public static boolean Attack(int[][] a, int row, int col, Player p) {

		int[][] b = a;

		if (b[row][col] == 1 || b[row][col] == 2) {
			System.out.println(b[row][col]);
			b[row][col] = b[row][col] - 1;
			//System.out.println(p.getPlayerName() + "Hits" + "Row" + row + "Col" + col);
			printArray(b);
			return true;
		}
		return false;
	}

	//Code to check the result of player
	public static boolean checkResult(int[][] a) {

		boolean searchResult = false;

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (a[i][j] == 1 || a[i][j] == 2) {
					searchResult = true;
					break;
				}
			}
		}

		if (searchResult) {
			System.out.println("Found continue to play");
			return true;
		} else {
			System.out.println("Winner");
			return false;
		}

	}

	public static String hitLogic(int number) {

		String hitResultName = null;
		switch (number) {

		case 1:
			hitResultName = "Hit";
			break;

		case 0:
			hitResultName = "Miss";
			break;
		}

		return hitResultName;

	}

	public static String playerLogic(int number) {

		String playerName = null;

		switch (number) {
		case 1:
			playerName = "Player1 ";
			break;

		case 2:
			playerName = "Player2 ";
			break;
		}
		
		return playerName;

	}
}
