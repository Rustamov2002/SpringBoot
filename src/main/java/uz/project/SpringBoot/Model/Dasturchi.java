package uz.project.SpringBoot.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Dasturchi {
    private int id;
    private String ism;
    private String  familya;
    private String lavozim;
    private double maosh;
    //private int T_yil;
}
