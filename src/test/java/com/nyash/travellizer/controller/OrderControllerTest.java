package com.nyash.travellizer.controller;

import com.nyash.travellizer.TravellizerApplication;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

@SpringJUnitWebConfig(TravellizerApplication.class)
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class OrderControllerTest {

}
