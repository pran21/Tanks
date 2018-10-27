import java.util.Scanner;
import java.io.*;

public class TopTen {
	private Player[] players;
	private String path;
	
	//fill constructor
	public TopTen(String p) throws FileNotFoundException {
		players = new Player[10];
		path = p;
		
		File topTenFile = new File(path);
		Scanner reader = new Scanner(topTenFile);
		String[] input = new String[2];
		int i = 0;
		
		while(reader.hasNextLine()) {
			input = reader.nextLine().split("-");
			players[i] = new Player(input[0], Integer.parseInt(input[1]));
			i++;
		}
	}
	//change the top ten file path
	public void changePath(String new_path){
		path = new_path;
	}
	public void Save() {
		Sort();
		try {
			PrintWriter writer = new PrintWriter(new File(path));
			for(int i = 0; i <= 9; i++) {
				writer.println(players[i].toString());
			}
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	//sort players from highest to lowest score
	public void Sort() {
		Player temp;
		for(int i = 0; i <= 8; i++) {
			for(int j = i + 1; j <= 9; j ++) {
				if (players[i].getScore() < players[j].getScore()) {
					temp = players[j];
					players[j] = players[i];
					players[i] = temp;
				}
			}
		}
	}
	//checks and adds a player to top ten
	public void addPlayer(Player new_player) {
		Sort();
		if(new_player.getScore() > players[9].getScore()) {
			players[9] = new_player;
		}
		Sort();
	}
	//output list of top ten
	public String toString() {
		Sort();
		String output = "";
		for(int i = 0; i <= 9; i++) {
			output += (i+1) + ": " + players[i].toString() + "\n";		
		}
		return output;
	}
}
