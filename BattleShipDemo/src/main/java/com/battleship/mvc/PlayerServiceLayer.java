package com.battleship.mvc;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.battleship.model.Player;

@Service
public class PlayerServiceLayer {

	@Autowired
	PlayerDAO dao;

	public boolean sendDataToDAO(Player p) throws Exception {

		return dao.storeData(p);
	}
	
	public boolean sendData2ToDAO(Player p) throws Exception {
		return dao.storeData2(p);
	}
	

	public boolean attackSeviceData() {
		
		return true;

	}

}
