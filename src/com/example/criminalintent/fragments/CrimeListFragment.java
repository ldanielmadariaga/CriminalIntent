package com.example.criminalintent.fragments;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.criminalintent.Crime;
import com.example.criminalintent.CrimeLab;
import com.example.criminalintent.R;
import com.example.criminalintent.activities.CrimePagerActivity;
import com.example.criminalintent.adapters.AdapterFactory;

public class CrimeListFragment extends ListFragment {

	private ArrayList<Crime> crimes;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActivity().setTitle(R.string.crimes_title);
		CrimeLab crimeLab = CrimeLab.getInstance(getActivity());
		crimes = crimeLab.getCrimes();

		ArrayAdapter<Crime> arrayAdapter = AdapterFactory.getCrimeListAdapter(getActivity(), crimes);
		setListAdapter(arrayAdapter);
	}

	@Override
	public void onResume() {
		super.onResume();
		@SuppressWarnings("unchecked")
		ArrayAdapter<Crime> arrayAdapter = (ArrayAdapter<Crime>) getListAdapter();
		arrayAdapter.notifyDataSetChanged();
	}

	@Override
	public void onListItemClick(ListView listView, View view, int position, long id) {
		@SuppressWarnings("unchecked")
		Crime crime = ((ArrayAdapter<Crime>) getListAdapter()).getItem(position);
		Intent intent = new Intent(getActivity(), CrimePagerActivity.class);
		intent.putExtra(CrimeFragment.EXTRA_CRIME_ID, crime.getId());
		startActivity(intent);
	}
}