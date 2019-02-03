<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Player</title>
</head>

<body>

	<h2 align="center">Player 1 Details</h2>


	<form action="/addPlayer1" method="get">

		Player Name : <input type="text" name="player1" required="required" placeholder="Player 1 Name"> <br>
		<br> Enter area boundaries: <input type="text"
			name="width" style="width: 15px"> * <input type="text"
			name="height" style="width: 15px"> <br>
		<br> Type for battleship 1: <select name="shipP">
			<option value="1" selected="selected">P</option>
			<option value="2">Q</option>

		</select> &nbsp; &nbsp; Dimension for battleship 1:  <input type="text" name="shipp1Width"
			style="width: 15px"> * <input type="text" name="shipp1Height"
			style="width: 15px"><br>
		<br> Location of battleship 1 for player A: <select name="setShipP"
			style="width: 50px">
			
			<option value="A1">A1</option>
			<option value="A2">A2</option>
			<option value="A3">A3</option>
			<option value="A4">A4</option>
			<option value="A5">A5</option>
			<option value="B1">B1</option>
			<option value="B2">B2</option>
			<option value="B3">B3</option>
			<option value="B4">B4</option>
			<option value="B5">B5</option>
			<option value="C1">C1</option>
			<option value="C2">C2</option>
			<option value="C3">C3</option>
			<option value="C4">C4</option>
			<option value="C5">C5</option>
			<option value="D1">D1</option>
			<option value="D2">D2</option>
			<option value="D3">D3</option>
			<option value="D4">D4</option>
			<option value="D5">D5</option>
			<option value="E1">E1</option>
			<option value="E2">E2</option>
			<option value="E3">E3</option>
			<option value="E4">E4</option>
			<option value="E5">E5</option>
			
		</select> <br><br> Type for battleship 2: <select name="shipQ">
			<option value="1" >P</option>
			<option value="2" selected="selected" >Q</option>

		</select> &nbsp; &nbsp; Dimension for battleship 2:<input type="text" name="shipQ1Width"
			style="width: 15px"> * <input type="text" name="shipQ1Height"
			style="width: 15px"> <br>
		<br> Location of battleship 2 for player A :<select name="setShipQ"
			style="width: 50px">

			<option value="A1">A1</option>
			<option value="A2">A2</option>
			<option value="A3">A3</option>
			<option value="A4">A4</option>
			<option value="A5">A5</option>
			<option value="B1">B1</option>
			<option value="B2">B2</option>
			<option value="B3">B3</option>
			<option value="B4">B4</option>
			<option value="B5">B5</option>
			<option value="C1">C1</option>
			<option value="C2">C2</option>
			<option value="C3">C3</option>
			<option value="C4">C4</option>
			<option value="C5">C5</option>
			<option value="D1">D1</option>
			<option value="D2">D2</option>
			<option value="D3">D3</option>
			<option value="D4">D4</option>
			<option value="D5">D5</option>
			<option value="E1">E1</option>
			<option value="E2">E2</option>
			<option value="E3">E3</option>
			<option value="E4">E4</option>
			<option value="E5">E5</option>
		</select> <br>
		<br>

	Missile targets for player 2: <input type="text" name="missiles"  required="required"  placeholder="Missile Target Location" > Note:Required Format(Eg: A1,A2,A3)
		<br>
		<br>
		<input type="submit" value="Submit">

	</form>


</body>
</html>