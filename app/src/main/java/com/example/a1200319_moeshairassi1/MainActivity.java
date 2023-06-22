package com.example.a1200319_moeshairassi1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.a1200319_moeshairassi1.modle.Cuboid;
import com.example.a1200319_moeshairassi1.modle.Cylinder;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    public static final String FORMEL ="Formel";

    private boolean flagg = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView formula = findViewById(R.id.formula);
        TextView tv1 = findViewById(R.id.entry1);
        TextView tv2 = findViewById(R.id.entry2);
        TextView tv3 = findViewById(R.id.entry3);

        final int[] flag = {0};

        EditText et1 = findViewById(R.id.tf1);
        EditText et2 = findViewById(R.id.tf2);
        EditText et3 = findViewById(R.id.tf3);

        TextView result = findViewById(R.id.result);

        result.setVisibility(View.GONE);

        String volFormulaa ="V=whl" ;

        prefs= PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();

        if(!flagg){


            editor.putString(FORMEL,volFormulaa);
            editor.putString("cubWidth","w= V/hl");
            editor.putString("cubLen","l=V/hw");
            editor.putString("cubHei","h=V/lw");

            editor.putString("cylVolume","V=Pi(r^2)h");
            editor.putString("cylRad","r=(V/Pi h)^(1/2)");
            editor.putString("cylHei","h=V/Pi*R^2");

            editor.commit();
        }

        Spinner spinner = findViewById(R.id.spinnerCuboid);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = spinner.getSelectedItem().toString();

                et1.setText("");
                et2.setText("");
                et3.setText("");
                result.setText("");

                if(selectedItem.equals("Volume")){
                    String st = prefs.getString(FORMEL," ");
                    formula.setText(st);
                    tv1.setText("L\tlength");
                    tv2.setText("W\tWidth");
                    tv3.setText("H\tHeight");
                    flag[0] =1;
                }
                else if(selectedItem.equals("Width")){
                    formula.setText(prefs.getString("cubWidth"," "));
                    tv1.setText("L\tlength");
                    tv2.setText("H\tHeight");
                    tv3.setText("V\tVolume");
                    flag[0] =2;
                }
                else if(selectedItem.equals("Length")){
                    formula.setText(prefs.getString("cubLen"," "));
                    tv1.setText("W\tWidth");
                    tv2.setText("H\tHeight");
                    tv3.setText("V\tVolume");
                    flag[0] =3;
                }
                else if(selectedItem.equals("Height")){
                    formula.setText(prefs.getString("cubHei"," "));
                    tv1.setText("L\tlength");
                    tv2.setText("W\tWidth");
                    tv3.setText("V\tVolume");
                    flag[0] =4;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                //formula.setText("V=whl");
            }
        });


        Button button = findViewById(R.id.calculateButton);
        button.setOnClickListener(v->{

            Double n1= Double.parseDouble(et1.getText().toString());
            Double n2 =Double.parseDouble(et2.getText().toString());
            Double n3= Double.parseDouble(et3.getText().toString());

            result.setVisibility(View.VISIBLE);

            if (flag[0]==1){
                //formula.setText("V=whl");
                //Double res = n1*n2*n3;
                Cuboid cuboid = new Cuboid(-1,n1,n2,n3);
                Double res = cuboid.getVolume();
                //result.setText(res.toString());
                result.setText(String.format("%.2f", res));
            }
            else if (flag[0]==2){
                //formula.setText("w= V/hl");
               // Double res = n3/(n1*n2);
                Cuboid cuboid = new Cuboid(n3,n1,-1,n2);
                Double res = cuboid.getWidth();
                result.setText(String.format("%.2f", res));
            }
            else if (flag[0]==3){
                //formula.setText("w= V/hl");
                //Double res = n3/(n1*n2);
                Cuboid cuboid = new Cuboid(n3,-1,n1,n2);
                Double res = cuboid.getLength();
                result.setText(String.format("%.2f", res));
            }
            else if (flag[0]==4){
                //formula.setText("w= V/hl");
                //Double res = n3/(n1*n2);
                Cuboid cuboid = new Cuboid(n3,n1,n2,-1);
                Double res = cuboid.getHeight();
                result.setText(String.format("%.2f", res));
            }
        });

        TextView cyleFormula = findViewById(R.id.cyleFormula);

        TextView cTv1 = findViewById(R.id.cEntry1);
        TextView cTv2 = findViewById(R.id.cEntry2);

        EditText cEt1 = findViewById(R.id.cTf1);
        EditText cEt2 = findViewById(R.id.cTf2);

        TextView cyleResult = findViewById(R.id.cyleResult);
        cyleResult.setVisibility(View.GONE);


        final int[] flag1 ={0};

        Spinner cyleSpinner = findViewById(R.id.spinnerCylinder);

        cyleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = cyleSpinner.getSelectedItem().toString();

                cEt1.setText("");
                cEt2.setText("");
                cyleResult.setText("");

                if(selectedItem.equals("Volume")){

                    cyleFormula.setText(prefs.getString("cylVolume"," "));
                    cTv1.setText("r\tRadius");
                    cTv2.setText("h\tHeight");

                    flag1[0] =1;
                }
                else if (selectedItem.equals("Radius")){
                    cyleFormula.setText(prefs.getString("cylRad"," "));
                    cTv1.setText("h\tHeight");
                    cTv2.setText("V\tVolume");

                    flag1[0] =2;
                }
                else if (selectedItem.equals("Height")){
                    cyleFormula.setText(prefs.getString("cylHei"," "));
                    cTv1.setText("r\tRadius");
                    cTv2.setText("V\tVolume");

                    flag1[0] =3;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });


        Button cyleButton = findViewById(R.id.cyleCalculateButton);
        cyleButton.setOnClickListener(e->{

            cyleResult.setVisibility(View.VISIBLE);

            Double n1= Double.parseDouble(cEt1.getText().toString());
            Double n2 =Double.parseDouble(cEt2.getText().toString());

            if (flag1[0]==1){
                Cylinder cylinder = new Cylinder(-1,n1,n2);
                Double res = cylinder.getVolume();
                cyleResult.setText(String.format("%.2f", res));
            }
            else if (flag1[0]==2){
                Cylinder cylinder = new Cylinder(n2,-1,n1);
                Double res = cylinder.getRadius();
                cyleResult.setText(String.format("%.2f", res));
            }
            else if (flag1[0]==3){
                Cylinder cylinder = new Cylinder(n2,n1,-1);
                Double res = cylinder.getHeight();
                cyleResult.setText(String.format("%.2f", res));
            }
        });
    }
}