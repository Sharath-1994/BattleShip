package com.battleship.mvc;


import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

import com.battleship.logic.BattleShipLogic;
import com.battleship.model.Player;

@Repository
public class PlayerDAO {

	private final Logger log = org.slf4j.LoggerFactory.getLogger(PlayerDAO.class);

	public boolean storeData(Player p) {

		int[][] player1 = new int[p.getDimensionOfBattleGroundHeight()][p.getDimensionOfBattleGroundWidth()];

		
		player1[p.getDimensionOfShip1Row()][p.getDimensionOfShip1Column()] = p.getTypeOfShip1();
		player1[p.getDimensionOfShip2Row()][p.getDimensionOfShip2Column()] = p.getTypeOfShip2();
		
		log.info("Player 1 battle field");
		BattleShipLogic.printArray(player1);
		
		return true;
	}

	public boolean storeData2(Player p) {

		int[][] player1 = new int[p.getDimensionOfBattleGroundHeight()][p.getDimensionOfBattleGroundWidth()];

		player1[p.getDimensionOfShip1Row()][p.getDimensionOfShip1Column()] = p.getTypeOfShip1();
		player1[p.getDimensionOfShip2Column()][p.getDimensionOfShip2Row()] = p.getTypeOfShip2();
		
		log.info("Player 2 battle field");
		BattleShipLogic.printArray(player1);

		return true;
	}

}
