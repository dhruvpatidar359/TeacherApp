package com.example.book_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.example.book_app.databinding.ActivityPdfViewerBinding;

import es.voghdev.pdfviewpager.library.RemotePDFViewPager;
import es.voghdev.pdfviewpager.library.adapter.PDFPagerAdapter;
import es.voghdev.pdfviewpager.library.remote.DownloadFile;


public class PdfViewer extends AppCompatActivity implements DownloadFile.Listener {
    ActivityPdfViewerBinding binding;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPdfViewerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        progressDialog =new ProgressDialog(this);
        progressDialog.setTitle("loading");
        progressDialog.setMessage("wait while the loading completes");
        progressDialog.show();
        String url = getIntent().getStringExtra("url");
        RemotePDFViewPager remotePDFViewPager =
                new RemotePDFViewPager(PdfViewer.this, url, this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);





    }

    @Override
    public void onSuccess(String url, String destinationPath) {
        progressDialog.dismiss();
        PDFPagerAdapter adapter = new PDFPagerAdapter(this, extractSubstringFromString(url));
       binding.pdfViewPager.setAdapter(adapter);


    }
    public static String  extractSubstringFromString(String url){

        return url.substring(url.lastIndexOf('/')+1);

    }


    @Override
    public void onFailure(Exception e) {

    }

    @Override
    public void onProgressUpdate(int progress, int total) {

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}