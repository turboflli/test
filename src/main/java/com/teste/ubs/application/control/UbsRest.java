package com.teste.ubs.application.control;

import com.teste.ubs.application.model.UbsEntity;
import com.teste.ubs.application.repositories.UbsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/v1")
public class UbsRest {

    @Autowired
    private UbsRepository ubsRepository;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(@RequestParam(required = true, value = "querry") String test) {
        return test;
    }

    @RequestMapping( value = "/find_ubs", method = RequestMethod.GET)
    public Page getUbs(@RequestParam(required = true, value = "querry") String coordenates,
                         @RequestParam(required = true) Integer page,
                @RequestParam(required = false, defaultValue = "10", value = "per_page") Integer pageSize){

        String[] coordenatesSplited = coordenates.split(",");
        Double lon = Double.parseDouble(coordenatesSplited[0]);
        Double lat = Double.parseDouble(coordenatesSplited[1]);
        Pageable paging = PageRequest.of(page, pageSize);
        Page<UbsEntity> response = ubsRepository.findByDistance(lon, lat, paging  );
        return response;
    }
}
