class AuthService {
    baseUrl = 'http://localhost:8000/auth'; // URL de base de l'API d'authentification
  
    // Méthode pour authentifier l'utilisateur
    login(credentials) {
      return fetch(`${this.baseUrl}/login`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(credentials)
      }).then((response) => response.json());
    }
  
    // Méthode pour déconnecter l'utilisateur
    logout() {
      // Logique pour déconnecter l'utilisateur, par exemple effacer les cookies ou supprimer le token JWT
    }
  }
  
  export default new AuthService();
  