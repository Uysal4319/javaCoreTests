package effectiveJava.memoryManagement.springApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QrCodeController {
	@GetMapping("/qrcode")
	public String getQRCode() {
		return QrCodeGenerator.generateCode();
	}
}
