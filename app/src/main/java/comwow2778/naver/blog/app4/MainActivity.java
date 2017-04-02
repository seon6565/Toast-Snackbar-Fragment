package comwow2778.naver.blog.app4;

import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

//프래그먼트에 버튼4개, 메인에 그아래요소
public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4;
    TextView t1,t2,t3,t4,t5,t6;
    EditText e1,e2,e3;

    Table T1 = new Table("","",0,0,0,0);
    Table T2 = new Table("","",0,0,0,0);
    Table T3 = new Table("","",0,0,0,0);
    Table T4 = new Table("","",0,0,0,0);

    ArrayList<Table> tablecount = new ArrayList<>();
    Date date;
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
        TextView t1 = (TextView)findViewById(R.id.t1);
        TextView t2 = (TextView)findViewById(R.id.t2);
        TextView t3 = (TextView)findViewById(R.id.t3);
        TextView t4 = (TextView)findViewById(R.id.t4);
        TextView t5 = (TextView)findViewById(R.id.t5);
        TextView t6 = (TextView)findViewById(R.id.t6);
        Button b1 = (Button)findViewById(R.id.b1);
        Button b2 = (Button)findViewById(R.id.b2);
        Button b3 = (Button)findViewById(R.id.b3);
        Button b4 = (Button)findViewById(R.id.b4);

    }

    void onmyclick(View v) {
        if(v.getId() == R.id.b1){
            //사과프래그먼트 실행
        }
        else if(v.getId() == R.id.b2){
            //포도
        }
        else if(v.getId() == R.id.b3){
            //키위
        }
        else if(v.getId() == R.id.b4){
            //자몽
        }
        else if(v.getId() == R.id.b5){
            order();
        }
        else if(v.getId() == R.id.b6){
            reorder();
        }
        else if(v.getId() == R.id.b7){
            reset();
        }
    }


    void order() {
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
    void reorder(){
        if(t1.getText()=="사과Table"){

        }
        else if(t1.getText()=="포도Table"){

        }
        else if(t1.getText()=="키위Table"){

        }
        else if(t1.getText()=="자몽Table"){

        }

        else{
            Toast.makeText(MainActivity.this,"초기화할 테이블을 선택하세요",Toast.LENGTH_SHORT).show();
        }
        //비어있지 않다면 스파게티,피자,맴버쉽카드 설정만 수정가능하게 함
    }

    void reset(){
        if(t1.getText()=="사과Table"){
            b1.setText("사과Table(비어있음)");
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t6.setText("");
            T1.name = "";
            T1.time = "";
            T1.total = 0;
            T1.membership = 0;
            T1.pizzacount = 0;
            T1.spacount = 0;
        }
        else if(t1.getText()=="포도Table"){
            b1.setText("포도Table(비어있음)");
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t6.setText("");
            T2.name = "";
            T2.time = "";
            T2.total = 0;
            T2.membership = 0;
            T2.pizzacount = 0;
            T2.spacount = 0;
        }
        else if(t1.getText()=="키위Table"){
            b1.setText("키위Table(비어있음)");
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t6.setText("");
            T3.name = "";
            T3.time = "";
            T3.total = 0;
            T3.membership = 0;
            T3.pizzacount = 0;
            T3.spacount = 0;
        }
        else if(t1.getText()=="자몽Table"){
            b1.setText("자몽Table(비어있음)");
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t6.setText("");
            T4.name = "";
            T4.time = "";
            T4.total = 0;
            T4.membership = 0;
            T4.pizzacount = 0;
            T4.spacount = 0;
        }
        else{
            Toast.makeText(MainActivity.this,"초기화할 테이블을 선택하세요",Toast.LENGTH_SHORT).show();
        }
        //선택한 것의 이름을 받아오고 그테이블의 모든요소를 null,0으로 초기화하고 invisible 테이블에 (비어있음)추가
        //버튼에 비어있음 추가
    }
}


