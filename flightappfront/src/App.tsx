import React from 'react';
import logo from './logo.svg';
import './App.css';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import SearchComponent from './Components/SearchPage/SearchComponent';


const router = createBrowserRouter([
  {
    path:'/',
    element:<SearchComponent/>
  }
])

function App() {
  return (
    <RouterProvider router={router}/>
  );
}

export default App;
