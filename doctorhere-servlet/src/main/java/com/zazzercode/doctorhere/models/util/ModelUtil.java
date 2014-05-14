/**
 * 
 */
package com.zazzercode.doctorhere.models.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


/**
 * @author prayag
 *
 */
public class ModelUtil {
	
	public static void main(String[] argus) throws IOException, InterruptedException{
//		testBoolean("trUe"); //gives true
//		testArray();
//		testInheritance();
//		testHashSet();
//		testOutputReaders();
//		testRunnable();
		testSerializable();
	}

	private static void testSerializable() {
		Vehicle vehicle = new Vehicle();
        try {
            FileOutputStream fos = new FileOutputStream("vehicle.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(vehicle);
            System.out.println("written to dat file.");
            oos.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
	}

	private static void testRunnable() throws InterruptedException {
		Thread thread = new Thread(new Cruiser());
		thread.start();
		System.out.println("Start");//is printed first
		thread.join();
		System.out.println("End");
	}

	private static void testOutputReaders() throws IOException {
		BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
		FileWriter fileWriter = new FileWriter("/home/prayag/input.text");
		
	}

	private static void testInheritance() {
		Vehicle vehicle = new Car();
		//Bike bike = (Bike) vehicle;//ClassCastException, Car cannot be cast Bike
		
		vehicle.printSound();
		//bike.printSound();
	}

	private static void testHashMap() {
		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
		Set<String> keySet = hashMap.keySet();
		Collection<Integer> values = hashMap.values(); 
	}
	
	private static void testHashSet() {
		HashSet<Object> hashSet = new HashSet<Object>();
		hashSet.add(new String("1"));
		hashSet.add(new String("2"));
		hashSet.add("1");
		System.out.print(hashSet.size());
	}

	public static void testBoolean(String str){
		System.out.print(Boolean.valueOf(str) ? "true" : "false"); 
	}
	
	private static void child() throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Enter first word : ");
		String first = bufferedReader.readLine();
		System.out.print("Enter second word : ");
		String second = bufferedReader.readLine();
		
		Set<Character> set = new HashSet<Character>();
		for(int i =0;i<first.length();i++){
			for(int j =0;j<second.length();j++){
				if(first.charAt(i)==second.charAt(j)){
					set.add(first.charAt(i));
					break;
				}
			}
		}
		System.out.print("Size : "+set.size());
	}
	
	public static void testArray(){
		 try {
	            String arr[] = new String[10];
	            arr = null;
	            arr[0] = "one";
	            System.out.print(arr[0]);
	        } catch(NullPointerException nex) { 
	            System.out.print("null pointer exception"); 
	        } catch(Exception ex) {
	            System.out.print("exception");
	        }
	}
}
