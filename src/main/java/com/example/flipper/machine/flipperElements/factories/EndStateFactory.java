package com.example.flipper.machine.flipperElements.factories;

public class EndStateFactory implements AbstractStateFactory {
	
	@Override
	public String showState() {
		return "\n" +
				"\n" +
				"   _____          __  __ ______    ______      ________ _____  _ \n" +
				"  / ____|   /\\   |  \\/  |  ____|  / __ \\ \\    / /  ____|  __ \\| |\n" +
				" | |  __   /  \\  | \\  / | |__    | |  | \\ \\  / /| |__  | |__) | |\n" +
				" | | |_ | / /\\ \\ | |\\/| |  __|   | |  | |\\ \\/ / |  __| |  _  /| |\n" +
				" | |__| |/ ____ \\| |  | | |____  | |__| | \\  /  | |____| | \\ \\|_|\n" +
				"  \\_____/_/    \\_\\_|  |_|______|  \\____/   \\/   |______|_|  \\_(_)\n" +
				"                                                                 \n" +
				"                                                                 \n" +
				"\n";
	}
}
