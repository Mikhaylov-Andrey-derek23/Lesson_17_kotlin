package com.example.lesson_17

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.lesson_17.databinding.FragmentWebViewBinding


class WebViewFragment : Fragment() {
    private  var binding: FragmentWebViewBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWebViewBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpWevView()
        setOnClickListeners()
    }

    private fun setUpWevView() {
        binding?.wbSite?.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                return false
            }
        }
        binding?.wbSite?.loadUrl(requireArguments().getString("URL", ""))
        binding?.wbSite?.settings?.javaScriptEnabled = true

    }

    private  fun setOnClickListeners(){

        binding?.btnNavigateToFirstFragment?.setOnClickListener {
            var fragment = FirstFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit()
        }


    }
}