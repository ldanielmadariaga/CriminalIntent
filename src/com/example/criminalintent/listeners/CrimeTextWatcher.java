package com.example.criminalintent.listeners;

import android.text.Editable;
import android.text.TextWatcher;

import com.example.criminalintent.Crime;
import com.example.criminalintent.interfaces.Callbacks;

class CrimeTextWatcher implements TextWatcher {

	private Crime crime;
	private Callbacks callbacks;
	private static CrimeTextWatcher crimeTextWatcher;

	private CrimeTextWatcher(Crime crime, Callbacks callbacks) {
		this.crime = crime;
		this.callbacks = callbacks;
	}

	public static CrimeTextWatcher getInstance(Crime crime, Callbacks callbacks) {
		crimeTextWatcher = new CrimeTextWatcher(crime, callbacks);
		return crimeTextWatcher;
	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count, int after) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		crime.setTitle(s.toString());
		callbacks.onCrimeUpdated(crime);
		// TODO Missing code?
	}

	@Override
	public void afterTextChanged(Editable s) {
		// TODO Auto-generated method stub

	}

}
