import React, { useState } from 'react';
import DemandForm from '../components/DemandForm';
import IncidentForm from '../components/IncidentForm';
import ApiService from '../services/ApiService';

function Home() {
  const [demandSubmitted, setDemandSubmitted] = useState(false);
  const [incidentReported, setIncidentReported] = useState(false);

  const handleDemandSubmit = (demandData) => {
    ApiService.submitDemand(demandData)
      .then(() => {
        setDemandSubmitted(true);
      })
      .catch((error) => {
        console.error('Error submitting demand:', error);
      });
  };

  const handleIncidentReport = (incidentData) => {
    ApiService.reportIncident(incidentData)
      .then(() => {
        setIncidentReported(true);
      })
      .catch((error) => {
        console.error('Error reporting incident:', error);
      });
  };

  return (
    <div>
      <h1>Plateforme de Gestion des Demandes et des Incidents</h1>
      <h2>Soumettre une Demande</h2>
      {demandSubmitted ? (
        <p>Votre demande a été soumise avec succès !</p>
      ) : (
        <DemandForm onSubmit={handleDemandSubmit} />
      )}
      <h2>Signaler un Incident</h2>
      {incidentReported ? (
        <p>L'incident a été signalé avec succès !</p>
      ) : (
        <IncidentForm onReport={handleIncidentReport} />
      )}
    </div>
  );
}

export default Home;
