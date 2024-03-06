import React, { useState } from 'react';

function DemandForm({ onSubmit }) {
  const [demandData, setDemandData] = useState({
    // Initialisez ici les valeurs par défaut des champs du formulaire
    location: '',
    description: ''
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setDemandData({ ...demandData, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    onSubmit(demandData);
  };

  return (
    <form onSubmit={handleSubmit}>
      <div>
        <label htmlFor="location">Localisation :</label>
        <input
          type="text"
          id="location"
          name="location"
          value={demandData.location}
          onChange={handleChange}
        />
      </div>
      <div>
        <label htmlFor="description">Description :</label>
        <textarea
          id="description"
          name="description"
          value={demandData.description}
          onChange={handleChange}
        />
      </div>
      <button type="submit">Soumettre</button>
    </form>
  );
}

export default DemandForm;
