package com.luckymahrus.finalsubmission;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        setActionBarTitle("About Me");

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView txtEmail = findViewById(R.id.tv_author_email);
        txtEmail.setOnClickListener(this);

        TextView txtPhone = findViewById(R.id.tv_author_phone);
        txtPhone.setOnClickListener(this);

        TextView txtProjectSource = findViewById(R.id.tv_project_source);
        txtProjectSource.setOnClickListener(this);

        ImageView ivFacebook = findViewById(R.id.iv_facebook_icon);
        ivFacebook.setOnClickListener(this);

        ImageView ivLinkedin = findViewById(R.id.iv_linkedin_icon);
        ivLinkedin.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if(id == android.R.id.home)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.tv_author_phone:
                TextView textPhoneView = findViewById(v.getId());
                String phoneNumber = textPhoneView.getText().toString();
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
                startActivity(dialPhoneIntent);
                break;
            case R.id.tv_author_email:
            TextView textEmailView = findViewById(v.getId());
                String emailAddress = textEmailView.getText().toString();
                Intent sendEmailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto",emailAddress, null));
                startActivity(sendEmailIntent);
                break;
            case R.id.tv_project_source:
                Intent openUrlIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/luckymahrus/FinalSubmission"));
                startActivity(openUrlIntent);
                break;
            case R.id.iv_facebook_icon:
                Intent openFbIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://facebook.com/luckymahrus"));
                startActivity(openFbIntent);
                break;
            case R.id.iv_linkedin_icon:
                Intent openLiIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://id.linkedin.com/in/luckymahrus"));
                startActivity(openLiIntent);
                break;
        }
    }

    private void setActionBarTitle(String title)
    {
        if (getSupportActionBar() != null)
        {
            getSupportActionBar().setTitle(title);
        }
    }
}
