package comwow2778.naver.blog.app4;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button bt1,bt2,bt3,bt4;
    TextView tv1,tv2,tv3,tv4,tv5,tv6;
    Table T1 = new Table("사과Table(비어있음)","","","","","");
    Table T2 = new Table("포도Table(비어있음)","","","","","");
    Table T3 = new Table("키위Table(비어있음)","","","","","");
    Table T4 = new Table("자몽Table(비어있음)","","","","","");
    ArrayList<Table> tablecount = new ArrayList<Table>();
    Date date;
    FragmentManager fragmentManager = getFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    frg fragment = new frg();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("HYpasta 예약시스템");
        tv1 = (TextView)findViewById(R.id.t1);
        tv2 = (TextView)findViewById(R.id.t2);
        tv3 = (TextView)findViewById(R.id.t3);
        tv4 = (TextView)findViewById(R.id.t4);
        tv5 = (TextView)findViewById(R.id.t5);
        tv6 = (TextView)findViewById(R.id.t6);
        bt1 = (Button)findViewById(R.id.b1);
        bt2 = (Button)findViewById(R.id.b2);
        bt3 = (Button)findViewById(R.id.b3);
        bt4 = (Button)findViewById(R.id.b4);
        tablecount.add(T1);
        tablecount.add(T2);
        tablecount.add(T3);
        tablecount.add(T4);

    }
    void onmyclick(View v) {
        if(v.getId() == R.id.b1){
            tv1.setText(T1.name);
            tv2.setText(T1.time);
            tv3.setText(T1.spacount);
            tv4.setText(T1.pizzacount);
            tv5.setText(T1.membership);
            tv6.setText(T1.total);
            if (bt1.getText() =="사과Table(비어있음)"){
                Toast.makeText(MainActivity.this,"비어있는 테이블입니다.",Toast.LENGTH_SHORT).show();
            }
        }
        else if(v.getId() ==R.id.b2){
            tv1.setText(T2.name);
            tv2.setText(T2.time);
            tv3.setText(T2.spacount);
            tv4.setText(T2.pizzacount);
            tv5.setText(T2.membership);
            tv6.setText(T2.total);
            if (bt2.getText() =="포도Table(비어있음)"){
                Toast.makeText(MainActivity.this,"비어있는 테이블입니다.",Toast.LENGTH_SHORT).show();
            }
        }
        else if(v.getId() ==R.id.b3){
            tv1.setText(T3.name);
            tv2.setText(T3.time);
            tv3.setText(T3.spacount);
            tv4.setText(T3.pizzacount);
            tv5.setText(T3.membership);
            tv6.setText(T3.total);
            if (bt3.getText() =="키위Table(비어있음)"){
                Toast.makeText(MainActivity.this,"비어있는 테이블입니다.",Toast.LENGTH_SHORT).show();
            }
        }
        else if(v.getId() ==R.id.b4){
            tv1.setText(T4.name);
            tv2.setText(T4.time);
            tv3.setText(T4.spacount);
            tv4.setText(T4.pizzacount);
            tv5.setText(T4.membership);
            tv6.setText(T4.total);
            if (bt4.getText() =="자몽Table(비어있음)"){
                Toast.makeText(MainActivity.this,"비어있는 테이블입니다.",Toast.LENGTH_SHORT).show();
            }
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
        if(tv1.getText()=="사과Table(비어있음)"){
            final View digview = View.inflate(this, R.layout.digview,null);
            final EditText e1 = (EditText)digview.findViewById(R.id.e1);
            final EditText e2 = (EditText)digview.findViewById(R.id.e2);
            final CheckBox c1 = (CheckBox)digview.findViewById(R.id.c1);
            final CheckBox c2 = (CheckBox)digview.findViewById(R.id.c2);
            AlertDialog.Builder dig = new AlertDialog.Builder(this);
            dig.setTitle("주문 상자");
            dig.setView(digview);
            dig.setPositiveButton("확인",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String name = "사과Table";
                    String time = DateFormat.getDateTimeInstance().format(new Date());
                    String spacount = e1.getText().toString();
                    String pizzacount = e2.getText().toString();
                    String membership="";
                    String total ="";
                    int spacounts = Integer.parseInt(spacount);
                    int pizzacounts = Integer.parseInt(pizzacount);
                    int totals=0;
                    if(c1.isChecked() && c2.isChecked()){
                        Toast.makeText(MainActivity.this,"맴버쉽을 하나만 선택하세요.",Toast.LENGTH_SHORT).show();
                        total = String.valueOf(totals);
                    }
                    else if(c1.isChecked()){
                        membership = "기본맴버쉽";
                        totals = ((spacounts * 10000) + (pizzacounts * 12000)) /100*90;
                        total = String.valueOf(totals);
                    }
                    else if(c2.isChecked()){
                        membership = "VIP맴버쉽";
                        totals = ((spacounts * 10000) + (pizzacounts * 12000)) /100*70;
                        total = String.valueOf(totals);
                    }
                    else{
                        totals = (spacounts * 10000) + (pizzacounts * 12000);
                        total = String.valueOf(totals);
                    }
                    T1.name = name;
                    T1.time = time;
                    T1.spacount = spacount;
                    T1.pizzacount = pizzacount;
                    T1.membership = membership;
                    T1.total = total;
                    bt1.setText("사과Table");
                    tv1.setText(T1.name);
                    tv2.setText(T1.time);
                    tv3.setText(T1.spacount);
                    tv4.setText(T1.pizzacount);
                    tv5.setText(T1.membership);
                    tv6.setText(T1.total);
                    Snackbar.make(getWindow().getDecorView().getRootView(),"정보가 입력되었습니다",Snackbar.LENGTH_SHORT).show();
                }
            });
            dig.setNegativeButton("취소",null);
            dig.show();
        }
        else if(tv1.getText()=="포도Table(비어있음)"){
            final View digview = View.inflate(this, R.layout.digview,null);
            final EditText e1 = (EditText)digview.findViewById(R.id.e1);
            final EditText e2 = (EditText)digview.findViewById(R.id.e2);
            final CheckBox c1 = (CheckBox)digview.findViewById(R.id.c1);
            final CheckBox c2 = (CheckBox)digview.findViewById(R.id.c2);
            AlertDialog.Builder dig = new AlertDialog.Builder(this);
            dig.setTitle("주문 상자");
            dig.setView(digview);
            dig.setPositiveButton("확인",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String name = "포도Table";
                    String time = DateFormat.getDateTimeInstance().format(new Date());
                    String spacount = e1.getText().toString();
                    String pizzacount = e2.getText().toString();
                    String membership="";
                    String total ="";
                    int spacounts = Integer.parseInt(spacount);
                    int pizzacounts = Integer.parseInt(pizzacount);
                    int totals=0;
                    if(c1.isChecked() && c2.isChecked()){
                        Toast.makeText(MainActivity.this,"맴버쉽을 하나만 선택하세요.",Toast.LENGTH_SHORT).show();
                        total = String.valueOf(totals);
                    }
                    else if(c1.isChecked()){
                        membership = "기본맴버쉽";
                        totals = ((spacounts * 10000) + (pizzacounts * 12000)) /100*90;
                        total = String.valueOf(totals);
                    }
                    else if(c2.isChecked()){
                        membership = "VIP맴버쉽";
                        totals = ((spacounts * 10000) + (pizzacounts * 12000)) /100*70;
                        total = String.valueOf(totals);
                    }
                    else{
                        totals = (spacounts * 10000) + (pizzacounts * 12000);
                        total = String.valueOf(totals);
                    }
                    T2.name = name;
                    T2.time = time;
                    T2.spacount = spacount;
                    T2.pizzacount = pizzacount;
                    T2.membership = membership;
                    T2.total = total;
                    bt2.setText("포도Table");
                    tv1.setText(T2.name);
                    tv2.setText(T2.time);
                    tv3.setText(T2.spacount);
                    tv4.setText(T2.pizzacount);
                    tv5.setText(T2.membership);
                    tv6.setText(T2.total);
                    Snackbar.make(getWindow().getDecorView().getRootView(),"정보가 입력되었습니다",Snackbar.LENGTH_SHORT).show();
                }
            });
            dig.setNegativeButton("취소",null);
            dig.show();
        }
        else if(tv1.getText()=="키위Table(비어있음)"){
            final View digview = View.inflate(this, R.layout.digview,null);
            final EditText e1 = (EditText)digview.findViewById(R.id.e1);
            final EditText e2 = (EditText)digview.findViewById(R.id.e2);
            final CheckBox c1 = (CheckBox)digview.findViewById(R.id.c1);
            final CheckBox c2 = (CheckBox)digview.findViewById(R.id.c2);
            AlertDialog.Builder dig = new AlertDialog.Builder(this);
            dig.setTitle("주문 상자");
            dig.setView(digview);
            dig.setPositiveButton("확인",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String name = "키위Table";
                    String time = DateFormat.getDateTimeInstance().format(new Date());
                    String spacount = e1.getText().toString();
                    String pizzacount = e2.getText().toString();
                    String membership="";
                    String total ="";
                    int spacounts = Integer.parseInt(spacount);
                    int pizzacounts = Integer.parseInt(pizzacount);
                    int totals=0;
                    if(c1.isChecked() && c2.isChecked()){
                        Toast.makeText(MainActivity.this,"맴버쉽을 하나만 선택하세요.",Toast.LENGTH_SHORT).show();
                        total = String.valueOf(totals);
                    }
                    else if(c1.isChecked()){
                        membership = "기본맴버쉽";
                        totals = ((spacounts * 10000) + (pizzacounts * 12000)) /100*90;
                        total = String.valueOf(totals);
                    }
                    else if(c2.isChecked()){
                        membership = "VIP맴버쉽";
                        totals = ((spacounts * 10000) + (pizzacounts * 12000)) /100*70;
                        total = String.valueOf(totals);
                    }
                    else{
                        totals = (spacounts * 10000) + (pizzacounts * 12000);
                        total = String.valueOf(totals);
                    }
                    T4.name = name;
                    T4.time = time;
                    T4.spacount = spacount;
                    T4.pizzacount = pizzacount;
                    T4.membership = membership;
                    T4.total = total;
                    bt3.setText("키위Table");
                    tv1.setText(T4.name);
                    tv2.setText(T4.time);
                    tv3.setText(T4.spacount);
                    tv4.setText(T4.pizzacount);
                    tv5.setText(T4.membership);
                    tv6.setText(T4.total);
                    Snackbar.make(getWindow().getDecorView().getRootView(),"정보가 입력되었습니다",Snackbar.LENGTH_SHORT).show();
                }
            });
            dig.setNegativeButton("취소",null);
            dig.show();
        }
        else if(tv1.getText()=="자몽Table(비어있음)"){
            final View digview = View.inflate(this, R.layout.digview,null);
            final EditText e1 = (EditText)digview.findViewById(R.id.e1);
            final EditText e2 = (EditText)digview.findViewById(R.id.e2);
            final CheckBox c1 = (CheckBox)digview.findViewById(R.id.c1);
            final CheckBox c2 = (CheckBox)digview.findViewById(R.id.c2);
            AlertDialog.Builder dig = new AlertDialog.Builder(this);
            dig.setTitle("주문 상자");
            dig.setView(digview);
            dig.setPositiveButton("확인",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String name = "자몽Table";
                    String time = DateFormat.getDateTimeInstance().format(new Date());
                    String spacount = e1.getText().toString();
                    String pizzacount = e2.getText().toString();
                    String membership="";
                    String total ="";
                    int spacounts = Integer.parseInt(spacount);
                    int pizzacounts = Integer.parseInt(pizzacount);
                    int totals=0;
                    if(c1.isChecked() && c2.isChecked()){
                        Toast.makeText(MainActivity.this,"맴버쉽을 하나만 선택하세요.",Toast.LENGTH_SHORT).show();
                        total = String.valueOf(totals);
                    }
                    else if(c1.isChecked()){
                        membership = "기본맴버쉽";
                        totals = ((spacounts * 10000) + (pizzacounts * 12000)) /100*90;
                        total = String.valueOf(totals);
                    }
                    else if(c2.isChecked()){
                        membership = "VIP맴버쉽";
                        totals = ((spacounts * 10000) + (pizzacounts * 12000)) /100*70;
                        total = String.valueOf(totals);
                    }
                    else{
                        totals = (spacounts * 10000) + (pizzacounts * 12000);
                        total = String.valueOf(totals);
                    }
                    T4.name = name;
                    T4.time = time;
                    T4.spacount = spacount;
                    T4.pizzacount = pizzacount;
                    T4.membership = membership;
                    T4.total = total;
                    bt4.setText("자몽Table");
                    tv1.setText(T4.name);
                    tv2.setText(T4.time);
                    tv3.setText(T4.spacount);
                    tv4.setText(T4.pizzacount);
                    tv5.setText(T4.membership);
                    tv6.setText(T4.total);
                    Snackbar.make(getWindow().getDecorView().getRootView(),"정보가 입력되었습니다",Snackbar.LENGTH_SHORT).show();
                }
            });
            dig.setNegativeButton("취소",null);
            dig.show();
        }
        else{
            Toast.makeText(MainActivity.this,"테이블이 이미 존재합니다.",Toast.LENGTH_SHORT).show();
        }

    }
    void reorder(){
        if(tv1.getText()=="사과Table"){
            final View digview = View.inflate(this, R.layout.digview,null);
            final EditText e1 = (EditText)digview.findViewById(R.id.e1);
            final EditText e2 = (EditText)digview.findViewById(R.id.e2);
            final CheckBox c1 = (CheckBox)digview.findViewById(R.id.c1);
            final CheckBox c2 = (CheckBox)digview.findViewById(R.id.c2);
            AlertDialog.Builder dig = new AlertDialog.Builder(this);
            dig.setTitle("주문 상자");
            dig.setView(digview);
            dig.setPositiveButton("확인",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String spacount = e1.getText().toString();
                    String pizzacount = e2.getText().toString();
                    String membership="";
                    String total ="";
                    int spacounts = Integer.parseInt(spacount);
                    int pizzacounts = Integer.parseInt(pizzacount);
                    int totals=0;
                    if(c1.isChecked() && c2.isChecked()){
                        Toast.makeText(MainActivity.this,"맴버쉽을 하나만 선택하세요.",Toast.LENGTH_SHORT).show();
                        total = String.valueOf(totals);
                    }
                    else if(c1.isChecked()){
                        membership = "기본맴버쉽";
                        totals = ((spacounts * 10000) + (pizzacounts * 12000)) /100*90;
                        total = String.valueOf(totals);
                    }
                    else if(c2.isChecked()){
                        membership = "VIP맴버쉽";
                        totals = ((spacounts * 10000) + (pizzacounts * 12000)) /100*70;
                        total = String.valueOf(totals);
                    }
                    else{
                        totals = (spacounts * 10000) + (pizzacounts * 12000);
                        total = String.valueOf(totals);
                    }
                    T1.spacount = spacount;
                    T1.pizzacount = pizzacount;
                    T1.membership = membership;
                    T1.total = total;
                    tv3.setText(T1.spacount);
                    tv4.setText(T1.pizzacount);
                    tv5.setText(T1.membership);
                    tv6.setText(T1.total);
                    Snackbar.make(getWindow().getDecorView().getRootView(),"정보가 수정되었습니다",Snackbar.LENGTH_SHORT).show();
                }
            });
            dig.setNegativeButton("취소",null);
            dig.show();
        }
        else if(tv1.getText()=="포도Table"){
            final View digview = View.inflate(this, R.layout.digview,null);
            final EditText e1 = (EditText)digview.findViewById(R.id.e1);
            final EditText e2 = (EditText)digview.findViewById(R.id.e2);
            final CheckBox c1 = (CheckBox)digview.findViewById(R.id.c1);
            final CheckBox c2 = (CheckBox)digview.findViewById(R.id.c2);
            AlertDialog.Builder dig = new AlertDialog.Builder(this);
            dig.setTitle("주문 상자");
            dig.setView(digview);
            dig.setPositiveButton("확인",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String spacount = e1.getText().toString();
                    String pizzacount = e2.getText().toString();
                    String membership="";
                    String total ="";
                    int spacounts = Integer.parseInt(spacount);
                    int pizzacounts = Integer.parseInt(pizzacount);
                    int totals=0;
                    if(c1.isChecked() && c2.isChecked()){
                        Toast.makeText(MainActivity.this,"맴버쉽을 하나만 선택하세요.",Toast.LENGTH_SHORT).show();
                        total = String.valueOf(totals);
                    }
                    else if(c1.isChecked()){
                        membership = "기본맴버쉽";
                        totals = ((spacounts * 10000) + (pizzacounts * 12000)) /100*90;
                        total = String.valueOf(totals);
                    }
                    else if(c2.isChecked()){
                        membership = "VIP맴버쉽";
                        totals = ((spacounts * 10000) + (pizzacounts * 12000)) /100*70;
                        total = String.valueOf(totals);
                    }
                    else{
                        totals = (spacounts * 10000) + (pizzacounts * 12000);
                        total = String.valueOf(totals);
                    }
                    T2.spacount = spacount;
                    T2.pizzacount = pizzacount;
                    T2.membership = membership;
                    T2.total = total;
                    tv3.setText(T2.spacount);
                    tv4.setText(T2.pizzacount);
                    tv5.setText(T2.membership);
                    tv6.setText(T2.total);
                    Snackbar.make(getWindow().getDecorView().getRootView(),"정보가 수정되었습니다",Snackbar.LENGTH_SHORT).show();
                }
            });
            dig.setNegativeButton("취소",null);
            dig.show();
        }
        else if(tv1.getText()=="키위Table"){
            final View digview = View.inflate(this, R.layout.digview,null);
            final EditText e1 = (EditText)digview.findViewById(R.id.e1);
            final EditText e2 = (EditText)digview.findViewById(R.id.e2);
            final CheckBox c1 = (CheckBox)digview.findViewById(R.id.c1);
            final CheckBox c2 = (CheckBox)digview.findViewById(R.id.c2);
            AlertDialog.Builder dig = new AlertDialog.Builder(this);
            dig.setTitle("주문 상자");
            dig.setView(digview);
            dig.setPositiveButton("확인",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String spacount = e1.getText().toString();
                    String pizzacount = e2.getText().toString();
                    String membership="";
                    String total ="";
                    int spacounts = Integer.parseInt(spacount);
                    int pizzacounts = Integer.parseInt(pizzacount);
                    int totals=0;
                    if(c1.isChecked() && c2.isChecked()){
                        Toast.makeText(MainActivity.this,"맴버쉽을 하나만 선택하세요.",Toast.LENGTH_SHORT).show();
                        total = String.valueOf(totals);
                    }
                    else if(c1.isChecked()){
                        membership = "기본맴버쉽";
                        totals = ((spacounts * 10000) + (pizzacounts * 12000)) /100*90;
                        total = String.valueOf(totals);
                    }
                    else if(c2.isChecked()){
                        membership = "VIP맴버쉽";
                        totals = ((spacounts * 10000) + (pizzacounts * 12000)) /100*70;
                        total = String.valueOf(totals);
                    }
                    else{
                        totals = (spacounts * 10000) + (pizzacounts * 12000);
                        total = String.valueOf(totals);
                    }
                    T3.spacount = spacount;
                    T3.pizzacount = pizzacount;
                    T3.membership = membership;
                    T3.total = total;
                    tv3.setText(T3.spacount);
                    tv4.setText(T3.pizzacount);
                    tv5.setText(T3.membership);
                    tv6.setText(T3.total);
                    Snackbar.make(getWindow().getDecorView().getRootView(),"정보가 수정되었습니다",Snackbar.LENGTH_SHORT).show();
                }
            });
            dig.setNegativeButton("취소",null);
            dig.show();
        }
        else if(tv1.getText()=="자몽Table"){
            final View digview = View.inflate(this, R.layout.digview,null);
            final EditText e1 = (EditText)digview.findViewById(R.id.e1);
            final EditText e2 = (EditText)digview.findViewById(R.id.e2);
            final CheckBox c1 = (CheckBox)digview.findViewById(R.id.c1);
            final CheckBox c2 = (CheckBox)digview.findViewById(R.id.c2);
            AlertDialog.Builder dig = new AlertDialog.Builder(this);
            dig.setTitle("주문 상자");
            dig.setView(digview);
            dig.setPositiveButton("확인",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String spacount = e1.getText().toString();
                    String pizzacount = e2.getText().toString();
                    String membership="";
                    String total ="";
                    int spacounts = Integer.parseInt(spacount);
                    int pizzacounts = Integer.parseInt(pizzacount);
                    int totals=0;
                    if(c1.isChecked() && c2.isChecked()){
                        Toast.makeText(MainActivity.this,"맴버쉽을 하나만 선택하세요.",Toast.LENGTH_SHORT).show();
                        total = String.valueOf(totals);
                    }
                    else if(c1.isChecked()){
                        membership = "기본맴버쉽";
                        totals = ((spacounts * 10000) + (pizzacounts * 12000)) /100*90;
                        total = String.valueOf(totals);
                    }
                    else if(c2.isChecked()){
                        membership = "VIP맴버쉽";
                        totals = ((spacounts * 10000) + (pizzacounts * 12000)) /100*70;
                        total = String.valueOf(totals);
                    }
                    else{
                        totals = (spacounts * 10000) + (pizzacounts * 12000);
                        total = String.valueOf(totals);
                    }
                    T4.spacount = spacount;
                    T4.pizzacount = pizzacount;
                    T4.membership = membership;
                    T4.total = total;
                    tv3.setText(T4.spacount);
                    tv4.setText(T4.pizzacount);
                    tv5.setText(T4.membership);
                    tv6.setText(T4.total);
                    Snackbar.make(getWindow().getDecorView().getRootView(),"정보가 수정되었습니다",Snackbar.LENGTH_SHORT).show();
                }
            });
            dig.setNegativeButton("취소",null);
            dig.show();
        }

        else{
            Toast.makeText(MainActivity.this,"비어있는 테이블은 수정할수없습니다.",Toast.LENGTH_SHORT).show();
        }
        //비어있지 않다면 스파게티,피자,맴버쉽카드 설정만 수정가능하게 함
    }

    void reset(){
        if(tv1.getText()=="사과Table"){
            bt1.setText("사과Table(비어있음)");
            tv1.setText("사과Table(비어있음)");
            tv2.setText("");
            tv3.setText("");
            tv4.setText("");
            tv5.setText("");
            tv6.setText("");
            T1.name = "사과Table(비어있음)";
            T1.time = "";
            T1.total = "";
            T1.membership = "";
            T1.pizzacount = "";
            T1.spacount = "";
        }
        else if(tv1.getText()=="포도Table"){
            bt2.setText("포도Table(비어있음)");
            tv1.setText("포도Table(비어있음)");
            tv2.setText("");
            tv3.setText("");
            tv4.setText("");
            tv5.setText("");
            tv6.setText("");
            T2.name = "포도Table(비어있음)";
            T2.time = "";
            T2.total = "";
            T2.membership = "";
            T2.pizzacount = "";
            T2.spacount = "";
        }
        else if(tv1.getText()=="키위Table"){
            bt3.setText("키위Table(비어있음)");
            tv1.setText("키위Table(비어있음)");
            tv2.setText("");
            tv3.setText("");
            tv4.setText("");
            tv5.setText("");
            tv6.setText("");
            T3.name = "키위Table(비어있음)";
            T3.time = "";
            T3.total = "";
            T3.membership = "";
            T3.pizzacount = "";
            T3.spacount = "";
        }
        else if(tv1.getText()=="자몽Table"){
            bt4.setText("자몽Table(비어있음)");
            tv1.setText("자몽Table(비어있음)");
            tv2.setText("");
            tv3.setText("");
            tv4.setText("");
            tv5.setText("");
            tv6.setText("");
            T4.name = "자몽Table(비어있음)";
            T4.time = "";
            T4.total = "";
            T4.membership = "";
            T4.pizzacount = "";
            T4.spacount = "";
        }
        else{
            Toast.makeText(MainActivity.this,"초기화할 테이블을 선택하세요",Toast.LENGTH_SHORT).show();
        }
    }
}


