package com.example.androidhardviewlesson7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.androidhardviewlesson7.adapters.InternetAdapter
import com.example.androidhardviewlesson7.databinding.FragmentInternetBinding
import com.example.androidhardviewlesson7.models.Internet

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [InternetFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InternetFragment : Fragment() {
    lateinit var internetList: ArrayList<Internet>

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
        loadInternet()
        val root = inflater.inflate(R.layout.fragment_internet, container, false)
        var internetAdapter = InternetAdapter(internetList)
        var bind = FragmentInternetBinding.bind(root)
        bind.internetRV.adapter = internetAdapter
        internetAdapter.setOnMyItemClickListener(object :InternetAdapter.OnMyItemClickListener{
            override fun onClick(internet: Internet) {
                var bundle = bundleOf("internet" to internet,"key" to "internet")
                val navOption = NavOptions.Builder()
                navOption.setEnterAnim(R.anim.exit_anim)
                navOption.setExitAnim(R.anim.enter_pop_anim )
                navOption.setPopEnterAnim(R.anim.enter_anim)
                navOption.setPopExitAnim(R.anim.exit_pop_anim)
                findNavController().navigate(R.id.informationFragment,bundle,navOption.build())
            }

        })
        return root
    }

    private fun loadInternet() {
        internetList= ArrayList()
        internetList.add(Internet("INTERNET-PAKET 1 GB",1,"10 000",R.drawable.internet_1,resources.getString(R.string.InternetAbout),"*1*01#"))
        internetList.add(Internet("INTERNET-PAKET 5 GB",5,"25 000",R.drawable.internet_5,resources.getString(R.string.InternetAbout),"*1*05#"))
        internetList.add(Internet("INTERNET-PAKET 10 GB",10,"40 000",R.drawable.internet_10,resources.getString(R.string.InternetAbout),"*1*10#"))
        internetList.add(Internet("INTERNET-PAKET 20 GB",20,"65 000",R.drawable.internet_20,resources.getString(R.string.InternetAbout),"*1*20#"))
        internetList.add(Internet("INTERNET-PAKET 30 GB",30,"75 000",R.drawable.internet_30,resources.getString(R.string.InternetAbout),"*1*30#"))
        internetList.add(Internet("INTERNET-PAKET 50 GB",50,"90 000",R.drawable.internet_50,resources.getString(R.string.InternetAbout),"*1*50#"))
        internetList.add(Internet("INTERNET-PAKET 75 GB",75,"110 000",R.drawable.internet_75,resources.getString(R.string.InternetAbout),"*1*75#"))
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment InternetFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            InternetFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}