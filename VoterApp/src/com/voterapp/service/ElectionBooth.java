package com.voterapp.service;

import com.voterapp.exception.*;

public class ElectionBooth {
	String localities[] = { "abc", "xyz", "rk" };

	boolean checkAge(int age) throws UnderAgeException {
		if (age >= 18)
			return true;
		else {
			throw new UnderAgeException("age is under 18");
		}
	}

	boolean checkLocality(String locality) throws LocalityNotFoundException {
		boolean flag = false;
		for (String locality1 : localities) {
			if (locality.equals(locality1)) {
				flag = true;
			}
		}
		if (flag == false) {
			throw new LocalityNotFoundException("No locality found");
		}
		return true;
	}

	boolean checkVoterID(int vid) throws NoVoterIDException {
		if (1000 <= vid && vid <= 9000) {
			return true;
		} else {
			throw new NoVoterIDException("ID is not in range");
		}
	}

	public boolean CheckEligibility(int age, String locality, int vid) throws NotEligibleException {

		if (checkVoterID(vid)) {
			if (checkAge(age)) {
				if (checkLocality(locality)) {
					System.out.println("You can cast your vote!!");
					return true;
				}
			}
		}
		return false;
	}
}