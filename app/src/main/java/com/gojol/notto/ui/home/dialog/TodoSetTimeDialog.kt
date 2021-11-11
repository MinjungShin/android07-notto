package com.gojol.notto.ui.home.dialog

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import com.gojol.notto.R
import com.gojol.notto.databinding.DialogTodoSetTimeBinding

class TodoSetTimeDialog(context: Context) : TodoBaseDialogImpl(context) {
    private val binding: DialogTodoSetTimeBinding =
        DataBindingUtil.inflate(
        LayoutInflater.from(context), R.layout.dialog_todo_set_time,
        null,
        false
    )

    init {
        setBinding(binding)
        setDialog(WIDTH, HEIGHT)
        initClickListener()
    }

    companion object {
        const val WIDTH = 0.8f
        const val HEIGHT = 0.8f
    }

    private fun initClickListener() {
        binding.bvDialogDeletion.btnDialogBaseConfirm.setOnClickListener {
            confirm()
        }
        binding.bvDialogDeletion.btnDialogBaseReject.setOnClickListener {
            dismiss()
        }
    }

    override fun confirm() {
        if (Build.VERSION.SDK_INT >= 23) {
            val hour = binding.tpSetTime.hour
            val minute = binding.tpSetTime.minute
        } else {
            val hour = binding.tpSetTime.currentHour
            val minute = binding.tpSetTime.currentMinute
        }
        // TODO : 얻은 정보 Todo 편집 화면으로 보내기
        super.confirm()
    }
}