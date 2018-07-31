package com.example.abdullah_mansour.coffee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int count = 0;
    Button Add,minus,confirm,neworder;
    TextView cups,total;
    CheckBox cream,choco;
    RadioGroup group;
    RadioButton french,turkish,espresso;
    int price = 0;
    int result = 0;

    int itemprice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews ();
        Add();
        minus();
        onRadioButtonClicked();
        neworder ();
    }

    public void initializeViews ()
    {
        //Buttons
        Add = (Button) findViewById(R.id.addcups);
        minus = (Button) findViewById(R.id.minus);
        confirm = (Button) findViewById(R.id.confirm);
        neworder = (Button) findViewById(R.id.neworder);

        //Text Views
        cups = (TextView) findViewById(R.id.numberofcups);
        total = (TextView) findViewById(R.id.total);

        //Check Boxes
        cream = (CheckBox) findViewById(R.id.add_cream);
        choco = (CheckBox) findViewById(R.id.add_chocolate);

        group = (RadioGroup) findViewById(R.id.group);
    }

    public void Add ()
    {
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (count < 10)
                {
                    count = count + 1;
                    cups.setText("" + count);
                } else
                {
                    Toast.makeText(MainActivity.this,"You Can't Order More Than 10 Cups at Once",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void minus ()
    {
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (count > 0)
                {
                    count = count - 1;
                    cups.setText("" + count);
                } else
                {
                    Toast.makeText(MainActivity.this,"You Can't Order Less Than 0 Cups",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void confirm (final int itemprice)
    {
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (cream.isChecked())
                {
                    price = price + 3;
                }

                if (choco.isChecked())
                {
                    price = price + 4;
                }

                result = (count * itemprice) + (price * count);
                total.setText("Total : " + result + " L.E");
            }
        });
    }

    public void neworder ()
    {
        neworder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                count = 0;
                price = 0;
                result = 0;

                cream.setChecked(false);
                choco.setChecked(false);

                cups.setText("" + count);
                total.setText("");
            }
        });
    }

    public void onRadioButtonClicked()
    {
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.french:
                        itemprice = 5;
                        confirm(itemprice);
                        break;
                    case R.id.turkish:
                        itemprice = 7;
                        confirm(itemprice);
                        break;
                    case R.id.espresso:
                        itemprice = 10;
                        confirm(itemprice);
                        break;
                }
            }
        });
    }
}
