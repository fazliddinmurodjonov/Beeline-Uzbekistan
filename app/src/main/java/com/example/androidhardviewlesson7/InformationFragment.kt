package com.example.androidhardviewlesson7

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.androidhardviewlesson7.databinding.FragmentInformationBinding
import com.example.androidhardviewlesson7.models.Internet
import com.example.androidhardviewlesson7.models.Minutes
import com.example.androidhardviewlesson7.models.SMS
import com.example.androidhardviewlesson7.models.Tariff

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [InformationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InformationFragment : Fragment() {
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
        val root = inflater.inflate(R.layout.fragment_information, container, false)

        setHasOptionsMenu(true)

        val key = arguments?.getString("key")

        var bind = FragmentInformationBinding.bind(root)
        bind.back.setOnClickListener {
            when(key)
            {
                "tariff"-> {
                    findNavController().popBackStack()
                }
                "minutes"-> {
                    findNavController().popBackStack()
                }
                "internet"-> {
                    findNavController().popBackStack()
                }
                "sms"-> {
                    findNavController().popBackStack()
                }
            }
        }
        when (key) {
            "tariff" -> {
                val tariff = arguments?.getSerializable("tariff") as Tariff
                bind.name.text = tariff.tariffName
                bind.about.text = tariff.tariffAbout
                bind.joinWithCode.text = tariff.tariffJoinWithCode
            }
            "minutes" -> {
                val minutes = arguments?.getSerializable("minutes") as Minutes
                bind.name.text = minutes.minutesName
                bind.about.text = minutes.minutesAbout
                bind.joinWithCode.text = minutes.minutesJoinWithCode
            }
            "internet" -> {
                val internet = arguments?.getSerializable("internet") as Internet
                bind.name.text = internet.internetName
                bind.about.text = internet.internetAbout
                bind.joinWithCode.text = internet.internetJoinWithCode
            }
            "sms" -> {
                val sms = arguments?.getSerializable("sms") as SMS
                bind.name.text = sms.smsName
                bind.about.text = sms.smsAbout
                bind.joinWithCode.text = sms.smsJoinWithCode
            }
        }

        return root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.my_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val itemId = item.itemId
        when(itemId)
        {
            R.id.back->
            {
                findNavController().navigate(R.id.minutesFragment)
            }
        }
        return super.onOptionsItemSelected(item)
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment InformationFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            InformationFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}