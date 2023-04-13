import React, { useContext } from 'react'
import { ContextGlobal } from './utils/global.context';
import { MapContainer, TileLayer, useMap, Marker, Popup } from 'react-leaflet'
import 'leaflet/dist/leaflet.css';
import L from 'leaflet'
import style from '../styles/productMap.module.css'
import icon from 'leaflet/dist/images/marker-icon.png';
import iconShadow from 'leaflet/dist/images/marker-shadow.png';
const ProductMap = ({ position }) => {  
    
    let DefaultIcon = L.icon({
        iconUrl: icon,
        shadowUrl: iconShadow
    });
    
    L.Marker.prototype.options.icon = DefaultIcon;

    const { state: { CiudadPE, ProductoE} } = useContext(ContextGlobal);

        
    return (        
        <div className={style.productMapContainer}>
            <h2>¿Donde vas a estar?</h2>
            <hr />           
            <div>           
                <p>{CiudadPE.nombre}, {CiudadPE.pais}. </p>
                <MapContainer className={style.mapContainer} center={position} zoom={15} scrollWheelZoom={false}>
                    <TileLayer
                        url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
                    />
                    <Marker position={position} >
                        <Popup className={style.popup}>
                            {ProductoE.titulo} <br /> {CiudadPE.nombre}, {CiudadPE.pais}
                        </Popup>
                    </Marker>
                </MapContainer>
            </div>
        </div>
    )
}

export default ProductMap