package com.example.mythreedimensionalland.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bjingban
 * @date 2026-09-27 23:15
 */
@RestController
@RequestMapping("cube")
public class CubeSeetingsController {

    @GetMapping(value = "get",produces = "application/json")
    public String cubeSeetings() {
        return cubeSeetings;
    }

    private String cubeSeetings ="""
            {
            "position": { "x": 2, "y": 1, "z": 0 },
            "color": "#ff8800"
            }
            """;
}
