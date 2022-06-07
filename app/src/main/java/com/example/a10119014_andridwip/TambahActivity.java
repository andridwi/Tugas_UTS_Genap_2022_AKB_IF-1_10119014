package com.example.a10119014_andridwip;
//*Nama : Andri Dwi P
//NIM : 10119014
//kelas: IF-1

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TambahActivity extends AppCompatActivity {
    private EditText etJudul, etPenulis, etIsi, etTahun;
    private Button btnSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        etJudul = findViewById(R.id.et_judul);
        etPenulis = findViewById(R.id.et_penulis);
        etIsi = findViewById(R.id.et_isi);
        etTahun = findViewById(R.id.et_tahun);
        btnSimpan = findViewById(R.id.btn_simpan);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getJudul = etJudul.getText().toString();
                String getPenulis = etPenulis.getText().toString();
                String getIsi = etIsi.getText().toString();
                String getTahun = etTahun.getText().toString();

                if(getJudul.trim().equals("")) {
                    etJudul.setError("Judul Tidak Boleh Kosong");
                } else if (getPenulis.trim().equals("")) {
                    etPenulis.setError("Kategori Tidak Boleh Kosong");
                } else if (getIsi.trim().equals("")) {
                    etIsi.setError("Isi Tidak Boleh Kosong");
                } else if (getTahun.trim().equals("")) {
                    etTahun.setError("Tanggal Tidak Boleh Kosong");
                }
                else{
                    MyDatabaseHelper myDB = new MyDatabaseHelper(TambahActivity.this);
                    long eksekusi = myDB.tambahBuku(getJudul, getPenulis, getPenulis, Integer.valueOf(getTahun));

                    if(eksekusi == -0 ){
                        Toast.makeText(TambahActivity.this, "Gagagl Menambah Data", Toast.LENGTH_SHORT).show();
                        etJudul.requestFocus();
                    }
                    else {
                        Toast.makeText(TambahActivity.this, "Tambah Data Berhasil", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(TambahActivity.this, MainActivity.class));
                        finish();
                    }
                }

            }
        });
    }
}