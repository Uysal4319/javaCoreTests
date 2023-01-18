package fileOperations;

import javax.activation.FileDataSource;
import javax.xml.soap.AttachmentPart;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPMessage;
import java.util.Arrays;
import java.util.Iterator;

public class AttachmentPartTest {
	public static void main(String[] args) {
		try {
			String filePath = "src/main/resources/test.tiff";
			MessageFactory messageFactory = MessageFactory.newInstance();
			SOAPMessage message = messageFactory.createMessage();
			AttachmentPart attachment = message.createAttachmentPart();
			attachment.setContent(new FileDataSource(filePath), "application/pdf");
			message.addAttachmentPart(attachment);
			
			Iterator attachmentIterator = (Iterator) message.getAttachments();
			
			while (attachmentIterator.hasNext()) {
				
				AttachmentPart attachmentPart = (AttachmentPart) attachmentIterator.next();
				System.out.println(attachmentPart.getContentType());
				System.out.println(Arrays.toString(attachmentPart.getMimeHeader("Content-Type")));
				System.out.println(Arrays.toString(attachmentPart.getMimeHeader("Extension")));
				System.out.println("AttachmentPart Extension: " + attachmentPart.getContentId());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
