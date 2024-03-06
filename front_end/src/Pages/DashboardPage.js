import React, { useEffect, useState } from 'react';
import Dashboard from '../components/Dashboard';
import ApiService from '../services/ApiService';

function DashboardPage() {
  const [incidents, setIncidents] = useState([]);

  useEffect(() => {
    // Chargez les incidents depuis l'API lorsque le composant est monté
    fetchIncidents();
  }, []);

  const fetchIncidents = () => {
    ApiService.getIncidents()
      .then((data) => {
        setIncidents(data);
      })
      .catch((error) => {
        console.error('Error fetching incidents:', error);
      });
  };

  return (
    <div>
      <h1>Tableau de Bord</h1>
      <Dashboard incidents={incidents} />
    </div>
  );
}

export default DashboardPage;
