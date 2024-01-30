package com.loop.step_definitions;

import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.Driver;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

public class T_Day16_DocuportStepDefs {

    @Then("user validates all accessible fields on the left panel for his usertype")
    public void user_validates_all_accessible_fields_on_the_left_panel_for_his_usertype(Map<String, List<String>> map) {

        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            Driver.getDriver().get(ConfigurationReader.getProperty("env"));


        }
    }

}
