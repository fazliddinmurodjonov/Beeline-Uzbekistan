package com.example.androidhardviewlesson7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.androidhardviewlesson7.adapters.NewsAdapter
import com.example.androidhardviewlesson7.adapters.ServicesAdapter
import com.example.androidhardviewlesson7.databinding.FragmentServisesBinding
import com.example.androidhardviewlesson7.models.Services

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [servisesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class servisesFragment : Fragment() {
    lateinit var servicesList:ArrayList<Services>
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
        loadServices()
        // Inflate the layout for this fragment
        val root =inflater.inflate(R.layout.fragment_servises, container, false)
        val bind = FragmentServisesBinding.bind(root)
        var servicesAdapter=ServicesAdapter(servicesList)
        bind.servicesRV.adapter=servicesAdapter
        servicesAdapter.setOnMyItemClickListener(object:ServicesAdapter.OnMyItemClickListener{
            override fun onClick(services: Services) {
                val bundle = bundleOf("services" to services,"key" to "services")
                val navOption = NavOptions.Builder()
                navOption.setEnterAnim(R.anim.exit_anim)
                navOption.setExitAnim(R.anim.enter_pop_anim )
                navOption.setPopEnterAnim(R.anim.enter_anim)
                navOption.setPopExitAnim(R.anim.exit_pop_anim)
            findNavController().navigate(R.id.newsInformationFragment,bundle,navOption.build())
                }

        })
        return root
    }

    private fun loadServices() {
        servicesList=ArrayList()
        servicesList.add(Services("Beeline TV","Internetingizni sarflamay sevimli filmlar va seriallarni tomosha qiling!","599","10 9999",R.drawable.services_beeline_tv_official))
        servicesList.add(Services("Beeline Music & Radio","Internet trafikni sarflamagan holda sevimli musiqangizni tinglashdan bahramand bo'ling!","599","10 9999",R.drawable.services_music_and_radio))
        servicesList.add(Services("Beeline VISA","Beeline VISA - bu internet xaridlar uchun mo'ljallangan karta.","599","10 9999",R.drawable.services_visa))
        servicesList.add(Services("Fantasy Football","899 so'm/kun yoki 17999 so'm/oy evaziga haqiqiy futbolchilardan tashkil topgan «FANTASTIK JAMOANGIZNI» YARATING.","599","10 9999",R.drawable.services_football))
        servicesList.add(Services("Beeline App","Reklamasiz va trafikni sarflamagan holda eng zo'r o'yinlar va mobil ilovalarni yuklab oling!","599","10 9999",R.drawable.services_app))
        servicesList.add(Services("Beeline Pressa","Internet trafikni sarflamagan holda sevimli jurnallar va gazetalaringizni onlayn rejimida o'qing!","599","10 9999",R.drawable.services_pressa))
        servicesList.add(Services("BeeGudok","«BeeGudok» xizmati oddiy zerikarli gudoklarni siz xush ko'rgan musiqa va hazillarga almashtirish imkonini beradi.","599","10 9999",R.drawable.services_beegudok))
        servicesList.add(Services("Bookmate","Internet trafikni sarflamagan holda sevimli kitoblaringizni o'qing va tinglang!","599","10 9999",R.drawable.services_bookmate))
        servicesList.add(Services("Bookmate","Internet trafikni sarflamagan holda sevimli kitoblaringizni o'qing va tinglang!","599","10 9999",R.drawable.services_yandex_music))
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment servisesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            servisesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}