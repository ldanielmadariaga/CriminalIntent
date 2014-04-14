package com.example.criminalintent.activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.criminalintent.Crime;
import com.example.criminalintent.R;
import com.example.criminalintent.fragments.CrimeFragment;
import com.example.criminalintent.fragments.CrimeListFragment;
import com.example.criminalintent.interfaces.Callbacks;

public class CrimeListActivity extends SingleFragmentActtivity implements Callbacks {

	@Override
	protected Fragment createFragment() {
		return new CrimeListFragment();
	}

	@Override
	protected int getLayoutResourceId() {
		return R.layout.activity_masterdetail;
	}

	@Override
	public void onCrimeSelected(Crime crime) {
		if (findViewById(R.id.detail_fragmentContainer) == null) {
			Intent intent = new Intent(this, CrimePagerActivity.class);
			intent.putExtra(CrimeFragment.EXTRA_CRIME_ID, crime.getId());
			startActivity(intent);
		} else {

			FragmentManager fragmentManager = getSupportFragmentManager();
			FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
			Fragment oldDetail = fragmentManager.findFragmentById(R.id.detail_fragmentContainer);
			Fragment newDetail = CrimeFragment.newInstance(crime.getId());
			if (oldDetail != null) {
				fragmentTransaction.remove(oldDetail);
			}

			fragmentTransaction.add(R.id.detail_fragmentContainer, newDetail);
			fragmentTransaction.commit();
		}
	}

	@Override
	public void onCrimeUpdated(Crime crime) {
		FragmentManager fragmentManager = getSupportFragmentManager();
		CrimeListFragment crimeListFragment = (CrimeListFragment) fragmentManager
				.findFragmentById(R.id.fragment_container);
		crimeListFragment.updateUI();
	}
}
