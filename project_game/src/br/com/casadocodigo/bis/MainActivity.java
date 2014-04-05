package br.com.casadocodigo.bis;

import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.opengl.CCGLSurfaceView;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import br.com.casadocodigo.bis.config.DeviceSettings;
import br.com.casadocodigo.bis.game.scenes.TitleScreen;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Orientação da tela, ignorando o sensor
		//Vertical = SCREEN_ORIENTATION_PORTRAIT
		//Horizonta = SCREEN_ORIENTATION_LANDSCAPE
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		//Sem titulo
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//Tela cheia
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		// view
		CCGLSurfaceView glSurfaceView = new CCGLSurfaceView(this);
		setContentView(glSurfaceView);
		CCDirector.sharedDirector().attachInView(glSurfaceView);
		
		// sensor manager - Método da própria classe
		configSensormanager();
		
		// configure CCDirector 
		CCDirector.sharedDirector().setScreenSize(320, 480);
		
		// Starts title screen
		//Classe usada Titlescreen
		CCScene scene = new TitleScreen().scene();
		CCDirector.sharedDirector().runWithScene(scene);
	}
	
	private void configSensormanager() {
		SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		//Classe usada DeviceSettings
		DeviceSettings.setSensorManager(sensorManager);
	}

}
