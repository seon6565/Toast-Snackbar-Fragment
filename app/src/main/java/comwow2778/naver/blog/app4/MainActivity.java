package comwow2778.naver.blog.app4;

import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

//프래그먼트에 버튼4개, 메인에 그아래요소
public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4;
    TextView t1,t2,t3,t4,t5,t6;
    EditText e1,e2,e3;

    Table T1 = new Table(null,0,0,0,0,0);
    Table T2 = new Table(null,0,0,0,0,0);
    Table T3 = new Table(null,0,0,0,0,0);
    Table T4 = new Table(null,0,0,0,0,0);
    ArrayList<Table> tablecount = new ArrayList<Table>();
    Date date;
    SimpleDateFormat tim = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    String time = tim.format(new Date(System.currentTimeMillis()));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        date = new Date();
        date.getTime();
        setTitle("HYpasta 예약시스템");
        tablecount.add(T1);
        tablecount.add(T2);
        tablecount.add(T3);
        tablecount.add(T4);

    }

    void dialog() {
        String name = null;
        //int time = 0;
        int spacount = 0;
        int pizzacount = 0;
        int membership = 0;
        int total = 0;

       //T1에 비어있음이 확인되면
                AlertDialog.Builder dig = new AlertDialog.Builder(this);
//스파게티 개수,피자 개수, 멤버쉽 카드
        //버튼에 비어있음 제거
    }
    void redialog(){
        //비어있지 않다면 스파게티,피자,맴버쉽카드 설정만 수정가능하게 함
    }

    void reset(){
        //선택한 것의 이름을 받아오고 그테이블의 모든요소를 null,0으로 초기화하고 invisible 테이블에 (비어있음)추가
        //버튼에 비어있음 추가
    }

    void onmyclick(View v) {
        if(v.getId() == R.id.b1){
            //프래그먼트 실행
        }
    }

}


