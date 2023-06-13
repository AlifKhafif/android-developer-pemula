package com.luckymahrus.finalsubmission;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class ProjectDetailsActivity extends AppCompatActivity {

    ViewFlipper v_flipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String projectId,projectName;
            if (savedInstanceState == null)
        {
            Bundle extras = getIntent().getExtras();
            if(extras == null)
            {
                projectId = "";
                projectName = "";
            }
            else
            {
                projectId = extras.getString("EXTRA_PROJECTID");
                projectName = extras.getString("EXTRA_PROJECTNAME");
            }
        }
        else
        {
            projectId = (String) savedInstanceState.getSerializable("EXTRA_PROJECTID");
            projectName = (String) savedInstanceState.getSerializable("EXTRA_PROJECTNAME");
        }

        ArrayList<Integer> images = new ArrayList<>();
        //int[] images;
        switch (projectId)
        {
            case "0":
                setContentView(R.layout.details_0);

                images.add(R.drawable.reporting0_resize);
                images.add(R.drawable.reporting1_resize);
                images.add(R.drawable.reporting2_resize);

                break;
            case "1":
                setContentView(R.layout.details_1);

                images.add(R.drawable.ctouchpp0_resize);
                images.add(R.drawable.ctouchpp1_resize);
                images.add(R.drawable.ctouchpp2_resize);

                break;
            case "2":
                setContentView(R.layout.details_2);

                images.add(R.drawable.zb040_resize);
                images.add(R.drawable.zb041_resize);
                images.add(R.drawable.zb042_resize);

                break;
            case "3":
                setContentView(R.layout.details_3);

                images.add(R.drawable.zb4120_resize);
                images.add(R.drawable.zb4121_resize);
                images.add(R.drawable.zb4122_resize);

                break;
            case "4":
                setContentView(R.layout.details_4);

                images.add(R.drawable.argos0_resize);
                images.add(R.drawable.argos1_resize);
                images.add(R.drawable.argos2_resize);

                break;
            case "5":
                setContentView(R.layout.details_5);

                images.add(R.drawable.phimex0_resize);
                images.add(R.drawable.phimex1_resize);
                images.add(R.drawable.phimex2_resize);

                break;
            case "6":
                setContentView(R.layout.details_6);

                images.add(R.drawable.lollypop0_resize);
                images.add(R.drawable.lollypop1_resize);
                images.add(R.drawable.lollypop2_resize);

                break;
            case "7":
                setContentView(R.layout.details_7);

                images.add(R.drawable.lentera0_resize);
                images.add(R.drawable.lentera1_resize);
                images.add(R.drawable.lentera2_resize);

                break;
            case "8":
                setContentView(R.layout.details_8);

                images.add(R.drawable.ntn0_resize);
                images.add(R.drawable.ntn1_resize);
                images.add(R.drawable.ntn2_resize);

                break;
            case "9":
                setContentView(R.layout.details_9);

                images.add(R.drawable.afung0_resize);
                images.add(R.drawable.afung1_resize);
                images.add(R.drawable.afung2_resize);

                break;
        }

        if(images.isEmpty() == false)
        {
            v_flipper = findViewById(R.id.vf_project_screenshots);

            for(int image:images)
            {
                flipperImages(image);
            }

        }
        //for(int i=0;i<projectScreenshots)

        setActionBarTitle(projectName);
        //Toast.makeText(this, "Kamu memilih " + projectName, Toast.LENGTH_SHORT).show();

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void flipperImages(int image)
    {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000);
        v_flipper.setAutoStart(true);

        v_flipper.setInAnimation(this,android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this,android.R.anim.slide_out_right);
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

    private void setActionBarTitle(String title)
    {
        if (getSupportActionBar() != null)
        {
            getSupportActionBar().setTitle(title);
        }
    }
}
