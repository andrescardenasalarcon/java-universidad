import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import ListadoEmpleados from './empleados/ListadoEmpleados';
import Navegacion from './plantilla/Navegacion';
import AgregarEmpleado from './empleados/AgregarEmpleado';
import EditarEmpleado from './empleados/EditarEmpleado';

//INSTALL LIB OF ROUTES --> npm i react-router-dom
function App() {
  return (
    <>
      <div className='container'>
        <BrowserRouter>
          <Navegacion />
            <Routes>
              <Route  path='/' element={<ListadoEmpleados/>}/>
              <Route path='/agregar' element={<AgregarEmpleado/>} />
              <Route path='/editar/:id' element={<EditarEmpleado/>} />
            </Routes>
        </BrowserRouter>
      </div>
    </>
  );
}

export default App;
