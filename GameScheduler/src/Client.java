
public class Client {
	static ISchedulerService service;
	static {
		IGameRepo gameRepo = new GameRepoImp();
		IPlayerRepo playerRepo = new PlayerRepoImp();
		IDayRepo dayRepo = new DayRepoImp();

		service = new SchedulerServiceImp(gameRepo, playerRepo, dayRepo);
	}

	public static void main(String[] args) {
	}

	public static String addGame(String name, int numPlayers) {
		// String response;
		// if (name != null && name.matches(".*[a-z].*") && numPlayers > 0) {
		// response = service.createGame(new Game(name, numPlayers));
		// } else if (numPlayers < 1) {
		// response = "Invalid number of players!";
		// } else {
		// response = "Invalid game name!";
		// }
		// System.out.println(response);
		// return response;
		return service.createGame(new Game(name, numPlayers));
	}

	public static String addPlayer(String name, Game[] games) {
		// String response;
		// if (name != null && name.matches(".*[a-z].*") && games.length > 0) {
		// response = service.createPlayer(new Player(name, games));
		// } else if (games.length < 1) {
		// response = "Invalid number of games!";
		// } else {
		// response = "Invalid player name!";
		// }
		// System.out.println(response);
		// return response;
		return service.createPlayer(new Player(name, games));
	}

	public static String addDay(String name, Game[] games) {
		// String response;
		// if (name != null && name.matches(".*[a-z].*") && games.length > 0) {
		// response = service.createDay(new Day(name, games));
		// } else if (games.length < 1) {
		// response = "Invalid number of games!";
		// } else {
		// response = "Invalid day name!";
		// }
		// System.out.println(response);
		// return response;
		return service.createDay(new Day(name, games));
	}

	public static StringBuffer generateGameWiseReport(String gameName) {
		return service.gameWiseReport(gameName);
	}

	public static StringBuffer generatePlayerWiseReport(String playerName) {
		return service.playerWiseReport(playerName);
	}

	public static StringBuffer generateDayWiseReport(String dayName) {
		return service.dayWiseReport(dayName);
	}
}
