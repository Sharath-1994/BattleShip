package com.battleship.model;

//@SuppressWarnings("unused")

public class Player {

	private String playerName;
	private Integer playerNumber;

	private int dimensionOfBattleGroundWidth;
	private int dimensionOfBattleGroundHeight;
	private int typeOfShip1;
	private int DimensionOfShip1Column;
	private int DimensionOfShip1Row;
	private String addBattleField1ToDimension;
	private int typeOfShip2;
	private int DimensionOfShip2Column;
	private int DimensionOfShip2Row;
	private String addBattleField2ToDimension;
	private String missileTarget;

	public String getMissileTarget() {
		return missileTarget;
	}

	public void setMissileTarget(String missileTarget) {
		this.missileTarget = missileTarget;
	}

	public Integer getPlayerNumber() {
		return playerNumber;
	}

	public void setPlayerNumber(Integer playerNumber) {
		this.playerNumber = playerNumber;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getDimensionOfBattleGroundWidth() {
		return dimensionOfBattleGroundWidth;
	}

	public void setDimensionOfBattleGroundWidth(int dimensionOfBattleGroundWidth) {
		this.dimensionOfBattleGroundWidth = dimensionOfBattleGroundWidth;
	}

	public int getDimensionOfBattleGroundHeight() {
		return dimensionOfBattleGroundHeight;
	}

	public void setDimensionOfBattleGroundHeight(int dimensionOfBattleGroundHeight) {
		this.dimensionOfBattleGroundHeight = dimensionOfBattleGroundHeight;
	}

	public int getTypeOfShip1() {
		return typeOfShip1;
	}

	public void setTypeOfShip1(int typeOfShip1) {
		this.typeOfShip1 = typeOfShip1;
	}

	public int getDimensionOfShip1Column() {
		return DimensionOfShip1Column;
	}

	public void setDimensionOfShip1Column(int dimensionOfShip1Column) {
		DimensionOfShip1Column = dimensionOfShip1Column;
	}

	public int getDimensionOfShip1Row() {
		return DimensionOfShip1Row;
	}

	public void setDimensionOfShip1Row(int dimensionOfShip1Row) {
		DimensionOfShip1Row = dimensionOfShip1Row;
	}

	public String getAddBattleField1ToDimension() {
		return addBattleField1ToDimension;
	}

	public void setAddBattleField1ToDimension(String addBattleField1ToDimension) {
		this.addBattleField1ToDimension = addBattleField1ToDimension;
	}

	public int getTypeOfShip2() {
		return typeOfShip2;
	}

	public void setTypeOfShip2(int typeOfShip2) {
		this.typeOfShip2 = typeOfShip2;
	}

	public int getDimensionOfShip2Column() {
		return DimensionOfShip2Column;
	}

	public void setDimensionOfShip2Column(int dimensionOfShip2Column) {
		DimensionOfShip2Column = dimensionOfShip2Column;
	}

	public int getDimensionOfShip2Row() {
		return DimensionOfShip2Row;
	}

	public void setDimensionOfShip2Row(int dimensionOfShip2Row) {
		DimensionOfShip2Row = dimensionOfShip2Row;
	}

	public String getAddBattleField2ToDimension() {
		return addBattleField2ToDimension;
	}

	public void setAddBattleField2ToDimension(String addBattleField2ToDimension) {
		this.addBattleField2ToDimension = addBattleField2ToDimension;
	}

	@Override
	public String toString() {
		return "Player [playerName=" + playerName + ", playerNumber=" + playerNumber
				+ ", dimensionOfBattleGroundWidth=" + dimensionOfBattleGroundWidth + ", dimensionOfBattleGroundHeight="
				+ dimensionOfBattleGroundHeight + ", typeOfShip1=" + typeOfShip1 + ", DimensionOfShip1Column="
				+ DimensionOfShip1Column + ", DimensionOfShip1Row=" + DimensionOfShip1Row
				+ ", addBattleField1ToDimension=" + addBattleField1ToDimension + ", typeOfShip2=" + typeOfShip2
				+ ", DimensionOfShip2Column=" + DimensionOfShip2Column + ", DimensionOfShip2Row=" + DimensionOfShip2Row
				+ ", addBattleField2ToDimension=" + addBattleField2ToDimension + ", missileTarget=" + missileTarget
				+ "]";
	}

	

}
