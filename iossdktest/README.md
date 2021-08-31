# iOS SDK 自动化测试
必备框架
https://github.com/kif-framework/KIF
https://github.com/xcpretty/xcpretty
Allure 

`xcodebuild -workspace XXX.xcworkspace \
-scheme XXXTest test \
-sdk "iphonesimulator13.5" \
-destination platform='iOS Simulator',OS=13.5,name='iPhone 11' \
| xcpretty --report junit`


`allure serve  build/reports`

测试完成生成allure测试报告

