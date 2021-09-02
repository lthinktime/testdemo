package com.example.apitest.testcases;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers.*;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class ParameterizedTest {
    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
        return new Object[][]{{"First Name"}, {"Second Name"}};

    }

    @Test(description = "ParameterizedTest", dataProvider = "data-provider")
    @Parameters({"testParam"})
    @Description("ParameterizedTest")
    public void parameterizedTest(String testParam) {
        step("Step inside parameterized test");
        step("Test parameter: " + testParam);
        Assert.assertEquals(1, 1);

    }

    @Test
    public void FakeParameterizedTest() {
        parameter("fakeParam", "fakeValue");
        step("Step inside fake parameterized test");
    }

    @Test
    public void testGetHtml() {
        given().get("http://www.baidu.com").then().statusCode(200);
    }

    @Test
    public void getHttpTest() {
        Response response = given()
                .get("http://www.jianshu.com/users/recommended?seen_ids=&count=5&only_unfollowed=true");
        // 打印出 response 的body
        response.print();
    }

    @Test()
    public void getHttpsTest() {
        Response response =given()
                // 配置SSL 让所有请求支持所有的主机名

                .config((RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation())))
                .params("q", "自动化测试", "start", 0, "count", 2)
                 //"{"msg":"apikey is required(218.75.34.154). Please contact bd-team@douban.com for authorized access.","code":131,"request":"GET \/v2\/book\/search"}"
                .get("https://api.douban.com/v2/book/search");
        response.then().assertThat().body("code",equalTo(131));
        response.getBody().jsonPath().getString("code");
        //jsonschema 校验
        response.then().assertThat().body(matchesJsonSchemaInClasspath("d.json"));

    }
}
