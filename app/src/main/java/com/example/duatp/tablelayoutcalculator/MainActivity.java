package com.example.duatp.tablelayoutcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit1,edit2;
    String num1;
    String num2;
    Integer result;
    TextView textView;
    Button[] numButtons = new Button[10];
    Integer[] numBtnIDs = {R.id.BtnNum0,R.id.BtnNum1,R.id.BtnNum2,R.id.BtnNum3,R.id.BtnNum4,
            R.id.BtnNum5,R.id.BtnNum6,R.id.BtnNum7,R.id.BtnNum8,R.id.BtnNum9};
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("테이블레이아웃 계산기");

        edit1 = (EditText) findViewById(R.id.Text1);
        edit2 = (EditText) findViewById(R.id.Text2);
        textView = (TextView) findViewById(R.id.TextView);

        for(i=0;i<numBtnIDs.length;i++){
            numButtons[i] = (Button) findViewById(numBtnIDs[i]);
        }

        for(i=0;i<numBtnIDs.length;i++){
            final int index;
            index = i;
            numButtons[index].setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){

                    if(edit1.isFocused()==true){
                        num1 = edit1.getText().toString() + numButtons[index].getText().toString();
                        edit1.setText(num1);
                    }else if (edit2.isFocused()==true){
                        num2 = edit2.getText().toString() + numButtons[index].getText().toString();
                        edit2.setText(num2);
                    } else{
                        Toast.makeText(getApplicationContext(), "먼저 에디트텍스트를 선택하세요", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    public void onAddClicked(View v){
        if(Verification()) {
            num1 = edit1.getText().toString();
            num2 = edit2.getText().toString();
            result = Integer.parseInt(num1) + Integer.parseInt(num2);
            textView.setText("계산 결과 : " + result);
        }
    }

    public void onSubClicked(View v){
        if(Verification()) {
            num1 = edit1.getText().toString();
            num2 = edit2.getText().toString();
            result = Integer.parseInt(num1) - Integer.parseInt(num2);
            textView.setText("계산 결과 : " + result);
        }
    }

    public void onMulClicked(View v){
        if(Verification()) {
            num1 = edit1.getText().toString();
            num2 = edit2.getText().toString();
            result = Integer.parseInt(num1) * Integer.parseInt(num2);
            textView.setText("계산 결과 : " + result);
        }
    }

    public void onDivClicked(View v){
        if(Verification()) {
            if(edit2.getText().toString().equals("0")) {
                Toast.makeText(getApplicationContext(),"나누는 값이 0 입니다.",Toast.LENGTH_LONG).show();
            }else{
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) / Integer.parseInt(num2);
                textView.setText("계산 결과 : " + result);
            }

        }
    }

    private boolean Verification(){
        if(edit1.getText().toString().equals("")||edit2.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"값이 입력되지 않았습니다.",Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}
