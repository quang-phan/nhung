package com.example.demo;

import com.example.demo.model.DuLieu;
import com.example.demo.service.MyService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Controller
public class MyController {
    private int dem = 0;
    @Autowired
    private MyService myService;

    @GetMapping("")
    String index(){

        return "index";
    }

    @GetMapping("/getdata")
    @ResponseBody
    String getDem(){
        List<DuLieu> list = myService.getData();
        System.out.println(list.toString());
        return new Gson().toJson(list);
    }

    @GetMapping("/addinfo")
    @ResponseBody
    String addData(@RequestParam(name = "temp") int temp,
                   @RequestParam(name = "humi") int humi,
                   @RequestParam(name = "ldr") int ldr){
        DuLieu duLieu = new DuLieu();
        Date date = new Date();

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        duLieu.setNhietDo(temp+"");
        duLieu.setDoAm(humi+"");
        duLieu.setGiaTri(ldr+"");
        duLieu.setThoiGian(format.format(date));

        System.out.println(duLieu.toString());
        if(myService.addValue(duLieu))
            return "OK";

        return "FALSE";
    }
}
