package com.example.myapplication;

import android.content.Intent;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button yesBtn;
    private Button noBtn;
    private Button showAnswer;
    private TextView resultDesk;


    ArrayList<String> finish = new ArrayList<>(); // здесь бы его заполнить





    private Question[] questions = new Question[]{
            new Question(R.string.question1, true), //0
            new Question(R.string.question2, false), //1
            new Question(R.string.question3, false), //2
            new Question(R.string.question4, true), //3
            new Question(R.string.question5, true) //4
    };

    private int questionIndex = 0; // номер вопроса
    private String endResult = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("SYSTEM INFO", "Метод onCreate() запущен");
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) { // Если есть сохранённая информация, то достаём её.
            questionIndex = savedInstanceState.getInt("questionIndex");
        }

        textView = findViewById(R.id.textView);
        yesBtn = findViewById(R.id.yesBtn);
        noBtn = findViewById(R.id.noBtn);
        showAnswer = findViewById(R.id.showAnswer);
        resultDesk = findViewById(R.id.resultDesk);

        textView.setText(questions[questionIndex].getQuestionResId());
        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questions[questionIndex].isAnswerTrue()) {
                    Toast.makeText(MainActivity.this, R.string.correct, Toast.LENGTH_SHORT).show();

                    finish.add(questionIndex, "Правильно");
                } else {
                    Toast.makeText(MainActivity.this, R.string.incorrect, Toast.LENGTH_SHORT).show();
                    finish.add(questionIndex, "Неправильно");
                }
                if (questionIndex == questions.length - 1) {
                    Intent intent = new Intent(MainActivity.this, ActivityEnd.class);
                    intent.putExtra("answer", finish);
                   

                    endResult += "Правильно \n";
                } else {
                    Toast.makeText(MainActivity.this, R.string.incorrect, Toast.LENGTH_SHORT).show();
                    endResult += "Неправильно \n";
                }
                if (questionIndex == questions.length - 1) {
                    Intent intent = new Intent(MainActivity.this, ActivityEnd.class);
                    intent.putExtra("answer", endResult); // Вы отдаёте по ключу answer



                    startActivity(intent);
                } else if (questionIndex < questions.length - 1) {


                    questionIndex++;
                    textView.setText(questions[questionIndex].getQuestionResId());
                }
            }
        });

        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questions[questionIndex].isAnswerTrue()) {
                    Toast.makeText(MainActivity.this, R.string.incorrect, Toast.LENGTH_SHORT).show();

                    finish.add(questionIndex, "Неправильно");
                } else {
                    Toast.makeText(MainActivity.this, R.string.correct, Toast.LENGTH_SHORT).show();
                    finish.add(questionIndex, "Правильно");
                }
                if (questionIndex == questions.length - 1) {
                    Intent intent = new Intent(MainActivity.this, ActivityEnd.class);
                    intent.putExtra("answer", finish); //написать код

                    endResult += "Неправильно \n";
                } else {
                    Toast.makeText(MainActivity.this, R.string.correct, Toast.LENGTH_SHORT).show();
                    endResult += "Правильно \n";
                }
                if (questionIndex == questions.length - 1) {
                    Intent intent = new Intent(MainActivity.this, ActivityEnd.class);
                    intent.putExtra("answer", endResult);

                    startActivity(intent);
                } else if (questionIndex < questions.length - 1) {


                    questionIndex++;
                    textView.setText(questions[questionIndex].getQuestionResId());
                }
            }
        });

        showAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AnswerActivity.class);
                intent.putExtra("answer", questions[questionIndex].isAnswerTrue());
                startActivity(intent);
            }
        });
    }


    @Override
    public void onStart(){
        super.onStart();
        Log.d("SYSTEM INFO","Метод onStart() запущен");
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.d("SYSTEM INFO","Метод onResume() запущен");
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.d("SYSTEM INFO","Метод onPause() запущен");
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){ // Метод сохранения данных перед уничтожением активности
        super.onSaveInstanceState(savedInstanceState);
        Log.d("SYSTEM INFO","Метод onSaveInstanceState() запущен");
        savedInstanceState.putInt("questionIndex",questionIndex); // Добавили элемент по ключу
    }
    @Override
    public void onStop(){
        super.onStop();
        Log.d("SYSTEM INFO","Метод onStop() запущен");
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d("SYSTEM INFO","Метод onDestroy() запущен");
    }
}
