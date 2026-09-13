Feature: Accès et vérification du Dashboard OrangeHRM

  Background:
    Given Aller sur la page de connexion OrangeHRM

  Scenario: Connexion réussie et affichage des widgets du dashboard
    When je saisis lidentifiant "Admin" et le mot de passe "admin123"
    Then je suis automatiquement dirige vers mon dashboard
    And je vois le cadran "My Actions"
    And je vois le cadran "Quick Launch"
