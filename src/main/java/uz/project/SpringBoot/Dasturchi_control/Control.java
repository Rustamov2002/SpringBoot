package uz.project.SpringBoot.Dasturchi_control;

import org.springframework.web.bind.annotation.*;
import uz.project.SpringBoot.Model.Dasturchi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class Control {

    List<Dasturchi> dasturchiList=new ArrayList<>(
            Arrays.asList(
                    new Dasturchi(1,"Davronbek","Rustamov","Middle",400),
                    new Dasturchi(2,"Bahrom","Kizilbiyev","Senyor",350),
                    new Dasturchi(3,"Aliyev","Vali","Junyor",200)
            )
    );

    @RequestMapping(value = "/Dastuechi_All_info",method = RequestMethod.GET)
    public List<Dasturchi> Dasturchi_info(){

        return dasturchiList;
    }

    @RequestMapping(value = "/isim_teng_bolmasa_qush/{ism}",method = RequestMethod.POST)
    public String Qoshish(@PathVariable String ism, @RequestBody Dasturchi dasturchi){
        for (Dasturchi dasturchi1 : dasturchiList) {
            if (dasturchi.getIsm()!=ism){
                dasturchi.setId(dasturchiList.size()+1);
                dasturchiList.add(dasturchi);
                return "malimot qushilid ---";
                // break;

            }
            //if (!(dasturchi1.setIsm(dasturchi.getIsm())=ism))
        }
        return ism+ " mavjud";
    }

    @RequestMapping(value = "/getTaxrirlash2",method = RequestMethod.POST)  //taxrirlash
    public String Taxrirlash2(@RequestBody Dasturchi dasturchi){
        for (Dasturchi dasturchi_info : dasturchiList) {
            if (dasturchi_info.getIsm().equals(dasturchi.getIsm()) && dasturchi_info.getFamilya().equals(dasturchi.getFamilya()) ) {
                return "  Bunday malumot bor ";
            }
        }
        dasturchi.setId(dasturchiList.size()+1);
        dasturchiList.add(dasturchi);
        return "-Dasturchi malumotlari joylandi";
    }



    @RequestMapping(value = "/edit_info/{id}", method = RequestMethod.PUT)
    public String edit_info(@PathVariable Integer id, @RequestBody Dasturchi dasturchi){
        for (Dasturchi dasturchi1 : dasturchiList) {
            if(dasturchi1.getId()==id){
                if(dasturchi.getIsm()==""){
                    dasturchi.setIsm(dasturchi1.getIsm());
                }
                else{
                    dasturchi1.setIsm(dasturchi.getIsm());
                }
                if(dasturchi.getFamilya()==""){
                    dasturchi.setFamilya(dasturchi1.getFamilya());
                }
                else{
                    dasturchi1.setFamilya(dasturchi.getFamilya());
                }
                if(dasturchi.getLavozim()==""){
                    dasturchi.setLavozim(dasturchi1.getLavozim());
                }
                else{
                    dasturchi1.setLavozim(dasturchi.getLavozim());
                }
                if(dasturchi.getMaosh()==0){
                    dasturchi.setMaosh(dasturchi1.getMaosh());
                }
                else{
                    dasturchi1.setMaosh(dasturchi.getMaosh());
                }
                return id + "dasturchi malumotlari tahrirlandi";
            }
        }
        return id + " bundan idli malumot topilmadi";

    }

}
