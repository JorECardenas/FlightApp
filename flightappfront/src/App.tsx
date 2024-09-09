import './App.css';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import SearchComponent from './Components/SearchPage/SearchComponent';
import ResultsComponent from './Components/ResultsPage/ResultsComponent';
import axios from 'axios';
import DetailsComponent from './Components/DetailsPage/DetailsComponent';

const callAPILoader = async ({ request }:any) => {

  const url = "http://localhost:8080/getFlights"

  console.log("Calling API")

  let data = await request.url.searchParams();

  let depAirport = data.get("depAirport") as string
  let arrAirport = data.get("arrAirport") as string

  const regex = /\((.*)\)/



  const params2 = {
    DepAirport: depAirport.match(regex)?.pop(),
    ArrAirport: arrAirport.match(regex)?.pop(),
    DepDate: data.get("depDate"),
    ArrDate: data.get("arrDate"),
    NumAdults: data.get("numAdults"),
    Currency: data.get("currency"),
    NonStop: data.get("nonStop"),

  }

  console.log(params2)


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

const callAPI = async ({ request }:any) => {

  const url = "http://localhost:8080/getFlights"

  console.log("Calling API")

  let data = await request.formData();

  let depAirport = data.get("depAirport") as string
  let arrAirport = data.get("arrAirport") as string

  const regex = /\((.*)\)/



  const params2 = {
    DepAirport: depAirport.match(regex)?.pop(),
    ArrAirport: arrAirport.match(regex)?.pop(),
    DepDate: data.get("depDate"),
    ArrDate: data.get("arrDate"),
    NumAdults: data.get("numAdults"),
    Currency: data.get("currency"),
    NonStop: data.get("nonStop"),

  }

  console.log(params2)


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
    id: 'results',
    path: '/results',
    action: callAPI,
    element: <ResultsComponent />,

  },
  {
    path: '/details',
    element: <DetailsComponent />
  }
])

function App() {
  return (
    <RouterProvider router={router}/>
  );
}

export default App;
