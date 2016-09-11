package id.sch.smktelkom_mlg.tugas01.xiirpl2002.inputpenduduk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNama;
    EditText etTTL;
    EditText etAL;
    Button bOK;
    RadioGroup rgStatus;
    Spinner umur;
    CheckBox cbBM, cbM,cbL;
    TextView tvHasil, tvHasil2, tvHasil3, tvHasil4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etTTL = (EditText) findViewById(R.id.editTextTTL);
        etAL = (EditText) findViewById(R.id.editTextAL);
        bOK = (Button) findViewById(R.id.buttonOK);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        tvHasil2 = (TextView) findViewById(R.id.textViewHasil2);
        cbBM = (CheckBox) findViewById(R.id.checkBoxBM);
        cbM = (CheckBox) findViewById(R.id.checkBoxM);
        cbL = (CheckBox) findViewById(R.id.checkBoxL);
        rgStatus = (RadioGroup) findViewById(R.id.radioGroupStatus);
        umur = (Spinner) findViewById(R.id.spinnerU);
        tvHasil3 = (TextView) findViewById(R.id.textViewHasil3);
        tvHasil4 = (TextView) findViewById(R.id.textViewHasil4);

        findViewById(R.id.buttonOK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });
    }

        /*bOK.setOnClickListener(new View.OnClickListener() {//spinner e
            @Override
            public void onClick(View view) {
                doClick();//tak komen diluko

            }
        });
    }*/

    private void doClick() {
        String hasil = null;

        if(rgStatus.getCheckedRadioButtonId()!=-1)
        {
            RadioButton rb = (RadioButton)
                    findViewById(rgStatus.getCheckedRadioButtonId());
            hasil = rb.getText().toString();
        }
        if(hasil == null)
        {
            tvHasil2.setText("Tidak ada pilihan");
        }
        else
        {
            tvHasil2.setText("Jenis Kelamin : " + hasil);
        }
        if(isValid());
        String nama = etNama.getText().toString();
        String ttl = etTTL.getText().toString();
        String al = etAL.getText().toString();
        tvHasil.setText("Nama : "+nama + "\n" +"TTL : "+ttl + "\n" +"Alamat : "+al);



        tvHasil3.setText("Umur : "+ umur.getSelectedItem().toString());
        String hasil2 = "Status :\n";
        int startlen = hasil2.length();
        if(cbBM.isChecked())hasil2+=cbBM.getText()+"\n";
        if(cbM.isChecked())hasil2+=cbM.getText()+"\n";
        if(cbL.isChecked())hasil2+=cbL.getText()+"\n";

        if(hasil2.length()==startlen) hasil2+="Tidak ada pilihan";

    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String ttl = etNama.getText().toString();
        String al = etNama.getText().toString();

        if(nama.isEmpty())
        {
            etNama.setError("Kolom belum diisi");
            valid = false;
        }
        else if(ttl.isEmpty())
        {
            etTTL.setError("Kolom belum diisi");
            valid = false;
        }
        else if(al.isEmpty())
        {
            etAL.setError("Kolom belum diisi");
            valid = false;
        }
        else
        {
            etNama.setError(null);
        }
        return valid;
    }

    private void doProcess() {
        /*String nama = etNama.getText().toString();
        String ttl = etTTL.getText().toString();
        String al = etAL.getText().toString();
        tvHasil.setText("Nama : "+nama + "\n" +"TTL : "+ttl + "\n" +"Alamat : "+al
        +"\n"+"Jenis Kelamin : ");*/

    }
}
