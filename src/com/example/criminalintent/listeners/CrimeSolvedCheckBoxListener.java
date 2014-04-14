package com.example.criminalintent.listeners;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

import com.example.criminalintent.Crime;
import com.example.criminalintent.interfaces.Callbacks;

class CrimeSolvedCheckBoxListener implements OnCheckedChangeListener {

	private static CrimeSolvedCheckBoxListener crimeSolvedCheckBoxListener;
	private Crime crime;
	private Callbacks callbacks;

	private CrimeSolvedCheckBoxListener(Crime crime, Callbacks callbacks) {
		this.crime = crime;
		this.callbacks = callbacks;
	}

	public static CrimeSolvedCheckBoxListener getInstance(Crime crime, Callbacks callbacks) {
		crimeSolvedCheckBoxListener = new CrimeSolvedCheckBoxListener(crime, callbacks);
		return crimeSolvedCheckBoxListener;
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		crime.setSolved(isChecked);
		callbacks.onCrimeUpdated(crime);
	}

}
