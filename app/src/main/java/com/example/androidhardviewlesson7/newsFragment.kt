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
import com.example.androidhardviewlesson7.databinding.FragmentNewsBinding
import com.example.androidhardviewlesson7.models.News

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [newsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class newsFragment : Fragment() {
    lateinit var newsList: ArrayList<News>

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
        val root = inflater.inflate(R.layout.fragment_news, container, false)
        val bind = FragmentNewsBinding.bind(root)
        loadNews()
        var newsAdapter = NewsAdapter(newsList)
        bind.newsRV.adapter=newsAdapter
    newsAdapter.setOnMyItemClickListener(object:NewsAdapter.OnMyItemClickListener
    {
        override fun onClick(news: News) {
            val bundle = bundleOf("news" to news,"key" to "news")
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

    private fun loadNews() {
        newsList = ArrayList()
        newsList.add(News("Yangilangan Welcome tarifini kutib oling!",R.drawable.news_1,resources.getString(R.string.newsOne),"05.09.2021"))
        newsList.add(News("Endi «Beeline Uzbekistan» dan 4G - rouming dunyoning 83 mamlakatida mavjud!",R.drawable.news_2,resources.getString(R.string.newsTwo),"05.09.2021"))
        newsList.add(News("707 yoki 077?",R.drawable.news_3,resources.getString(R.string.newsThree),"05.09.2021"))
        newsList.add(News("«4G OY» Internet-paketidan foydalanuvchi abonentlarimiz diqqatiga!",R.drawable.news_4,resources.getString(R.string.newsFour),"05.09.2021"))
        newsList.add(News("«Beeline Uzbekistan» «Ookla» tomonidan O'zbekistondagi mobil internet tezligi bo'yicha yetakchi deb tan olindi",R.drawable.news_5,resources.getString(R.string.newsFive),"05.09.2021"))
        newsList.add(News("Hurmatli abonentlar!",R.drawable.news_6,resources.getString(R.string.newsSix),"05.09.2021"))
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment newsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            newsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}