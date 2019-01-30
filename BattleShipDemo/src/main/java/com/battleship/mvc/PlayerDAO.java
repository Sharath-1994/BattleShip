package com.battleship.mvc;

import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

import com.battleship.logic.BattleShipLogic;
import com.battleship.model.Player;

@Repository
public class PlayerDAO {

	private final static Logger log = org.slf4j.LoggerFactory.getLogger(PlayerDAO.class);

	public boolean storeData(Player p) {

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

	public boolean storeData2(Player p) {
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

	public static int[][] player1Details(Player p1) {

		int[][] a = new int[p1.getDimensionOfBattleGroundWidth()][p1.getDimensionOfBattleGroundHeight()];

		BattleShipLogic.printArray(a);
		log.info("Player 1 battle field");
		return a;

	}

	public static int[][] player2Details(Player p2) {

		int[][] a = new int[p2.getDimensionOfBattleGroundWidth()][p2.getDimensionOfBattleGroundHeight()];

		a[1][2] = 1;
		BattleShipLogic.printArray(a);
		return a;

	}

	public void attackShips() {

	}

}
