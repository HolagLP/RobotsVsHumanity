package com.mart.rvsh.data;

public class Humanity {
	
	public static double humanity = 7000000000.0;
	public static long finalHumanity = 7000000000L;
	public static double killspersecond = 0.0;
	
	public static int detectedKills = 0;;
	
	public void increaseHumanity(){
		finalHumanity = Math.round(humanity);
		humanity = humanity + (humanity/300000000);
	}
	
	public void decreaseHumanity(){
		finalHumanity = Math.round(humanity);
		killspersecond = (RobotStats.robots * 0.02) 
				+ (RobotStats.stealthbots * RobotStats.stealthbotCPS/10)
				+ (RobotStats.arachnotrons * RobotStats.arachnotronCPS/10);
		humanity = humanity - killspersecond;
	}
	
	public void setDetectedKills(){
		detectedKills += ((int) RobotStats.robots * RobotStats.robotsCPS)
				+ ((int) RobotStats.stealthbots * RobotStats.stealthbotCPS/2)
				+ ((int)RobotStats.arachnotrons * 1);
 	}
	
	public void decreaseHumanityOnClick(){
		humanity--;
	}

}
