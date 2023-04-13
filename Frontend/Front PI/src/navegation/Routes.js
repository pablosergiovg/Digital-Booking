import Home from '../routes/Home'
import Product from '../routes/Product'
import Booking from '../routes/Booking'
import Register from '../routes/Register'
import SignIn from '../routes/SignIn'
import ErrorComponent from '../routes/ErrorComponent'
import Administration from '../routes/Administration'
import UserBooking from '../routes/UserBooking'
import Favs from '../routes/Favs'
import SuccessfulRegister from '../components/SuccessfulRegister'

export const routes = [
    { id: 1, path: "/", Element: Home, title: "Home" },
    { id: 2, path: "/producto/:id", Element: Product, title: "producto"},
    { id: 3, path: "/producto/:id/reserva", Element: Booking, title: "reserva"},
    { id: 4, path: "/usuario/:email/reserva", Element: UserBooking, title: "reserva-usuario"},
    { id: 5, path: "/usuario/:email/favoritos", Element: Favs, title: "favoritos"},
    { id: 6, path: "/crear-cuenta", Element: Register, title: "crear-cuenta" },
    { id: 7, path: "/registro-exitoso", Element: SuccessfulRegister, title: "registro-exitoso" },
    { id: 8, path: "/iniciar-sesion", Element: SignIn, title: "iniciar-sesion" },
    { id: 9, path: "/administracion/nuevo-producto", Element: Administration, title: "administracion" },
    { id: 10, path: "*", Element: ErrorComponent, title: "Error" },
]
