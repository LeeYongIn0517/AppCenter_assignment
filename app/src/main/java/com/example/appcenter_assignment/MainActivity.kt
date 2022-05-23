package com.example.appcenter_assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.RecyclerView
import com.example.appcenter_assignment.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var splashOut = false
        // Set up an OnPreDrawListener to the root view.
        val content = findViewById<View>(android.R.id.content)
        content.viewTreeObserver.addOnPreDrawListener(object:ViewTreeObserver.OnPreDrawListener{
            override fun onPreDraw(): Boolean {
                return splashOut //false:뷰 그리기 중단, true:뷰 그리기&활동 시작
            }
        })
        CoroutineScope(Dispatchers.IO).launch {
            delay(3000)
            splashOut = true
        }
        //리사이클러 어댑터 등록
        binding.rcView.adapter = Adapter(createData())
        //버튼 클릭시 인텐트
        binding.nextBtn.setOnClickListener {
            val intent = Intent(this,PageActivity::class.java)
            intent.putExtra("exit","End")
            startActivity(intent)
        }
    }
    private fun createData():ArrayList<Nation>{
        val data = arrayListOf<Nation>()
        data.add(Nation("대한민국","서울"))
        data.add(Nation("중국","베이징"))
        data.add(Nation("미국","워싱턴 DC"))
        data.add(Nation("영국","런던"))
        data.add(Nation("인도","뉴델리"))
        data.add(Nation("일본","도쿄"))
        data.add(Nation("독일","베를린"))
        data.add(Nation("프랑스","파리"))
        data.add(Nation("캐나다","오타와"))
        data.add(Nation("우크라이나","키예프"))
        data.add(Nation("러시아","모스크바"))
        data.add(Nation("이집트","나이로"))
        data.add(Nation("브라질","상파울로"))
        data.add(Nation("쿠바","아바나"))
        data.add(Nation("멕시코","멕시코시티"))
        data.add(Nation("스페인","마드리드"))
        data.add(Nation("노르웨이","오슬로"))

        return data
    }
}