import React from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom'; // Importez BrowserRouter une seule fois

import Home from '././Pages';
import DashboardPage from '././pages';

function App() {
  return (
    <BrowserRouter>
      <div>
        <header>
          <h1>Plateforme de Gestion des Demandes et des Incidents</h1>
          {/* Ajoutez des éléments de navigation ou d'en-tête supplémentaires ici si nécessaire */}
        </header>
        <Switch>
          <Route path="/dashboard">
            <DashboardPage />
          </Route>
          <Route exact path="/">
            <Home />
          </Route>
        </Switch>
      </div>
    </BrowserRouter>
  );
}

export default App;
