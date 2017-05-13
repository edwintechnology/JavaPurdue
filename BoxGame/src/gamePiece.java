import java.awt.*;

public class gamePiece {
	private int x;
	private int y;
	private Color gamePieceColor;
	
	public gamePiece(int x, int y, Color color){
		this.x = x;
		this.y = y;
		gamePieceColor = color;
	}
	public void paint (Graphics g){
		g.setColor(gamePieceColor); // sets color of graphic to the color of the object
		g.fillOval(x-10, y-10, 20, 20); // draws the graphic oval
	}
}
