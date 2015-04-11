package com.mart.rvsh.data;

import java.util.Random;

import com.mart.rvsh.Main;

public class ComputerChips {
	Main main;
	
	RobotStats rs;
	
	public static double computerChips = 30000.0;
	public static double CPS = 0.0;
	public static int finalComputerChips;
	public static double finalCPS;
	
	public void finalComputerChips(){
		computerChips += CPS/10;
		finalComputerChips = (int) Math.round(computerChips);
	}
	
	public void calculateCPS(){
		CPS = (RobotStats.robots * RobotStats.robotsCPS) 
				+ (RobotStats.scavengers * RobotStats.scavengersCPS)
				+ (RobotStats.stealthbots * RobotStats.stealthbotCPS)
				+ (RobotStats.airbots * RobotStats.airbotCPS)
				+ (RobotStats.arachnotrons * RobotStats.arachnotronCPS)
				+ (RobotStats.undertakers * RobotStats.undertakerCPS);
		finalCPS = (double)Math.round((CPS *100)) /100;
	}
	
	public void increaseComputerChipsOnClick(){
		computerChips++;
	}
	
	public void randomChances(){
		Random ran = new Random();
		int random =  (int) Math.round(Humanity.killspersecond * 10);
		if(random >= 1){
			for(int i = 0; i < random + 1; i++){
				if(ran.nextInt(600) == 0)computerChips++;
			}
		}
	}
	
}
