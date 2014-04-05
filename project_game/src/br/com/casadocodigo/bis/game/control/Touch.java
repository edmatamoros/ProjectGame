package br.com.casadocodigo.bis.game.control;

import org.cocos2d.events.CCTouchDispatcher;
import org.cocos2d.layers.CCLayer;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCSprite;
import static br.com.casadocodigo.bis.config.DeviceSettings.screenResolution;


import org.cocos2d.types.CGPoint;
import org.cocos2d.types.CGRect;

import android.view.MotionEvent;

public class Touch extends CCLayer{
	
	CCSprite canon1;


	public Touch() {
		
		// Enable Touch
			this.setIsTouchEnabled(true);
			
	}
	
	
	@Override
	public boolean ccTouchesBegan(MotionEvent event) {
	  
		canon1 = CCSprite.sprite("android.png");
	     canon1.setPosition(screenResolution(CGPoint.ccp(50, 80)));
	     canon1.setScale(1f);
	    addChild(canon1);

	   // CGRect canon1Rect = CGRect.make(canon1.getPosition().x - (canon1.getContentSize().width/2),
	   //         canon1.getPosition().y - (canon1.getContentSize().height/2),
	   //         canon1.getContentSize().width,
	   //         canon1.getContentSize().height);

	    // Choose one of the touches to work with
	    //CGPoint location = CCDirector.sharedDirector().convertToGL(CGPoint.ccp(10,60));

	return true;
	  
	}
	
	@Override
	public boolean ccTouchesEnded(MotionEvent event) {
		
		//canon1 = CCSprite.sprite("android.png");
	     //canon1.setPosition(screenResolution(CGPoint.ccp(50, 80)));
	     //scanon1.setScale(1f);
	    removeChild(canon1, true);
		
	  return true;
	}
	@Override
	public boolean ccTouchesMoved(MotionEvent event) {
		
		canon1 = CCSprite.sprite("android.png");
	     canon1.setPosition(screenResolution(CGPoint.ccp(90, 110)));
	     canon1.setScale(1f);
	    addChild(canon1);
		
	  return true;
	}
	/*
	@Override
	public boolean ccTouchesCancelled(MotionEvent event) {
	  return super.ccTouchesCancelled(event);
	}*/

}
