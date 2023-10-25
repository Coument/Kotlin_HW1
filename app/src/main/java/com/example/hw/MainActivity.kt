package com.example.hw

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private var editText: EditText? = null
    private var textView: TextView? = null
    private  var name:TextView? = null
    private  var winner:TextView? = null
    private  var mmora:TextView? = null
    private  var cmora:TextView? = null
    private var btn_scissor: RadioButton? = null
    private  var btn_stone:RadioButton? = null
    private  var btn_paper:RadioButton? = null
    private  var button: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText=findViewById(R.id.editTextText);
        textView=findViewById(R.id.textView);
        name=findViewById(R.id.name1);
        winner=findViewById(R.id.name2);
        mmora=findViewById(R.id.name3);
        cmora=findViewById(R.id.textView5);
        btn_scissor=findViewById(R.id.btn_scissor);
        btn_paper=findViewById(R.id.btn_paper);
        btn_stone=findViewById(R.id.btn_stone);
        button=findViewById(R.id.button);

        button?.setOnClickListener(View.OnClickListener {
            if (editText?.length()!! < 1) {
                textView?.text = "請輸入玩家姓名"
            } else {
                name?.text = String.format("名字:\n%s", editText?.getText().toString())
                if (btn_paper?.isChecked == true) {
                    mmora?.text = "我方出拳\n布"
                } else if (btn_scissor?.isChecked == true) {
                    mmora?.text = "我方出拳\n剪刀"
                } else {
                    mmora?.text = "我方出拳\n石頭"
                }
                val rand = (Math.random() * 3).toInt()
                if (rand == 0) {
                    cmora?.text = "電腦出拳\n布"
                } else if (rand == 1) {
                    cmora?.text = "電腦出拳\n剪刀"
                } else if (rand == 2) {
                    cmora?.text = "電腦出拳\n石頭"
                }
                if (((btn_paper?.isChecked == true && rand == 2) || (btn_scissor?.isChecked == true && rand == 0 )|| (btn_stone?.isChecked == true && rand == 1))) {
                    textView?.text = "你贏了"
                    winner?.text = "勝利者\n玩家"
                } else if (btn_paper?.isChecked == true && rand == 1 || btn_scissor?.isChecked == true && rand == 2 || btn_stone?.isChecked == true && rand == 0) {
                    textView?.text = "你輸了"
                    winner?.text = "勝利者\n電腦"
                } else {
                    textView?.text = "平局，再來一次"
                    winner?.text = "勝利者\n平手"
                }
            }
        })
    }
}