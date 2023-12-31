package oi;
import robocode.*;
import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * Frederico - a robot by (your name here)
 */
public class Frederico extends Robot
{
	/**
	 * run: Frederico's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		setColors(Color.cyan,Color.magenta,Color.white); // body,gun,radar

		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			ahead(100);
			turnGunRight(360);
			
			
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
public void onScannedRobot(ScannedRobotEvent e) {
    // Calcula a diferença de ângulo entre a posição atual do canhão e o inimigo
    double anguloParaInimigo = getHeading() + e.getBearing() - getGunHeading();
    
    // Gira o canhão para a posição do inimigo
    turnGunRight(anguloParaInimigo);

    // Dispara quando o canhão estiver apontando diretamente para o inimigo
    if (getGunHeat() == 0 && Math.abs(anguloParaInimigo) < 2) {
        fire(3); // Ajuste a potência de fogo conforme necessário
    }
}



	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		back(30);
		turnLeft(45);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		turnRight(90);
		ahead(20);
	}	
}
