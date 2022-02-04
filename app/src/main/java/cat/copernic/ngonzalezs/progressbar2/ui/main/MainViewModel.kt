package cat.copernic.ngonzalezs.progressbar2.ui.main

import android.util.Log
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.coroutines.*

class MainViewModel : ViewModel() {

    private var _prog1 = MutableLiveData<Int>()
    val prog1: LiveData<Int> get() = _prog1

    private var _contr1 = MutableLiveData<Boolean>()
    val contr1: LiveData<Boolean> get() = _contr1

    private var _pmax1 = MutableLiveData<Int>()
    val pmax1: LiveData<Int> get() = _pmax1

    private var _corr1 = MutableLiveData<Boolean>()
    val corr1: LiveData<Boolean> get() = _corr1

    private var _prog2 = MutableLiveData<Int>()
    val prog2: LiveData<Int> get() = _prog2

    private var _contr2 = MutableLiveData<Boolean>()
    val contr2: LiveData<Boolean> get() = _contr2

    private var _pmax2 = MutableLiveData<Int>()
    val pmax2: LiveData<Int> get() = _pmax2

    private var _corr2 = MutableLiveData<Boolean>()
    val corr2: LiveData<Boolean> get() = _corr2

    var job: Job? = null
    var job2: Job? = null

    fun startbar1(){

        if (_corr1.value == true){
            _pmax1.value = 100
            _prog1.value = 0

            _contr1.value = false
            _corr1.value = false

            job = viewModelScope.launch{
                for(i in prog1.value!!..pmax1.value!!){
                    delay((10000 / pmax1.value!!).toLong())
                    _prog1.value = i
                }
            }
        }
        else{
            _contr1.value = false

            job = viewModelScope.launch{
                for(i in prog1.value!!..pmax1.value!!){
                    delay((10000 / pmax1.value!!).toLong())
                    _prog1.value = i
                }
            }
        }
    }

    fun cancelbar1(){
        if(job!!.isActive || job!!.isCompleted){
            job!!.cancel(CancellationException("Resetting job"))
            _prog1.value = 0
            _contr1.value = true
            _corr1.value = true
        }
    }

    fun pausebar1(){
        if(job!!.isActive || job!!.isCompleted){
            job!!.cancel(CancellationException("Pausing job"))
            _contr1.value = true
        }
    }

    fun startbar2(){

        if (_corr2.value == true){
            _pmax2.value = 100
            _prog2.value = 0

            _contr2.value = false
            _corr2.value = false

            job2 = viewModelScope.launch{
                for(i in prog2.value!!..pmax2.value!!){
                    delay((10000 / pmax2.value!!).toLong())
                    _prog2.value = i
                }
            }
        }
        else{
            _contr2.value = false

            job2 = viewModelScope.launch{
                for(i in prog2.value!!..pmax2.value!!){
                    delay((10000 / pmax2.value!!).toLong())
                    _prog2.value = i
                }
            }
        }
    }

    fun cancelbar2(){
        if(job2!!.isActive || job2!!.isCompleted){
            job2!!.cancel(CancellationException("Resetting job"))
            _prog2.value = 0
            _contr2.value = true
            _corr2.value = true
        }
    }

    fun pausebar2(){
        if(job2!!.isActive || job2!!.isCompleted){
            job2!!.cancel(CancellationException("Pausing job"))
            _contr2.value = true
        }
    }

    fun init(){
        if (_contr1.value == null){
            _contr1.value = true
            _corr1.value = true
            _contr2.value = true
            _corr2.value = true
        }
    }
}