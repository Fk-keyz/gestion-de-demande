import React from 'react';

function Dashboard({ incidents }) {
  return (
    <div>
      <h2>Incidents en Attente</h2>
      <ul>
        {incidents.map((incident) => (
          <li key={incident.id}>
            <strong>Localisation:</strong> {incident.location} - <strong>Description:</strong> {incident.description}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default Dashboard;
