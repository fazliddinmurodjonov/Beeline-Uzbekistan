package com.example.androidhardviewlesson7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.androidhardviewlesson7.databinding.FragmentNewsInformationBinding
import com.example.androidhardviewlesson7.models.News
import com.example.androidhardviewlesson7.models.Services

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NewsInformationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewsInformationFragment : Fragment() {
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
        val root = inflater.inflate(R.layout.fragment_news_information, container, false)
        val bind = FragmentNewsInformationBinding.bind(root)
        val key = arguments?.getString("key")
        bind.backTwo.setOnClickListener {

            when (key) {
                "news" -> {
                    findNavController().popBackStack()
                }
                "services" -> {
                    findNavController().popBackStack()
                }
            }
        }

        when (key) {
            "news" -> {
                val news = arguments?.getSerializable("news") as News
                bind.nameNews.text = news.newsName
                bind.aboutNews.text = news.newsAbout
                bind.imageNews.setImageResource(news.newsImage!!)
            }
            "services" -> {
                val services = arguments?.getSerializable("services") as Services
                bind.nameNews.text = services.serviceName
                bind.aboutNews.text = services.serviceAbout
                bind.imageNews.setImageResource(services.serviceImage!!)
            }
        }
        return root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NewsInformationFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NewsInformationFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}