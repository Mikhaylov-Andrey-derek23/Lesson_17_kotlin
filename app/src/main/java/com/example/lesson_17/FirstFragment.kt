package com.example.lesson_17

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lesson_17.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {
    private var binding: FragmentFirstBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        setOnClickListeners()
    }

    private fun navigateToSite(url: String, fragment: Fragment) {
        val bundle = Bundle()
        bundle.putString("URL", url)
        fragment.arguments = bundle
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

    private fun setOnClickListeners() {


        binding?.btnNavigateToYandex?.setOnClickListener {
            val url = "https://ya.ru/"
            navigateToSite(url, WebViewFragment())
        }

        binding?.btnNavigateGoogle?.setOnClickListener {
            val url = "https://www.google.ru/"
            navigateToSite(url, WebViewFragment())
        }

    }
}