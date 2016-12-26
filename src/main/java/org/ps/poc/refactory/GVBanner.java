package org.ps.poc.refactory;

import java.io.PrintStream;

import org.springframework.boot.Banner;
import org.springframework.core.env.Environment;

public class GVBanner implements Banner {

	@Override
	public void printBanner(Environment env, Class<?> clazz, PrintStream out) {
		out.append(" _____       _      _           _   _ _      _               _ \n");
		out.append("|  __ \\     (_)    | |         | | | (_)    | |             | |\n");
		out.append("| |  \\/_   _ _  ___| |__   ___ | | | |_ _ __| |_ _   _  __ _| |\n");
		out.append("| | __| | | | |/ __| '_ \\ / _ \\| | | | | '__| __| | | |/ _\\`| |\n");
		out.append("| |_\\ \\ |_| | | (__| | | |  __/\\ \\_/ / | |  | |_| |_| | (_| | |\n");
		out.append(" \\____/\\__,_|_|\\___|_| |_|\\___| \\___/|_|_|   \\__|\\__,_|\\__,_|_|\n\n");
	}

}
