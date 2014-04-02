package com.example.criminalintent;

import java.util.ArrayList;
import java.util.UUID;

import android.content.Context;

public class CrimeLab {

	private static CrimeLab crimeLab;
	private Context appContext;

	private ArrayList<Crime> crimes;

	private CrimeLab(Context appContext) {
		this.appContext = appContext;
		crimes = new ArrayList<Crime>();
		for (int i = 0; i < 100; i++) {
			Crime c = new Crime();
			c.setTitle("Crime #" + i);
			c.setSolved(i % 2 == 0); // Every other one
			crimes.add(c);
		}

	}

	public static CrimeLab getInstance(Context appContext) {
		if (crimeLab == null) {
			crimeLab = new CrimeLab(appContext.getApplicationContext());
		}
		return crimeLab;

	}

	public ArrayList<Crime> getCrimes() {
		return crimes;
	}

	public Crime getCrime(UUID id) {
		Crime searchedCrime = null;
		for (Crime crime : crimes) {
			if (crime.getId().equals(id)) {
				searchedCrime = crime;
			}
		}
		return searchedCrime;
	}
}
