/**
 * 
 */
package com.zazzercode.doctorhere.models.util;

import java.lang.instrument.Instrumentation;

/**
 * @author prayag
 * 
 */
public class ModelInstrumentation extends Object {
	private static Instrumentation instrumentation;

	public static void premain(String args, Instrumentation inst) {
		instrumentation = inst;
	}

	public static long getObjectSize(Object o) {
		return instrumentation.getObjectSize(o);
	}
}
