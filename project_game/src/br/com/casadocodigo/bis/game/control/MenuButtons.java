package br.com.casadocodigo.bis.game.control;

import static br.com.casadocodigo.bis.config.DeviceSettings.screenHeight;
import static br.com.casadocodigo.bis.config.DeviceSettings.screenResolution;
import static br.com.casadocodigo.bis.config.DeviceSettings.screenWidth;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.transitions.CCFadeTransition;
import org.cocos2d.types.CGPoint;

import br.com.casadocodigo.bis.config.Assets;
import br.com.casadocodigo.bis.game.scenes.GameScene;


public class MenuButtons extends CCLayer implements ButtonDelegate {

	private Button playButton;
	private Button highscoredButton;
	
	public MenuButtons() {

		// Enable Touch
		this.setIsTouchEnabled(true);
		
		// Create Buttons
		this.playButton 	  = new Button(Assets.PLAY);
		this.highscoredButton = new Button(Assets.HIGHSCORE);
		
		// Set Buttons Delegates
		this.playButton.setDelegate(this);
		this.highscoredButton.setDelegate(this);
		
		// set position
		setButtonspPosition();

		// Add Buttons to Screen
		addChild(playButton);
		addChild(highscoredButton);
		
	}
	
	private void setButtonspPosition() {

		// Buttons Positions
		playButton.setPosition(screenResolution(CGPoint.ccp( screenWidth() /2 , screenHeight() - 250 ))) ;
		highscoredButton.setPosition(screenResolution(CGPoint.ccp( screenWidth() /2 , screenHeight() - 300 ))) ;
	}

	//A��es dos bot�es
	@Override
	public void buttonClicked(Button sender) {
		
		if (sender.equals(this.playButton)) {
			System.out.println("Button clicked: Play");
			//Cria uma nova scena
			CCDirector.sharedDirector().replaceScene(
					CCFadeTransition.transition(1.0f, GameScene.createGame()));
		}
		
		if (sender.equals(this.highscoredButton)) {
			System.out.println("Button clicked: Highscore");
		}

	}

}
