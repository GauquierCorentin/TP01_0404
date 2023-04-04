package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class BankManagerSteps {

    private BankManager bankManager;
    private double montant;

    /*Depot*/

    @Given("je suis sur la page de depot avec un {double} dans mon compte")
    public void jesuissurlapagedepot(double solde){
        System.out.println("page depot");
        bankManager = new BankManager();
        bankManager.create(1);
    }

    @When("je remplis le champ avec un {double}")
    public void jeremplislechamp(double mont){
        System.out.println("je remplis");
        montant = mont;
    }

    @And("je clique sur Deposer")
    public void jecliquesurdeposer(){
        System.out.println("je clique");
        bankManager.deposit(1,montant);
    }

    @Then("je devrais voir un message de depot effectue avec succes et le solde {double}")
    public void jedevraisvoirunmessage(double solde){
        System.out.println(bankManager.getBalance(1));
        assertEquals(solde, bankManager.getBalance(1), 0);
    }

    /*Retrait*/

    @Given("je suis sur la page de retrait avec un {double} dans mon compte")
    public void jesuissurlapagederetrait(double solde){
        System.out.println("page retrait");
        bankManager = new BankManager();
        bankManager.create(1);
        bankManager.deposit(1,solde);
    }

    @When("je remplis le champ de retrait avec un {double}")
    public void jeremplislechampretrait(double mont){
        System.out.println("je remplis");
        montant = mont;
    }

    @And("je clique sur Retirer")
    public void jecliquesurretirer(){
        System.out.println("je clique");
        bankManager.withdraw(1,montant);
    }

    @And("je clique sur Retirer avec trop")
    public void jecliquesurretireravectrop(){
        System.out.println("je clique");
        assertThrows(IllegalArgumentException.class, () -> {
            bankManager.withdraw(1,montant);
        });
    }

    @Then("je devrais voir un message de retrait effectue avec succes et le solde {double} ou un message d'erreur")
    public void jedevraisvoirunmessageretrait(double solde){
        System.out.println(bankManager.getBalance(1));
        assertEquals(solde, bankManager.getBalance(1), 0);
    }

    /*Crea depot*/

    @Given("je creer un compte 1 avec un solde de 1000")
    public void creadepotCrea(){
        bankManager= new BankManager(1,1000);
    }

    @When("je depose 500 sur le compte 1")
    public void creadepotDeposit(){
        bankManager.deposit(1,500);
    }

    @Then("le solde du compte 1 est 1500")
    public void creadepotCheckSolde() {
        assertEquals(1500, bankManager.getBalance(1),0);
    }

}
