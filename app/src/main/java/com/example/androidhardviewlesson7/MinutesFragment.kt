package com.example.androidhardviewlesson7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.androidhardviewlesson7.adapters.MinutesAdapter
import com.example.androidhardviewlesson7.adapters.TariffAdapter
import com.example.androidhardviewlesson7.databinding.FragmentMinutesBinding
import com.example.androidhardviewlesson7.models.Minutes

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MinutesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MinutesFragment : Fragment() {
    lateinit var minutesList: ArrayList<Minutes>

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_minutes, container, false)
        loadMinutes()
        var minutesAdapter = MinutesAdapter(minutesList)
        var bind = FragmentMinutesBinding.bind(root)
        minutesAdapter.setOnMyItemClickListener(object :MinutesAdapter.OnMyItemClickListener
        {
            override fun onClick(minutes: Minutes) {
                var bundle = bundleOf("minutes" to minutes,"key" to "minutes")
                val navOption = NavOptions.Builder()
                navOption.setEnterAnim(R.anim.exit_anim)
                navOption.setExitAnim(R.anim.enter_pop_anim )
                navOption.setPopEnterAnim(R.anim.enter_anim)
                navOption.setPopExitAnim(R.anim.exit_pop_anim)
                findNavController().navigate(R.id.informationFragment,bundle,navOption.build())
            }

        })
        bind.minutesRV.adapter = minutesAdapter
        return root
    }

    private fun loadMinutes() {
        minutesList = ArrayList()
        minutesList.add(Minutes("Extra 200 paketi",200,200,"10 000",R.drawable.minutes_extra_200,resources.getString(R.string.MinutesAbout),"*110*500#"))
        minutesList.add(Minutes("Extra 400 paketi",400,400,"18 000",R.drawable.minutes_extra_400,resources.getString(R.string.MinutesAbout),"*110*500#"))
        minutesList.add(Minutes("Extra 600 paketi",600,600,"25 000",R.drawable.minutes_extra_600,resources.getString(R.string.MinutesAbout),"*110*500#"))
        minutesList.add(Minutes("#Ko`pso'zla",0,600,"10 000",R.drawable.minutes_kop_sozla,resources.getString(R.string.MinutesAbout),"*110*500#"))
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MinutesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MinutesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}