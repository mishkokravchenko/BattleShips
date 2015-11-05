package org.itstep.sea.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class GameController implements ActionListener {
	public GameModel model;
	public GameView view;

	public GameController(GameView view, GameModel model) {
		this.view = view;
		this.model = model;
	}
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd == "New game") { 	
				model.newGame();
		}
		if (cmd == "5 x 5") {
			model.setDimention(5, 5, 2);
		}
		
		if (cmd == "10 x 10") {
			model.setDimention(10, 10, 4);
		}
		
		if (cmd == "15 x 15") {
			model.setDimention(15, 15, 6);
		}
		
		if (cmd == "20 x 20") {
			model.setDimention(20, 20, 7);
		}
		
		if (cmd == "About") {
			System.out.println("About");
		}
		if (cmd == "Exit") {	
			System.exit(0);
		}
	}

	public void mousePressed(MouseEvent arg0) {
		PanelField field =  view.panelPlayerOpponent;
		int x = arg0.getX() / (field.getWidth() / field.getField().getWidth());
		int y = arg0.getY() / (field.getHeight() / field.getField().getHeight());
		if ( field.getField().isBound(x, y) ) {
			model.doShotByOpponent(x, y);
		}
	}

}
