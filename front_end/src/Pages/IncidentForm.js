import React, { useState } from 'react';

function IncidentForm({ onReport }) {
  const [incidentData, setIncidentData] = useState({
    // Initialisez ici les valeurs par défaut des champs du formulaire
    location: '',
    description: ''
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setIncidentData({ ...incidentData, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    onReport(incidentData);
  };

  return (
    <form onSubmit={handleSubmit}>
      <div>
        <label htmlFor="location">Localisation :</label>
        <input
          type="text"
          id="location"
          name="location"
          value={incidentData.location}
          onChange={handleChange}
        />
      </div>
      <div>
        <label htmlFor="description">Description :</label>
        <textarea
          id="description"
          name="description"
          value={incidentData.description}
          onChange={handleChange}
        />
      </div>
      <button type="submit">Signaler</button>
    </form>
  );
}

export default IncidentForm;
