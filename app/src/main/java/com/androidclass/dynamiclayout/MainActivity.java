package com.androidclass.dynamiclayout;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.androidclass.model.Stock;
import com.androidclass.model.StockService;


public class MainActivity extends Activity implements OnClickListener{


    private StockService sc;
    private static final String TAG = MainActivity.class.getSimpleName();


    LinearLayout mainLayout = null;

    LayoutParams lblSymbolParams, symbolParams;
    TextView lblSymbol;
    EditText symbol;


    LayoutParams btnShowStockParams;
    Button btnShowStock;

    LayoutParams lblNameParams, nameValueParams;
    TextView lblName ;
    TextView nameValue ;

    LayoutParams lblPriceParams, priceValueParams;
    TextView lblPrice;
    TextView priceValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sc = new StockService();

        mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);

        // label for symbol
        lblSymbolParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lblSymbol = new TextView(this.getApplicationContext());
        lblSymbol.setLayoutParams(lblSymbolParams);
        lblSymbol.setText("Enter Symbol:");
        lblSymbol.setTextColor(Color.RED);
        lblSymbol.setTextSize(20);

        //enter the symbol
        symbolParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        symbol = new EditText(this.getApplicationContext());
        symbol.setLayoutParams(symbolParams);
        symbol.setTextColor(Color.BLACK);
        symbol.setTextSize(20);

        //  symbol.setFocusable(false);

        //click the button
        btnShowStockParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        btnShowStock = new Button(this.getApplicationContext());
        btnShowStock.setLayoutParams(btnShowStockParams);
        btnShowStock.setOnClickListener(this);
        btnShowStock.setText("Display Stock");

        // label for name
        lblNameParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lblName = new TextView(this.getApplicationContext());
        lblName.setLayoutParams(lblNameParams);
        lblName.setText("Company:");
        lblName.setTextSize(20);
        lblName.setTextColor(Color.BLUE);

        //  name
        nameValueParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        nameValue = new TextView(this.getApplicationContext());
        nameValue.setLayoutParams(nameValueParams);
        nameValue.setText("None");
        nameValue.setTextSize(25);
        nameValue.setTextColor(Color.BLACK);
        nameValue.setTextSize(20);

        // label for price
        lblPriceParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lblPrice = new TextView(this.getApplicationContext());
        lblPrice.setLayoutParams(lblPriceParams);
        lblPrice.setText("Price:");
        lblPrice.setTextSize(20);
        lblPrice.setTextColor(Color.BLUE);

        //  price
        priceValueParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        priceValue = new TextView(this.getApplicationContext());
        priceValue.setLayoutParams(priceValueParams);
        priceValue.setText("0.0");
        priceValue.setTextSize(25);
        priceValue.setTextColor(Color.BLACK);
        priceValue.setTextSize(20);

        mainLayout.addView(lblSymbol);
        mainLayout.addView(symbol);
        mainLayout.addView(btnShowStock);
        mainLayout.addView(lblName);
        mainLayout.addView(nameValue);
        mainLayout.addView(lblPrice);
        mainLayout.addView(priceValue);



        setContentView(mainLayout);

        // setContentView(R.layout.activity_main);
    }




    @Override
    public void onClick(View v) {


        String st = symbol.getText().toString().toUpperCase();
        Log.d(TAG, "button click: " + st);

        if (st !=null) {
            Stock stk = (Stock) sc.get(st);
            if (stk !=null) {
                nameValue.setText(stk.getName());
                priceValue.setText(stk.getPrice().toString());
            }else {
                nameValue.setText("Not Found");
                priceValue.setText("0.0");

            }

        }

    }


}