package com.idapgroup.argumentdelegateexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.text.parseAsHtml
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.idapgroup.argumentdelegate.argumentDelegate
import kotlinx.android.synthetic.main.fragment_data_receiver.*

class DataReceiverFragment : Fragment() {

    companion object {
        fun bundle(data: String) = bundleOf("data" to data)
    }

    private val data: String? by argumentDelegate()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_data_receiver, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        argumentDelegate<Int>()

        messageView.text =
                if(data.isNullOrEmpty()) {
                    getString(R.string.receiver_no_data_message)
                } else {
                    getString(R.string.receiver_data_message, data).parseAsHtml()
                }
        backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }

}