
public class Player {
	private int losses;
	private int wins;
	public Player() {
		wins = 0;
		losses = 0;
	}
	public int getLosses() {
		return losses;
	}
	public void setLosses(int losses) {
		this.losses = losses;
	}
	public int getWins() {
		return wins;
	}
	public void setWins(int wins) {
		this.wins = wins;
	}
	
	public void assignWin() {
		wins++;
	}
	
	public void assignLoss() {
		losses++;
	}
	
	public int getGames() {
		return wins + losses;
	}
	
	public int getRank() {
		return wins * 3;
	}
	
	public String reportRecord() {
		return new String(wins + "-" + losses);
	}
}