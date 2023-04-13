import React, {useState, useContext, useEffect } from 'react'
import { ContextGlobal } from './utils/global.context';
import style from "../styles/productLocation.module.css"
import { getStarsCalification, getWordCalification, toCenterOfCity} from './utils/usefulFunctions';

const ProductLocation = () => {

    const { state:{CiudadPE, ProductoE} } = useContext(ContextGlobal);
    const [latitude, setLatitude] = useState(null);
    const [longitude, setLongitude] = useState(null);
    const [city, setCity] = useState(null)
    const [meters, setMeters] = useState(0)

    useEffect(()=>{
        setLatitude(ProductoE?.latitud)
        setLongitude(ProductoE?.longitud)
        setCity(CiudadPE.nombre)
    },[ProductoE, CiudadPE])

    useEffect(()=>{
        setMeters(toCenterOfCity(latitude ?? 0, longitude ?? 0, city ?? ""))
    },[latitude, longitude])

  return (
    <div className={style.container}>
        <div className={style.locationDiv}>
            <i className="fa-solid fa-location-dot"></i>
            <div className={style.location}>
                <p>{CiudadPE?.nombre}, {CiudadPE?.provincia}, {CiudadPE?.pais}. </p>
                <p>{`A ${meters} mts del centro`}</p>
            </div>
        </div>
        <div className={style.calificationDiv}>
            <div className={style.starsDiv}>
                <p>{getWordCalification(ProductoE?.puntuacion)}</p>
                {getStarsCalification(ProductoE?.clasificacion)}
            </div>
            <p>{ProductoE?.puntuacion === undefined ? "" : ProductoE?.puntuacion * 2}</p>
        </div>
    </div>
  )
}

export default ProductLocation