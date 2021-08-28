export class HomePo {
    getPageTitle() {
        return cy.title();
      }
    goToSearch(value){
        cy.get("#kw").type(value)
        cy.get("#su").click()
    }
    

}