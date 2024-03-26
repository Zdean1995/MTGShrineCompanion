package com.auchtermuchty.shrine.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShrineViewModel: ViewModel() {
    private val _shrineCount = MutableLiveData<Int>()
    val shrineCount: LiveData<Int> = _shrineCount

    private val _upkeepVisible = MutableLiveData<Boolean>()
    val upkeepVisible: LiveData<Boolean> = _upkeepVisible

    private val _precombatVisible = MutableLiveData<Boolean>()
    val precombatVisible: LiveData<Boolean> = _precombatVisible

    private val _endStepVisible = MutableLiveData<Boolean>()
    val endstepVisible: LiveData<Boolean> = _endStepVisible

    private val _sacAllVisible = MutableLiveData<Boolean>()
    val sacAllVisible: LiveData<Boolean> = _sacAllVisible

    private val _sacAllAbilityVisible = MutableLiveData<Boolean>()
    val sacAllAbilityVisible: LiveData<Boolean> = _sacAllAbilityVisible

    private val _lifesOriginVisible = MutableLiveData<Boolean>()
    val lifesOriginVisible: LiveData<Boolean> = _lifesOriginVisible

    private val _chkWhiteVisible = MutableLiveData<Boolean>()
    val chkWhiteVisible: LiveData<Boolean> = _chkWhiteVisible

    private val _chkBlueVisible = MutableLiveData<Boolean>()
    val chkBlueVisible: LiveData<Boolean> = _chkBlueVisible

    private val _chkBlackVisible = MutableLiveData<Boolean>()
    val chkBlackVisible: LiveData<Boolean> = _chkBlackVisible

    private val _chkRedVisible = MutableLiveData<Boolean>()
    val chkRedVisible: LiveData<Boolean> = _chkRedVisible

    private val _chkGreenVisible = MutableLiveData<Boolean>()
    val chkGreenVisible: LiveData<Boolean> = _chkGreenVisible

    private val _m21WhiteVisible = MutableLiveData<Boolean>()
    val m21WhiteVisible: LiveData<Boolean> = _m21WhiteVisible

    private val _m21BlueVisible = MutableLiveData<Boolean>()
    val m21BlueVisible: LiveData<Boolean> = _m21BlueVisible

    private val _m21BlackVisible = MutableLiveData<Boolean>()
    val m21BlackVisible: LiveData<Boolean> = _m21BlackVisible

    private val _m21RedVisible = MutableLiveData<Boolean>()
    val m21RedVisible: LiveData<Boolean> = _m21RedVisible

    private val _m21GreenVisible = MutableLiveData<Boolean>()
    val m21GreenVisible: LiveData<Boolean> = _m21GreenVisible

    private val _neoWhiteVisible = MutableLiveData<Boolean>()
    val neoWhiteVisible: LiveData<Boolean> = _neoWhiteVisible

    private val _neoBlueVisible = MutableLiveData<Boolean>()
    val neoBlueVisible: LiveData<Boolean> = _neoBlueVisible

    private val _neoBlackVisible = MutableLiveData<Boolean>()
    val neoBlackVisible: LiveData<Boolean> = _neoBlackVisible

    private val _neoRedVisible = MutableLiveData<Boolean>()
    val neoRedVisible: LiveData<Boolean> = _neoRedVisible

    private val _neoGreenVisible = MutableLiveData<Boolean>()
    val neoGreenVisible: LiveData<Boolean> = _neoGreenVisible

    private val _noShrine = MutableLiveData<Boolean>()
    val noShrine: LiveData<Boolean> = _noShrine

    private val _noShrineTrigger = MutableLiveData<Boolean>()
    val noShrineTrigger: LiveData<Boolean> = _noShrineTrigger



    private var _oldTokenCount: Int = 0

    init {
        resetShrines()
    }

    fun resetShrines() {
        _sacAllAbilityVisible.value = false
        _upkeepVisible.value = false
        _precombatVisible.value = false
        _endStepVisible.value = false
        _sacAllVisible.value = false
        _lifesOriginVisible.value = false
        _chkWhiteVisible.value = false
        _chkBlueVisible.value = false
        _chkBlackVisible.value = false
        _chkRedVisible.value = false
        _chkGreenVisible.value = false
        _m21WhiteVisible.value = false
        _m21BlueVisible.value = false
        _m21BlackVisible.value = false
        _m21RedVisible.value = false
        _m21GreenVisible.value = false
        _neoWhiteVisible.value = false
        _neoBlueVisible.value = false
        _neoBlackVisible.value = false
        _neoRedVisible.value = false
        _neoGreenVisible.value = false
        _precombatVisible.value = false
        _noShrine.value = true
        _noShrineTrigger.value = false
        _oldTokenCount = 0
        _shrineCount.value = 0
    }

    fun tokenCount(tokenCount: String) {
        _shrineCount.value = _shrineCount.value!! - _oldTokenCount + tokenCount.toInt()
        _oldTokenCount = tokenCount.toInt()
        titleVisibilityCheck()
    }

    fun titleVisibilityCheck(){
        _noShrine.value = _shrineCount.value!! == 0
        _noShrineTrigger.value = _shrineCount.value!! > 0 && !(_sacAllVisible.value!! || _chkWhiteVisible.value!! ||
        _chkBlueVisible.value!! || _chkBlackVisible.value!! || _chkRedVisible.value!! ||
                _chkGreenVisible.value!! || _m21BlackVisible.value!! || _m21BlueVisible.value!! ||
                _m21GreenVisible.value!! || _neoWhiteVisible.value!! || _neoBlueVisible.value!! ||
                _neoBlackVisible.value!! || _neoRedVisible.value!! || _neoGreenVisible.value!!)
        _sacAllAbilityVisible.value = _sacAllVisible.value!! && _shrineCount.value!! > 5
        _upkeepVisible.value = _sacAllVisible.value!! || _chkWhiteVisible.value!! ||
                _chkBlueVisible.value!! || _chkBlackVisible.value!! || _chkRedVisible.value!! ||
                _chkGreenVisible.value!!
        _precombatVisible.value = _m21BlackVisible.value!! || _m21BlueVisible.value!! ||
                _m21GreenVisible.value!!
        _endStepVisible.value = _neoWhiteVisible.value!! || _neoBlueVisible.value!! ||
                _neoBlackVisible.value!! || _neoRedVisible.value!! || _neoGreenVisible.value!!
    }

    fun sacAllBtn() {
        if(_sacAllVisible.value!!){
            _shrineCount.value = _shrineCount.value!! - 1
            _sacAllVisible.value = false
        }
        else {
            _shrineCount.value = _shrineCount.value!! + 1
            _sacAllVisible.value = true
        }
        titleVisibilityCheck()
    }

    fun lifesOriginBtn() {
        if(_lifesOriginVisible.value!!){
            _shrineCount.value = _shrineCount.value!! - 1
            _lifesOriginVisible.value = false
        }
        else {
            _shrineCount.value = _shrineCount.value!! + 1
            _lifesOriginVisible.value = true
        }
        titleVisibilityCheck()
    }

    fun chkWhiteBtn() {
        if(_chkWhiteVisible.value!!){
            _shrineCount.value = _shrineCount.value!! - 1
            _chkWhiteVisible.value = false
        }
        else {
            _shrineCount.value = _shrineCount.value!! + 1
            _chkWhiteVisible.value = true
        }
        titleVisibilityCheck()
    }

    fun chkBlueBtn() {
        if(_chkBlueVisible.value!!){
            _shrineCount.value = _shrineCount.value!! - 1
            _chkBlueVisible.value = false
        }
        else {
            _shrineCount.value = _shrineCount.value!! + 1
            _chkBlueVisible.value = true
        }
        titleVisibilityCheck()
    }

    fun chkBlackBtn() {
        if(_chkBlackVisible.value!!){
            _shrineCount.value = _shrineCount.value!! - 1
            _chkBlackVisible.value = false
        }
        else {
            _shrineCount.value = _shrineCount.value!! + 1
            _chkBlackVisible.value = true
        }
        titleVisibilityCheck()
    }

    fun chkRedBtn() {
        if(_chkRedVisible.value!!){
            _shrineCount.value = _shrineCount.value!! - 1
            _chkRedVisible.value = false
        }
        else {
            _shrineCount.value = _shrineCount.value!! + 1
            _chkRedVisible.value = true
        }
        titleVisibilityCheck()
    }

    fun chkGreenBtn() {
        if(_chkGreenVisible.value!!){
            _shrineCount.value = _shrineCount.value!! - 1
            _chkGreenVisible.value = false
        }
        else {
            _shrineCount.value = _shrineCount.value!! + 1
            _chkGreenVisible.value = true
        }
        titleVisibilityCheck()
    }

    fun m21WhiteBtn() {
        if(_m21WhiteVisible.value!!){
            _shrineCount.value = _shrineCount.value!! - 1
            _m21WhiteVisible.value = false
        }
        else {
            _shrineCount.value = _shrineCount.value!! + 1
            _m21WhiteVisible.value = true
        }
        titleVisibilityCheck()
    }

    fun m21BlueBtn() {
        if(_m21BlueVisible.value!!){
            _shrineCount.value = _shrineCount.value!! - 1
            _m21BlueVisible.value = false
        }
        else {
            _shrineCount.value = _shrineCount.value!! + 1
            _m21BlueVisible.value = true
        }
        titleVisibilityCheck()
    }

    fun m21BlackBtn() {
        if(_m21BlackVisible.value!!){
            _shrineCount.value = _shrineCount.value!! - 1
            _m21BlackVisible.value = false
        }
        else {
            _shrineCount.value = _shrineCount.value!! + 1
            _m21BlackVisible.value = true
        }
        titleVisibilityCheck()
    }

    fun m21RedBtn() {
        if(_m21RedVisible.value!!){
            _shrineCount.value = _shrineCount.value!! - 1
            _m21RedVisible.value = false
        }
        else {
            _shrineCount.value = _shrineCount.value!! + 1
            _m21RedVisible.value = true
        }
        titleVisibilityCheck()
    }

    fun m21GreenBtn() {
        if(_m21GreenVisible.value!!){
            _shrineCount.value = _shrineCount.value!! - 1
            _m21GreenVisible.value = false
        }
        else {
            _shrineCount.value = _shrineCount.value!! + 1
            _m21GreenVisible.value = true
        }
        titleVisibilityCheck()
    }

    fun neoWhiteBtn() {
        if(_neoWhiteVisible.value!!){
            _shrineCount.value = _shrineCount.value!! - 1
            _neoWhiteVisible.value = false
        }
        else {
            _shrineCount.value = _shrineCount.value!! + 1
            _neoWhiteVisible.value = true
        }
        titleVisibilityCheck()
    }

    fun neoBlueBtn() {
        if(_neoBlueVisible.value!!){
            _shrineCount.value = _shrineCount.value!! - 1
            _neoBlueVisible.value = false
        }
        else {
            _shrineCount.value = _shrineCount.value!! + 1
            _neoBlueVisible.value = true
        }
        titleVisibilityCheck()
    }

    fun neoBlackBtn() {
        if(_neoBlackVisible.value!!){
            _shrineCount.value = _shrineCount.value!! - 1
            _neoBlackVisible.value = false
        }
        else {
            _shrineCount.value = _shrineCount.value!! + 1
            _neoBlackVisible.value = true
        }
        titleVisibilityCheck()
    }

    fun neoRedBtn() {
        if(_neoRedVisible.value!!){
            _shrineCount.value = _shrineCount.value!! - 1
            _neoRedVisible.value = false
        }
        else {
            _shrineCount.value = _shrineCount.value!! + 1
            _neoRedVisible.value = true
        }
        titleVisibilityCheck()
    }

    fun neoGreenBtn() {
        if(_neoGreenVisible.value!!){
            _shrineCount.value = _shrineCount.value!! - 1
            _neoGreenVisible.value = false
        }
        else {
            _shrineCount.value = _shrineCount.value!! + 1
            _neoGreenVisible.value = true
        }
        titleVisibilityCheck()
    }
}

