package com.luckymahrus.finalsubmission.model;

import java.util.ArrayList;

public class ProjectsData
{
    public static String[][] data = new String[][]
    {
        {"0", "U-Reporting Tools", "https://reporting.u-campaigns.nl/", "https://reporting.u-campaigns.nl/assets/img/logos/u-logo.png"},
        {"1", "CTOUCH Partner Portal", "https://partners.ctouch.eu/", "https://partners.ctouch.eu/assets/images/greylogo.png"},
        {"2", "ZorgBeuningan 0-4", "https://0-4.zorgbeuningen.nl/", "https://0-4.zorgbeuningen.nl/assets/default/images/logo/logo.jpg"},
        {"3", "ZorgBeuningan 4-12", "https://4-12.zorgbeuningen.nl/", "https://4-12.zorgbeuningen.nl/assets/default/images/logo/logo.jpg"},
        {"4", "Argos", "https://www.argos.nl/", "https://www.argos.nl/wp-content/themes/argos/images/logo.png"},
        {"5", "Phimex", "https://phimex.nl/", "https://phimex.nl/wp-content/themes/phimex/assets/img/logo.png"},
        {"6", "Lollypop PreSchool", "https://www.lollypoppreschoolmenteng.com/", "https://www.lollypoppreschoolmenteng.com/wp-content/uploads/2019/03/LOGO-MENTENG-150x150.png"},
        {"7", "Sekolah Lentera Kasih", "http://lenterakasih.org/", "http://lenterakasih.org/images/logo.png"},
        {"8", "New Telaga Niaga", "https://newtelaganiaga.com/", "https://newtelaganiaga.com/assets/img/logo/logo-small.png"},
        {"9", "Soto Afung", "https://sotoafung.com/", "https://sotoafung.com/assets/img/logo/logo.png"},
    };

    public static ArrayList<Project> getProjectListData()
    {
        ArrayList<Project> list = new ArrayList<>();
        for (String[] aData : data)
        {
            Project project = new Project();
            project.setProjectId(aData[0]);
            project.setProjectName(aData[1]);
            project.setProjectUrl(aData[2]);
            project.setCompanyLogo(aData[3]);
            list.add(project);
        }
        return list;
    }
}