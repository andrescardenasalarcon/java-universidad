import axios from 'axios';
import React, { useEffect, useState } from 'react';
import Empleado from '../model/Empleado';
import { NumericFormat } from 'react-number-format';
import { Link } from 'react-router-dom';
import EditarEmpleado from './EditarEmpleado';
//COMANDO DE FUNCIONES "rfc"
export default function ListadoEmpleados() {
  const URL = 'http://localhost:8080/rh-app/empleados';

  const [empleados, setEmpleados] = useState<Empleado[]>([]);

  useEffect(() => {
    cargarEmpleados();

    return () => {};
  }, []);

  const cargarEmpleados = async () => {
    const result = await axios.get(URL);
    console.log('Resultado de cargar empleados: ');
    console.log(result.data);
    setEmpleados(result.data);
  };

  const eliminarEmpleado = async (id:number) => {
    await axios.delete(`${URL}/${id}`);
    cargarEmpleados();
  }

  return (
    <div className='container'>
      <div
        className='container text-center'
        style={{ marginTop: '30px' }}
      >
        <h3>Sistema de Recursos Humanos</h3>

        <table className='table table-striped table-hover align-middle'>
          <thead className='table-dark'>
            <tr>
              <th scope='col'>ID</th>
              <th scope='col'>Empleado</th>
              <th scope='col'>Departamento</th>
              <th scope='col'>Sueldo</th>
              <th scope='col'></th>
            </tr>
          </thead>
          <tbody>
            {
              //Iteramos el arreglo de empleados
              empleados.map((empleado, indice) => (
                <tr>
                  <th
                    scope='row'
                    key={indice}
                  >
                    {empleado.idEmpleado}
                  </th>
                  <td>{empleado.nombre}</td>
                  <td>{empleado.departamento}</td>
                  {/* npm i react-number-format */}
                  <td>
                    <NumericFormat
                      value={empleado.sueldo}
                      displayType={'text'}
                      thousandSeparator=','
                      prefix={'$'}
                      decimalScale={2}
                      fixedDecimalScale
                    />
                  </td>
                  <td className='text-center'>
                    <div>
                      <Link to={`/editar/${empleado.idEmpleado}`} className='btn btn-warning btn-sm me-3'>Editar</Link>
                      <button onClick={() => eliminarEmpleado(empleado.idEmpleado)} className='btn btn-danger btn-sm me-3'>Eliminar</button>
                    </div>
                  </td>
                </tr>
              ))
            }
          </tbody>
        </table>
      </div>
    </div>
  );
}
