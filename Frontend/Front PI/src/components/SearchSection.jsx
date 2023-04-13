import React, { useContext, useState } from 'react'
import InputSelect from './InputSelect.jsx'
import InputDate from './InputDate.jsx'
import style from "../styles/searchSection.module.css";
import { ContextGlobal } from './utils/global.context.jsx';
import axios from 'axios';

const SearchSection = () => {
  
  const {state:{SelectedCity, SelectedDateRange}, dispatch} = useContext(ContextGlobal)

  const [dateRange, setDateRange] = useState(["", ""])

  const [idCity, setIdCity] = useState()

  const renderRecomendations = (productos) => {    
    dispatch({type: "PRODUCTOSF", payload: productos})
  }

const reservedDates = () =>{
    axios.get(`${url}reservas/producto/${id}`)
    .then (res =>{
      dispatch ({type: "RESERVAS", payload: res.data })
    })
    .catch(error => console.error("Error", error))
  } 


  const handleDatePicker = (range) => {
    range = range.map(date => new Date(date).toISOString().split('T')[0])
    setDateRange(range)    
    dispatch({type: "SELECTEDDATERANGE", payload: range})    
  }

  const handleSubmit = (e) => {
    e.preventDefault()    
    axios.get(`http://3.141.200.56:8080/api/productos/fechaCiudad?fechaInicio=${dateRange[0]}&fechaFinal=${dateRange[1]}&idCiudad=${idCity}`)
    .then(res => renderRecomendations(res.data))    
  }  
  
  return (
    <div className={style.searchSectionContainer}>
        <p className={style.searchTitle}>Busca ofertas en hoteles, casas y mucho más</p>
        <form onSubmit={handleSubmit}  className={style.filtersContainer}>
            <InputSelect getIdCity = {setIdCity}/>
            <InputDate handleDate={handleDatePicker}/>
            <button className={style.button} type="submit">Buscar</button>
        </form>
    </div>
  )
}

export default SearchSection