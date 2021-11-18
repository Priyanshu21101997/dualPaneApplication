package com.example.dualpaneapplication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.dualpaneapplication.FirstFragment.OnOptionClickListener








class FirstFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    interface OnOptionClickListener {
        fun onOptionSelected(option: String?)
    }

    private var mCallback: OnOptionClickListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mCallback = context as OnOptionClickListener
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_first, container, false)
        val mDisplayOption:LinearLayout = rootView.findViewById(R.id.displayOption)

        mDisplayOption.setOnClickListener { mCallback!!.onOptionSelected("display") }

        return rootView
    }
}