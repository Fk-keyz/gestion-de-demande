class ApiService {
    baseUrl = 'http://localhost:8000/api'; // URL de base de l'API
  
    // Méthode pour soumettre une demande
    submitDemand(demandData) {
      return fetch(`${this.baseUrl}/demands`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(demandData)
      }).then((response) => response.json());
    }
  
    // Méthode pour signaler un incident
    reportIncident(incidentData) {
      return fetch(`${this.baseUrl}/incidents`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(incidentData)
      }).then((response) => response.json());
    }
  
    // Méthode pour récupérer la liste des incidents
    getIncidents() {
      return fetch(`${this.baseUrl}/incidents`)
        .then((response) => response.json())
        .then((data) => data.incidents);
    }
  }
  
  export default new ApiService();
  