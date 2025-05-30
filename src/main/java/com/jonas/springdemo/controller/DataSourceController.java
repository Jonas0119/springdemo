package com.jonas.springdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

@Controller
@RequestMapping("/config")
public class DataSourceController {

    @Value("${app.datasource.type}")
    private String currentDataSourceType;

    @GetMapping
    public String showConfig(Model model) {
        model.addAttribute("currentDataSourceType", currentDataSourceType);
        return "config/datasource";
    }

    @PostMapping("/datasource")
    public String changeDataSource(@RequestParam("type") String type) {
        try {
            // 获取application.properties文件路径
            Path path = Paths.get("src/main/resources/application.properties");
            
            // 读取现有属性
            Properties props = new Properties();
            props.load(Files.newInputStream(path));
            
            // 更新数据源类型
            props.setProperty("app.datasource.type", type);
            
            // 保存更新后的属性
            try (FileOutputStream out = new FileOutputStream(path.toFile())) {
                props.store(out, "Updated datasource type");
            }
            
            return "redirect:/config?success=true";
        } catch (IOException e) {
            e.printStackTrace();
            return "redirect:/config?error=true";
        }
    }
}