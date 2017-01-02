import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private ArrayList card;

	public ArrayList getCard() {
		return card;
	}

	public void setCard(ArrayList card) {
		this.card = card;
	}
	
	public void shuffle() {
		Collections.shuffle(this.card);
	}
}
