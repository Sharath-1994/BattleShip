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
	private List<Player> playerData = new ArrayList<>();

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

		List<String> missilesOfPlayer1 = BattleShipLogic.seperateMissiles(p1.getMissileTarget());
		System.out.println(missilesOfPlayer1.get(0) + missilesOfPlayer1.get(0) + "Missiles of Player 1");
		List<String> missilesOfPlayer2 = BattleShipLogic.seperateMissiles(p2.getMissileTarget());
		System.out.println(missilesOfPlayer1.get(0) + missilesOfPlayer1.get(0) + "Missiles of Player 2");

		for (int i = 0; i < missilesOfPlayer1.size(); i++) {
			String missileLocation = missilesOfPlayer1.get(i);

			int locationRow = BattleShipLogic.checkChar(missileLocation);
			int locationCol = BattleShipLogic.checkNumber(missileLocation);
			System.out.println(missilesOfPlayer1.remove(i + "Missile removed "));
			int update[][] = BattleShipLogic.Attack(b, locationRow, locationCol, p1);
			PlayerDAO.updatePlayer2(update);

		}

		return false;

	}

	public static int[][] updatePlayer1(int[][] player1BattleShip) {

		BattleShipLogic.printArray(player1BattleShip);
		return player1BattleShip;
	}

	public static int[][] updatePlayer2(int[][] player2BattleShip) {

		BattleShipLogic.printArray(player2BattleShip);
		return player2BattleShip;
	}

}
