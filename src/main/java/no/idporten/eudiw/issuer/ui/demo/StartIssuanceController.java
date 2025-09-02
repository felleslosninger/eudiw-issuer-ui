package no.idporten.eudiw.issuer.ui.demo;

import no.idporten.eudiw.issuer.ui.demo.issuer.IssuerServerService;
import no.idporten.eudiw.issuer.ui.demo.issuer.domain.IssuanceResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StartIssuanceController {

    Logger logger = LoggerFactory.getLogger(StartIssuanceController.class);

    private final IssuerServerService issuerServerService;

    @Autowired
    public StartIssuanceController(IssuerServerService issuerServerService) {
        this.issuerServerService = issuerServerService;
    }

    @GetMapping("/")
    public String start() {
        return "start";
    }

    @PostMapping("/start-issuance")
    public String startIssuance(Model model) {
        // TODO: legg med input og parse output (+modelview)
        IssuanceResponse response = issuerServerService.startIssuance();
        model.addAttribute("offer", response);
        logger.info("Issuer response: " + response);
        return "issuer_response";
    }


}
