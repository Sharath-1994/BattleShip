package com.battleship.mvc;

import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

import com.battleship.logic.BattleShipLogic;
import com.battleship.model.Player;

@Repository
public class PlayerDAO {

	private final static Logger log = org.slf4j.LoggerFactory.getLogger(PlayerDAO.class);

	public boolean storeData(Player p) throws Exception {

		boolean result = BattleShipLogic.checkDimensionLogic(p);

		if (result == true) {
			log.error("Unable to create");
			return true;
		} else {
			log.info("Able to create");
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
			PlayerDAO.player1Details(p);
			return false;

		}

	}

	public static int[][] player1Details(Player p1) throws Exception {

		int[][] a = new int[p1.getDimensionOfBattleGroundWidth()][p1.getDimensionOfBattleGroundHeight()];
		int locationOfBs1Row = BattleShipLogic.checkChar(p1.getAddBattleField1ToDimension());
		int locationOfBS1Width = BattleShipLogic.checkNumber(p1.getAddBattleField1ToDimension());

		int locationOfBs2Row = BattleShipLogic.checkChar(p1.getAddBattleField2ToDimension());
		int locationOfBS2Width = BattleShipLogic.checkNumber(p1.getAddBattleField2ToDimension());

		BattleShipLogic.addElemenetInArrayByDimension(a, p1.getDimensionOfShip1Row(), p1.getDimensionOfShip1Column(),
				p1.getTypeOfShip1(), locationOfBs1Row, locationOfBS1Width);

		BattleShipLogic.addElemenetInArrayByDimension(a, p1.getDimensionOfShip2Row(), p1.getDimensionOfShip2Column(),
				p1.getTypeOfShip2(), locationOfBs2Row, locationOfBS2Width);
		BattleShipLogic.printArray(a);
		log.info("Player 1 battle field");
		return a;

	}

	public static int[][] player2Details(Player p2) throws Exception {

		int[][] a = new int[p2.getDimensionOfBattleGroundWidth()][p2.getDimensionOfBattleGroundHeight()];

		int locationOfBs1Row = BattleShipLogic.checkChar(p2.getAddBattleField1ToDimension());
		int locationOfBS1Width = BattleShipLogic.checkNumber(p2.getAddBattleField1ToDimension());

		int locationOfBs2Row = BattleShipLogic.checkChar(p2.getAddBattleField2ToDimension());
		int locationOfBS2Width = BattleShipLogic.checkNumber(p2.getAddBattleField2ToDimension());

		BattleShipLogic.addElemenetInArrayByDimension(a, p2.getDimensionOfShip1Row(), p2.getDimensionOfShip1Column(),
				p2.getTypeOfShip1(), locationOfBs1Row, locationOfBS1Width);

		BattleShipLogic.addElemenetInArrayByDimension(a, p2.getDimensionOfShip2Row(), p2.getDimensionOfShip2Column(),
				p2.getTypeOfShip2(), locationOfBs2Row, locationOfBS2Width);
		BattleShipLogic.printArray(a);
		log.info("Player 2 battle field");
		return a;

	}

	public boolean attackShips() {

		return false;

	}

	public static void updatePlayer1(int[][] player1BattleShip, Player p) {

		Player p1 = new Player();
		int[][] a = new int[p.getDimensionOfBattleGroundWidth()][p.getDimensionOfBattleGroundHeight()];

	}

	public static void updatePlayer2(int[][] player2BattleShip, Player p) {

		Player p1 = new Player();
		int[][] a = new int[p.getDimensionOfBattleGroundWidth()][p.getDimensionOfBattleGroundHeight()];
		

	}

}
