import './App.css';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import SearchComponent from './Components/SearchPage/SearchComponent';
import ResultsComponent from './Components/ResultsPage/ResultsComponent';
import axios from 'axios';
import DetailsComponent from './Components/DetailsPage/DetailsComponent';


const callAPI = async ({ request }:any) => {

  const url = "http://localhost:8080/getFlights"

  console.log("Calling API")

  let data = await request.formData();

  const params2 = {
    DepAirport: data.get("depAirport"),
    ArrAirport: data.get("arrAirport"),
    DepDate: data.get("depDate"),
    ArrDate: data.get("arrDate"),
    NumAdults: data.get("numAdults"),
    Currency: data.get("currency"),
    NonStop: data.get("nonStop"),

  }



  let res = await axios({
      method: 'get',
      url: url,
      params: params2
    })
    .then((response) => {
      console.log("Got data", response)
      return response.data;
    }).catch((e) => {
      return e;
    })

    console.log("Still here", res)

    return res;
}


const router = createBrowserRouter([
  {
    path: '/',
    element: <SearchComponent />
  },
  {
    path: '/results',
    action: callAPI,
    element: <ResultsComponent />,
    children: [
      {
        path:"/details/:id",
        element: <DetailsComponent/>
      }
    ]
  }
])

function App() {
  return (
    <RouterProvider router={router}/>
  );
}

export default App;
