package com.example.madlevel3task2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_add_portal.*

const val PORTAL_OBJECT = "portal_object"

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AddPortalFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_portal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_add_portal.setOnClickListener {
            onAddPortal()
        }

    }

    private fun onAddPortal(){
        val portalTitle = etTitle.text.toString()
        val portalUrl = etUrl.text.toString()

        if (portalTitle.isNotBlank() && portalUrl.isNotBlank()){

            val args = Bundle()
            val portal = Portal(portalTitle,portalUrl)

            args.putParcelable(PORTAL_OBJECT,portal)

            setFragmentResult(PORTAL_OBJECT, args)
            findNavController().popBackStack()

        } else {
            Toast.makeText(activity,"ENTER TEXT",Toast.LENGTH_SHORT).show()
        }

    }
}