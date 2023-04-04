Feature: Deposer Argent

  @Depot
  Scenario Outline: Deposer avec succes
    Given je suis sur la page de depot avec un <solde> dans mon compte
    When je remplis le champ avec un <montant>
    And je clique sur Deposer
    Then je devrais voir un message de depot effectue avec succes et le solde <attendue>
    Examples:
      | solde | montant | attendue |
      | 0     | 100     | 100      |
      | 0     | 2000    | 2000     |


  @Retrait
  Scenario Outline: Retirer avec succes
    Given je suis sur la page de retrait avec un <solde> dans mon compte
    When je remplis le champ de retrait avec un <montant>
    And je clique sur Retirer
    Then je devrais voir un message de retrait effectue avec succes et le solde <attendue> ou un message d'erreur
    Examples:
      | solde | montant | attendue |
      | 100    | 0      | 100      |
      | 2000   | 2000   | 0        |


  @ErrorRetrait
  Scenario Outline: Retirer Error
    Given je suis sur la page de retrait avec un <solde> dans mon compte
    When je remplis le champ de retrait avec un <montant>
    And je clique sur Retirer avec trop
    Then je devrais voir un message de retrait effectue avec succes et le solde <attendue> ou un message d'erreur
    Examples:
      | solde | montant | attendue |
      | 0     | 100     | 0        |
      | 20    | 30      | 20       |



  @CreaDepot
  Scenario: Crea depot
    Given je creer un compte 1 avec un solde de 1000
    When je depose 500 sur le compte 1
    Then le solde du compte 1 est 1500