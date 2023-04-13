import style from '../../styles/productCard.module.css'
import L from "leaflet"

export const getWordCalification = (calification) => {
  switch (calification) {
    case 1:
      return "Regular";
    case 2:
      return "Decente";
    case 3:
      return "Bueno";
    case 4:
      return "Muy bueno";
    case 5:
      return "Excelente";
    default:
      break;
  }
};

export const getStarsCalification = (calification) => {
  switch (calification) {
    case 1:
      return (
        <span className={style.mainColorStar}>
          ★<span className={style.lightColorStar}>★★★★</span>
        </span>
      );
    case 2:
      return (
        <span className={style.mainColorStar}>
          ★★<span className={style.lightColorStar}>★★★</span>
        </span>
      );
    case 3:
      return (
        <span className={style.mainColorStar}>
          ★★★<span className={style.lightColorStar}>★★</span>
        </span>
      );
    case 4:
      return (
        <span className={style.mainColorStar}>
          ★★★★<span className={style.lightColorStar}>★</span>
        </span>
      );
    case 5:
      return <span className={style.mainColorStar}>★★★★★</span>;
    default:
      break;
  }
};


  /* ////////////// localStorageFuntions ////////////// */


export const getLocaStorageFavs = () => {
  const favs = localStorage.getItem("favs");
  return favs ? JSON.parse(favs) : [];
};

export const setLocalStorageFavs = (card) => {
  let favs = getLocaStorageFavs();
  const newFavs = favs.filter((fav) => {
    return fav.id === card.id;
  });

  if (newFavs.length === 0) {
    favs.push(card);
    localStorage.setItem("favs", JSON.stringify(favs));
  }
};

export const clearFromFavs = (id, name) => {
  let favs = getLocaStorageFavs();
  const index = favs.findIndex((fav) => fav.id === id);
  if (index !== -1) {
    favs.splice(index, 1);
    localStorage.setItem("favs", JSON.stringify(favs));
  }
};

export const isFav = (id) => {
  const favs = getLocaStorageFavs();
  const newFavs = favs.filter((fav) => {
    return fav.id === id;
  });
  return newFavs.length === 1;
};

export const toCenterOfCity = (latitude, longitude, city) => {

  let puntaDelEsteCenter = [-34.962264, -54.943699];
  let buenosAiresCenter = [-34.599695, -58.382076];
  let montevideoCenter = [-34.904190, -56.192949];
  let cordobaCenter = [-31.413787, -64.182712];
  let coloniaDelSacramentoCenter = [-34.468194, -57.842844];
  let barilocheCenter = [-41.134341, -71.301835];
  let puntaDelDiabloCenter = [-34.045386, -53.538688];
  let mendozaCenter = [-32.889457, -68.845917];
  let atlantidaCenter = [-34.773612, -55.762079];
  let marDelPlataCenter = [-37.999824, -57.546203];
  let piriapolisCenter = [-34.865872, -55.275568];
  let carlosPazCenter = [-31.421155, -64.498433];
  let caboPolonioCenter = [-34.402755, -53.781561];
  let iguazuCenter = [-25.596500, -54.575048];
  let joseIgnacioCenter = [-34.845050, -54.637317];
  let sanSalvadorDeJujuyCenter = [-24.185343, -65.303179];
  let minasCenter = [-34.375877, -55.239885];
  let ushuaiaCenter = [-54.806062, -68.310155];
  let saltoCenter = [-31.387376, -57.966735];
  let peritoMorenoCenter = [-46.591928, -70.929672];

  const theCity = cityOfCard => {

      switch(cityOfCard) {
        case "Punta del Este":
          return puntaDelEsteCenter;
        case "Buenos Aires":
          return buenosAiresCenter;
        case "Montevideo":
          return montevideoCenter;
        case "Córdoba":
          return cordobaCenter;
        case "Colonia del Sacramento":
          return coloniaDelSacramentoCenter;
        case "Bariloche":
          return barilocheCenter;
        case "Punta del Diablo":
          return puntaDelDiabloCenter;
        case "Mendoza":
          return mendozaCenter;
        case "Atlántida":
          return atlantidaCenter;
        case "Mar del Plata":
          return marDelPlataCenter;
        case "Piriápolis":
          return piriapolisCenter;
        case "Carlos Paz":
          return carlosPazCenter;
        case "Cabo Polonio":
          return caboPolonioCenter;
        case "Iguazú":
          return iguazuCenter;
        case "José Ignacio":
          return joseIgnacioCenter;
        case "San Salvador de Jujuy":
          return sanSalvadorDeJujuyCenter;
        case "Minas":
          return minasCenter;
        case "Ushuaia":
          return ushuaiaCenter;
        case "Salto":
          return saltoCenter;
        case "Perito Moreno":
          return peritoMorenoCenter;
        default:
          return [0, 0];
      }

  }

  const punto1 = L.latLng(latitude, longitude);
  const CenterCity = L.latLng(theCity(city));
  const distanceInMeters = Math.floor(punto1.distanceTo(CenterCity))
  return distanceInMeters;

}