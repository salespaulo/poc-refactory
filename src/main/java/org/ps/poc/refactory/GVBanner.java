package org.ps.poc.refactory;

import java.io.PrintStream;

import org.springframework.boot.Banner;
import org.springframework.core.env.Environment;

public class GVBanner implements Banner {

	@Override
	public void printBanner(Environment env, Class<?> clazz, PrintStream out) {
		out.append("                  _            _     _        _ _    \n");
		out.append("  __ ___   __    | |_ ___  ___| |__ | |_ __ _| | | __\n");
		out.append(" / _` \\ \\ / /____| __/ _ \\/ __| '_ \\| __/ _` | | |/ /\n");
		out.append("| (_| |\\ V /_____| ||  __/ (__| | | | || (_| | |   < \n");
		out.append(" \\__, | \\_/       \\__\\___|\\___|_| |_|\\__\\__,_|_|_|\\_\\\n");
		out.append(" |___/                                               \n");
	}

}
