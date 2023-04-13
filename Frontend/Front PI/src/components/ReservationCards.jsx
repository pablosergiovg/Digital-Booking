import React, {useState} from 'react'
import style from "../styles/reservationCards.module.css"
import { useEffect } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const ReservationCards = ({reservationData, setUser}) => {

    const user = JSON.parse(localStorage.getItem("user"));
    const [product, setProduct] = useState()
    const {id, fechaInicial, fechaFinal, horaInicio, productoId} = reservationData;

    const reservationDelete = () => {
        axios.delete(`http://3.141.200.56:8080/api/reservas/${id}`)
        .then(res => {
            const reservations = user.reservas;
            const newRes = reservations.filter(rese => rese.id !== id)
            user.reservas = newRes;
            localStorage.setItem("user", JSON.stringify(user))
            setUser(user)
        }).catch(error => "error: " + error)
    }

    const navigate = useNavigate();

    const goProduct = (id) => {
        console.log(id);
        navigate(`/producto/${id}`)
    }

    const getProductData = (productId) => {
        axios.get(`http://3.141.200.56:8080/api/productos/${productId}`)
        .then(res => {
            setProduct(res.data)
        })
    }

    useEffect(()=>{
        getProductData(productoId)
    },[productoId])

  return (
     <div className={style.container}>
        <div className={style.divProductInfo}>
            <img src={product?.imagenes[0].urlImagen} alt={product?.titulo} />
            <div className={style.productInfo}>
                <div className={style.headerProduct}>
                    <p>{product?.categoria.titulo}</p>
                    <h2>{product?.titulo}</h2>
                </div>
                <button onClick={() => goProduct(productoId)}>ver producto</button>
            </div>
        </div>
        <div className={style.divReservation}>
            <div className={style.titleTrash}>
                <h3>Reserva:</h3>
                <i onClick={reservationDelete} className="fa-solid fa-trash-can"></i>
            </div>
            <div className={style.reservation}>
                <div className={style.userInfo}>
                    <p>Nombre: {user.nombre}</p>
                    <p>Apellido: {user.apellido}</p>
                    <p>Código de reserva: {id}</p>
                </div>
                <div className={style.checkInfo}>
                    <p>Check in: {fechaInicial}</p>
                    <p>Check out: {fechaFinal}</p>
                    <p>Hora de llegada: {horaInicio}</p>
                </div>
            </div>
        </div>
    </div>
  )
}

export default ReservationCards