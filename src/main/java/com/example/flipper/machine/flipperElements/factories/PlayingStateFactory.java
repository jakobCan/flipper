package com.example.flipper.machine.flipperElements.factories;

public class PlayingStateFactory implements AbstractStateFactory {
	
	@Override
	public String showState() {
		return "\n" +
				"\n" +
				"   _____          __  __ ______    _____ _______       _____ _______ _____ _ \n" +
				"  / ____|   /\\   |  \\/  |  ____|  / ____|__   __|/\\   |  __ \\__   __/ ____| |\n" +
				" | |  __   /  \\  | \\  / | |__    | (___    | |  /  \\  | |__) | | | | (___ | |\n" +
				" | | |_ | / /\\ \\ | |\\/| |  __|    \\___ \\   | | / /\\ \\ |  _  /  | |  \\___ \\| |\n" +
				" | |__| |/ ____ \\| |  | | |____   ____) |  | |/ ____ \\| | \\ \\  | |  ____) |_|\n" +
				"  \\_____/_/    \\_\\_|  |_|______| |_____/   |_/_/    \\_\\_|  \\_\\ |_| |_____/(_)\n" +
				"                                                                             \n" +
				"                                                                             \n" +
				"\n";
	}
}
