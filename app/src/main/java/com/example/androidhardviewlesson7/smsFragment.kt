package com.example.androidhardviewlesson7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.androidhardviewlesson7.adapters.SMSAdapter
import com.example.androidhardviewlesson7.databinding.FragmentSmsBinding
import com.example.androidhardviewlesson7.models.SMS

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [smsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class smsFragment : Fragment() {
    lateinit var smsList: ArrayList<SMS>

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
        val root = inflater.inflate(R.layout.fragment_sms, container, false)
        loadSMS()
        var smsAdapter = SMSAdapter(smsList)
        val bind = FragmentSmsBinding.bind(root)
        bind.smsRV.adapter = smsAdapter
        smsAdapter.setOnMyItemClickListener(object:SMSAdapter.OnMyItemClickListener{
            override fun onClick(sms: SMS) {
                val bundle = bundleOf("sms" to sms, "key" to "sms")
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

    private fun loadSMS() {
        smsList = ArrayList()
        smsList.add(SMS("20 SMS paketi","500 so'm/kun","20/kun",R.drawable.sms_20,resources.getString(R.string.SMSAbout),"*110*161#"))
        smsList.add(SMS("50 SMS paketi","1 000 so'm/kun","20/kun",R.drawable.sms_20,resources.getString(R.string.SMSAbout),"*110*162#"))
        smsList.add(SMS("100 SMS paketi","5 262.5 so'm/oy","100/oy",R.drawable.sms_1_5_10,resources.getString(R.string.SMSAbout),"*110*044#"))
        smsList.add(SMS("500 SMS paketi","13 682.5 so'm/oy","500/oy",R.drawable.sms_1_5_10,resources.getString(R.string.SMSAbout),"*110*045#"))
        smsList.add(SMS("1 000 SMS paketi","22 102.5 so'm/oy","1000/oy",R.drawable.sms_1_5_10,resources.getString(R.string.SMSAbout),"*110*046#"))
        smsList.add(SMS("SMS non-stop","1 300 so'm/kun","250/kun",R.drawable.sms_20,resources.getString(R.string.SMSAbout),"*110*151#"))
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment smsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            smsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}