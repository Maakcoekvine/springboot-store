package com.coek.controller;

import com.coek.domain.District;
import com.coek.service.DistrictService;
import com.coek.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author:MaakcoekVine
 * @Date:2022-01-24 20:24:37
 */
@RestController
@RequestMapping("districts")
public class DistrictController extends BaseController{

    @Autowired
    private DistrictService districtService;

    @RequestMapping({"/",""})
    public JsonResult getAllParent(@RequestParam("parent") String parent){
        List<District> allParent = districtService.getAllParent(parent);

        return new JsonResult(OK,allParent);
    }
}
