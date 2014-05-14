/**
 * 
 */
package com.zazzercode.doctorhere.models.util;

import java.io.Serializable;

/**
 * @author prayag
 *
 */
public class Vehicle implements Serializable{
	private transient Wheel wheel = new Wheel();
	public void printSound() {
        System.out.print("vehicle");
    }

}
