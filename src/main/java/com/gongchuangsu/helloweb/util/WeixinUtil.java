package com.gongchuangsu.helloweb.util;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.gongchuangsu.helloweb.model.TextMessage;
import com.thoughtworks.xstream.XStream;

public class WeixinUtil {

	private static final String TOKEN = "isusu";
	
	public static final String MESSAGE_TEXT = "text";
	public static final String MESSAGE_IMAGE = "image";
	public static final String MESSAGE_VOICE = "voice";
	public static final String MESSAGE_VIDEO = "video";
	public static final String MESSAGE_LINK = "link";
	public static final String MESSAGE_LOCATION = "location";
	public static final String MESSAGE_EVENT = "event";
	public static final String MESSAGE_SUBSCRIBE = "subscribe";
	public static final String MESSAGE_UNSUBSRIBE = "unsubscribe";
	public static final String MESSAGE_CLICK = "CLICK";
	public static final String MESSAGE_VIEW = "VIEW";
	
	/**
	 * ����token����signature��֤�Ƿ�Ϊweixin����˷��͵���Ϣ
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	public static boolean checkSignature(
			String signature, String timestamp, String nonce){
		if(signature != null && timestamp != null && nonce != null){
			String[] arr = new String[]{TOKEN, timestamp, nonce};
			// ����/У������
			// ��һ������token��timestamp��nonce�������������ֵ�������
			Arrays.sort(arr);
			// �ڶ����������������ַ���ƴ�ӳ�һ���ַ�������sha1����
			StringBuffer key = new StringBuffer();
			for(int i = 0; i < arr.length; i++){
				key.append(arr[i]);
			}
			String pwd = getSha1(key.toString());
			// ����������signature�Աȣ���ʶ��������Դ��΢��
			return pwd.equals(signature);
		}else{
			return false;
		}
	}
	
	/**
	 * sha1�����㷨
	 * @param key ��Ҫ���ܵ��ַ���
	 * @return ���ܺ�Ľ��
	 */
	public static String getSha1(String key){
		try{
			MessageDigest md = MessageDigest.getInstance("SHA1");
			md.update(key.getBytes());
			String pwd = new BigInteger(1, md.digest()).toString(16);
			return pwd;
		}catch(Exception e){
			e.printStackTrace();
			return key;
		}
	}
	
	/**
	 * ����request�е� xml �������ݴ洢��һ��Map�з���
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 */
	public static Map<String, String> xmlToMap(HttpServletRequest request) 
			throws IOException, DocumentException{
		Map<String, String> map = new HashMap<String, String>();
		SAXReader reader = new SAXReader();
		InputStream ins = request.getInputStream();
		Document doc = reader.read(ins);
		Element root = doc.getRootElement();
		List<Element> list = root.elements();
		for(Element e : list){
			map.put(e.getName(), e.getText());			
		}
		ins.close();
		return map;
	}
	
	/**
	 * ���ı���Ϣ����ת��Ϊxml
	 * @param textMessage
	 * @return
	 */
	public static String textMessageToXml(TextMessage textMessage){
		XStream xstream = new XStream();
		xstream.alias("xml", textMessage.getClass());
		return xstream.toXML(textMessage);
	}
	
	public static String initText(String toUserName, String fromUserName, String content){
		TextMessage text = new TextMessage();
		text.setFromUserName(toUserName);
		text.setToUserName(fromUserName);
		text.setMsgType(MESSAGE_TEXT);
		text.setCreateTime(new Date().getTime());
		text.setContent(content);
		return textMessageToXml(text);
	}
}
