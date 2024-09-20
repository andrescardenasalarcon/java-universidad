import { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

export default function AgregarEmpleado() {
  let navegacion = useNavigate();

  const [empleado, setEmpleado] = useState({
    nombre: '',
    departamento: '',
    sueldo: 0,
  });

  const { nombre, departamento, sueldo } = empleado;

  const onInputChanger = (e: any) => {
    //spread operator ... (expandir los atriburos de tipo empleado )
    setEmpleado({ ...empleado, [e.target.name]: e.target.value });
  };

  const onSubmit = async (e: any) => {
    e.preventDefault();
    const URL = 'http://localhost:8080/rh-app/empleados';
    await axios.post(URL, empleado);
    //Redirigimos a la pagina de inicio
    navegacion('/');
  };

  return (
    <div className='container'>
      <div
        className='container text-center'
        style={{ marginTop: '30px' }}
      >
        <h3>Agregar Empleado</h3>
        <form
          onSubmit={(e) => onSubmit(e)}
          method='post'
        >
          <div className='mb-3'>
            <label
              htmlFor='nombre'
              className='form-label'
            >
              Nombre
            </label>
            <input
              type='text'
              className='form-control'
              id='nombre'
              name='nombre'
              value={nombre}
              onChange={(e) => onInputChanger(e)}
              required
            />
          </div>
          <div className='mb-3'>
            <label
              htmlFor='departamento'
              className='form-label'
            >
              Departamento
            </label>
            <input
              type='text'
              className='form-control'
              id='departamento'
              name='departamento'
              value={departamento}
              onChange={(e) => onInputChanger(e)}
              required
            />
          </div>
          <div className='mb-3'>
            <label
              htmlFor='sueldo'
              className='form-label'
            >
              Sueldo
            </label>
            <input
              type='number'
              step='any'
              className='form-control'
              id='sueldo'
              name='sueldo'
              value={sueldo}
              onChange={(e) => onInputChanger(e)}
              required
            />
          </div>
          <div className='text-center'>
            <button
              type='submit'
              className='btn btn-success btn-sm me-3'
            >
              Agregar
            </button>
            <a
              href='/'
              className='btn btn-danger btn-sm'
            >
              Cancelar
            </a>
          </div>
        </form>
      </div>
    </div>
  );
}
