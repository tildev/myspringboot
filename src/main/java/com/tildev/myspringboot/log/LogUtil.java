package com.tildev.myspringboot.log;

import java.io.PrintWriter;
import java.io.StringWriter;

public class LogUtil {
	public String getErrorLog(Exception e) {
		StringWriter error = new StringWriter();
		e.printStackTrace(new PrintWriter(error));
		return error.toString();
	}
}
