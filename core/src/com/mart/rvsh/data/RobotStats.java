package com.mart.rvsh.data;

public class RobotStats {
	
	public static double robotCost = 100.0;
	public static double scavengerCost = 10.0;
	public static double stealthbotCost = 400.0;
	public static double airbotCost = 2000.0;
	public static double arachnotronCost = 7000.0;
	public static double undertakerCost = 30000.0;
	
	public double robotBasecost = 100.0;
	public double scavengerBaseCost = 10.0;
	public double stealthbotBaseCost = 400.0;
	public double airbotBaseCost = 2000.0;
	public double arachnotronBaseCost = 7000.0;
	public double undertakerBaseCost = 30000.0;
	
	public static long finalRobotCost;
	public static long finalScavengerCost;
	public static long finalStealthBotCost;
	public static long finalAirBotCost;
	public static long finalArachnotronCost;
	public static long finalUnderTakerCost;
	
	public static int robots = 0;
	public static int scavengers = 0;
	public static int stealthbots = 0;
	public static int airbots = 0;
	public static int arachnotrons = 0;
	public static int undertakers = 0;
	
	public static double robotsCPS = 1.0;
	public static double scavengersCPS = 0.2;
	public static double stealthbotCPS = 8.0;
	public static double airbotCPS = 0.0;
	public static double arachnotronCPS = 25.0;
	public static double undertakerCPS = 99.0;
	
	public void increaseRobotCost(){
		robotCost = robotBasecost * Math.pow(1.15, robots);
		scavengerCost = scavengerBaseCost * Math.pow(1.15, scavengers);
		stealthbotCost = stealthbotBaseCost * Math.pow(1.15, stealthbots);
		airbotCost = airbotBaseCost * Math.pow(1.15, airbots);
		arachnotronCost = arachnotronBaseCost * Math.pow(1.15, arachnotrons);
		undertakerCost = undertakerBaseCost * Math.pow(1.15, undertakers);
	}
	
	public void calculateFinalCosts(){
		finalRobotCost = Math.round(robotCost);
		finalScavengerCost = Math.round(scavengerCost);
		finalStealthBotCost = Math.round(stealthbotCost);
		finalAirBotCost = Math.round(airbotCost);
		finalArachnotronCost = Math.round(arachnotronCost);
		finalUnderTakerCost = Math.round(undertakerCost);
	}
	
	public void calculateRobotCPS(){
		airbotCPS = (robots * 0.5)
				+ (scavengers * 0.2)
				+ (stealthbots * 1.0)
				+ (arachnotrons * 4.0);
	}

}
