
public class Player {
	private String initials;
	private int score;
	
	//default constructor
	public Player() {
		initials = "ABC";
		score = 0;
	}
	//fill constructor
	public Player(String inits, int s) {
		initials = inits;
		score = s;
	}
	//copy constructor
	public Player(Player copy) {
		initials = copy.getInitials();
		score = copy.getScore();
	}
	
	//gets
	public String getInitials() {
		return initials;
	}
	public int getScore() {
		return score;
	}
	//sets
	public void setInitials(String inits) {
		initials = inits;
	}
	public void setScore(int player_score) {
		score = player_score;
	}
	
	//Returns player in form of 'ABC-000'
	public String toString() {
		return (initials + "-" + Integer.toString(score));
	}
}
