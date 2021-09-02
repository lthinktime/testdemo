package com.example.apitest.testcases;

import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Stories;
import io.qameta.allure.model.Status;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
@Feature("Feature")
public class SimpleTest {
    @Test(description = "this is desc")
    public void newtest() {
        step("step");
        step(" step with status", Status.FAILED);
        step(" lambda step", () -> {
            step(" step inside lambda step");
        });
        testMethod("method parameter");
    }

    @Step("test method with step annotation")
    public void testMethod(String param) {
        step("Method parameter:" + param);
        step("step inside test method");
    }
}
