package com.luckymahrus.finalsubmission;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.luckymahrus.finalsubmission.adapter.ListProjectAdapter;
import com.luckymahrus.finalsubmission.model.Project;
import com.luckymahrus.finalsubmission.model.ProjectsData;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity
{
    private RecyclerView rvProjects;
    private ArrayList<Project> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActionBarTitle("Lucky Mahrus Portofolio");

        rvProjects = findViewById(R.id.rv_projects);
        rvProjects.setHasFixedSize(true);

        list.addAll(ProjectsData.getProjectListData());
        showRecyclerList();
    }

    private void showRecyclerList(){

        rvProjects.setLayoutManager(new LinearLayoutManager(this));
        ListProjectAdapter listProjectAdapter = new ListProjectAdapter(list);
        rvProjects.setAdapter(listProjectAdapter);

        listProjectAdapter.setOnItemClickCallback(new ListProjectAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Project data) {
                showSelectedProject(data);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode)
    {
        switch (selectedMode)
        {
            case R.id.menu_about:
                Intent aboutIntent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(aboutIntent);
                break;
        }
    }

    private void showSelectedProject(Project project)
    {
        Intent projectDetailsIntent = new Intent(MainActivity.this, ProjectDetailsActivity.class);
        projectDetailsIntent.putExtra("EXTRA_PROJECTID", project.getProjectId());
        projectDetailsIntent.putExtra("EXTRA_PROJECTNAME", project.getProjectName());
        startActivity(projectDetailsIntent);

        /*switch (project.getProjectId())
        {
            case "0":
                Toast.makeText(this, "Kamu memilih " + project.getProjectName(), Toast.LENGTH_SHORT).show();
                // Intent aboutIntent = new Intent(MainActivity.this, AboutActivity.class);
                // startActivity(aboutIntent);
                break;
        }*/
    }

    private void setActionBarTitle(String title)
    {
        if (getSupportActionBar() != null)
        {
            getSupportActionBar().setTitle(title);
        }
    }
}