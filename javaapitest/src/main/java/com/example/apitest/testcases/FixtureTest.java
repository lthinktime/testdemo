package com.example.apitest.testcases;

import org.testng.annotations.*;

import static io.qameta.allure.Allure.step;
public class FixtureTest {
    @BeforeGroups
    public void beforeGroups() {
        step("Step inside beforeGroups");
    }

    @BeforeSuite
    public void beforeSuite() {
        step("Step inside beforeSuite");
    }

    @BeforeClass
    public void beforeClass() {
        step("Step inside beforeClass");
    }

    @BeforeTest
    public void beforeTest() {
        step("Step inside beforeTest");
    }

    @BeforeMethod
    public void beforeMethod() {
        step("Step inside beforeMethod");
    }

    @Test
    public void Test1() {
        step("Step inside allureFixtureTest");
    }

    @Test
    public void Test2() {
        step("Step inside allureFixtureTest2");
    }

    @AfterMethod
    public void afterMethod() {
        step("Step inside afterMethod");
    }

    @AfterTest
    public void afterTest() {
        step("Step inside afterTest");
    }

    @AfterClass
    public static void afterClass() {
        step("Step inside afterClass");
    }

    @AfterSuite
    public void afterSuite() {
        step("Step inside afterSuite");
    }

    @AfterGroups
    public void afterGroups() {
        step("Step inside afterGroups");
    }

}
