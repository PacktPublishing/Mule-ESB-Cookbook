package com.org.drop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

public class FileToInputStream extends AbstractMessageTransformer {

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding)
			throws TransformerException {
		
		Map<String,String> payload = new HashMap<String,String>();
		
		payload = message.getPayload(payload.getClass());
		
		try {
			return new FileInputStream(new File( System.getProperty("user.dir") + "/src/main/resources/" + payload.get("inputFile")));
		} catch (FileNotFoundException e) {
			throw new TransformerException(null);
		}
		
	}

}
