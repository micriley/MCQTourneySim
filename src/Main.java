
public class Main {
	public static void main(String[]args) {
		Tournament tournament = new Tournament(4000,8,2);
		tournament.runTournament();
		System.out.println(tournament.reportRecordCounts());
	}
}
