package co.afca.tareas.service;

import co.afca.tareas.model.Tarea;
import co.afca.tareas.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService implements ITareaService {

    @Autowired
    private TareaRepository tareaRepository;

    @Override
    public List<Tarea> listarTareas() {
        return this.tareaRepository.findAll();
    }

    @Override
    public Tarea buscarTareaPorId(Integer idTarea) {
        Tarea tarea = this.tareaRepository.findById(idTarea).orElse(null);
        return tarea;
    }

    @Override
    public void guardarTarea(Tarea tarea) {
        tareaRepository.save(tarea);
    }

    @Override
    public void eliminarTarea(Tarea tarea) {
        tareaRepository.delete(tarea);
    }
}
