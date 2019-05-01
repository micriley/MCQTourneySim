import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Tournament {
	private List<Player> playersInTournament;
	private List<Player> allPlayers;
	
	private int topWins;
	private int topLosses;
	public Tournament(int playerNumber, int topWins, int topLosses) {
		allPlayers = new ArrayList<Player>();
		for(int i = 0; i < playerNumber; i++) {
			Player myPlayer = new Player();
			allPlayers.add(myPlayer);
		}
		playersInTournament = new ArrayList<Player>();
		playersInTournament.addAll(allPlayers);
		this.topWins = topWins;
		this.topLosses = topLosses;
	}
	
	public void runTournament() {
		int round = 0;
		while(playersInTournament.size() > 0) {
			round++;
			List<Player> currentRoundPlayers = new ArrayList<Player>();
			currentRoundPlayers.addAll(playersInTournament);
			System.out.println("Round " + round + ", total number of players left:" + playersInTournament.size());
			Collections.shuffle(currentRoundPlayers);
			while(currentRoundPlayers.size() >= 2) {
				Player playerA = currentRoundPlayers.remove(0);
				Player playerB = currentRoundPlayers.remove(0);
				playerA.assignWin();
				if(playerA.getWins() == topWins) {
					playersInTournament.remove(playerA);
				}
				playerB.assignLoss();
				if(playerB.getLosses() == topLosses) {
					playersInTournament.remove(playerB);
				}
			}
			if(currentRoundPlayers.size() == 1) {
				Player playerA = currentRoundPlayers.remove(0);
				playerA.assignWin();
				if(playerA.getWins() == topWins) {
					playersInTournament.remove(playerA);
				}
			}
		}
	}
	
	public String reportRecordCounts() {
		Map<String,List<Player>> records = allPlayers.stream()
				.collect(Collectors.groupingBy(e -> e.reportRecord()));
		StringBuilder sb = new StringBuilder();
		for(String recordKey: records.keySet()) {
			sb.append("Number of ");
			sb.append(recordKey);
			sb.append(": ");
			sb.append(records.get(recordKey).size());
			sb.append("\n");
		}
		return sb.toString();
	}
}