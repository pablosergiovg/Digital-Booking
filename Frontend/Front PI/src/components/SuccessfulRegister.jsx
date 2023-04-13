import React from 'react'
import style from "../styles/successfulBooking.module.css"
import { Link } from 'react-router-dom'

const SuccessfulRegister = () => {


  return (
    <div className={style.container}>
      <div className={style.cardDiv}>
        <i className="fa-solid fa-circle-check"></i>
        <p className={style.p1}>¡Muchas gracias!</p>
        <p className={style.p2}>Su registro se ha completado con éxito</p>
        <Link to={"/iniciar-sesion"}>
          <button>Iniciar Sesión</button>
        </Link>
      </div>
    </div>
  )
}

export default SuccessfulRegister