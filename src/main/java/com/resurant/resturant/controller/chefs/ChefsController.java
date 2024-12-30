package com.resurant.resturant.controller.chefs;


import com.resurant.resturant.dto.ChefsDto;
import com.resurant.resturant.service.chefs.ChefsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chefs")
public class ChefsController {
@Autowired
    private ChefsService chefsService;
@GetMapping("get_all_chefs")
public ResponseEntity<List<ChefsDto>> getAllChefsC(){
    return ResponseEntity.ok(chefsService.getAllChefsService());
}
}
