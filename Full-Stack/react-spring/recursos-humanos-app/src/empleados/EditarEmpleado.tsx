import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

export default function EditarEmpleado() {
  const URL = 'http://localhost:8080/rh-app/empleados';

  let navegacion = useNavigate();

  const { id } = useParams();

  const [empleado, setEmpleado] = useState({
    nombre: '',
    departamento: '',
    sueldo: 0,
  });

  const { nombre, departamento, sueldo } = empleado;

  const cargarEmpleado = async () => {
    const result = await axios.get(`${URL}/${id}`);
    setEmpleado(result.data);
  };

  useEffect(() => {
    cargarEmpleado();

    return () => {};
  }, []);

  const onInputChanger = (e: any) => {
    //spread operator ... (expandir los atriburos de tipo empleado )
    setEmpleado({ ...empleado, [e.target.name]: e.target.value });
  };

  const onSubmit = async (e: any) => {
    e.preventDefault();
    await axios.put(`${URL}/${id}`, empleado);
    //Redirigimos a la pagina de inicio
    navegacion('/');
  };
  return (
    <div className='container'>
      <div
        className='container text-center'
        style={{ marginTop: '30px' }}
      >
        <h3>Editar Empleado</h3>
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
              className='btn btn-warning btn-sm me-3'
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
