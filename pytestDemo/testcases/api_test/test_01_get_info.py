import pytest
import allure
from testcases.conftest import api_data
from common.logger import logger
import requests
import jsonschema
import jsonpath
from common.json_schema import get_schema_from_file


@allure.step("步骤1 ==>> 获取所有用户信息")
def step_1():
    logger.info("步骤1 ==>> 获取所有用户信息")


@allure.step("步骤1 ==>> 获取某个用户信息")
def step_2(username):
    logger.info("步骤1 ==>> 获取某个用户信息：{}".format(username))


@allure.severity(allure.severity_level.TRIVIAL)
@allure.epic("针对单个接口的测试")
@allure.feature("获取用户信息模块")
class TestGetInfo():
    """获取信息模块"""
    def __init__(self):
        self.url = "xxx.com";

    @allure.story("用例-")
    @allure.description("该用例是针对 的测试")
    @allure.issue("https://jira.com", name="点击，跳转到对应BUG的链接地址")
    @allure.testcase("https://testcase.com", name="点击，跳转到对应用例的链接地址")
    @pytest.mark.single
    @pytest.mark.parametrize("except_result, except_code, except_msg",
                             api_data["test_get_all_user_info"])
    def test_get_all_user_info(self, except_result, except_code):
        logger.info("*************** 开始执行用例 ***************")
        step_1()
        result = requests.get(self.url)
        # print(result.__dict__)
        assert result.status_code == 200
        logger.info("code ==>> 期望结果：{}， 实际结果：{}".format(except_code, result.json().get("code")))
        assert result.json().get("code") == except_code
        logger.info("*************** 结束执行用例 ***************")
        res = jsonpath.jsonpath(result.json(),'$.code')
        schema = get_schema_from_file("../../jsonschema/abc.json")
        jsonschema.validate(result.json(), schema)


if __name__ == '__main__':
    pytest.main(["-q", "-s", "test_01_get_info.py"])
