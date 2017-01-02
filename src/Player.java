import java.util.ArrayList;

public class Player {
//	private Boolean turn;
	private ArrayList hand;
	private int total;

//	public Boolean getTurn() {
//		return turn;
//	}
//
//	public void setTurn(Boolean turn) {
//		this.turn = turn;
//	}

	public ArrayList getHand() {
		return hand;
	}

	public void setHand(ArrayList hand) {
		this.hand = hand;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int addThis) {
		this.total = total + addThis;
	}
}
