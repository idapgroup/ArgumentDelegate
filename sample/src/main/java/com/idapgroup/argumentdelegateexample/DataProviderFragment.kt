package com.idapgroup.argumentdelegateexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_data_provider.*

class DataProviderFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_data_provider, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        nextButton.setOnClickListener {
            findNavController().navigate(
                R.id.dataProviderFragment_to_dataReceiverFragment,
//                bundleOf("data" to null)
                DataReceiverFragment.bundle(providingDataEditText.text.toString())
            )
        }
    }

}