import React from 'react';
import Form from './Components/Form';
import List from './Components/List';
import { StoreProvider } from './Components/Store';

//Se separo Form a un nuevo componente

//Se separo List a un nuevo componente

//Se separo StoreProvider a un nuevo componente

function App() {
  return <StoreProvider>
    <h3>To-Do List</h3>
    <Form />
    <List />
  </StoreProvider>
}

export default App;
