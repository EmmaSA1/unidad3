package utez.edu.mx.unidad3.moduls.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.unidad3.utils.APIResponse;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public APIResponse findAllClients() {
        List<Client> clients = clientRepository.findAll();
        return new APIResponse("Operación exitosa", clients, false, HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public APIResponse findById(Long id) {
        try {
            Client client = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
            return new APIResponse("Cliente encontrado", client, false, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new APIResponse(e.getMessage(), true, HttpStatus.NOT_FOUND);
        }
    }

    @Transactional(readOnly = true)
    public APIResponse save() {
        return null;
    }

    @Transactional(readOnly = true)
    public APIResponse update() {
        return null;
    }

    @Transactional(readOnly = true)
    public APIResponse remove() {
        return null;
    }

}
