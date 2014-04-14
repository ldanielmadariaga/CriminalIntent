package com.example.criminalintent.interfaces;

import com.example.criminalintent.Crime;

public interface Callbacks {

	void onCrimeSelected(Crime crime);

	void onCrimeUpdated(Crime crime);
}
