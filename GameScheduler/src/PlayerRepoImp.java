
public class PlayerRepoImp implements IPlayerRepo {
	private Player[] players;
	private int numPlayers;

	PlayerRepoImp() {
		players = new Player[5];
		numPlayers = 0;
	}

	@Override
	public String save(Player p) {
		if (numPlayers < players.length) {
			players[numPlayers] = p;
			numPlayers++;
		} else {
			Player[] oldPlayers = players.clone();
			players = new Player[numPlayers + 5];
			for (int i = 0; i < oldPlayers.length; i++) {
				players[i] = oldPlayers[i];
			}
			players[numPlayers] = p;
			numPlayers++;
		}
		return "Player saved successfully!";
	}

	@Override
	public Player findOne(String name) {
		for (Player player : players) {
			// if player exists
			if (player != null && player.getName().equals(name)) {
				return player;
			}
		}
		// if player does not exist
		return null;
	}

	@Override
	public Player[] findAll() {
		return this.players;
	}

}
