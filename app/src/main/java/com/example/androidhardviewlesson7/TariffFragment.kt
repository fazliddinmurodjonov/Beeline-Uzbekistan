package com.example.androidhardviewlesson7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.androidhardviewlesson7.adapters.TariffAdapter
import com.example.androidhardviewlesson7.databinding.FragmentTariffBinding
import com.example.androidhardviewlesson7.models.Tariff

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TariffFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TariffFragment : Fragment() {
    lateinit var tariffList: ArrayList<Tariff>

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

        loadTariff()
        var tariffAdapter = TariffAdapter(tariffList)
        val root = inflater.inflate(R.layout.fragment_tariff, container, false)
        val bind = FragmentTariffBinding.bind(root)
        bind.tariffRV.adapter = tariffAdapter
        tariffAdapter.setOnMyItemClickListener(object : TariffAdapter.OnMyItemClickListener {
            override fun onClick(tariff: Tariff, position: Int) {
                var bundle = bundleOf("tariff" to tariff, "key" to "tariff")
                val navOption = NavOptions.Builder()
                navOption.setEnterAnim(R.anim.exit_anim)
                navOption.setExitAnim(R.anim.enter_pop_anim )
                navOption.setPopEnterAnim(R.anim.enter_anim)
                navOption.setPopExitAnim(R.anim.exit_pop_anim)
                findNavController().navigate(R.id.informationFragment, bundle,navOption.build())
            }
        })
        return root
    }

    private fun loadTariff() {
        tariffList = ArrayList()
        tariffList.add(
            Tariff(
                "ZO‘R 3",
                R.drawable.tariff_zor_3,
                "20 000",
                "1 500",
                "3",
                "1 500",
                resources.getString(R.string.TariffAbout),
                "*2*3#"
            )
        )
        tariffList.add(
            Tariff(
                "ZO‘R 5",
                R.drawable.tariff_zor_5,
                "27 000",
                "2 500",
                "5",
                "2 500",
                resources.getString(R.string.TariffAbout),
                "*2*5#"
            )
        )
        tariffList.add(
            Tariff(
                "ZO‘R 7",
                R.drawable.tariff_zor_7,
                "35 000",
                "\u221e",
                "7",
                "5 000",
                resources.getString(R.string.TariffAbout),
                "*2*7#"
            )
        )
        tariffList.add(
            Tariff(
                "ZO‘R 12",
                R.drawable.tariff_zor_12,
                "50 000",
                "\u221e",
                "12",
                "5 000",
                resources.getString(R.string.TariffAbout),
                "*2*12#"
            )
        )
        tariffList.add(
            Tariff(
                "ZO‘R 20",
                R.drawable.tariff_zor_20,
                "70 000",
                "\u221e",
                "20",
                "5 000",
                resources.getString(R.string.TariffAbout),
                "*2*20#"
            )
        )
        tariffList.add(
            Tariff(
                "Status Silver",
                R.drawable.tariff_status_silver,
                "90 000",
                "\u221e",
                "30",
                "5 000",
                resources.getString(R.string.TariffAbout),
                "*2*30#"
            )
        )
        tariffList.add(
            Tariff(
                "Status Gold",
                R.drawable.tariff_status_gold,
                "130 000",
                "\u221e",
                "50",
                "10 000",
                resources.getString(R.string.TariffAbout),
                "*2*50#"
            )
        )
        tariffList.add(
            Tariff(
                "Status Platinum",
                R.drawable.tariff_status_platinum,
                "200 000",
                "\u221e",
                "150",
                "10 000",
                resources.getString(R.string.TariffAbout),
                "*2*150#"
            )
        )
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TariffFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TariffFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}