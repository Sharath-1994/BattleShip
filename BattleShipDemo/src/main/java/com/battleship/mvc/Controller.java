package com.battleship.mvc;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.battleship.model.Player;

@org.springframework.stereotype.Controller
public class Controller {

	private final Logger log = LoggerFactory.getLogger(Controller.class);

	@RequestMapping("/")
	public String welcome() {
		return "Battlefield";
	}

	@RequestMapping("/createPlayer1")
	public String startGame() {
		return "player1";
	}

	@RequestMapping("/createPlayer2")
	public String player2() {
		return "player2";
	}

	@Autowired
	PlayerServiceLayer service;

	@RequestMapping("/addPlayer1")
	public ModelAndView addPlayer1(HttpServletRequest request) throws Exception {

		ModelAndView mv = new ModelAndView();


		Player p = new Player();
		p.setPlayerName(request.getParameter("player1"));
		p.setPlayerNumber(1);
		p.setDimensionOfBattleGroundWidth(Integer.parseInt(request.getParameter("width")));
		p.setDimensionOfBattleGroundHeight(Integer.parseInt(request.getParameter("height")));
		p.setTypeOfShip1(Integer.parseInt(request.getParameter("shipP")));

		p.setDimensionOfShip1Column(Integer.parseInt(request.getParameter("shipp1Height")));
		p.setDimensionOfShip1Row(Integer.parseInt(request.getParameter("shipp1Width")));
		
		p.setDimensionOfShip2Column(Integer.parseInt(request.getParameter("shipQ1Height")));
		p.setDimensionOfShip2Row(Integer.parseInt(request.getParameter("shipQ1Width")));

		p.setAddBattleField1ToDimension(request.getParameter("setShipP"));
		p.setTypeOfShip2(Integer.parseInt(request.getParameter("shipQ")));

		p.setAddBattleField2ToDimension(request.getParameter("setShipQ"));
		p.setMissileTarget(request.getParameter("missiles"));


		boolean result = service.sendDataToDAO(p);
		if (result == true) {
			mv.setViewName("unableToCreate");

		} else {
			mv.setViewName("PlayerCreated");
		}

		return mv;

	}

	@RequestMapping("/addPlayer2")
	public ModelAndView addPlayer2(HttpServletRequest request) throws Exception {

		ModelAndView mv = new ModelAndView();
		
		
		Player p = new Player();
		p.setPlayerName(request.getParameter("player1"));
		p.setPlayerNumber(2);
		p.setDimensionOfBattleGroundWidth(Integer.parseInt(request.getParameter("width")));
		p.setDimensionOfBattleGroundHeight(Integer.parseInt(request.getParameter("height")));
		p.setTypeOfShip1(Integer.parseInt(request.getParameter("shipP")));
		p.setDimensionOfShip1Column(Integer.parseInt(request.getParameter("shipp1Height")));
		p.setDimensionOfShip1Row(Integer.parseInt(request.getParameter("shipp1Width")));
		p.setAddBattleField1ToDimension(request.getParameter("setShipP"));
		p.setTypeOfShip2(Integer.parseInt(request.getParameter("shipQ")));
		p.setDimensionOfShip2Column(Integer.parseInt(request.getParameter("shipQ1Height")));
		p.setDimensionOfShip2Row(Integer.parseInt(request.getParameter("shipQ1Width")));
		p.setAddBattleField2ToDimension(request.getParameter("setShipQ"));
		p.setMissileTarget(request.getParameter("missiles"));
		
		
		boolean result = service.sendData2ToDAO(p);

		if (result == true) {
			mv.setViewName("unableToCreate");

		} else {
			mv.setViewName("PlayerCreated2");
		}

		return mv;
	}

	@RequestMapping("/StartGame")
	public String gameStart() {

		 service.attackSeviceData();

		return "battleResult";
	}

}
