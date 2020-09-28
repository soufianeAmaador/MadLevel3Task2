package com.example.madlevel3task2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_start.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class StartFragment : Fragment() {

    private val portals = arrayListOf<Portal>()
    private val portalAdapter = PortalAdapter(portals)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.e("portalcount","amount of portals: " + portals.size)
        observeAddPortalResult()
        initViews()


    }

    private fun initViews(){
        rvPortals.layoutManager = GridLayoutManager(context,2)
        rvPortals.adapter = portalAdapter
    }

    private fun observeAddPortalResult(){
        setFragmentResultListener(PORTAL_OBJECT) { key, bundle ->
            bundle.getParcelable<Portal>(PORTAL_OBJECT)?.let {
                val reminder = Portal(it.title,it.url)

                portals.add(reminder)
                portalAdapter.notifyDataSetChanged()
            } ?: Log.e("PortalFragment", "Request triggered, but empty portal object!")

        }
    }

}