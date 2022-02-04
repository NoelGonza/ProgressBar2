package cat.copernic.ngonzalezs.progressbar2.ui.main

import android.content.ContentValues.TAG
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import cat.copernic.ngonzalezs.progressbar2.R
import cat.copernic.ngonzalezs.progressbar2.databinding.MainFragmentBinding
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.coroutines.*

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    private lateinit var binding: MainFragmentBinding

    private lateinit var job: CompletableJob

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.main_fragment,
            container,
            false
        )

        binding.mainViewModel = viewModel

        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.init()

        start_button.setOnClickListener {
            viewModel.startbar1()
        }

        cancel_button.setOnClickListener {
            viewModel.cancelbar1()
        }

        pause_button.setOnClickListener {
            viewModel.pausebar1()
        }

        start_button2.setOnClickListener {
            viewModel.startbar2()
        }

        cancel_button2.setOnClickListener {
            viewModel.cancelbar2()
        }

        pause_button2.setOnClickListener {
            viewModel.pausebar2()
        }
    }
}