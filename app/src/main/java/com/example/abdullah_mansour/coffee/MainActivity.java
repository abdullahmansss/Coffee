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
    // declare objects from view classes
    Button Add,minus,confirm,neworder;
    TextView cups,total;
    CheckBox cream,choco;
    RadioGroup group;
    RadioButton french,turkish,espresso;

    // count cup of coffee
    int count = 0;
    // calculate adds (cream & chocolate)
    int price = 0;
    // calculate total (number of cups & adds)
    int result = 0;
    // item price (french - turkish - espresso)
    int itemprice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // calling methods
        initializeViews ();
        Add();
        minus();
        onRadioButtonClicked();
        neworder ();
    }

    public void initializeViews ()
    {
        // buttons
        Add = (Button) findViewById(R.id.addcups);
        minus = (Button) findViewById(R.id.minus);
        confirm = (Button) findViewById(R.id.confirm);
        neworder = (Button) findViewById(R.id.neworder);

        // text views
        cups = (TextView) findViewById(R.id.numberofcups);
        total = (TextView) findViewById(R.id.total);

        // check boxes
        cream = (CheckBox) findViewById(R.id.add_cream);
        choco = (CheckBox) findViewById(R.id.add_chocolate);

        // radio group
        group = (RadioGroup) findViewById(R.id.group);
    }

    // add button method
    public void Add ()
    {
        // set on click button
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (count < 10)
                {
                    // make button add 1 if the number of cups still less than 10
                    count = count + 1;
                    // set count text to the number of cups
                    cups.setText("" + count);
                } else
                {
                    // toast message appear if numbers of cups more than 10
                    Toast.makeText(MainActivity.this,"You Can't Order More Than 10 Cups at Once",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    // minus button method
    public void minus ()
    {
        // set on click button
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (count > 0)
                {
                    // make button minus 1 if the number of cups still less than 10
                    count = count - 1;
                    // set count text to the number of cups
                    cups.setText("" + count);
                } else
                {
                    // toast message appear if numbers of cups less than 0
                    Toast.makeText(MainActivity.this,"You Can't Order Less Than 0 Cups",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    // confirm button method
    public void confirm (final int itemprice)
    {
        // set on click button
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                // check if cream added or not
                if (cream.isChecked())
                {
                    // if yes, so add 3 to price
                    price = price + 3;
                }

                // check if choco added or not
                if (choco.isChecked())
                {
                    // if yes, so add 4 to price
                    price = price + 4;
                }

                // calculate result
                result = (count * itemprice) + (price * count);
                // set total text to Total : 5 L.E
                total.setText("Total : " + result + " L.E");
            }
        });
    }

    // new order button method
    public void neworder ()
    {
        // set on click button
        neworder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                // make all int variables = 0
                count = 0;
                price = 0;
                result = 0;

                // set 2 check boxes to unchecked
                cream.setChecked(false);
                choco.setChecked(false);

                // set 2 text views to "" empty
                cups.setText("" + count);
                total.setText("");
            }
        });
    }

    // radio button click method
    public void onRadioButtonClicked()
    {
        // set on click radio group
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    // if ID equal to french ID
                    case R.id.french:
                        // so set item price = 5
                        itemprice = 5;
                        // calling confirm method and pass item price as a parameter to it
                        confirm(itemprice);
                        // then break
                        break;
                    // if ID equal to turkish ID
                    case R.id.turkish:
                        // so set item price = 7
                        itemprice = 7;
                        // calling confirm method and pass item price as a parameter to it
                        confirm(itemprice);
                        // then break
                        break;
                    // if ID equal to espresso ID
                    case R.id.espresso:
                        // so set item price = 10
                        itemprice = 10;
                        // calling confirm method and pass item price as a parameter to it
                        confirm(itemprice);
                        // then break
                        break;
                }
            }
        });
    }
}
