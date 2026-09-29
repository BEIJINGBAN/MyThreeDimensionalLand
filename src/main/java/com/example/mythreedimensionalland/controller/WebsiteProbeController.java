package com.example.mythreedimensionalland.controller;

import com.example.mythreedimensionalland.service.WebsiteProbeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author bjingban
 * @date 2026-09-29 23:45
 */

@RestController
@RequestMapping("NetWorkLag")
public class WebsiteProbeController {

    @Autowired
    WebsiteProbeService websiteProbeService;

    @GetMapping("get")
    public void get() throws IOException, InterruptedException {
        websiteProbeService.get();
    }
}
