package com.battleship.mvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

import com.battleship.logic.BattleShipLogic;
import com.battleship.model.Player;

@Repository
public class PlayerDAO {

	private final static Logger log = org.slf4j.LoggerFactory.getLogger(PlayerDAO.class);

	private static Map<Integer, int[][]> data = new HashMap<>();

	// Player 1 and Player 2 Data
	private List<Player> playerData = new ArrayList<>();

	// List of messages of players attack
	public static List<String> message = new ArrayList<String>();

	// flag to identify hit or miss
	private static int hit = -1;

	// flag to identify current player
	private static int currentPlayer = -1;

	// Status to check results of player 1
	private static boolean resultPlayer1 = false;

	// Status to check results of player 2
	private static boolean resultPlayer2 = false;

	// Store data of Player1
	public boolean storeData(Player p) throws Exception {

		boolean result = BattleShipLogic.checkDimensionLogic(p);

		if (result == true) {
			log.error("Unable to create");
			return true;
		} else {
			log.info("Able to create");
			playerData.add(p);
			PlayerDAO.player1Details(p);
			return false;

		}
	}

	// Store data of Player2
	public boolean storeData2(Player p) throws Exception {
		boolean result = BattleShipLogic.checkDimensionLogic(p);
		PlayerDAO.player2Details(p);
		if (result == true) {
			log.error("Unable to create");
			return true;
		} else {
			log.info("Able to create");
			playerData.add(p);
			PlayerDAO.player1Details(p);
			return false;

		}

	}

	// Store data of player1 with battleshipDimension and battleshiplocation
	public static int[][] player1Details(Player p1) throws Exception {

		int[][] player1 = new int[p1.getDimensionOfBattleGroundWidth()][p1.getDimensionOfBattleGroundHeight()];
		int locationOfBs1Row = BattleShipLogic.checkChar(p1.getAddBattleField1ToDimension());
		int locationOfBS1Width = BattleShipLogic.checkNumber(p1.getAddBattleField1ToDimension());

		int locationOfBs2Row = BattleShipLogic.checkChar(p1.getAddBattleField2ToDimension());
		int locationOfBS2Width = BattleShipLogic.checkNumber(p1.getAddBattleField2ToDimension());

		BattleShipLogic.addElemenetInArrayByDimension(player1, p1.getDimensionOfShip1Row(),
				p1.getDimensionOfShip1Column(), p1.getTypeOfShip1(), locationOfBs1Row, locationOfBS1Width);

		BattleShipLogic.addElemenetInArrayByDimension(player1, p1.getDimensionOfShip2Row(),
				p1.getDimensionOfShip2Column(), p1.getTypeOfShip2(), locationOfBs2Row, locationOfBS2Width);

		data.put(p1.getPlayerNumber(), player1);
		BattleShipLogic.printArray(player1);
		log.info("Player 1 battle field");
		return player1;

	}

	// Store data of player2 with battleshipDimension and battleshiplocation
	public static int[][] player2Details(Player p2) throws Exception {

		int[][] player2 = new int[p2.getDimensionOfBattleGroundWidth()][p2.getDimensionOfBattleGroundHeight()];

		int locationOfBs1Row = BattleShipLogic.checkChar(p2.getAddBattleField1ToDimension());
		int locationOfBS1Width = BattleShipLogic.checkNumber(p2.getAddBattleField1ToDimension());

		int locationOfBs2Row = BattleShipLogic.checkChar(p2.getAddBattleField2ToDimension());
		int locationOfBS2Width = BattleShipLogic.checkNumber(p2.getAddBattleField2ToDimension());

		BattleShipLogic.addElemenetInArrayByDimension(player2, p2.getDimensionOfShip1Row(),
				p2.getDimensionOfShip1Column(), p2.getTypeOfShip1(), locationOfBs1Row, locationOfBS1Width);

		BattleShipLogic.addElemenetInArrayByDimension(player2, p2.getDimensionOfShip2Row(),
				p2.getDimensionOfShip2Column(), p2.getTypeOfShip2(), locationOfBs2Row, locationOfBS2Width);

		data.put(p2.getPlayerNumber(), player2);
		BattleShipLogic.printArray(player2);
		log.info("Player 2 battle field");
		return player2;

	}

	// Attack logic
	public boolean attackShips() {

		System.out.println("Attack ship method called");

		int a[][] = data.get(1);
		int b[][] = data.get(2);

		Player p1 = playerData.get(0);
		Player p2 = playerData.get(1);

		// Player 1 Missiles
		List<String> missilesOfPlayer1 = BattleShipLogic.seperateMissiles(p1.getMissileTarget());

		// Player 2 Missiles
		List<String> missilesOfPlayer2 = BattleShipLogic.seperateMissiles(p2.getMissileTarget());

		int lenghtOfBothArray = missilesOfPlayer1.size() + missilesOfPlayer2.size();

		// Initial calling of Player 1
		if (hit == -1) {
			currentPlayer = 1;
			missilesOfPlayer1 = PlayerDAO.chanceToNextPlayer(b, missilesOfPlayer1, p1);

			for (int i = 0; i < missilesOfPlayer1.size(); i++) {
				System.out.println("List of modied array list after removing 1 element " + missilesOfPlayer1.get(i));
			}

		}

		for (int i = 0; i < lenghtOfBothArray; i++) {
			resultPlayer1 = BattleShipLogic.checkResult(b);
			resultPlayer2 = BattleShipLogic.checkResult(a);
			if (resultPlayer1 == false) {
				message.add("Player 1 Wins");
				break;
			} else if (resultPlayer2 == false) {
				message.add("Player 2 Wins");
				break;
			} else {

				if (hit == 0 || hit == 1) {

					switch (hit) {

					case 1:
						if (currentPlayer == 1) {

							if (missilesOfPlayer2.size() == 0) {
								message.add("Player2 Runs out of missiles");
								chanceToNextPlayer(b, missilesOfPlayer1, p1);
								currentPlayer = 1;
							}
							System.out.println("Hit by player 1");

							chanceToNextPlayer(b, missilesOfPlayer1, p1);

						} else if (currentPlayer == 2) {

							if (missilesOfPlayer1.size() == 0) {
								message.add("Player1 Runs out of missiles");
								chanceToNextPlayer(a, missilesOfPlayer2, p2);
								currentPlayer = 2;
							}
							System.out.println("Hit by player 2");
							chanceToNextPlayer(a, missilesOfPlayer2, p2);
						}

					case 0:
						if (currentPlayer == 1) {
							System.out.println("Miss by player 1");
							if (missilesOfPlayer2.size() == 0) {
								message.add("Player2 Runs out of missiles");
								chanceToNextPlayer(b, missilesOfPlayer1, p1);
								currentPlayer = 1;
							} else {
								currentPlayer = 2;
								chanceToNextPlayer(a, missilesOfPlayer2, p2);
							}
						} else if (currentPlayer == 2) {
							System.out.println("Miss by player 2");
							if (missilesOfPlayer1.size() == 0) {
								message.add("Player1 Runs out of missiles");
								chanceToNextPlayer(a, missilesOfPlayer2, p2);
								currentPlayer = 2;
							} else {
								currentPlayer = 1;
								chanceToNextPlayer(b, missilesOfPlayer1, p1);
							}

						}

					}
				}
			}

		}
		return false;
	}

	//Logic to give chance to next player
	public static List<String> chanceToNextPlayer(int[][] player, List<String> missile, Player p) {

		for (int i = 0; i < missile.size();) {

			String missileLocation = missile.get(i);
			int locationRow = BattleShipLogic.checkChar(missileLocation);
			int locationCol = BattleShipLogic.checkNumber(missileLocation);
			boolean hitResult = BattleShipLogic.Attack(player, locationRow, locationCol, p);
			String hitNumber;
			String battleShipCurrentPlayer;

			if (hitResult == true) {
				hit = 1;
				hitNumber = BattleShipLogic.hitLogic(hit);
				battleShipCurrentPlayer = BattleShipLogic.playerLogic(currentPlayer);
				message.add(battleShipCurrentPlayer + " " + hitNumber + " " + missileLocation);
				missile.remove(i);
				return missile;
			} else {
				hit = 0;
				hitNumber = BattleShipLogic.hitLogic(hit);
				battleShipCurrentPlayer = BattleShipLogic.playerLogic(currentPlayer);
				message.add(battleShipCurrentPlayer + " " + hitNumber + " " + missileLocation);
				missile.remove(i);
				return missile;
			}

		}

		return missile;

	}

}
