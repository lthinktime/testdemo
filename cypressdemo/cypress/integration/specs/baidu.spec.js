import {HomePo} from '../page-objects/home.po';

describe('百度测试',function(){
    let homePage;

    this.beforeEach(()=>{
    homePage = new HomePo();
    cy.visit(Cypress.config().baseUrl);
    })
    it("百度输入测试",function(){
        homePage.getPageTitle().should("contain","百度");
        homePage.goToSearch('hello');
    })
})