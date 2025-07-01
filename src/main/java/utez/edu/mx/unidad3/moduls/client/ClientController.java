package utez.edu.mx.unidad3.moduls.client;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utez.edu.mx.unidad3.utils.APIResponse;

@RestController
@RequestMapping("/api/clients")
@Tag(name = "Controlador de clientes", description = "Operaciones relacionadas con los clientes")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    @Operation(summary = "Traer clientes", description = "Obtiene una lista de todos los clientes registrados")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Lista de clientes obtenida exitosamente",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class)),
                            @Content(mediaType = "application/xml", schema = @Schema(implementation = APIResponse.class)),
                            @Content(mediaType = "application/html", schema = @Schema(implementation = APIResponse.class))
                    }
            )
    })
    public ResponseEntity<APIResponse> findAllClients() {
        APIResponse response = clientService.findAllClients();
        return new ResponseEntity<>(response, response.getStatus());
    }

}
