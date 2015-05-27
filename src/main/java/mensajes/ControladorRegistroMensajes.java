package mensajes;

import com.google.android.gcm.server.Sender;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;

/**
 * Created by campitos on 5/26/15.
 */

@Service
@Transactional
@Controller
public class ControladorRegistroMensajes {
@Inject
private ServicioRegistro servicioRegistro;
    private Sender sender;

    @RequestMapping(value="/registro-mensajes", method = RequestMethod.POST, headers={"Accept=text/html"})
    @ResponseBody public String registrarCelular(@RequestParam("registroId") String registroId ){
      String resultado="nada";
        RegistroMensajeria registroMensajeria= new RegistroMensajeria(registroId);
        servicioRegistro.agregarRegistro(registroMensajeria);
        return "registrado con exito";
    }
}
