package com.teknodate.smekyayinlari;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class Anasayfa extends AppCompatActivity {

    public EditText barkod,kitap;
    public Button kaydetBtn;
    public ListView liste;

    public Veritabani vt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anasayfa);

        barkod=findViewById(R.id.barkod);
        kitap=findViewById(R.id.kitap);

        kaydetBtn=findViewById(R.id.kaydet);

        liste=findViewById(R.id.kitapListesi);

         vt = new Veritabani(getApplicationContext(),null,1);

        kaydetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String barkodNo= barkod.getText().toString();
                String kitapAdi=kitap.getText().toString();

                Kitap yeniKitap = new Kitap(barkodNo,kitapAdi);

                vt.yeniKitapKaydet(yeniKitap);

                Toast.makeText(Anasayfa.this, "Kitap Kaydedildi.", Toast.LENGTH_SHORT).show();



            }
        });

        List<Kitap> veriler = vt.kitaplariGetir();
 OzelAdapter adaptor = new OzelAdapter(Anasayfa.this,veriler);

 liste.setAdapter(adaptor);
    }
}
