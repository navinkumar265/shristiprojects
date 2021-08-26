package com.voterapp.main;

import java.util.Scanner;

import com.voterapp.exception.NotEligibleException;
import com.voterapp.service.ElectionBooth;

public class Voter {

	public static void main(String[] args) {

		ElectionBooth booth = new ElectionBooth();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter voter ID");
		int vid = sc.nextInt();
		System.out.println("enter age");
		int age = sc.nextInt();
		System.out.println("enter locality");
		String locality = sc.next();
		boolean check = false;
		try {
			check = booth.CheckEligibility(age, locality, vid);
		} catch (NotEligibleException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (check)
				System.out.println("CASTED YOUR VOTE");
			else
				System.out.println("NOT ELIGIBLE TO VOTE");
		}
	}

}
