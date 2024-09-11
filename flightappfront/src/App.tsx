import './App.css';
import { createBrowserRouter, json, RouterProvider } from 'react-router-dom';
import SearchComponent from './Components/SearchPage/SearchComponent';
import ResultsComponent from './Components/ResultsPage/ResultsComponent';
import axios from 'axios';
import DetailsComponent from './Components/DetailsPage/DetailsComponent';
import ErrorComponent from './Components/ErrorComponent';
import { LoaderData, SearchComponentData } from './Models/SearchModel';

const callAPILoader = async ({ request }: any) => {

  const url = "http://localhost:8080/getFlights"

  console.log("Calling API")

  let searchUrl = new URL(request.url)


  let depAirport = searchUrl.searchParams.get("depAirport") as string
  let arrAirport = searchUrl.searchParams.get("arrAirport") as string

  const regex = /\((.*)\)/

  const params2 = {
    DepAirport: depAirport.match(regex)?.pop(),
    ArrAirport: arrAirport.match(regex)?.pop(),
    DepDate: searchUrl.searchParams.get("depDate"),
    ArrDate: searchUrl.searchParams.get("arrDate"),
    NumAdults: searchUrl.searchParams.get("numAdults"),
    Currency: searchUrl.searchParams.get("currency"),
    NonStop: searchUrl.searchParams.get("nonStop"),

  }

  const SearchData:SearchComponentData = {
    DepAirport: depAirport,
    ArrAirport: arrAirport,
    DepDate: searchUrl.searchParams.get("depDate"),
    ArrDate: searchUrl.searchParams.get("arrDate"),
    NumAdults: searchUrl.searchParams.get("numAdults"),
  }


  let res = await axios({
    method: 'get',
    url: url,
    params: params2
  })
    .then((response) => {
      
      const res:LoaderData = { data: response.data, search: SearchData }
      console.log("Got data", res)

      return res;
    }).catch((e) => {


      throw json({error: e})
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
    id: "results",
    path: '/results',
    loader: callAPILoader,
    shouldRevalidate: (req) => {
      return req.currentUrl.pathname === "" || req.currentUrl.search === req.nextUrl.search
    },
    errorElement: <ErrorComponent />,
    children: [
      {
        index: true,
        element: <ResultsComponent />
      },
      {
        path: "details",
        element: <DetailsComponent />
      }
    ]
  }
])

function App() {
  return (
    <RouterProvider router={router} />
  );
}

export default App;
