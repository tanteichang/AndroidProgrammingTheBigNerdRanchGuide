package com.tantei.androidguide

import android.os.Bundle
import android.text.*
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment

class CrimeFragment: Fragment() {

    private lateinit var titleFiled: EditText

    private lateinit var crime: Crime
    private lateinit var deleteButton: Button
    private lateinit var solvedCheckBox: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crime = Crime()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_crime, container, false)

        titleFiled = view.findViewById(R.id.crime_title)
        deleteButton = view.findViewById(R.id.crime_date)
        solvedCheckBox = view.findViewById(R.id.crime_solved)

        deleteButton.apply {
            text = crime.date.toString()
            isEnabled = false
        }

        return view
    }

    override fun onStart() {
        super.onStart()

        val titleWatcher = object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                crime.title = p0.toString()
            }

            override fun afterTextChanged(p0: Editable?) {
                TODO("Not yet implemented")
            }
        }
        titleFiled.addTextChangedListener(titleWatcher)

        solvedCheckBox.apply {
            setOnCheckedChangeListener {_, isChecked ->
                crime.isSolved = isChecked
            }
        }
    }
}